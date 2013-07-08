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

package org.brechas.teccel.server.entity;

import java.util.UUID;

import org.brechas.teccel.shared.entity.CurrentUserDto;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

@Entity
public class CurrentUser extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean isAdmin;
	private Boolean isPublisher;
	private Boolean isGuest;
	private Boolean isLoggedin;
	private String userId;
	@Index
	private String email;
	@Ignore
	private String logoutUrl;
	@Ignore
	private String loginUrl;
	private String nickname;
	private String universidad;
	private String facultad;

	public CurrentUser() {
		isAdmin = false;
		isPublisher = false;
		isGuest = false;
		email = "---";
		loginUrl = "---";
		logoutUrl = "---";
		nickname = "---";
		universidad = "---";
		facultad = "---";
		start();
		set_kindName("CurrentUser");
	}

	public CurrentUserDto getDto() {
		CurrentUserDto dto = new CurrentUserDto();
		dto.setIsAdmin(isAdmin);
		dto.setIsPublisher(isPublisher);
		dto.setIsGuest(isGuest);
		dto.setEmail(email);
		dto.setLogoutUrl(logoutUrl);
		dto.setLoginUrl(loginUrl);
		dto.setNickname(nickname);
		dto.setUniversidad(universidad);
		dto.setFacultad(facultad);
		return dto;
	}

	public void setDto(CurrentUserDto dto) {
		isAdmin = dto.isAdmin();
		isPublisher = dto.isPublisher();
		isGuest = dto.isGuest();
		email = dto.getEmail();
		logoutUrl = dto.getLogoutUrl();
		loginUrl = dto.getLoginUrl();
		nickname = dto.getNickname();
		universidad = dto.getUniversidad();
		facultad = dto.getFacultad();
		id = dto.getEmail();
		userId = "USER: " + UUID.randomUUID().toString();
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

	public void copyFrom(CurrentUser currentUser) {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean isLoggedin() {
		return isLoggedin;
	}

	public void setIsLoggedin(Boolean isLoggedin) {
		this.isLoggedin = isLoggedin;
	}
}
