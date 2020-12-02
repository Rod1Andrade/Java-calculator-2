/**
 * Projeto se encontra no repositório do github:
 * http://github.com/Rod1Andrade
 */
package presenter.screen;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import external.models.BaseCalc;
import presenter.components.ButtonPanel;
import presenter.components.Result;
import presenter.components.SelectOperators;
import presenter.components.SidePanel;
import presenter.controller.OperatorController;
import presenter.controller.ResultController;
import presenter.listeners.ButtonListener;
import presenter.listeners.OperatorListener;
import presenter.utils.Constants;

/**
 * Tela principal da aplicação
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class CalculatorScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	private final Result result;
	private final ButtonPanel buttonPanel;
	private final SidePanel sidePanel;
	private final SelectOperators selectOperators;

	/**
	 * Construtor
	 */
	public CalculatorScreen(OperatorController operatorController, ResultController resultController) {

		this.setBackground(Color.DARK_GRAY);

		this.setLayout(new BorderLayout());
		this.setPreferredSize(this.getPreferredSize());

		// Label result panel
		this.result = new Result(Constants.DEFAULT_VALUE);
		this.add(this.result, BorderLayout.NORTH);

		// Keyboard panel
		ButtonListener buttonListener = new ButtonListener(this.result, resultController);
		this.buttonPanel = new ButtonPanel(buttonListener);
		this.add(this.buttonPanel, BorderLayout.CENTER);

		// SidePanel
		this.selectOperators = new SelectOperators(this.getBaseCalcs(operatorController));

		OperatorListener operatorListener = new OperatorListener(resultController,
				this.selectOperators.getOperatorSelect());
		operatorListener.setResult(this.result);

		this.selectOperators.getOperatorSelectActionButton().addActionListener(operatorListener);

		this.sidePanel = new SidePanel(this.selectOperators);
		this.sidePanel.getResultButton().addActionListener(buttonListener);

		this.add(this.sidePanel, BorderLayout.EAST);
	}

	/**
	 * Retorna os calculos basicos atraves do controller
	 * 
	 * @param operatorController
	 * @return
	 */
	private JComboBox<BaseCalc> getBaseCalcs(OperatorController operatorController) {
		JComboBox<BaseCalc> baseCalcsComboBox = new JComboBox<BaseCalc>();
		DefaultComboBoxModel<BaseCalc> baseCalcDefaultModel = new DefaultComboBoxModel<BaseCalc>();
		baseCalcDefaultModel.addAll(operatorController.getAllBaseCalcs());

		baseCalcsComboBox.setModel(baseCalcDefaultModel);
		return baseCalcsComboBox;
	}
}
