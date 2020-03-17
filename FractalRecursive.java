import java.util.Scanner;

public class FractalRecursive {
	
	int denominator;
	int numerator;

	private static Scanner input = new Scanner(System.in);
	
	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public FractalRecursive() {
		// TODO Auto-generated constructor stub
		this.setDenominator(1);
		this.setNumerator(3);
	}
	
	public void fractal(int count) {
		if(count>1) {
			recurseFractal(1, this.getNumerator(), this.getDenominator(),count-1);
		}
	}
	
	public void recurseFractal(int blackTriangleNum, int preNumerator, int preDenominator ,int count) {
		if(count==0) {
			return;
		}
		
		int whiteTriangleNum = blackTriangleNum;
		
		this.numerator = 2*preNumerator + 3*whiteTriangleNum;
		this.denominator = 2*preDenominator;
		
		recurseFractal(blackTriangleNum*3, this.getNumerator(), this.getDenominator(), count-1);
	}

	public void result() {
		System.out.print("input: ");
		int count = input.nextInt();
		
		while(count>0) {
			fractal(count);
			
			System.out.println("S"+count+" = ("+this.getNumerator()+"/"+this.getDenominator()+")L");
			System.out.println("");
			
			this.setDenominator(1);
			this.setNumerator(3);
			
			System.out.print("input: ");
			count = input.nextInt();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractalRecursive main = new FractalRecursive();
		main.result();
	}
	
}