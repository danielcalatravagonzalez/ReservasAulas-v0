package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Aula {
	//Atributos
	private String nombre;
	
	//Constructor con parámetro
	public Aula (String nombre) {
		setNombre(nombre);
	}
	
	//Constructor copia
	public Aula(Aula otraAula) {
		if (otraAula == null) {
			throw new NullPointerException("ERROR: No se puede copiar un aula nula.");
		} else {
			setNombre(otraAula.getNombre());
		}
	}
	
	//Setter de nombre
	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException ("ERROR: El nombre del aula no puede ser nulo.");
		} else if (nombre.isEmpty()) {
			throw new IllegalArgumentException ("ERROR: El nombre del aula no puede estar vacío.");
		} else {
			this.nombre = nombre;
		}
		
	}
	
	//Getter de nombre
	public String getNombre() {
		return nombre;
	}

	//Métodos hashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Aula))
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(nombre, other.nombre);
	}

	//Método toString
	@Override
	public String toString() {
		return "nombre Aula=" + nombre + "";
	}


}
