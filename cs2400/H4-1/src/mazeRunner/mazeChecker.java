package mazeRunner;

/*	READ THIS!! IMPORTANT!!!
 * You cannot modify the name or declaration of the class.
You have to use this class in this implementation
You may add methods or attributes 

*/

public class mazeChecker {
	
	/* DO NOT REMOVE the method OR CHANGE the definition
	 * identifyPath()	
	 * */
	/** Identifies a valid path from the Start to the Exit.
    @param //maze a 2D char array representing the original maze.
    @return 2D char array that is similar to the input maze and also has the path indicated   
     */
     /*
      * Example:
      * For the following 2D char array input:
      * 
      * XXXXSXX
	  * XX   XX
      * XX XXXX
      * XX    X
      * XXXXEXX 
      *
      * The method should return the following 2D char array.(The output should also have the X, S, and E positions from the input array)
      * 
      * XXXXSXX
      * XXPPXXX
      * XXPXXXX
      * XXPPP X
      * XXXXEXX
      * 
	*/

	public int[][] getStartExit(char [][]mazeWithPath){ //helper method
		int [][] retVal=new int[2][2];//x and y coordinates of the start and exit
		//retVal[0][0], retval[0][1] has the X and Y coordinates of start
		//retVal[1][0], retval[1][1] has the X and Y coordinates of exit
		//you can assume that are distinct start and exit in the maze
		for(int i=0;i<mazeWithPath.length;++i) {
			for(int j=0;j<mazeWithPath[i].length;++j) {
				if(mazeWithPath[i][j]=='S') {
					retVal[0][0] = i;
					retVal[0][1] = j;
				}else if(mazeWithPath[i][j]=='E') {
					retVal[1][0] = i;
					retVal[1][1] = j;
				}
			}
		}
		return retVal;
	}

	public static boolean IsCoordinateValid(char [][]maze, int x, int y) {//helper method for isPathValid()
		if(x >=0 && x < maze.length && y >= 0 && y < maze[0].length)
			return true;
		else
			return false;
	}

	public static boolean testForWall(char [][]maze, int x, int y) {//helper method for isPathValid()
		int count=0;
		if(MazeClient.IsCoordinateValid(maze,x+1,y) && (maze[x+1][y]=='X'))
			count++;
		if(MazeClient.IsCoordinateValid(maze,x-1,y) && (maze[x-1][y]=='X'))
			count++;
		if(MazeClient.IsCoordinateValid(maze,x,y-1) && (maze[x][y-1]=='X'))
			count++;
		if(MazeClient.IsCoordinateValid(maze,x,y+1) && (maze[x][y+1]=='X'))
			count++;

		if(count==3)
			return true;
		else
			return false;

	}

	public int[] getNextPath(char [][]maze, int x, int y){
		int [] nextPathCoordinate = new int[2];
		nextPathCoordinate[0] = x;
		nextPathCoordinate[1] = y;
		if(x > 0 && maze[x - 1][y] == ' ' ) {
			 	nextPathCoordinate[0] = x-1;
			 	nextPathCoordinate[1] = y;
		}
		if(x < maze.length && maze[x + 1][y] == ' ') {
				nextPathCoordinate[0] = x+1;
				nextPathCoordinate[1] = y;
		}
		if(y > 0 && maze[x][y-1] == ' '){
				nextPathCoordinate[0] = x;
				nextPathCoordinate[1] = y-1;
		}
		if(y < maze[0].length && maze[x][y + 1] == ' ') {
				nextPathCoordinate[0] = x;
				nextPathCoordinate[1] = y+1;
		}
 		return nextPathCoordinate;
	}

	public char[][] identifyPath(char [][] maze){
		char [][] mazeWithPath = null;
		int row = maze.length;
		int col = maze[0].length;
		mazeWithPath = new char[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				mazeWithPath[i][j] = maze[i][j];
			}

		}

		LinkedStack<int []> mazePath = new LinkedStack();

		int [][] startEnd = getStartExit(mazeWithPath);
		int x, y;
		x = startEnd[0][0];
		y = startEnd[0][1];
		int [] path;
		while(true){
			path = getNextPath(mazeWithPath, x, y);
			x = path[0];
			y = path[1];
			mazeWithPath[x][y] = 'P';
			if(testForWall(mazeWithPath, x, y) == true){
				while (mazeWithPath[x][y] != ' '){
					mazeWithPath[x][y] = 'V';
					int [] back = mazePath.peek();
					path = getNextPath(mazeWithPath,back[0], back[1]);
					x = path[0];
					y = path[1];
					mazePath.pop();
					if(mazePath.isEmpty()){
						mazeWithPath = null;
						break;
					}
				}
				mazeWithPath[x][y] = 'P';
			}
			mazePath.push(path);

			//wall or end, if wall pop and if return to start return null for no path
			if(mazeWithPath[x+1][y] == 'E'){
				break;
			}
		}
		return mazeWithPath;
	}
}
