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

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.projectforge.rest.AbstractBaseObject;

/**
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class CalendarEventObject extends AbstractBaseObject
{
  private Integer calendarId;

  private Date startDate;

  private Date endDate;

  private String uid;

  private String subject;

  private String location;

  private String note;

  public Integer getCalendarId()
  {
    return calendarId;
  }

  public CalendarEventObject setCalendarId(final Integer calendarId)
  {
    this.calendarId = calendarId;
    return this;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public CalendarEventObject setStartDate(final Date startDate)
  {
    this.startDate = startDate;
    return this;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public CalendarEventObject setEndDate(final Date endDate)
  {
    this.endDate = endDate;
    return this;
  }

  public String getUid()
  {
    return uid;
  }

  public CalendarEventObject setUid(final String uid)
  {
    this.uid = uid;
    return this;
  }

  public String getSubject()
  {
    return subject;
  }

  public CalendarEventObject setSubject(final String subject)
  {
    this.subject = subject;
    return this;
  }

  public String getLocation()
  {
    return location;
  }

  public CalendarEventObject setLocation(final String location)
  {
    this.location = location;
    return this;
  }

  public String getNote()
  {
    return note;
  }

  public CalendarEventObject setNote(final String note)
  {
    this.note = note;
    return this;
  }

  @Override
  public String toString()
  {
    return new ReflectionToStringBuilder(this) {
      @Override
      protected boolean accept(final Field f)
      {
        return super.accept(f);
      }
    }.toString();
  }
}
