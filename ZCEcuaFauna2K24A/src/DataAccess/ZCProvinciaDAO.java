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

import DataAccess.DTO.ZCProvinciaDTO;
import Framework.ZCException;

public class ZCProvinciaDAO extends ZCSQLiteDataHelper implements IDAO<ZCProvinciaDTO> {

    @Override
    public boolean create(ZCProvinciaDTO entity) throws Exception {
        String query = "INSERT INTO Provincia (idRegion, nombre, estado) VALUES (?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdRegion());
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getEstado());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<ZCProvinciaDTO> readAll() throws Exception {
        List<ZCProvinciaDTO> lst = new ArrayList<>();
        String query = "SELECT idProvincia, idRegion, nombre, estado, fechaCreacion, fechaModifica FROM Provincia WHERE estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ZCProvinciaDTO provincia = new ZCProvinciaDTO(
                        rs.getInt("idProvincia"),
                        rs.getInt("idRegion"),
                        rs.getString("nombre"),
                        rs.getString("estado"),
                        rs.getString("fechaCreacion"),
                        rs.getString("fechaModifica")
                );
                lst.add(provincia);
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ZCProvinciaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Provincia SET idRegion = ?, nombre = ?, estado = ?, fechaModifica = ? WHERE idProvincia = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdRegion());
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getEstado());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdProvincia());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Provincia SET estado = 'X' WHERE idProvincia = ?";
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
    public ZCProvinciaDTO readBy(Integer id) throws Exception {
        ZCProvinciaDTO provincia = null;
        String query = "SELECT idProvincia, idRegion, nombre, estado, fechaCreacion, fechaModifica FROM Provincia WHERE estado = 'A' AND idProvincia = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                provincia = new ZCProvinciaDTO(
                        rs.getInt("idProvincia"),
                        rs.getInt("idRegion"),
                        rs.getString("nombre"),
                        rs.getString("estado"),
                        rs.getString("fechaCreacion"),
                        rs.getString("fechaModifica")
                );
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return provincia;
        
    }
}
