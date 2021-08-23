package d210326;

class Check{
	
	public static boolean checkPal(int num) {
//		if(checkPrime(num)) {
//			String temp = num + "";
//			
//			int cnt = 0;
//			if(temp.length() % 2 == 0) {
//				for(int i=0; i<temp.length()/2; i++)
//					if(temp.charAt(i) == temp.charAt(temp.length() - i - 1))
//						cnt += 2;
//			}else {
//				for(int i=0; i<temp.length()/2; i++)
//					if(temp.charAt(i) == temp.charAt(temp.length() - i - 1))
//						cnt += 2;
//				
//				cnt += 1;
//			}
//			
//			if(cnt == temp.length())
//				return true;
//		}
//		
//		return false;
		
		StringBuilder str = new StringBuilder();
        str.append(num);

        return str.toString().equals(str.reverse().toString());
	}
	
	public static boolean checkPrime(int num) {
		
		if(num == 2)
			return true;

		if(num < 2 || num % 2 == 0)
			return false;
		
		int sqrt = (int)Math.sqrt(num);
		
		for(int i=3; i<=sqrt; i += 2) {
			if(num % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static int PalPrime(int num) {
		while(true) {
			if(checkPal(num))
				if(checkPrime(num))
					break;
			
			num += 1;
		}
		
		return num;
	}
}

public class P1747 {
	public static void main(String[] args) {
		
		int i = 2;
		System.out.println(Check.PalPrime(i));
	}
}
