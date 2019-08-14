package arq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArraysAndStrings {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * Example:
     * <p>
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int firstVal = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (firstVal == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * If the target is not found in the array, return [-1, -1].
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
            result[0] = -1;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                result[1] = j;
                break;
            }
            result[1] = -1;
        }
        return result;
    }

    public static int[] searchRangeSolution(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIndx = extremeInsertionIndex(nums, target, true);
        if (leftIndx == nums.length || nums[leftIndx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIndx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return lo;
    }

    /**
     * Given an array of strings, group anagrams together.
     * <p>
     * Example:
     * <p>
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * Note:
     * <p>
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<String> scanned = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (scanned.size() == strs.length) {
                break;
            }
            if (!scanned.contains(strs[i])) {
                List<String> subResult = new ArrayList<>();
                String s = strs[i];
                subResult.add(s);
                scanned.add(s);
                for (int j = i + 1; j < strs.length; j++) {
                    String s1 = strs[j];
                    if (isAnagram(s, s1)) {
                        subResult.add(s1);
                        scanned.add(s1);
                    }
                }
                result.add(subResult);
            }
        }
        return result;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        boolean result = true;

        HashMap<Character, Integer> map1 = new HashMap<>();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (Character c: c1) {
            Integer i = map1.get(c);
            if (i == null) {
                map1.put(c, 1);
            } else {
                map1.put(c, i + 1);
            }
        }

        for (Character c: c2) {
            Integer i = map1.get(c);
            if (i == null || i.equals(0)) {
                result = false;
                break;
            } else {
                map1.put(c, i - 1);
            }
        }

        return result;
    }

    public static boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        s1 = Arrays.toString(chars1);
        s2 = Arrays.toString(chars2);

        return s1.equals(s2);
    }

    /**
     * Input:
     * words = ["This", "is", "an", "example", "of", "text", "justification."]
     * maxWidth = 16
     * Output:
     * [
     *    "This    is    an",
     *    "example  of text",
     *    "justification.  "
     * ]
     */

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> rawResult = new ArrayList<>();
        List<String> result = new ArrayList<>();

        int widthUsed = 0;

        List<String> subResult = new ArrayList<>();
        for (String word: words) {
            if (widthUsed + word.length() > maxWidth) {
                rawResult.add(subResult);
                widthUsed = 0;
                subResult = new ArrayList<>();
            }
            if (widthUsed + word.length() <= maxWidth) {
                subResult.add(word);
                widthUsed += word.length() + 1;
            }
        }
        rawResult.add(subResult);


        for (int i = 0; i < rawResult.size() - 1; i++) {
            List<String> line = rawResult.get(i);
            if (line.size() > 1) {
                StringBuilder lineStr = new StringBuilder();
                HashMap<Integer, Integer> spacingMap = new HashMap<>();

                int charNums = 0;
                for (String s : line) {
                    charNums += s.length();
                }
                int spacing = (maxWidth - charNums)/(line.size() - 1);

                int remainingWidth = maxWidth - line.get(line.size() - 1).length();
                for (int j = 0; j < line.size() - 1; j++) {
                    spacingMap.put(j, spacing);
                    remainingWidth -= line.get(j).length() + spacing;
                }
                while (remainingWidth > 0) {
                    for (int j = 0; j < line.size() - 1; j++) {
                        spacingMap.put(j, spacingMap.get(j) + 1);
                        remainingWidth -= 1;
                        if (remainingWidth <= 0) {
                            break;
                        }
                    }
                }
                for (Integer k: spacingMap.keySet()) {
                    lineStr.append(addPadding(line.get(k), spacingMap.get(k)));
                }
                lineStr.append(line.get(line.size() - 1));
                result.add(lineStr.toString());
            } else {
                result.add(addPadding(line.get(0), maxWidth - line.get(0).length()));
            }
        }

        StringBuilder lastLineStr = new StringBuilder();
        List<String> lastLine = rawResult.get(rawResult.size() - 1);
        if (lastLine.size() > 1) {
            for (int i = 0; i < lastLine.size() - 1; i++) {
                lastLineStr.append(addPadding(lastLine.get(i), 1));
            }
            lastLineStr.append(addPadding(lastLine.get(lastLine.size() - 1),
                    maxWidth - lastLineStr.length() - lastLine.get(lastLine.size() - 1).length()));
        } else {
            lastLineStr.append(addPadding(lastLine.get(0), maxWidth - lastLine.get(0).length()));
        }


        result.add(lastLineStr.toString());


        return result;
    }

    private static String addPadding(String str, int padding) {
        StringBuilder strBuilder = new StringBuilder(str);
        while (padding > 0) {
            strBuilder.append(" ");
            padding--;
        }
        return strBuilder.toString();
    }
}
