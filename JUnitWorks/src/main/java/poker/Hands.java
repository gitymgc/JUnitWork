package poker;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Hands implements Iterable<Card>{
	private static final int SIZE = 5;
	private final Set<Card> hands = new HashSet<Card>(SIZE);
	public  Hands(Card...cards){
		//引数の数が手札と一致しなければ例外送出
		if(cards.length != SIZE)
			throw new IllegalArgumentException();
		//HashSetにカードオブジェクト追加
		for(Card card : cards){
			hands.add(card);
		}
	}
	//コレクションに順番にアクセス
	@Override
	public Iterator<Card> iterator(){
		return hands.iterator();
	}

}
