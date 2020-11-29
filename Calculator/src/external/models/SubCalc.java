package external.models;

import domain.entities.Operator;

/**
 * Modelo de cálculo para subtração.
 * 
 * @author Rodrigo M.P Andrade
 * @since 29 de nov. de 2020
 *
 */
public class SubCalc extends BaseCalc {

	public SubCalc(Operator operator) {
		super(operator);
	}

	@Override
	public Double makeCalc(Double... doubles) {
		Double result = 0.0;
		for (Double value : doubles) {
			result = value - result;
		}

		return result;
	}
}
