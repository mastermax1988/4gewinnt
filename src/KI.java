import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KI
{
    Random random;

    public KI()
    {
        random = new Random();
    }

    public int getBestMove(Model model)
    {
        if(true)
        {
            var mt = new ModelTree(model, model.getCurrentPlayer());
            return mt.getBestMove();
        }
        return getBestMoveRecursion(model, model.getCurrentPlayer(), 3);
    }
    private int getBestMoveRecursion(Model model, int kiPlayer, int r)
    {
       var free=model.getFreeCols();
       var t = new ArrayList<Model>();
       for(int i : free)
        {
            Model clone = new Model(model);
            clone.addDisk(i,model.getCurrentPlayer());
            if(clone.getWinner()==kiPlayer)
                return i;
            t.add(clone);
        }
       return free.get(random.nextInt(free.size()));
    }
}
