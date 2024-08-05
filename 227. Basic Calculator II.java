class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char operator= '+';

        for(int i=0; i<s.length(); i++){
            char charVal = s.charAt(i);
            // handles digits and 2-digit+ numbers
            if(Character.isDigit(charVal)){
                num = (num*10) + (charVal -'0');
            }
            // handels operators
            if( (!Character.isDigit(charVal) && charVal != ' ') || i == s.length()-1){
                if(operator=='+'){
                    st.push(num);
                }else if(operator== '-'){
                    st.push(-1 * num);
                }else if(operator == '*'){
                    st.push(num * st.pop());
                }else if(operator == '/'){
                    st.push(st.pop()/ num);
                }

                num=0;
                operator = charVal;
            }
        }

        int sum=0;
        while(!st.isEmpty()){
            sum =sum +st.pop();
        }

        return sum;
    }
}
