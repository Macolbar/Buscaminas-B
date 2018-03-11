package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import modelo.Dificultad;
import modelo.Tablero;

public class MyActionListener implements ActionListener, MouseListener {

	private ParaBuscaminasUI paraBuscaminasUI;
	Tablero tablero = new Tablero(Dificultad.MEDIO);

	public MyActionListener(ParaBuscaminasUI paraBuscaminasUI) {
		super();
		this.paraBuscaminasUI = paraBuscaminasUI;
	}

	public void actionPerformed(ActionEvent e) {
		// pone el action listener dependiendo del boton que sea
		if (((JButton) e.getSource()).getName() == "btnReboot") {
//			paraBuscaminasUI.rebootGame();
		} else {
//			paraBuscaminasUI.pseudoMain(((JButton) e.getSource()).getName());
			new Desvelador(tablero).desvelarCasilla((JButton) e.getSource(), null);
			if (tablero.isGanador()) {
				
				
			}
			if(tablero.isPerdedor()){
				//contenedor.setBackground(Color.RED);
					
				
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3)
			new Marcador().marcarCasilla((JButton) e.getSource(), tablero);
	}

	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	
	

}
