package MODEL;

public class Empleado extends Persona {

    private String rol;
    private String cargo;
    private double sueldo;

    public Empleado(String rut,
                    String nombre,
                    String telefono,
                    String email,
                    Direccion direccion,
                    String cargo,
                    double sueldo,
                    String rol) {

        super(rut, nombre, telefono, email, direccion);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Cargo: " + cargo + "\n" +
                "Rol: " + rol + "\n" +
                "Sueldo: $" + sueldo;
    }
}