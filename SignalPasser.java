public abstract class SignalPasser extends Component{
    private Signal signal;
    private Component prevComp;
	private Component nextComp;

    public SignalPasser(){}	

	public abstract void start();

	public void transmit(){
		if (!(nextComp instanceof Receiver)){
			((SignalPasser)nextComp).setSignal(signal);
			signal = null;
		}
	}
	
	public Signal getSignal(){
		return signal;
	}
	public void setSignal(Signal signal){
		this.signal = signal;
	}
	public Component getPrevComp(){
		return this.prevComp;
	}
	public void setPrevComp(Component prevComp){
		this.prevComp = prevComp;
	}
	public Component getNextComp(){
		return this.nextComp;
	}
	public void setNextComp(Component nextComp){
		this.nextComp = nextComp;
	}
}