package test;

public class NumBackwardsAlt {

	public static void main(String[] args) {
		//Method 1
		for (int i = 100; i > 0; i--) {
			if (i%5==0) {
				System.out.println("Agile");
				if (i%3==0) {
					System.out.println("Testing");
					System.out.println("Software");
				} else {
					System.out.println("Agile");
				}
			} else if (i%3==0) {
				if (i%5==0) {
					System.out.println("Testing");
				} else {
					System.out.println("Software");
				}
			} else if (i%5!=0 && i%3!=0) {
				System.out.println(i);
			}
		}
		
		//Method 2
		/*for (int i = 100; i > 0; i--) {
			if (i%5==0) 
			{
				System.out.println("Agile");
			} 
			if (i%3==0) 
			{
				System.out.println("Software");
			}
			if (i%5==0 && i%3==0) 
			{
				System.out.println("Testing");
			}
			if (i%5!=0 && i%3!=0) 
			{
				System.out.println(i);
			}
		}*/
	}
}
