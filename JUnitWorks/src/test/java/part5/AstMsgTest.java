package part5;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import part2.Calculator;


@RunWith(Theories.class)
public class AstMsgTest {

	@DataPoints public static Fixture[] datas  = {
		new Fixture(5,5,28)
	};

	@Rule
	public AssertionMessage message = new AssertionMessage();

	@Theory
	public void 乗算結果取得(Fixture fx){
		//有効なアサーションメッセージを追加
		message.append("case: %d * %d = %d",fx.x,fx.y,fx.expected);
		int expected = fx.expected;
		Calculator calc = new Calculator();
		int actual = calc.multiply(fx.x, fx.y);
		assertThat(actual ,is(expected));

	}

	static class Fixture{

		int x ;
		int y ;
		int expected;
		Fixture(int x, int y, int expected){
			this.x = x;
			this.y = y;
			this.expected = expected;

		}


	}
}
