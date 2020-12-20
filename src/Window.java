import java.awt.*;

public class Window extends Canvas
{
    private Model model;
    public Window()
    {
        setSize(1200,800);
        setBackground(Color.blue);
    }

    public void drawBoard(Model m)
    {
        model = m;
        paint(getGraphics());
    }

    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        for(int i = 0; i< model.iCols; i++)
            for(int j = 0; j< model.iRows; j++)
            {
                int col = model.getDisk(i,j);
                switch (col)
                {
                    case 1:
                        graphics.setColor(Color.yellow);
                        break;
                    case 2:
                        graphics.setColor(Color.red);
                        break;
                    default:
                        graphics.setColor(Color.darkGray);
                }
                graphics.fillOval(i * 100 + 50, 500 - j * 100 + 50, 100,  100);
            }
        graphics.setFont(new Font("Times",10,24));
        int currentPlayer = model.getCurrentPlayer();
        graphics.setColor(currentPlayer== 1 ? Color.yellow : Color.red);
        if(model.getWinner()>0)
        {
           graphics.setColor(model.getWinner() == 1 ? Color.yellow : Color.red);
           graphics.drawString("Player " + model.getWinner() + " won!", 50, 40);
        }
        else if(model.boardFull())
        {
           graphics.setColor(Color.green);
           graphics.drawString("It's a tie, nobody won!", 50, 40);
        }
        else
           graphics.drawString("Player " + currentPlayer + ", it's your turn!",50,40);
    }
}
