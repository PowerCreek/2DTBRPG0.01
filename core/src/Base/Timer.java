package Base;


public class Timer {

	long timeStart = System.currentTimeMillis();
	public long timeCount = 0;
	public long timeDiff = 0;
	long interval = 0;
	
	public Timer(long interval){
		this.interval = interval;
	}
	
	public void update(){
		
		timeCount = System.currentTimeMillis();
		timeDiff = timeCount-timeStart;
		
	}
	
	public boolean isTimeUp(){
		
		return Math.abs(timeDiff) >= interval;
	}
	
	
	
	
}
