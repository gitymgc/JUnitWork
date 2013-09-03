package part4;
//構造化されたテストクラスでは、例外処理は扱えない、しかし後述のExpectedExceptionを使用すれば可能になる。
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import part2.Calculator;


//フィクスチャオブジェクトを使用した乗算結果取得テストクラス
@RunWith(Theories.class)
public  class list5CalculatorTest{

	//配列によるパラメータ指定・@DataPointにより、個々に生成することも可能
	@DataPoints public static Fixture[] datas = {
		new Fixture(5,5,25),
		new Fixture(2,8,15),
	};

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

