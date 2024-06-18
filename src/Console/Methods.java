package Console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Methods {
	public static List<User> Users=new ArrayList<>();
	public static List<phone> p=new ArrayList<>();
	public static int  Ui() throws InterruptedException
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
		 if(num==1)
			{
				Methods.create();
			}
			else if(num==2)
			{
				 Methods.update();  
			}
			else if(num==3)
			{
				Methods.delete();                        
			}
			else if(num==4)
			{
				Methods.fetchSingleUser();
			}
			else if(num==5)
			{
				Methods.fetchAllUser();
			}
			else 
			{
				System.out.println("Invalid Input");
				Methods.Ui();
			}


		// sc.close();
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
	//.......................................................................................
	public static void create() throws InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		try {System.out.println("Enter Name");
		String name =sc.next();
		System.out.println("Enter mail");
		String mail=sc.next();
		System.out.println("Enter Phone Number");
		long phone =sc.nextLong();
		phone ob=new phone(phone,mail);
		p.add(ob);
		User obj=new User(name, mail, p  );
	boolean ans=	Users.add(obj);
	if(ans==true)
	{
		System.out.println("Successfuly created");
	}
	else
	{
		System.out.println("erro");
	}
	}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid Input");
			Methods.create();
		}
		Thread.sleep(1000);
	Methods.Ui();
		sc.close();
		
	}
	//.........................................................................................
	public static void update() throws InterruptedException
	
	{Scanner sc=new Scanner(System.in);
	
		try {
		System.out.println("Enter mail");
		String mail=sc.next();
		System.out.println("Update Phone number : 1");
		System.out.println("Add another Phone number : 2");
		System.out.println("Update name : 3");
		//boolean ans=Users.contains(mail);
		//System.out.println(ans);
		int num=sc.nextInt();
		
		if(num==1)
		{
			System.out.println("Enter phone number for update");
			long ph =sc.nextLong();
			
			
		for(User user : Users)
		{
			if(user.getEmail().equals(mail))
			{
				for (phone ph1 : p)
				{
					if(ph1.getMail().equals(mail))
					{
						ph1.setPhone(ph);
					}
				}
			}
			return;
		}
		    
			
		}
		else if(num==2)
		{
			System.out.println("Add Phone Number");
			long ph=sc.nextLong();
			phone ob=new phone(ph,mail);
			p.add(ob);
		}
		else if(num==3) 
		{
			System.out.println("Enter new name");
			String newName=sc.next();
			for(User user: Users)
			{
				if(user.getEmail().equals(mail))
				{
					user.setName(newName);
				}
			}
		}
		else
		{
			System.out.println("Wrong Input");
		}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid Input");
		}
				
		sc.close();
		Methods.Ui();
	}
	//...................................................................................
	
	public static void delete() throws InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		try {
		System.out.println("Enter mail");
		String mail=sc.next();

			for(User user: Users)
			{
				if(user.getEmail().equals(mail))
					
				{
					Users.remove(user);
				
				}
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Inatlid mail");
		}
			sc.close();
			Methods.Ui();
	}
	
	
	//.....................................................................................
	public static void fetchSingleUser() throws InterruptedException
	{Scanner sc=new Scanner(System.in);
	System.out.println("Enter mail");
	String mail=sc.next();

		for(User user: Users)
		{
			if(user.getEmail().equals(mail))
				
			{
				user.toString();
			}
		}
		sc.close();
		Methods.Ui();
	}
	
	//......................................................................................
	public static void fetchAllUser() throws InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mail");
		String mail=sc.next();
		for(User user : Users) {
			user.toString();
		}
		sc.close();
		Methods.Ui();

	}

}
