package BusinessLogic;

import java.util.List;
import DataAccess.ZCProvinciaDAO;
import DataAccess.DTO.ZCProvinciaDTO;

public class ZCProvinciaBL {
    private ZCProvinciaDTO provincia;
    private ZCProvinciaDAO pDAO = new ZCProvinciaDAO();

    public ZCProvinciaBL() {}

    public List<ZCProvinciaDTO> getAll() throws Exception {
        List<ZCProvinciaDTO> lst = pDAO.readAll();
        
        return lst;
    }

    public ZCProvinciaDTO getBy(int idProvincia) throws Exception {
        provincia = pDAO.readBy(idProvincia);
        return provincia;
    }

    public boolean add(ZCProvinciaDTO provinciaDTO) throws Exception {   
        return pDAO.create(provinciaDTO);
    }

    public boolean update(ZCProvinciaDTO provinciaDTO) throws Exception {
        return pDAO.update(provinciaDTO);
    }

    public boolean delete(int idProvincia) throws Exception {
        return pDAO.delete(idProvincia);
    }

    // public Integer getRowCount() throws Exception {
    //     
    //     throw new UnsupportedOperationException("Método no implementado.");
    // }
    public String getNombreById(int id) throws Exception {
        return pDAO.readBy(id).getNombre();
    }
    
}
