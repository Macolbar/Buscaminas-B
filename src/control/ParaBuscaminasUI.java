package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import modelo.Casilla;
import modelo.Dificultad;
import modelo.Tablero;
import vista.BuscaminasUI;

public class ParaBuscaminasUI extends BuscaminasUI{
    JButton casillita = null;
 	Tablero tablero = new Tablero(Dificultad.MEDIO);
 	Casilla casilla = new Casilla();
 	
 	
	
	public ParaBuscaminasUI(){
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {

				botones[i][j].addMouseListener(new MouseAdapter() {

					public void mousePressed(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON3)
							new Marcador().marcarCasilla((JButton) e.getSource(), tablero);
						
					}
				});

				botones[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						new Desvelador(tablero).desvelarCasilla((JButton) arg0.getSource());
//						comprobar ganador

					}
				});
			}
		}
	
		

	

	
   }
}
