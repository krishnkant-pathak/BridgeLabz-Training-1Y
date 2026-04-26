class Unique {
    public int firstUniqChar(String s) {

        for (int i = 0; i < s.length(); i++) {
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                return i;   // first unique character found
            }
        }

        return -1; // no unique character
    }
}