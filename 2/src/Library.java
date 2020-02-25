import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
public class Library {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Book> al=new ArrayList<Book>();
		ArrayList<Book> al1=new ArrayList<Book>();
		ArrayList<Book> al2=new ArrayList<Book>();
		Book b1=new Book("ABC","EB","FD",1500);
		Book b2=new Book("DA","EB","FD",999.99);
		Book b3=new Book("KC","R","B",1299);
		al.add(b1);
		al.add(b2);
		al.add(b3);
		al1.addAll(al);
		Collections.sort(al1,Book.cp);
		for(Book b:al1)
		{
			System.out.println(b.toString());
		}
		HashMap<Integer,Book> hm=new HashMap<Integer,Book>();
		hm.put(1,b1);
		hm.put(2,b2);
		hm.put(3,b3);
		Scanner sc=new Scanner(System.in);
		String auth=sc.next();
		for(Book b:al1)
		{
			if((b.author).equals(auth))
			{
				System.out.println(b.toString());
			}
		}
		double a=sc.nextDouble();
		for(Book b:al1)
		{
			if((b.price)>a)
			{
				al2.add(b);
			}
		}
		System.out.println("\n");
		for(Book b:al2)
		{
			System.out.println(b.toString());
		}
		System.out.println("\n");
		for(Book b:al1)
		{
			if((b.title).contains("D"))
			{
				System.out.println(b.toString());
			}
		}
		System.out.println("\n");
		Map<String, List<Book>> bypub = al.stream() .collect(Collectors.groupingBy(Book :: getPublisher));
		System.out.println("Books grouped by publisher " + bypub);
		String title=sc.next();
		for(Book b:al1)
		{
			if((b.title).equals(title))
			{
				b.publisher="A";
			}
		}
		for(Book b:al1)
		{
			System.out.println(b.toString());
			
		}
		
		
	}

}
