public class Recap {
	public static void main(String[] args) {
		int[] cube1= {9,5,7,7};
		int[] cube2= {9,7,7,5};
		int[] cube3= {5,1,9,5};
		int[] cube4= {7,6,9,2};
		int[] cube5= {1,9,2,9};
		int[] cube6= {5,9,8,7};
		int[] cube7= {8,1,5,1};
		int[] cube8= {2,9,8,3};
		int[] cube9= {8,3,5,6};
		//3x3 grid
		int[][]row1= {cube1,cube2,cube3};
		int[][]row2= {cube4,cube5,cube6};
		int[][]row3= {cube7,cube8,cube9};
		
		int[][][]gameGrid= {row1,row2,row3};
		System.out.println(gameGrid);		
		// TODO Auto-generated method stub

	}

}
