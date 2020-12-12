import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer
{
    private final View view;
    private final Model model;
    @Override
    public void update(Observable observable, Object o)
    {
        if(o==null)
            return;
        DataObject ob = (DataObject) o;
        if(ob.from.equals("View"))
        {
            System.out.println("Controller from view" + ob);
            if(model.getWinner()>0)
            {
                System.exit(0);
            }
            if (model.addDisk(ob.value, model.getCurrentPlayer()))
                model.setCurrentPlayer((model.getCurrentPlayer() % 2) + 1);
            System.out.println("Controller set player to " + model.getCurrentPlayer());
        }
        else if(ob.from.equals("Model"))
        {
            model.setWinner(ob.value);
            view.updateBoard();
        }
    }
    public Controller(Model m, View v)
    {
        view = v;
        view.addObserver(this);
        model = m;
        m.addObserver(this);
        model.setCurrentPlayer(1);
        view.updateBoard();
    }
}
