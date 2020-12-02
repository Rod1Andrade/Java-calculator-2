package external.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import domain.entities.Operator;
import domain.services.CalculateServiceInterface;
import external.models.BaseCalc;

/**
 * Implementação da interface CalculateServiceInterface.
 * 
 * @author Rodrigo M.P Andrade
 *
 */
public class CalculateService implements CalculateServiceInterface {

	private List<BaseCalc> baseCalcList;

	@Override
	public Double calculateExpression(String expression) {

		// Pilhas para aplicar o infix-calculator.
		Stack<Double> stackNumbers = new Stack<>();
		Stack<BaseCalc> stackBaseCalc = new Stack<>();

		// Lista de números e base de cálculos existentes.
		List<Double> numbers = this.separeteNumberFromOperators(expression);
		List<BaseCalc> existentsCalcs = this.listOfCalcs(expression);

		// Index de controle do existentsCalcs
		int indexExistentsCalc = 0;

		for (int i = 0; i < numbers.size(); i++) {
			stackNumbers.push(numbers.get(i));

			if (indexExistentsCalc < existentsCalcs.size()) {
				while (!stackBaseCalc.isEmpty()
						&& this.precendenceCheck(existentsCalcs.get(indexExistentsCalc), stackBaseCalc.peek())) {
					double result = this.executeCalc(stackNumbers, stackBaseCalc);
					stackNumbers.push(result);
				}
				stackBaseCalc.push(existentsCalcs.get(indexExistentsCalc++));
			}
		}

		while (!stackBaseCalc.isEmpty()) {
			double result = this.executeCalc(stackNumbers, stackBaseCalc);
			stackNumbers.push(result);
		}

		return stackNumbers.pop();
	}

	/***
	 * Executa o cálculo dos valores de pilha de números.
	 * 
	 * @param stackNumbers  Pilha de números
	 * @param stackBaseCalc Pilha
	 * @return double
	 */
	private double executeCalc(Stack<Double> stackNumbers, Stack<BaseCalc> stackBaseCalc) {
		Double number1 = stackNumbers.pop();
		Double number2 = stackNumbers.pop();
		BaseCalc baseCalc = stackBaseCalc.pop();
		return baseCalc.makeCalc(number1, number2);
	}

	/**
	 * Checa a precedência entre operadores
	 * 
	 * @param baseCalc1
	 * @param baseCalc2
	 * @return TRUE caso o operador1 tenha precedência menor que o operador2.
	 */
	private boolean precendenceCheck(BaseCalc baseCalc1, BaseCalc baseCalc2) {
		Operator operator1 = baseCalc1.getOperator();
		Operator operator2 = baseCalc2.getOperator();
		return operator1.getPrecedenceNumber() <= operator2.getPrecedenceNumber();
	}

	/**
	 * Retorna uma lista de numeros separados pelos operadores
	 * 
	 * @param expression
	 * @return List<Double>
	 */
	public List<Double> separeteNumberFromOperators(String expression) {
		String number = "";
		List<Double> numbers = new ArrayList<>();
		char[] simbols = expression.toCharArray();

		for (int i = 0; i < simbols.length; i++) {
			if (!this.isOperator(simbols[i])) {
				number += String.valueOf(simbols[i]);
			} else {
				numbers.add(Double.parseDouble(number));
				number = "";
			}
		}

		if (!number.isEmpty()) {
			numbers.add(Double.parseDouble(number));
		}

		return numbers;
	}

	/**
	 * Construtor vázio
	 */
	public CalculateService() {
	}

	/**
	 * Construtor padrão para injetar uma lista de cálculos aceitos.
	 * 
	 * @param baseCalcList
	 */
	public CalculateService(List<BaseCalc> baseCalcList) {
		this.baseCalcList = baseCalcList;
	}

	/**
	 * Cria uma lista de cálculos existentes
	 * 
	 * @param expression Expressao
	 * @return List
	 */
	private List<BaseCalc> listOfCalcs(String expression) {
		List<BaseCalc> calcs = new ArrayList<>();

		for (Character simbol : expression.toCharArray()) {
			if (this.isOperator(simbol)) {
				calcs.add(this.getCalcBySimbol(simbol));
			}
		}

		return calcs;
	}

	/**
	 * Retorna o cálculo dado o simbolo.
	 * 
	 * @param simbol Simbolo para buscar operador
	 * @return Operator
	 */
	private BaseCalc getCalcBySimbol(Character simbol) {

		for (BaseCalc baseCalc : this.getBaseCalcList()) {
			Operator operator = baseCalc.getOperator();

			if (operator.getSimbol().equals(simbol)) {
				return baseCalc;
			}
		}

		return null;
	}

	/**
	 * Verifica se é um Operator da lista de operators
	 * 
	 * @param simbol
	 * @return True caso seja um operator e falso caso contrário.
	 */
	private boolean isOperator(Character simbol) {
		for (BaseCalc baseCalc : this.getBaseCalcList()) {
			Operator operator = baseCalc.getOperator();

			if (operator.getSimbol().equals(simbol)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Lista de operações permitidas
	 * 
	 * @return List<BaseCalc>
	 */
	public List<BaseCalc> getBaseCalcList() {
		return baseCalcList;
	}

	/**
	 * Define uma lista de operações permitidas
	 * 
	 * @param baseCalcList
	 */
	public void setBaseCalcList(List<BaseCalc> baseCalcList) {
		this.baseCalcList = baseCalcList;
	}
}
