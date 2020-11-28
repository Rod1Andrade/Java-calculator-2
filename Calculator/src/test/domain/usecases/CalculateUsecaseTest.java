package test.domain.usecases;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.exceptions.CalculateException;
import domain.services.CalculateServiceInterface;
import domain.usecases.CalculateUsecase;

class CalculateServiceMock implements CalculateServiceInterface {
	@Override
	public Double calculateExpression(String expression) {
		return 4.0;
	}
}

class CalculateUsecaseTest {
	
	CalculateUsecase usecase = new CalculateUsecase(new CalculateServiceMock());
	
	@Test
	@DisplayName("Cáculo usando service mockado.")
	void tryCalculateAExpression() {
		usecase.setExpression("2+2");
		assertEquals(4.0, usecase.make());
	}
	
	@Test
	@DisplayName("Exceção para expressão vazia.")
	void expectAExceptionWithEmptyExpression() {
		assertThrows(CalculateException.class, () -> {
			usecase.make();
		});
	}

}
