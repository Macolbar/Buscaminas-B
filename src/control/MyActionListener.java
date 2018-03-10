package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import control.ParaBuscaminasUI;


public class MyActionListener implements ActionListener, MouseListener {

	//TresNRaya control=new TresNRaya();
	
	private ParaBuscaminasUI paraBuscaminasUI;
	
	

	public MyActionListener(ParaBuscaminasUI paraBuscaminasUI) {
		this.paraBuscaminasUI=paraBuscaminasUI;
	
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// pone el action listener dependiendo del boton que sea
		if (((JButton) e.getSource()).getName() == "btnReboot") {
//			paraBuscaminasUI.rebootGame();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}
}
