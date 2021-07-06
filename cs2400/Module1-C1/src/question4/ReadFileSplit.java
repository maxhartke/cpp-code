package question4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class ReadFileSplit {
    public static void main(String[] args) {
    String str=" ";
    int count=0;	
    try
    {
		File myFile=new File("/mnt/c/Teaching/Cal Poly/fall 2020/CS2400/code/Module1/src/practiceSols/test.txt");
 		Scanner scan=new Scanner(myFile);
		while(scan.hasNextLine())
		{
			str=scan.nextLine();
			String [] strtok = str.split("\\s+"); // delimitor is multiple white space			
			//String [] strtok = str.split(" "); // delimitor is single white space
			for(int i=0; i<strtok.length; ++i)
			{
				System.out.println(strtok[i]);
				count++;				
			}			  
        }
		scan.close();
    }    //end of try block of code!!!!!!
    catch(IOException ioe)
    { 
		System.out.println("The file can not be read");
		System.exit(-1);
	}
    
	System.out.println("The number of strings tokens read is:" + count);
    }
}
