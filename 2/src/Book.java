import java.util.Comparator;

public class Book {
	String title,author,publisher;
	double price;
	Book(String title,String author,String publisher,double price)
	{
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
	}
	public static Comparator<Book> cp = new Comparator<Book>() {

		public int compare(Book b1,Book b2) {

		   double p1 = b1.price;
		   double p2 = b2.price;
		   return (int) (p1-p2);
		}
	};
	public String getPublisher() {
		return publisher;
	}
	public String toString()
	{
		return "Title: "+title+"\tAuthor: "+author+"\tPublisher: "+publisher+"\tPrice:"+price;
	}
}
