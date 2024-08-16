package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class ZCStyle {

    public static final Color COLOR_FONT = new Color(0x4D4D4D); // Gris oscuro
    public static final Color COLOR_FONT_LIGHT = new Color(0xBFBFBF); // Gris claro
    public static final Color COLOR_FONT_BG = new Color(0xE0E0E0); // Fondo gris claro
    public static final Color COLOR_CURSOR = Color.gray; // Cursor gris
    public static final Color COLOR_BORDER_BUTTON= new Color(0x4D4D4D); // Borde de botón gris oscuro
    public static final Color COLOR_BACKGROUND= new Color(0x7F7F7F); // Fondo gris medio
    public static final Color COLOR_FOREGROUND = new Color(0xD9D9D9); // Primer plano gris claro
    public static final Color COLOR_FOREGROUND_PRESSED = new Color(0xA6A6A6); // Primer plano al presionar gris medio

    public static final Font FONT = new Font("Inconsolata", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("Inconsolata", Font.BOLD | Font.PLAIN, 14);
    public static final Font FONT_BOLD_24 = new Font("Inconsolata", Font.BOLD| Font.PLAIN, 24);
    public static final Font FONT_SMALL = new Font("Inconsolata", Font.PLAIN | Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    //public static final URL URL_FONDO = ZCStyles.class.getResource("/UserInterface/Resources/Img/BGmain.jpg");
    public static final URL URL_FONDO_GENERAL= ZCStyle.class.getResource("/UserInterface/Resources/Img/fondo.jpg");
    //public static final URL URL_BOTON = ZCStyles.class.getResource("/UserInterface/Resources/Img/Button.png");
    public static final URL URL_MAIN = ZCStyle.class.getResource("/UserInterface/Resources/Img/EATypo.png");
    public static final URL URL_HORMIGUERO = ZCStyle.class.getResource("/UserInterface/Resources/Img/HormigueroVirtual.png");
    public static final URL URL_LOGO = ZCStyle.class.getResource("/UserInterface/Resources/Img/Logo.png");
    public static final URL URL_SPLASH = ZCStyle.class.getResource("/UserInterface/Resources/Img/HormigaSplash.png");

    public static final CompoundBorder createBorderRect() {
        return BorderFactory.createCompoundBorder(new LineBorder(Color.lightGray),
                new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "🐶 HORMIGAS", JOptionPane.INFORMATION_MESSAGE);
    }

    public static final void showMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "🦁 HORMIGAS", JOptionPane.OK_CANCEL_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg) {
        return (JOptionPane.showConfirmDialog(null, msg, "🤡 HORMIGAS",
                JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION);
    }
}
