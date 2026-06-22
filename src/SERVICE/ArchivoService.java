package SERVICE;

import MODEL.Direccion;
import MODEL.Persona;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchivoService {

    public ArrayList<Persona> cargarPersonas(String archivo) {
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length != 7) {
                    System.out.println("Línea inválida en archivo: " + linea);
                    continue;
                }

                Direccion direccion = new Direccion(
                        datos[4].trim(),
                        datos[5].trim(),
                        datos[6].trim()
                );

                Persona persona = new Persona(
                        datos[0].trim(),
                        datos[1].trim(),
                        datos[2].trim(),
                        datos[3].trim(),
                        direccion
                );

                personas.add(persona);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo. Si es la primera ejecución, se creará al guardar datos.");
        }

        return personas;
    }

    public void guardarPersona(String archivo, Persona persona) {
        try {
            File file = new File(archivo);

            if (archivoNoPreparado(file)) {
                return;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            escribirPersona(bw, persona);
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            System.out.println("Error al guardar la persona.");
        }
    }

    public void guardarPersonas(String archivo, ArrayList<Persona> personas) {
        try {
            File file = new File(archivo);

            if (archivoNoPreparado(file)) {
                return;
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));

            for (Persona persona : personas) {
                escribirPersona(bw, persona);
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar el archivo de personas.");
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

    private void escribirPersona(BufferedWriter bw, Persona persona) throws Exception {
        bw.write(
                persona.getRut() + "," +
                        persona.getNombre() + "," +
                        persona.getTelefono() + "," +
                        persona.getEmail() + "," +
                        persona.getDireccion().getCalle() + "," +
                        persona.getDireccion().getComuna() + "," +
                        persona.getDireccion().getCiudad()
        );
    }
}