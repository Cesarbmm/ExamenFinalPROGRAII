package BusinessLogic.Entities;

import DataAccess.DTO.ZCHormigaDTO;
import DataAccess.ZCHormigaDAO;

import java.util.List;

public class ZCHormigaBL {
    private ZCHormigaDAO hDAO;

    public ZCHormigaBL() {
        hDAO = new ZCHormigaDAO();
    }

    public List<ZCHormigaDTO> getAll() throws Exception {
        return hDAO.readAll();
    }

    public ZCHormigaDTO getBy(int idHormiga) throws Exception {
        return hDAO.readBy(idHormiga);
    }

    public boolean add(ZCHormigaDTO hormigaDTO) throws Exception {
        return hDAO.create(hormigaDTO);
    }

    public boolean update(ZCHormigaDTO hormigaDTO) throws Exception {
        return hDAO.update(hormigaDTO);
    }

    public boolean delete(int idHormiga) throws Exception {
        return hDAO.delete(idHormiga);
    }
}
