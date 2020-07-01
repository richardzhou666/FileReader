package com.flexon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    /** Read from file word by word without filtering
     * @param path local path to the file
     * @return ArrayList of words, return null if file empty */
    public ArrayList<String> readRaw(String path) {
        try {
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);
            myReader.useDelimiter("[^A-Za-z]+");
            ArrayList<String> wordList = new ArrayList<>();
            while (myReader.hasNext()) {
                wordList.add(myReader.next());
            }
            return wordList;
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occurred! ");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> read(String path) {
        ArrayList<String> wordList = readRaw(path);
        HashMap<String, Integer> wordMap = toHashMap(wordList);
        ArrayList<String> result = new ArrayList<>();
        for (String word:wordMap.keySet()) {
            if (filter(word, wordMap)) result.add(word);
        }
        return result;
    }

    protected HashMap<String, Integer> toHashMap(ArrayList<String> wordList) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String word:wordList) {
            if (!result.containsKey(word)) {
                result.put(word, 1);
            } else
            result.put(word, result.get(word) + 1);
        }
        return result;
    }

    private boolean filter(String word, HashMap<String, Integer> wordMap) {
        return (wordMap.get(word) >5 && word.length() > 3);
    }

    /** Print each word in a separate line*/
    public void print(String path) {
        ArrayList<String> wordList = read(path);
        for (String word:wordList) {
            System.out.println(word);
        }
    }

    /** Read words from file and reverse each word */
    public ArrayList<String> reverse(String path) {
        ArrayList<String> wordList = read(path);
        ArrayList<String> reversed = new ArrayList<>();
        for (String word:wordList) {
            StringBuilder sb = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                sb.append(word.toCharArray()[i]);
            }
            reversed.add(sb.toString());
        }
        return reversed;
    }

    /** Print each reversed word */
    public void reversePrint(String path) {
        ArrayList<String> wordList = reverse(path);
        for (String word:wordList) {
                System.out.println(word);
        }
    }
}
