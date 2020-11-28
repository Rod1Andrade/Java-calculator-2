package domain.services;

/**
 * Interface do serviço experado para uso das classes de domínio.
 * 
 * @author Rodrigo M.P Andrade
 *
 */
public interface CalculateServiceInterface {

	/**
	 * Calcula a expressão matemática proveniente de uma string
	 * 
	 * @param expression Expressão matemática
	 * 
	 * @return Resultado da expressão matemática passada como argumento.
	 */
	Double calculateExpression(String expression);

}
