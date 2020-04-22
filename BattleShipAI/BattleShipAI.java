
public class BattleShipAI
{
    public static String makeGuess(char[][] guesses){

        int row;
        int col;

        for (int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(guesses[i][j] == 'X'){
                    if (i+3<10 && guesses [i+1][j] == 'X' && guesses[i+2][j] == 'X' && guesses[i+3][j] == '.') return hit(i+3, j);
                    if (j+3<10 && guesses [i][j+1] == 'X' && guesses[i][j+2] == 'X' && guesses[i][j+3] == '.') return hit(i, j+3);
                    if (i-3>=0 && guesses [i-1][j] == 'X' && guesses[i-2][j] == 'X' && guesses[i-3][j] == '.') return hit(i-3, j);
                    if (j-3>=0 && guesses [i][j-1] == 'X' && guesses[i][j-2] == 'X' && guesses[i][j-3] == '.') return hit(i, j-3);
                } 
            }
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(guesses[i][j] == 'X'){
                    if (i+2<10 && guesses[i+1][j] == 'X' && guesses[i+2][j] == '.') return hit(i+2, j);
                    if (i-2>=0 && guesses[i-1][j] == 'X' && guesses[i-2][j] == '.') return hit(i-2, j);
                    if (j+2<10 && guesses[i][j+1] == 'X' && guesses[i][j+2] == '.') return hit(i, j+2);
                    if (j-2>=0 && guesses[i][j-1] == 'X' && guesses[i][j-2] == '.') return hit(i, j-2);
                }
            }
        }
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                if(guesses[i][j] == 'X'){
                    if (i+1<10 && guesses[i+1][j] == '.') return hit(i+1, j);
                    if (j+1<10 && guesses[i][j+1] == '.') return hit(i, j+1);
                    if (i-1>=0 && guesses[i-1][j] == '.') return hit(i-1, j);
                    if (j-1>=0 && guesses[i][j-1] == '.') return hit(i, j-1);
                }
            }
        }
        do{
            row = (int)(Math.random() * 10);
            col = (int)(Math.random() * 10);
        }while(guesses[row][col] != '.' || (row+col)%2==1 );
        return hit(row,col);
    }

    public static String hit(int row, int col){
        char c = (char)((int)'A'+ row);
        String guess = c + Integer.toString(col+1);
        return guess;
    }
}
