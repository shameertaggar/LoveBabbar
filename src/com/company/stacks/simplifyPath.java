package com.company.stacks;

import java.util.Stack;

public class simplifyPath {
    public static void main(String[] args) {
        String q = "/a//b////c/d//././/..";

        Stack<Character> st = new Stack<>();
        for(int i = 0; i< q.length() ; i++){
            if(i == q.length()-1 && q.charAt(i) == '/'){
                break;
            }else if(!st.isEmpty() && st.peek() == '/' && q.charAt(i) == '/'){
                continue;
            }else if(!st.isEmpty()&& st.peek() =='.' && q.charAt(i) == '.' && i+1<q.length() && q.charAt(i+1) !='.'){
                int n = 2;
                char s = 0;
                while(!st.isEmpty()&& n>0){
                    if(!st.isEmpty()&& st.peek() == '/'){
                        n--;
                    }
                    s = st.pop();
                    System.out.println(s);
                }
                st.push(s);
            }else if(!st.isEmpty()&& st.peek() =='.' && q.charAt(i) == '.' && i+1<q.length() && q.charAt(i+1) =='.'){
                st.push(q.charAt(i));
                st.push(q.charAt(i+1));
                i++;
            }else if(!st.isEmpty()&& st.peek() =='/' && q.charAt(i) == '.' && i<q.length() && q.charAt(i+1) !='.'){
                System.out.println(st.peek());
                st.pop();
            }
            else{
                st.push(q.charAt(i));
            }
        }

        while (!Character.isAlphabetic(st.peek())){
            st.pop();
        }


// Assume the stack 'st' is already populated with characters

        String ans = "";

        while (!st.isEmpty()){
            ans = st.pop() + ans;  // Prepend the popped character to ans
        }

        System.out.println("Final answer is: " + ans);

    }
}
