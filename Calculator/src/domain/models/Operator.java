package domain.models;

/**
 * Classe de modelo para operadores
 * 
 * @author Rodrigo M.P Andrade
 *
 */
public class Operator {

	private Character simbol;
	private String name;
	private int precedenceNumber;

	/**
	 * Construor padrão
	 * 
	 * @param simbol           Simbolo represante da operação matemática
	 * @param name             Nome da operação matemática
	 * @param precedenceNumber Valor de precedência do operador matemático quanto,
	 *                         maior o número menor sua precedência em relação aos
	 *                         outros operadores.
	 */
	public Operator(Character simbol, String name, int precedenceNumber) {
		this.simbol = simbol;
		this.name = name;
		this.precedenceNumber = precedenceNumber;
	}

	/**
	 * Retorna Simbolo represante da operação matemática
	 * 
	 * @return Character
	 */
	public Character getSimbol() {
		return simbol;
	}

	/**
	 * Define Simbolo represante da operação matemática
	 * 
	 * @param simbol
	 */
	public void setSimbol(Character simbol) {
		this.simbol = simbol;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define o nome para a operação matemática.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna o valor de precedência
	 * 
	 * @return int
	 */
	public int getPrecedenceNumber() {
		return precedenceNumber;
	}

	/**
	 * Define o valor de precedência do operador.
	 * 
	 * @param precedenceNumber
	 */
	public void setPrecedenceNumber(int precedenceNumber) {
		this.precedenceNumber = precedenceNumber;
	}

}
