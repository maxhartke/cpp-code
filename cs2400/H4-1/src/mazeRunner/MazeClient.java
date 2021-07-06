package mazeRunner;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MazeClient {
	
	/* DO NOT REMOVE OR MODIFY
	 * isPathValid()	
	 * */
	 /** check whether the path in the maze is valid.
    @param maze The original maze represented as a 2D char array.
    @param mazeWithPath The maze with the path identified by the mazeChecker class (represented as a 2D char array)
    @return True if path is valid
     */
	public static boolean isPathValid(char [][]maze, char [][]mazeWithPath)
	{
			
		//initial check: if the maze itself is the right one
		if(maze.length!=mazeWithPath.length || maze[0].length!=mazeWithPath[0].length) {
			System.out.println("Check the maze solution, row and cols numbers does not match with input");
			return false;
		}
			
		
		for(int i=0;i<maze.length;++i) {
			for(int j=0;j<maze[i].length;++j) {
				if(maze[i][j]=='X' || maze[i][j]=='S' || maze[i][j]=='E') {
					if(maze[i][j] != mazeWithPath[i][j]) {
						System.out.println("Check the maze solution, solution maze does not match with input");
						return false;
					}
				}
			}
		}
		
		//final check: check if the path valid
		char [][] result = mazeWithPath.clone();
		//get the start and exit
		int [][]StartExit = MazeClient.getStartExit(maze);
		int currentX = StartExit[0][0];
		int currentY = StartExit[0][1];
		while(true) {
			//get next step on the path
			//if there are more than one "P" in the immediate neighbhorhood, then it should be invalid
			if(!MazeClient.testForOnePathInNeighbhorhood(result, currentX, currentY))
				return false;
			
			if(MazeClient.IsCoordinateValid(maze, currentX+1, currentY) && result[currentX+1][currentY]=='P')
			{				
				result[currentX+1][currentY]='V';//visited node
				currentX=currentX+1;
				
			}
			else if(MazeClient.IsCoordinateValid(maze, currentX+1, currentY) && result[currentX+1][currentY]=='E')//reached exit
				return true;
			else if(MazeClient.IsCoordinateValid(maze, currentX-1, currentY) && result[currentX-1][currentY]=='P')
			{
				result[currentX-1][currentY]='V';//visited node
				currentX=currentX-1;
			}
			else if(MazeClient.IsCoordinateValid(maze, currentX-1, currentY) && result[currentX-1][currentY]=='E') //reached exit
				return true;
			else if(MazeClient.IsCoordinateValid(maze, currentX, currentY-1) && result[currentX][currentY-1]=='P')
			{
				result[currentX][currentY-1]='V';//visited node
				currentY=currentY-1;
			}
			else if(MazeClient.IsCoordinateValid(maze, currentX, currentY-1) && result[currentX][currentY-1]=='E')//reached exit
			{
				return true;
			}
			else if(MazeClient.IsCoordinateValid(maze, currentX, currentY+1) && result[currentX][currentY+1]=='P')
			{
				result[currentX][currentY+1]='V';//visited node
				currentY=currentY+1;
			}
			else if(MazeClient.IsCoordinateValid(maze, currentX, currentY+1) && result[currentX][currentY+1]=='E')//reached exit
			{
				return true;
			}
			else
				return false;
		}
	}
	
	/* DO NOT REMOVE OR MODIFY
	 * IsCoordinateValid()	
	 * */
	public static boolean IsCoordinateValid(char [][]maze, int x, int y) {//helper method for isPathValid()
		if(x >=0 && x < maze.length && y >= 0 && y < maze[0].length)
			return true;
		else
			return false;		
	}
	/* DO NOT REMOVE OR MODIFY
	 * testForOnePathInNeighbhorhood()	
	 * */
	public static boolean testForOnePathInNeighbhorhood(char [][]maze, int x, int y) {//helper method for isPathValid()
		int count=0;
		if(MazeClient.IsCoordinateValid(maze,x+1,y) && (maze[x+1][y]=='P' || maze[x+1][y]=='E'))
			count++;
		if(MazeClient.IsCoordinateValid(maze,x-1,y) && (maze[x-1][y]=='P'  || maze[x+1][y]=='E'))
			count++;
		if(MazeClient.IsCoordinateValid(maze,x,y-1) && (maze[x][y-1]=='P'  || maze[x+1][y]=='E'))
			count++;
		if(MazeClient.IsCoordinateValid(maze,x,y+1) && (maze[x][y+1]=='P'  || maze[x+1][y]=='E'))
			count++;
		
		if(count>1) 
			return false;
		else
			return true;
		
	}
	
	/* DO NOT REMOVE OR MODIFY
	 * printMaze()
	 * * 
	 * */
	/** prints out a given maze.
    @param maze represented as a 2D char array.   
     */
	public static void printMaze(char [][]maze) {
		String row;
		for(int i=0;i<maze.length;i++) {
			row = new String();
			for(int j=0; j < maze[i].length;j++) {
				row = row + maze[i][j];
			}
			System.out.println(row);
		}
	}
	
	/* DO NOT REMOVE OR MODIFY
	 * readMazeFromFile()
	 * */
	/** Reads the maze from a text file.
    @param fileName file name containing the maze. 
    @return maze, represented as a 2D char array.   
     */
	
	/*
	 * 
	 * */
	public static char[][] readMazeFromFile(String fileName) {
		char [][] maze=null;
		//read the size from the file
		String str;
		int rows, cols;
		int cnt=0;
		try
	    {
			File myFile=new File(fileName);
	 		Scanner scan=new Scanner(myFile);
	 		str=scan.nextLine(); // read no of rows
	 		rows = Integer.parseInt(str);
	 		
	 		str=scan.nextLine(); // read no of columns
	 		cols = Integer.parseInt(str);
	 		
	 		maze = new char[rows][cols];
			
	 		while(scan.hasNextLine())
			{				
	 			str=scan.nextLine();
	 			maze[cnt++]=str.toCharArray();	 			
	        }
			scan.close();
	    }    //end of try block of code!!!!!!
	    catch(IOException ioe)
	    { 
			System.out.println("Error in readMazeFromFile... Exiting");			
			System.exit(-1);
		}
		return maze;
		
	}
	/* DO NOT REMOVE OR MODIFY
	 * getStartExit()
	 * */
	public static int[][] getStartExit(char[][] mazeWithPath){ //helper method
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
	
	public static void main(String[] args) {
		mazeChecker checker = new mazeChecker();
		//read the maze from test case 1
		char [][]maze=MazeClient.readMazeFromFile("testcase1");
		char [][]mazeWithPath = checker.identifyPath(maze);

		if(maze!=null) {// to make sure there was a valid input
			if(mazeWithPath==null)
				System.out.println("No Path Found");
			else if(MazeClient.isPathValid(maze, mazeWithPath))
				System.out.println("Path correct");
			else 
				System.out.println("Path incorrect");					
		}
	}

}
