public class Relay extends SignalPasser{
	private boolean status;

	public Relay(){}
	
	public boolean amplifySignal(){
		boolean confirmation = false;
		if (super.getSignal() != null){
			super.getSignal().setStrength(100);
			System.out.println("Repetidor: Se amplifico la señal");
			confirmation = true;
		}
		else
			confirmation = false;
		return confirmation;
	}

	public void start(){
		if (amplifySignal()){
			transmit();
			System.out.println("Repetidor: Se envio al siguiente componente");
		}
		else
			System.out.println("Repetidor: No se encontro una señal que amplificar");
	}

	public boolean isStatus() {
		return this.status;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
