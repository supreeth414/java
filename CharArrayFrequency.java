package supreeth;

import java.util.HashMap;
import java.util.Map;

public class CharArrayFrequency {
	
	public static Map<Character,Integer> getCharFreq(char[] s) {
		  Map<Character,Integer> charFreq = new HashMap<Character,Integer>();
		  if (s != null) {
		    for (Character c : s) {
		    	//System.out.println(s.toCharArray());
		    //	System.out.println(c);
		      Integer count = charFreq.get(c);
		    //  System.out.println(charFreq.get(c));
		    //  System.out.println(count);
		      int newCount = (count==null ? 1 : count+1);
		     // System.out.println(newCount);
		      charFreq.put(c, newCount);
		    }
		  }
		  System.out.println(charFreq);
		  return charFreq;
		}

	public static void main(String[] args) {
		char[] s = { 'a', 'r', 't', 't', 's', 't' ,'a', 'r', 't', 't', 's', 't' ,'a', 'r', 't', 'i', 't', 't' };
		Map counts = getCharFreq(s);
		counts.get('t'); // => 3
		counts.get('a'); // => 7
		counts.get('s'); // => 6
		System.out.println(counts.get('t'));
		

	}

}
