
public class MethodTest {

    public static void main(String[] args) {

        // Range(int): Prints values 0 to 99
        Range x = new Range(-10, -30, -7);
        while (x.hasNext())
            System.out.println(x.next());
        System.out.println(x.next());
        System.out.println("\n Values 0 to 9 \n");
        System.out.println("foo");




/*
		// Range(int) Enhanced for loop: Prints values 0 to 9
				for (int val : new Range(1))
				  System.out.println(val + " ");
				 System.out.println(""); 
		 // Range(int, int):  Prints values 20 to 29
			 System.out.println( "\n Values 20 to 29 \n");
				for (int val : new Range(20, 30))
			  System.out.print(val + " \n");
		 System.out.println( "range(i, i, i): Multiples of 100 from 0 to 1000 \n");

	    // Prints multiples of 100 from 0 to 1000

        for (int val : new Range(-70, -40, 0))
            System.out.println(val);
*/
    }
}
