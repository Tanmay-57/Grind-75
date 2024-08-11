class Solution {
    private static final String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        
        combinations(digits, 0, new StringBuilder(), res);
        return res;
    }
    
    private void combinations(String digits, int pos, StringBuilder sb, List<String> res) {
        if (pos == digits.length()) {
            res.add(new String(sb));
            return;
        }
        
        String letters = mapping[digits.charAt(pos) - '2'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            combinations(digits, pos + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
