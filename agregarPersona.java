package Personas;


import edu10.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class agregarPersona {
    public static void agregarPersona() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Ingrese el nombre y apellido:");
        String nombreApellido = scanner.nextLine();

        System.out.println("Ingrese la fecha de registro (yyyy-MM-dd) osea (año, mes, día):");
        String fechaRegistroStr = scanner.nextLine();
        Date fechaRegistro = null;
        try {
            fechaRegistro = new SimpleDateFormat("yyyy-MM-dd").parse(fechaRegistroStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto.");
            return;
        }

        System.out.println("Ingrese el sueldo base:");
        double sueldoBase = scanner.nextDouble();
        scanner.nextLine(); // Consumir la línea en blanco después de nextDouble()

        System.out.println("Ingrese el sexo (M/F) osea (M si es masculino y F si es femenino) :");
        String sexo = scanner.nextLine().toUpperCase();

        System.out.println("Ingrese la edad:");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea en blanco después de nextInt()

        System.out.println("Ingrese la latitud de su casa:");
        double latitud = scanner.nextDouble();
        scanner.nextLine(); // Consumir la línea en blanco después de nextDouble()

        System.out.println("Ingrese la longitud de su casa:");
        double longitud = scanner.nextDouble();
        scanner.nextLine(); // Consumir la línea en blanco después de nextDouble()

        System.out.println("Ingrese comentarios:");
        String comentarios = scanner.nextLine();

        Connection conexion = ConexionBD.obtenerConexion();
        if (conexion != null) {
            String sql = "INSERT INTO personas (nombre_apellido, fecha_registro, sueldo_base, sexo, edad, latitud, longitud, comentarios) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                PreparedStatement statement = conexion.prepareStatement(sql);
                statement.setString(1, nombreApellido);
                statement.setDate(2, new java.sql.Date(fechaRegistro.getTime()));
                statement.setDouble(3, sueldoBase);
                statement.setString(4, sexo);
                statement.setInt(5, edad);
                statement.setDouble(6, latitud);
                statement.setDouble(7, longitud);
                statement.setString(8, comentarios);

                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Persona agregada con éxito.");
                } else {
                    System.out.println("No se pudo agregar la persona.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}