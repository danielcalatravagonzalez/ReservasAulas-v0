package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.mvc.controlador.Controlador;

public class Vista {
	//Atributos
	private static final String ERROR = "ERROR";
	private static final String NOMBRE_VALIDO = "Nombre válido";
	private static final String CORREO_VALIDO = "Correo válido";
	private Controlador controlador;

	//Constructor por defecto
	public Vista() {
		Opcion.setVista(this);
	}

	//Método setControlador
	public void setControlador (Controlador controlador){
		this.controlador = controlador;
	}

	//Método comenzar
	public void comenzar() {
		Consola.mostrarCabecera("Programa de gestión para reservar aulas");
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	//Método salir
	public void salir() {
		System.out.println("¡Hasta la próxima!");
	}

	//Método insertarAula
	public void insertarAula() {
		Consola.mostrarCabecera("Insertar aula");
		try {
			Aula aula = Consola.leerAula();
			controlador.insertarAula(aula);
			System.out.println("Se ha insertado el aula correctamente"+ NOMBRE_VALIDO);
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	//Método borrarAula
	public void borrarAula() {
		Consola.mostrarCabecera("Borrar aula");
		try {
			Aula aula = Consola.leerAula();
			controlador.borrarAula(aula);
			System.out.println("Se ha borrado el aula correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	//Método buscarAula
	public void buscarAula() {
		Consola.mostrarCabecera("Buscar aula");
		Aula aula = null;
		try {
			aula = Consola.leerAula();
			aula = controlador.buscarAula(aula);
			if (aula != null) {
				System.out.println("El aula buscado es: " + aula);
			} else {
				System.out.println("No existe ningún aula con ese nombre");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	//Método listarAula
	public void listarAula() {
		Consola.mostrarCabecera("Listar aulas");
		String[] aulas = controlador.representarAulas();
		if (aulas.length != 0) {
			for (String aula : aulas) {
				System.out.println(aula);
			}
		} else {
			System.out.println("No hay aulas que listar.");
		}
	}

	//Método insertarProfesor
	public void insertarProfesor() {
		Consola.mostrarCabecera("Insertar profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			controlador.insertarProfesor(profesor);
			System.out.println("El profesor se ha insertado correctamente"+ NOMBRE_VALIDO);
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	//Método borrarProfesor
	public void borrarProfesor() {
		Consola.mostrarCabecera("Borrar profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			controlador.borrarProfesor(profesor);
			System.out.println("El profesor se ha borrado correctamente correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	//Método buscarProfesor
	public void buscarProfesor() {
		Consola.mostrarCabecera("Buscar profesor");
		Profesor profesor = null;
		try {
			profesor = Consola.leerProfesor();
			profesor = controlador.buscarProfesor(profesor);
			if (profesor != null) {
				System.out.println("El profesor buscado es: " + profesor);
			} else {
				System.out.println("No existe ningún profesor con ese nombre");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	//Método listarProfesor
	public void listarProfesor() {
		Consola.mostrarCabecera("Listar profesores");
		String[] profesores = controlador.representarProfesores();
		if (profesores.length != 0) {
			for (String profesor : profesores) {
				System.out.println(profesor);
			}
		} else {
			System.out.println("No hay profesores que listar.");
		}
	}

	//Método realizarReserva
	public void realizarReserva() {
		Consola.mostrarCabecera("Realizar reserva");
		try {
			Profesor profesor = Consola.leerProfesor();
			Reserva reserva = leerReserva(profesor);
			controlador.realizarReserva(reserva);
			System.out.println("La reserva se ha realizado correctamente");
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	//Método leerReserva(Profesor)
	private Reserva leerReserva(Profesor profesor) {
		Consola.mostrarCabecera("Leer reserva");
		Aula aula = Consola.leerAula();
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		return new Reserva(profesor, aula, permanencia);
	}

	//Método anularReserva
	public void anularReserva() {
		Consola.mostrarCabecera("Anular reserva");
		try {
			Profesor profesor = Consola.leerProfesor();
			Reserva reserva = leerReserva(profesor);
			controlador.anularReserva(reserva);
			System.out.println("La reserva se ha anulado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	//Método listarReservas
	public void listarReservas() {
		Consola.mostrarCabecera("Listar Reservas");
		String[] reservas = controlador.representarReservas();
		if (reservas.length != 0) {
			for (String reserva : reservas) {
				System.out.println(reserva);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}

	//Método listarReservasAula
	public void listarReservasAula() {
		Consola.mostrarCabecera("Listar reservas aula");
		Aula aula = Consola.leerAula();
		Reserva[] reservasAulas = controlador.getReservasAula(aula);
		if (reservasAulas.length != 0) {
			for (Reserva reservaAula : reservasAulas) {
				System.out.println(reservaAula);
			}
		} else {
			System.out.println(aula.getNombre()+" no tiene ninguna reserva a su nombre.");
		}
	}

	//Método listarReservasProfesor
	public void listarReservasProfesor() {
		Consola.mostrarCabecera("Listar reservas profesor");
		Profesor profesor = Consola.leerProfesor();
		Reserva[] reservasProfesor = controlador.getReservasProfesor(profesor);
		if (reservasProfesor.length != 0) {
			for (Reserva reservaProfesor : reservasProfesor) {
				System.out.println(reservaProfesor);
			}
		} else {
			System.out.println(profesor.getNombre()+" no tiene ninguna reserva a su nombre.");
		}
	}

	//Método listarReservasPermanencia
	public void listarReservasPermanencia() {
		Consola.mostrarCabecera("Listar reservas permanencia");
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		Reserva[] reservasPermanencia = controlador.getReservasPermanencia(permanencia);
		if (reservasPermanencia.length != 0) {
			for (Reserva reservaPermanencia : reservasPermanencia) {
				System.out.println(reservaPermanencia);
			}
		} else {
			System.out.println(permanencia.getDia()+": no hay ninguna reserva.");
		}
	}

	//Método consultarDisponibilidad
	public void consultarDisponibilidad() {
		Consola.mostrarCabecera("Consultar disponibilidad");
		Aula aula = Consola.leerAula();
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		if (controlador.consultarDisponibilidad(aula,permanencia)) {
			System.out.println(aula + " se encuentra disponible el dia "+permanencia.getDia()+".");
		}else {
			System.out.println(aula + " no se encuentra disponible el dia "+permanencia.getDia()+".");
		}
	}

}
