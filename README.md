# anagrams puzzle

## Problem Description
List all anagrams of words contained within a file. Two words are defined as anagrams if they do share the same letters, but are in a different order (i.e. the english words race and care are anagrams). 

Given an input file which contains one word per line, as an output construct a list of all anagrams fromthat input file. Print those words to the console, where all words that are an anagram should each other should be on the same line. 

As an example, given the sample.txt file: 

act

cat

tree

race

care

acre

bee

the output should be: 

act cat

acre care race

## Solution 
The main idea behind the solution is to eventually create a 1:N relationship where a particular set of sorted characters has N permutations inserted in the file. 

## Requirements

1. Java version >= 1.8
2. Maven (install on debian with "sudo apt install maven")
3. sample.txt file on the local machine with list of words and anagrams separated by newline (Please ensure that the user has appropriate rights to the created document)

## How to Run

1. In root directory, run command "mvn package" on local terminal
2. If the execution succeeds, there will be a jar file generated in the path "<directory_name>/target" with name "puzzle-0.0.1-SNAPSHOT.jar".
3. Execute the jar on the local terminal with program argument as path to sample.txt 
 *** Example command : java -jar puzzle-0.0.1-SNAPSHOT.jar /home/ranjan/eclipse-workspace-practice/codility_puzzles/src/sample ***
4. Verify the output

