package UserInterface.CustomerControl;

import javax.swing.ImageIcon;

import UserInterface.ZCStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ZCLabelLink extends ZCLabel implements MouseListener {

    public ZCLabelLink(String text) {
        super(text);
        setPersonalizacion();
    }

    public ZCLabelLink(String text, String iconPath) {
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }

    void setPersonalizacion() {
        addMouseListener(this);
        setOpaque(false);
        setForeground(ZCStyle.COLOR_FONT);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(ZCStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(ZCStyle.CURSOR_DEFAULT);
    }

}
