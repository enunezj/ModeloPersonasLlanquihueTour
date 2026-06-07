package MODEL;

// Herencia desde Persona

public class Empleado extends Persona {

    private String cargo;
    private double sueldo;

    public Empleado(String rut, String nombre, String telefono,
                    String email, Direccion direccion,
                    String cargo, double sueldo) {

        super(rut, nombre, telefono, email, direccion);

        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado\n" +
                "Rut: " + getRut() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Telefono: " + getTelefono() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Direccion: " + getDireccion() + "\n" +
                "Cargo: " + cargo + "\n" +
                "Sueldo: $" + sueldo;
    }
}