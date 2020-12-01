package presenter.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import presenter.listeners.ButtonListener;
import presenter.styles.MouseHover;
import presenter.styles.ResetButtonModel;

/**
 * Botão customizado para a calculadora.
 * 
 * Listener: presenter.listeners.ButtonListener.java
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class Button extends JButton {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 100;
	public static final int HEIGHT = 103;

	private String value;

	/**
	 * Construtor
	 * 
	 * @param value           Valor textual
	 * @param listener      Controller do botao
	 * @param backgroundColor Cor de fundo do botao
	 * @param textColor       Cor do texto do botao
	 * @param hasHoverEffect  Define se tem o efeito de hover no botao
	 */
	Button(String value, ButtonListener listener, Color backgroundColor, Color textColor, boolean hasHoverEffect) {
		this.value = value;
		this.setMinimumSize(new Dimension(Button.WIDTH, Button.HEIGHT));
		this.setText(this.getValue());

		this.setBorderPainted(false);
		this.setContentAreaFilled(true);

		this.setFocusPainted(false);
		this.setBackground(backgroundColor);
		this.setForeground(textColor);

		this.setModel(new ResetButtonModel());

		this.setRolloverEnabled(false);

		this.addActionListener(listener);

		if (hasHoverEffect) {
			this.addMouseListener(new MouseHover(this, new Color(75, 0, 130)));
		}
	}

	/**
	 * Define o valor do botao
	 * 
	 * @param value Valor que vai ser definido para o botao
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Retorna o valor do botao
	 */
	public String getValue() {
		return this.value;
	}

}
