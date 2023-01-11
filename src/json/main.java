package json;
import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException{

        Scanner in = new Scanner(System.in);
        int choise;
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Your choise Number: "+"\n");
            System.out.println("1- Create json file");
            System.out.println("2- insert new building");
            System.out.println("3- search in json file");
            System.out.println("4- delete building");
            System.out.println("0- Exit");

            choise = in.nextInt();

  switch (choise) {

            case 0: {
                flag = false;
                System.out.println("Program closed");
                break;
            }
            
            case 1:{
            	json.create();
                 break;
            }
            
            case 2: {
                json.insert();
                break;
            }
            
            case 3: {
               
                json.search();
                break;
            }
            
            case 4: {
          
                json.delete();
                break;
            }
  }
        }
    }

}