public class BombSquare extends GameSquare
{
    private GameBoard board;                            // Object reference to the GameBoard this square is part of.
    private boolean hasBomb;                            // True if this squre contains a bomb. False otherwise.
    private int widthForBoard;
    private int heightForBoard;

    private boolean buttonClicked;
    private boolean buttonFlaged;
    private int countNum;
    private boolean bombHitStatus;


	public static final int MINE_PROBABILITY = 10;

	public BombSquare(int x, int y, GameBoard board)
	{
        super(x, y, "images/blank.png");
        this.widthForBoard = x;
        this.heightForBoard = y;

        this.board = board;
        
        this.hasBomb = ((int) (Math.random() * MINE_PROBABILITY)) == 0;
       
    }
    


    public boolean getBombStatus(){
        return this.hasBomb;
    }

    public int countBombAround(int x, int y){
        int countMine = 0;
        for(int i = x - 1; i <= x + 1; i++){
            for(int j = y - 1; j <= y + 1; j++){
                BombSquare bombSquare = (BombSquare)board.getSquareAt(i, j);   //BoSq is the subclass of GaSq
                if(bombSquare.getBombStatus()) countMine++;
            }
        }
        return countMine;
       
    }
    public void showTopLeftBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x>=0 && y>=0 && (int)(bombSquare.countBombAround(x - 1, y -1 )) == 0) showTopLeftBlank(x - 1, y - 1);
        }
        

    }
    public void showTopBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x>=0 && (int)(bombSquare.countBombAround(x-1, y)) == 0) showTopBlank(x - 1, y);
            
        }
        
    }
    public void showTopRightBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x>=0 && y<=100 && (int)(bombSquare.countBombAround(x-1, y+1)) == 0) showTopRightBlank(x - 1, y + 1);
            
        }
        
    }
    public void showLeftBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(y>=0 && (int)(bombSquare.countBombAround(x, y-1)) == 0) showLeftBlank(x, y - 1);
            
        }
        
    }
    public void showRightBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(y<=100 && (int)(bombSquare.countBombAround(x, y+1)) == 0) showRightBlank(x, y + 1);
            
        }
        
    }
    public void showDownLeftBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x<=100 && y>=0 && (int)(bombSquare.countBombAround(x+1, y-1)) == 0) showDownLeftBlank(x + 1, y - 1);
            
        }
        
    }
    public void showDownBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x<=100 && (int)(bombSquare.countBombAround(x+1, y)) == 0) showDownBlank(x + 1, y);
            
        }
        
    }
    public void showDownRightBlank(int x, int y){
        BombSquare bombSquare = (BombSquare)board.getSquareAt(x, y);
        bombSquare.setButtonClickedStatus(true);
        bombSquare.setImage("images/0.png");
        if(bombSquare.getBombStatus() == false){
            if(x<=100 && y<=100 && (int)(bombSquare.countBombAround(x+1, y+1)) == 0) showDownRightBlank(x + 1, y + 1);
            
        }
    }

   
            
          
            
            
            
            
         

    

    /**
     * It's the method which image will be shown with related number
     * @param i the number which the grid will print the image with the same number shown
     * @param x the row number of the grid to change on board
     * @param y the column number of the grid to change on board
     */
  
    public void setImageBasedOnNum(int i, int x, int y){
        
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
    public void setButtonClickedStatus(boolean status){
        this.buttonClicked = status;
    }

    public boolean getButtonClickedStatus(){
        return this.buttonClicked;
    }

     public void setButtonFlagedStatus(boolean status){
        this.buttonFlaged = status;
    }

    public boolean getButtonFlagedStatus(){
        return this.buttonFlaged;
    }
    
    public void printAllBomb(){
        for(int i = 0 ; i < 30; i ++){
            for(int j = 0 ; j< 30; j++){
                BombSquare bombSquare = (BombSquare)board.getSquareAt(i, j);
                bombSquare.setButtonClickedStatus(true);
                if(bombSquare.getBombStatus() == true)bombSquare.setImage("images/bomb.png");
                     
            }
        }
     
    }
    
   
   /**
    * This method allows user to click the selected grid on board.
    */
    public void leftClicked(){
       
        int x = super.getXLocation();
        int y = super.getYLocation();
        if(getButtonFlagedStatus() == false){
            if(getButtonClickedStatus() == false){
                if(getBombStatus()){
                    super.setImage("images/bomb.png");
                    System.out.println("Position " + x + " " + y + " with bomb been clicked\n" + "Please restart the game, you have failed");
                    printAllBomb();
                    
                }
                else{
                    setImageBasedOnNum(countBombAround(x, y), x, y);
                    System.out.println("Position " + x + " " + y + " been clicked");
                    setButtonClickedStatus(true);
                }
               
            }
          
            

        }
        
    }
     
     /**
      * This right clicked function ensure that once the cell has been flagged, it will not be able to leftclicked.
      */
    public void rightClicked(){
 
        if(getButtonClickedStatus() == false){
            if(getButtonFlagedStatus() == false){
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

    


    
    
 

