import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> arrSt=new ArrayList<Student>();
		arrSt.add(new Student("ABC","1MS17IS037",19,"XYZ,No.38",(float) 89.681));
		Student s1=new Student("PQR","1MS17IS038",18,"ABC,N0-645",(float) 80.83);
		arrSt.add(s1);
		Student s2=new Student("DEF","1MS17IS035",19,"CDF-64",(float) 80.93);
		arrSt.add(s2);
		System.out.println(arrSt.size());
		Student s3=arrSt.get(2);
		for(Student s:arrSt)
		{
			if(s.name.charAt(0)=='A')
			{
				int in=arrSt.indexOf(s);
				s.usn="1MS19042";
				Student s4=arrSt.set(in,s);
			}
		}
		for(Student s:arrSt)
		{
			System.out.println(s);
		}
		

	}

}
