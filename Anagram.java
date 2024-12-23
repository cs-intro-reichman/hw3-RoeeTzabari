/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		String s1 = preProcess(str1), s2 = preProcess(str2);

		char c;
		for (int i = 0; i < s1.length(); i++) {
			c = s1.charAt(i);
			if (s2.indexOf(c) == -1) {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		char l;
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			l = str.charAt(i);
			if ((l >= 'a' && l <= 'z') || (l >= 'A' && l <= 'Z') || (l == ' ')) {
				newStr += ("" + l).toLowerCase();
			}
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		String newStr = "";
		String tempStr = "";
		int randomChar;
		
		while (str.length() > 0) {
			
			randomChar = (int)(Math.random() * str.length());
			newStr += str.charAt(randomChar);
			
			if(randomChar == str.length() -1) {
				tempStr = str.substring(0, randomChar);
			} 
			else {
				tempStr = str.substring(0, randomChar) + str.substring(randomChar+1, str.length() - 1) + str.charAt(str.length() -1);
			}

			str = tempStr;
			
		}
		return newStr;
	}
}
