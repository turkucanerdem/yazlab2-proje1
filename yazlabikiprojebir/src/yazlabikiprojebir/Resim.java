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

/**
 *
 * @author Spike
 */
public class Resim {
    
    BufferedImage img;
    String imgPath;
    int height;
    int width;
    int lilImageHeight;
    int lilImageWidth;
    Resim(String path) throws IOException{
        imgPath=path;
        img = null;
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (IOException e) {
        }
        ResimleriBol();
    }
    
    public void ResimleriBol() throws IOException{
        height=img.getHeight();
        width=img.getWidth();
        
        lilImageHeight=height/4;
        lilImageWidth=width/4;
        int idx = 0;
        for (int x = 0; x < height; x += lilImageHeight) {
            for (int y = 0; y < width; y += lilImageWidth) {
                ImageIO.write(img.getSubimage(y, x, lilImageWidth, lilImageHeight ), "png", new File( idx++ + ".png"));
        }
        }
    }
    
    
}
    
    
