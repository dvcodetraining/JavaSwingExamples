package Calculator;

import javax.swing.JFrame;

public class Calculator
{
	public static double add(double a, double b)
	{
		return a + b;
	}
	public static double sub(double a, double b)
	{
		return a- b;
	}
	public static double mult(double a, double b)
	{
		return a*b;
	}
	public static double div(double a, double b)
	{
		return a/b;
	}
	public static double squareRoot(double a)
	{
		return Math.sqrt(a);
	}
	public static int fatorial(int a)
	{
		if (a <2)
		{
			return 1;
		}
		return a*fatorial(a-1);
	}
	public static double exp(double a, double b)
	{
		return Math.pow(a, b);
	}
	public static double expE(int a)
	{
		return  Math.pow(Math.E, a);
	}
	public static double cubicRoot(double a)
	{
		return Math.cbrt(a);
	}
	public static double percentage(double a) 
	{
		return a/100;
	}
	public static double square(double a)
	{
		return a*a;
	}
	public static double cube(double a)
	{
		return a*a*a;
	}
}
