package simplilearn;

import java.util.Scanner;

public class calc {
	
	public static void main(String[] args) {
		
		double num1, num2;
		
		Scanner scanner =new Scanner (System.in);
		
		
		System.out.println("Please enter the first number: ");
		num1 = scanner.nextDouble();
		
	
		System.out.println("Please enter the second number: ");
		num2 = scanner.nextDouble();
		
		System.out.println("Please enter an arithmetic operator: (+-/* ): ");
	    char oper= scanner.next().charAt(0);
	       
	  	double ans;
	  	scanner.close();
	 
	   switch(oper)
	    {
	    case '+':
	    	ans = num1+num2;
	    	break;
	    	
	    case '-':
	    	ans = num1-num2;
	    	break;
	    	
	    case '*':
	    	ans = num1*num2;	
	    	break;
	    	
	    case '/':
	    	ans = num1/num2;
	    	break;
	    	
	    	default:
	    		 System.out.println("You have entered an invalid operator, please run the test again!");
	    		 return;

	    }

	
	    System.out.println("Answer is " +ans);
	    
	 	
		
		
	}
	
}


