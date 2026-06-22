package SERVICE;

import MODEL.Persona;
import UTIL.Validaciones;

import java.util.ArrayList;

public class PersonaService {

    private final ArrayList<Persona> personas;

    public PersonaService() {
        personas = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) {
        if (persona == null) {
            return;
        }

        if (personaInvalida(persona)) {
            return;
        }

        if (Validaciones.rutExiste(personas, persona.getRut())) {
            System.out.println("No se agregó. Ya existe una persona con el RUT: " + persona.getRut());
            return;
        }

        personas.add(persona);
    }

    public void mostrarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        System.out.println("\n===== LISTADO DE PERSONAS =====");

        for (Persona persona : personas) {
            System.out.println(persona);
            System.out.println("----------------------------");
        }
    }

    public Persona buscarPersona(String rut) {
        for (Persona persona : personas) {
            if (persona.getRut().equalsIgnoreCase(rut)) {
                return persona;
            }
        }

        return null;
    }

    public ArrayList<Persona> obtenerPersonas() {
        return personas;
    }

    private boolean personaInvalida(Persona persona) {
        return Validaciones.rutInvalido(persona.getRut()) ||
                Validaciones.nombreInvalido(persona.getNombre()) ||
                Validaciones.telefonoInvalido(persona.getTelefono()) ||
                Validaciones.emailInvalido(persona.getEmail());
    }
}