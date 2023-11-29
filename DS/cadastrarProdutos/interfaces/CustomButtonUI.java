package interfaces;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalButtonUI;

public class CustomButtonUI extends MetalButtonUI {
   @Override
   public void update(Graphics g, JComponent c) {
       super.update(g, c);
       if (!c.isEnabled()) {
           c.setBackground(Color.decode("#505050"));
       } else {
    	   c.setBackground(Color.decode("#5B9BD5"));
       }
   }
}
