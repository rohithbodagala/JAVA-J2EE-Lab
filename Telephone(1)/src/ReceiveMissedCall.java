import java.util.*;
import java.io.*;
public class ReceiveMissedCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Long,String> hm=new HashMap<Long,String>();
		hm.put(9210324234L,"ABC");
		hm.put((long)9340842342L,"DEF");
		hm.put((long)9763424214L,"EFG");
		hm.put((long)9980845235L,"GFE");
		ArrayList<MissedCalls> mcc=new ArrayList<MissedCalls>();
		ArrayList<MissedCalls> removelist=new ArrayList<MissedCalls>();
		
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter a choice");
			System.out.println("1.add missed call \n 2.Display and delete on request \n 3. Delete based on number \n 4. Print");
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter time");
					String tc=sc.next();
					System.out.println("Enter the number");
					long val=sc.nextLong();
					String n;
					if(hm.containsKey(val))
					{
						n=hm.get(val);
					}
					else
					{
						n="Private Caller";
					}
					MissedCalls m=new MissedCalls(n,tc,val);
					mcc.add(m);
					if(mcc.size()>10)
					{
						mcc.remove(0);
					}
					break;
		
		
				case 2:
					for(MissedCalls s:mcc)
					{
						System.out.println(s.number);
						System.out.println("\n1:Delete the number\n2:Show details of call\n3:Go to next call\nEnter your choice\n");
						int a=sc.nextInt();
						if(a==1)
						{
							removelist.add(s);
							System.out.println("Phone number is deleted");
						
						}
						else if(a==2)
						{
							System.out.println(s.toString());
						}
					}
					mcc.removeAll(removelist);
					break;
				case 3:
					System.out.println("Enter the number");
					Long num = sc.nextLong();
					ListIterator<MissedCalls> it1 = mcc.listIterator();
					boolean flag = false;
					 int i=0;
					while(it1.hasNext())
					{	i++;
						MissedCalls m1 = it1.next();
						if(m1.number==num)
						{
							flag =true;
							mcc.remove(m1);
						break;
						}
					}
					if(i!=0)
					{
						if(flag==true)
							System.out.println("Phone number with details "+ num +" deleted");
						else
							System.out.println("No such number exists");
					}
					else
						System.out.println("No missed Call");
					break;
				case 4:
					for(MissedCalls s:mcc)
					{
						System.out.println(s.toString());
					}
					break;
				default:System.out.println("Invalid Choice!");
		
			}
		

		}
	}

}
