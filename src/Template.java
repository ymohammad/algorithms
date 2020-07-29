import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Template
{
	//Multiple Arrays
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            
            int n = Integer.parseInt(arrayValues[0].trim());
            int m = Integer.parseInt(arrayValues[1].trim());
            
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
			line = br.readLine();
            arrayValues = line.trim().split(" ");
			int[] b = new int[m];
            i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        b[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			//int x = getCount(a, b, n, m);
			//System.out.println(x);
            t--;
        }
	}
	//Single Array
	public static void main1(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			int x = Integer.parseInt(br.readLine().trim());
			
			System.out.println(x);
            t--;
        }
	}
	
	//1 size and Multiple Arrays
		public static void main3(String[] args) throws NumberFormatException, IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	            int n = Integer.parseInt(br.readLine().trim());
	            
	            String line = br.readLine();
	            String[] arrayValues = line.trim().split(" ");
	            int[] a = new int[n];
	            int i = 0;
				for (String s: arrayValues) {
				    if (s != null && s.trim().length() > 0) {
				        a[i]= Integer.parseInt(s.trim());
				        i++;
				    }
				}
				line = br.readLine();
	            arrayValues = line.trim().split(" ");
				int[] b = new int[n];
	            i = 0;
				for (String s: arrayValues) {
				    if (s != null && s.trim().length() > 0) {
				        b[i]= Integer.parseInt(s.trim());
				        i++;
				    }
				}
					
				//int x = getCount(a, b, n, m);
				//System.out.println(x);
	            t--;
	        }
		}
		
		public static void main4(String[] args) throws NumberFormatException, IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	            // Input the size of the array
	            String line = br.readLine();
	            //printPattern(line);
	            t--;
	        }
		}
}
