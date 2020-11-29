package test.external.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.entities.Operator;
import external.models.BaseCalc;
import external.models.SubCalc;
import external.models.SumCalc;
import external.services.CalculateService;

/**
 * @author Rodrigo M.P Andrade
 * @since 29 de nov. de 2020
 *
 */
class CalculateServiceTest {

	List<BaseCalc> baseCalcList = new ArrayList<>();
	CalculateService calculateService = new CalculateService();

	@BeforeEach
	void init() {
		baseCalcList.add(new SumCalc(new Operator('+', "Sum", 1)));
		baseCalcList.add(new SubCalc(new Operator('-', "Sub", 1)));
		
		calculateService.setBaseCalcList(baseCalcList);
	}

	@Test
	@DisplayName("Soma de dois números")
	void trySumTwoNumbers() {
		String expression = "2+2";
		assertEquals(4.0, calculateService.calculateExpression(expression));
	}
	
	@Test
	@DisplayName("Subtração de dois números")
	void trySubTwoNumbers() {
		String expression = "2-2";
		assertEquals(0.0, calculateService.calculateExpression(expression));
	}
	
	@Test
	@DisplayName("Expressão com soma e subtração")
	void tryExpressionWithSumAndSub() {
		String expression = "2-2+4";
		assertEquals(4.0, calculateService.calculateExpression(expression));
	}

}
