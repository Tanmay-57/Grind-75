class Solution {
    public int minAddToMakeValid(String s) {
        //Stack<Character> stack = new Stack<>();
        int c=0;
        int min=0;

        for(char ch: s.toCharArray()){
            if(ch=='('){
                c++;
            }else{
                if(c<=0){
                    min++;
                }else{
                    c--;
                }
            }
        }

        return min+c;
    }
}
