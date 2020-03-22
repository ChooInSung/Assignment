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

	// n의 수만큼 print()재귀 함수, recursePascal 재귀 함수 호출하고 다음 칸으로  이동
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
	
	// countRow 각 행별로 출력해줘야 하는 숫자의 수이다. 호출될 떄마다 -1을 해줘서 0이 될 경우 재귀 함수가 끝난다. i,j는 각 행과 열을 나타내주는 index이다.
	public void recursePascal(int countRow, int i, int j) {
		
		if(countRow==0) {
			return;
		}
		
		int num = returnNum(i, j);
		int digit = 0;
		int newNum = num;
		
		// 자릿수 계산 후 digit에 저장한다.
		while(newNum>0) {
			newNum /= 10;
			digit += 1;
		}
		
		// 자릿수 별로 숫자 좌우 간격을 다르게 해준다. 자릿수가 클수록 간격 작게 해준다.
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
	
	// recursePascal에서 필요한 숫자를 반환해준다.
	public int returnNum(int i, int j) {
		
		if(j==0||j==i) {
			return 1;
		}
		
		return returnNum(i-1, j-1)+returnNum(i-1, j);
	}
	
	// 피라미드 모양이 생길 수 있게 각 행별로 공백을 만들어주는 함수이다.
	public void printSpace(int n) {
		if(n==1) {
			return;
		}
		
		System.out.print("   ");
		printSpace(n-1);
	}
}