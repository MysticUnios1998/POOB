package aplicacion;

import java.util.Arrays;

public class Replicate {

	private boolean[][] board;
	private int height;
	private int width;
	
	
	/**
	 * Constructor principal de la clase Replicate.
	 * @param fila numero de filas del juego.
	 * @param columna numero de columnas del juego.
	 * @throws ReplicateException si el numero de filas/columnas es menor a 1.
	 */
	public Replicate(int filas, int columnas) throws ReplicateException{
		if (filas<1 || columnas<1) throw new ReplicateException(ReplicateException.INVALID_BOARD);
		board = new boolean[filas][columnas];
		height = filas;
		width = columnas;
	}
	
	
	/**
	 * Cambia el estado de la casilla seleccionada a "true". La coordenadas se cuentan desde 0.
	 * @param fila coordenada de la fila de la casilla.
	 * @param columna coordenada de la columna de la casilla.
	 * @return si la operacion se llevo a cabo con exito o no
	 * @throws ReplicateException si las coordenadas son incorrectas.
	 */
	public boolean llenar(int fila, int columna) throws ReplicateException{
		if (height*width < fila*columna || fila < 0 || columna < 0)  throw new ReplicateException(ReplicateException.INVALID_COORDINATES);
		boolean opAnswer = !board[fila][columna];
		if (opAnswer) board[fila][columna] = true;
		return opAnswer;
	}
	
	
	/**
	 * Hace que el juego cambie de estado según el siguiente criterio: Cada celda
	 * revisa las celdas adyacentes (incluyéndose) y cuenta la cantidad que tiene estado "encendido". 
	 * Si este número es impar, el siguiente estado de la celda será "enendido", de lo contrario será "apagado".
	 * @return si el estado del juego cambió o se mantuvo constante.
	 */
	public boolean replicar() {
		boolean opAnswer = false;
		boolean newCell;
		boolean[][] newState = new boolean[height][width];
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				newCell = countCells(i,j)%2 == 1;
				if (newCell != board[i][j] && !opAnswer) opAnswer = true;
				newState[i][j] = newCell;
			}
		}
		board = newState;
		return opAnswer; 
	}
	
	/**
	 * Consultar el estado actual del tablero.
	 * @return arrayMatrix con el estado de las celdas del juego.
	 */
	public boolean[][] consulte(){
		boolean[][] actualState = new boolean[height][];
		for (int i=0; i<height; i++) actualState[i] = Arrays.copyOf(board[i], width); 
		return actualState;
	}
	
	private int countCells(int i, int j) {
		int[] posX = new int[] {-1,-1,-1,0,0,0,1,1,1};
		int[] posY = new int[] {-1,0,1,-1,0,1,-1,0,1};
		int cellsCount = 0;
		for (int x=0; x<9; x++) {
			if (0<=i+posX[x] && i+posX[x]<height && 0<=j+posY[x] && j+posY[x]<width) cellsCount += (board[i+posX[x]][j+posY[x]]) ? 1:0;
		}
		return cellsCount;
	}

}
