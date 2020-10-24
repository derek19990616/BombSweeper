/**
 * @author Haochen Pan
 * This class contains the bomb data and number of surrounding bomb
 * User can also interact with the button, once clicked, the corrsponding image will be displayed
 */
public class BombSquare extends GameSquare
{
    private GameBoard board;                            // Object reference to the GameBoard this square is part of.
    private boolean hasBomb;                            // True if this squre contains a bomb. False otherwise.
    private int widthForBoard;
    private int heightForBoard;

    private boolean buttonClicked;                       //Check whether the button has been clicked
    private boolean buttonFlaged;                        //Check whether the button has been flaged
    private int countNum;                                //Number surrounding bomb
    private boolean bombHitStatus;                       //check whether the homb has been hit


	public static final int MINE_PROBABILITY = 10;       //Probability of the mine hit
    

    /**
     * Constructor of the class BombSquare
     * @param x x-coordinate
     * @param y y-coordinate
     * @param board the GameBoard
     */
	public BombSquare(int x, int y, GameBoard board)
	{
        super(x, y, "images/blank.png");
        this.widthForBoard = x;
        this.heightForBoard = y;

        this.board = board;
        
        this.hasBomb = ((int) (Math.random() * MINE_PROBABILITY)) == 0;
       
    }
    
    /**
     * This method is the getter of the bomb status
     * @return hasbomb status
     */
    public boolean getBombStatus(){
        return this.hasBomb;
    }

    /**
     * Thhis method can count the surrounding bomb number
     * @param x x coordnate
     * @param y y coordnate
     * @return countMine the number of mines around the selected position
     */
    private int countBombAround(int x, int y){
        int countMine = 0;
        for(int i = x - 1; i <= x + 1; i++){
            for(int j = y - 1; j <= y + 1; j++){
                BombSquare bombSquare = (BombSquare)board.getSquareAt(i, j);   //BoSq is the subclass of GaSq
                if(bombSquare.getBombStatus()) countMine++;
            }
        }
        return countMine;
       
    }
    
