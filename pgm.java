package labcie;

import java.util.Scanner;

public class pgm 
{	
	String name,stud_addr,stud_phoneno,stud_emailid,branch;
	double tfees,ad_fee,tuition_fees,fee1;
	static String college,address,phoneno;
	static
	{
		college="RVCE";
		address="Bangalore";
		phoneno="9535771683";
	}
		
	pgm(String name2,String add,String phoneno2,String emailid2,String branch2)
	{
		this.name=name2;
		this.stud_addr=add;
		this.stud_phoneno=phoneno2;
		this.stud_emailid=emailid2;
		this.branch=branch2;
	}
	
	pgm(String name2,String add,String branch2)
	{
		this.name=name2;
		this.stud_addr=add;
		this.stud_phoneno=phoneno;
		this.stud_emailid=" "+name+ "@rvce.edu.in";
		this.branch=branch2;
	}
	
	public double fee(String branch2)
	{
		this.ad_fee=25000;
		this.tuition_fees=35000;
		this.fee1=20000;
		tfees=ad_fee+tuition_fees+fee1;
		if(branch.equalsIgnoreCase("MCA"))
		{
			tfees+=45000;
		}
		else
		{
			tfees+=15000;
		}
		return tfees;
	}
	
	public void display()
	{
		System.out.println("NAME: "+name);
		System.out.println("ADDRESS: "+address);
		System.out.println("PHONE NUMBER: "+phoneno);
		System.out.println("EMAIL ID: "+stud_emailid);
		System.out.println("BRANCH: "+branch);
	}
	
	public void display(String branch)
	{
		double feecal=this.fee(branch);
		System.out.println("Total fee for the branch " +branch+ "total fee: "+feecal);
	}
	
	public void display(int nooffields)
	{
		if(nooffields==3)
		{
			System.out.println("NAME: "+name+ "\n ADDRESS: " +address+ "PHONE NO: "+phoneno);
		}
		else
		{
			System.out.println("NAME: "+name+ "\n ADDRESS: " +address+ "\nPHONE NO: " +phoneno+ "\nEMAIL ID: " +stud_emailid+ "\nBRANCH" +branch );
		}
	}
	
	public static void main(String args[])
	{
		pgm s;
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("ENTER THE DETAILS OF STUDENTS");
			System.out.println("Enter student's name: ");
			String name=sc.next();
			System.out.println("Enter the address: ");
			String addr=sc.next();
			System.out.println("Enter the branch: ");
			String branch=sc.next();
			System.out.println("To enter the emailid and phone number, please enter 1: ");
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.println("Enter the email id: ");
				String emailid=sc.next();
				System.out.println("Enter the phone no: ");
				String phoneno=sc.next();
				s=new pgm(name,addr,phoneno,emailid,branch);
			}
			else
			{
				s=new pgm(name,addr,branch);
			}
			
			System.out.println("1. Display all details of the student");
			System.out.println("2. Display total branch fee");
			System.out.println("3. Display the selected fields");
			System.out.println("Enter your choice: ");
			int ch=sc.nextInt();
			if(ch==1)
			{
				s.display();
			}
			else if(ch==2)
			{
				System.out.println("Enter the branch: ");
				branch=sc.next();
				s.display(branch);
			}
			else if(ch==3)
			{
				System.out.println("Enter the number of fields (3/5) to display: ");
				int nooffields=sc.nextInt();
				s.display(nooffields);
			}
			else
			{
				System.out.println("INVALID CHOICE!!");
			}
			System.out.println("Enter choice: 1.CONTINUE 2.EXIT");
			sc.nextInt();
			if(choice==2)
			{
				break;
			}
		}
	}
}