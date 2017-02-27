package controllers;

import models.Word;
import utils.DataInput;

import java.util.List;

/**
 * Created by ciaran on 27/02/17.
 */
public class DictionaryAPI {

    public DictionaryAPI(){}

    public static void main(String[] args) throws Exception {
        prime();
    }

    public static void prime() throws Exception{
        DataInput loader = new DataInput();
        List<Word> words = loader.loadData("././data/spanish");
        for(Word word : words){
            System.out.println(word);
        }
    }

}

