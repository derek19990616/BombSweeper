import java.util.*;
/**
 * This class is the class to run the game
 */
public class Driver
{

	/**
    * This is the main method in running the entire minesweeping program
    */
	public static void main(String[] Args)
	{   
		int x; //x-axis for column
		int y; //y-axis for row
		int xCheck; // check the value before pass to x
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to this test version of minesweeper game");
		System.out.println("Please enter how many rows would you want the game board be(30 only)");
		xCheck = (int)input.nextInt();
		while(xCheck != 30){
			System.out.println("Please enter the number again as the previous entry is not valid(30 only)");
			xCheck = (int)input.nextInt();

		}
		x = xCheck;
		y = x;
	                                                            //Creating the game board for the game by assigning the size
       
        
		GameBoard b = new GameBoard("BugSweeper", x, y, "BombSquare");


	}

	
	
	
}
