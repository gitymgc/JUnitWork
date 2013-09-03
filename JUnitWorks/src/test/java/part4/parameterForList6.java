package part4;

import part4.list6CalculatorTest.multiplyで乗算結果取得.Fixture;



public class parameterForList6 {

	public static Fixture[] load(String s){
		Fixture fx[] = new Fixture[2];
		if(s.equals("a")){

			fx[0] = new Fixture(9,9,81);
			fx [1] = new Fixture(8,8,64);

		}
		return fx;
	}
}

