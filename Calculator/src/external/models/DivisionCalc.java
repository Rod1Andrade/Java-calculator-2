package external.models;

import domain.entities.Operator;
import external.utils.Constants;

/**
 * Calculo de divisao.
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class DivisionCalc extends BaseCalc {

	public DivisionCalc(Operator operator) {
		super(operator);
	}

	@Override
	public Double makeCalc(Double value1, Double value2) {
		if (value1 == 0) {
			throw new NumberFormatException(Constants.DIVION_BY_ZERO);
		}
		System.out.println(value1 + " / " + value2);
		return value2 / value1;
	}

}
