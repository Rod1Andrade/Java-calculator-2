package presenter.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import presenter.components.Result;
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

	private Result result;
	private final ResultController resultController;

	/**
	 * Construtor
	 * 
	 * @param resultController Controller do Result
	 */
	public ButtonListener(ResultController resultController) {
		this.resultController = resultController;
	}

	/**
	 * Contrutor com result label.
	 * 
	 * @param result
	 * @param resultController
	 */
	public ButtonListener(Result result, ResultController resultController) {
		this.result = result;
		this.resultController = resultController;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		JButton button = (JButton) actionEvent.getSource();
		JLabel resultLabel = this.result.getResultLabel();

		if (button.getText().equals("Deletar")) {
			this.resultController.deleteLastValue();
			resultLabel.setText(this.resultController.getValue());
		} else if (button.getText().equals(Constants.RESULT_VALUE)) {
			resultLabel.setText(this.resultController.makeResult());
		} else {
			this.resultController.concatValue(button.getText());
			resultLabel.setText(this.resultController.getValue());
		}
	}

}
