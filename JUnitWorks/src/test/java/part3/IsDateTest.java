package part3;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static part3.IsDate.*;

import java.util.Date;

import org.junit.Test;
//アサーションの拡張
public class IsDateTest {

	@Test
	public void test() {
//		
		assertThat(new Date(), is(dateOf(2013,9,02)));
	}

}
