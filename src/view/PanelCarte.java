/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import controleur.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.*;
import models.Explorateur;
import models.Ingenieur;
import models.Joueur;
import models.Messager;
import models.Navigateur;
import models.Pilote;
import models.Plongeur;
import util.Message;
import util.Tresor;

/**
 *
 * @author Vypz
 */
public class PanelCarte extends JPanel {

    private ArrayList<Carte> ac = new ArrayList();
    private ArrayList<Joueur> aj = new ArrayList();
    private Joueur j;
    private Carte ca;
    private Controleur c;
    private boolean cliquable = false;
    private int x1, l, y1, h;
    private CTresor ct;
    
    public PanelCarte(ArrayList<Joueur> joueurs, Joueur joueur, ArrayList<Carte> cartes, Carte carte, Controleur controleur) {
        j = joueur;
        aj = joueurs;
        ca = carte;
        ac = cartes;
        c = controleur;
        addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (cliquable)
                c.traiterMessage(new Message(Message.TypeMessage.CARTE,ac.indexOf(ca),aj.indexOf(j)));
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //g.setColor(new Color(30,30,30));
        //g.fillRect(0, 0, getWidth(), getHeight());
        setOpaque(true);
        h = (int) getHeight();
        l = (int) (h*49)/69;
        x1 = (int) (getWidth()-l)/2;
        y1 = (int) 1;
        if (ca == null) {
            cliquable = false;
            g.setColor(new Color(70,70,70));
            g.fillRect(x1, y1, l, h);
        }
        
        if (ca != null) {
            try {
                if (ca instanceof CSacSable)
                    g.drawImage(ImageIO.read(Main.class.getResource("/img/cartes/Sac.png")), x1, y1, l, h, this);
                if (ca instanceof CHelico)
                    g.drawImage(ImageIO.read(Main.class.getResource("/img/cartes/Helicoptere.png")), x1, y1, l, h, this);
                if (ca instanceof CTresor) {
                    ct = (CTresor) ca;
                    if (ct.getTresor() == Tresor.Calice)
                        g.drawImage(ImageIO.read(Main.class.getResource("/img/cartes/Calice.png")), x1, y1, l, h, this);
                    if (ct.getTresor() == Tresor.Cristal)
                        g.drawImage(ImageIO.read(Main.class.getResource("/img/cartes/Cristal.png")), x1, y1, l, h, this);
                    if (ct.getTresor() == Tresor.Pierre)
                        g.drawImage(ImageIO.read(Main.class.getResource("/img/cartes/Pierre.png")), x1, y1, l, h, this);
                    if (ct.getTresor() == Tresor.Statue)
                        g.drawImage(ImageIO.read(Main.class.getResource("/img/cartes/Statue.png")), x1, y1, l, h, this);
                }
                g.setColor(Color.black);
                g.drawRect(x1, y1, l-1, h-2);
                g.drawRect(x1+1, y1+1, l-3, h-4);
                
                if (!cliquable) {
                    g.setColor(new Color(150,150,150,150));
                    g.fillRect(x1, y1, l, h);
                }
            } catch (IOException ex) {
                Logger.getLogger(PanelCarte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    /**
     * @param cliquable the cliquable to set
     */
    public void setCliquable(boolean cliquable) {
        this.cliquable = cliquable;
        repaint();
    }
}
