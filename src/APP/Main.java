package APP;

import MODEL.Direccion;
import MODEL.Persona;
import MODEL.Empleado;

public class Main {
    public static void main(String[] args) {
        // creacion de direccion
        Direccion direccion = new Direccion(
                "Av. Costanera",
                123,
                "Puerto Varas"
        );
        // crear persona
        Persona cliente1 = new Persona(
                "11.688.254-K",
                "Juan Perez",
                "+56918469545",
                "juan@gmail.cl",
                direccion
        );
        cliente1.setNombre("Juan Carlos Perez");
        cliente1.setTelefono("+56955220388");

        // crear empleado
        Empleado empleado1 = new Empleado(
                "11.362.678-1",
                "Jose Jorquera",
                "+56987654321",
                "JoJo@Llanquihuetour.cl",
                direccion,
                "Guia Turistico",
                560000
        );

        // uso de set de manera explicita
        empleado1.setCargo("Guia Turistico");
        empleado1.setSueldo(800000);

        // uso de setters de Direccion
        direccion.setCalle("Av. Vicente Perez Rosales");
        direccion.setNumero(456);
        direccion.setCiudad("Llanquihue");

        // uso de getters de Direccion
        System.out.println("Calle: " + direccion.getCalle());
        System.out.println("Numero: " + direccion.getNumero());
        System.out.println("Ciudad: " + direccion.getCiudad());

        System.out.println();

        // setters de PERSONA   CLIENTE
        cliente1.setNombre("Juan Carlos Perez");
        cliente1.setTelefono("+56998765432");
        cliente1.setRut("20349630-1");
        cliente1.setEmail("jucarpe@gmail.com");
        Direccion direccionNueva = new Direccion(
                "Av. lago Colico",
                500,
                "puerto varas"
        );
        cliente1.setDireccion(direccionNueva);

        // getters de PERSONA
        System.out.println("Nombre: " + cliente1.getNombre());
        System.out.println("Telefono: " + cliente1.getTelefono());

        System.out.println();

        // setters de Empleado
        empleado1.setCargo("Guia Turistico Senior");
        empleado1.setSueldo(1100000);

        // getters de Empleado
        System.out  .println("Cargo: " + empleado1.getCargo());
        System.out.println("Sueldo: " + empleado1.getSueldo());

        System.out.println();

        // mostrar objetos completos usando toString()
        System.out.println("=== CLIENTE ===");
        System.out.println(cliente1);

        System.out.println( );

        System.out.println("=== Empleado ===");
        System.out.println(empleado1);

        System.out.println( );

        // mostrar texto
        System.out.println("=== DATOS DE PERSONA ===");
        System.out.println(cliente1);
        System.out.println("Nombre actualizado: " + cliente1.getNombre());
        System.out.println("Telefono actualizado: " + cliente1.getTelefono());
        System.out.println("Rut actualizado: " + cliente1.getRut());
        System.out.println("Email actualizado: " + cliente1.getEmail());
        System.out.println("Direccion actualizada: " + cliente1.getDireccion());
        System.out.println();

        System.out.println("=== DATOS DE EMPLEADO ===");
        System.out.println(empleado1);
        System.out.println("Cargo: " + empleado1.getCargo());
        System.out.println("Sueldo: " + empleado1.getSueldo());
    }
}