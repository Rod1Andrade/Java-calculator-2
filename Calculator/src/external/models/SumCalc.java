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
	public Double makeCalc(Double... doubles) {
		Double result = 0.0;
		for (Double value : doubles) {
			result += value;
		}

		return result;
	}

}