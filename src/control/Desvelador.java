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
		Coordenada coordenada = Convertidor.convertirACoordenada(botoncito);
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
		
	

	
	public void desvelarCasilla(JButton casillita) {
		Coordenada coordenada = Convertidor.convertirACoordenada(casillita);
		Casilla casilla = tablero.getCasilla(coordenada);
		assert casilla!=null:"casilla no valida";
		// TODO llamamos a la casilla pero tambien al *tablero*         //contar las minas que faltan por descubrir, tablero.minas con marcador
		//porque el tablero debe buscar recursivamente las casillas a desvelar
		
		if(casilla.isOculta()&&!casilla.isMarcada()){
			
				if(casilla.getAlrededor()>0){
					desocultar(casillita);
				}else{
					desocultar(casillita);
				}
				
				
				
			}
		}	
	
	



	/*private void desvelarContigua(JButton casillita,Coordenada coordenada,Casilla casilla) {
		casilla.setOculta(false);
		casillita.setOpaque(true);
		casillita.setBackground(Color.GRAY);
		// comprobar si las casillas marcadas alrededor coincide con el
		// numero de minas alrededor de la casilla
		if (tablero.comprobarMarcadas(coordenada)) {
			for (int i = 0; i < Utiles.OCHO; i++) {
				Coordenada posicion = tablero.crearCoordenadaAlrededor(coordenada.getPosX(), coordenada.getPosY(), i);
				if (tablero.isInToLimits(posicion)
						&& casilla.isOculta()
						&& !casilla.isMarcada()) {
					casilla.setOculta(false);
					casillita.setOpaque(true);
					casillita.setText(""+tablero.getAlrededor(posicion));
					if (casilla.getAlrededor() == 0)
						desvelarContigua(casillita, posicion, casilla);
				}
			}
		}
		
	}*/





}