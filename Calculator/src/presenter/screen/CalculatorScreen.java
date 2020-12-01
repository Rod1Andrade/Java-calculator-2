/**
 * Projeto se encontra no repositório do github:
 * http://github.com/Rod1Andrade
 */
package presenter.screen;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import presenter.components.ButtonPanel;
import presenter.components.Result;
import presenter.components.SelectOperators;
import presenter.components.SidePanel;
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
	public CalculatorScreen() {

		this.setBackground(Color.DARK_GRAY);

		this.setLayout(new BorderLayout());
		this.setPreferredSize(this.getPreferredSize());

		// Label result panel
		this.result = new Result(Constants.DEFAULT_VALUE);
		this.add(this.result, BorderLayout.NORTH);

		ResultController resultController = new ResultController(result);

		// Keyboard panel
		ButtonListener buttonController = new ButtonListener(resultController);
		this.buttonPanel = new ButtonPanel(buttonController);
		this.add(this.buttonPanel, BorderLayout.CENTER);

		// SidePanel
		this.selectOperators = new SelectOperators();

		OperatorListener operatorController = new OperatorListener(resultController,
				this.selectOperators.getOperatorSelect());

		this.selectOperators.getOperatorSelectActionButton().addActionListener(operatorController);

		this.sidePanel = new SidePanel(this.selectOperators);
		this.sidePanel.getResultButton().addActionListener(buttonController);

		this.add(this.sidePanel, BorderLayout.EAST);
	}
}
