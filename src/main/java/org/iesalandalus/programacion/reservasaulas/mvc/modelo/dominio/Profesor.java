package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.util.Objects;

public class Profesor {
	// Atributos
	private static final String ER_TELEFONO = ("[69][0-9]{8}");
	private static final String ER_CORREO = ("[A-Za-z0-9+_.-]+@(.+)$");
	private String nombre;
	private String correo;
	private String telefono;

	// Constructor con parámetros nombre y correo
	public Profesor(String nombre, String correo) {
		setNombre(nombre);
		setCorreo(correo);
	}

	// Constructor con parámetros nombre, correo y telefono
	public Profesor(String nombre, String correo, String telefono) {
		setNombre(nombre);
		setCorreo(correo);
		setTelefono(telefono);
	}

	// Constructor copia
	public Profesor(Profesor otroProfesor) {
		if (otroProfesor == null) {
			throw new NullPointerException("ERROR: No se puede copiar un profesor nulo.");
			} else {
			setNombre(otroProfesor.getNombre());
			setCorreo(otroProfesor.getCorreo());
			setTelefono(otroProfesor.getTelefono());
			}
	}

	// Setter de nombre
	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre del profesor no puede ser nulo.");
		} else if (nombre.isEmpty()) {
			throw new IllegalArgumentException("ERROR: El nombre del profesor no puede estar vacío.");
		} else {
			this.nombre = nombre;
		}
	}

	// Setter de correo
	public void setCorreo(String correo) {
		if (correo == null) {
			throw new NullPointerException("ERROR: El correo del profesor no puede ser nulo.");
		} else if (correo.matches(ER_CORREO)) {
			this.correo = correo;
		} else {
			throw new IllegalArgumentException("ERROR: El correo del profesor no es válido.");
		}
	}

	// Setter de telefono
	public void setTelefono(String telefono) {
		  if (telefono == "" && telefono.length() != 9 && !telefono.matches(ER_TELEFONO)) {
		      throw new IllegalArgumentException("ERROR: El teléfono del profesor no es válido.");
		    }

		    this.telefono = telefono;
		  }

	// Getter de nombre
	public String getNombre() {
		return nombre;
	}

	// Getter de correo
	public String getCorreo() {
		return correo;
	}

	// Getter de telefono
	public String getTelefono() {
		return telefono;
	}

	// Métodos hashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(nombre, correo, telefono);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Profesor))
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("nombre=");
		sb.append(this.nombre);
		sb.append(", correo=");
		sb.append(this.correo);
		if (this.telefono !=null) {
			sb.append(", telefono=");
			sb.append(this.telefono);
		}
		//return "nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + "";
		return sb.toString();
	}

}
