public class Main{
	public static void main(String[] args){
		Transmitter t = new Transmitter();
		Cable c = new Cable(50.0, 10);
		Receiver rec = new Receiver();
		Relay rel = new Relay();
		Component[] comps = {t, c, rel, rec};
		TelegraphSystem tlSys = new TelegraphSystem(comps);

		t.setStatus(true);
		tlSys.run();
	}
}
