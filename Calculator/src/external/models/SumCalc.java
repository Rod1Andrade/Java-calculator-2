package external.models;

import domain.entities.Operator;

/**
 * Modelo de cálculo para soma.
 * 
 * @author Rodrigo M.P Andrade
 * @since 29 de nov. de 2020
 *
 */
public class SumCalc extends BaseCalc {

	public SumCalc(Operator operator) {
		super(operator);
	}

	@Override
	public Double makeCalc(Double value1, Double value2) {
		return value1 + value2;
	}


}
