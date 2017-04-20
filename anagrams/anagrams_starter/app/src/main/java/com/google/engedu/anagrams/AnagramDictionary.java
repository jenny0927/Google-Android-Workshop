/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;
import android.util.Log;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private ArrayList<String> wordList;
    HashMap<String, ArrayList<String>> lettersToWord = new HashMap<String, ArrayList<String>> ();
    HashSet<String> wordSet = new HashSet<String>();

    //AnagramDictionary constructor
    // Each word that is read from the dictionary file stored in an ArrayList
    public AnagramDictionary(Reader reader) throws IOException {

        BufferedReader in = new BufferedReader(reader);
        String line;
        wordList = new ArrayList<String>();
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);
            wordSet.add(word);
            if(lettersToWord.containsKey(sortLetters(word))) {
                lettersToWord.get(sortLetters(word)).add(word);

            }
            else{
                lettersToWord.put(sortLetters(word),new ArrayList<String>());
                lettersToWord.get(sortLetters(word)).add(word);
            }
        }
    }

    //check the provided word is a valid dictionary word
    //check the word does not contain the base word as a substring
    public boolean isGoodWord(String word, String base) {
        return wordSet.contains(word) && !(word.contains(base));
    }

    //takes a string and finds all the anagrams of that string in our input
    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        int targetlength = targetWord.length();
        String sortedTarget = sortLetters(targetWord);
        for (String s : lettersToWord.get(sortedTarget)) {
            if (isGoodWord(s, targetWord)) {
                result.add(s);
            }
        }
        return  result;
    }

    public String sortLetters(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

//    public List<String> getAnagramsWithOneMoreLetter(String word) {
//        List<String> result = new ArrayList<String>();
//        String character = "abcdefghijklmnopqrstuvwxyz";
//
//        for(int i =0; i< character.length();i++){
//            String newWorld = word + character.charAt(i);
//            if(lettersToWord.containsKey(sortLetters(newWorld))){
//                for (String s : lettersToWord.get(sortLetters(newWorld))) {
//                    if (isGoodWord(s, word)) {
//                        result.add(s);
//                    }
//                }
//            }
//        }
//        return result;
//    }

    public String pickGoodStarterWord() {
        return "skate";
    }
}

