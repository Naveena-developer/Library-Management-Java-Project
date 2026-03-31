import java.util.*;
class Book {
    int id;
    String name;
    boolean isIssued;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.isIssued = false;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Book\n2.View Books\n3.Search Book\n4.Issue Book\n5.Return Book\n6.Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    //  Prevent duplicate ID
                    boolean exists = false;
                    for (Book b : books) {
                        if (b.id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Book ID already exists!");
                        break;
                    }

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();
                    books.add(new Book(id, name));
                    System.out.println("Book Added!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : books) {
                            System.out.println(b.id + " - " + b.name + " - " + (b.isIssued ? "Issued" : "Available"));
                        }
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Book Name to Search: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    //  Search by name
                    for (Book b : books) {
                        if (b.name.equalsIgnoreCase(searchName)) {
                            System.out.println("Found: " + b.id + " - " + b.name + " - " + (b.isIssued ? "Issued" : "Available"));
                            found = true;
                        }
                    }

                    // Not found message
                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();

                    boolean issueFound = false;

                    for (Book b : books) {
                        if (b.id == issueId) {
                            issueFound = true;
                            if (!b.isIssued) {
                                b.isIssued = true;
                                System.out.println("Book Issued!");
                            } else {
                                System.out.println("Book already issued!");
                            }
                        }
                    }

                    if (!issueFound) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();

                    boolean returnFound = false;

                    for (Book b : books) {
                        if (b.id == returnId) {
                            returnFound = true;
                            if (b.isIssued) {
                                b.isIssued = false;
                                System.out.println("Book Returned!");
                            } else {
                                System.out.println("Book was not issued!");
                            }
                        }
                    }

                    if (!returnFound) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}