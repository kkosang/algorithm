import java.util.HashMap;
import java.util.Scanner;

/* [#0] 모든 아나그램 찾기
https://cote.inflearn.com/contest/10/problem/04-04
* */
public class No4_04 {
    public static int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char key : t.toCharArray()) { // 타겟 map
            tMap.put(key, tMap.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < t.length() - 1; i++) { // 슬라이딩 윈도우 map
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            sMap.put(s.charAt(rt), sMap.getOrDefault(s.charAt(rt), 0) + 1);
            if (sMap.equals(tMap)) answer++; // 두개의 map이 같으면 증가
            sMap.put(s.charAt(lt), sMap.get(s.charAt(lt)) - 1);
            if (sMap.get(s.charAt(lt)) == 0) sMap.remove(s.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        System.out.println(solution(S, T));
    }
}

