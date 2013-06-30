package org.brechas.teccel.server.entity;

import java.io.Serializable;
import java.util.TimeZone;

import org.apache.james.mime4j.field.datetime.DateTime;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Tiempo extends BaseEntity {

	private static final long serialVersionUID = 7304302089090428442L;

    @Id Long id;

	private DateTime horaInicio;
	private DateTime horaFin;
	private TimeZone timeZoneInicio;
	private TimeZone timeZoneFin;

	public Tiempo() {
	}

	public void setHoraInicio(DateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFin(DateTime horaFin) {
		this.horaFin = horaFin;
	}

	public void setTimeZoneInicio(TimeZone timeZoneInicio) {
		this.timeZoneInicio = timeZoneInicio;
	}

	public void setTimeZoneFin(TimeZone timeZoneFin) {
		this.timeZoneFin = timeZoneFin;
	}

	public DateTime getHoraInicio() {
		return horaInicio;
	}

	public DateTime getHoraFin() {
		return horaFin;
	}

	public TimeZone getTimeZoneInicio() {
		return timeZoneInicio;
	}

	public TimeZone getTimeZoneFin() {
		return timeZoneFin;
	}
}
