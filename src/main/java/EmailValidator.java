public class EmailValidator {
    public static boolean isValidEmail(String email) {
        if (email == null || email.length() == 0) {
            return false;
        }

        boolean hasAtSymbol = false;
        boolean hasDot = false;
        boolean hasSpace = false;

        for (char c : email.toCharArray()) {
            if (c == '@') {
                if (hasAtSymbol || hasDot || hasSpace) {
                    return false;
                }
                hasAtSymbol = true;
            } else if (c == '.') {
                if (hasDot || hasSpace) {
                    return false;
                }
                hasDot = true;
            } else if (c == ' ') {
                if (hasSpace) {
                    return false;
                }
                hasSpace = true;
            }
        }

        return hasAtSymbol && hasDot && !hasSpace;
    }

}