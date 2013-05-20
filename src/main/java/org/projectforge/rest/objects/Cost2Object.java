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

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.projectforge.rest.AbstractBaseObject;

/**
 * REST object cost2. See {@link Kost2DO} for detail information about the fields.
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class Cost2Object extends AbstractBaseObject
{
  private String number;

  private String type;

  private String project;

  private String customer;

  public Cost2Object()
  {
  }

  public String getNumber()
  {
    return number;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getProject()
  {
    return project;
  }

  public void setProject(String project)
  {
    this.project = project;
  }

  public String getCustomer()
  {
    return customer;
  }

  public void setCustomer(String customer)
  {
    this.customer = customer;
  }

  @Override
  public String toString()
  {
    return new ReflectionToStringBuilder(this) {
      protected boolean accept(Field f)
      {
        return super.accept(f) && !f.getName().equals("authenticationToken");
      }
    }.toString();
  }
}
