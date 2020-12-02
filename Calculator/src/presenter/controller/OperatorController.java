package presenter.controller;

import java.util.ArrayList;
import java.util.List;

import domain.entities.Operator;
import external.models.BaseCalc;
import external.models.DivisionCalc;
import external.models.SubCalc;
import external.models.SumCalc;
import external.models.TimesCalc;

/**
 * Controller das operacoes.
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class OperatorController {

	private List<BaseCalc> baseCalcList;

	/**
	 * Contrutor
	 */
	public OperatorController() {
		this.baseCalcList = new ArrayList<>();
		this.onInit();
	}

	/**
	 * Retorna todos os BaseCalc
	 * 
	 * @return List<BaseCalc>
	 */
	public List<BaseCalc> getAllBaseCalcs() {
		return this.baseCalcList;
	}

	/**
	 * Rotina inicial
	 */
	private void onInit() {
		this.baseCalcList.add(new SumCalc(new Operator('+', "Soma", 1)));
		this.baseCalcList.add(new SubCalc(new Operator('-', "Subtração", 1)));
		this.baseCalcList.add(new TimesCalc(new Operator('*', "Multiplicação", 2)));
		this.baseCalcList.add(new DivisionCalc(new Operator('/', "Divisão", 2)));

		// TODO: Definir regra para operacoes especiais
	}

}
