package presenter.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import external.models.BaseCalc;
import presenter.styles.MouseHover;
import presenter.styles.ResetButtonModel;
import presenter.utils.Constants;

/**
 * Seletor de operações
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class SelectOperators extends JPanel {

	private static final long serialVersionUID = 1L;

	private JComboBox<BaseCalc> baseCalcsComboBox;
	private JButton operatorSelectActionButton;

	public SelectOperators(JComboBox<BaseCalc> baseCalcsComboBox) {
		this.setBackground(Color.DARK_GRAY);
		this.setOperatorSelect(baseCalcsComboBox);

		GridLayout gridLayout = new GridLayout(2, 1);
		gridLayout.setVgap(5);

		this.init();

		this.setLayout(gridLayout);
		this.add(this.baseCalcsComboBox);
		this.add(this.operatorSelectActionButton);
	}

	/**
	 * Funcao para iniciar os componentes
	 */
	private void init() {
		this.operatorSelectInit();
		this.actionButtonInit();
	}

	/**
	 * Define como o comboBox de selecao unica deve ser iniciado.
	 */
	private void operatorSelectInit() {
		this.baseCalcsComboBox.setBackground(Color.BLACK);
		this.baseCalcsComboBox.setForeground(Color.WHITE);
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
	 * Retorna a lista de BaseCalc onde pode ser extraido os operadores.
	 * 
	 * @return JComboBox<BaseCalc>
	 */
	public JComboBox<BaseCalc> getOperatorSelect() {
		return baseCalcsComboBox;
	}

	/**
	 * Define as a lista de BaseCacl onde pode ser extraido os operadores.
	 * 
	 * @param operatorSelect
	 */
	public void setOperatorSelect(JComboBox<BaseCalc> operatorSelect) {
		this.baseCalcsComboBox = operatorSelect;
	}

	/**
	 * Retorna o botão de ação.
	 * 
	 * @return JButton
	 */
	public JButton getOperatorSelectActionButton() {
		return operatorSelectActionButton;
	}

	/**
	 * Define o botao de ação.
	 * 
	 * @param operatorSelectActionButton
	 */
	public void setOperatorSelectActionButton(JButton operatorSelectActionButton) {
		this.operatorSelectActionButton = operatorSelectActionButton;
	}

}
