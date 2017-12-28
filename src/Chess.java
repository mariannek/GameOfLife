/**************************************************************
 * Compilation: javac CheckerBoard.java
 * Execution: java CheckerBoard N
 * Dependencies: StdDraw.java
 *
 * Plots an NxN red and black checkerboard.
 * Lower left square is red. (Ex. 1.5.18)
 **************************************************************/

public class Chess {

	public static void main(String[] args) {
		// declaration and initialization - How big?
		int N = Integer.parseInt(args[0]);
		double len = 0.5;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);

		// Draw from lower left, up and across
		// i is the index for the x value. j is the index for y.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ( ((i+j) % 2) == 0 )
					StdDraw.setPenColor(StdDraw.BLACK);
				else StdDraw.setPenColor(StdDraw.RED);
				StdDraw.filledSquare(i+len, j+len, len);
			}
		}

		StdDraw.show();
	}
}