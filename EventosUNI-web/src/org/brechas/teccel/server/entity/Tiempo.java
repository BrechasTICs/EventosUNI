package org.brechas.teccel.server.entity;

import java.util.Date;
import java.util.UUID;

import org.brechas.teccel.shared.entity.TiempoDto;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Tiempo extends BaseEntity {
	private static final String CLOUD_ENTITY_ID_PREFIX="CE:";
	private static final long serialVersionUID = 7304302089090428442L;

    @Index private Date horaInicio;
	@Index private Date horaFin;
	private String timeZoneInicio;
	private String timeZoneFin;

	public Tiempo() {
		start();
		set_kindName("Tiempo");
	}
	public TiempoDto getDto(){
		TiempoDto dto = new TiempoDto();
		dto.setHoraFin(horaFin);
		dto.setHoraInicio(horaInicio);
		dto.setTimeZoneFin(timeZoneFin);
		dto.setTimeZoneInicio(timeZoneInicio);
		return dto;
	}
	public void setDto(TiempoDto dto){
		horaFin=dto.getHoraFin();
		horaInicio=dto.getHoraInicio();
		timeZoneFin=dto.getTimeZoneFin();
		timeZoneInicio=dto.getTimeZoneInicio();
		id=CLOUD_ENTITY_ID_PREFIX+UUID.randomUUID().toString();
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
