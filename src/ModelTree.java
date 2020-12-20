import java.util.ArrayList;
import java.util.List;

public class ModelTree
{
    private Model root;
    private ArrayList<ModelTree> nodes;
    private int move; //
    private int kiPlayer; // the ki player

    public int getMove()
    {
        return move;
    }

    private class MoveScore
    {
        public int move;
        public int score;
        public MoveScore(int move, int score)
        {
            this.move = move;
            this.score = score;
        }
    }
    public ModelTree(Model root, int kiPlayer)
    {
        this.root = root;
        this.kiPlayer = kiPlayer;
        move = -1;
        nodes = new ArrayList<ModelTree>();
    }
    private ModelTree(Model root, int kiPlayer, int move)
    {
        this.root = root;
        this.kiPlayer = kiPlayer;
        this.move = move;
        nodes = new ArrayList<ModelTree>();
    }
    public int getBestMove()
    {
        int recDepth=5;
        nodes = new ArrayList<ModelTree>(); //starting fresh
        fillTree(recDepth);
        var ms = new ArrayList<MoveScore>();
        for(var n : nodes)
           ms.add(new MoveScore(n.getMove(), n. getScore(recDepth,recDepth)));
        int iBestScore=-10000;
        for(var m : ms)
        {
            if(m.score>iBestScore && m.move>-1)
                iBestScore = m.score;
        }
        for(var m : ms)
        {
            if(m.score == iBestScore && m.move>-1)
                return m.move;
        }
        return -2;
    }
    public int getScore(int r1, int r2)
    {
        int score = 0;
        if(root.getWinner()==kiPlayer)
            score = (r1-r2 == 0) ? 1000 : 1;
        else if(root.getWinner()!=-1) // enemy won
            score = (r1-r2 < 2) ? -100 : -30;
        for(var n : nodes)
            score += n.getScore(r1, r2-1);
        if(score!=0)
            System.out.println(root + "Score: " + score);
        return score;
    }
    public void fillTree(int r)
    {
        var free = root.getFreeCols();
        for(var i : free)
        {
            if(root.getWinner()>-1)
            {
                nodes.add(new ModelTree(root,kiPlayer));
                continue;
            }
            var clone = new Model(root);
            clone.addDisk(i,clone.getCurrentPlayer());
            nodes.add(new ModelTree(clone,kiPlayer,i));
        }
        if(r<=1)
            return;
        for(var m : nodes)
            m.fillTree(r-1);
    }
    private void addChild(ModelTree model)
    {
        nodes.add(model);
    }
    @Override
    public String toString()
    {
        return "Model: " + root.toString();
    }
}
