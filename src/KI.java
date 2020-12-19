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
        return getBestMoveRecursion(model,1);
    }
    private int getBestMoveRecursion(Model model, int r)
    {
       var free=model.getFreeCols();
       for(int i : free)
        {
            Model clone = new Model(model);
            clone.addDisk(i,2);
            if(clone.getWinner()==2)
                return i;

        }
       return free.get(random.nextInt(free.size()));
    }
}
