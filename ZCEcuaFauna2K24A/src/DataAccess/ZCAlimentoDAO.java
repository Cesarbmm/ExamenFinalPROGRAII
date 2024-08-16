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

import DataAccess.DTO.ZCAlimentoDTO;
import Framework.ZCException;

public class ZCAlimentoDAO extends ZCSQLiteDataHelper implements IDAO<ZCAlimentoDTO> {

    @Override
    public boolean create(ZCAlimentoDTO entity) throws Exception {
        String query = "INSERT INTO Alimento (ingestaNativa, genoAlimento, estado) VALUES (?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getIngestaNativa());
            pstmt.setString(2, entity.getGenoAlimento());
            pstmt.setString(3, entity.getEstado());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<ZCAlimentoDTO> readAll() throws Exception {
        List<ZCAlimentoDTO> lst = new ArrayList<>();
        String query = "SELECT idAlimento, ingestaNativa, genoAlimento, estado, fechaCreacion, fechaModifica FROM Alimento WHERE estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ZCAlimentoDTO alimento = new ZCAlimentoDTO(
                        rs.getInt("idAlimento"),
                        rs.getString("ingestaNativa"),
                        rs.getString("genoAlimento"),
                        rs.getString("estado"),
                        rs.getString("fechaCreacion"),
                        rs.getString("fechaModifica")
                );
                lst.add(alimento);
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ZCAlimentoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Alimento SET ingestaNativa = ?, genoAlimento = ?, estado = ?, fechaModifica = ? WHERE idAlimento = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getIngestaNativa());
            pstmt.setString(2, entity.getGenoAlimento());
            pstmt.setString(3, entity.getEstado());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Alimento SET estado = 'X' WHERE idAlimento = ?";
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
    public ZCAlimentoDTO readBy(Integer id) throws Exception {
        ZCAlimentoDTO alimento = null;
        String query = "SELECT idAlimento, ingestaNativa, genoAlimento, estado, fechaCreacion, fechaModifica FROM Alimento WHERE estado = 'A' AND idAlimento = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                alimento = new ZCAlimentoDTO(
                        rs.getInt("idAlimento"),
                        rs.getString("ingestaNativa"),
                        rs.getString("genoAlimento"),
                        rs.getString("estado"),
                        rs.getString("fechaCreacion"),
                        rs.getString("fechaModifica")
                );
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return alimento;
    }
}
