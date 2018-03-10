package modelo;


import javax.naming.event.NamespaceChangeListener;

import modelo.Casilla;
import modelo.Coordenada;
import utiles.Utiles;

public class Tablero implements AccionesTablero {
	private Casilla[][] casillas;
	boolean ganador = false;
	boolean perdedor = false;
	

	public Casilla[][] getCasillas() {
		return casillas;
	}
	
	public Casilla getCasilla(Coordenada coordenada) { //esto es para llamar a una casilla en concreto (Convertidor
														//saca la coordenada del JButton y se identifica asi)
		return casillas[coordenada.getPosX()][coordenada.getPosY()];
	}
	
	public Tablero(Dificultad dificultad) {
		super();
		crearTablero(dificultad.getMinas());
	}

	private void crearTablero(int minas) {
		casillas = new Casilla[Utiles.DIEZ][Utiles.DIEZ];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla(); 
			}
		}
		
		int x;
		int y;
		do{
			x= (int) Math.abs(Math.random()*Utiles.DIEZ);
			y= (int) Math.abs(Math.random()*Utiles.DIEZ);
			
			if(colocarMina(x,y)){
				minas--;
			}
		}while(minas!=0);
		
	}

	
	

	
	@Override
	public void calcularMinasAlrededor() {
		// TODO recorrer el panel donde hay mina y colocar un incremento
		// de una mina alrededor de ella
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (!casillas[i][j].isMina()) {
					// VIVA el hardcode
					for (int j2 = 0; j2 < Utiles.OCHO; j2++) {
						Coordenada alrededor = crearCoordenadaAlrededor(i, j, j2);
						if (isInToLimits(alrededor)) {
							// ¿que nos preguntamos para incrementar en uno el
							// numero de minas alrededor de esta casilla
							if (!casillas[alrededor.getPosX()][alrededor.getPosY()].isMina()) {
								casillas[alrededor.getPosX()][alrededor.getPosY()].setAlrededor();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Crear la coordenada exacta con un posicion alrededor segun defina el
	 * lugar
	 * 
	 */
	public Coordenada crearCoordenadaAlrededor(int i, int j, int lugar) {
		Coordenada desplazamiento = Utiles.damePosicionAlrededor(lugar);
		// ¿Que nos estamos preguntando?
		int posX = i + desplazamiento.getPosX();
		int posY = j + desplazamiento.getPosY();
		return new Coordenada(posX, posY);
	}

	public boolean isInToLimits(Coordenada pos) {
		return isInside(pos, casillas.length) && isInside(pos, casillas[0].length);
	}

	public boolean isInside(Coordenada pos, int upperLimitRow) {
		return pos.getPosX() >= 0 && pos.getPosX() <= upperLimitRow;
	}

	public boolean colocarMina(int x, int y) {
		// no se debe acceder directamente a las propiedades de otra clase
		// casilla[x][y].mina=true;

		return casillas[x][y].colocaMina();
	}

	

	@Override
	public void desvelarContigua(Coordenada casilla) {
		// lo que hay que hacer siempre
		// es velar una casilla
		setOculta(casilla);
		// comprobar si las casillas marcadas alrededor coincide con el
		// numero de minas alrededor de la casilla
		if (comprobarMarcadas(casilla)) {
			for (int i = 0; i < Utiles.OCHO; i++) {
				Coordenada posicion = crearCoordenadaAlrededor(casilla.getPosX(), casilla.getPosY(), i);
				if (isInToLimits(posicion)
						&& isOculta(posicion)
						&& !isMarcada(posicion)) {
					setOculta(casilla);
					if (getAlrededor(casilla) == 0)
						desvelarContigua(posicion);
				}
			}
		}
	}

	
	public byte getAlrededor(Coordenada lugar) {
		
		return casillas[lugar.getPosX()][lugar.getPosY()].getAlrededor();
	}

	public boolean isMarcada(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isMarcada();
	}

	public boolean isOculta(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()].isOculta();
	}

	public void setOculta(Coordenada lugar) {
		casillas[lugar.getPosX()][lugar.getPosY()].setOculta(false);
	}

	/**
	 * Comporbar si el numero de casillas marcadas alrededor de una casilla
	 * coincide con el numero de minas alrededor de una casilla
	 * 
	 * @param lugar
	 * @return
	 */
	public boolean comprobarMarcadas(Coordenada lugar) {
		int contador = 0;
		// es contar cuantas casilla marcadas rodean a la actual
		for (int i = 0; i < Utiles.OCHO; i++) {
			Coordenada posicion = crearCoordenadaAlrededor(lugar.getPosX(), lugar.getPosY(), i);
			if (isInToLimits(posicion)) {
				if (isMarcada(posicion)) {
					contador++;
				}
			}
		}
		boolean retorno = false;
		if (contador == casillas[lugar.getPosX()][lugar.getPosY()].getAlrededor()
				&& !casillas[lugar.getPosX()][lugar.getPosY()].isMina())
			retorno = true;
		return retorno;
	}
	
	
	
	
	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public boolean isPerdedor() {
		return perdedor;
	}

	public void setPerdedor(boolean perdedor) {
		this.perdedor = perdedor;
	}

}
