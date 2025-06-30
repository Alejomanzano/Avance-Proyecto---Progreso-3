public class Mantenimientos {
    private String tipo;
    private String descripcion;
    private String parroquia;
    private String codigoPostal;
    private String estado;
    private String usuarioReporte;
    private String tecnicoAsignado;

    public Mantenimientos(String tipo, String parroquia, String codigoPostal,
                          String descripcion, String estado, String usuarioReporte) {
        this(tipo, parroquia, codigoPostal, descripcion, estado, usuarioReporte, "Pendiente");
    }

    public Mantenimientos(String tipo, String parroquia, String codigoPostal,
                          String descripcion, String estado, String usuarioReporte, String tecnicoAsignado) {
        this.tipo = tipo;
        this.parroquia = parroquia;
        this.codigoPostal = codigoPostal;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioReporte = usuarioReporte;
        this.tecnicoAsignado = tecnicoAsignado;
    }

    // Getters y Setters (igual que en Fallas)
    public String getUsuarioReporte() {
        return usuarioReporte;
    }

    public void setUsuarioReporte(String usuarioReporte) {
        this.usuarioReporte = usuarioReporte;
    }

    public String getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(String tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + "\n" +
                "Ubicación: " + parroquia + " (CP: " + codigoPostal + ")\n" +
                "Descripción: " + descripcion + "\n" +
                "Estado: " + estado + "\n" +
                "Reportado por: " + usuarioReporte + "\n" +
                "Técnico asignado: " + tecnicoAsignado + "\n";
    }
}