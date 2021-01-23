package com.awad.anthony.demos.utils;

import java.util.regex.Pattern;

public class test {


	public static void main(String[] args) {
//		CircularLinkedList c = new CircularLinkedList();
//		B b = new B(1);
//		B b1 = new B(1);
//		B b2 = new B(1);
//		B b3 = new B(1);
//		B b4 = new B(1);
//		
//		c.addListNode(b);
//		c.addListNode(b1);
//		c.addListNode(b2);
//		c.addListNode(b3);
//		c.addListNode(b4);
//		
//		System.out.println(c.containsListNode(b1));
		String string = "aabbbccccx"; 
		System.out.print(isValid(string,0));
	}
	
	

	public static boolean isValid(String s,int index) {

		String newstring = s;
		if (index != 0) {
			newstring = s.substring(0, s.length()-index) + s.substring(s.length()-index, s.length()-1);
			index++;
		}else {
			++index;
		}

		if(!Pattern.compile("(.{1,2})+").matcher(newstring).matches()) {
			return true;
		}
		return isValid(s,index);
	}

}
