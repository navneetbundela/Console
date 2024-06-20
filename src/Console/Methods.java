package Console;

import java.lang.reflect.Method;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
	public static List<User> Users = new ArrayList<>();
	public static List<phone> p = new ArrayList<>();
	public static String phoneRegrex = "[0-9]{10}";
	public static String mailRegrex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	public static Scanner sc = new Scanner(System.in);

	public static void Ui() throws Exception {
		System.out.println("...........................................");
		System.out.println("Console Base App");
		System.out.println("Create User : 1");
		System.out.println("Update User : 2");
		System.out.println("Delete User : 3");
		System.out.println("Fetch Single User : 4");
		System.out.println("Fetch All User : 5");
		
		
		try {
			int num = sc.nextInt();
			//Integer i=num;
			
			if (num == 1) {

				Methods.create();
			} else if (num == 2) {
				Methods.update();
			} else if (num == 3) {
				Methods.delete();
			} else if (num == 4) {
				Methods.fetchSingleUser();
			} else if (num == 5) {
				Methods.fetchAllUser();
			}else if(num==0)
			{
				System.out.println("wrong Input , Press 1 to exit");
				if(sc.nextInt()==1)
				{
					Methods.Ui();
				}
			}
			else {
				System.out.println("Invalid Input");
				Methods.Ui();
			}

			
		} catch (InputMismatchException e) {
			
			System.out.println("Invalid Input");
			System.out.println("..............................");
			
		//	System.out.println("wrong Input , Press any key to exit");
			try{
				
				  String inp=sc.nextLine(); 
				//  System.out.println(inp);
				  if(!inp.isEmpty())
				  Methods.Ui();
				  
				 }
			catch(InputMismatchException i)
			{ 
				System.out.println("Again Wrong input");
				
			}
			//Methods.Ui();
		}

	

	}

	// .......................................................................................
	public static void create() throws Exception {
		// Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Enter Name");
			String name;
			name = sc.next();
			System.out.println("Enter mail");
			String mail = sc.next();
			boolean mailAns = Methods.StringValidate(mailRegrex, mail);
			if (mailAns == false) {
				System.out.println("Wrong mail format please re Enter Details");
				Methods.create();
			}
						for(User user : Users)
			{
				if(user.getEmail().equals(mail))
				{
					
					System.out.println("User Already Exist");
					Thread.sleep(500);
					Methods.create();
				}
			}
						System.out.println("Enter Phone Number");
			String phone = sc.next();
			//String str = Long.toString(phone);
			boolean phoneAns = Methods.StringValidate(phoneRegrex, phone);
			if (phoneAns == false) {
				System.out.println("Wrong phone no. format please re Enter Details");
				Methods.create();
			}
			List<String> newPhone=new ArrayList<>();
			newPhone.add(phone);
			phone ob = new phone(newPhone, mail);
			p.add(ob);
			User obj = new User(name, mail, p);
			boolean ans = Users.add(obj);
			if (ans == true) {
				System.out.println("Successfuly created");
			} else {
				System.out.println("Not Created");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			Methods.create();
		}
		Thread.sleep(1000);
		
		Methods.Ui();

	}

	// .........................................................................................
	public static void update() throws Exception

	{

		try {
			System.out.println("Enter mail");
			String mail = sc.next();
			boolean mailAns = Methods.StringValidate(mailRegrex, mail);
				if(mailAns==false)
				{
					System.out.println("Wrong mail format please re Enter Details");
					Methods.update();
				}
							for(User user : Users)
				{
					if(user.getEmail().equals(mail))
					{
						System.out.println("User Not Found");
						Methods.Ui();
				}
				}
				
			System.out.println("Update Phone number : 1");
			System.out.println("Add another Phone number : 2");
			System.out.println("Update name : 3");
			
			try{int num = sc.nextInt();

				if (num == 1) {
					try 
					{
						System.out.println("Enter Old phone Unmber");
						String phOld = sc.next();
					
						boolean phoneOldAns=Methods.StringValidate(phoneRegrex, phOld);
						if(phoneOldAns==false)
						{
							System.out.println("Wrong phone no. format please re Enter Details");
							Methods.update();
						}
						System.out.println("Enter phone number for update");
						
					String ph = sc.next();
					
					boolean phoneAns=Methods.StringValidate(phoneRegrex, ph);
					if(phoneAns==false)
					{
						System.out.println("Wrong phone no. format please re Enter Details");
						Methods.update();
					}
					for (User user : Users)
	
					{
						System.out.println("itr");
						if (user.getEmail().equals(mail))
	
						{
							System.out.println(user.getEmail());
							for (phone ph1 : p)
							{
								if (ph1.getMail().equals(mail))
								{
									
									ph1.replacePhone(phOld, ph);
									System.out.println("Phone number is modified");
									break;
									
								}
							}
						}
	
	
					}
					
					}
				
			
					catch(InputMismatchException e)
					{
						System.out.println("Wrong phone Number format");
						System.out.println(".....................................");
						Thread.sleep(500);
						Methods.update();
					}
								

			    }
				else if (num == 2) {
				try {
				System.out.println("Add Phone Number");
				String ph = sc.next();
								boolean phoneAns=Methods.StringValidate(phoneRegrex, ph);
				if(phoneAns==false)
				{
					System.out.println("Wrong phone no. format please re Enter Details");
					Methods.update();
		
				}
				//phone ph2=new phone();
				for(phone ph1 : p)
				{
					if(ph1.getMail().equals(mail))
					{
						//ph2=ph1;
						ph1.addPhone(ph);
					break;
						
						
					}
				}
			//	ph2.setPhone(ph);
				//p.add(ph2);
				System.out.println("Phone number added Successfuly");
				System.out.println();
				}
				catch(InputMismatchException e)
				{
					System.out.println("Wrong phone number format");
					System.out.println("........................................");
					Methods.update();
				}
			} else if (num == 3) {
				System.out.println("Enter new name");
				String newName = sc.next();
				for (User user : Users) {
					if (user.getEmail().equals(mail)) {
						user.setName(newName);
						System.out.println("Name Changed Successfully");
						Thread.sleep(300);
						break;
					}
				}
			} else {
				System.out.println("Wrong Input");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
		}

		
		Methods.Ui();
		}
		
		
		catch(InputMismatchException e)
		{
			System.out.println("Invalid Input format Please try again");
			Thread.sleep(300);
			Methods.update();
			
		}
	}
	// ...................................................................................

	public static void delete() throws Exception {
		
		try {
			System.out.println("Enter mail");
			String mail = sc.next();
			boolean regexAns = Methods.StringValidate(mailRegrex, mail);
				if (regexAns == false) 
				{
				System.out.println("Wrong mail Please Re Enter");
				Methods.delete();
			    }
			User u = new User();
			int c = 0;
				for (User user : Users) {
					if (user.getEmail().equals(mail))

					{
						u = user;
						c++;
						break;
					}
				}
				if (c == 0) {
					System.out.println("User Not Found");
				}
				int c1=0;
				phone phon1=new phone();
				for(phone pho : p)
				{
					if(pho.getMail().equals(mail))
					{
						phon1=pho;
						c1++;
						break;
					}
				}
				if(c1!=0)
				{
					p.remove(phon1);
				}
			boolean ans = Users.remove(u);
				if (ans == true) {
					System.out.println("Successfuly Removed");
				} else {
					System.out.println("Not Removed");
				}
				} 
		catch (InputMismatchException e) {
			System.out.println("Invalid mail");
			System.out.println("..........................................");
		}
		
		Methods.Ui();
	}

	// .....................................................................................
	public static void fetchSingleUser() throws Exception {
		System.out.println("Enter mail");
		String mail = sc.next();
		boolean mailAns = Methods.StringValidate(mailRegrex, mail);
		if (mailAns == false) {
			System.out.println("Invalid input please reEnter");
			Methods.fetchSingleUser();
		}
		int c = 0;
		for (User user : Users) {
			if (user.getEmail().equals(mail))

			{
				for(phone objP :p)
				{
					if(objP.getMail().equals(mail))
					{
						System.out.println("Name : " +user.getName());
						System.out.println("Mail : "+user.getEmail());
						System.out.println("Phone no. : "+objP.getPhone());
						Thread.sleep(2000);
						c++;
						break;
					}
				}
				
				
			}

		}
		try {
			if (c == 0) {
				throw new UserPrincipalNotFoundException(mail);
			}
		} catch (UserPrincipalNotFoundException u) {
			System.out.println("User Not Found" + u);
			Thread.sleep(500);
		}
		
		Methods.Ui();
	}

	// ......................................................................................
	public static void fetchAllUser() throws Exception {

	
		for (User user : Users) {
			
				for(phone objP :p)
				{
					if(objP.getMail().equals(user.getEmail()))
					{
						System.out.println("Name : " +user.getName());
						System.out.println("Mail : "+user.getEmail());
						System.out.println("Phone no. :  1"+objP.getPhone());
						System.out.println(".........................................");
						Thread.sleep(1000);
						
					}
				}
				
				// user.toString();
			}
		// for(User user : Users) {
		// user.toString();
		// }
		System.out.println("Enter 1 to exit");
		int n = sc.nextInt();
		if (n == 1) {
			Methods.Ui();
		}

	}

	// ........................................................................................
	public static Boolean StringValidate(String re, String str) {
		Pattern pattern = Pattern.compile(re);
		Matcher matcher = pattern.matcher(str);
		boolean ans = matcher.matches();
		return ans;

	}
}
