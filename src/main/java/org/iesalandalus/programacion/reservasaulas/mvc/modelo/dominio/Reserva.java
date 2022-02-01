package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Reserva {
	//Atributos
	public Profesor profesor;
	public Aula aula;
	public Permanencia permanencia;
	
	//Constructor con parámetros
	public Reserva (Profesor profesor, Aula aula, Permanencia permanencia) {
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}
	
	//Constructor copia
	public Reserva (Reserva otraReserva) {
		if (otraReserva == null) {
			throw new NullPointerException ("ERROR: No se puede copiar una reserva nula.");
		} else {
			setProfesor(otraReserva.getProfesor());
			setAula(otraReserva.getAula());
			setPermanencia(otraReserva.getPermanencia());
		}
		
	}
	
	// Setter de profesor
	private void setProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException ("ERROR: La reserva debe estar a nombre de un profesor.");
		} else {
			this.profesor = new Profesor(profesor);
		}
		
	}

	// Getter de profesor
	public Profesor getProfesor() {
		return new Profesor(profesor);
	}

	// Setter de aula
	private void setAula(Aula aula) {
		if (aula == null) {
			throw new NullPointerException ("ERROR: La reserva debe ser para un aula concreta.");
		} else {
			this.aula = new Aula(aula);
		}
		
	}

	// Getter de aula
	public Aula getAula() {
		return new Aula(aula);
	}

	// Setter de permanencia
	private void setPermanencia(Permanencia permanencia) {
		if (permanencia == null) {
			throw new NullPointerException ("ERROR: La reserva se debe hacer para una permanencia concreta.");
		} else {
			this.permanencia = new Permanencia(permanencia);
		}
		
	}
	
	// Getter de permanencia
	public Permanencia getPermanencia() {
		return new Permanencia(permanencia);
	}

	//Métodos hashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(aula, permanencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(permanencia, other.permanencia);
	}

	//Método toString
	@Override
	public String toString() {
		return "Profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia + "";
	}
	
}
