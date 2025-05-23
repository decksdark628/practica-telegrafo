public class Cable extends SignalPasser{
	private double length;
	private int signalDegrad;

	public Cable(double length, int signalDegrad){
		this.length = length;
		this.signalDegrad = signalDegrad;
	}

	public void start(){
		if (super.getSignal() != null){
			degradeSignal();
			transmit();
			System.out.println("Cable: Señal enviada al siguiente componente");
		}
	}

	private void degradeSignal(){
		for (int i = 1; i<=length; i++){
			super.getSignal().decreaseStrength(signalDegrad);
		}
	}

	public double getLength() {
		return this.length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getSignalDegrad() {
		return this.signalDegrad;
	}

	public void setSignalDegrad(int signalDegrad) {
		this.signalDegrad = signalDegrad;
	}
}