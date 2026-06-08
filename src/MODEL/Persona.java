package MODEL;

public class Persona {

    private String rut;
    private String nombre;
    private String telefono;
    private String email;
    private Direccion direccion;

    public Persona(String rut, String nombre, String telefono, String email, Direccion direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Rut: " + rut + "\n" +
                "Nombre: " + nombre + "\n" +
                "Telefono: " + telefono + "\n" +
                "Email: " + email + "\n" +
                "Direccion: " + direccion;
    }
}