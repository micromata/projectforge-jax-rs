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

import org.projectforge.rest.objects.ConnectionSettingsObject;

/**
 * Serialization and deserialization for rest calls.
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class ConnectionSettings
{
  private static final org.projectforge.common.Logger log = org.projectforge.common.Logger.getLogger(ConnectionSettings.class);

  /**
   * settings.dateTimeFormat
   */
  public static final String DATE_TIME_FORMAT = "settings.dateTimeFormat";

  public final static ConnectionSettingsObject get()
  {
    ConnectionSettingsObject settings = context.get();
    if (settings == null) {
      settings = new ConnectionSettingsObject();
    }
    return settings;
  }

  public final static void set(final ConnectionSettingsObject settings)
  {
    if (log.isDebugEnabled() == true) {
      log.debug("set connection settings: " + settings);
    }
    context.set(settings);
  }

  private static ThreadLocal<ConnectionSettingsObject> context = new ThreadLocal<ConnectionSettingsObject>();

}
