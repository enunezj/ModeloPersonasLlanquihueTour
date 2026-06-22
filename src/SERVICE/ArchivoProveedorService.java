package SERVICE;

import MODEL.Direccion;
import MODEL.Proveedor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchivoProveedorService {

    public ArrayList<Proveedor> cargarProveedores(String archivo) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length != 9) {
                    System.out.println("Línea inválida en archivo de proveedores: " + linea);
                    continue;
                }

                proveedores.add(crearProveedor(datos));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo de proveedores. Si es la primera ejecución, se creará al guardar datos.");
        }

        return proveedores;
    }

    public void guardarProveedor(String archivo, Proveedor proveedor) {
        try {
            File file = new File(archivo);

            if (prepararArchivo(file)) {
                return;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            escribirProveedor(bw, proveedor);
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            System.out.println("Error al guardar el proveedor.");
        }
    }

    public void guardarProveedores(String archivo, ArrayList<Proveedor> proveedores) {
        try {
            File file = new File(archivo);

            if (prepararArchivo(file)) {
                return;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));

            for (Proveedor proveedor : proveedores) {
                escribirProveedor(bw, proveedor);
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar el archivo de proveedores.");
        }
    }

    private boolean prepararArchivo(File file) {
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            boolean carpetaCreada = file.getParentFile().mkdirs();

            if (!carpetaCreada) {
                System.out.println("No se pudo crear la carpeta de datos.");
                return true;
            }
        }

        return false;
    }

    private void escribirProveedor(BufferedWriter bw, Proveedor proveedor) throws Exception {
        bw.write(
                proveedor.getRut() + "," +
                        proveedor.getNombre() + "," +
                        proveedor.getTelefono() + "," +
                        proveedor.getEmail() + "," +
                        proveedor.getDireccion().getCalle() + "," +
                        proveedor.getDireccion().getComuna() + "," +
                        proveedor.getDireccion().getCiudad() + "," +
                        proveedor.getEmpresa() + "," +
                        proveedor.getServicio()
        );
    }

    private Proveedor crearProveedor(String[] datos) {
        Direccion direccion = new Direccion(
                datos[4].trim(),
                datos[5].trim(),
                datos[6].trim()
        );

        return new Proveedor(
                datos[0].trim(),
                datos[1].trim(),
                datos[2].trim(),
                datos[3].trim(),
                direccion,
                datos[7].trim(),
                datos[8].trim()
        );
    }
}