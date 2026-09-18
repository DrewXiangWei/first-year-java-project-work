import java.util.Random;

public class Assignment1Start {
	private static final int ROWS = 5;
	private static final int COLS = 5;

	public static void main(String[] args) {
		int[][] numbers = new int[ROWS][COLS];
		Random random = new Random();
		System.out.println("\nGenerated numbers:\n");
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[0].length; j++) {
				numbers[i][j] = random.nextInt(100);
				System.out.printf("%4d", numbers[i][j]);
			}
			System.out.println();
		} // set a point in my array
		int row = random.nextInt(ROWS);
		int col = random.nextInt(COLS);
		System.out.printf("\nRow : %d, Column : %d\n", row, col);
// Your code goes here:
		System.out.println("\nNumber to consider:\n");
		int sum = 0;
		int total = 0;
		for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, ROWS - 1); i++) {
			for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, COLS - 1); j++) {
				if (i != row || j != col) {
					System.out.printf("%4d", numbers[i][j]);
					sum = sum + numbers[i][j];
					total++;
				}
			}
			System.out.println();
		}
		int average = sum / total;
		System.out.printf("\nSum : %d, Average :%d\n", sum, average);
	}
}