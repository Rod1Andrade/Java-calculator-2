package presenter.styles;

import javax.swing.DefaultButtonModel;

/**
 * Reseta as configurações de estilo do botão.
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class ResetButtonModel extends DefaultButtonModel {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isPressed() {
		return false;
	}

	@Override
	public boolean isRollover() {
		return false;
	}

	@Override
	public void setRollover(boolean b) {
		// NOOP
	}

}
