package game;

import static game.TicTacToe.*;

public class Computer {
    public TicTacToe obj = new TicTacToe();
    final int[] corners = {1,3,5,7};
    final int[] sides = {2,4,6,8};
    final int[] centre = {5};
    public static int isPower(int x, int y)
    {

        double value = Math.log(y) / Math.log(x);
        if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
            System.out.println(value);
            return (int)value;
        }

        return 0;
    }
    public int checkandmove(int check){
        int computersituation=0;
        for(int i=0;i<8;i++) {
            int position = Computer.isPower(2, win[i] - (check & win[i]));
            if (position > 0) {
                if (obj.moveBoard(position+1, chooseletter[1])==true) {
                    break;
                }
                else
                    computersituation = computersituation+1;
            }
            if(position==0)
                computersituation = computersituation+1;
        }

        System.out.println("hii"+computersituation);
         return computersituation;
    }

    public void computerWin(){
        System.out.println("function is called");
        obj.playerbytevalues();
        Computer st = new Computer();
        if(st.checkandmove(playersinfo[1])==8)
            if(st.checkandmove(playersinfo[0])==8)
            {
                if(st.checkCornerCentreSides(corners)==0)
                    if(st.checkCornerCentreSides(centre)==0)
                        st.checkCornerCentreSides(sides);
            }

    }
    public int checkCornerCentreSides(int[] positions)
    {
        int ackcheck=0;
        for (int i: positions){
            if(((int) board[i])-48==i){
                obj.moveBoard(i,chooseletter[1]);
                ackcheck=1;
                break;
            }

        }
        System.out.println(ackcheck);
        return ackcheck;
    }

}
