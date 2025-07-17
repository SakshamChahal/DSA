import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] phoneMap = {
            "",     
            "",     
            "abc",  
            "def",  
            "ghi",  
            "jkl",  
            "mno",  
            "pqrs", 
            "tuv",  
            "wxyz"  
        };

        backtrack(result, digits, phoneMap, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, String[] phoneMap, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(result, digits, phoneMap, index + 1, current);
            current.deleteCharAt(current.length() - 1); 
        }
    }
}
