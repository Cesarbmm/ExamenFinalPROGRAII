package DataAccess.DTO;

public class ZCAlimentoDTO {
    private Integer idAlimento;
    private String ingestaNativa;
    private String genoAlimento;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public ZCAlimentoDTO() {}

    public ZCAlimentoDTO(Integer idAlimento, String ingestaNativa, String genoAlimento, String estado, String fechaCreacion, String fechaModifica) {
        this.idAlimento = idAlimento;
        this.ingestaNativa = ingestaNativa;
        this.genoAlimento = genoAlimento;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getIngestaNativa() {
        return ingestaNativa;
    }

    public void setIngestaNativa(String ingestaNativa) {
        this.ingestaNativa = ingestaNativa;
    }

    public String getGenoAlimento() {
        return genoAlimento;
    }

    public void setGenoAlimento(String genoAlimento) {
        this.genoAlimento = genoAlimento;
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
                + "\n idAlimento     " + getIdAlimento()
                + "\n ingestaNativa  " + getIngestaNativa()
                + "\n genoAlimento   " + getGenoAlimento()
                + "\n estado         " + getEstado()
                + "\n fechaCreacion  " + getFechaCreacion()
                + "\n fechaModifica  " + getFechaModifica();
    }

    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }
}
