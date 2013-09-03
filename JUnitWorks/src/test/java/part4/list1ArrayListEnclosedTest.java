package part4;
//コンテキストで構造化

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
//ネストしたクラスを実行するためのテストランナー
@RunWith(Enclosed.class)
public class list1ArrayListEnclosedTest {
	
	//共通処理グループ名
	public static class 初期状態のとき{
		private ArrayList<String> list;
		//共通初期化処理
		@Before
		public void setUp() throws Exception{
			list = new ArrayList();
		}
		
		@Test
		public void sizeは0を返す() throws Exception{
			int actual = list.size();
			int expected = 0;
			assertThat(actual,is(expected));
		}
		
		@Test
		public void addでHelloを追加するとget0はHelloを返す(){
			list.add("Hello");
			String actual = list.get(0);
			String expected = "Hello";
			assertThat(actual,is(expected));
		}
	}
	//共通処理グループ名
	public static class Helloが含まれるとき{
		private ArrayList<String> list;
		//共通初期化処理
		@Before
		public void setUp()throws Exception{
			list = new ArrayList();
			list.add("Hello");
		}
		
		@Test
		public void sizeは1を返す()throws Exception{
			int actual = list.size();
			int expected = 1;
			assertThat(actual , is(expected));
		}
		
		@Test
		public void addでWorldを追加するとget0はHelloを返す()throws Exception{
			list.add("World");
			String actual = list.get(0);
			String expected = "Hello";
			assertThat(actual , is(expected));
		}
		
		@Test
		public void addでWorldを追加するとget1はWorldを返す()throws Exception{
			list.add("World");
			String actual = list.get(1);
			String expected = "World";
			assertThat(actual , is(expected));
		}
	}

	
}
