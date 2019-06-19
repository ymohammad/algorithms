import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class RemoveFriend4 {
   public static void main(String args[] ) throws Exception {
	         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int totalTestCases = Integer.parseInt(br.readLine());
	        for(int i=0;i<totalTestCases;i++) {
	            int totalFriendsToDelete = Integer.parseInt(br.readLine().split(" ")[1]);
	            String[] popularity = br.readLine().split(" ");
	            LinkedList ll = new LinkedList(Arrays.asList(popularity));
	            
	            
	            // iterate over each element in LinkedList and show what is in the list.
	            ListIterator iterator = ll.listIterator();
	            int previousPopularity = -1;
	            while (iterator.hasNext()) {
	            	if(previousPopularity > -1) {
	            		int currentPopularity = Integer.parseInt((String)iterator.next());
	            		if(previousPopularity < currentPopularity) {
	            			iterator.previous();
	            			iterator.previous();
	            			iterator.remove();
	            			totalFriendsToDelete --;
	            			if(totalFriendsToDelete == 0) {
	            				break;
	            			}
	            			if(iterator.hasPrevious()) {
	            				iterator.previous();
	            			}
	            			
	            			previousPopularity = Integer.parseInt((String)iterator.next());
	            		} else {
	            			previousPopularity = currentPopularity;
	            		}
	            	} else {
	            		previousPopularity = Integer.parseInt((String)iterator.next());
	            	}
	            }
	            
	            ListIterator iteratorNew = ll.listIterator();
	            while (iteratorNew.hasNext()) {
	                if(iteratorNew.nextIndex() == ll.size() - totalFriendsToDelete) {
	            		break;
	            	}
	            	System.out.print(iteratorNew.next()+" ");
	            }
	            System.out.println();
	        }
 
	    }
}