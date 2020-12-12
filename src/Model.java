import java.util.Observable;

public class Model extends Observable
{
    public final int iCols = 7, iRows = 6;
    private final int[][] field;
    private int iWinner;
    private int currentPlayer;
    public Model()
    {
        field = new int[iCols][iRows];
        iWinner = -1;
        setChanged();
        notifyObservers();
    }
    public boolean colFree(int c)
    {
        if(c>=iCols)
            return false;
        return field[c][iRows-1]==0;
    }
    public boolean addDisk(int c, int player)
    {
        if(!colFree(c))
            return false;
        for(int i=0;i<iRows;i++)
            if(field[c][i]==0)
            {
                field[c][i]=player;
                checkWin();
                setChanged();
                notifyObservers();
                return true;
            }
        return false;
    }
    private void checkWin()
    {
        for(int i=0;i<iCols;i++)
        {
            for (int j = 0;j<iRows;j++)
            {
                int f =field[i][j];
                if(f==0)
                    continue;
                if(i+3<iCols)
                {
                    if (f == field[i + 1][j] && f == field[i + 2][j] && f == field[i + 3][j])
                    {
                        setChanged();
                        notifyObservers(new DataObject("Model",f));
                        return;
                    }
                }
                if(j+3<iRows)
                {
                   if (f == field[i][j+1] && f == field[i][j+2] && f == field[i][j+3])
                    {
                        setChanged();
                        notifyObservers(new DataObject("Model",f));
                        return;
                    }
                }
                if(i+3<iCols && j+3<iRows)
                {
                   if (f == field[i+1][j+1] && f == field[i+2][j+2] && f == field[i+3][j+3])
                    {
                        setChanged();
                        notifyObservers(new DataObject("Model",f));
                        return;
                    }
                }
                if(i+3<iCols && j>2)
                {
                   if (f == field[i+1][j-1] && f == field[i+2][j-2] && f == field[i+3][j-3])
                    {
                        setChanged();
                        notifyObservers(new DataObject("Model",f));
                        return;
                    }
                }
            }
        }
    }
    public int getDisk(int c, int r)
    {
        if(c<0 || c>=iCols || r<0 || r>=iRows)
            return -1;
        return field[c][r];
    }

    public int getWinner()
    {
        return iWinner;
    }

    public void setWinner(int iWinner)
    {
        this.iWinner = iWinner;
    }

    public int getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }
}
