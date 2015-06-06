import java.util.Observable;

public class Beobachtbar extends Observable {
	int _n;

	public Beobachtbar() {
		_n = 1;
	}

	public int getNumber() {
		return _n;
	}

	public void setNumber(int i) {
		_n = i;
		setChanged();
		notifyObservers();
	}

}
