package presenter.controller;

import domain.usecases.CalculateUsecase;
import external.services.CalculateService;
import presenter.utils.Constants;

/**
 * Controller do Resultado.
 * 
 * @author Rodrigo M.P Andrade
 * @since 1 de dez. de 2020
 *
 */
public class ResultController {

	private CalculateUsecase usecase;
	private String value;

	/**
	 * Construtor
	 * 
	 * @param result Componente Result
	 */
	public ResultController(CalculateService calculateService) {
		this.value = "";
		this.usecase = new CalculateUsecase(calculateService);
	}

	/**
	 * Concatena o valor
	 * 
	 * @param value Valor a ser concatenado
	 */
	public void concatValue(String value) {
		if (this.value.trim().equals(Constants.DEFAULT_VALUE)) {
			this.value = value;
		} else {
			this.value += value;
		}
	}

	/**
	 * Concatena o valor
	 * 
	 * @param value Valor a ser concatenado
	 */
	public void concatValue(Character value) {
		if (this.value.trim().equals(Constants.DEFAULT_VALUE)) {
			this.value = String.valueOf(value);
		} else {
			this.value += String.valueOf(value);
		}
	}

	/**
	 * Deleta o ultimo valor
	 */
	public void deleteLastValue() {
		if (this.value.length() > 0 && !this.value.trim().equals(Constants.DEFAULT_VALUE)) {
			char lastChar = this.value.charAt(this.value.length() - 1);
			int lastIndex = this.value.lastIndexOf(lastChar);

			this.value = this.value.substring(0, lastIndex);
		}

		if (this.value.isEmpty()) {
			this.value = Constants.DEFAULT_VALUE;
		}
	}

	/**
	 * Aplica a expressao a uma funcao para obter o resultado
	 */
	public String makeResult() {
		this.usecase.setExpression(this.value);
		this.value = String.valueOf(this.usecase.make());
		return this.value;
	}

	/**
	 * Retorna o valor
	 * 
	 * @return String
	 */
	public String getValue() {
		return this.value;
	}

}
