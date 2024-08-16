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

import DataAccess.DTO.ZCHormigaDTO;
import Framework.ZCException;

public class ZCHormigaDAO extends ZCSQLiteDataHelper implements IDAO <ZCHormigaDTO> {

    @Override
    public boolean create(ZCHormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String query = "INSERT INTO Hormiga (TipoHormiga, IdSexo, IdProvincia, IdAlimento, IngestaNativa, Estado, FechaCreacion, FechaModifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getTipoHormiga());
            pstmt.setInt(2, entity.getIdSexo());
            pstmt.setInt(3, entity.getIdProvincia());
            pstmt.setInt(4, entity.getIdAlimento());
            pstmt.setString(5, entity.getIngestaNativa());
            pstmt.setString(6, "A");  // Estado activo por defecto
            pstmt.setString(7, dtf.format(LocalDateTime.now()));
            pstmt.setString(8, dtf.format(LocalDateTime.now()));
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
           throw new ZCException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<ZCHormigaDTO> readAll() throws Exception {
        List<ZCHormigaDTO> lst = new ArrayList<>();
        String query = "SELECT IdHormiga, TipoHormiga, IdSexo, IdProvincia, IdAlimento, IngestaNativa, Estado, FechaCreacion, FechaModifica FROM Hormiga WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ZCHormigaDTO s = new ZCHormigaDTO(
                    rs.getInt(1),  // IdHormiga
                    rs.getString(2),  // TipoHormiga
                    rs.getInt(3),  // IdSexo
                    rs.getInt(4),  // IdProvincia
                    rs.getInt(5),  // IdAlimento
                    rs.getString(6),  // IngestaNativa
                    rs.getString(7),  // Estado
                    rs.getString(8),  // FechaCreacion
                    rs.getString(9)   // FechaModifica
                );
                lst.add(s);
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ZCHormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String query = "UPDATE Hormiga SET TipoHormiga = ?, IdSexo = ?, IdProvincia = ?, IdAlimento = ?, IngestaNativa = ?, FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getTipoHormiga());
            pstmt.setInt(2, entity.getIdSexo());
            pstmt.setInt(3, entity.getIdProvincia());
            pstmt.setInt(4, entity.getIdAlimento());
            pstmt.setString(5, entity.getIngestaNativa());
            pstmt.setString(6, dtf.format(LocalDateTime.now()));
            pstmt.setInt(7, entity.getIdHormiga());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Hormiga SET Estado = ? WHERE IdHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "I");  // Cambia a estado inactivo
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
    @Override
public ZCHormigaDTO readBy(Integer id) throws Exception {
    ZCHormigaDTO hormiga = null;
    String query = "SELECT IdHormiga, TipoHormiga, IdSexo, IdProvincia, IdAlimento, IngestaNativa, Estado, FechaCreacion, FechaModifica FROM Hormiga WHERE IdHormiga = ? AND Estado = 'A'";
    
    try {
        Connection conn = openConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            hormiga = new ZCHormigaDTO(
                rs.getInt(1),  // IdHormiga
                rs.getString(2),  // TipoHormiga
                rs.getInt(3),  // IdSexo
                rs.getInt(4),  // IdProvincia
                rs.getInt(5),  // IdAlimento
                rs.getString(6),  // IngestaNativa
                rs.getString(7),  // Estado
                rs.getString(8),  // FechaCreacion
                rs.getString(9)   // FechaModifica
            );
        }
    } catch (SQLException e) {
        throw new ZCException(e.getMessage(), getClass().getName(), "readBy()");
    }

    return hormiga;
}

}
