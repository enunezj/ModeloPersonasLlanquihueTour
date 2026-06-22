package SERVICE;

import MODEL.Proveedor;
import UTIL.Validaciones;

import java.util.ArrayList;

public class ProveedorService {

    private final ArrayList<Proveedor> proveedores;

    public ProveedorService() {
        proveedores = new ArrayList<>();
    }

    public void agregarProveedor(Proveedor proveedor) {
        if (proveedor == null) return;

        if (Validaciones.rutInvalido(proveedor.getRut())) return;
        if (Validaciones.nombreInvalido(proveedor.getNombre())) return;
        if (Validaciones.telefonoInvalido(proveedor.getTelefono())) return;
        if (Validaciones.emailInvalido(proveedor.getEmail())) return;

        if (rutExisteProveedor(proveedor.getRut())) {
            System.out.println("No se agregó. Ya existe un proveedor con ese RUT.");
            return;
        }

        proveedores.add(proveedor);
    }

    public void mostrarProveedores() {
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }

        System.out.println("\n===== LISTADO DE PROVEEDORES =====");

        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor);
            System.out.println("----------------------------");
        }
    }

    public Proveedor buscarProveedor(String rut) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getRut().equalsIgnoreCase(rut)) {
                return proveedor;
            }
        }

        return null;
    }

    public boolean rutExisteProveedor(String rut) {
        return buscarProveedor(rut) != null;
    }

    public ArrayList<Proveedor> obtenerProveedores() {
        return proveedores;
    }
}