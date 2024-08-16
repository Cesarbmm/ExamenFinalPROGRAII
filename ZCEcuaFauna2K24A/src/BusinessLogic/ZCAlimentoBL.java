package BusinessLogic;

import DataAccess.ZCAlimentoDAO;
import DataAccess.DTO.ZCAlimentoDTO;
import java.util.List;


public class ZCAlimentoBL {
    private ZCAlimentoDTO alimento;
    private ZCAlimentoDAO aDAO = new ZCAlimentoDAO();

    public ZCAlimentoBL() {}

    public boolean updateGenoAlimento(int idAlimento, String genoAlimento) throws Exception {
        alimento = aDAO.readBy(idAlimento);
        if (alimento != null) {
            alimento.setGenoAlimento(genoAlimento);
            return aDAO.update(alimento);
        }
        return false;
    }

    public boolean updateIngestaNativa(int idAlimento, String ingestaNativa) throws Exception {
        alimento = aDAO.readBy(idAlimento);
        if (alimento != null) {
            alimento.setIngestaNativa(ingestaNativa);
            return aDAO.update(alimento);
        }
        return false;
    }

    public List<ZCAlimentoDTO> getAll() throws Exception {
        List<ZCAlimentoDTO> lst = aDAO.readAll();
        for (ZCAlimentoDTO alimentoDTO : lst) {
            alimentoDTO.setIngestaNativa(alimentoDTO.getIngestaNativa().toUpperCase());
            alimentoDTO.setGenoAlimento(alimentoDTO.getGenoAlimento().toUpperCase());
        }
        return lst;
    }

    public ZCAlimentoDTO getBy(int idAlimento) throws Exception {
        alimento = aDAO.readBy(idAlimento);
        return alimento;
    }

    public boolean add(ZCAlimentoDTO alimentoDTO) throws Exception {   
        return aDAO.create(alimentoDTO);
    }

    public boolean update(ZCAlimentoDTO alimentoDTO) throws Exception {
        return aDAO.update(alimentoDTO);
    }

    public boolean delete(int idAlimento) throws Exception {
        return aDAO.delete(idAlimento);
    }

    public Integer getRowCount() throws Exception {
        throw new UnsupportedOperationException("Método no implementado.");
    }

    public String getNombreById(int id) throws Exception {
        return aDAO.readBy(id).getNombre();
    }
}
