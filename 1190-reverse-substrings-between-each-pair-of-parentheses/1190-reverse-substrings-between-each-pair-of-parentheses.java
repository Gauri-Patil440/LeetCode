class Solution {
    public String reverseParentheses(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == ')') {

                int start = result.lastIndexOf("(");

                String part = result.substring(start + 1);

                result.delete(start, result.length());

                result.append(new StringBuilder(part).reverse());

            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}