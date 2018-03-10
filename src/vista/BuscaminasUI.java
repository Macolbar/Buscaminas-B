package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import control.MyActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import utiles.Utiles;

public class BuscaminasUI extends JFrame {

	protected boolean oculta = true;
	private JPanel contenedor;
	private int tamaño=10;
	protected JButton[][] botones = new JButton[tamaño][tamaño];
	protected ImageIcon bandera = new ImageIcon(getClass().getResource("/assets/bandera.png"));
	protected ImageIcon sonrisa = new ImageIcon(getClass().getResource("/assets/sonrisa.png"));
	protected ImageIcon mina = new ImageIcon(getClass().getResource("/assets/mina.jpg"));
	protected JButton btnReboot;
	protected JMenuBar menuBar;
	protected JMenu mnDificultad;
	protected JMenuItem mntmFcil;
	protected JMenuItem mntmMedio;
	protected JMenuItem mntmDifcil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaminasUI frame = new BuscaminasUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	 
	 
	   
	public BuscaminasUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 414);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnDificultad = new JMenu("Dificultad");
		mnDificultad.setForeground(Color.WHITE);
		menuBar.add(mnDificultad);
		
		JMenuItem mntmFcil = new JMenuItem("F\u00E1cil");
		mntmFcil.setBackground(Color.BLACK);
		mntmFcil.setForeground(Color.YELLOW);
		mnDificultad.add(mntmFcil);
		
		JMenuItem mntmMedio = new JMenuItem("Medio");
		mntmMedio.setBackground(Color.BLACK);
		mntmMedio.setForeground(Color.YELLOW);
		mnDificultad.add(mntmMedio);
		
		JMenuItem mntmDifcil = new JMenuItem("Dif\u00EDcil");
		mntmDifcil.setBackground(Color.BLACK);
		mntmDifcil.setForeground(Color.YELLOW);
		mnDificultad.add(mntmDifcil);
		
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setBackground(Color.gray);
		setContentPane(contenedor);
		contenedor.setLayout(new MigLayout("", "[][grow][][][][][]", "[][][][grow][][]"));
		
		JButton btnReboot = new JButton("");
		btnReboot.setActionCommand("");
		btnReboot.setIcon(sonrisa);
		btnReboot.setBackground(Color.BLACK);
		
		contenedor.add(btnReboot, "cell 1 0 3 1,alignx center,aligny center");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(0, botones.length, 0, 0));
		contenedor.add(panel, "cell 1 1 3 5,grow");
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBackground(Color.getHSBColor(234, 243, 92));
				panel.add(botones[i][j]);
				botones[i][j].setName(i+","+j);
				 
			}
		}
	}

}
