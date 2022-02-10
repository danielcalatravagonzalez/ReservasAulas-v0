package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public class Reservas {
	// Atributos
	private int capacidad;
	private int tamano;
	Reserva[] coleccionReservas;

	// Constructor con parámetros
	public Reservas(int capacidadReservas) {
		if (capacidadReservas <= 0) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		} else {
			coleccionReservas = new Reserva[capacidadReservas];
			this.capacidad = capacidadReservas;
			tamano = 0;
		}
	}

	// Método Reserva[] get()
	public Reserva[] get() {
		return copiaProfundaReservas();
	}

	// Método copiaProfundaReservas
	private Reserva[] copiaProfundaReservas() {
		Reserva[] copiaReservas = new Reserva[capacidad];
		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionReservas[i] != null)
				copiaReservas[i] = new Reserva(coleccionReservas[i]);
		}
		return copiaReservas;

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
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
		}
		int indice = buscarIndice(reserva);
		if (capacidadSuperada(indice)) {
			throw new OperationNotSupportedException("ERROR: No se aceptan más reservas.");
		}
		if (tamanoSuperado(indice)) {
			coleccionReservas[indice] = new Reserva(reserva);
			tamano++;
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe una reserva con ese nombre.");
		}
	}

	// Método buscarIndice
	private int buscarIndice(Reserva reserva) {
		int indice = 0;
		boolean reservaEncontrada = false;
		while (!tamanoSuperado(indice) && !reservaEncontrada) {
			if (coleccionReservas[indice].equals(reserva)) {
				reservaEncontrada = true;
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
	public Reserva buscar(Reserva reserva) {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede buscar una reserva nula.");
		}
		int indice = buscarIndice(reserva);
		if (tamanoSuperado(indice)) {
			return null;
		} else {
			return new Reserva(reserva);
		}
	}

	// Método borrar
	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
		}
		int indice = buscarIndice(reserva);
		if (!tamanoSuperado(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ninguna reserva con ese nombre.");
		}
	}

	// Método desplazarUnaPosicionHaciaIzquierda
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; !tamanoSuperado(i); i++) {
			coleccionReservas[i] = coleccionReservas[i + 1];
		}
		tamano--;
	}

	// Metodo representar
	public String[] representar() {
		String[] representacion = new String[tamano];
		for (int i = 0; i < representacion.length; i++)
			if (coleccionReservas != null)
				representacion[i] = "" + coleccionReservas[i];
		return representacion;
	}

	// Método getReservasProfesor(Profesor)
	public Reserva[] getReservasProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede reservar con un profesor nulo.");
		}
		Reserva[] reservasProfesor = new Reserva[capacidad];
		for (int i = 0; i < tamano; i++)
			if (coleccionReservas[i].getProfesor().equals(profesor))
				reservasProfesor[i] = coleccionReservas[i];
		return reservasProfesor;
	}

	// Método getReservasAula(Aula)
	public Reserva[] getReservasAula(Aula aula) {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede reservar un aula nula.");
		}
		Reserva[] reservasAula = new Reserva[capacidad];
		for (int i = 0; i < tamano; i++)
			if (coleccionReservas[i].getAula().equals(aula))
				reservasAula[i] = coleccionReservas[i];
		return reservasAula;

	}

	// Método getReservasPermanencia(Permanencia)
	 public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		    if(permanencia == null) {
		      throw new NullPointerException("ERROR: No se puede reservar con una permanencia nula.");
		    }
		    Reserva[] reservasPermanencia = new Reserva[capacidad]; 
		    int indiceReservas = 0;
		    for(int i = 0; i < tamano; i++) {
		      if(coleccionReservas[i].getPermanencia().equals(permanencia)) {
		        reservasPermanencia[indiceReservas] = coleccionReservas[i];
		        indiceReservas++;
		      }
		    } 
		    return reservasPermanencia;
		  }

	// Método consultarDisponibilidad(Aula,Permanencia)
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede consultar la disponibilidad de un aula nula.");
		}
		if (permanencia == null) {
			throw new NullPointerException("ERROR: No se puede consultar la disponibilidad de una permanencia nula.");
		}
		for (int i = 0; i < tamano; i++) {
			if (coleccionReservas[i].getAula().equals(aula) && coleccionReservas[i].getPermanencia().equals(permanencia)) {
				return false;
			}
		}
		return true;
	}
}
