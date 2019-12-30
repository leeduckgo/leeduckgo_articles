import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OOPWords {
    private Set<String> NON_WORDS = new HashSet<String>() {{
        add("a"); add("an"); add("on");
    }}; // collection of the word should be ignored

    public Map wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
        Matcher m = Pattern.compile("\\w+").matcher(words);

        while(m.find()) {
            String word = m.group().toLowerCase();
            if (! NON_WORDS.contains(word)) {
                if (wordMap.get(word) == null) {
                    wordMap.put(word, 1);
                }else{
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }
        return wordMap;
    }

    public static void main(String[] args){
        OOPWords words = new OOPWords();
        System.out.println(words.wordFreq("A apple on an apple tree"));
    }
}
