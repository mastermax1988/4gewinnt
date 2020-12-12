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
    }
}
