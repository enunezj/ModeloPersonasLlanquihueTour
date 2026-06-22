package SERVICE;

import MODEL.Empleado;
import UTIL.Validaciones;

import java.util.ArrayList;

public class EmpleadoService {

    private final ArrayList<Empleado> empleados;

    public EmpleadoService() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) return;

        if (Validaciones.rutInvalido(empleado.getRut())) return;
        if (Validaciones.nombreInvalido(empleado.getNombre())) return;
        if (Validaciones.telefonoInvalido(empleado.getTelefono())) return;
        if (Validaciones.emailInvalido(empleado.getEmail())) return;
        if (Validaciones.rolInvalido(empleado.getRol())) return;

        if (rutExisteEmpleado(empleado.getRut())) {
            System.out.println("No se agregó. Ya existe un empleado con ese RUT.");
            return;
        }

        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.println("\n===== LISTADO DE EMPLEADOS =====");

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
            System.out.println("----------------------------");
        }
    }

    public Empleado buscarEmpleado(String rut) {
        for (Empleado empleado : empleados) {
            if (empleado.getRut().equalsIgnoreCase(rut)) {
                return empleado;
            }
        }

        return null;
    }

    public boolean rutExisteEmpleado(String rut) {
        return buscarEmpleado(rut) != null;
    }

    public ArrayList<Empleado> obtenerEmpleados() {
        return empleados;
    }
    public void mostrarEmpleadosPorRol(String rol) {
        boolean encontrado = false;

        System.out.println("\n===== EMPLEADOS CON ROL: " + rol + " =====");

        for (Empleado empleado : empleados) {
            if (empleado.getRol().equalsIgnoreCase(rol)) {
                System.out.println(empleado);
                System.out.println("----------------------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron empleados con ese rol.");
        }
    }
}