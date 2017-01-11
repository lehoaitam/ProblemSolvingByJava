import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class BalanceBracket
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int hasBalancedBrackets(String str)
    {
        //assumed if inputed string is empty, the result should be 0
        if(str.length() == 0) return 0;
        Stack<Character> stack = new Stack<Character>();
        int hasBalanced = 0;
        char[] arrChrs = str.toCharArray();
        for(char ch : arrChrs){
            //if detect opening bracket character, push it into stack
            if(ch == '(' || ch == '{' || ch == '[' || ch == '<')
                stack.push(ch);
                //if detect closing bracket chracter, check if there is a pair or not
            else if(ch == ')' || ch == '}' || ch == ']' || ch == '>'){
                if(stack.isEmpty()) return 0;
                char chOpen = stack.peek();
                if( (chOpen == '(' && ch != ')') ||
                        (chOpen == '{' && ch != '}') ||
                        (chOpen == '[' && ch != ']') ||
                        (chOpen == '<' && ch != '>') )
                    return 0;
                stack.pop();
            }
        }
        //finally, if stack is empty, it isbalanced
        if(stack.isEmpty())
            hasBalanced = 1;
        return hasBalanced;
    }
    // METHOD SIGNATURE ENDS
    public static void main(String[] args){

        palindrome("aabaa");

    }

    static int palindrome(String s) {
        //use manacher for detect palindrome
        if(s == null ) return 0;
        if(s.length() < 2)
            return 1;
        int result = 0;
        //1.append # to each character of s
        char[] charArray = s.toCharArray();
        char[] t = new char[charArray.length * 2 + 1];
        int i;
        for(i = 0; i < charArray.length; i++){
            t[i*2] = '#';
            t[i*2 + 1] = charArray[i];
        }
        t[i*2] = '#';
        //2. find longest pandromic string and then count the number of palindrome
        int n = t.length;
        int c = 1;
        int r = 1;
        int[]p = new int[n];
        p[0] = 0;
        p[1] = 1;
        int maxLength = 0;
        int maxPos = 0;
        int j;
        for(i = 2; i < n; i++){
            //find pandrome position
            j = 2*c - i;
            if(j > 0 && i < r){
                p[i] = Math.min(r-i, p[j]);
            }else{
                p[i] = 0;
            }

            //expand pandromic around i
            while((i-1-p[i] >= 0) && (i+1+p[i] < n) && t[i-1-p[i]] == t[i+1+p[i]])
                p[i]++;

            if(i + p[i] > r){
                c = i;
                r = i + p[i];
            }
        }
        HashSet<String> set = new HashSet<>();
        for(i = 1; i < n; i++){
            if(p[i] > 0){
                for(int k = 0; k <= p[i]; k++){
                    String strTemp = String.valueOf(t,p[i]-k,1+2*k);
                    strTemp = strTemp.replaceAll("#","");
                    if(!set.contains(strTemp)){
                        set.add(strTemp);
                        result++;
                    }
                }
            }
        }
        return result - 1;

    }

}