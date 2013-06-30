/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.brechas.teccel.server.beans;

import java.util.EnumSet;
import java.util.Set;

import org.brechas.teccel.server.entity.BaseEntity;
import org.brechas.teccel.server.entity.Role;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class User extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Index
    private String googleId;

    private Set<Role> roles;

    public User() {
        googleId = "";
        roles=EnumSet.of(Role.GUEST);
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
