package presenter.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import presenter.utils.Constants;
import presenter.utils.MouseHover;
import presenter.utils.ResetButtonModel;

/**
 * Seletor de operações
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class SelectOperators extends JPanel {

	private static final long serialVersionUID = 1L;

	// TODO: Ajustar para receber as operacoes atraves do controller
	private JComboBox operators;
	private JButton operatorSelectActionButton;

	public SelectOperators() {
		this.setBackground(Color.DARK_GRAY);

		GridLayout gridLayout = new GridLayout(2, 1);
		gridLayout.setVgap(5);

		this.init();

		this.setLayout(gridLayout);
		this.add(this.operators);
		this.add(this.operatorSelectActionButton);
	}

	/**
	 * Funcao para iniciar os componentes
	 */
	private void init() {
		operatorSelectInit();
		actionButtonInit();
	}

	/**
	 * Define como o comboBox de selecao unica deve ser iniciado.
	 */
	private void operatorSelectInit() {
		this.operators = this.defineOperatorSelect();
		this.operators.setBackground(Color.BLACK);
		this.operators.setForeground(Color.WHITE);
	}

	/**
	 * Define os valores a serem iniciados no botao de acao.
	 */
	private void actionButtonInit() {
		this.operatorSelectActionButton = new JButton(Constants.SELECT_OPERATION);
		this.operatorSelectActionButton.setBackground(Color.BLACK);
		this.operatorSelectActionButton.setForeground(Color.WHITE);
		this.operatorSelectActionButton.setFocusPainted(false);
		this.operatorSelectActionButton.setBorderPainted(false);
		this.operatorSelectActionButton.setModel(new ResetButtonModel());
		this.operatorSelectActionButton
				.addMouseListener(new MouseHover(this.operatorSelectActionButton, new Color(13, 13, 13)));
	}

	/**
	 * Define 'operatorSelect' com seus valores padroes.
	 *
	 * @return JComboBox
	 */
	private JComboBox defineOperatorSelect() {
		JComboBox comboBox = new JComboBox<>();

		return comboBox;
	}

	public JComboBox getOperatorSelect() {
		return operators;
	}

	public void setOperatorSelect(JComboBox operatorSelect) {
		this.operators = operatorSelect;
	}

	public JButton getOperatorSelectActionButton() {
		return operatorSelectActionButton;
	}

	public void setOperatorSelectActionButton(JButton operatorSelectActionButton) {
		this.operatorSelectActionButton = operatorSelectActionButton;
	}

}
