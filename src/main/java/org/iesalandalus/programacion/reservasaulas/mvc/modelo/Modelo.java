package org.iesalandalus.programacion.reservasaulas.mvc.modelo;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.Aulas;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.Profesores;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.Reservas;

public class Modelo {
	// Atributos
	private static int CAPACIDAD = 10;
	Profesores profesores;
	Aulas aulas;
	Reservas reservas;

	// Constructor por defecto
	public Modelo() {
		aulas = new Aulas(CAPACIDAD);
		profesores = new Profesores(CAPACIDAD);
		reservas = new Reservas(CAPACIDAD);
	}

	// Método getAulas
	public Aula[] getAulas(Aula aula) {
		return aulas.get();
	}

	// Método getNumAulas
	public int getNumAulas() {
		return aulas.getTamano();
	}

	// Método representarAulas
	public String[] representarAulas() {
		return aulas.representar();
	}

	// Método buscarAula(Aula)
	public Aula buscarAula(Aula aula) {
		return aulas.buscar(aula);
	}

	// Método insertarAula
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		aulas.insertar(aula);
	}

	// Método borrarAula
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		aulas.borrar(aula);
	}

	// Método getProfesores
	public Profesor[] getProfesores(Profesor profesor) {
		return profesores.get();
	}

	// Método getNumProfesores
	public int getNumProfesores() {
		return profesores.getTamano();
	}

	// Método representarProfesores
	public String[] representarProfesores() {
		return profesores.representar();
	}

	// Método buscarProfesor
	public Profesor buscarProfesor(Profesor profesor) {
		return profesores.buscar(profesor);
	}

	// Método insertarProfesor
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		profesores.insertar(profesor);
	}

	// Método borrarProfesor
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		profesores.borrar(profesor);
	}

	// Método getReservas
	public Reserva[] getReservas(Reserva reserva) {
		return reservas.get();
	}

	// Método getNumReservas
	public int getNumReservas() {
		return reservas.getTamano();
	}

	// Método representarReservas
	public String[] representarReservas() {
		return reservas.representar();
	}

	// Método buscarReserva
	public Reserva buscarReserva(Reserva reserva) {
		return reservas.buscar(reserva);
	}

	// Método realizarReserva
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		reservas.insertar(reserva);
	}

	// Método anularReserva
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
		reservas.borrar(reserva);
	}

	// Método getReservasProfesor(Profesor)
	public Reserva[] getReservasProfesor(Profesor profesor) {
		return reservas.getReservasProfesor(profesor);
	}

	// Método getReservasAula(Aula)
	public Reserva[] getReservasAula(Aula aula) {
		return reservas.getReservasAula(aula);
	}

	// Método getReservasPermanencia(Permanencia)
	public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		return reservas.getReservasPermanencia(permanencia);
	}

	// Método consultarDisponibilidad(Aula,Permanencia)
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return reservas.consultarDisponibilidad(aula, permanencia);
	}
}