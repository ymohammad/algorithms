package imtiaz.tutorial.problemset3;

/**
 * Find all circular (clockwise) tours a truck can take to visit all petrol pumps arranged in a circle. Assume:
	1.c[] has distance from each petrol pump to next.
	2.p[] has amount of petrol at every pump.
	3.The truck has to stop at and use all petrol at each pump.
	4.The truck has infinite capacity.
	5.For 1 unit petrol, the truck can go 1 unit of distance.
	Example:
	N = 4 c[] = {4, 3, 9, 5} p[] = {1, 2, 10, 8}
	
	0 --4-> 1 ---3-> 2 ---9--> 3 ----5-> 0
 * @author ymohammad
 *
 */
public class CircularTours {

	public static void main(String[] args) {
		int[] c = {4, 3, 9, 5};
		int[] p = {1, 2, 10, 8};
		
		for(int x = 0; x<c.length; x++) {
			completeTour(c, p, x, 0, x, true);
		}
	}
	public static void completeTour(int[] c, int[] p, int currentStation, int petrolLeft, int startPosition, boolean isFirstStation) {
		//System.out.println("CurrentStation: " + currentStation + " >>> petrolLeft::" + petrolLeft + ">>> StartPosition ::" + startPosition);
		if (c[currentStation] > p[currentStation] + petrolLeft || petrolLeft < 0) {
			//System.out.println("FAIL");
			return;
		}
		
		if (currentStation == startPosition && !isFirstStation) {
			System.out.println("Completed Tour for starting position " + startPosition +". Petrol left :" + petrolLeft);
			return;
		}
		
		petrolLeft = p[currentStation] + petrolLeft - c[currentStation];
		currentStation = c.length <= (currentStation+1) ? 0 : currentStation+1;
		completeTour(c, p, currentStation, petrolLeft, startPosition, false);
	}
}
