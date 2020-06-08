import java.util.Arrays;

public class SlidingWindowProblem2 {

    /*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    Example:

    Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC"
    Note:

        If there is no such window in S that covers all characters in T, return the empty string "".
        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
     */

    public static String minWindow(String s, String t) {

        int sLen = s.length(), tLen = t.length();

        if (tLen > sLen) return "";

        if (s.equals(t)) return t;

        int[] Tcount = new int[256];
        int[] Scount = new int[256];
        for (int i = 0; i < t.length(); i++) {

            ++Tcount[t.charAt(i)];
        }

        int windowStart = 0;

        int min = Integer.MAX_VALUE, tCount = 0;
        int start = -1, end = -1;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            char ch = s.charAt(windowEnd);

            ++Scount[ch];

            if (Scount[ch] <= Tcount[ch] && Scount[ch] > 0) {

                ++tCount;
            }

            if (tCount == tLen) {
                --tCount;

                while ((windowEnd-windowStart+1) >= tLen) {

                    char stCh = s.charAt(windowStart);

                    if (min > (windowEnd-windowStart+1)) {

                        min = windowEnd-windowStart+1;
                        start = windowStart;
                        end = windowEnd;
                    }

                    ++windowStart;

                    if (Tcount[stCh] > 0 &&
                            (--Scount[stCh] == 0 || Scount[stCh] < Tcount[stCh])) {

                        break;
                    }
                }
            }
        }

        return start == -1 ? "" : s.substring(start, end+1);
    }

    public static void main(String args[]){
        String test = "ADOBECODEBANC";
        String search = "ABC";
        String ans = minWindow(test, search);
        System.out.println(ans);

        /*int[] count = new int[256];
        for (int i = 0; i < test.length(); i++)
        {
            count[test.charAt(i)]++;
        }
        System.out.println(Arrays.toString(count).toCharArray());*/
    }
}
