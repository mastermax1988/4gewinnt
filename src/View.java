import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class View  extends Observable  implements Observer, MouseListener
{
    private final Model model;
    private final Window window;

    public View(Model m)
    {
        model = m;
        model.addObserver(this);
        Frame frame = new Frame("4 gewinnt");
        window = new Window();
        frame.add(window);
        frame.setSize(800,700);
        frame.setVisible(true);
        window.addMouseListener(this);
    }


    @Override
    public void update(Observable observable, Object o)
    {
        window.drawBoard(model);
    }

    public void updateBoard()
    {
        window.drawBoard(model);
    }

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
        notifyObservers(new DataObject("View", iLastCol));
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
