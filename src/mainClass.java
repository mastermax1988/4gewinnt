public class mainClass
{
    public static void main(String[] args)
    {
        Model m = new Model();
        View v = new View(m);
        Controller c = new Controller(m,v);

    }
}
