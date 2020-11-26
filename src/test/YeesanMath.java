package test;

public class YeesanMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 0.0;
		double i = 1.0;
		while (x<10) {
			x = (x+1)/i;
			i++;
			System.out.printf("x = %f\n",x);
			System.out.printf("i = %f\n",i);
		}
	}

}
