package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Dificultad;
import modelo.Tablero;
import utiles.Utiles;
import vista.BuscaminasUI;

public class ParaBuscaminasUI extends BuscaminasUI{
    JButton casillita = null;
    MyActionListener listener = new MyActionListener(this);
 	Tablero tablero = new Tablero(Dificultad.FACIL);
 	Casilla casilla = new Casilla();
 	protected ImageIcon ganador = new ImageIcon(getClass().getResource("/assets/ganador.png"));
 	protected ImageIcon perdedor = new ImageIcon(getClass().getResource("/assets/neh.png")); //esto es para el boton de reinicio
 	//pero primero centremonos en que funcione lo demas y ya veremos si hay tiempo de eso
 	
 	
	
	public ParaBuscaminasUI(){
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
		botones[i][j].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton pulsado = (JButton) e.getSource();
				switch (e.getButton()) {
				case 1:
					new Desvelador(tablero).desvelarCasilla((JButton) e.getSource(), botones);
					
					if(tablero.isPerdedor()){
						contenedor.setBackground(Color.RED);
						//btnReboot.setIcon(perdedor);
						
							for (int i = 0; i < Utiles.DIEZ; i++) {
								for (int j = 0; j < Utiles.DIEZ; j++) {
									new Desvelador(tablero).desvelarCasilla(botones[i][j], botones);
									Coordenada coordenada=new Coordenada(i,j);
									if(tablero.getCasilla(coordenada).isMarcada()||tablero.getCasilla(coordenada).isOculta()){
									botones[i][j].setEnabled(false);
									}
								}
							}
						
						
					}else{
						if(tablero.comprobarGanador(botones)){
							tablero.setGanador(true);
						}
					}
					
					if (tablero.isGanador()) {
						contenedor.setBackground(Color.GREEN);
						for (int i = 0; i < Utiles.DIEZ; i++) {
							for (int j = 0; j < Utiles.DIEZ; j++) {
								botones[i][j].setEnabled(false);
							}
						}
						//btnReboot.setIcon(ganador);
					}
					
					break;
				case 3:
					
					new Marcador().marcarCasilla((JButton) e.getSource(), tablero);
					
					
					break;
				}
			}
		});
		
			}
			}
		
		
		
		

				/*botones[i][j].addMouseListener(new MouseAdapter() {

					public void mousePressed(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON3)
							new Marcador().marcarCasilla((JButton) e.getSource(), tablero);
						
					}
				});

				botones[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						new Desvelador(tablero).desvelarCasilla((JButton) arg0.getSource());
						if (tablero.isGanador()) {
							
							
						}
						if(tablero.isPerdedor()){
							contenedor.setBackground(Color.RED);
								
							
						}
//						comprobar ganador

					}
				});
			}
		}*/
	
		

	

	
   }
	
	



	/*public void rebootGame() { //(prueba, no hacer caso por ahora)
		// TODO Auto-generated method stub
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j].setEnabled(true);
				botones[i][j].setBackground(Color.GRAY);
				
			}
		}
		
	}*/
}
