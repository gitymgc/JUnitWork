package poker;

import java.util.HashMap;
import java.util.Map.Entry;

public class Pat {
	public static final Pat NO_PAIR = new NoPair();
	public static Pat make(Hands hands){
		//ペアの数を数える
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>(5);
		for(Card card : hands){
			//HashMapに現行数字のカードが今まで加算された分のカウント呼び出し
			Integer count = nums.get(card.no);
			//初めてはnullなので、0を入れる
			if(count == null)count = 0;
			//現行カード分加算
			count++;
			//そのカウントを、HashMapに上書き
			nums.put(card.no, count);
		}
		//HashMapからEntrySet獲得
		for(Entry<Integer,Integer> entry : nums.entrySet()){
			//カウントが2だったら、つまり上記のfor分で二度同じ数字が入ってきていたら、OnePairオブジェクトを返す。
			if(entry.getValue() == 2)
				return new OnePair(entry.getKey());
		}
		//TODO 他の役の実装
		//なにもなければノーペア
		return NO_PAIR;
	}
	public static class NoPair extends Pat{
		
	}
	public static class OnePair extends Pat{
		//メンバ変数
		public final int no;
		//コンクラスタ
		public OnePair(int no){
			//ペアの数字の値を所持
			this.no = no;
		}
		//hashCode,equalsメソッドは省略
		
	}
}
