import java.util.Scanner;
class Complex
{
  //Field
  private int real;	//0
  private int imag;	//0
 
 //Complex this
  public Complex( )
  {
	this( 10, 20 );	//ctor chaining
  }
  public Complex( int real, int imag )
  {
	this.real = real;
	this.imag = imag;
  }
  //Complex this = c1
  public void acceptRecord()
  {
	Scanner sc = new Scanner( System.in );
	System.out.print("Real number	:	");
	this.real = sc.nextInt();
	System.out.print("Imag number	:	");
	this.imag = sc.nextInt();
  }
  //Complex this = c1
  public void printRecord()
  {
	System.out.println("Real Number	:	"+this.real);
	System.out.println("Imag Number	:	"+this.imag);
  }
}
class Program
{
  public static void main1( String[] args )
  {
	Complex c1 = new Complex( );
  	c1.acceptRecord( );
	c1.printRecord( );//Message Passing
  }
  public static void main2( String[] args )
  {
	Complex c1 = null;	//c1 -> null reference variable/null object
	c1.printRecord( );	//NullPointerException
  }
  public static void main( String[] args )
  {
	Complex c1 = null;
	c1 = new Complex( );	//To avoid NullPointerException
	c1.printRecord( );	//NullPointerException
  }
}




