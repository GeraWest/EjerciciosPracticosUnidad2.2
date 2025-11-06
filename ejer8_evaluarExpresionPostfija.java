package pilas;

import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer8_evaluarExpresionPostfija {
    public static int evaluar(String expr) {
Stack<Integer> pila = new Stack<>();
for (String token : expr.trim().split("\\s+")) {
if (token.matches("\\d+")) {
pila.push(Integer.parseInt(token));
} else {
if (pila.size() < 2) throw new IllegalArgumentException("Expresión inválida");
int b = pila.pop();
int a = pila.pop();
switch (token) {
case "+": pila.push(a + b); break;
case "-": pila.push(a - b); break;
case "*": pila.push(a * b); break;
case "/": pila.push(a / b); break;
default: throw new UnsupportedOperationException("Operador no soportado: " + token);
}
}
}
if (pila.isEmpty()) throw new IllegalStateException("Expresión vacía");
return pila.pop();
}


public static void main(String[] args) {
System.out.println(evaluar("5 3 + 8 2 - *")); // 48
}
    
}

