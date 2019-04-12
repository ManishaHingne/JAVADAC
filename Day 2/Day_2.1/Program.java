class Program
{
  public static void main( String[] args )
  {
		System.out.println("Result	:	"+2 + 3 );	//23
		System.out.println("Result	:	"+( 2 + 3 ) ); //5
  }
  public static void main1( String[] args )
  {
	String name = "Sandeep Kulange";
	int empid = 33;
	float salary = 25000.50f;
	System.out.printf("%-30s%-5d%-10.2f\n",name,empid,salary);

	name = "Amit Pol";
	empid = 45;
	salary = 125000.50f;
	System.out.printf("%-30s%-5d%-10.2f\n",name,empid,salary);
  }
}
