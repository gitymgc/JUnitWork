package part4;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
//組み合わせテスト
@RunWith(Theories.class)
public class list2ParameterizedTest {
	
	//パラメータ設定、変数名は何でも良い
	@DataPoint
	public static int INT_PARAM_1 = 3;
	@DataPoint
	public static int INT_PARAM__2 = 4;
	@DataPoint
	public static int a = 9;
	
	//コンストラクタ
	public list2ParameterizedTest(){
		System.out.println("初期化");
	}
	
	//テストメソッド
	//(パラメータ設定数の引数乗の組み合わせ)回テストは実行される
	@Theory
	public void テスト(int param)throws Exception{
		System.out.println("test("+ param + ")");
	}
}

