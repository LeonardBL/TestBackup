package vuecontroleur;

import modele.plateau.Case;

import javax.swing.*;
import java.awt.*;

public class CombatPreview extends JPanel {

    public int attaqueUnite;
    public int defenseUnite;
    public double attaquePourcent;


    public JPanel panel;

    private JLabel pourcentAttaque = new JLabel();
    private JLabel pourcentDefense = new JLabel();

    public Color colorAttaque = new Color(0,0,0);
    public Color colorDefense = new Color(0,0,0);

    public CombatPreview(){
        attaqueUnite = 0;
        defenseUnite = 0;
    }

    // Calcule les pourcentages pour le combat, les met dans les JLabel et les affiche
    public void calculatePercents(Case c1, Case c2){
        int total = attaqueUnite + defenseUnite;

        if(c1.getBiome() == c1.getUnites().getTypePeuple().getTerrainFavori()){
            colorAttaque = new Color(0,200,0);
        }else{
            colorAttaque = new Color(0,0,0);
        }
        if(c2.getBiome() == c2.getUnites().getTypePeuple().getTerrainFavori()){
            colorDefense = new Color(0,200,0);
        }else{
            colorDefense = new Color(0,0,0);
        }

        attaquePourcent = (double) attaqueUnite / total;
    }

    public void showPercents(){
        pourcentAttaque.setText(Math.round(attaquePourcent * 100) + " %");
        pourcentDefense.setText(Math.round((1 - attaquePourcent) * 100) + " %");

        pourcentAttaque.setLocation(getWidth()-35,getHeight()-35);
        pourcentDefense.setLocation(getWidth()-35,getHeight()-35);

        pourcentAttaque.setFont(new Font("Arial",Font.BOLD,22));
        pourcentDefense.setFont(new Font("Arial",Font.BOLD,22));

        pourcentAttaque.setForeground(colorAttaque);
        pourcentDefense.setForeground(colorDefense);

        panel.add(pourcentAttaque);
        panel.add(pourcentDefense);
    }

    public void hidePercents(){
        panel.remove(pourcentAttaque);
        panel.remove(pourcentDefense);
    }

}
