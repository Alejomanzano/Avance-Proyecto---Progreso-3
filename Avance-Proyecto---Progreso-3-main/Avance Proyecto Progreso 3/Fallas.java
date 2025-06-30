public class Fallas {
    private String tipo;
    private String descripcion;
    private String parroquia;
    private String codigoPostal;
    private String Estado;
    private String usuarioReporte;
    private String tecnicoAsignado;  // Cambiado de Encargado a tecnicoAsignado

    public Fallas(String tipo, String parroquia, String codigoPostal,
                  String descripcion, String estado, String usuarioReporte) {
        this(tipo, parroquia, codigoPostal, descripcion, estado, usuarioReporte, "Pendiente");
    }

    public Fallas(String tipo, String parroquia, String codigoPostal,
                  String descripcion, String estado, String usuarioReporte, String tecnicoAsignado) {
        this.tipo = tipo;
        this.parroquia = parroquia;
        this.codigoPostal = codigoPostal;
        this.descripcion = descripcion;
        this.Estado = estado;
        this.usuarioReporte = usuarioReporte;
        this.tecnicoAsignado = tecnicoAsignado;
    }

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
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }



    @Override
    public String toString() {
        return
                "Tipo: " + tipo + "\n" +
                "Ubicación: " + parroquia + " (CP: " + codigoPostal + ")\n" +
                "Descripción: " + descripcion + "\n" +
                "Estado: " + Estado + "\n" +
                "Reportado por: " + usuarioReporte + "\n" +
                "Técnico asignado: " + tecnicoAsignado + "\n" ;
    }
}
