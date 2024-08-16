package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.ZCPaisDTO;
import Framework.ZCException;

public class ZCPaisDAO extends ZCSQLiteDataHelper implements IDAO<ZCPaisDTO> {

    @Override
    public boolean create(ZCPaisDTO entity) throws Exception {
        String query = "INSERT INTO Pais (nombre, estado) VALUES (?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEstado());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<ZCPaisDTO> readAll() throws Exception {
        List<ZCPaisDTO> lst = new ArrayList<>();
        String query = "SELECT idPais, nombre, estado, fechaCreacion, fechaModifica FROM Pais WHERE estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ZCPaisDTO pais = new ZCPaisDTO(
                        rs.getInt("idPais"),
                        rs.getString("nombre"),
                        rs.getString("estado"),
                        rs.getString("fechaCreacion"),
                        rs.getString("fechaModifica")
                );
                lst.add(pais);
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ZCPaisDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Pais SET nombre = ?, estado = ?, fechaModifica = ? WHERE idPais = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEstado());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdPais());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Pais SET estado = 'X' WHERE idPais = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public ZCPaisDTO readBy(Integer id) throws Exception {
        ZCPaisDTO pais = null;
        String query = "SELECT idPais, nombre, estado, fechaCreacion, fechaModifica FROM Pais WHERE estado = 'A' AND idPais = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pais = new ZCPaisDTO(
                        rs.getInt("idPais"),
                        rs.getString("nombre"),
                        rs.getString("estado"),
                        rs.getString("fechaCreacion"),
                        rs.getString("fechaModifica")
                );
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return pais;
    }
}
