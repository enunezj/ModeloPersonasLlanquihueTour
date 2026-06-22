package MODEL;

public class Proveedor extends Persona {

    private String empresa;
    private String servicio;

    public Proveedor(String rut, String nombre, String telefono, String email,
                     Direccion direccion, String empresa, String servicio) {

        super(rut, nombre, telefono, email, direccion);
        this.empresa = empresa;
        this.servicio = servicio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Empresa: " + empresa + "\n" +
                "Servicio: " + servicio;
    }
}