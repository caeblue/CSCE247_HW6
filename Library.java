import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Library 
{
    /**
     * Creation of a hashmap to store books and a library variable
     */
    private HashMap<String, Integer> books= new HashMap<>();
    private static Library library;

    /**
     * empty method, not used
     */
    private Library()
    {
        //empty method
    }

    /**
     * Creating a new library to call to if there isn't one previously
     * @return a newly made library variable
     */
    public static Library getInstance()
    {
        if (library == null)
        {
            System.out.println("Creating our library. Time to begin reading");
            library = new Library();
        }
        return library;

    }

    /**
     * A method to check if this book is in the library, then to check if there is a copy to check out
     * if there is a copy, it will check out and subtract that number of book.
     * Otherwise, it'll output a no copies message
     * @param bookName a value to describe what type of book is being checked out
     * @return a true or false variable on if this book was checked out
     */
    public boolean checkoutBook(String bookName)
    {
        if(books.containsKey(bookName))
        {
            if(books.containsValue(1))
            {
                int previousCopies = books.get(bookName);
                books.put(bookName, previousCopies - 1);
                System.out.println(bookName + " was successfully checked out");
                return true;
            }
            else 
            {
                System.out.println("Sorry " + bookName + " is not in stock");
                return false;
            }
        }
        else
        {
            System.out.println("Sorry " + bookName + " is not in stock");
            return false;
        }
    }

    /**
     * If/else statement checking if the book is currently within the library
     * and if it is, taking it out of the hashmap after checkout
     * @param bookName the name of the book that the user is looking for
     * @param numToAdd number of copies that the user is checking in
     */
    public void checkInBook(String bookName, int numToAdd)
    {
        
        if(books.containsKey(bookName))
        {
            int previousCopies = books.get(bookName);
            books.put(bookName, previousCopies + numToAdd);
            System.out.println("A new copy of " + bookName + " was successfully added to the library");
        }
        else
        {
            System.out.println(bookName + " was successfully added to the library");
            books.put(bookName, numToAdd);
        }
    }

    /**
     * A iterator to run through all of the entries in the hashmap
     * bookinfo is used to pull variables out of the hashmap
     */
    public void displayBooks()
    {
        System.out.println("");
        System.out.println("Inventory:");
        Iterator iterator = books.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry bookInfo =(Map.Entry) iterator.next();
            System.out.println("  - " + bookInfo.getKey() + ", Copies: " + bookInfo.getValue());
        }
    }

}
