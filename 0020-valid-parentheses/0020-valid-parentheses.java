class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Opening brackets ko stack mein add karo
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Closing brackets
            else {

                // Agar opening bracket hi nahi hai
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Matching bracket check karo
                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        // Stack empty hona chahiye
        return stack.isEmpty();
    }
}