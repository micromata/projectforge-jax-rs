/////////////////////////////////////////////////////////////////////////////
//
// Project ProjectForge Community Edition
//         www.projectforge.org
//
// Copyright (C) 2001-2013 Kai Reinhard (k.reinhard@micromata.de)
//
// ProjectForge is dual-licensed.
//
// This community edition is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License as published
// by the Free Software Foundation; version 3 of the License.
//
// This community edition is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
// Public License for more details.
//
// You should have received a copy of the GNU General Public License along
// with this program; if not, see http://www.gnu.org/licenses/.
//
/////////////////////////////////////////////////////////////////////////////

package org.projectforge.rest;

import java.util.Collection;

import org.projectforge.rest.objects.TaskObject;
import org.projectforge.rest.objects.UserObject;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TaskDaoClientMain
{
  private static final org.projectforge.common.Logger log = org.projectforge.common.Logger.getLogger(TaskDaoClientMain.class);

  public static void main(final String[] args)
  {
    final Client client = Client.create();
    UserObject user = RestClientMain.authenticate(client);

    // http://localhost:8080/ProjectForge/rest/task/tree // userId / token
    WebResource webResource = client.resource(RestClientMain.URL + RestPaths.buildTreePath(RestPaths.TASK)).queryParam("search", "");
    ClientResponse response = RestClientMain.getClientResponse(webResource, user);
    if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }
    String json = response.getEntity(String.class);
    log.info(json);
    final Collection<TaskObject> col = JsonUtils.fromJson(json, new TypeToken<Collection<TaskObject>>() {
    }.getType());
    for (final TaskObject task : col) {
      logTask(task, "");
    }
  }

  private static void logTask(final TaskObject task, final String indent)
  {
    log.info(indent + task.getTitle());
    final Collection<TaskObject> children = task.getChildren();
    if (children == null || children.size() == 0) {
      return;
    }
    for (final TaskObject child : children) {
      logTask(child, indent + "  ");
    }
  }
}
