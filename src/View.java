import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class View  extends Observable  implements Observer
{
    private final Model model;
    private final Window window;
    private final MyMouseListener myMouseListener;

    public View(Model m)
    {
        model = m;
        model.addObserver(this);
        Frame frame = new Frame("4 gewinnt");
        window = new Window();
        frame.add(window);
        frame.setSize(800,700);
        frame.setVisible(true);
        myMouseListener = new MyMouseListener();
        myMouseListener.addObserver(this);
        window.addMouseListener(myMouseListener);
    }


    @Override
    public void update(Observable observable, Object o)
    {
        if(o!=null) // when o!=null, then mouseclick set it
        {
            setChanged();
            notifyObservers(new DataObject("View", (int)o));
        }
        else //model doesn't set o
            window.drawBoard(model);
    }
    public void updateBoard()
    {
        window.drawBoard(model);
    }
}
