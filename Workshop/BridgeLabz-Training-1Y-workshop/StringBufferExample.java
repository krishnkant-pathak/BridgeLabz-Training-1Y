class StringBufferExample {
public static void main(String[] args) {

// Creates a StringBuffer object with initial value "Hello" StringBuffer sb = new StringBuffer("Hello");

// append() adds text at the end of the existing string sb.append(" World");
System.out.println("append: " + sb);

// insert() adds text at a specified index sb.insert(5, ",");
System.out.println("insert: " + sb);

// replace() replaces characters from start index to end index sb.replace(6, 11, "Java");
System.out.println("replace: " + sb);

// delete() removes characters between start and end index sb.delete(5, 6);
System.out.println("delete: " + sb);

// reverse() reverses the entire string sb.reverse();
System.out.println("reverse: " + sb);

// length() returns the number of characters in the string System.out.println("length: " + sb.length());

// charAt() returns the character at a given index System.out.println("charAt(2): " + sb.charAt(2));

// setCharAt() changes the character at a specific index sb.setCharAt(2, 'X');
System.out.println("setCharAt: " + sb);

// substring() returns a part of the string System.out.println("substring: " + sb.substring(1, 4));
}
}