    /**
     * This method automatically displays the top left blank
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void showTopLeftBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x>0 && y>0 && (int)(bombSquare.countBombAround(x - 1, y -1 )) == 0) showTopLeftBlank(x - 1, y - 1);
        }
        

    }

    /**
     * This method automatically displays the top blank
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void showTopBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x>0 && (int)(bombSquare.countBombAround(x-1, y)) == 0) showTopBlank(x - 1, y);
            
        }
        
    }

    /**
     * This method automatically displays the top right blank
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void showTopRightBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x>0 && y<30 && (int)(bombSquare.countBombAround(x-1, y+1)) == 0) showTopRightBlank(x - 1, y + 1);
            
        }
        
    }

    /**
     * This method automatically displays the left blank
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void showLeftBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(y>0 && (int)(bombSquare.countBombAround(x, y-1)) == 0) showLeftBlank(x, y - 1);
            
        }
        
    }

    /**
     * This method automatically displays the right blank
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void showRightBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(y<30 && (int)(bombSquare.countBombAround(x, y+1)) == 0) showRightBlank(x, y + 1);
            
        }
        
    }

    /**
     * This method automatically displays the down left blank
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void showDownLeftBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x<30 && y>0 && (int)(bombSquare.countBombAround(x+1, y-1)) == 0) showDownLeftBlank(x + 1, y - 1);
            
        }
        
    }

    /**
     * This method automatically displays the down lank
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void showDownBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x<30 && (int)(bombSquare.countBombAround(x+1, y)) == 0) showDownBlank(x + 1, y);
            
        }
        
    }

    /**
     * This method automatically displays the down right blank
     * @param x x-coordinate
     * @param y y-coordinate
     */
    private void showDownRightBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x<30 && y<30 && (int)(bombSquare.countBombAround(x+1, y+1)) == 0) showDownRightBlank(x + 1, y + 1);
            
        }
    }

    /**
     * It's the method which image will be shown with related number
     * @param i the number which the grid will print the image with the same number shown
     * @param x the row number of the grid to change on board
     * @param y the column number of the grid to change on board
     */  
    private void setImageBasedOnNum(int i, int x, int y){
        
            switch(i){
                
                case 1:
                board.getSquareAt(x, y).setImage("images/1.png");
                break;
                case 2:
                board.getSquareAt(x, y).setImage("images/2.png");
                break;
                case 3:
                board.getSquareAt(x, y).setImage("images/3.png");
                break;
                case 4:
                board.getSquareAt(x, y).setImage("images/4.png");
                break;
                case 5:
                board.getSquareAt(x, y).setImage("images/5.png");
                break;
                case 6:
                board.getSquareAt(x, y).setImage("images/6.png");
                break;
                case 7:
                board.getSquareAt(x, y).setImage("images/7.png");
                break;
                case 8:
                board.getSquareAt(x, y).setImage("images/8.png");
                break;
                case 0:
                board.getSquareAt(x, y).setImage("images/0.png");
                showTopLeftBlank(x,y);
                showTopBlank(x,y);
                showTopRightBlank(x,y);
                showLeftBlank(x,y);
                showRightBlank(x,y);
                showDownLeftBlank(x,y);
                showDownBlank(x,y); 
                showDownRightBlank(x,y);
                break;
            }
        
    }

    /**
     * This is the setter for button clicked status
     * @param status the status of button clicked (true/false)
     */
    public void setButtonClickedStatus(boolean status){
        this.buttonClicked = status;
    }
    
    /**
     * This is the getter for the button licked status
     * @return the status of whether the button has been clicked
     */
    public boolean getButtonClickedStatus(){
        return this.buttonClicked;
    }
    
    /**
     * This is the setter for button flaged status
     * @param status whether the status of the flag is true/false
     */
    public void setButtonFlagedStatus(boolean status){
        this.buttonFlaged = status;
    }
    
    /**
     * This is the getter for the button flaged status
     * @return the status of whether the button has been flaged
     */
    public boolean getButtonFlagedStatus(){
        return this.buttonFlaged;
    }
    
    /**
     * This method is triggered only if one of the bomb has been trigger, the all others will be shown immediately, with no more buttons are available for clicking
     */
    private void printAllBomb(){
        for(int i = 0 ; i < 30; i ++){
            for(int j = 0 ; j< 30; j++){
                BombSquare bombSquare = (BombSquare)board.getSquareAt(i, j);
                bombSquare.setButtonClickedStatus(true);
                if(bombSquare.getBombStatus() == true)bombSquare.setImage("images/bomb.png");
                     
            }
        }
     
    }
    
    /**
     * This is the win condition check, if all the bomb has been flaged, then player win
     * 
     */
    private void checkWin(){
        int numOfBomb = 0;
        int numOfFlagedBomb = 0;
        for(int i = 0 ; i < 30; i ++){
            for(int j = 0 ; j< 30; j++){
                BombSquare bombSquare = (BombSquare)board.getSquareAt(i, j);
               
                if(bombSquare.getBombStatus() == true) numOfBomb++;
                if(bombSquare.getBombStatus() == true && bombSquare.getButtonFlagedStatus() == true) numOfFlagedBomb++;
                     
            }
        }
        if(numOfBomb == numOfFlagedBomb) {
            for(int i = 0; i < 30; i++){
                for(int j = 0; j < 30; j++){
                    BombSquare bombSquare = (BombSquare)board.getSquareAt(i, j);
                    bombSquare.setButtonClickedStatus(true);   //To ensure no more button can be clicked

                }
            }
            
            System.out.println("You have won the game!!!!!!!!!");
               
        }
        
        

    }
   
   /**
    * This method allows user to click the selected grid on board.
    * Once the button has been hit by the left click, it will then start to check whether the image shown on the button
    * It contains two constriants, one is whether the button has been flaged or clicked
    * Only the button without being flaged or clicked can be trigger
    *
    */
    @Override
    public void leftClicked(){
       
        int x = super.getXLocation();
        int y = super.getYLocation();
        if(getButtonFlagedStatus() == false){
            if(getButtonClickedStatus() == false){
                if(getBombStatus()){
                    super.setImage("images/bomb.png");
                    System.out.println("Position " + x + " " + y + " with bomb been clicked\n" + "Please restart the game, you have failed");
                    printAllBomb();                               //Print all bomb and lock all buttons function
                }
                else{
                    setImageBasedOnNum(countBombAround(x, y), x, y);
                    System.out.println("Position " + x + " " + y + " been clicked");
                    setButtonClickedStatus(true);                 //Only lock the selected button
                }
            }
        }
    }
     
    /**
     * This right clicked function ensure that once the cell has been flagged, it will not be able to leftclicked.
     * This function enables the flag function to add the constriant function for the button, the one being flaged can be clicked
     * If rightclicked the same button, the flag will be removed and it can be used again
     */
     @Override
    public void rightClicked(){
 
        if(getButtonClickedStatus() == false){
            if(getButtonFlagedStatus() == false){
                checkWin();                            //Check if all the bombs are flaged
                super.setImage("images/flag.png");
                setButtonFlagedStatus(true);
            }
            else{
                super.setImage("images/blank.png");
                setButtonFlagedStatus(false);;
            }
        }
    }

 
}

    


    
    
 

