import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Controller implements Observer
{
    private final View view;
    private final Model model;
    Random random;
    private KI ki;
    @Override
    public void update(Observable observable, Object o)
    {
        if(o==null)
            return;
        DataObject ob = (DataObject) o;
        if(ob.from.equals("View"))
        {
            if(model.getWinner()>0 || model.boardFull())
            {
                System.exit(0);
            }
            model.addDisk(ob.value, model.getCurrentPlayer());
            if(model.getCurrentPlayer()==2 && !model.boardFull() && model.getWinner()==-1)
            {
                model.addDisk(ki.getBestMove(model),2);
            }

        }
        else if(ob.from.equals("Model"))
        {
            model.setWinner(ob.value);
            view.updateBoard();
        }
    }
    public Controller(Model m, View v)
    {
        random = new Random();
        view = v;
        view.addObserver(this);
        model = m;
        m.addObserver(this);
        model.setCurrentPlayer(1);
        view.updateBoard();
        ki = new KI();
    }
}
