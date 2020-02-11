import java.util.Scanner;
/*
    This task can also be solved:
        1) Using stack: If ( found - push, if ) found- pop.
                        If in some part of the process we have an empty stack and need to pop => the input is incorrect.
                        At the end if the stack is empty => the input is correct, otherwise it is NOT correct.
        2) The idea of the stack but with just one variable: Increment its value if ( found and decrement if ) found.
                                                             If in the process the value is <0 => the input is incorrect.
                                                             At the end if the value is 0 the input is correct. otherwise
                                                             the input is NOT correct
    I decided to show how it is solved with recursion.
 */

public class Main {

    public static int findIndexOfClosingParenthesis(String string, int startPosition, int length)   //function to find )
    {
        int parenthesisFoundAtIndex = 0;        //0 for not found, index if found
        for (int i = startPosition; i < length; i++) {
            if (string.charAt(i) == ')') {
                parenthesisFoundAtIndex = i;   //index if ) is found
                break;
            } else if (string.charAt(i) == '(') {
                i = findIndexOfClosingParenthesis(string, ++i, length);  //recursion
                if (i == 0) {
                    parenthesisFoundAtIndex = 0;  // ) is not found
                    break;
                }
            }
        }
        return parenthesisFoundAtIndex;
    }

    public static boolean checkForBalancedParenthesis(String input) {
        if (input.isEmpty()) {
            return false;
        }
        boolean isInputCorrect = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                isInputCorrect = false;
                break;
            }
            if (input.charAt(i) == '(') {
                i = findIndexOfClosingParenthesis(input, ++i, input.length());   //find index of )
                if (i == 0) {
                    isInputCorrect = false;  //no ) found
                    break;
                }
            }
        }
        return isInputCorrect;
    }

    public static void main(String[] args) {
        System.out.println("Input: ");
        String input = new String();
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        boolean result = checkForBalancedParenthesis(input);
        System.out.println(result);
    }
}
