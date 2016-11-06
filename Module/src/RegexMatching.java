/**
 * Created by Aakash on 11/6/2016.
 */
public class RegexMatching {
    public boolean isMatch(String str, String pattern) {
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        boolean[][] rt = new boolean[s.length + 1][p.length + 1];
        rt[0][0] = true;
        for (int i = 1; i < rt[0].length; i++) {
            if(p[i - 1] == '*') {
                rt[0][i] = rt[0][i - 2];
            }
        }

        for (int i = 1; i < rt.length; i++) {
            for (int j = 1; j < rt[0].length; j++) {
                if(p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                    rt[i][j] = rt[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    if (rt[i][j - 2] || ((p[j - 2] == '.' || p[j - 2] == s[i - 1]) && rt[i - 1][j])) {
                        rt[i][j] = true;
                    }
                }
            }
        }
        return rt[s.length][p.length];
    }

    public static void main(String[] args) {
        RegexMatching regularExpressionMatching_hard = new RegexMatching();
        if (regularExpressionMatching_hard.isMatch("aakash", "a*.a.hb.")) {
            System.out.println("Regex matched");
        } else {
            System.out.println("Regex not matched");
        }
    }
}
