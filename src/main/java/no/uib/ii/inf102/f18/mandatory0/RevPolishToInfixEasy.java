package no.uib.ii.inf102.f18.mandatory0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Sample solution
 *
 * @author Torstein Strømme
 */
public class RevPolishToInfixEasy {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(revpolishToInfix(in.readLine()));
    }

    /**
     * Function converts reverse polish notation to infix notation. Ex input:
     * "1 3 + 2 4 2 * + *" produce output "((1+3)*(2+(4*2)))
     *
     * @param inp input string with expression in reverse polish notation
     * @return a string containing the same expression in infix notation
     */
    public static String revpolishToInfix(String inp) {
        final String operators = "+-*/";
        MyDynamicArrayStack<String> mystack = new MyDynamicArrayStack<String>();


        for (String item : inp.split(" ")) {
            if (!operators.contains(item)) {
                // Item is a number
                mystack.push(item);
            }
            else {
                // Item is an operator
                String b = mystack.pop();
                String a = mystack.pop();
                String combinedItem = "(" + a + item + b + ")";
                mystack.push(combinedItem);
            }
        }
        return mystack.pop();
    }
}
