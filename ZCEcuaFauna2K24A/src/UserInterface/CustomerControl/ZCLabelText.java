package UserInterface.CustomerControl;

import javax.swing.*;

import java.awt.BorderLayout;

import UserInterface.ZCStyle;

public class ZCLabelText extends JPanel {
    private ZCLabel lblEtiqueta = new ZCLabel();
    private ZCTextBox txtContenido = new ZCTextBox();

    public ZCLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(etiqueta, ZCStyle.FONT_SMALL, ZCStyle.COLOR_FONT_LIGHT, ZCStyle.ALIGNMENT_LEFT);

        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
