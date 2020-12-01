package presenter.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import presenter.controller.ResultController;

/**
 * Listener das operacoes
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class OperatorListener implements ActionListener {
	private final ResultController resultController;
	private final JComboBox comboBox;

	/**
	 * Construtor
	 * 
	 * @param resultController Controller do Result
	 * @param comboBox         ComboBox com as opcoes de operacoes
	 */
	public OperatorListener(ResultController resultController, JComboBox comboBox) {
		this.resultController = resultController;
		this.comboBox = comboBox;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// TODO: Verificar depois da nova impolementacao dos controller
//		Operator operator = (Operator) this.comboBox.getSelectedItem();
//		this.resultController.concatValue(operator.getSimbol());
//		this.resultController.changeLabel();
	}
}
