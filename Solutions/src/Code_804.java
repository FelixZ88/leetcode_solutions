import java.util.HashMap;

public class Code_804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashMap unique = new HashMap();
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            for (char c : word.toCharArray()) {
                sb.append(morses[c - 'a']);
            }
            String morse = sb.toString();
            if (!unique.containsKey(morse)) {
                unique.put(morse, 1);
            }
        }
        return unique.size();
    }
}
