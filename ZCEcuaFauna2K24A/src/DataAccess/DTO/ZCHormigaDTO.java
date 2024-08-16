package DataAccess.DTO;

public class ZCHormigaDTO {
    private Integer idHormiga;
    private String tipoHormiga;
    private Integer idSexo;
    private Integer idProvincia;
    private Integer idAlimento;
    private String ingestaNativa;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }

    public String getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
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

    public ZCHormigaDTO() {}

    public ZCHormigaDTO(Integer idHormiga, String tipoHormiga, Integer idSexo, Integer idProvincia,
            Integer idAlimento, String ingestaNativa, String estado, String fechaCreacion,
            String fechaModifica) {
        this.idHormiga = idHormiga;
        this.tipoHormiga = tipoHormiga;
        this.idSexo = idSexo;
        this.idProvincia = idProvincia;
        this.idAlimento = idAlimento;
        this.ingestaNativa = ingestaNativa;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getName()
                + "\n idHormiga     " + getIdHormiga()
                + "\n tipoHormiga   " + getTipoHormiga()
                + "\n idSexo        " + getIdSexo()
                + "\n idProvincia   " + getIdProvincia()
                + "\n idAlimento    " + getIdAlimento()
                + "\n ingestaNativa " + getIngestaNativa()
                + "\n estado        " + getEstado()
                + "\n fechaCreacion " + getFechaCreacion()
                + "\n fechaModifica " + getFechaModifica();
    }
}
