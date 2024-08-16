package DataAccess.DTO;

public class ZCPaisDTO {
    private Integer idPais;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public ZCPaisDTO() {}

    public ZCPaisDTO(Integer idPais, String nombre, String estado, String fechaCreacion, String fechaModifica) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getName()
                + "\n idPais          " + getIdPais()
                + "\n nombre          " + getNombre()
                + "\n estado          " + getEstado()
                + "\n fechaCreacion   " + getFechaCreacion()
                + "\n fechaModifica   " + getFechaModifica();
    }
}
