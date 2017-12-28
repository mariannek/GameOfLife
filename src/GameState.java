/**
 * The class DeadOrAlive provides the following
 * (1) 
 * Given a matrix of alive or dead states this returns a new matrix the same size fulfilling the game of life rules.
 **/


public class GameState {

	/**
	 * The matrix holding information of which cells are dead or alive
	 */
	int[][] gameMatrix; // This is the starting matrix for GOL
	/**
	 *  The size the user wants the game to be, in our case it is the size of the matrix
	 */
	int matrixSize;

	/**
	 * Takes a user specific parameter and makes the starting position of Game of life.
	 * @param N
	 */
	public GameState(int N){

		matrixSize   = N;
		gameMatrix   = new int [matrixSize][matrixSize];

		for (int i = 0; i < matrixSize; i++){
			for (int j = 0; j < matrixSize; j++){
				if (Math.random()>0.8){
					gameMatrix[i][j] = 1; // one is implying that the cell is alive.
				}
			}
		}
	}

	/**
	 * Returns the chosen cell's current status. 1 means alive and 0 means dead. 
	 * @param i
	 * @param j
	 * @return
	 */
	public int getCell(int i, int j){
		return gameMatrix[i][j];

	}

	/**
	 * The method plays one round of Game of life.
	 * It uses the information from the current gameMatrix and update the matrix updateMatrix.
	 */
	public void updateGame(){
		
		int[][] updateMatrix = new int [matrixSize][matrixSize];
		int numberOfNeighbours;

		for (int i = 0; i < matrixSize; i++){
			for (int j = 0; j < matrixSize; j++){
				numberOfNeighbours = 0;

				numberOfNeighbours += (i == 0) ? 0 : gameMatrix[i-1][j];
				numberOfNeighbours += (j == matrixSize-1) ? 0 : gameMatrix[i][j+1];
				numberOfNeighbours += (j == 0) ? 0 : gameMatrix[i][j-1];
				numberOfNeighbours += (i == matrixSize-1) ? 0 : gameMatrix[i+1][j];
				numberOfNeighbours += (i == 0 || j == 0) ? 0 : gameMatrix[i-1][j-1];
				numberOfNeighbours += (i == matrixSize-1 || j == matrixSize-1) ? 0 : gameMatrix[i+1][j+1];
				numberOfNeighbours += (i == 0 || j == matrixSize-1) ? 0 : gameMatrix[i-1][j+1];
				numberOfNeighbours += (i == matrixSize-1 || j == 0) ? 0 : gameMatrix[i+1][j-1];

				// If the cell is alive there is one set of rules and another if dead.
				if (gameMatrix[i][j] == 1){
					// Now play game of life:
					if (numberOfNeighbours < 2){
						updateMatrix[i][j] = 0; // the cell dies
					} else if (numberOfNeighbours < 4){
						updateMatrix[i][j] = 1; // the stays alive
					} else {
						updateMatrix[i][j] = 0; // the cell dies
					}
				} else {
					if (numberOfNeighbours == 3){
						updateMatrix[i][j] = 1; // the cell lives up
					}

				}
			}
		}
		gameMatrix = updateMatrix;

	}
}





