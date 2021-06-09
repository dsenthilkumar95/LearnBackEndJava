package com.improve.programming;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ParanthesisBalanceTest {
    private ParanthesisBalance solution;

    @Before
    public void setUp() throws Exception {
        solution = new ParanthesisBalance();
    }

    @Test
    public void testlongestValidParentheses() {
        assertEquals(2, solution.longestValidParentheses("(()"));
        assertEquals(4, solution.longestValidParentheses(")()())"));
        assertEquals(6, solution.longestValidParentheses("((()))"));
        assertEquals(0, solution.longestValidParentheses(")))((("));
        assertEquals(2, solution.longestValidParentheses("((()"));
        assertEquals(2, solution.longestValidParentheses("()))"));
        assertEquals(0, solution.longestValidParentheses("(((("));
        assertEquals(0, solution.longestValidParentheses("))))"));
        assertEquals(8, solution.longestValidParentheses("()()()()"));
    }

    @Test
    public void testlongestValidParentheses_MaxLengthPositiveCase() {
        int charLimit = 30000;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<charLimit/2; i++){
            sb.append('(');
        }
        for(int i=0; i<charLimit/2; i++){
            sb.append(')');
        }
        assertEquals(charLimit, solution.longestValidParentheses(sb.toString()));
    }

    @Test
    public void testlongestValidParentheses_MaxLengthNegativeCase() {
        int charLimit = 30000;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<charLimit/2; i++){
            sb.append(')');
        }
        for(int i=0; i<charLimit/2; i++){
            sb.append('(');
        }
        assertEquals(0, solution.longestValidParentheses(sb.toString()));
    }

    @Test
    public void testlongestValidParentheses_MaxLengthHalfPositiveCase() {
        int charLimit = 30000;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<charLimit/4; i++){
            sb.append(')');
        }
        for(int i=0; i<charLimit/2; i++){
            sb.append('(');
        }
        for(int i=0; i<charLimit/4; i++){
            sb.append(')');
        }
        assertEquals(charLimit/2, solution.longestValidParentheses(sb.toString()));
    }

}
