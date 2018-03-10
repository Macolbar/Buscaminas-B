package control;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import modelo.Tablero;
import vista.BuscaminasUI;

public class ParaBuscaminasUI extends BuscaminasUI{
 	Buscaminas mimi = new Buscaminas();
 	Tablero control = new Tablero(null);
	
	public ParaBuscaminasUI(){
	
	for (int i = 0; i < botones.length; i++){
		for (int j = 0; j < botones.length; j++) {
			
			
			botones[i][j].addMouseListener(new MouseAdapter(){

				public void mouseClicked(MouseEvent e) {
					JButton pulsado = (JButton) e.getSource();
					switch (e.getButton()) {
					case 1:
//						System.out.println("boton izquierda");
//						getAlrededor() 
						
						pulsado.setBackground(Color.GRAY);
						
		
						pulsado.setText("5");
						oculta = !oculta;
						
						break;
					case 3:
						// System.out.println("boton derecho");
						if (oculta) {
							// pulsado.setText("X");
							pulsado.setIcon(bandera);
						} else {
							// pulsado.setText("");
							
							pulsado.setIcon(null);
							
						}
						
						break;
					}
				}
			
			});
		}
		}
	

	
   }
}
