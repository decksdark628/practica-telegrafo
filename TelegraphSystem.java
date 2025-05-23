public class TelegraphSystem{
	private Component[] components;

	public TelegraphSystem(Component[] components){
		this.components = components; 
	}

	public void run(){
		if (validSequence()){
			connectSystem();
			// TODO considerar clases intermedias que diferencien Emite señal vs Mueve señal
			if (((Transmitter)components[0]).sendSignal()){
				for (int i = 1; i<components.length-1; i++){
					((SignalPasser)components[i]).transmit();
				}
				((Receiver)components[components.length]).receiveSignal();
				((Receiver)components[components.length]).displayMessage();
			}
			System.out.println("Se ha inciado el Telegrafo");
		}
	}

	// TODO revisar que no haya conflictos si un array tiene 1 o 2 elementos	
	private boolean validSequence(){
		boolean confirmation;
		int c = components.length;

		confirmation = (components[0] instanceof Transmitter && components[c-1] instanceof Receiver);

		if (confirmation){
			for (int i = 1; i<components.length-1 && confirmation; i++){
				if (components[i] == null)
					confirmation = false;
				if (components[i] instanceof Transmitter || components[i] instanceof Receiver)
					confirmation = false;
			}
		}
		return confirmation;
	}

	public void connectSystem(){
		int c = components.length;
		Transmitter first = (Transmitter)components[0];
		Receiver last = (Receiver)components[c-1];
		if (c > 2)
			first.setNextComp(components[1]);
		else
			System.out.println("c<=2");
		if (c-2 > 0)
			last.setPrevComp(components[c-2]);
		else
			System.out.println("menos de 3 elementos");
		for ( int i = 1; i<components.length-1; i++){
			if (i+1 < components.length)
				((SignalPasser)components[i]).setNextComp(components[i+1]);
			else
				System.out.println("no nextComp for " + i);
			if (i-1 >= 0)
				((SignalPasser)components[i]).setPrevComp(components[i-1]);
			else
				System.out.println("no prevComp for " + i);
		}
		System.out.println("Se conecto el sistema");

		for (int i = 0; i<components.length; i++){
			System.out.println("Componente numero" + i);
			System.out.println(components[i]);
			if (i >0 )
				System.out.println("\t prev:" + components[i-1]);
			if (i<components.length-1)
				System.out.println("\t next:" + components[i+1]);
		}
	}
}

