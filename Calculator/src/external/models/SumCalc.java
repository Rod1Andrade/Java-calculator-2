package external.models;

import domain.entities.Operator;

public class SumCalc extends BaseCalc {

	public SumCalc(Operator operator) {
		super(operator);
	}

	@Override
	public Double makeCalc(Double... doubles) {
		return null;
	}

}
