package json;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
public class json{
	Scanner input = new Scanner(System.in);

	public static void create() {
		Scanner input = new Scanner(System.in);
		JSONArray jarr = new JSONArray();

		// Create a JSON objects
		JSONObject obj1 = new JSONObject();
		obj1.put("BlName", "UN HQ");
		obj1.put("city", "nyc");
		obj1.put("FoundationYear", "1952");
		
		// Add the object to the array
		jarr.put(obj1);

		// Create another JSON object
		JSONObject obj2 = new JSONObject();
		obj2.put("BlName", "Khufu Pyramid");
		obj2.put("city", "cairo");
		obj2.put("FoundationYear", "2570 BC");

		// Add the object to the array
		jarr.put(obj2);
		
		JSONObject obj3 = new JSONObject();
		obj3.put("BlName", "Eiffel Tower");
		obj3.put("city", "paris");
		obj3.put("FoundationYear", "1889C");
		
		jarr.put(obj3);
		
	    String f;  
		System.out.println("Enter file name");
		f= input.next();
		// Print the array
		
		 try (FileWriter file = new FileWriter(f+".json")) {
		      file.write(jarr.toString());
		      file.flush();
		      System.out.println(jarr);
		    } 
		 catch (IOException e) {
		      e.printStackTrace();
		    }
	}
		 
		//////////////////////////////////////////
		 
	public static void insert() {
		
		 Scanner input1 = new Scanner(System.in);
		
		  String f;  
		  System.out.println("Enter file name");
		  f= input1.next();
		  try (FileReader reader = new FileReader(f+".json")) {
			  
			  Scanner input = new Scanner(System.in);
		      JSONArray array = new JSONArray(new JSONTokener(reader));
		      
		      int num;
		      System.out.println("Enter number of buildings : ");
		      num = input.nextInt();
		      
		      for(int i=1; i<=num; i++) {

		      JSONObject obj4 = new JSONObject();
		      String bl;
				 System.out.println("Enter BlName "+i +" :");
				 bl = input.next();
				 obj4.put("BlName", bl);
				 String c;
				 System.out.println("Enter city "+i +" :");
				 c = input.next();
				 obj4.put("city", c);
				 String year;
				 System.out.println("Enter FoundationYear "+i +" :");
				 year = input.next();
				 
				 obj4.put("FoundationYear", year);

		      array.put(obj4);
		      }
		      try (FileWriter file = new FileWriter(f+".json")) {
		        file.write(array.toString());
		        file.flush();
		      }
}
		  catch (IOException e) {
		      e.printStackTrace();
		    }
	}
		  
		  
		  //////////////////////////////////////////////////
		  
	public static void search() {
		
		Scanner input1 = new Scanner(System.in);
		  String f;  
		  System.out.println("Enter file name");
		  f= input1.next();
		  
		  try (FileReader reader = new FileReader(f+".json")) {
			  
		 while ( true ) {
			 
		      
		      
		      System.out.println ( " 1- Search by city        " );
		      System.out.println ( " 2- Search by foundation year" );
		      System.out.println ( " 3- back" );
		      
		      Scanner input2 = new Scanner(System.in);
		      int choise = input2.nextInt ( );
		     
		     
		      if(choise == 1) {
		      
			  Scanner input = new Scanner(System.in);
		      JSONArray array = new JSONArray(new JSONTokener(reader));
		      String city;
			  System.out.println("enter city");
			   city = input.next();
			   int flag=0;
			   
		      for (int i = 0; i < array.length(); i++) {
		        JSONObject obj = array.getJSONObject(i);
		      
		        if (obj.getString("city").equals(city)) {
		          System.out.println("Found object: " + obj.toString());
		         flag=1;
		        }
		        
		    }
		      if(flag==0) {
		        	 
		        	 System.out.println("Not Found");
		        	 break;
		         }
		      }
		      
		      else if(choise == 2) {
		    	  
		    	  Scanner input = new Scanner(System.in);
			      JSONArray array = new JSONArray(new JSONTokener(reader));
			      String year;
				  System.out.println("enter foundation year");
				   year = input.next();
				   int flag=0;
				   
			      for (int i = 0; i < array.length(); i++) {
			        JSONObject obj = array.getJSONObject(i);
			        if (obj.getString("FoundationYear").equals(year)) {
			          System.out.println("Found object: " + obj.toString());
			         flag=1;
			        }
			        
			    }
			      if(flag==0) {
			        	 
			        	 System.out.println("Not Found");
			        	 break;
			         }
		      }
		      
		      else if ( choise == 3 ) {
	                break;
	            }
	            else {
	                System.out.println ( "Enter valid number" );
	            }
		      
		     }
		 
	}
		  
		  
		  catch (IOException e) {
		      e.printStackTrace();
		    }
	}
		  
		  ///////////////////////////////////////////////////////
		  
	public static void delete() throws FileNotFoundException, IOException {
		
		 Scanner input1 = new Scanner(System.in);
		  String f;  
		  System.out.println("Enter file name");
		  f= input1.next();
		
		  try (FileReader reader = new FileReader(f+".json")) {
			  
			  Scanner input = new Scanner(System.in);
		      JSONArray array = new JSONArray(new JSONTokener(reader));
		      String city;
			  System.out.println("enter city : ");
			   city = input.next();
			   int flag=0;
			   
		      for (int i = 0; i < array.length(); i++) {
		        JSONObject obj = array.getJSONObject(i);
		        if (obj.getString("city").equals(city)) {
		        	array.remove(i);
		        	System.out.println("Deleted");
		         flag=1;
		        }
		        
		    }
		         if(flag==0) {
		        	 
		        	 System.out.println("Not Found");
		         }
		         
		
		  try (FileWriter file = new FileWriter(f+".json")) {
		        file.write(array.toString());
		        file.flush();
		      }
		  catch (IOException e) {
		      e.printStackTrace();
		    }
		}
	}

}
