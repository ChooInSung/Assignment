public class PascalRecursive3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalRecursiveFinal main = new PascalRecursiveFinal();
		main.setCount(20);
	}
	
	int num;
	
	public void setCount(int n) {
		this.num = n;
		this.pascal(n);
	}

	// n�� ����ŭ print()��� �Լ�, recursePascal ��� �Լ� ȣ���ϰ� ���� ĭ����  �̵�
	public void pascal(int n) {
		if(n==0) {
			return;
		}
		int count = this.num-n+1;
		printSpace(n);
		recursePascal(count, count-1, 0);
		System.out.println("");
		
		
		n -= 1;
		pascal(n);
	}
	
	// countRow �� �ະ�� �������� �ϴ� ������ ���̴�. ȣ��� ������ -1�� ���༭ 0�� �� ��� ��� �Լ��� ������. i,j�� �� ��� ���� ��Ÿ���ִ� index�̴�.
	public void recursePascal(int countRow, int i, int j) {
		
		if(countRow==0) {
			return;
		}
		
		int num = returnNum(i, j);
		int digit = 0;
		int newNum = num;
		
		// �ڸ��� ��� �� digit�� �����Ѵ�.
		while(newNum>0) {
			newNum /= 10;
			digit += 1;
		}
		
		// �ڸ��� ���� ���� �¿� ������ �ٸ��� ���ش�. �ڸ����� Ŭ���� ���� �۰� ���ش�.
		if(digit<2) {
			if(i+1==countRow && j==0) {
				System.out.print(num+" ");
			}
			else {
				System.out.print("    "+num+" ");
			}
		}
		else if(digit<3) {
			System.out.print("   "+num+" ");
		}
		else if(digit<4) {
			System.out.print("  "+num+" ");
		}
		else if(digit<5) {
			System.out.print(" "+num+" ");
		}
		else {
			System.out.print(num+" ");
		}
		
		recursePascal(countRow-1, i, j+1);
	}
	
	// recursePascal���� �ʿ��� ���ڸ� ��ȯ���ش�.
	public int returnNum(int i, int j) {
		
		if(j==0||j==i) {
			return 1;
		}
		
		return returnNum(i-1, j-1)+returnNum(i-1, j);
	}
	
	// �Ƕ�̵� ����� ���� �� �ְ� �� �ະ�� ������ ������ִ� �Լ��̴�.
	public void printSpace(int n) {
		if(n==1) {
			return;
		}
		
		System.out.print("   ");
		printSpace(n-1);
	}
}