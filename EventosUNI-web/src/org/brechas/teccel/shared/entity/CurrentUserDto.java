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

package org.brechas.teccel.shared.entity;


import com.googlecode.objectify.annotation.Entity;

@Entity
public class CurrentUserDto implements Dto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean isAdmin;
	private Boolean isPublisher;
	private Boolean isGuest;
	private String email;
	private String logoutUrl;
	private String loginUrl;
	private String nickname;
	private String universidad;
	private String facultad;

	public CurrentUserDto() {
	}

	public Boolean isAdmin() {
		return isAdmin;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void copyFrom(CurrentUserDto currentUser) {
		isAdmin = currentUser.isAdmin;
		isPublisher = currentUser.isPublisher;
		isGuest = currentUser.isGuest;
		email = currentUser.email;
		logoutUrl = currentUser.logoutUrl;
		loginUrl = currentUser.loginUrl;
		nickname = currentUser.nickname;
		universidad = currentUser.universidad;
		facultad = currentUser.facultad;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public Boolean isPublisher() {
		return isPublisher;
	}

	public void setIsPublisher(Boolean isPublisher) {
		this.isPublisher = isPublisher;
	}

	public Boolean isGuest() {
		return isGuest;
	}

	public void setIsGuest(Boolean isGuest) {
		this.isGuest = isGuest;
	}

}
