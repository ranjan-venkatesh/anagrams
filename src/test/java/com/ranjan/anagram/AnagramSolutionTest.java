package com.ranjan.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class AnagramSolutionTest {
	//Point the following variable to the directory of sample file on your local workspace
	private String inputFile = "/home/ranjan/eclipse-workspace-practice/codility_puzzles/src/sample";
	private static List<SortedSet<String>> expectedResult = new ArrayList<SortedSet<String>>();
	
	@Test
	public void testBasic() throws Exception {
		SortedSet<String> a = new TreeSet<String>(Arrays.asList("act","cat"));
		SortedSet<String> b = new TreeSet<String>(Arrays.asList("acre","care","race"));
		expectedResult.add(a);
		expectedResult.add(b);
		
		Assert.assertEquals(expectedResult, AnagramSolution.findAnagrams(inputFile));
	}

}
