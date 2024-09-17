
public class backstacking {

	public static void printAllPaths(int maze[][], int path[][],int n,int si,int sj){

		if(si<0 || si>n-1 || sj<0 || sj>n-1 || maze[si][sj] == 0 || path[si][sj] == 1){  //Block paths
			return;
		}

		path[si][sj] = 1;

		if(si==n-1 && sj==n-1){  // Base case for destination
			
			for(int i=0;i<path.length;i++){
				for(int j=0;j<path[i].length;j++){
					System.out.print(path[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			path[si][sj] = 0;
			return;
			
		}
		
		printAllPaths(maze,path,n,si-1,sj); //top
		printAllPaths(maze,path,n,si,sj+1); //right
		printAllPaths(maze,path,n,si+1,sj); //bottom
		printAllPaths(maze,path,n,si,sj-1); //left
		
		path[si][sj] = 0;
		
	}

    public static boolean ratInAMaze(int maze[][], int path[][],int n,int si,int sj){
		if(si==n-1 && sj==n-1){  // Base case for destination
			
			path[si][sj] = 1;
			for(int i=0;i<path.length;i++){
				for(int j=0;j<path[i].length;j++){
					System.out.print(path[i][j] + " ");
				}
				System.out.println();
			}

			return true;
		}
		if(si<0 || si>n-1 || sj<0 || sj>n-1 || maze[si][sj] == 0 || path[si][sj] == 1){  //Block paths
			return false;
		}
		path[si][sj] = 1;

		if(ratInAMaze(maze,path,n,si-1,sj)){  //top
			return true;
		}
		if(ratInAMaze(maze,path,n,si,sj+1)){  // right
			return true;
		}
		if(ratInAMaze(maze,path,n,si+1,sj)){  //bottom
			return true;
		}
		if(ratInAMaze(maze,path,n,si,sj-1)){  //left
			return true;
		}
		
		return false;
	}

	public static boolean isDiagonalElement(int n, int i,int j, int x, int y){
		int a = Math.abs(i-x);

		if (i-a == x && j-a == y) {
			return true;
		}else if (i-a ==x && j+a == y) {
			return true;
		}else if (i+a == x && j-a ==y) {
			return true;
		}else if (i+a == x && j+a == y) {
			return true;
		}
		
		return false;
	}

	public static boolean isSameRowOrColumn(int n, int i,int j, int x, int y){
		if(i == x || j == y){
			return true;
		}
		return false;
	}

	public static void placeNQueens(int n){
		
		
		int[][] board = new int[n][n];
		solveNQueens(board, 0,n); 
	
	}
		
	static void solveNQueens(int board[][], int row, int N) { 
	
		if (row == N) { 
			printSolution(board,N); 
			return;
		} 
		
		
		for (int i = 0; i < N; i++) { 
			
			if ( isSafe(board, row, i, N) ) { 
				board[row][i] = 1;
				solveNQueens(board, row + 1, N); 
				board[row][i] = 0; 
			} 
		} 

	}
	
	static boolean isSafe(int board[][], int row, int col, int N) { 
		
		// for (int i = 0; i < N; i++) { 

		// 	for (int j = 0; j < N; j++) {

		// 		if(board[i][j] == 1 && (isSameRowOrColumn(N, i, j, row, col) || isDiagonalElement(N, i, j, row, col))){
		// 			return false;
		// 		}
		// 	}
		// } 
		int i,j;
		for (i=0;i<row;i++){
			if(board[i][col] == 1){
				return false;
			}
		}

		for(i=row,j=col; i>=0 && j>=0; i--,j--){
			if(board[i][j] == 1){
				return false;
			}
		}

		for(i=row,j=col; i>=0 && j<N; i--,j++){
			if(board[i][j] == 1){
				return false;
			}
		}
		
		return true; 
	} 
	
	static void printSolution(int board[][], int N) { 

		for (int i = 0; i < N; i++){ 
			for (int j = 0; j < N; j++) 
				System.out.print(board[i][j]+"  ");  
				
			System.out.println();
		} 
		System.out.println();
	} 

    public static void main(String[] args) {
		// 2-d array for maze
        // int[][] maze = {{1,1,0,0,0},
		// 				{0,1,1,1,0},
		// 				{1,0,1,1,0},
		// 				{0,1,0,1,1},
		// 				{0,1,1,1,1}};
        // int[][] path = new int[maze.length][maze[0].length]; // array to store visited elements
		// int n = maze.length;
		
        // System.out.println(ratInAMaze(maze,path,n,0,0));
		//printAllPaths(maze,path,n,0,0);
		
		placeNQueens(4);
		
		
    }
}
