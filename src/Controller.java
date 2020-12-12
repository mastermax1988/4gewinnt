import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer
{
    private final View view;
    private final Model model;
    int player;
    @Override
    public void update(Observable observable, Object o)
    {
        System.out.println("Controller: " + o);
        if(o==null || (int)o == -1)
            return;
        if(model.addDisk((int)o,player))
            player = (player % 2) + 1;
    }
    public Controller(Model m, View v)
    {
        view = v;
        view.addObserver(this);
        model = m;
        m.addObserver(this);
        player = 1;
    }
}
