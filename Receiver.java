public class Receiver extends Component{
	private Component prevComp;
	private String message;

	public Receiver(){}

	public void receiveSignal(){
		Translator tr = new Translator();
		message = tr.decode(((SignalPasser)prevComp).getSignal().getContent());
	}

	public void displayMessage(){
		if (message != null) 
			System.out.println(message);
		else
			System.out.println("Error. No se pudo leer el mensaje");
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Component getPrevComp() {
		return this.prevComp;
	}

	public void setPrevComp(Component prevComp) {
		this.prevComp = prevComp;
	}

}
