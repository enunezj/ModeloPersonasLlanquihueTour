package SERVICE;

import MODEL.Direccion;
import MODEL.Empleado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchivoEmpleadoService {

    public ArrayList<Empleado> cargarEmpleados(String archivo) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length != 10) {
                    System.out.println("Línea inválida en archivo de empleados: " + linea);
                    continue;
                }

                empleados.add(crearEmpleado(datos));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo de empleados. Si es la primera ejecución, se creará al guardar datos.");
        }

        return empleados;
    }

    public void guardarEmpleado(String archivo, Empleado empleado) {
        try {
            File file = new File(archivo);

            if (archivoNoPreparado(file)) {
                return;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            escribirEmpleado(bw, empleado);
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            System.out.println("Error al guardar el empleado.");
        }
    }

    public void guardarEmpleados(String archivo, ArrayList<Empleado> empleados) {
        try {
            File file = new File(archivo);

            if (archivoNoPreparado(file)) {
                return;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));

            for (Empleado empleado : empleados) {
                escribirEmpleado(bw, empleado);
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar el archivo de empleados.");
        }
    }

    private boolean archivoNoPreparado(File file) {
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            boolean carpetaCreada = file.getParentFile().mkdirs();

            if (!carpetaCreada) {
                System.out.println("No se pudo crear la carpeta de datos.");
                return true;
            }
        }

        return false;
    }

    private void escribirEmpleado(BufferedWriter bw, Empleado empleado) throws Exception {
        bw.write(
                empleado.getRut() + "," +
                        empleado.getNombre() + "," +
                        empleado.getTelefono() + "," +
                        empleado.getEmail() + "," +
                        empleado.getDireccion().getCalle() + "," +
                        empleado.getDireccion().getComuna() + "," +
                        empleado.getDireccion().getCiudad() + "," +
                        empleado.getCargo() + "," +
                        empleado.getSueldo() + "," +
                        empleado.getRol()
        );
    }

    private Empleado crearEmpleado(String[] datos) {
        Direccion direccion = new Direccion(
                datos[4].trim(),
                datos[5].trim(),
                datos[6].trim()
        );

        return new Empleado(
                datos[0].trim(),
                datos[1].trim(),
                datos[2].trim(),
                datos[3].trim(),
                direccion,
                datos[7].trim(),
                Double.parseDouble(datos[8].trim()),
                datos[9].trim()
        );
    }
}