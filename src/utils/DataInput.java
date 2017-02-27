package utils;

import edu.princeton.cs.introcs.In;
import models.Word;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciaran on 27/02/17.
 */
public class DataInput {
    public static void main(String[] args){

    }

    public List<Word> loadData(String filename) throws Exception {
        File wordsFile = new File(filename);
        In inWords = new In(wordsFile);

        String delims = "[\t]";
        List<Word> words = new ArrayList<Word>();
        while(!inWords.isEmpty()){
            String wordDetails = inWords.readLine();
            String[] wordTokens = wordDetails.split(delims);
            if(wordTokens.length == 2){
                String spanishWord = wordTokens[0];
                String englishWord = wordTokens[1];

                words.add(new Word(spanishWord, englishWord));
            }else{
                throw new Exception("Invalid token length: " + wordTokens.length);
            }
        }
        return words;
    }
}
