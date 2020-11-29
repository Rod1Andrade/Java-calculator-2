package domain.usecases;

import domain.exceptions.CalculateException;
import domain.services.CalculateServiceInterface;
import domain.utils.constants.Message;

/**
 * Caso de Uso responsável por fazer o cálculo.
 * 
 * @author Rodrigo M.P Andrade
 *
 */
public class CalculateUsecase implements Usecase<Double> {

	private CalculateServiceInterface calculateService;
	private String expression;

	@Override
	public Double make() {
		this.validate();
		return this.getCalculateService().calculateExpression(this.getExpression());
	}
	
	/**
	 * Construtor para injetar depedência.
	 * 
	 * @param calculateService
	 */
	public CalculateUsecase(CalculateServiceInterface calculateService) {
		this.calculateService = calculateService;
	}

	/**
	 * Validações para a o caso de uso.
	 */
	private void validate() {
		if (this.emptyExpression()) {
			throw new CalculateException(Message.EMPTY_EXPRESSION);
		}
	}

	/**
	 * Verifica se a expressão está vazia
	 * 
	 * @return True caso esteja vazia e falso caso contrário.
	 */
	private boolean emptyExpression() {
		return this.getExpression() == null || this.getExpression().isEmpty();
	}

	/**
	 * Retorna a expressão matemática
	 * 
	 * @return String
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Define a expressão matemática
	 * 
	 * @param expression Expressão matemática a ser cálculada
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

	/**
	 * Retorna o Calculate Service
	 * 
	 * @return CalculateService
	 */
	private CalculateServiceInterface getCalculateService() {
		return this.calculateService;
	}
}
