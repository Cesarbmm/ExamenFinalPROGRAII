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

import DataAccess.DTO.ZCRegionDTO;
import Framework.ZCException;

public class ZCRegionDAO extends ZCSQLiteDataHelper implements IDAO<ZCRegionDTO> {

    @Override
    public boolean create(ZCRegionDTO entity) throws Exception {
        String query = "INSERT INTO Region (nombre, estado) VALUES (?, ?)";
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
    public List<ZCRegionDTO> readAll() throws Exception {
        List<ZCRegionDTO> lst = new ArrayList<>();
        String query = "SELECT idRegion, nombre, estado, fechaCreacion, fechaModifica FROM Region WHERE estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ZCRegionDTO region = new ZCRegionDTO(
                        rs.getInt("idRegion"),
                        rs.getString("nombre"),
                        rs.getString("estado"),
                        rs.getString("fechaCreacion"),
                        rs.getString("fechaModifica")
                );
                lst.add(region);
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ZCRegionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Region SET nombre = ?, estado = ?, fechaModifica = ? WHERE idRegion = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEstado());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdRegion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Region SET estado = 'X' WHERE idRegion = ?";
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
    public ZCRegionDTO readBy(Integer id) throws Exception {
        ZCRegionDTO region = null;
        String query = "SELECT idRegion, nombre, estado, fechaCreacion, fechaModifica FROM Region WHERE estado = 'A' AND idRegion = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                region = new ZCRegionDTO(
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
        return region;
    }
}
