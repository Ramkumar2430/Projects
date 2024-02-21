import java.util.*;
public class App {
    static String[] board;
    static String turn;
    static String checkWinner(){
        for(int i = 0;i < 8;i++){
            String line  = null;
            switch(i){
                case 0:
                    line = board[0] + board[1] + board [2];
                    break;
                case 1:
                    line = board[3] + board[4] + board [5];
                    break;
                case 2:
                    line = board[6] + board[7] + board [8];
                    break;
                case 3:
                    line = board[0] + board[3] + board [6];
                    break;
                case 4:
                    line = board[1] + board[4] + board [7];
                    break;
                case 5:
                    line = board[2] + board[5] + board [8];
                    break;
                case 6:
                    line = board[0] + board[4] + board [8];
                    break;
                case 7:
                    line = board[2] + board[4] + board [6];
                    break;
            }
            if(line.equals("XXX")){

                return "X";
            }
            else if(line.equals("OOO")){
                
                return "O";
            }
            
        }
        for(int i = 0; i < 9;i++){
            if(Arrays.asList(board).contains(String.valueOf(i+1))){
                break;
            }
            else if(i==8){
                return "draw";
            }
        }
        System.out.println(turn+"'s Enter the slot number::::");
        return null;
    }
    static void printboard(String[] board){
        System.out.println("|---|---|---|");
        System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
        System.out.println("|---|---|---|");
    }
    public static void main(String[] args) throws Exception {
            Scanner in  = new Scanner(System.in);
            board = new String[9];
            turn = "X";
            String winner = null;
            for(int i = 0;i < 9;i++){ 
                board[i] = String.valueOf(i+1);
            }
            System.out.println("...................Welcome to Tic Tac Toe..................");
            printboard(board);
            System.out.println("X will play first enter the slot::::");
            while(winner == null){
                int numin;
                try{
                    numin = in.nextInt();
                    if(!(numin > 0 && numin <= 9)){
                        System.out.println("Invalid Input, re-enter the slot number::::");
                        continue;
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid Input, re-enter the slot number::::");
                    in.nextLine();
                    continue;
                }
                if(board[numin - 1].equals(String.valueOf(numin))){
                    board[numin - 1] = turn;
                    if(turn.equals("X")){
                        turn = "O";
                    }
                    else if(turn.equals("O")){
                        turn = "X";
                    }
                    printboard(board);
                    winner = checkWinner();
                }
                else{
                    System.out.println("The Slot is already filled, re-enter the slot number::::");
                }
            }
            if(winner.equalsIgnoreCase("draw")){
                System.out.println("The match ---->> draw");
            }
            else{
                System.out.println("Congratulations " + winner + " won the match :)");
            }
            in.close();
    }
}