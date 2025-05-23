import java.util.Scanner;

public class Transmitter extends Component{
	private Component nextComp;
	private boolean status;
	private String inputMsg;

	public Transmitter(){}

	public boolean sendSignal(){
		boolean confirmation = false;
		if (!status)
			System.out.println("Error. El transmisor no esta encendido");
		else{
			Scanner sc = new Scanner(System.in);
			// TODO validate message
			System.out.println("Escribe un mensaje");
			inputMsg = sc.nextLine();

			Translator tr = new Translator();
			System.out.println("Input message: "+ inputMsg);
			String[] x = tr.encode(inputMsg);
			Signal s = ((SignalPasser)nextComp).getSignal();
			s.setContent(x);
			confirmation = true;
			System.out.println("Transmitter: Señal enviada al siguiente componente");
		}
		return confirmation;
	}

	public Component getNextComp() {
		return this.nextComp;
	}

	public void setNextComp(Component nextComp) {
		this.nextComp = nextComp;
	}

	public boolean isStatus() {
		return this.status;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
		System.out.println("Se ha encendido el Emisor");
	}

	public String getInputMsg() {
		return this.inputMsg;
	}

	public void setInputMsg(String inputMsg) {
		this.inputMsg = inputMsg;
	}

}
