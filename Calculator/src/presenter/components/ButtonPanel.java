package presenter.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import presenter.listeners.ButtonListener;

/**
 * Painel de botões.
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ButtonListener buttonListener;

	private Button button7;
	private Button button8;
	private Button button9;

	private Button button4;
	private Button button5;
	private Button button6;

	private Button button1;
	private Button button2;
	private Button button3;

	private Button button0;
	private Button buttonDot;
	private Button buttonDelete;

	/**
	 * Construtor
	 */
	public ButtonPanel(ButtonListener buttonController) {
		this.setBackground(Color.DARK_GRAY);

		GridLayout gridLayout = new GridLayout(4, 3);
		gridLayout.setVgap(1);
		gridLayout.setHgap(1);

		this.setLayout(gridLayout);
		this.setPreferredSize(this.getPreferredSize());

		this.buttonListener = buttonController;

		this.init();
		this.addAllButtons();
	}

	/**
	 * Funcao para instanciar os componentes
	 */
	private void init() {
		this.button7 = new Button("7", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button8 = new Button("8", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button9 = new Button("9", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button4 = new Button("4", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button5 = new Button("5", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button6 = new Button("6", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button1 = new Button("1", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button2 = new Button("2", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button3 = new Button("3", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.button0 = new Button("0", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.buttonDot = new Button(".", this.buttonListener, Color.BLACK, Color.WHITE, true);

		this.buttonDelete = new Button("Deletar", this.buttonListener, Color.ORANGE, Color.BLACK, false);
	}

	/**
	 * Adiciona os botoes ao Painel
	 */
	private void addAllButtons() {
		this.add(this.button7);
		this.add(this.button8);
		this.add(this.button9);

		this.add(this.button4);
		this.add(this.button5);
		this.add(this.button6);

		this.add(this.button1);
		this.add(this.button2);
		this.add(this.button3);

		this.add(this.button0);
		this.add(this.buttonDot);
		this.add(this.buttonDelete);
	}
}
