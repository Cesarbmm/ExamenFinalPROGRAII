// Clase ZCSexoDAO.java
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

import DataAccess.DTO.ZCSexoDTO;
import Framework.ZCException;

public class ZCSexoDAO extends ZCSQLiteDataHelper implements IDAO<ZCSexoDTO> {

    @Override
    public boolean create(ZCSexoDTO entity) throws Exception {
        String query = "INSERT INTO Catalogo (IdCatalogoTipo, Nombre, Descripcion) VALUES (?, ?, ?)";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, 2);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<ZCSexoDTO> readAll() throws Exception {
        List<ZCSexoDTO> lst = new ArrayList<>();
        String query = "SELECT IdCatalogo, IdCatalogoTipo, Nombre, Descripcion, Estado, FechaCreacion, FechaModifica FROM Catalogo WHERE Estado ='A' AND IdCatalogoTipo = 2";
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ZCSexoDTO s = new ZCSexoDTO(
                        rs.getInt(1),    // IdCatalogo
                        rs.getInt(2),    // IdCatalogoTipo
                        rs.getString(3), // Nombre
                        rs.getString(4), // Descripcion
                        rs.getString(5), // Estado
                        rs.getString(6), // FechaCreacion
                        rs.getString(7)  // FechaModifica
                );
                lst.add(s);
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ZCSexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(4, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Catalogo SET Estado = ? WHERE IdCatalogo = ?";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public ZCSexoDTO readBy(Integer id) throws Exception {
        ZCSexoDTO s = new ZCSexoDTO();
        String query = "SELECT IdCatalogo, IdCatalogoTipo, Nombre, Descripcion, Estado, FechaCreacion, FechaModifica FROM Catalogo WHERE Estado ='A' AND IdCatalogoTipo = 2 AND IdCatalogo = " + id;
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                s = new ZCSexoDTO(
                        rs.getInt(1),    // IdCatalogo
                        rs.getInt(2),    // IdCatalogoTipo
                        rs.getString(3), // Nombre
                        rs.getString(4), // Descripcion
                        rs.getString(5), // Estado
                        rs.getString(6), // FechaCreacion
                        rs.getString(7)  // FechaModifica
                );
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return s;
    }

    public Integer getRowCount() throws Exception {
        String query = "SELECT COUNT(*) TotalReg FROM Catalogo WHERE Estado ='A' AND IdCatalogoTipo = 2";
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1); // TotalReg
            }
        } catch (SQLException e) {
            throw new ZCException(e.getMessage(), getClass().getName(), "getRowCount()");
        }
        return 0;
    }
}
