public class Usuarios {
    private String nombre;
    private String cedula;
    private String correo;
    private String rol;
    private int fallasRegistradas;


    public Usuarios(String nombre, String cedula, String correo, String rol) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.rol = rol;
        this.fallasRegistradas = 0;
    }
    public Usuarios(String nombre, String cedula, String correo, String rol,int fallasRegistradas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.rol = rol;
        this.fallasRegistradas =fallasRegistradas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public int getFallasRegistradas() {
        return fallasRegistradas;
    }

    public void incrementarFallas() {
        this.fallasRegistradas++;
    }


    @Override
    public String toString() {
        return "Usuario:  " +
                "Nombre= " + nombre +
                ", cedula= " + cedula +
                ", correo= " + correo +
                ", rol= " + rol+
                ", fallasRegistradas=" + fallasRegistradas +
                '}';
    }
}

