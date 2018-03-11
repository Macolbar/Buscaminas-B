package utiles;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import modelo.Coordenada;
import modelo.Tablero;

public class Utiles {
	public static final int OCHO = 8;
	public static final int DIEZ = 10;
	
	public static Coordenada convertirACoordenada(JButton boton) {
		String[]coordenada = boton.getName().split(",");
	
		int x=Integer.parseInt(coordenada[0]);
		int y=Integer.parseInt(coordenada[1]);
	

	return new Coordenada(x,y);
}

	public static Coordenada[] damePosicionAlrededor(int x, int y) {
		Coordenada[] coordenadas = { new Coordenada(x - 1, y - 1), new Coordenada(x - 1, y),
				new Coordenada(x - 1, y + 1), new Coordenada(x, y - 1), new Coordenada(x, y + 1),
				new Coordenada(x + 1, y - 1), new Coordenada(x + 1, y), new Coordenada(x + 1, y + 1) };
		return coordenadas;
	}

	public static ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 2, height - 2, Image.SCALE_SMOOTH));

	}
	
	public Coordenada[] validaContiguas(Coordenada[] coordenadas, int maximo) {
		int noValidas = 0;
		for (int i = 0; i < coordenadas.length; i++) {
			if (coordenadas[i].getPosX() < 0 || coordenadas[i].getPosY() < 0 || coordenadas[i].getPosX() > maximo
					|| coordenadas[i].getPosY() > maximo) {
				coordenadas[i].setPosX(-1);
				coordenadas[i].setPosY(-1);
				noValidas++;
			}
		}
		Coordenada[] validas = new Coordenada[coordenadas.length - noValidas];
		int iterador = 0;
		for (int i = 0; i < coordenadas.length; i++) {
			if (coordenadas[i].getPosX() == -1) {

			} else {
				validas[iterador] = coordenadas[i];
				iterador++;
			}
		}

		return validas;

	}
	

	
	
}
