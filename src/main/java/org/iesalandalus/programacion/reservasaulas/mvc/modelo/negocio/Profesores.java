package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;

public class Profesores {
	// Atributos
	private int capacidad;
	private int tamano;
	Profesor[] coleccionProfesores;

	// Constructor con parámetros
	public Profesores(int capacidadProfesores) {
		if (capacidadProfesores <= 0) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		} else {
			coleccionProfesores = new Profesor[capacidadProfesores];
			this.capacidad = capacidadProfesores;
			tamano = 0;
		}
	}

	// Método Profesor[] get()
	public Profesor[] get() {
		return copiaProfundaProfesores();
	}

	// Método copiaProfundaProfesores
	private Profesor[] copiaProfundaProfesores() {
		Profesor[] copiaProfesores = new Profesor[capacidad];
		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionProfesores[i] != null)
				copiaProfesores[i] = new Profesor(coleccionProfesores[i]);
		}
		return copiaProfesores;

	}

	// Método getTamano
	public int getTamano() {
		return tamano;
	}

	// Método getCapacidad
	public int getCapacidad() {
		return capacidad;
	}

	// Método insertar
	public void insertar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede insertar un profesor nulo.");
		}
		int indice = buscarIndice(profesor);
		if (capacidadSuperada(indice)) {
			throw new OperationNotSupportedException("ERROR: No se aceptan más profesores.");
		}
		if (tamanoSuperado(indice)) {
			coleccionProfesores[indice] = new Profesor(profesor);
			tamano++;
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un profesor con ese nombre.");
		}
	}

	// Método buscarIndice
	private int buscarIndice(Profesor profesor) {
		int indice = 0;
		boolean profesorEncontrado = false;
		while (!tamanoSuperado(indice) && !profesorEncontrado) {
			if (coleccionProfesores[indice].equals(profesor)) {
				profesorEncontrado = true;
			} else {
				indice++;
			}
		}
		return indice;
	}

	// Método tamanoSuperado
	private boolean tamanoSuperado(int indice) {
		boolean tamanoSuperado;
		tamanoSuperado = (indice >= tamano);
		return tamanoSuperado;
	}

	// Método capacidadSuperada
	private boolean capacidadSuperada(int indice) {
		boolean capacidadSuperada;
		capacidadSuperada = (indice >= capacidad);
		return capacidadSuperada;

	}

	// Método buscar
	public Profesor buscar(Profesor profesor) {
		if(profesor == null) {
			throw new NullPointerException ("ERROR: No se puede buscar un profesor nulo.");
		}
		int indice = buscarIndice(profesor);
		if (tamanoSuperado(indice)) {
			return null;
		} else {
			return new Profesor(profesor);
		}
	}

	// Método borrar
	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede borrar un profesor nulo.");
		}
		int indice = buscarIndice(profesor);
		if (!tamanoSuperado(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún profesor con ese nombre.");
		}
	}

	// Método desplazarUnaPosicionHaciaIzquierda
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; !tamanoSuperado(i); i++) {
			coleccionProfesores[i] = coleccionProfesores[i + 1];
		}
		tamano--;
	}

	//Metodo representar
	public String[] representar() {
		String[] representacion = new String[tamano];
		for (int i = 0; i < representacion.length; i++)
			if (coleccionProfesores[i] != null)
				representacion[i] ="" + coleccionProfesores[i];
		return representacion;
	}

}
