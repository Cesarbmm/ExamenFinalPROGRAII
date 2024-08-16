package UserInterface.Form;

import java.awt.Color;
//import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

import UserInterface.ZCStyle;

public class ZCSplashForm extends JFrame {

    public ZCSplashForm() {

        setUndecorated(true);
        setSize(240, 240);
        JProgressBar loadingSplash = new JProgressBar(0, 100);
        loadingSplash.setStringPainted(true);
        loadingSplash.setBackground(ZCStyle.COLOR_BACKGROUND);
        loadingSplash.setOpaque(true);
        loadingSplash.setBorderPainted(false);
        loadingSplash.setForeground(ZCStyle.COLOR_FOREGROUND);
        loadingSplash.setFont(ZCStyle.FONT_SMALL);
        loadingSplash.setUI(new BasicProgressBarUI() {
            @Override
            protected Color getSelectionBackground() {
                return ZCStyle.COLOR_FOREGROUND; // Establece el color de la barra de progreso
            }
        });

        ImageIcon icon = new ImageIcon(ZCStyle.URL_SPLASH);
        ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(240, 240, java.awt.Image.SCALE_SMOOTH));
        JLabel logo = new JLabel(scaledIcon);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.CENTER);
        add(logo, BorderLayout.CENTER);
        add(loadingSplash, BorderLayout.SOUTH);
        setLocationRelativeTo(null);

        setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(25); // Espera por 50 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loadingSplash.setValue(i);
        }
        setVisible(false);

    }

}
