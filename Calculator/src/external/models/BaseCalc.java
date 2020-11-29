package external.models;

import domain.entities.Operator;

/**
 * @author Rodrigo M.P Andrade
 * @since 28 de nov. de 2020
 *
 */
public abstract class BaseCalc {

	private Operator operator;

	/**
	 * Executa o cálculo.
	 * 
	 * @param doubles Valores para cálculo.
	 * @return Resultado do calculo
	 */
	public abstract Double makeCalc(Double value1, Double value2);

	/**
	 * Construtor padrão para definir operador da classe de cálculo.
	 * 
	 * @param operator
	 */
	public BaseCalc(Operator operator) {
		this.operator = operator;
	}

	/**
	 * Retorna o operador da classe de cálculo.
	 * 
	 * @return Operator
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Define o operador para a classe cálculo.
	 * 
	 * @param operator
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
}
