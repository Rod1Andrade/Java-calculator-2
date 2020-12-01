package presenter.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import presenter.styles.MouseHover;
import presenter.styles.ResetButtonModel;
import presenter.utils.Constants;

/**
 * Painel lateral
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class SidePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private SelectOperators selectOperators;
	private JButton resultButton;

	/**
	 * Construtor
	 */
	public SidePanel(SelectOperators selectOperators) {
		this.setBackground(Color.DARK_GRAY);

		this.selectOperators = selectOperators;
		initResultButton();

		GridLayout gridLayout = new GridLayout(2, 1);
		gridLayout.setVgap(10);

		JPanel sidePanelComponents = new JPanel(gridLayout);
		sidePanelComponents.add(this.selectOperators);
		sidePanelComponents.add(this.resultButton);
		sidePanelComponents.setBackground(Color.DARK_GRAY);

		this.setLayout(new BorderLayout());
		this.add(sidePanelComponents, BorderLayout.NORTH);
	}

	private void initResultButton() {
		this.resultButton = new JButton(Constants.RESULT_VALUE);
		this.resultButton.setBackground(Color.BLACK);
		this.resultButton.setForeground(Color.WHITE);
		this.resultButton.setFocusPainted(false);
		this.resultButton.setBorderPainted(false);
		this.resultButton.setModel(new ResetButtonModel());
		this.resultButton.addMouseListener(new MouseHover(this.resultButton, new Color(13, 13, 13)));
	}

	public SelectOperators getOperatorSelect() {
		return selectOperators;
	}

	public void setOperatorSelect(SelectOperators operatorSelect) {
		this.selectOperators = operatorSelect;
	}

	public JButton getResultButton() {
		return resultButton;
	}

	public void setResultButton(JButton resultButton) {
		this.resultButton = resultButton;
	}
}
