class StringMethodsDemo {
    public static void main(String[] args) {

        String s = "Java Programming";

        // length()
        System.out.println(s.length());  // 16

        // toUpperCase()
        System.out.println(s.toUpperCase());  // JAVA PROGRAMMING

        // toLowerCase()
        System.out.println(s.toLowerCase());  // java programming

        // charAt()
        System.out.println(s.charAt(5));  // P

        // substring()
        System.out.println(s.substring(5));     // Programming
        System.out.println(s.substring(0, 4));  // Java

        // contains()
        System.out.println(s.contains("Java")); // true

        // equals()
        System.out.println(s.equals("Java Programming")); // true
    }
}