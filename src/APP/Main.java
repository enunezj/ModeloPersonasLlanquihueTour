package APP;

import MODEL.Direccion;
import MODEL.Persona;
import MODEL.Empleado;

public class Main {

    public static void main(String[] args) {

        // Crear direccion
        Direccion direccion = new Direccion(
                "Av. Costanera",
                123,
                "Puerto Varas"
        );

        // Crear persona
        Persona cliente1 = new Persona(
                "11.688.254-K",
                "Juan Perez",
                "+56918469545",
                "juan@gmail.cl",
                direccion
        );

        // Uso de setters
        cliente1.setNombre("Juan Carlos Perez");
        cliente1.setTelefono("+56998765432");
        cliente1.setRut("20349630-1");
        cliente1.setEmail("jucarpe@gmail.com");

        Direccion direccionNueva = new Direccion(
                "Av. Lago Colico",
                500,
                "Puerto aisen"
        );
        direccionNueva.setCalle("Av. Lago Colico");
        direccionNueva.setNumero(550);
        direccionNueva.setCiudad("Puerto Aysen");

        cliente1.setDireccion(direccionNueva);

        // Crear empleado
        Empleado empleado1 = new Empleado(
                "11.362.678-1",
                "Jose Jorquera",
                "+56987654321",
                "JoJo@Llanquihuetour.cl",
                direccion,
                "Guia Turistico Diurno",
                560000
        );

        empleado1.setCargo("Guia Turistico Nocturno");
        empleado1.setSueldo(850000);

        // Mostrar resultados
        System.out.println("=== CLIENTE ===");
        System.out.println(cliente1);
        System.out.println("Confirmacion de ciudad de cliente: " + direccionNueva.getCiudad());
        System.out.println("Confirmacion de Numero de calle de cliente: " + direccionNueva.getNumero());
        System.out.println("Confirmacion de calle de cliente: " + direccionNueva.getCalle());
        System.out.println();

        System.out.println("=== EMPLEADO ===");
        System.out.println(empleado1);

        System.out.println("Verificacion de cambio de turno:");
        System.out.println("Cargo: " + empleado1.getCargo());
        System.out.println("Sueldo: $" + empleado1.getSueldo());
    }
}