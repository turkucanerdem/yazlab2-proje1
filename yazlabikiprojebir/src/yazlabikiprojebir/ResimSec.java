/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* parçalar için skor sistemi kurulucak
parçayı doğru haraket ettirirsen skor artıcak veya düşmeyecek
yanlış haraket ettirirsen azalıcak
bu skorlar txt dosyasına yazılacak
program her açıldığında bu skor bilgisini gösterecek
*/

package yazlabikiprojebir;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author Spike
 */
public class ResimSec extends javax.swing.JFrame {

    /**
     * Creates new form ResimSec
     */
    String imagePath;
    
    private boolean basilmis;
    private JButton buton1;
    private JButton buton2;
    ArrayList<Integer> kullanilan;
    private boolean karistirKontrol; 
    Resim resim;
    int skor;
    
    public ResimSec() throws IOException {
        JFileChooser chooser = new JFileChooser();
    
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        imagePath=chooser.getSelectedFile().getAbsolutePath();
        System.out.println(imagePath);
        initComponents();
        resim=new Resim(imagePath);
        basilmis=false;
        kullanilan=new ArrayList<Integer>();
        karistirKontrol=false;
        skor=100;
    }
    }
    
    void kararver(JButton buton){
        //hangi tıklanma
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
        //butonlardaki imagei değiştiriyor
        Icon butonicon1 = buton1.getIcon();
        Icon butonicon2 = buton2.getIcon();
        buton2.setIcon(butonicon1);
        buton1.setIcon(butonicon2);
        
        boolean isComplete=tumResimKarsilastir();
        if(isComplete){
            System.out.println("bitti");
            System.out.println(skor);
        }
        else{
            skor-=3;
        }
    }
    
    boolean tumResimKarsilastir(){
        
        //tum resim karelerini karşılaştırıyor
        resim.setIsAyniTrue();
        boolean isAyni=true;
        
       ImageIcon butonicon=(ImageIcon) jButton2.getIcon();
       Image image = butonicon.getImage();
       BufferedImage buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,0,0);
       
       butonicon=(ImageIcon) jButton3.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,0,1);
       
       butonicon=(ImageIcon) jButton4.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,0,2);
       
       butonicon=(ImageIcon) jButton5.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,0,3);
       
       butonicon=(ImageIcon) jButton6.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,1,0);
       
       butonicon=(ImageIcon) jButton7.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,1,1);
       
       butonicon=(ImageIcon) jButton8.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,1,2);
       
       butonicon=(ImageIcon) jButton9.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,1,3);
       
       butonicon=(ImageIcon) jButton10.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,2,0);
       
       butonicon=(ImageIcon) jButton11.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,2,1);
       
       butonicon=(ImageIcon) jButton12.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,2,2);
       
       butonicon=(ImageIcon) jButton13.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,2,3);
       
       butonicon=(ImageIcon) jButton14.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,3,0);
       
       butonicon=(ImageIcon) jButton15.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,3,1);
       
       butonicon=(ImageIcon) jButton16.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,3,2);
       
       butonicon=(ImageIcon) jButton17.getIcon();
       image = butonicon.getImage();
       buffimage = (BufferedImage) image;
       isAyni=resim.ResimleriKarsilastir(buffimage,3,3);
       
       return isAyni;
    }
    
    Integer rastgelesec(){
        //rastgele image seçiyor
        Random rands = new Random(); 
        int random = -1; 
        Integer rand= -1;
        
        do{
         random = rands.nextInt(16); 
         rand=random;
         System.out.println(rand);
        }while(kullanilan.contains(rand));
        System.out.println("asil"+rand);
        kullanilan.add(rand);
        return rand;
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Karistir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });

        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });

        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });

        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });

        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });

        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });

        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
        });

        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17)))
                .addContainerGap(913, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton11)
                    .addComponent(jButton10)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15)
                    .addComponent(jButton14)
                    .addComponent(jButton16)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
        //yapılacak: rastgele 0-15 arası bir numara bulunacak ve o bulunan .png resmi butona atılacak, sırasıyla bu işlem tüm butonlar için yapılacak böylece butonlardaki resimler karışmış olacak
        try{
            
            for(int i=0;i<16;i++){
                Integer rast=rastgelesec();
                int r=rast.intValue();
                BufferedImage iconimg=ImageIO.read(new File(r+".png"));
                Icon imgicon= new ImageIcon(iconimg);
                if(r==i+2){
                    karistirKontrol=true;
                }
                
                switch(i) {
                    case 0:
                        jButton2.setIcon(imgicon);
                        break;
                    case 1:
                        jButton3.setIcon(imgicon);
                        break;
                    case 2:
                        jButton4.setIcon(imgicon);
                        break;
                    case 3:
                        jButton5.setIcon(imgicon);
                        break;
                    case 4:
                        jButton6.setIcon(imgicon);
                        break;
                    case 5:
                        jButton7.setIcon(imgicon);
                        break;
                    case 6:
                        jButton8.setIcon(imgicon);
                        break;
                    case 7:
                        jButton9.setIcon(imgicon);
                        break;
                    case 8:
                        jButton10.setIcon(imgicon);
                        break;
                    case 9:
                        jButton11.setIcon(imgicon);
                        break;
                    case 10:
                        jButton12.setIcon(imgicon);
                        break;
                    case 11:
                        jButton13.setIcon(imgicon);
                        break;
                    case 12:
                        jButton14.setIcon(imgicon);
                        break;
                    case 13:
                        jButton15.setIcon(imgicon);
                        break;
                    case 14:
                        jButton16.setIcon(imgicon);
                        break;
                    case 15:
                        jButton17.setIcon(imgicon);
                        break;
                    
                }
                
            }
            kullanilan.clear();
            if(karistirKontrol){
                jButton1.setVisible(false);
            }
            if(tumResimKarsilastir()){
                System.out.println("OYUN BİTTİ ");
            }
        }catch (IOException e) {
                
        }
        /*BufferedImage testimg=null;
        try {
            testimg = ImageIO.read(new File("0.png"));
        } catch (IOException ex) {
            Logger.getLogger(ResimSec.class.getName()).log(Level.SEVERE, null, ex);
        }
        resim.ResimleriKarsilastir(testimg, 0, 0);*/
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        kararver(jButton2);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        kararver(jButton3);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        kararver(jButton4);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        kararver(jButton5);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        kararver(jButton6);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        kararver(jButton7);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        kararver(jButton8);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        kararver(jButton9);
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        kararver(jButton10);
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        kararver(jButton11);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        kararver(jButton12);
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        kararver(jButton13);
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        kararver(jButton14);
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        kararver(jButton15);
    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        kararver(jButton16);
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        kararver(jButton17);
    }//GEN-LAST:event_jButton17MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResimSec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResimSec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResimSec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResimSec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ResimSec().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ResimSec.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
