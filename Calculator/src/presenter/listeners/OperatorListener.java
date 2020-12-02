package presenter.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import external.models.BaseCalc;
import presenter.components.Result;
import presenter.controller.ResultController;

/**
 * Listener das operacoes
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class OperatorListener implements ActionListener {

	private Result result;
	private final ResultController resultController;
	private final JComboBox<BaseCalc> comboBox;

	/**
	 * Construtor
	 * 
	 * @param resultController Controller do Result
	 * @param comboBox         ComboBox com as opcoes de operacoes
	 */
	public OperatorListener(ResultController resultController, JComboBox<BaseCalc> comboBox) {
		this.resultController = resultController;
		this.comboBox = comboBox;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (this.comboBox.getSelectedItem() != null) {
			BaseCalc baseCalc = (BaseCalc) this.comboBox.getSelectedItem();
			this.resultController.concatValue(baseCalc.getOperator().getSimbol());
			this.result.getResultLabel().setText(this.resultController.getValue());
		}
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
