import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class HackerRankReadingInput {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok = null;

	public static void main(String[] args) {
	    int n = getInt();
	    int q = getInt();
	    int cmd, c, len;
	}
	
	static String gets() throws IOException{
	    if(tok == null || !tok.hasMoreTokens())
	        tok = new StringTokenizer(br.readLine());
	    return tok.nextToken();
	}

	static int getInt() {
	    try {
	        return Integer.parseInt(gets());
	    } catch(IOException | NumberFormatException e) {
	        return -1;
	    }
	}
}
