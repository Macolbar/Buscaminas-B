package control;

import vista.BuscaminasUI;

public class ParaBuscaminasUI extends BuscaminasUI{
	Buscaminas control = new Buscaminas();

	protected void rebootGame() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j].setEnabled(true);

			}
		}
	}

}
