package edu10;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static Personas.actualizarPersona.actualizarPersona;
import static Personas.agregarPersona.agregarPersona;
import static Personas.consultarPersonas.consultarPersonas;
import static Personas.eliminarPersona.eliminarPersona;

public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Menú:");
                System.out.println("1. Agregar Persona");
                System.out.println("2. Consultar Personas");
                System.out.println("3. Actualizar Persona");
                System.out.println("4. Eliminar Persona");
                System.out.println("5. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea en blanco después de nextInt()

                switch (opcion) {
                    case 1:
                        agregarPersona();
                        break;
                    case 2:
                        consultarPersonas();
                        break;
                    case 3:
                        actualizarPersona();
                        break;
                    case 4:
                        eliminarPersona();
                        break;
                    case 5:
                        // Salir del programa
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }

    }
}