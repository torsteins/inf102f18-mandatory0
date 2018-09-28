package no.uib.ii.inf102.f18.mandatory0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Sample solution
 *
 * @author Torstein Strømme
 */
public class RevPolishToInfixHard {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(revpolishToInfix(in.readLine()));
    }

    /**
     * Function converts reverse polish notation to infix notation. Ex input:
     * "1 3 + 2 4 2 * + *" produce output "((1+3)*(2+(4*2)))
     *
     * Code is identical to the easy version, except I'm using a custom "String" type
     * consisting of JoinableLinkedList<String>. Such an element is basically a list of
     * String fragments which, if read in order, represents a longer string.
     *
     * @param inp input string with expression in reverse polish notation
     * @return a string containing the same expression in infix notation
     */
    private static String revpolishToInfix(String inp) {
        final String operators = "+-*/";
        MyDynamicArrayStack<JoinableLinkedList<String>> mystack = new MyDynamicArrayStack<JoinableLinkedList<String>>();


        for (String item : inp.split(" ")) {
            JoinableLinkedList<String> op = new JoinableLinkedList<String>(item);
            if (!operators.contains(item)) {
                // Item is a number
                mystack.push(op);
            }
            else {
                // Item is an operator
                JoinableLinkedList<String> lb = new JoinableLinkedList<String>("(");
                JoinableLinkedList<String> rb = new JoinableLinkedList<String>(")");
                JoinableLinkedList<String> b = mystack.pop();
                JoinableLinkedList<String> a = mystack.pop();
                JoinableLinkedList<String> res = lb.adjoin(a).adjoin(op).adjoin(op).adjoin(b).adjoin(rb);
                mystack.push(res);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : mystack.pop()) {
            sb.append(s);
        }
        return sb.toString();
    }
}
