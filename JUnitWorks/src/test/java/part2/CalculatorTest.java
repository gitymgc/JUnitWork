package part2;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import part2.Calculator;



public class CalculatorTest {

	@Test
	public void multiply() {
		Calculator calc = new Calculator();
		int expected = 12;
		int actual= calc.multiply(3,4);
			assertThat(actual, is(expected));	
	}
	@Test
	public void multiplyFor5and7(){
		Calculator calc = new Calculator();
		int expected = 35;
		int actual = calc.multiply(5,7);
		assertThat(actual,is(expected));
		
		
	}
	@Test
	public void divideで3と2の除算結果が取得できる(){
		Calculator calc = new Calculator();
		double expected = 1.5;
		double actual = calc.divide(3, 2);
		assertThat(actual,is(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void divideの第二引数に0を指定した場合にはIllegalargumentExceptionを送出する(){
		Calculator calc = new Calculator();
		calc.divide(5,0);
	}
	
}
