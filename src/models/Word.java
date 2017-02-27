package models;

import com.google.common.base.Objects;

/**
 * Created by ciaran on 27/02/17.
 */
public class Word implements Comparable<Word>{
    private String spanishWord;
    private String englishWord;

    public Word(String spanishWord, String englishWord){
        this.spanishWord = spanishWord;
        this.englishWord = englishWord;
    }

    public String toString(){
        return spanishWord + " : " + englishWord + "\n";
    }

    public void addSpanishWord(String spanishWord){
        this.spanishWord = spanishWord;
    }

    public void addEnglishWord(String englishWord){
        this.englishWord = englishWord;
    }

    public String getSpanishWord(){
        return spanishWord;
    }

    public String getEnglishWord(){
        return englishWord;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.spanishWord, this.englishWord);
    }

    @Override
    public boolean equals(final Object obj){
        if(obj instanceof Word){
            final Word other = (Word) obj;
            return Objects.equal(spanishWord, other.spanishWord)
                    && Objects.equal(englishWord, other.englishWord);
        }else{
            return false;
        }
    }

    @Override
    public int compareTo(Word o) {
        return this.spanishWord.compareTo(o.spanishWord);
    }

}
