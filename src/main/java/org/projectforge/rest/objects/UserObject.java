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

import org.projectforge.rest.AbstractBaseObject;




/**
 * REST object user. See {@link PFUserDO} for detail information about the fields.
 * @see PFUserDO
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class UserObject extends AbstractBaseObject
{
  private String username, firstName, lastName, email;

  private String authenticationToken;

  public UserObject()
  {
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(final String username)
  {
    this.username = username;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(final String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(final String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(final String email)
  {
    this.email = email;
  }

  public String getAuthenticationToken()
  {
    return authenticationToken;
  }

  public void setAuthenticationToken(final String authenticationToken)
  {
    this.authenticationToken = authenticationToken;
  }
}
