package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	// Atributos
	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");;

	// Constructor consola (utilidad, por lo tanto no se instancian objetos)
	private Consola() {

	}

	// Método mostrarMenu
	public static void mostrarMenu() {
		mostrarCabecera("Bienvenido al gestor de reservas de aulas");
		for (Opcion opcion : Opcion.values()) {
			System.out.println(opcion);
		}
	}

	// Método mostrarCabecera
	public static void mostrarCabecera(String mostrarCabecera) {
		System.out.printf("%n%s%n", mostrarCabecera);
		String cadena = "%0" + mostrarCabecera.length() + "d%n";
		System.out.println(String.format(cadena, 0).replace("0", "-"));
	}

	// Método elegirOpcion()
	public static int elegirOpcion() {
		System.out.println("");
		System.out.println("Por favor, elija una opción");
		System.out.println("");
		int opcionElegida = Entrada.entero();
		while (opcionElegida < 0 || opcionElegida > Opcion.values().length) {
			System.out.println("Por favor, elija una opción comprendida entre 0 y 15: ");
			opcionElegida = Entrada.entero();
		}
		return opcionElegida;
	}

	// Método leerAula
	public static Aula leerAula() {
		return new Aula(leerNombreAula());

	}

	// Método leerNombreAula
	public static String leerNombreAula() {
		System.out.println("Introduzca el nombre del aula:");
		String nombre = Entrada.cadena();
		return nombre;
	}

	// Método leerProfesor
	public static Profesor leerProfesor() {
		System.out.println("Introduce el correo del profesor:");
		String correoProfesor = Entrada.cadena();
		System.out.println("Introduce el teléfono del profesor:");
		String telefonoProfesor = Entrada.cadena();
		if (telefonoProfesor == null || telefonoProfesor.isBlank()) {
			return new Profesor(leerNombreProfesor(), correoProfesor);
		} else {
			return new Profesor(leerNombreProfesor(), correoProfesor, telefonoProfesor);
		}
	}

	// Método leerNombreProfesor
	public static String leerNombreProfesor() {
		System.out.println("Introduzca el nombre del profesor:");
		String nombre = Entrada.cadena();
		return nombre;
	}

	// Método leerTramo
	public static Tramo leerTramo() {
		System.out.println("Eliga un tramo insertando 1 (Mañana) o 2 (Tarde): ");
		int indice = Entrada.entero();
		switch (indice) {
		case 1:
			return Tramo.MANANA;

		case 2:
			return Tramo.TARDE;

		default:
			return null;
		}
	}

	// Método leerDia
	public static LocalDate leerDia() {
		System.out.println("Introduzca una fecha con el siguiente formato: dd/MM/aaaa:");
		return LocalDate.parse(Entrada.cadena(), FORMATO_DIA);
	}
}