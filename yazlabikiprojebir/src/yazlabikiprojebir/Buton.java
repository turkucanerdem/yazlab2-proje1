/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlabikiprojebir;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author teddybear01
 */
public class Buton {
    
    private boolean basilmis;
    private JButton buton1;
    private JButton buton2;
    
    Buton(){
        basilmis=false;
    }
    
    void kararver(JButton buton){
        if(!basilmis){
            buton1=buton;
            basilmis=true;
        }
        else{
            buton2=buton;
            basilmis=false;
            degistir();
        }
    }
    
    void degistir(){
        Icon butonicon1 = buton1.getIcon();
        Icon butonicon2 = buton2.getIcon();
        buton2.setIcon(butonicon1);
        buton1.setIcon(butonicon2);
            
    }
}
