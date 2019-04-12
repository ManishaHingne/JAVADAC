//import java.lang.String;
//import java.lang.System;
import java.util.Scanner;
class Program
{
  public static void main1( String[] args )
  {
	String str = "125";
	int number = Integer.parseInt( str );	//UnBoxing
 	 System.out.println("Number	:	"+number);
  }
  public static void main2( String[] args )
  {
	int number = 125;
	//String str = Integer.toString( number );//Boxing
	String str = String.valueOf( number );//Boxing
 	System.out.println("Number	:	"+str);
  }
  public static void main( String[] args )
  {
	//java.util.Scanner sc = new java.util.Scanner( System.in );
	Scanner sc = new Scanner( System.in );

	
	System.out.print("Name	:	");
	String name = sc.nextLine();
	System.out.print("Empid	:	");
	int empid = sc.nextInt();
	System.out.print("Salary	:	");
	float salary = sc.nextFloat();

	System.out.printf("%-30s%-5d%-10.2f\n",name, empid,salary);
  }
}
