import java.util.HashMap;
import java.util.HashSet;

public class Code_819 {

    public static void main(String[] args) {
        Code_819 c = new Code_819();
        String[] banned = {"hit"};
        c.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banned);
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("\\!|\\?|\\'|\\,|;|\\.| ");

        HashSet<String> bannedSet = new HashSet<>(banned.length);
        for (String ban : banned) {
            bannedSet.add(ban);
        }

        int most = 0;
        String mostCommon = "";
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            word = word.trim().toLowerCase();
            if (!bannedSet.contains(word) && word.length() > 0) {
                wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
                if (wordsMap.get(word) > most) {
                    mostCommon = word;
                    most = wordsMap.get(word);
                }
            }
        }
        return mostCommon;
    }
}
