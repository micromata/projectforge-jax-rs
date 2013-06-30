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

package org.projectforge.rest.objects;

import java.util.Locale;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.projectforge.rest.converter.DateTimeFormat;

/**
 * This object is used for configuring the current request.
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class ConnectionSettingsObject
{
  private static final DateTimeFormat DEFAULT_DATE_TIME_FORMAT = DateTimeFormat.ISO_DATE_TIME_MILLIS;

  private DateTimeFormat dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;

  private Locale locale = Locale.US;

  /**
   * @return the dateTimeFormat
   */
  public DateTimeFormat getDateTimeFormat()
  {
    return dateTimeFormat;
  }

  /**
   * @param dateTimeFormat the dateTimeFormat to set
   * @return this for chaining.
   */
  public ConnectionSettingsObject setDateTimeFormat(final DateTimeFormat dateTimeFormat)
  {
    if (dateTimeFormat == null) {
      this.dateTimeFormat = DateTimeFormat.ISO_DATE_TIME_MILLIS;
    } else {
      this.dateTimeFormat = dateTimeFormat;
    }
    return this;
  }

  public boolean isDefaultDateTimeFormat()
  {
    return dateTimeFormat == DEFAULT_DATE_TIME_FORMAT;
  }

  /**
   * @return the locale
   */
  public Locale getLocale()
  {
    return locale;
  }

  /**
   * @param locale the locale to set
   * @return this for chaining.
   */
  public ConnectionSettingsObject setLocale(final Locale locale)
  {
    if (locale == null) {
      this.locale = Locale.getDefault();
    }
    this.locale = locale;
    return this;
  }

  @Override
  public String toString()
  {
    return new ReflectionToStringBuilder(this).toString();
  }
}
