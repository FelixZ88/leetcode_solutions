public class Code_657 {
    public boolean judgeCircle(String moves) {
        int L_Count = 0, R_Count = 0, U_Count = 0, D_Count = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                if (R_Count != 0) {
                    R_Count --;
                } else {
                    L_Count ++;
                }
            } else if (move == 'R') {
                if (L_Count != 0) {
                    L_Count --;
                } else {
                    R_Count ++;
                }
            } else if (move == 'U') {
                if (D_Count != 0) {
                    D_Count --;
                } else {
                    U_Count ++;
                }
            } else if (move == 'D'){
                if (U_Count != 0) {
                    U_Count --;
                } else {
                    D_Count ++;
                }
            }
        }
        if (L_Count == 0 && R_Count == 0 && U_Count == 0 && D_Count == 0) {
            return true;
        }
        return false;
    }
}
