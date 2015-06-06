import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Beobachter implements Observer {
	private interface command {
		public void run(Object arg);
	}

	private Beobachtbar test;
	private Map<Observable, command> _funktionen;

	public Beobachter() {
		test = new Beobachtbar();
		test.addObserver(this);
		_funktionen = new HashMap<Observable, command>();

		command com = new command() {
			public void run(Object arg) {
				print();
			}
		};

		_funktionen.put(test, com);

	}

	@Override
	public void update(Observable o, Object arg) {
		_funktionen.get(o).run(arg);
	}

	private void print() {
		if(test.getNumber() == 5){
		System.out.println("ok");
		}
	}

	public void setNumber(int i) {
		test.setNumber(i);
	}

}
