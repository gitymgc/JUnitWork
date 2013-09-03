package cucumber.porker;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import poker.Card;
import poker.Pat;
import poker.PorkerGame;
import poker.Pat.OnePair;
import cucumber.annotation.ja.ならば;
import cucumber.annotation.ja.もし;
import cucumber.annotation.ja.前提;

public class PorkerGameStepDefs {

	PorkerGame  sut;

	@前提("^手札に([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+)が配られた$")
	public void 手札にカードが配られた(
			char suite1, int no1,
			char suite2, int no2,
			char suite3, int no3,
			char suite4, int no4,
			char suite5, int no5){
		sut = new PorkerGame();
		sut.setUp(Card.get(suite1, no1),
				Card.get(suite2, no2),
				Card.get(suite3, no3),
				Card.get(suite4, no4),
				Card.get(suite5,no5));
	}

	@もし("^チェンジしない$")
	public void チェンジしない() {
		sut.noChange();
	}

	@ならば("^ノーペアであるべき$")
	public void ノーペアであるべき()  {
		Pat result = sut.pat();
		assertThat(result,is(Pat.NO_PAIR));
	}

	@ならば("^(\\d+)のワンペアであるべき$")
	public void のワンペアであるべき(int no) {
		OnePair expected = new Pat.OnePair(no);
		//		Pat expected = new Pat.OnePair(no);
		int ex  = expected.no;
		Pat actual = sut.pat();
		OnePair op = null;
		if(actual.getClass().equals(OnePair.class)){
			op  = (OnePair) actual;
		}
		int ac = op.no;
				assertThat(ac, is(ex));

//		assertThat(sut.pat(), is(expected));
	}




}
