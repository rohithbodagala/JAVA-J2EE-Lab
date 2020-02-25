
public class MissedCalls {
	String name,time;
	long number;
	MissedCalls(String name,String time,long number)
	{
		this.name=name;
		this.time=time;
		this.number=number;
	}
	public String toString()
	{
		return name+" "+number+" "+" "+time;
	}

}
