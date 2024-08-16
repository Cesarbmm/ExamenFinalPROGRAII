package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import UserInterface.ZCStyle;

public class ZCButton extends JButton implements MouseListener {

    public ZCButton(String text) {
        customizeComponent(text);
    }

    public ZCButton(String text, String iconPath) {
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath) {

        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20);

        setIcon(new ImageIcon(iconPath));
        setFont(ZCStyle.FONT);
    }

    public void customizeComponent(String text) {
        setText(text);
        setOpaque(true);
        setFocusPainted(false);
        setBorderPainted(false);

        setContentAreaFilled(true);
        setForeground(ZCStyle.COLOR_FONT);
        setHorizontalAlignment(ZCStyle.ALIGNMENT_LEFT);
        setFont(ZCStyle.FONT);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        setForeground(Color.BLACK);
        setCursor(ZCStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(ZCStyle.CURSOR_DEFAULT);
    }

}
