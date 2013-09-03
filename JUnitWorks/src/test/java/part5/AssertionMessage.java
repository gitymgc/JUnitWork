package part5;
//インポート選択注意
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

//テストルールインターフェイスを実装して作成する。
public class AssertionMessage implements TestRule {
	//可変長文字列StringBulder
	private StringBuilder msg = new StringBuilder();
	//フォーマットと入力値を引数にとる
	public void append(String format, Object...params){
		msg.append(String.format(format, params));
	}
	
	//ルールアノテーションとして動かすために必要なメソッド
	//AssertionErrorをキャッチし、メッセージを追加した新しいAssertionErroを送出
	//独自のStatementオブジェクトを返す
	@Override
	public Statement apply(final Statement base, final Description desc){
		return new Statement(){

			@Override
			public void evaluate()throws Throwable{
				try{
					base.evaluate();
				}catch(AssertionError e){
					//エラーメッセージ追加
					msg.append('\n').append(e.getMessage());
					AssertionError e2 = new AssertionError(msg.toString());
					e2.setStackTrace(e.getStackTrace());
					throw e2;	
				}
			}
		};
	}
}
