import java.util.Observable;

public class Model extends Observable
{
    public final int iCols = 7, iRows = 6;
    private final int[][] field;
    public Model()
    {
        field = new int[iCols][iRows];
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
                setChanged();
                notifyObservers();
                return true;
            }
        return false;
    }
    public int getDisk(int c, int r)
    {
        if(c<0 || c>=iCols || r<0 || r>=iRows)
            return -1;
        return field[c][r];
    }
}
