package Permutations;

public class StringPermutator {
	
	public static String[] getStringPermutations(String str){
		String[] retval = new String[5];
		int n  = str.length();
		permute(str, 0, n-1);
		return retval;
	}
	public static String permute(String str, int a, int b){
		if(a==b){
			System.out.println(str);
		}
		else {
			for (int i = 0; i <= str.length()-1; i++) {
				str = swap(str, a, i);
				permute(str, a+1, b);
				str = swap(str, a, i);
			}
		}
		return str;
	}

	public static String swap(String a, int i, int j){
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
