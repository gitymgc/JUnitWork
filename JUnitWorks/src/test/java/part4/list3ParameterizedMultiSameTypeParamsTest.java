package part4;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class list3ParameterizedMultiSameTypeParamsTest {
	
	//パラメータ設定、変数名は何でも良い
	@DataPoint
	public static int PARAM_1 = 3;
	@DataPoint
	public static int PARAM_2 = 4;
	@DataPoint
	public static int a = 9;
	
	//テストメソッド
	//(パラメータ設定数の引数乗の組み合わせ)回テストは実行される
	@Theory
	public void test(int x, int y)throws Exception{
		System.out.println("test("+x+" , "+y+")");
	}

}

//期待値が制御しづらいため、使いどころ難しい
//ので、次のフィクスチャオブジェクトを使用して、配列と引数でパラメータを整理する。
