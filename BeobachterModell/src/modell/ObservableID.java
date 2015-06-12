package modell;

import java.util.Observable;

public class ObservableID extends Observable
{
    private static int UNIQUE_ID = 0;
    protected final int id = ++UNIQUE_ID;

    public int getID()
    {
        return id;
    }
}
