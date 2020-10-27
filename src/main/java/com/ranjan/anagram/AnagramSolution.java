package com.ranjan.anagram;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

public class AnagramSolution {
	private static List<SortedSet<String>> result;

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Please provide a path to file!");
			System.exit(0);
		}
		try {
			printList(findAnagrams(args[0]));
		} catch (Exception e) {
			System.out.println("Exception Occured!! Please check " + e.getMessage());
		}
	}

	private static String getSortedChars(String inputString) {
		char[] stringChars = inputString.toCharArray();
		Arrays.parallelSort(stringChars);
		return new String(stringChars);
	}

	private static void printList(List<SortedSet<String>> collections) {
		// Entire method could be avoided if we appropriatly create a custom collection
		// class and override the "toString()" method
		for (SortedSet<String> collection : collections) {
			System.out.print("\n");
			for (String item : collection) {
				System.out.print(item + "\t");
			}
		}
	}

	public static List<SortedSet<String>> findAnagrams(String inputFile) throws Exception {
		// Buffered reader yields better latency as compared to scanner or file reader.
		// The buffer size can be varied as per the amount of data reading from the
		// sources, in our case, buffer size is default.
		BufferedReader bufferedReader = null;
		result = new ArrayList<SortedSet<String>>();

		try {
			bufferedReader = Files.newBufferedReader(Paths.get(inputFile));

			// MultiMap from Guava provides ability to implement 1:N relationship. The key
			// of the map is sorted letters and the its values are corresponding anagrams.
			// We use LinkedList variant to preserve order
			Multimap<String, String> inputMap = LinkedListMultimap.create();

			String statement;
			while ((statement = bufferedReader.readLine()) != null) {
				if (statement.isEmpty())
					continue;

				if (!inputMap.containsValue(statement.trim().toLowerCase())) {
					inputMap.put(getSortedChars(statement.trim().toLowerCase()), statement.trim().toLowerCase());
				}

			}

			for (String inputKey : inputMap.keySet()) {
				if (inputMap.get(inputKey).size() > 1) {
					// Sorted Set/Tree Set sorts the values corresponding to each key of the map as
					// required in the output
					SortedSet<String> set = new TreeSet<String>(inputMap.get(inputKey));
					result.add(set);
					// Current printing functionality yields O(n*n*n) complexity, we can reduce the
					// complexity by following Options:
					// 1. Modify the method printList() and directly call the method from this
					// point.
					// 2. In a larger scenario, we can keep the complexity as o(n) by overriding the
					// "toString()" method of the custom List and directly print to console at this
					// point.
				}
			}

		} finally {
			if (bufferedReader != null)
				bufferedReader.close();
		}

		return result;
	}
}
