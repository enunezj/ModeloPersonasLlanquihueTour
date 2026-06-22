package APP;

import MODEL.Direccion;
import MODEL.Empleado;
import MODEL.Persona;
import MODEL.Proveedor;
import SERVICE.ArchivoEmpleadoService;
import SERVICE.ArchivoProveedorService;
import SERVICE.ArchivoService;
import SERVICE.EmpleadoService;
import SERVICE.PersonaService;
import SERVICE.ProveedorService;
import UTIL.Validaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String ARCHIVO_PERSONAS = "data/cliente.txt";
    private static final String ARCHIVO_EMPLEADOS = "data/colaboradores.txt";
    private static final String ARCHIVO_PROVEEDORES = "data/proveedores.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PersonaService personaService = new PersonaService();
        EmpleadoService empleadoService = new EmpleadoService();
        ProveedorService proveedorService = new ProveedorService();

        ArchivoService archivoService = new ArchivoService();
        ArchivoEmpleadoService archivoEmpleadoService = new ArchivoEmpleadoService();
        ArchivoProveedorService archivoProveedorService = new ArchivoProveedorService();

        ArrayList<Persona> personasArchivo = archivoService.cargarPersonas(ARCHIVO_PERSONAS);
        for (Persona persona : personasArchivo) {
            personaService.agregarPersona(persona);
        }

        ArrayList<Empleado> empleadosArchivo = archivoEmpleadoService.cargarEmpleados(ARCHIVO_EMPLEADOS);
        for (Empleado empleado : empleadosArchivo) {
            empleadoService.agregarEmpleado(empleado);
        }

        ArrayList<Proveedor> proveedoresArchivo = archivoProveedorService.cargarProveedores(ARCHIVO_PROVEEDORES);
        for (Proveedor proveedor : proveedoresArchivo) {
            proveedorService.agregarProveedor(proveedor);
        }

        int opcion;

        do {
            System.out.println("\n===== SISTEMA LLANQUIHUE TOUR =====");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Buscar cliente por RUT");
            System.out.println("4. Agregar empleado");
            System.out.println("5. Mostrar empleados");
            System.out.println("6. Buscar empleado por RUT");
            System.out.println("7. Modificar cliente");
            System.out.println("8. Modificar empleado");
            System.out.println("9. Filtrar empleados por rol");
            System.out.println("10. Agregar proveedor");
            System.out.println("11. Mostrar proveedores");
            System.out.println("12. Buscar proveedor por RUT");
            System.out.println("13. Modificar proveedor");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        agregarPersona(scanner, personaService, archivoService);
                        break;
                    case 2:
                        personaService.mostrarPersonas();
                        break;
                    case 3:
                        buscarPersona(scanner, personaService);
                        break;
                    case 4:
                        agregarEmpleado(scanner, empleadoService, archivoEmpleadoService);
                        break;
                    case 5:
                        empleadoService.mostrarEmpleados();
                        break;
                    case 6:
                        buscarEmpleado(scanner, empleadoService);
                        break;
                    case 7:
                        modificarPersona(scanner, personaService, archivoService);
                        break;
                    case 8:
                        modificarEmpleado(scanner, empleadoService, archivoEmpleadoService);
                        break;
                    case 9:
                        filtrarEmpleadoPorRol(scanner, empleadoService);
                        break;
                    case 10:
                        agregarProveedor(scanner, proveedorService, archivoProveedorService);
                        break;
                    case 11:
                        proveedorService.mostrarProveedores();
                        break;
                    case 12:
                        buscarProveedor(scanner, proveedorService);
                        break;
                    case 13:
                        modificarProveedor(scanner, proveedorService, archivoProveedorService);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
                opcion = -1;
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void agregarPersona(Scanner scanner,
                                       PersonaService personaService,
                                       ArchivoService archivoService) {

        System.out.println("\n===== AGREGAR CLIENTE =====");

        String rut = pedirRutCliente(scanner, personaService);
        String nombre = pedirNombre(scanner);
        String telefono = pedirTelefono(scanner);
        String email = pedirEmail(scanner);
        Direccion direccion = pedirDireccion(scanner);

        Persona persona = new Persona(rut, nombre, telefono, email, direccion);

        personaService.agregarPersona(persona);
        archivoService.guardarPersona(ARCHIVO_PERSONAS, persona);

        System.out.println("Cliente agregado correctamente.");
    }

    private static void agregarEmpleado(Scanner scanner,
                                        EmpleadoService empleadoService,
                                        ArchivoEmpleadoService archivoEmpleadoService) {

        System.out.println("\n===== AGREGAR EMPLEADO =====");

        String rut = pedirRutEmpleado(scanner, empleadoService);
        String nombre = pedirNombre(scanner);
        String telefono = pedirTelefono(scanner);
        String email = pedirEmail(scanner);
        Direccion direccion = pedirDireccion(scanner);
        String cargo = pedirTexto(scanner, "Ingrese cargo: ");
        double sueldo = pedirSueldo(scanner);

        String rol;

        while (true) {
            System.out.print("Ingrese rol (Guia u Operador): ");
            rol = scanner.nextLine().trim();

            if (!rol.equalsIgnoreCase("Guia") &&
                    !rol.equalsIgnoreCase("Operador")) {
                System.out.println("Rol inválido. Debe ser Guia u Operador.");
                continue;
            }

            break;
        }

        Empleado empleado = new Empleado(
                rut,
                nombre,
                telefono,
                email,
                direccion,
                cargo,
                sueldo,
                rol
        );

        empleadoService.agregarEmpleado(empleado);
        archivoEmpleadoService.guardarEmpleado(ARCHIVO_EMPLEADOS, empleado);

        System.out.println("Empleado agregado correctamente.");
    }

    private static void agregarProveedor(Scanner scanner,
                                         ProveedorService proveedorService,
                                         ArchivoProveedorService archivoProveedorService) {

        System.out.println("\n===== AGREGAR PROVEEDOR =====");

        String rut = pedirRutProveedor(scanner, proveedorService);
        String nombre = pedirNombre(scanner);
        String telefono = pedirTelefono(scanner);
        String email = pedirEmail(scanner);
        Direccion direccion = pedirDireccion(scanner);
        String empresa = pedirTexto(scanner, "Ingrese empresa: ");
        String servicio = pedirTexto(scanner, "Ingrese servicio prestado: ");

        Proveedor proveedor = new Proveedor(
                rut,
                nombre,
                telefono,
                email,
                direccion,
                empresa,
                servicio
        );

        proveedorService.agregarProveedor(proveedor);
        archivoProveedorService.guardarProveedor(ARCHIVO_PROVEEDORES, proveedor);

        System.out.println("Proveedor agregado correctamente.");
    }

    private static void buscarPersona(Scanner scanner,
                                      PersonaService personaService) {

        System.out.println("\n===== BUSCAR CLIENTE =====");
        System.out.print("Ingrese RUT: ");
        String rut = scanner.nextLine();

        Persona encontrada = personaService.buscarPersona(rut);

        if (encontrada != null) {
            System.out.println("\nCliente encontrado:");
            System.out.println(encontrada);
        } else {
            System.out.println("No se encontró un cliente con ese RUT.");
        }
    }

    private static void buscarEmpleado(Scanner scanner,
                                       EmpleadoService empleadoService) {

        System.out.println("\n===== BUSCAR EMPLEADO =====");
        System.out.print("Ingrese RUT: ");
        String rut = scanner.nextLine();

        Empleado encontrado = empleadoService.buscarEmpleado(rut);

        if (encontrado != null) {
            System.out.println("\nEmpleado encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("No se encontró un empleado con ese RUT.");
        }
    }

    private static void buscarProveedor(Scanner scanner,
                                        ProveedorService proveedorService) {

        System.out.println("\n===== BUSCAR PROVEEDOR =====");
        System.out.print("Ingrese RUT: ");
        String rut = scanner.nextLine();

        Proveedor encontrado = proveedorService.buscarProveedor(rut);

        if (encontrado != null) {
            System.out.println("\nProveedor encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("No se encontró un proveedor con ese RUT.");
        }
    }

    private static void modificarPersona(Scanner scanner,
                                         PersonaService personaService,
                                         ArchivoService archivoService) {

        System.out.println("\n===== MODIFICAR CLIENTE =====");

        System.out.print("Ingrese RUT del cliente a modificar: ");
        String rut = scanner.nextLine();

        Persona persona = personaService.buscarPersona(rut);

        if (persona == null) {
            System.out.println("No se encontró un cliente con ese RUT.");
            return;
        }

        System.out.println("\nCliente encontrado:");
        System.out.println(persona);

        String nuevoRut;

        while (true) {
            System.out.print("Ingrese nuevo RUT: ");
            nuevoRut = scanner.nextLine();

            if (Validaciones.rutInvalido(nuevoRut)) {
                continue;
            }

            if (!nuevoRut.equalsIgnoreCase(persona.getRut()) &&
                    Validaciones.rutExiste(personaService.obtenerPersonas(), nuevoRut)) {
                System.out.println("No se puede usar ese RUT porque ya existe.");
                continue;
            }

            break;
        }

        persona.setRut(nuevoRut);
        persona.setNombre(pedirNombre(scanner));
        persona.setTelefono(pedirTelefono(scanner));
        persona.setEmail(pedirEmail(scanner));

        modificarDireccion(scanner, persona.getDireccion());

        archivoService.guardarPersonas(ARCHIVO_PERSONAS, personaService.obtenerPersonas());

        System.out.println("Cliente modificado correctamente.");
    }

    private static void modificarEmpleado(Scanner scanner,
                                          EmpleadoService empleadoService,
                                          ArchivoEmpleadoService archivoEmpleadoService) {

        System.out.println("\n===== MODIFICAR EMPLEADO =====");

        System.out.print("Ingrese RUT del empleado a modificar: ");
        String rut = scanner.nextLine();

        Empleado empleado = empleadoService.buscarEmpleado(rut);

        if (empleado == null) {
            System.out.println("No se encontró un empleado con ese RUT.");
            return;
        }

        System.out.println("\nEmpleado encontrado:");
        System.out.println(empleado);

        empleado.setNombre(pedirNombre(scanner));
        empleado.setTelefono(pedirTelefono(scanner));
        empleado.setEmail(pedirEmail(scanner));

        modificarDireccion(scanner, empleado.getDireccion());

        empleado.setCargo(pedirTexto(scanner, "Ingrese nuevo cargo: "));
        empleado.setSueldo(pedirSueldo(scanner));

        String rol;

        while (true) {
            System.out.print("Ingrese nuevo rol (Guia u Operador): ");
            rol = scanner.nextLine().trim();

            if (!rol.equalsIgnoreCase("Guia") &&
                    !rol.equalsIgnoreCase("Operador")) {
                System.out.println("Rol inválido. Debe ser Guia u Operador.");
                continue;
            }

            break;
        }

        empleado.setRol(rol);

        archivoEmpleadoService.guardarEmpleados(ARCHIVO_EMPLEADOS, empleadoService.obtenerEmpleados());

        System.out.println("Empleado modificado correctamente.");
    }

    private static void modificarProveedor(Scanner scanner,
                                           ProveedorService proveedorService,
                                           ArchivoProveedorService archivoProveedorService) {

        System.out.println("\n===== MODIFICAR PROVEEDOR =====");

        System.out.print("Ingrese RUT del proveedor a modificar: ");
        String rut = scanner.nextLine();

        Proveedor proveedor = proveedorService.buscarProveedor(rut);

        if (proveedor == null) {
            System.out.println("No se encontró un proveedor con ese RUT.");
            return;
        }

        System.out.println("\nProveedor encontrado:");
        System.out.println(proveedor);

        proveedor.setNombre(pedirNombre(scanner));
        proveedor.setTelefono(pedirTelefono(scanner));
        proveedor.setEmail(pedirEmail(scanner));

        // Aquí usamos setDireccion() para que ese setter también quede utilizado.
        proveedor.setDireccion(pedirDireccion(scanner));

        proveedor.setEmpresa(pedirTexto(scanner, "Ingrese nueva empresa: "));
        proveedor.setServicio(pedirTexto(scanner, "Ingrese nuevo servicio: "));

        archivoProveedorService.guardarProveedores(
                ARCHIVO_PROVEEDORES,
                proveedorService.obtenerProveedores()
        );

        System.out.println("Proveedor modificado correctamente.");
    }

    private static void filtrarEmpleadoPorRol(Scanner scanner,
                                              EmpleadoService empleadoService) {

        System.out.println("\n===== FILTRAR EMPLEADOS POR ROL =====");

        String rol;

        while (true) {
            System.out.print("Ingrese rol a filtrar (Guia u Operador): ");
            rol = scanner.nextLine().trim();

            if (!rol.equalsIgnoreCase("Guia") &&
                    !rol.equalsIgnoreCase("Operador")) {
                System.out.println("Rol inválido. Debe ser Guia u Operador.");
                continue;
            }

            break;
        }

        empleadoService.mostrarEmpleadosPorRol(rol);
    }

    private static String pedirRutCliente(Scanner scanner,
                                          PersonaService personaService) {

        String rut;

        while (true) {
            System.out.print("Ingrese RUT (Ej: 12345678-1): ");
            rut = scanner.nextLine();

            if (Validaciones.rutInvalido(rut)) {
                continue;
            }

            if (Validaciones.rutExiste(personaService.obtenerPersonas(), rut)) {
                System.out.println("No se puede registrar. El RUT ya existe.");
                continue;
            }

            break;
        }

        return rut;
    }

    private static String pedirRutEmpleado(Scanner scanner,
                                           EmpleadoService empleadoService) {

        String rut;

        while (true) {
            System.out.print("Ingrese RUT (Ej: 12345678-9): ");
            rut = scanner.nextLine();

            if (Validaciones.rutInvalido(rut)) {
                continue;
            }

            if (empleadoService.rutExisteEmpleado(rut)) {
                System.out.println("No se puede registrar. El RUT ya existe.");
                continue;
            }

            break;
        }

        return rut;
    }

    private static String pedirRutProveedor(Scanner scanner,
                                            ProveedorService proveedorService) {

        String rut;

        while (true) {
            System.out.print("Ingrese RUT (Ej: 12345678-9): ");
            rut = scanner.nextLine();

            if (Validaciones.rutInvalido(rut)) {
                continue;
            }

            if (proveedorService.rutExisteProveedor(rut)) {
                System.out.println("No se puede registrar. El RUT ya existe.");
                continue;
            }

            break;
        }

        return rut;
    }

    private static String pedirNombre(Scanner scanner) {
        String nombre;

        while (true) {
            System.out.print("Ingrese nombre: ");
            nombre = scanner.nextLine();

            if (Validaciones.nombreInvalido(nombre)) {
                continue;
            }

            break;
        }

        return nombre;
    }

    private static String pedirTelefono(Scanner scanner) {
        String telefono;

        while (true) {
            System.out.print("Ingrese telefono (Ej: +56912345678 o 912345678): ");
            telefono = scanner.nextLine();

            if (Validaciones.telefonoInvalido(telefono)) {
                continue;
            }

            break;
        }

        return telefono;
    }

    private static String pedirEmail(Scanner scanner) {
        String email;

        while (true) {
            System.out.print("Ingrese email: ");
            email = scanner.nextLine();

            if (Validaciones.emailInvalido(email)) {
                continue;
            }

            break;
        }

        return email;
    }

    private static Direccion pedirDireccion(Scanner scanner) {
        String calle = pedirTexto(scanner, "Ingrese calle y numero: ");
        String comuna = pedirNombreCampo(scanner, "Ingrese comuna: ");
        String ciudad = pedirNombreCampo(scanner, "Ingrese ciudad: ");

        return new Direccion(calle, comuna, ciudad);
    }

    private static void modificarDireccion(Scanner scanner, Direccion direccion) {
        String calle = pedirTexto(scanner, "Ingrese nueva calle y numero: ");
        String comuna = pedirNombreCampo(scanner, "Ingrese nueva comuna: ");
        String ciudad = pedirNombreCampo(scanner, "Ingrese nueva ciudad: ");

        direccion.setCalle(calle);
        direccion.setComuna(comuna);
        direccion.setCiudad(ciudad);
    }

    private static String pedirTexto(Scanner scanner, String mensaje) {
        String texto;

        while (true) {
            System.out.print(mensaje);
            texto = scanner.nextLine();

            if (texto == null || texto.isBlank()) {
                System.out.println("Este campo no puede estar vacío.");
                continue;
            }

            if (texto.contains(",")) {
                System.out.println("No use comas en este campo.");
                continue;
            }

            break;
        }

        return texto;
    }

    private static String pedirNombreCampo(Scanner scanner, String mensaje) {
        String texto;

        while (true) {
            System.out.print(mensaje);
            texto = scanner.nextLine();

            if (Validaciones.nombreInvalido(texto)) {
                continue;
            }

            break;
        }

        return texto;
    }

    private static double pedirSueldo(Scanner scanner) {
        double sueldo;

        while (true) {
            try {
                System.out.print("Ingrese sueldo: ");
                sueldo = Double.parseDouble(scanner.nextLine());

                if (sueldo <= 0) {
                    System.out.println("El sueldo debe ser mayor a 0.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un sueldo numerico.");
            }
        }

        return sueldo;
    }
}