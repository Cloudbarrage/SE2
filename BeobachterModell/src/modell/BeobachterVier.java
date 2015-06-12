package modell;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class BeobachterVier implements Observer
{
    private class counter
    {
        private int i = 0;

        public void count()
        {
            ++i;
        }

        public int getValue()
        {
            return i;
        }
    }

    private Map<Observable, counter> _beobachtbar = new HashMap<Observable, counter>();

    public void registriereBeobachter(BeobachtbarVier beobachtbar)
    {
        beobachtbar.addObserver(this);
        _beobachtbar.put(beobachtbar, new counter());

    }

    @Override
    public void update(Observable o, Object arg)
    {
        _beobachtbar.get(o)
            .count();
    }

    public int getNumber(Observable o)
    {
        return _beobachtbar.get(o)
            .getValue();
    }
}
