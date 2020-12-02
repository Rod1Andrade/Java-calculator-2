package external.models;

import domain.entities.Operator;

/**
 * Calculo de multiplicacao.
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class TimesCalc extends BaseCalc {

	public TimesCalc(Operator operator) {
		super(operator);
	}

	@Override
	public Double makeCalc(Double value1, Double value2) {
		return value1 * value2;
	}

}
