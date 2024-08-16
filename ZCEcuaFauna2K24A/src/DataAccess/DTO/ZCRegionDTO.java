package DataAccess.DTO;

public class ZCRegionDTO {
    private Integer idRegion;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public ZCRegionDTO() {}

    public ZCRegionDTO(Integer idRegion, String nombre, String estado, String fechaCreacion, String fechaModifica) {
        this.idRegion = idRegion;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
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
                + "\n idRegion        " + getIdRegion()
                + "\n nombre          " + getNombre()
                + "\n estado          " + getEstado()
                + "\n fechaCreacion   " + getFechaCreacion()
                + "\n fechaModifica   " + getFechaModifica();
    }
}
