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

package org.brechas.teccel.server.objectify;

import org.brechas.teccel.server.entity.Actividad;
import org.brechas.teccel.server.entity.Contacto;
import org.brechas.teccel.server.entity.CurrentUser;
import org.brechas.teccel.server.entity.Evento;
import org.brechas.teccel.server.entity.Lugar;
import org.brechas.teccel.server.entity.Organizador;
import org.brechas.teccel.server.entity.Tiempo;
import org.brechas.teccel.server.entity.TipoEvento;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.googlecode.objectify.ObjectifyFactory;

@Singleton
public class OfyFactory extends ObjectifyFactory {
	
	@Inject private static Injector injector;
	public OfyFactory() {
		long time = System.currentTimeMillis();
		this.register(CurrentUser.class);
		this.register(Actividad.class);
		this.register(Contacto.class);
		this.register(Organizador.class);
		this.register(Tiempo.class);
		this.register(Lugar.class);
		this.register(Evento.class);
		this.register(TipoEvento.class);
		long millis = System.currentTimeMillis() - time;
	}

	@Override
	public <T> T construct(Class<T> type) {
		return injector.getInstance(type);
	}

	@Override
	public Ofy begin() {
		return new Ofy(this);
	}
}
