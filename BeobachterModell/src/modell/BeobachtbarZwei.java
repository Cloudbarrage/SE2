package modell;

public class BeobachtbarZwei extends ObservableID
{
    private int _n = 0;

    public int getNumber()
    {
        return _n;
    }

    public void increment()
    {
        ++_n;
        setChanged();
        notifyObservers(id);
    }

}
