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
		Stack<Double> stackNumbers = new Stack<>();
		Stack<Operator> stackOperations = new Stack<>();

		List<Operator> existentsOperators = this.listOfOperators(expression);
		List<Double> numbers = this.separeteNumberFromOperators(expression);

		int indexOperators = 0;
		for (int i = 0; i < numbers.size(); i++) {
			stackNumbers.push(numbers.get(i));

			if (indexOperators < existentsOperators.size()) {
				while (!stackOperations.isEmpty()
						&& this.precendenceCheck(existentsOperators.get(indexOperators), stackOperations.peek())) {
					// TODO: Pensar na forma de executar cálculo do número que está na pilha de
					// numeros
					// e dar POP na pilha de operações
				}
				stackOperations.push(existentsOperators.get(indexOperators++));
			}
		}

		return null; // TODO: Retornar último valor da pilha
	}

	/**
	 * Checa a precedência entre operadores
	 * 
	 * @param operator1 Operator
	 * @param operator2 Operator
	 * @return TRUE caso o operador1 tenha precedência menor que o operador2.
	 */
	private boolean precendenceCheck(Operator operator1, Operator operator2) {
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
	 * Cria uma lista de operacoes existentes
	 * 
	 * @param expression Expressao
	 * @return List
	 */
	private List<Operator> listOfOperators(String expression) {
		List<Operator> operators = new ArrayList<>();

		for (Character simbol : expression.toCharArray()) {
			if (this.isOperator(simbol)) {
				operators.add(this.getOperatorBySimbol(simbol));
			}
		}

		return operators;
	}

	/**
	 * 
	 * @param simbol Simbolo para buscar operador
	 * @return Operator
	 */
	private Operator getOperatorBySimbol(Character simbol) {

		for (BaseCalc baseCalc : this.getBaseCalcList()) {
			Operator operator = baseCalc.getOperator();

			if (operator.getSimbol().equals(simbol)) {
				return operator;
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
