import java.util.*;
public class Driver
{

	
	public static void main(String[] Args)
	{   
		int x;
		int y;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the size of your game for x axis");
		x = (int)input.nextInt();
		System.out.println("Please enter the size of your game for y axis");
		y = (int)input.nextInt();

		GameBoard b = new GameBoard("BugSweeper", x, y, "BombSquare");
		BombSquare[][] bs = new BombSquare[x][y];
		boolean[][] boardMine = new boolean[x][y];
		for(int i = 0 ; i < x; i++){
			for(int j = 0; j < y; j++){
				bs[i][j] = new BombSquare(i, j, b);
				if(bs[i][j].getBombStatus())
				boardMine[i][j] = true;
				else boardMine[i][j] = false;
	
			}
		}
		for(int i = 0 ; i < x; i++){
			for(int j = 0; j < y; j++){
                if(boardMine[i][j] != true){
				    bs[i][j].setCountNum(checkNumSurroundBomb(i, j, boardMine, x, y));
					System.out.println("Position "+ i + " " + j + " " + " with num " + bs[i][j].getCountNum());
				}
				else if(boardMine[i][j] == true){
					System.out.println("Position "+ i + " " + j + " " + " with bomb ");

				}
			}
		}
	   
		


		

	}
	 private static int checkNumSurroundBomb(int i, int j, boolean[][] boardMine, int x, int y){
       
        int countMine = 0;    
        if(boardMine[i][j] == false){
            
            if(i!=0 && j!=0 && boardMine[i-1][j-1] == true) countMine++;           //top left
            if(i!=0 && boardMine[i-1][j] == true) countMine++;                     //top
            if(i!=0 && j < y-1 && boardMine[i-1][j+1] == true) countMine++;          //top right
            if(j!=0 && boardMine[i][j-1] == true) countMine++;                     //left
            if(j < x-1 && boardMine[i][j+1] == true) countMine++;                    //right
            if(i < x-1 && j!=0 && boardMine[i+1][j-1] == true) countMine++;          //down left
            if(i < x-1 && boardMine[i+1][j] == true) countMine++;                    //down
            if(i < x-1 && j < y-1 && boardMine[i+1][j+1] == true) countMine++;         //down right
            
        }
        return countMine;

	}
	
	
}
