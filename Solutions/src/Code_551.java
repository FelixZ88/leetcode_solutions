public class Code_551 {
    public boolean checkRecord(String s) {
        int L_Continous_Count = 0, A_Count = 0, P_Count = 0;
        for (char p : s.toCharArray()) {
            if (p == 'P') {
                P_Count ++;
                L_Continous_Count = 0;
            } else if (p == 'A'){
                A_Count ++;
                L_Continous_Count = 0;
                if (A_Count > 1) {
                    return false;
                }
            } else if (p == 'L') {
                L_Continous_Count ++;
                if (L_Continous_Count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
