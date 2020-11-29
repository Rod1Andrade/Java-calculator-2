package test.external.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.entities.Operator;
import external.models.BaseCalc;
import external.models.SumCalc;
import external.services.CalculateService;

class CalculateServiceImplementedTest {
	
	CalculateService service = new CalculateService();
	
	@Test
	@DisplayName("Testando separação de números por operador.")
	void test() {
		List<BaseCalc> baseCalcs = new ArrayList<>();
		baseCalcs.add(new SumCalc(new Operator('+', "Sum", 1)));
		baseCalcs.add(new SumCalc(new Operator('-', "Sub", 2)));
		
		service.setBaseCalcList(baseCalcs);
		List<Double> list = service.separeteNumberFromOperators("2+20-11");
	
		for(Double d: list) {
			System.out.println(d);
		}
		
		assertTrue(true);
	}

}
