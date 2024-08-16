package UserInterface.Form;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UserInterface.ZCStyle;
import UserInterface.CustomerControl.ZCLabel;

public class ZCDatosPanel extends JPanel{
    private ZCLabel cdLblCedula = new ZCLabel("Cedula:");
    private ZCLabel cdLblNombre = new ZCLabel("Nombre:");
    private JTextField cdTxtCedula = new JTextField("1751381474");
    private JTextField cdTxtNombre = new JTextField("Cesar Zapata");
    private JPanel cdGraySquarePanel = new JPanel();
    
    public ZCDatosPanel(){
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new GridBagLayout());
        setSize(new Dimension(350, 350));
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(5, 5, 5, 5);
        
        cdLblCedula.setFont(ZCStyle.FONT_BOLD);
        cdLblNombre.setFont(ZCStyle.FONT_BOLD);

        cdTxtCedula.setFont(ZCStyle.FONT);
        cdTxtCedula.setPreferredSize(new Dimension(300, 25));
        cdTxtCedula.setEditable(false);
        cdTxtCedula.setHorizontalAlignment(JTextField.CENTER);
        cdTxtCedula.setBorder(BorderFactory.createLineBorder(ZCStyle.COLOR_FONT_LIGHT, 1));
        
        cdTxtNombre.setFont(ZCStyle.FONT);
        cdTxtNombre.setPreferredSize(new Dimension(300, 25));
        cdTxtNombre.setEditable(false);
        cdTxtNombre.setHorizontalAlignment(JTextField.CENTER);
        cdTxtNombre.setBorder(BorderFactory.createLineBorder(ZCStyle.COLOR_FONT_LIGHT, 1));

        cdGraySquarePanel.setBackground(ZCStyle.COLOR_BACKGROUND);
        cdGraySquarePanel.setPreferredSize(new Dimension(600, 100));
        cdGraySquarePanel.setOpaque(true);
        
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 0;
        gbc.insets = new Insets(0, 90, 35, 0);
        add(cdLblCedula, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 300, 35, 0);
        add(cdTxtCedula, gbc);
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 0;
        gbc.insets = new Insets(35, 90, 0, 0);
        add(cdLblNombre, gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 300, 0, 0);
        add(cdTxtNombre, gbc);
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(14, 14, 14, 14);
        add(cdGraySquarePanel, gbc);

    }
}
