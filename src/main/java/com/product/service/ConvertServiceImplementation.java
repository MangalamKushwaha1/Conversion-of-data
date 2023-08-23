package com.product.service;

import java.util.Arrays;
import org.springframework.stereotype.Service;



@Service
public class ConvertServiceImplementation implements ConvertService {

	@Override
	public String convertToCamelCase(String data) {
		// Initialize a StringBuilder to store the result
		StringBuilder result = new StringBuilder();

		// Split the input data into words using whitespace as delimiter
		String[] words = data.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			String word = words[i]; // Get the current word

			// Capitalize the first letter of the word and concatenate the rest of the word
			word = Character.toUpperCase(word.charAt(0)) + word.substring(1);

			result.append(word); // Append the modified word to the result
			// Append a space if it's not the last word
			if (i < words.length - 1) {
				result.append(" ");
			}
		}
		// Convert the result StringBuilder to a String and return it
		return result.toString();
	}

	@Override
	public String sortingEachWordByExclusion(String word, int numToPreserve) {
		String[] words = word.split(" ");
		StringBuilder result = new StringBuilder();

		for (String w : words) {
			if (w.length() <= numToPreserve) {
				result.append(w).append(" ");
				continue;
			}

			char[] tempArray = w.substring(numToPreserve).toCharArray();
			Arrays.sort(tempArray);

			result.append(w.substring(0, numToPreserve)).append(tempArray).append(" ");
		}

		return result.toString().trim();
	}

	String sortingEachWordByExclusions(String input, int numToPreserve) {
		String[] words = input.split(" ");
		for (int i = 0; i < words.length; i++) {
			words[i] = sortingEachWordByExclusion(words[i], numToPreserve);
		}
		return String.join(" ", words);
	}

// // specify the maximum number of allowed duplicate words in a given string.
	@Override
	public String removeDuplicateWords(String input, int allowedDuplicateWords) {

		String[] words = input.split(" ");

		// String result=
		for (int i = 0; i < words.length; i++) {
			if (words[i] != null) {
				for (int j = i + 1; j < words.length; j++) {
					if (words[i].equals(words[j])) {
						words[j] = null;
					}
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (String word : words) {
			if (word != null) {
				result.append(word).append(" ");
			}
		}

		return result.toString().trim();
	}


	@Override
	public String dataSwapping(String input, String swapby, String swapon) {
		 String result="";

		String word = "word";
		String character = "character";
		String even = "even";
		String odd = "odd";

		if(swapby.equals(word)) {
			switch(swapon) {
			case "even":
				//System.err.println("word && even");
				result=getSwapWordByEvenMethod(input); break;

			case "odd":
				//System.err.println("word && odd");
				result= getSwapWordByOddMethod( input); break;
			
		}
		}
			if(swapby.equals(character)) {
				switch(swapon) {
				case "even":
					//System.err.println("char && even");
					result= getSwapCharacterByEvenMethod( input); break;
				case "odd":
					//System.err.println("char && odd");
					result= getSwapCharacterByOddMethod(input); break;
					
				}
			}

		return result;
	}


//swapping by word based on even index 
	public String getSwapWordByEvenMethod(String input) {
		String[] a = input.split(" ");
		String result = "";
		for (int i = 0; i < a.length- 2; i++) {
			if (i % 2 == 0) {
				String temp = a[i];
				a[i] = a[i + 2];
				a[i + 2] = temp;
			}
		}
		for (String word : a) {
			// System.out.print(word + " ");
			result += word + " ";
		}
		
		return result;
	}

	// swapping by word based on odd index
	public String getSwapWordByOddMethod(String input) {

		String[] a = input.split(" ");
		String result = "";

		for (int i = 0; i < a.length - 2; i++) {
			if (i % 2 == 1) {
				String temp = a[i];
				a[i] = a[i + 2];
				a[i + 2] = temp;
			}
		}

		for (String words : a) {
			result += words + " ";
		}
		return result;
	}

	// swapping by character based on even index
	public String getSwapCharacterByEvenMethod(String input) {

		String[] arrOfStr = input.split(" ");
		String result = "";
		if (arrOfStr.length > 0) {
			for (String s : arrOfStr) {
				s = s.trim();
				char[] arr = s.toCharArray();
				for (int j = 0; j < arr.length - 2; j++) {
					if (j % 2 == 0) {
						char temp = arr[j];
						arr[j] = arr[j + 2];
						arr[j + 2] = temp;
					}
				}
				String string = new String(arr);
				result += string + " ";
			}
		}
		return result;
	}

	// swapping by character based on odd index
	public String getSwapCharacterByOddMethod(String input) {

		String[] arrOfStr = input.split(" ");
		String result = "";
		if (arrOfStr.length > 0) {
			for (String s : arrOfStr) {
				s = s.trim();
				char[] arr = s.toCharArray();
				for (int j = 0; j < arr.length - 2; j++) {
					if (j % 2 == 1) {
						char temp = arr[j];
						arr[j] = arr[j + 2];
						arr[j + 2] = temp;
					}
				}
				String string = new String(arr);
				result += string + " ";
			}
		}
		return result;
	}				
}
		
