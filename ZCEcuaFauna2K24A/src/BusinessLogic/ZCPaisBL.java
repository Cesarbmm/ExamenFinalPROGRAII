package BusinessLogic;

import java.util.List;
import DataAccess.ZCPaisDAO;
import DataAccess.DTO.ZCPaisDTO;

public class ZCPaisBL {
    private ZCPaisDTO pais;
    private ZCPaisDAO pDAO = new ZCPaisDAO();

    public ZCPaisBL() {}

    public List<ZCPaisDTO> getAll() throws Exception {
        List<ZCPaisDTO> lst = pDAO.readAll();
        
        return lst;
    }

    public ZCPaisDTO getBy(int idPais) throws Exception {
        pais = pDAO.readBy(idPais);
        return pais;
    }

    public boolean add(ZCPaisDTO paisDTO) throws Exception {   
        return pDAO.create(paisDTO);
    }

    public boolean update(ZCPaisDTO paisDTO) throws Exception {
        return pDAO.update(paisDTO);
    }

    public boolean delete(int idPais) throws Exception {
        return pDAO.delete(idPais);
    }

    // public Integer getRowCount() throws Exception {
    //  
    //     throw new UnsupportedOperationException("Método no implementado.");
    // }
    public String getNombreById(int id) throws Exception {
        return pDAO.readBy(id).getNombre();
    }
    
}
