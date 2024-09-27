// Main.java			
// Pig Latin Converter
// This is the student starting file for Lab02bPigLatin.

import java.util.Scanner;

public class PigLatin
{
	public static void main (String[] args)
	{
      		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String str = input.nextLine(); 
		System.out.print("Enter a sentence: ");
		String sentence = input.nextLine(); 
		String pig = FigureOutWord.convertSentence(sentence);
		String piggie = FigureOutWord.convertWord(str);
		System.out.println();
		System.out.println("Converted word: " + piggie);
		System.out.println("Converted sentence: " + pig);
		input.close();
	}
}

///// This can be put all in one file or make a separate class in BlueJ
class FigureOutWord
{
	/*
	 * Precondition:  s is a String containing a single word.
	 * Postcondition: returns a word converted into Pig Latin according to the appropriate rule.
 	 * 
	 */
    public static boolean isVowel(String s){
        s = s.toUpperCase();
    if(s.substring(0,1).equals("A") || s.substring(0,1).equals("E") || s.substring(0,1).equals("I") || s.substring(0,1).equals("O") || s.substring(0,1).equals("U")){
        return true;
    } else{
        return false; 
    }
       
    }
	public static Boolean startsVowel(String s){
		 if(FigureOutWord.isVowel(s.substring(0,1))){
        return true;
    } else{
        return false; 
    }

	}
	public static Boolean startsConstonant(String s){
		s.toUpperCase();
		 if(s.substring(0,1).equals("A") || s.substring(0,1).equals("E") || s.substring(0,1).equals("I") || s.substring(0,1).equals("O") || s.substring(0,1).equals("U")){
        return false;
    } else{
        return true; 
    }

  }
  	public static Boolean startsTwoConstonants(String s){
		if(FigureOutWord.startsConstonant(s)){
			if(FigureOutWord.isVowel(s.substring(1,2))){
				return false;
			}else{
				return true;
			}
			}else{
				return false;
			}
		}

	public static String convertWord(String s)
	{
		if(FigureOutWord.startsTwoConstonants(s)){
			return s.substring(2) + s.substring(0,2) + "ay";
		}else if(FigureOutWord.startsConstonant(s)){
			return s.substring(1) + s.substring(0,1) + "ay";
		}else{
			return s + "ay";
		}
     		 
	}  
	public static String convertSentence(String s){
    String[] words = s.split(" ");
        String pigLatinSentence = "";
        for (String word : words) {
            pigLatinSentence += convertWord(word) + " ";
        }
        return pigLatinSentence.trim();

	}
   
}
