import java.io.*;
import java.util.*;
public class Student {
	String name,usn,address;
	int age;
	float avg_marks;
	Student(String name,String usn,int age,String addr,float avg)
	{
		this.name=name;
		this.usn=usn;
		this.age=age;
		this.address=addr;
		this.avg_marks=avg;
	}
	public String toString()
	{
		return name+" "+usn+" "+age+" "+address+" "+avg_marks;
	}
}
