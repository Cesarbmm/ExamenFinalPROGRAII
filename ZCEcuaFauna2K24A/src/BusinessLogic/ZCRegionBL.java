package BusinessLogic;

import java.util.List;
import DataAccess.ZCRegionDAO;
import DataAccess.DTO.ZCRegionDTO;

public class ZCRegionBL {
    private ZCRegionDTO region;
    private ZCRegionDAO rDAO = new ZCRegionDAO();

    public ZCRegionBL() {}

    public List<ZCRegionDTO> getAll() throws Exception {
        List<ZCRegionDTO> lst = rDAO.readAll();
        
        return lst;
    }

    public ZCRegionDTO getBy(int idRegion) throws Exception {
        region = rDAO.readBy(idRegion);
        return region;
    }

    public boolean add(ZCRegionDTO regionDTO) throws Exception {   
        return rDAO.create(regionDTO);
    }

    public boolean update(ZCRegionDTO regionDTO) throws Exception {
        return rDAO.update(regionDTO);
    }

    public boolean delete(int idRegion) throws Exception {
        return rDAO.delete(idRegion);
    }

    // public Integer getRowCount() throws Exception {
    //    
    //     throw new UnsupportedOperationException("Método no implementado.");
    // }
    public String getNombreById(int id) throws Exception {
        return rDAO.readBy(id).getNombre();
    }
    
}
