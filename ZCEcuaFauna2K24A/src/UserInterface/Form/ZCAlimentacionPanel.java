package UserInterface.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BusinessLogic.ZCAlimentoBL;

public class ZCAlimentacionPanel extends JPanel {
    private JComboBox<String> cbxGenoAlimento, cbxIngestaNativa;
    private JButton btnAlimentarConGenoAlimento, btnAlimentarConIngestaNativa;
    private ZCAlimentoBL zcAlimentacionBL;
    private int selectedHormigaId; 

    public ZCAlimentacionPanel() {
        zcAlimentacionBL = new ZCAlimentoBL();
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new GridLayout(2, 2));

        
        cbxGenoAlimento = new JComboBox<>(new String[]{"<GenoAlimento>", "X", "XX", "XY"});
        cbxIngestaNativa = new JComboBox<>(new String[]{"<IngestaNativa>", "Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro", "Nectarívoros"});

       
        btnAlimentarConGenoAlimento = new JButton("Alimentar con GenoAlimento");
        btnAlimentarConIngestaNativa = new JButton("Alimentar con Ingesta Nativa");

        
        add(cbxGenoAlimento);
        add(btnAlimentarConGenoAlimento);
        add(cbxIngestaNativa);
        add(btnAlimentarConIngestaNativa);

      
        btnAlimentarConGenoAlimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alimentarConGenoAlimento();
            }
        });

        btnAlimentarConIngestaNativa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alimentarConIngestaNativa();
            }
        });
    }

    private void alimentarConGenoAlimento() {
        String genoAlimento = (String) cbxGenoAlimento.getSelectedItem();

        
        if (genoAlimento == null || genoAlimento.equals("<GenoAlimento>")) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un GenoAlimento válido.");
            return;
        }


        if (selectedHormigaId == 0) {
            JOptionPane.showMessageDialog(this, "No hay una hormiga seleccionada para alimentar.");
            return;
        }

        try {
            zcAlimentacionBL.updateGenoAlimento(selectedHormigaId, genoAlimento);
            JOptionPane.showMessageDialog(this, "Hormiga alimentada con: " + genoAlimento);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al alimentar la hormiga: " + ex.getMessage());
        }
    }

    private void alimentarConIngestaNativa() {
        String ingestaNativa = (String) cbxIngestaNativa.getSelectedItem();

    
        if (ingestaNativa == null || ingestaNativa.equals("<IngestaNativa>")) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una Ingesta Nativa válida.");
            return;
        }

        if (selectedHormigaId == 0) {
            JOptionPane.showMessageDialog(this, "No hay una hormiga seleccionada para alimentar.");
            return;
        }

    
        try {
            zcAlimentacionBL.updateIngestaNativa(selectedHormigaId, ingestaNativa);
            JOptionPane.showMessageDialog(this, "Hormiga alimentada con: " + ingestaNativa);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al alimentar la hormiga: " + ex.getMessage());
        }
    }

    public void setSelectedHormigaId(int idHormiga) {
        this.selectedHormigaId = idHormiga;
    }
}
