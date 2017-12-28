
public class GOL {

	public static void main(String[] args) {
		// Mark er dum :)
		//StdDraw.setPenRadius(0.01);
		//StdDraw.setPenColor(StdDraw.BLUE);
		//StdDraw.line(0.2, 0.2, 0.8, 0.2);
		StdDraw.setCanvasSize(800, 800);

		int N = 30;
		double M = 0.5;

		GameState state = new GameState(N);

		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);

		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){

				int deadOrAlive = state.getCell(i,j);

				if (deadOrAlive == 1) {
					StdDraw.filledRectangle(i+M, j+M, M, M);
				} else {
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledRectangle(i+M, j+M, M, M);
					StdDraw.setPenColor(StdDraw.BLACK);
				}

			}
		}

		// Play the game.
		while (true){

			state.updateGame();
			//StdDraw.pause(150);

			for (int i = 0; i < N; i++){
				for (int j = 0; j < N; j++){

					if (state.getCell(i,j) == 1) {
						StdDraw.filledRectangle(i+M, j+M, M, M);
					} else {
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledRectangle(i+M, j+M, M, M);
						StdDraw.setPenColor(StdDraw.BLACK);
					}
				}
			}
		}
	}

}
