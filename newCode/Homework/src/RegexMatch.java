/**
 * @author Freaver
 * @date 07/10/2021 13:49
 * @description
 */
public class RegexMatch {

    public static void main(String[] args) {
        RegexMatch regexMatch = new RegexMatch();
        boolean match1 = regexMatch.isMatch("aa", "a");
        boolean match2 = regexMatch.isMatch("aa", "a*");
        boolean match3 = regexMatch.isMatch("ab", ".*");
        boolean match4 = regexMatch.isMatch("aab", "c*a*b");
        boolean match5 = regexMatch.isMatch("mississippi", "mis*is*p*.");
        System.out.println(match1);
        System.out.println(match2);
        System.out.println(match3);
        System.out.println(match4);
        System.out.println(match5);
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (isMatched(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (isMatched(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean isMatched(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}

