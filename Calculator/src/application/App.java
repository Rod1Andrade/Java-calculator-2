package application;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

import presenter.screen.CalculatorScreen;

/**
 * Classe principal da aplicação.
 * 
 * @author Rodrigo M.P Andrade
 *
 */
public class App extends JFrame {

	private static final long serialVersionUID = 1L;

	private Dimension screenDimension = this.getToolkit().getScreenSize();

	private static final double WIDTH_SCALE = .3;
	private static final double HEIGHT_SCALE = .6;

	/**
	 * Construtor padrão da classe App
	 * 
	 * @param title Titulo da janela
	 */
	private App(String title) {
		this.setTitle(title);
		this.setMinimumSize(this.minimumDimension());
		this.setSize(this.getScaledScreenDimension());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Inicia os recursos definidos na classe.
	 * 
	 * @param component Componente inicial da aplicação.
	 */
	private void start(JComponent component) {
		this.getContentPane().add(component);
		this.setVisible(true);
	}

	/**
	 * Retorna a largura escalonada de acordo com as preferencias
	 * 
	 * @return double
	 */
	private double getScaledWidth() {
		return screenDimension.getWidth() * WIDTH_SCALE;
	}

	/**
	 * Retorna a altura escalonada de acordo com as preferencias
	 * 
	 * @return double
	 */
	private double getScaledHeight() {
		return screenDimension.getHeight() * HEIGHT_SCALE;
	}

	/**
	 * Devolve a dimensao scalonada de acordo com as preferencias.
	 * 
	 * @return Dimension
	 */
	private Dimension getScaledScreenDimension() {
		return new Dimension((int) this.getScaledWidth(), (int) this.getScaledHeight());
	}

	/**
	 * Retorna a dimensão minima da aplicaaco.
	 * 
	 * @return Dimensions
	 */
	private Dimension minimumDimension() {
		return new Dimension(800, 450);
	}

	// Execução
	public static void main(String[] args) {
		new App("Calculadora 2").start(new CalculatorScreen());
	}

}
