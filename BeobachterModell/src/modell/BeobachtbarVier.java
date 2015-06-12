package modell;

import java.util.Observable;

public class BeobachtbarVier extends Observable
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
        notifyObservers();
    }
}
