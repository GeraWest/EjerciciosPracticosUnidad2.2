package pilas;

import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer5_BalanceoDeParentesis {
    public static boolean estaBalanceada(String expr) {
Stack<Character> pila = new Stack<>();
for (char c : expr.toCharArray()) {
if (c == '(') pila.push(c);
else if (c == ')') {
if (pila.isEmpty()) return false;
pila.pop();
}
}
return pila.isEmpty();
}


public static void main(String[] args) {
System.out.println(estaBalanceada("((2+3)*5)")); // true
System.out.println(estaBalanceada("((2+3)*5")); // false
}
}

