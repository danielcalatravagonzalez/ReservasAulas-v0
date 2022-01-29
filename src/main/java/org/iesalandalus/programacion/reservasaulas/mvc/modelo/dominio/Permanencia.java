package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Permanencia {
	//Atributos
	private LocalDate dia;
	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public Tramo tramo;
	
	//Constructor con parámetros
	public Permanencia(LocalDate dia, Tramo tramo) {
		setDia(dia);
		setTramo(tramo);
	}

	//Constructor copia
	public Permanencia(Permanencia otraPermanencia) {
		if (otraPermanencia == null) {
			throw new NullPointerException("ERROR: No se puede copiar una permanencia nula.");
		} else {
			setDia(otraPermanencia.getDia());
			setTramo(otraPermanencia.getTramo());
		}
	}

	//Getters y Setters de dia
	public LocalDate getDia() {
		return dia;
	}

	private void setDia(LocalDate dia) {
		if (dia == null) {
			throw new NullPointerException ("ERROR: El día de una permanencia no puede ser nulo.");
		} else {
		this.dia = dia;
		}
	}

	//Getters y Setters de tramo
	public Tramo getTramo() {
		return tramo;
	}

	private void setTramo(Tramo tramo) {
		if (tramo == null) {
			throw new NullPointerException ("ERROR: El tramo de una permanencia no puede ser nulo.");
		} else {
		this.tramo = tramo;
		}
		
	}

	//Métodos hasCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(dia, tramo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Permanencia))
			return false;
		Permanencia other = (Permanencia) obj;
		return Objects.equals(dia, other.dia) && tramo == other.tramo;
	}

	//Método toString
	@Override
	public String toString() {

		return "dia=" + dia.format(FORMATO_DIA)+ ", tramo=" + tramo + "";
	}
	
}
