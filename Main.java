public class Main{
	public static void main(String[] args){
		Transmitter t = new Transmitter();
		Cable c = new Cable(50.0);
		Receiver rec = new Receiver();
		Relay rel = new Relay();
		Componente[] comps = {t, c, rel, rec};
		TelegraphSystem tlSys = new TelegramSystem(comps);

		if (!tlSys.run())
			System.out.println("La configuracion del sistema es incorrecta");
	}
}
