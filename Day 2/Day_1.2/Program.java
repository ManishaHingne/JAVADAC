class Program
{
  public static void main1( String[] args )
  {
	int num1 = 10;
	//double num2 = ( double )num1;	//Widening : Ok
	double num2 = num1;	//Widening : OK

	System.out.println("Num2	:	"+num2);
  }

  public static void main2( String[] args )
  {
	double num1 = 10.5;
	int num2 = ( int )num1;//Narrowing
	System.out.println("Num2	:	"+num2);
  }
	
	public static void main( String[] args )
	{
		int num1 = Integer.parseInt( args[ 0 ] );
		float num2 = Float.parseFloat( args[ 1 ] );
		double num3 = Double.parseDouble( args[ 2 ] );
		double result = num1 + num2 + num3;
		System.out.println( "Result	:	"+result );
	}
}
