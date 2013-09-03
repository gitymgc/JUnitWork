package part5;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Rule;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import part2.Calculator;



/*
 * パラメータ化されたテストクラスで例外を送出する。
 * ルールを使う
 * 宣言的に利用でき、テストクラス単位で適用できる拡張フレームワーク
 * 継承と異なり、いくつも宣言できる
 */


@RunWith(Enclosed.class)
public class List2DivideOfExpectedExceptionAndAssumeTrueTest {

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
	public static class 除算メソッドのパラメータ化テスト{
		@DataPoints
		public static Fixture[] DATAS = {
			new Fixture(3,2,1.5f),
			new Fixture(10,2,5f),
			new Fixture(3,0,null),
			new Fixture(10,0,null)
		};

		/*
		 * 例外検証クラス
		 * エラーメッセージの検証も行う。
		 * カスタムMatcherも指定できるため、柔軟な検証も行う事が出来る。⇔@expectedは例外の型しか検証出来ない。
		 * noneメソッドによるインスタンス取得
		 * 
		 */
		@Rule
		public ExpectedException exception = ExpectedException.none();
		@Rule
		public Timeout to = new Timeout(1);

		@Theory
		public void divideによる除算結果取得(Fixture fx){
			/*
			 * assumeTrueメソッドで、条件規定、条件外は無視、失敗とはならない。
			 */
			Assume.assumeTrue(fx.y != 0);
			Calculator calc = new Calculator();
			float expected = fx.expected;
			float actual = calc.divide(fx.x, fx.y);
			assertThat(actual,is(expected));
		}

		//例外排出も、一つのTheoryにまとめられる
		@Theory
		public void divideの第二引数に0の場合例外送出(Fixture fx){
			Assume.assumeTrue(fx.y == 0);
			//予期される例外をexpectメソッドに渡す
			exception.expect(IllegalArgumentException.class);
			Calculator calc = new Calculator();
			calc.divide(fx.x,fx.y);

		}
		//フィクスチャオブジェクト
		static class Fixture{
			int x,y;
			Float expected;
			Fixture(int x, int y, Float expected){
				this.x = x;
				this.y = y;
				this.expected = expected;

			}
		}
	}
}
