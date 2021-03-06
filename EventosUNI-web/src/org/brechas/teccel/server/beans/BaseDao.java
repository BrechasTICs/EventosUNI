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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.brechas.teccel.server.objectify.Ofy;
import org.brechas.teccel.server.objectify.OfyFactory;

import com.google.common.collect.Lists;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.LoadType;

public abstract class BaseDao<T> {
    private final Class<T> clazz;

    @Inject
    OfyFactory ofyFactory;

    private Ofy lazyOfy;

    protected BaseDao(final Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> getAll() {
        return ofy().load().type(clazz).list();
    }

    public T put(T object) {
        ofy().save().entity(object).now();

        return object;
    }

    public Collection<T> put(Iterable<T> entities) {
        return ofy().save().entities(entities).now().values();
    }

    public T get(Key<T> key) {
        return ofy().load().get(key);
    }

    public T get(Long id) {
        // work around for objectify cacheing and new query not having the
        // latest
        // data
        ofy().clear();

        return ofy().load().get(clazz, id);
    }

    public Boolean exists(Key<T> key) {
        return get(key) != null;
    }

    public Boolean exists(Long id) {
        return get(id) != null;
    }

    public List<T> getSubset(List<Long> ids) {
        return new ArrayList<T>(ofy().load().type(clazz).ids(ids).values());
    }

    public Map<Long, T> getSubsetMap(List<Long> ids) {
        return new HashMap<Long, T>(ofy().load().type(clazz).ids(ids));
    }

    public void delete(T object) {
        ofy().delete().entity(object);
    }

    public void delete(Long id) {
        Key<T> key = Key.create(clazz, id);
        ofy().delete().entity(key);
    }

    public void delete(List<T> objects) {
        ofy().delete().entities(objects);
    }

    public List<T> get(List<Key<T>> keys) {
        return Lists.newArrayList(ofy().load().keys(keys).values());
    }

    protected Ofy ofy() {
        if (lazyOfy == null) {
            lazyOfy = ofyFactory.begin();
        }
        return lazyOfy;
    }

    protected LoadType<T> query() {
        return ofy().load().type(clazz);
    }
}
