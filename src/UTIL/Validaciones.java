package UTIL;

import MODEL.Persona;

import java.util.ArrayList;

public class Validaciones {

    public static boolean rutInvalido(String rut) {
        try {
            if (rut == null || rut.isBlank()) {
                throw new IllegalArgumentException("El RUT no puede estar vacío.");
            }

            if (!rut.matches("^[0-9]{7,8}-[0-9Kk]$")) {
                throw new IllegalArgumentException("El RUT debe tener formato válido. Ejemplo: 20349630-1");
            }

            return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static boolean nombreInvalido(String nombre) {
        try {
            if (nombre == null || nombre.isBlank()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }

            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                throw new IllegalArgumentException("El nombre solo puede contener letras y espacios.");
            }

            return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static boolean telefonoInvalido(String telefono) {
        try {
            if (telefono == null || telefono.isBlank()) {
                throw new IllegalArgumentException("El teléfono no puede estar vacío.");
            }

            if (!telefono.matches("^(\\+569[0-9]{8}|9[0-9]{8})$")) {
                throw new IllegalArgumentException("El teléfono debe tener formato válido. Ejemplo: +56912345678 o 912345678");
            }

            return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static boolean emailInvalido(String email) {
        try {
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("El email no puede estar vacío.");
            }

            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                throw new IllegalArgumentException("El email ingresado no es válido.");
            }

            return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static boolean rutExiste(ArrayList<Persona> personas, String rut) {
        for (Persona persona : personas) {
            if (persona.getRut().equalsIgnoreCase(rut)) {
                return true;
            }
        }
        return false;
    }
    public static boolean rolInvalido(String rol) {
        try {
            if (rol == null || rol.isBlank()) {
                throw new IllegalArgumentException("El rol no puede estar vacío.");
            }

            String rolLimpio = rol.trim();

            if (!rolLimpio.equalsIgnoreCase("Guia") &&
                    !rolLimpio.equalsIgnoreCase("Operador") &&
                    !rolLimpio.equalsIgnoreCase("Proveedor")) {

                throw new IllegalArgumentException("Rol inválido. Debe ser Guia, Operador o Proveedor.");
            }

            return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
    }