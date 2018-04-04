/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class BalancedString {
	public static void main (String[] args) {
		String input = "{[]{{{{{{{{{{{{{{{'''}";
		System.out.println(isBalanced(input));
	}
	static boolean isBalanced(String s) {
	    char[] cs = s.toCharArray();
	    Deque<Character> deque = new ArrayDeque<Character>();

	    for(int index = 0 ; index < cs.length; index++) {
	        char c = cs[index];
	        switch(c) {
	            case '{':
                case '[':
	                deque.addFirst(c);
	                break;
                case '}': {
                    char top = deque.peekFirst();
                    if (top == '{')
                        deque.removeFirst();
                    else
                        return false;
                }
                    break;
                case ']' : {
                    char top = deque.peekFirst();
                    if (top == '[')
                        deque.removeFirst();
                    else
                        return false;
                }
                    break;
                default:
                    return false;
	        }
	    }

	    if (deque.size() == 0) return true;
	    else return false;
	}
}
