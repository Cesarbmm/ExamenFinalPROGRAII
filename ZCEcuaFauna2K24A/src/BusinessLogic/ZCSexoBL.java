package BusinessLogic;

import java.util.List;
import DataAccess.ZCSexoDAO;
import DataAccess.DTO.ZCSexoDTO;

public class ZCSexoBL {
    private ZCSexoDTO sexo;
    private ZCSexoDAO sDAO = new ZCSexoDAO();

    public ZCSexoBL() {}

    public List<ZCSexoDTO> getAll() throws Exception {
        List<ZCSexoDTO> lst = sDAO.readAll();
        for (ZCSexoDTO sexoDTO : lst) {
           
            sexoDTO.setNombre(sexoDTO.getNombre().toUpperCase());
        }
        return lst;
    }

    public ZCSexoDTO getBy(int idSexo) throws Exception {
        sexo = sDAO.readBy(idSexo);
        return sexo;
    }

    public boolean add(ZCSexoDTO sexoDTO) throws Exception {   
        return sDAO.create(sexoDTO);
    }

    public boolean update(ZCSexoDTO sexoDTO) throws Exception {
        return sDAO.update(sexoDTO);
    }

    public boolean delete(int idSexo) throws Exception {
        return sDAO.delete(idSexo);
    }

    public Integer getRowCount() throws Exception {
        return sDAO.getRowCount();
    }

    public String getNombreById(int id) throws Exception {
        return sDAO.readBy(id).getNombre();
    }
    
}
