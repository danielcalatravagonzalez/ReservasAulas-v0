package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.naming.OperationNotSupportedException;

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
		System.out.println("Bienvenido al sistema gestor de reservas de aulas, elige una opción:");
		System.out.println("0. Salir.");
		System.out.println("1. Insertar aula.");
		System.out.println("2. Borrar aula.");
		System.out.println("3. Buscar aula.");
		System.out.println("4. Listar aulas.");
		System.out.println("5. Insertar profesor.");
		System.out.println("6. Borrar profesor.");
		System.out.println("7. Buscar profesor.");
		System.out.println("8. Listar profesores.");
		System.out.println("9. Insertar reserva.");
		System.out.println("10. Borrar reserva.");
		System.out.println("11. Listar reservas.");
		System.out.println("12. Listar reservas aula.");
		System.out.println("13. Listar reservas profesor.");
		System.out.println("14. Listar reservas permanencia.");
		System.out.println("15. Consultar disponibilidad.");
	}

	// Método mostrarCabecera
	public static void mostarCabecera(String mostrarCabecera) {
		System.out.printf("%n%s%n", mostrarCabecera);
		String cadena = "%0" + mostrarCabecera.length() + "d%n";
		System.out.println(String.format(cadena, 0).replace("0", "-"));
	}

	// Método elegirOpcion()
	public static Opcion elegirOpcion() {
		Opcion[] opcion = Opcion.values();
		System.out.println("");
		System.out.println("Por favor, elija una opción");
		System.out.println("");
		int opcionElegida = Entrada.entero();
		while (opcionElegida < 0 || opcionElegida > 15) {
			System.out.println("Por favor, elija una opción comprendida entre 0 y 15: ");
			opcionElegida = Entrada.entero();
		}
		return opcion[opcionElegida];
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
		return new Profesor(leerNombreProfesor(), correoProfesor, telefonoProfesor);
	}

	// Método leerNombreProfesor
	public static String leerNombreProfesor() {
		System.out.println("Introduzca el nombre del profesor:");
		String nombre = Entrada.cadena();
		return nombre;
	}

	// Método leerTramo
	public static Tramo leerTramo() {
		System.out.println("Introduzca un Tramo poninendo 1 o 2: Mañana(1) Tarde(2)");
		int tramo = Entrada.entero();
		switch (tramo) {
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
		DateTimeFormatter formatoCadena = FORMATO_DIA;
		LocalDate fecha = null;
		boolean fechaValida = false;
		do {
			try {
				System.out.println("Introduzca una fecha con el siguiente formato: dd/MM/aaaa:");
				fecha = LocalDate.parse(Entrada.cadena(), formatoCadena);
				fechaValida = true;
			} catch (DateTimeParseException e) {
				fechaValida = false;
			}
		} while (!fechaValida);
		return fecha;
	}
}