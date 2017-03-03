package controllers;

import models.Word;
import utils.DataInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciaran on 27/02/17.
 */
public class DictionaryAPI {

    public static ArrayList<Word> BST = new ArrayList<>();

    public DictionaryAPI(){}

    public static void main(String[] args) throws Exception {
        Word one = new Word("test", "test", null,null);
        Word two = new Word("atest", "atest", null, null);
        addWord(one);
        addWord(two);
        System.out.println(BST.toString());
    }

    public static void prime() throws Exception{
        DataInput loader = new DataInput();
        List<Word> words = loader.loadData("././data/spanish");
        for(Word word : words){
            System.out.println(word);
        }
    }

    public static void addWord(Word newEntry){
        int parent = 0;

        if(BST.size()==0){
            BST.add(newEntry);
        }else if(BST.size()>0){
            if(BST.get(parent).getSpanishWord().compareTo(newEntry.getSpanishWord())<0){
                if(BST.get(parent).getLeftWord()==null){
                    BST.add(newEntry);
                }else{

                }
            }
        }
    }

}

