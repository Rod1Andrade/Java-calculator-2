package presenter.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import presenter.controller.ResultController;
import presenter.utils.Constants;

/**
 * Listener responsavel por botão.
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class ButtonListener implements ActionListener {

	// TODO: Verificar depois da mudanca de apenas retorno
	private final ResultController resultController;

	/**
	 * Construtor
	 * 
	 * @param resultController Controller do Result
	 */
	public ButtonListener(ResultController resultController) {
		this.resultController = resultController;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton button = (JButton) actionEvent.getSource();

		if (button.getText().equals("Deletar")) {
			this.resultController.deleteLastValue();
		} else if (button.getText().equals(Constants.RESULT_VALUE)) {
			this.resultController.makeResult();
		} else {
			this.resultController.concatValue(button.getText());
		}

		this.resultController.changeLabel();
	}

}
