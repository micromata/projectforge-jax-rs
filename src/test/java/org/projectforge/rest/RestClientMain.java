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

import javax.ws.rs.core.MediaType;

import org.projectforge.ProjectForgeVersion;
import org.projectforge.rest.objects.ServerInfo;
import org.projectforge.rest.objects.UserObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClientMain
{
  private static final org.projectforge.common.Logger log = org.projectforge.common.Logger.getLogger(RestClientMain.class);

  public static final String URL = "http://localhost:8080/ProjectForge/rest";

  public static void main(final String[] args)
  {
    final Client client = Client.create();
    UserObject user = authenticate(client);
    initialContact(client, user.getId(), user.getAuthenticationToken());
  }

  public static UserObject authenticate(Client client)
  {
    return authenticate(client, "demo", "demo123");
  }

  /**
   * @return authentication token for further rest calls.
   */
  public static UserObject authenticate(Client client, String username, String password)
  {
    // http://localhost:8080/ProjectForge/rest/authenticate/getToken // username / password
    WebResource webResource = client.resource(URL + "/authenticate/getToken");
    ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).header(Authentication.AUTHENTICATION_USERNAME, username)
        .header(Authentication.AUTHENTICATION_PASSWORD, password).get(ClientResponse.class);
    if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }
    String json = response.getEntity(String.class);
    log.info(json);
    final UserObject user = JsonUtils.fromJson(json, UserObject.class);
    if (user == null) {
      throw new RuntimeException("Can't deserialize user : " + json);
    }
    final Integer userId = user.getId();
    final String authenticationToken = user.getAuthenticationToken();
    log.info("userId = " + userId + ", authenticationToken=" + authenticationToken);
    return user;
  }

  public static void initialContact(Client client, Integer userId, String authenticationToken)
  {
    // http://localhost:8080/ProjectForge/rest/authenticate/initialContact?clientVersion=5.0 // userId / token
    WebResource webResource = client.resource(URL + "/authenticate/initialContact");
    ClientResponse response = webResource.queryParam("clientVersion", ProjectForgeVersion.VERSION_STRING)
        .accept(MediaType.APPLICATION_JSON).header(Authentication.AUTHENTICATION_USER_ID, userId.toString())
        .header(Authentication.AUTHENTICATION_TOKEN, authenticationToken).get(ClientResponse.class);
    if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }
    String json = response.getEntity(String.class);
    log.info(json);
    final ServerInfo serverInfo = JsonUtils.fromJson(json, ServerInfo.class);
    if (serverInfo == null) {
      throw new RuntimeException("Can't deserialize serverInfo : " + json);
    }
    log.info("serverInfo=" + serverInfo);
  }
}
