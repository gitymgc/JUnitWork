package part3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
//Matcherインターフェースを実装したBaseMatcherクラスのサブクラスとして、カスタムMatcherクラス作成
//通知情報作成describeToと比較検証matchesを実装する。
public class IsDate extends BaseMatcher<Date>{
	//メンバ変数
	private final int yyyy;
	private final int mm;
	private final int dd;

	//コンストラクタ
	IsDate(int yyyy,int mm, int dd){
		this.yyyy = yyyy;
		this.mm = mm;
		this.dd = dd;
	}
	
	//コンストラクタに期待値を渡すスタティックファクトリメソッド
	public static Matcher<Date> dateOf(int yyyy,int mm, int dd){
		//戻り値として、カスタムMatcherクラスを返す
		return new IsDate(yyyy,mm,dd);
	}
	//実測値
	Object actual;
	//assertThatによって呼びだされるメソッド
	//何を持ってマッチとするかを決められる、比較対象の取捨選択
	@Override
	public boolean matches(Object actual){
		
		this.actual = actual;
		if(!(actual instanceof Date))return false;
		Calendar cal = Calendar.getInstance();
		cal.setTime((Date)actual);
		if(yyyy != cal.get(Calendar.YEAR))return false;
		if(mm != cal.get(Calendar.MONTH) + 1)return false;
		if(dd != cal.get(Calendar.DATE))return false;
		return true;
	}
	
	//assertThat内appendDescriptionOf内のSelfDescribingによって実行されるメソッド
	//間違った時の処理を詳細に決められる
	//StringBulderのようなメソッドの使い方
	@Override 
	public void describeTo(Description desc){
		//オブジェクトを引数に、値としての文字列表記を追加
		desc.appendValue(yyyy + "/" + mm + "/" + dd);
		if(actual != null){
			//単純に文字列を追加
			desc.appendText("but actual is");
			desc.appendValue(new SimpleDateFormat("yyyy/MM/dd").format((Date) actual));
		}

	}

}
