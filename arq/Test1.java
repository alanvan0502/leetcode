package arq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static int solution1(int[] numbers, int difference) {
        int result = 0;

        List<Integer> uniqueNums = new ArrayList<>();
        for (int number : numbers) {
            if (!uniqueNums.contains(number)) {
                uniqueNums.add(number);
            }
        }


        for (int i = 0; i < uniqueNums.size(); i++) {
            for (int j = i + 1; j < uniqueNums.size(); j++) {
                int sum1 = uniqueNums.get(i) + difference;
                int sum2 = uniqueNums.get(j) + difference;
                if (sum1 == uniqueNums.get(j) || sum2 == uniqueNums.get(i)) {
                    result += 1;
                }
            }
        }

        return result;
    }

    public static int solution(String A, String B) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char c: alphabet) {
            mapA.put(c, 0);
            mapB.put(c, 0);
        }

        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();

        for (char a: charA) {
            int count = mapA.get(a);
            count += 1;
            mapA.put(a, count);
        }

        for (char b: charB) {
            int count = mapB.get(b);
            count += 1;
            mapB.put(b, count);
        }

        int result = 0;
        for (char c: alphabet) {
            result += Math.abs(mapA.get(c) - mapB.get(c));
        }

        return result;
    }

}
