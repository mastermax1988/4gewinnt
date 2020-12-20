public class KI
{

    public KI()
    {
    }

    public int getBestMove(Model model)
    {
        var mt = new ModelTree(model, model.getCurrentPlayer());
        return mt.getBestMove();
    }
}
