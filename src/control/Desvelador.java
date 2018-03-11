package control;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;

public class Desvelador{
	Tablero tablero;
	protected ImageIcon fin = new ImageIcon(getClass().getResource("/assets/neh.png"));
	protected ImageIcon mina = new ImageIcon(getClass().getResource("/assets/mina.jpg"));
	
	
	public Desvelador(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
	public void desocultar(JButton botoncito){
		Coordenada coordenada = Utiles.convertirACoordenada(botoncito);
		Casilla casilla = tablero.getCasilla(coordenada);
		
		if(casilla.isOculta()){
			casilla.setOculta(false);
			botoncito.setOpaque(true);
		
		
		if (casilla.getAlrededor() > 0) {
			
			botoncito.setText(casilla.getTextoAlrededor());
			casilla.setOculta(false);
			botoncito.setBackground(Color.GRAY);
			botoncito.setOpaque(true);
			
		}else{
			botoncito.setText("");
			casilla.setOculta(false);
			botoncito.setBackground(Color.GRAY);
			botoncito.setOpaque(true);
		}
		}
	if(casilla.isMina()){
		if(casilla.isMarcada()){
			botoncito.setIcon(null);
		}
		botoncito.setIcon(Utiles.createScaledIcon(mina, botoncito.getHeight()));
		botoncito.setOpaque(true);
		botoncito.setBackground(Color.RED);
		casilla.setOculta(false);
		tablero.setPerdedor(true);
	}
		
	
}
		
	

	
	public void desvelarCasilla(JButton casillita, JButton[][] botonera) {
		Coordenada coordenada = Utiles.convertirACoordenada(casillita);
		Casilla casilla = tablero.getCasilla(coordenada);
		assert casilla!=null:"casilla no valida";
		// TODO llamamos a la casilla pero tambien al *tablero*         //contar las minas que faltan por descubrir, tablero.minas con marcador
		//porque el tablero debe buscar recursivamente las casillas a desvelar
		
		if(casilla.isOculta()&&!casilla.isMarcada()){
			
				if(casilla.getAlrededor()>0){
					desocultar(casillita);
				}else{
					desvelarContigua(coordenada, botonera);
				}
				
				
				
			}
		}	
	
	



	private void desvelarContigua(Coordenada coordenada, JButton[][] botonera) {
		Coordenada coordenadaCasilla = new Utiles().convertirACoordenada(botonera[coordenada.getPosX()][coordenada.getPosY()]);
		Coordenada coordenadas[] = new Utiles().damePosicionAlrededor(coordenadaCasilla.getPosX(), coordenadaCasilla.getPosY());
		Coordenada[] coordenadasValidas = new Utiles().validaContiguas(coordenadas, Utiles.DIEZ - 1);
		if (tablero.getCasilla(coordenadaCasilla).getAlrededor() > 0) {
			desocultar(botonera[coordenadaCasilla.getPosX()][coordenadaCasilla.getPosY()]);

		} else {
			desocultar(botonera[coordenadaCasilla.getPosX()][coordenadaCasilla.getPosY()]);
			for (int i = 0; i < coordenadasValidas.length; i++) {
				desvelarContigua(new Coordenada(coordenadasValidas[i].getPosX(), coordenadasValidas[i].getPosY()), botonera);
			}
		}

	}
	
	




}