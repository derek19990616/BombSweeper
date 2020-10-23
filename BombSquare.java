public class BombSquare extends GameSquare
{
    private GameBoard board;                            // Object reference to the GameBoard this square is part of.
    private boolean hasBomb;                            // True if this squre contains a bomb. False otherwise.
    private int widthForBoard;
    private int heightForBoard;

    
    
    private boolean buttonClicked;
    private boolean buttonFlagged;
    private int countNum = 0;
    private boolean gameFail = false;
    
 
  
    
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
    public boolean getFailStatus(){
        return this.gameFail;
    }



    public boolean getButtonClickStatus(){
        return this.buttonClicked;
    }
     public void setButtonClickStatus(){
        this.buttonClicked = false;
    }
    public void setCountNum(int countNum){
        this.countNum = countNum;

    
    }
    public int getCountNum(){
        return this.countNum;
    }

    public void setImageBasedOnNum(int i, int x, int y){
        if(getButtonClickStatus() == false){
            switch(i){
                case 0:
                board.getSquareAt(x, y).setImage("images/0.png");
                break;
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
            }
        }
    }

   
    
   // @overide
   /**
    * This method allows user to click the selected grid on board.
    */
    public void leftClicked(){
       
        int x = super.getXLocation();
        int y = super.getYLocation();
        if(buttonFlagged == false){
            if(buttonClicked == false){
                if(getBombStatus()){
                    board.getSquareAt(x, y).setImage("images/bomb.png");
                    System.out.println("Position " + x + " " + y + " with bomb been clicked");
                    this.gameFail = true;
                }
                else{
                    setImageBasedOnNum(getCountNum(),x, y);
                    System.out.println("Position " + x + " " + y + " with number " + getCountNum() + " been clicked");

                }
               
            }
            this.buttonClicked = true;
            

        }
        
    }
     // @overide
     /**
      * This right clicked function ensure that once the cell has been flagged, it will not be able to leftclicked.
      */
    public void rightClicked(){
        int x = super.getXLocation();
        int y = super.getYLocation();
        if(buttonClicked == false){
            if(buttonFlagged == false){
                board.getSquareAt(x,y).setImage("images/flag.png");
                buttonFlagged = true;
            }
            else{
                board.getSquareAt(x,y).setImage("images/blank.png");
                buttonFlagged = false;
            }
        }
    }

 
}

    


    
    
 

