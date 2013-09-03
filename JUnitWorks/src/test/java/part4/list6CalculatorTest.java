package part4;
//構造化されたテストクラスでは、例外処理は扱えない、しかし後述のExpectedExceptionを使用すれば可能になる。
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static part4.parameterForList6.*;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import part2.Calculator;


//失敗時の出力文字追加
//乗算クラスと除算クラスをネストした計算クラス
@RunWith(Enclosed.class)
public class list6CalculatorTest{

	//フィクスチャオブジェクトを使用した乗算結果取得テストクラス
	@RunWith(Theories.class)
	public static class multiplyで乗算結果取得{

		@DataPoints 
		public static Fixture[] createFixtures(){
			Fixture[] fixtures = load("a");
			return fixtures;
		}

		@Theory
		public void 乗算結果取得(Fixture fx){
			//失敗時のパラメータを示す文字列生成
			String msg = fx.x + "*" + fx.y + "=" + fx.expected;

			System.out.println(fx.x +"*"+ fx.y +"="+fx.expected);
			Calculator calc = new Calculator();
			int expected = fx.expected;
			int actual= calc.multiply(fx.x,fx.y);

			//第一引数で、パラメータ情報を含むメッセージを指定し、期待値と実測値を比較
			assertThat(msg,actual, is(expected));	

		}
		//フィクスチャオブジェクト作成
		//所持する変数を定義
		static class Fixture{
			//パラメータ
			int x,y;
			//期待値
			int expected;
			//コンクラスタで値を代入
			Fixture(int x,int y, int expected){
				this.x = x;
				this.y = y;
				this.expected = expected;
			}
		}
	}

	@RunWith(Theories.class)
	public static class divideで除算結果取得{
		//一つずつパラメータ設定も出来る
		@DataPoint public static Fixture DATA1 = new Fixture(10,5,2);

		@Theory
		public void 除算結果取得(Fixture fx){
			String msg = fx.x + "/" + fx.y + "=" + fx.expected;
			float expected = fx.expected;
			Calculator calc = new Calculator();
			float actual = calc.divide(fx.x,fx.y);
			assertThat(msg,actual,is(expected));

		}
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
}
