public class TelegraphSystem{
	private Componente[] componentes;

	public TelegraphSystem(Componente[] componentes){
		this.componentes = componentes; 
	}
// TODO revisar que no haya conflictos si un array tiene 1 o 2 elementos	
	private boolean validSequence(){
		boolean confirmation;
		int c = componentes.length;

		confirmation = componentes[0] instanceof Transmitter && componentes[c] instaceof Receiver;

		if (confirmation){
			for (int i = 1; i<componentes.length-1 && confirmation; i++){
				if (componentes[i] != null)
					confirmation = false;
				if (componentes[i] instanceof Transmitter || componentes[i] instanceof Receiver)
					confirmation = false;
			}
		}

		return confirmation;
	}

	private boolean connectSystem(){
		boolean confirmation = true;
		int c = componentes.length;

		if (confirmation){
			componentes[0].setNextComp(componentes[1]);
			componentes[c].setPrevComp(componentes[c-1]);
			for ( int i = 1; i<componentes.length-1; i++){
				if (componentes[i+1] < componentes.length)
					componentes[i].setNextComp(componentes[i+1]);
				if (componentes[i-1] >= 0)
					componentes[i].setPrevComp(componentes[i-1]);
			}
		}
		
		return confirmation;

	}

	public boolean run(){
		boolean confirmation = validSequence();
		if (confirmation){
			confirmation = connectSystem();
			if (confirmation){
				componentes[0].sendSignal();
				for (int i = 1; i<componentes.length-1&&confirmation; i++)
					componentes[i].transmit();
				componentes[componentes.length].receiveSignal();
				componentes[componentes.length].displayMessage();
			}
		}

		return confirmation;
	}
}

