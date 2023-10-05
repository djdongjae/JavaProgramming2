package ch12.prob09;

// chap12 구현문제 323p 문자열 압축
public class Solution {
    public static int solution(String s) {
        int answer = s.length();
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = s.substring(0, step);
            int cnt = 1;
            for (int j = step; j < s.length(); j += step) {
                String sub = "";
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }
                if (prev.equals(sub)) cnt++;
                else {
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    prev = sub;
                    cnt = 1;
                }
            }
            compressed += (cnt >= 2) ? cnt + prev : prev;
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}
