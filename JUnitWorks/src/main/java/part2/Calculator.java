package part2;

public class Calculator {
	public int  multiply(int x, int y){
		return x * y;
	}
	//修正後
	public float divide(int x, int y){
		if(y == 0)throw new IllegalArgumentException();
		return (float)x/ (float)y;
	}

}
