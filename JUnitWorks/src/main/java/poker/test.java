package poker;

public class test {
	
	public static void main(String[] args){
		int i = 0;
		i = getR();
		System.out.println(i);
	}

	private static int getR() {
		
		for(int y = 0; y < 10; y++){
			if(y == 5){
				return 5;
			}
		}
		return 0;
	}

}
