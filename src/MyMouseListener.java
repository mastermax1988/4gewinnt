import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

public class MyMouseListener extends Observable implements MouseListener
{

    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {
        int iLastCol;
        int iCol = mouseEvent.getX();
        if(iCol<50)
            iLastCol = -1;
        else if(iCol<150)
            iLastCol = 0;
        else if(iCol<250)
            iLastCol = 1;
        else if(iCol<350)
            iLastCol = 2;
        else if(iCol<450)
            iLastCol = 3;
        else if(iCol<550)
            iLastCol = 4;
        else if(iCol<650)
            iLastCol = 5;
        else if(iCol<750)
            iLastCol = 6;
        else
            iLastCol = -1;
        setChanged();
        notifyObservers(iLastCol);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {

    }
}
