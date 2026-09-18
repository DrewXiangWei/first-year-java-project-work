import java.util.Random;
public class numbersingrid {

	public static void main(String[] args) {
		final int ROWS=5;
		final int COLS=5;
		
		int [][]array=new int[ROWS][COLS];
		
		Random random = new Random();
		
		for(int i=0; i<array.length; i++) {
			for(int j=0;j< array[i].length; j++) {
				int value = random.nextInt(100);
				array[i][j] =value;
				System.out.printf("%2d", array[i][j]);
			}
			System.out.println();
		}
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				int value=array[1+i][2+j];
				System.out.printf("%4d",value);
			}
			System.out.println();
		}
	}
}
