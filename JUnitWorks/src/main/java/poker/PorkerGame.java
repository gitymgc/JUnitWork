package poker;

public class PorkerGame {
	//列挙型
	private enum Status {
		INIT, READY,  CHANGED
	}

	private Status status = Status.INIT;
	private Hands hands = null;
	//可変長引数にカードオブジェクトをとるメソッド
	public void setUp(Card...cards){
		//ステータスが初期状態じゃなかったら例外送出
		if(status != Status.INIT)
			throw new IllegalStateException();
		//手札オブジェクト作成
		hands = new Hands(cards);
		//準備完了
		this.status = Status.READY;
	}
		//チェンジ無しなら
	public void noChange(){
		//手札が準備できてないなら例外送出
		if(status != Status.READY)
			throw new IllegalStateException();
		// do nothing何もせずに、statusの状態のみ変更
		this.status = Status.CHANGED;
	}
	public Pat pat(){
		if(status != Status.CHANGED)
			throw new IllegalStateException();
		
		return Pat.make(hands);
	}
	
}
