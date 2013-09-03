package part5;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import part2.Calculator;


@RunWith(Enclosed.class)
public class list1 {
	@RunWith(Theories.class)
	public static class multiplyで乗算結果取得{

		@DataPoint public static Fixture DATA1 = new Fixture(10,5,50);
		@Theory
		public void 乗算結果取得(Fixture fx){
			String msg = fx.x + "*" + fx.y + "=" + fx.expected;
			System.out.println(fx.x +"*"+ fx.y +"="+fx.expected);
			Calculator calc = new Calculator();
			int expected = fx.expected;
			int actual= calc.multiply(fx.x,fx.y);
			assertThat(msg,actual, is(expected));	

		}
		static class Fixture{
			int x,y;
			int expected;
			Fixture(int x,int y, int expected){
				this.x = x;
				this.y = y;
				this.expected = expected;
			}
		}
	}

	@RunWith(Theories.class)
	public static class divideで除算結果取得{
		@DataPoint public static Fixture DATA1 = new Fixture(10,5,2);

		@Theory
		public void 除算結果取得(Fixture fx){
			String msg = fx.x + "/" + fx.y + "=" + fx.expected;
			float expected = fx.expected;
			Calculator calc = new Calculator();
			float actual = calc.divide(fx.x,fx.y);
			assertThat(msg,actual,is(expected));

		}
		
//		@Theory(expected = IllegalArgumentException.class)
		static class Fixture{
			//パラメータ
			int x,y;
			//期待値
			float expected;
			//コンクラスタで値を代入
			Fixture(int x,int y, float expected){
				this.x = x;
				this.y = y;
				this.expected = expected;
			}
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divideの第二引数が0の場合は例外送出(){
		Calculator calc = new Calculator();
		calc.divide(5, 0);

	}
}
