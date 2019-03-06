import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_811 {

    public static void main(String[] args) {
        Code_811 c = new Code_811();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        c.subdomainVisits(cpdomains);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> counts = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] countAndDomain = cpdomain.split(" ");
            int count = Integer.valueOf(countAndDomain[0]);
            String domain = countAndDomain[1];

            String subdomain = "";
            String[] subdomains = domain.split("\\.");
            for (int i = subdomains.length - 1; i >= 0; i --) {
                if (i == subdomains.length - 1) {
                    subdomain = subdomains[i];
                } else {
                    subdomain = subdomains[i] + "." + subdomain;
                }
                if (counts.containsKey(subdomain)) {
                    counts.put(subdomain, counts.get(subdomain) + count);
                } else {
                    counts.put(subdomain, count);
                }
            }
        }

        ArrayList<String> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            ret.add(entry.getValue() + " " + entry.getKey());
        }

        return ret;
    }
}
