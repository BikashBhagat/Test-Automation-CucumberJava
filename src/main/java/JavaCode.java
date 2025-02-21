
public class JavaCode {

	public static void primeNumber(int n){
		for (int i =0; i<=n;i++){
			if (i==0||i==1){
				continue;
			}

			int flag = 1;
			for (int x=2;x<=i/2; x++){
				if(i%x==0){
					flag = 0;
					break;
				}
			}
			if (flag==1){
				System.out.println(i);
			}
		}
	}

	public static int reverseNumber(int num){
		int res = 0;
		while(num>0){
			res = res*10 +num % 10;
			num = num/10;
		}
		return res;
	}

	public static void revString(){
		String text = "Bikash";
		int i = text.length();//6
		String s = "";
		for(int j=i-1;j>=0;j--)
		{
		s += text.charAt(j);
		}
		System.out.println(s);
	}

	public static boolean isPalindrome(String text){
	
			int left = 0;
			int right = text.length()-1;
	
			while (right>left){
				if (text.charAt(left)!=text.charAt(right)){
					return false;
				}
				left++;
				right--;
			}
			return true;
	
	
		}
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[] numbers = {1,2,4,3,2};
			
			// System.out.println(numbers[0]);
			// System.out.println(numbers[4]);
			int[] arr = new int[5];
			for(int i=0;i<numbers.length;i++) {
				arr[numbers.length - (i+1)]=numbers[i];
			}
			// for (int s:arr) {
			// 	System.out.println(s);
			// }
			String text= "Bikash";
			System.out.println("Is Palindrome "+isPalindrome(text));
			

			int num= 123456;
			System.out.println("reverse number "+reverseNumber(num));
			int n=10;
			primeNumber(n);

			StringBuilder sb = new StringBuilder(text);
			if (text.contains(sb.reverse()))
			{
				System.out.println("text is palindrome");
			}
			revString();

	    }
	    }
	    


