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

import java.util.Date;

import org.brechas.teccel.server.beans.EntityDto;
import org.brechas.teccel.shared.entity.Dto;

import com.google.inject.Inject;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;

public abstract class BaseEntity implements Dto {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5168519386812761312L;
	@Id
    protected String id;
	
	private Date _createdAt;

	private Date _updatedAt;

	private String _createdBy;

	private String _updatedBy;

	private String _kindName;

	//private Map<String, Object> properties = new HashMap<String, Object>();

	private String _owner;

    protected BaseEntity() {
    }

    public void start(){
    	set_createdAt(new Date());
		set_updatedAt(new Date());
    }
    public void up(CurrentUser user){
		set_createdBy(user.getEmail());
		set_owner(user.getUserId());
		set_updatedBy(user.getEmail());
    }
    
    public BaseEntity(String _kindName) {
        if (_kindName == null || !_kindName.matches("\\w+")) {
          throw new IllegalArgumentException("Illegal kind name: " + _kindName);
        }
        this._kindName = _kindName;
      }
    
    public void createBaseEntityFromEntityDto(EntityDto cd) {
    	_kindName =cd.getKindName(); 
        id = cd.getId();
        _createdAt = new Date(cd.getCreatedAt().getTime());
        _updatedAt = new Date(cd.getUpdatedAt().getTime());
        _createdBy = cd.getCreatedBy();
        _updatedBy = cd.getUpdatedBy();
        _kindName = cd.getKindName();
        //properties.putAll((Map<String, Object>) cd.getProperties());
        _owner = cd.getOwner();
     }

    @Override
    public int hashCode() {
      String s = "" + this.id + this._kindName + this._createdAt + this._createdBy + this._updatedAt
          + this._updatedBy + /*this.properties.toString() +*/ this._owner;
      return s.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      return obj.hashCode() == this.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSaved() {
        return (id != null);
    }
/*
	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
*/
	public String get_owner() {
		return _owner;
	}

	public void set_owner(String _owner) {
		this._owner = _owner;
	}

	public String get_kindName() {
		return _kindName;
	}

	public void set_kindName(String _kindName) {
		this._kindName = _kindName;
	}

	public String get_updatedBy() {
		return _updatedBy;
	}

	public void set_updatedBy(String _updatedBy) {
		this._updatedBy = _updatedBy;
	}

	public String get_createdBy() {
		return _createdBy;
	}

	public void set_createdBy(String _createdBy) {
		this._createdBy = _createdBy;
	}

	public Date get_updatedAt() {
		return _updatedAt;
	}

	public void set_updatedAt(Date _updatedAt) {
		this._updatedAt = _updatedAt;
	}

	public Date get_createdAt() {
		return _createdAt;
	}

	public void set_createdAt(Date _createdAt) {
		this._createdAt = _createdAt;
	}
}
