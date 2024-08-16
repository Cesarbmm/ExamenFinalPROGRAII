package UserInterface.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BusinessLogic.Entities.ZCHormigaBL;
import BusinessLogic.ZCSexoBL;
import BusinessLogic.ZCProvinciaBL;
import DataAccess.DTO.ZCHormigaDTO;
import UserInterface.ZCStyle;
import java.awt.*;
import java.util.List;

public class ZCHormigueroPanel extends JPanel {
    private JTable hormigaTable;
    private DefaultTableModel hormigaTableModel;
    private JButton btnCrear, btnGuardar, btnEliminar;
    private ZCHormigaBL zcHormigaBL;
    private ZCSexoBL zcSexoBL;
    private ZCProvinciaBL zcProvinciaBL;
    private JTextField txtTipoHormiga, txtUbicacion, txtSexo, txtEstado;
    private JLabel messageLabel;

    public ZCHormigueroPanel() {
        zcHormigaBL = new ZCHormigaBL();
        zcSexoBL = new ZCSexoBL();
        zcProvinciaBL = new ZCProvinciaBL();
        initializeComponents();
        loadData();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel logo = new JLabel(new ImageIcon(ZCStyle.URL_HORMIGUERO)); 
        topPanel.add(logo, BorderLayout.WEST);

        btnCrear = new JButton("Crear hormiga larva");
        topPanel.add(btnCrear, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Configuración de la tabla
        String[] columnNames = {"ID", "Tipo de Hormiga", "Ubicación", "Sexo", "Estado"};
        hormigaTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Las celdas no son editables
            }
        };
        hormigaTable = new JTable(hormigaTableModel);
        add(new JScrollPane(hormigaTable), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        txtTipoHormiga = new JTextField();
        txtUbicacion = new JTextField(); // Asumido como nombre de la provincia
        txtSexo = new JTextField(); // Asumido como nombre del sexo
        txtEstado = new JTextField();

        formPanel.add(new JLabel("Tipo Hormiga:"));
        formPanel.add(txtTipoHormiga);
        formPanel.add(new JLabel("Ubicación:"));
        formPanel.add(txtUbicacion);
        formPanel.add(new JLabel("Sexo:"));
        formPanel.add(txtSexo);
        formPanel.add(new JLabel("Estado:"));
        formPanel.add(txtEstado);

        bottomPanel.add(formPanel, BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        btnGuardar = new JButton("Guardar");
        btnEliminar = new JButton("Eliminar");

        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnEliminar);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        messageLabel = new JLabel();
        bottomPanel.add(messageLabel, BorderLayout.NORTH);

        add(bottomPanel, BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> confirmarCrearHormiga());
        btnGuardar.addActionListener(e -> guardarHormiga());
        btnEliminar.addActionListener(e -> eliminarHormiga());
    }

    private void confirmarCrearHormiga() {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de crear una hormiga larva?", "Confirmar creación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            crearHormiga();
        }
    }

    private void crearHormiga() {
        txtTipoHormiga.setText("");
        txtUbicacion.setText("");
        txtSexo.setText("");
        txtEstado.setText("");
        messageLabel.setText("Ingrese los datos para la nueva hormiga larva.");
    }

    private void guardarHormiga() {
        try {
            String tipoHormiga = txtTipoHormiga.getText();
            String ubicacion = txtUbicacion.getText(); // Asumido como nombre de la provincia
            String sexo = txtSexo.getText(); // Asumido como nombre del sexo
            String estado = txtEstado.getText();

            // Obtener ID de provincia y sexo basado en los nombres ingresados
            // Integer idProvincia = zcProvinciaBL.getBy(provincia); 
            // Integer idSexo = zcSexoBL.getBy(sexo);

            // if (idProvincia == null || idSexo == null) {
            //     messageLabel.setText("Ubicación o Sexo no válidos.");
            //     return;
            // }

            ZCHormigaDTO hormigaDTO = new ZCHormigaDTO();
            hormigaDTO.setTipoHormiga(tipoHormiga);
            // hormigaDTO.setIdProvincia(idProvincia); 
            // hormigaDTO.setIdSexo(idSexo);
            hormigaDTO.setEstado(estado);

            boolean exito = zcHormigaBL.add(hormigaDTO);
            if (exito) {
                messageLabel.setText("Hormiga guardada con éxito.");
                // Cargar la ID generada y añadir la fila a la tabla
                hormigaDTO = zcHormigaBL.getBy(hormigaDTO.getIdHormiga()); // Obtener el objeto guardado por su ID
                hormigaTableModel.addRow(new Object[]{
                        hormigaDTO.getIdHormiga(),
                        hormigaDTO.getTipoHormiga(),
                        zcProvinciaBL.getNombreById(hormigaDTO.getIdProvincia()),
                        zcSexoBL.getNombreById(hormigaDTO.getIdSexo()),
                        hormigaDTO.getEstado()
                });
            } else {
                messageLabel.setText("No se pudo guardar la hormiga.");
            }
        } catch (Exception ex) {
            messageLabel.setText("Error al guardar la hormiga.");
            ex.printStackTrace();
        }
    }

    private void eliminarHormiga() {
        int selectedRow = hormigaTable.getSelectedRow();
        if (selectedRow != -1) {
            Integer idHormiga = (Integer) hormigaTableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar esta hormiga?", "Eliminar hormiga", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    boolean exito = zcHormigaBL.delete(idHormiga);
                    if (exito) {
                        messageLabel.setText("Hormiga eliminada con éxito.");
                        hormigaTableModel.removeRow(selectedRow);
                    } else {
                        messageLabel.setText("No se pudo eliminar la hormiga.");
                    }
                } catch (Exception e) {
                    messageLabel.setText("Error al eliminar la hormiga.");
                    e.printStackTrace();
                }
            }
        } else {
            messageLabel.setText("Selecciona una hormiga para eliminar.");
        }
    }

    private void loadData() {
        try {
            List<ZCHormigaDTO> hormigas = zcHormigaBL.getAll();
            for (ZCHormigaDTO hormiga : hormigas) {
                hormigaTableModel.addRow(new Object[]{
                        hormiga.getIdHormiga(),
                        hormiga.getTipoHormiga(),
                        zcProvinciaBL.getNombreById(hormiga.getIdProvincia()),
                        zcSexoBL.getNombreById(hormiga.getIdSexo()),
                        hormiga.getEstado()
                });
            }
        } catch (Exception e) {
            messageLabel.setText("Error al cargar las hormigas.");
            e.printStackTrace();
        }
    }
}
