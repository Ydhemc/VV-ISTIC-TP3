package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
    	Stack<Character> stack = new Stack<>();
        
        for (char c : str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false; // Ferme la chaîne sans symbole d'ouverture
                }
                char top = stack.pop(); //dernière ouverture
                if ((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '(')) {
                    return false; // mal appariées
                }
            }
        }
        
        return stack.isEmpty(); // (aucune ouverture restante)
    }

}
