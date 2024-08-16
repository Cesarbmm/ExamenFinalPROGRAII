package UserInterface.Form;

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class ZCMainForm extends JFrame{
    
    ZCDatosPanel    pnlDatos         = new ZCDatosPanel();
    ZCHormigueroPanel pnlHormiguero   = new ZCHormigueroPanel();
    ZCAlimentacionPanel pnlAlimentacion = new ZCAlimentacionPanel();
   

    public ZCMainForm(String titleApp){
        zcCustomizeComponent(titleApp);
    }

    private void zcCustomizeComponent(String titleApp){
        setTitle(titleApp);
        setSize(700, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container zcContainer = getContentPane();
        zcContainer.setLayout(new BorderLayout());
        
        zcContainer.add(pnlDatos, BorderLayout.NORTH);        
        zcContainer.add(pnlHormiguero, BorderLayout.CENTER);
        zcContainer.add(pnlAlimentacion, BorderLayout.SOUTH);  // Añadimos el panel de alimentación en la parte inferior
        

        setVisible(true);
    }
}
