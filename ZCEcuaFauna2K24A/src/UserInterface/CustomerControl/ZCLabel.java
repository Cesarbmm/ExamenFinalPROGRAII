package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
//import javax.swing.text.Style;

import UserInterface.ZCStyle;

public class ZCLabel extends JLabel {

    public ZCLabel() {
        customizeComponent();
    }

    public ZCLabel(String text) {
        setText(text);
        customizeComponent();
    }

    private void customizeComponent() {
        setCustomizeComponent(getText(), ZCStyle.FONT, ZCStyle.COLOR_FONT, ZCStyle.ALIGNMENT_LEFT);
    }

    public void setCustomizeComponent(String text, Font font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(ZCStyle.COLOR_FOREGROUND);
        setHorizontalAlignment(alignment);
        // setIcon(new ImageIcon(iconPath));
    }
}
