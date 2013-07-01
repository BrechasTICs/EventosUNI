package org.brechas.teccel.shared.entity;

import java.util.Date;
import java.util.TimeZone;

public class TiempoDto implements Dto {

	private static final long serialVersionUID = 7304302089090428442L;
	private Date horaInicio;
	private Date horaFin;
	private String timeZoneInicio;
	private String timeZoneFin;

	public TiempoDto() {
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public void setTimeZoneInicio(String timeZoneInicio) {
		this.timeZoneInicio = timeZoneInicio;
	}

	public void setTimeZoneFin(String timeZoneFin) {
		this.timeZoneFin = timeZoneFin;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public String getTimeZoneInicio() {
		return timeZoneInicio;
	}

	public String getTimeZoneFin() {
		return timeZoneFin;
	}
}
