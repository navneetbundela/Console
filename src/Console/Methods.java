package Console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Methods {
	public static List<User> Users=new ArrayList<>();
	public static int  Ui()
	{
		System.out.println("Console Base App");
		System.out.println("Create User : 1");
		System.out.println("Update User : 2");
		System.out.println("Delete User : 3");
		System.out.println("Fetch Single User : 4");
		System.out.println("Fetch All User : 5");
		Scanner sc=new Scanner(System.in);
		int num=0;
		try {
		 num=sc.nextInt();
	//	System.out.println(num);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid Input");
			System.out.println("..............................");
			Methods.Ui();
			
		}
		return num;
		
		
	}
	public static void create() throws InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name");
		String name =sc.next();
		System.out.println("Enter mail");
		String mail=sc.next();
		System.out.println("Enter Phone Number");
		long phone =sc.nextLong();
		User obj=new User(name, mail, phone);
	boolean ans=	Users.add(obj);
	if(ans==true)
	{
		System.out.println("Successfuly created");
	}
	else
	{
		System.out.println("erro");
	}
	Thread.sleep(1000);
	Methods.Ui();
		
		
	}

}
