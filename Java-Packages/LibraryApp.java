import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class LibraryApp {
    public static void main(String[] args) {
        Book b = new Book();
        Member m = new Member();
        Transaction t = new Transaction();

        b.addBook();
        m.register();
        t.issueBook();
    }
}