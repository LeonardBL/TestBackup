package vuecontroleur;

import javax.swing.*;
import java.awt.*;

public class CombatPreview extends JPanel {

    public int attaqueUnite;
    public int defenseUnite;

    public JPanel panel;

    private JLabel pourcentAttaque = new JLabel();
    private JLabel pourcentDefense = new JLabel();

    public CombatPreview(){
        attaqueUnite = 0;
        defenseUnite = 0;
    }

    // Calcule les pourcentages pour le combat, les mets dans les JLabel et les affiche
    public void calculatePercents(){
        int total = attaqueUnite + defenseUnite;
        double attaquePourcent = (double) attaqueUnite / total;

        pourcentAttaque.setText(Math.round(attaquePourcent * 100) + " %");
        pourcentDefense.setText(Math.round((1 - attaquePourcent) * 100) + " %");

        pourcentAttaque.setLocation(getWidth()-35,getHeight()-35);
        pourcentDefense.setLocation(getWidth()-35,getHeight()-35);

        pourcentAttaque.setFont(new Font("Arial",Font.BOLD,22));
        pourcentDefense.setFont(new Font("Arial",Font.BOLD,22));

        panel.add(pourcentAttaque);
        panel.add(pourcentDefense);
    }

    public void hidePercents(){
        panel.remove(pourcentAttaque);
        panel.remove(pourcentDefense);
    }

}
