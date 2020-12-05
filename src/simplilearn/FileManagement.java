package simplilearn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class FileManagement {
	
   static Scanner s;
	
  public static void main(String[] args) throws Exception  {
		
	  try {
		 
        //Welcome Message
		System.out.println("****************************************************\n");
        System.out.println("WELCOME To LOCKEDME.COM FILE MANAGEMENT APPLICATION!!! \n ");
        System.out.println("****************************************************\n");
        System.out.println("Developed by Deelu Alexander.\n");
                    
          Main_Menu();
	    
		
			} catch (Exception  e) {
				
				System.err.println("Exception Found!.. : "+e.getMessage()+"\n");
				Main_Menu();
		    }
	  }

		
	//Main Menu
	 	 private static void Main_Menu() throws Exception {
	 		try {
		     s = new Scanner(System.in);
		    System.out.println("\n  ***********\n");
		    System.out.println("    MAIN MENU:");
		    System.out.println("\n  ***********\n");
		    System.out.println(" 1: Display all files in  a specific directory");
	        System.out.println(" 2: Add a file to the directory");
	        System.out.println(" 3: Delete a file from the directory");
	        System.out.println(" 4: Search for a file in the directory");
	        System.out.println(" 5: Exit\n");
	        
	        System.out.println(" Please enter the code for your option (1/2/3/4/5): \n");
	        int option= s.nextInt();
	       
	        System.out.println(" ***You selected option "+option +"***.\n");
	       
	        if (option==1) {
	        	Display_Files();
	 	    	ReturnToMain();
	        }else if (option==2) {
	        	Add_File();
	 	        ReturnToMain();
	        }else if (option==3) {
	        	Delete_File();
	        }else if (option==4) {
	        	Search_File();
	        }else if (option==5) {
	        	Exit();
	        }
	        else {
	        	System.out.println("Sorry,you have entered an invalid option.\n");
	        	ReturnToMain();}
	        }catch (Exception e) {
	        	e.getMessage();
	        	System.out.println("Sorry,you have entered an invalid option.\n");
	        }
	 		ReturnToMain();
	 	 s.close();
	      }
	
	 	//Method to return to Main Menu
			private static void ReturnToMain() throws Exception{
				try {
				
			    s = new Scanner(System.in);
				int result;
				do {
				System.out.println("\n**Please press 0 to go back to main menu: **");
				result=s.nextInt();
							
				if (result==0) {
					Main_Menu();
					
				}else {
					System.out.println("Sorry,you have entered an invalid option, please press 0 to go back to main menu: \n");
				}
					
				}while (result!=0);
				}catch (Exception e) {
				e.getMessage();
	        	System.out.println("Sorry,you have entered an invalid option...\n");
				ReturnToMain();}
				s.close();
				
			}
	
	   //Method to Add  a new file
			private static void Add_File () throws Exception{
				
			s = new Scanner(System.in);
			
			//Getting directory and file name from user
						
			System.out.println("Enter the path of the directory to save the file: \n");
			String dir = s.nextLine();
			
            System.out.println("Please enter a filename: ");
			String fname=s.nextLine();
						
			//Creating directory		
			File dirname =new File(dir);
									
			if (dirname.exists() && dirname.isDirectory()){ 
				System.out.println("Directory already exists...\n");
				System.out.println("Now adding file to the directory..\n");
			}else {
					System.out.println("Directory does not exist. Creating new directory now...\n");
					dirname.mkdir(); //creating new directory
			}
			//Creating file in directory
									
				File file =new File(dirname,fname);
				if (file.exists()) {
					System.out.println("File already exist in the directory\n");
								
						}
					     else {
					    	 FileWriter writer =new FileWriter(file);
							  writer.close();	
					      System.out.println("File is successfully created in the directory \n");
					     }
				
				//Additional logic to write to the file with content from user.
                        System.out.println("Do you like to add your file content?. Press 1 for Yes and 0 for No:");
                        
                        int final_option =s.nextInt();
                        if (final_option==1) {
                        	Write_Files(file);
                        	ReturnToMain();
                        	}
                        else if(final_option==0){
                        	ReturnToMain();
                        	
                        }
                        else {
                        	System.out.println("Sorry, you have entered an invalid option..\n.");
                        	ReturnToMain();
                        }
                        
								
				
				s.close();
				
				
         }
			
			
		//Write to a file		
        private static void Write_Files(File file) throws Exception{
	
        	System.out.println("Please enter file content: \n");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String content=br.readLine();
			
			FileWriter writer =new FileWriter(file, true);
					
			writer.write("\n"); //appends to the existing content
			writer.write(content);
					     	        	
        	writer.close();
			ReturnToMain();
	}


		

		//Method to Delete a file
		public static void Delete_File() throws Exception { 
			 s = new Scanner(System.in);
			System.out.println("Enter the directory of the file to the delete: \n");
			String dirname=s.next();
			System.out.println("Enter the file name you like to delete: \n ");
			String fname=s.next();
					
			
				if(Files.deleteIfExists(Paths.get(dirname, fname))) {
				System.out.println("File "+fname+ " is successfully deleted from the directory " +dirname+ "\n");}
				else {
					System.out.println("File or directory does NOT exist.");}
					ReturnToMain();
					s.close();				
					
					
		 }
		
		//Method to search for a file
		
		public static void Search_File() throws Exception {
			
		     s = new Scanner(System.in);
			System.out.println("Enter the directory name of the file you like to search: \n");
			String dirname=s.next();
			System.out.println("Enter the file name you like to search: \n ");
			String fname=s.next();
			
							
			if(Files.exists(Paths.get(dirname, fname))) {
				System.out.println("File "+fname+ " is successfully found in directory " +dirname+ "\n");
				ReturnToMain();
				}
			else { 
				System.out.println("File or directory does NOT exist...");  }
			   ReturnToMain();
			   s.close();
			
			
		}
		
		//Method to display all files in a given directory
		
		public static void Display_Files() throws Exception {
						
		     s = new Scanner(System.in);
			System.out.println("Enter the directory name to display the files: \n");
			String dir=s.next();
			File dirname =new File(dir);
			File[] files = dirname.listFiles();
			
			//Checking if directory exists
			if (dirname.exists() && dirname.isDirectory())
			{ 
				Arrays.sort(files);  //Uses quick sort
				System.out.println("Directory  exists...\n");
				System.out.println("Checking files now....");
								
			//Checking if files present
			    if(files !=null && files.length>0)
			   {
			      System.out.println("Files in directory " +dirname+ " are: \n");
				  for (int i=0;i<files.length;i++)
				    {
					  
					  System.out.println(files[i].getName());  //prints file name
				  	 }
			     }else {
			    	 System.out.println("Sorry, there are NO files in the selected directory...");}
			    
			   }else{
					System.out.println("Sorry, directory entered does NOT exist...");}
				
			    ReturnToMain();
			    
			    s.close();
		}
			
		

	//Method to Exit
		public static void Exit() throws Exception{
						
		     s = new Scanner(System.in);
			System.out.println("Are you sure you want to exit?. Please press 1 for Yes and 0 for No: ");
			 int final_option = s.nextInt();
			 if (final_option==1) {
				 System.out.println("You selected to exit the application.");
				 System.out.println("Thank you for using LOCKEDME.COM FILE MANAGEMENT APPLICATION !!!");
				  System.exit(0);
			 }else if (final_option==0){
				 Main_Menu();
			 }
			 else {
				 System.out.println("Sorry, you have entered an invalid option...");
				 ReturnToMain();
			 }
			
			s.close();
			}
		
				
}
	   

