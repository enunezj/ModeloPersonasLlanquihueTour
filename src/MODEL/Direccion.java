package MODEL;

public class Direccion {

    private String calle;
    private String comuna;
    private String ciudad;

    public Direccion(String calle, String comuna, String ciudad) {
        this.calle = calle;
        this.comuna = comuna;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return calle + ", " + comuna + ", " + ciudad;
    }
}