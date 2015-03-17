package aron;

public class Unicode2Saiyin {
	public static void main(String[] args)
	{
		for(int i = 0x1820; i < 0x189b; i++)
		{
			System.out.println(Integer.toString(i) + "," + Character.toString((char) (i)));
		}
	}

}
