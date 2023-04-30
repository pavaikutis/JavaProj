package anagrams.model;


public class GameTimer
{
	private int time;
	
	public GameTimer()
	{
		this.time = 60;		
	}
	
	public int getTime()
	{
		return this.time;
	}
	
	public void updateTime()
	{
		if (this.time > 0){
			this.time -= 1;
		}
	}		
}
