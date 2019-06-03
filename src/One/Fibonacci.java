package One;

public class Fibonacci 
{
	public static void main(String[] args) 
	{
		fibonacci(21);
	}
	
	public static int[] fibonacci(int elements)
	{
		int[] sequencia = new int[elements];
		sequencia[0] = 1;
		sequencia[1] = 1;
		System.out.print("[ 1, 1, ");
		for (int i = 2; i < elements; i++)
		{
			sequencia[i] = sequencia[i -1] + sequencia[i - 2];
			System.out.print((int)(sequencia[i]) + ", ");
		}
		System.out.println("}");
		return sequencia;
		
	}
}
