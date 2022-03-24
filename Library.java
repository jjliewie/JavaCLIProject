package firstproject;
import java.util.*;

public class Library {

    // initializing my utilities, sorting, and shortcuts class

    Utilities util = new Utilities();
    Sorting sorting = new Sorting();
    Shortcuts sc = new Shortcuts();

    // initializing scanner

    Scanner scanner = new Scanner(System.in);

    // for input 

    // recursively asks for input until it fits requirements

    int input(int lower, int upper, String ask){

        // lowerbound, upperbound, question

        System.out.print(ask + ": ");

        String temp = scanner.next();

        if(util.isInt(temp)){
            int i = Integer.parseInt(temp);

            if(i>=lower && i <=upper){
                return i;
            }
        }

        System.out.println("You've entered an invalid value. Please Try again.");

        // recursive until input is "correct" 

        return input(lower, upper, ask);

    }

    // the only function that I call in the main class
    
    void start(){

        backgroundInfo();

        util.print_rectangle(9, 20);
        System.out.println();

        // using spacedLines method from shortcuts class

        sc.spacedLines("Welcome to the Library Sourcing program!"); // title
        sc.spacedLines("This program is created by Julie Rhee.");

        // asks for name

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.println("Thank you for using our program " + name + "!");
        int choice = choices();

        // calls action method to call corresponding methods, including back and quit methods

        action(choice);

    }

    // for printing out all the background information

    void backgroundInfo(){

        // using spacedLines method from shortcuts class

        sc.spacedLines("You are at the International School Manila High School Library.");
        sc.spacedLines("You decide that the vast library and collection of books that school library offer is simply not enough");
        sc.spacedLines("You log into the hidden webpage only accessible by the select few from a military computer inside the egg chair.");

    }

    // menu board

    int choices(){

        System.out.println();

        // using spacedLines method from shortcuts class

        sc.spacedLines("Here are some thing you can do!");
        
        String [] posactions = {"Search for a book", "Search for a library", "Find nearest Library", "Get all Library Information", "See Book List"};
        
        // printing possible actions
        
        for(int i = 0; i < posactions.length; i++){
            System.out.print((i+1) + "     ");
            System.out.println(posactions[i]);
        }
        System.out.println();

        // user input

        int choice = input(1, posactions.length, "Please enter a number corresponding to your choice");

        System.out.println();
        return choice;
    }

    void action(int choice){

        // using switch

        switch(choice){

            // calls corresponding method, quit method, and back method, 
            // so that user can choose whether they want to quit the program or go back to menu afterwards
            // finally, break is called

            case 1:
                searchBook();
                quit();
                back();
                break;
            case 2:
                searchLibrary();
                quit();
                back();
                break;
            case 3:
                nearestLibrary();
                quit();
                back();
                break;
            case 4: 
                libraryInfo();
                quit();
                back();
                break;
            case 5: 
                bookList();
                quit();
                back();
                break;
            default:

            // if input is invalid, but this should actually never be called due to recursive error catcher in input mathod

                System.out.println("Invalid Input");
                quit();
                back();
                break;
        }
    }

    // using a hastable,, I could have used a binary searach algorithm each time instead but the time complexity for using a hashtable is 
    // O(1) while binary search is O(logN)

    Map<Integer, String> data() {

        Map<Integer, String> myMap = new HashMap<Integer, String>();
        String [] libnames = libraryNames();
        int[][] locations = libraryloc();
        for(int i = 0; i < libnames.length; i++){

            // distance from ISM library through distance formula

            int dist = (int) Math.hypot(locations[i][0], locations[i][1]);
            myMap.put(dist, libnames[i]);
        }
        return myMap;
    }

    // locations of each library (as for distance, we are always assuming the user is located at location (0, 0))
    // arranged by array index

    int[][] libraryloc(){

        // 2d array

        int[][] locations = {
            {2, 4}, 
            {1, 3}, 
            {20, 1}, 
            {7, 7}, 
            {3, 4}, 
            {6, 9}, 
            {16, 20}, 
            {5, 16}, 
            {9, 9}, 
            {9, 10}
        };

        return locations;
    }

    // books each library offers
    // arranged by array index

    String[][] librarybooks(){

        // 2d string array for books

        String[][] books = {

            {"To kill a Mockingbird", "Hunger Games", "Insurrecto", "Great Expectations", "Harry Potter Series", "Crimes and Punishment", "Moby Dick", "Wuthering Heights", "Fahrenheit 451", "Jane Eyre"}, 
            {"Hunger Games", "Illustrado", "Great Expectations", "The Vegetarian", "Jane Eyre", "Harry Potter Series", "Anne of Green Gables", "Moby Dick", "Pride and Prejudice", "Little Women"}, 
            {"To kill a Mockingbird", "Hunger Games", "1984", "Great Expectations", "Macbeth", "Percy Jackson Series", "The Color Purple", "Scarlet Letter", "Rebecca", "Crimes and Punishment"}, 
            {"Wuthering heights", "Siddhartha", "Insurrecto", "Moby Dick", "Harry Potter Series", "The Color Purple", "Scarlet Letter", "Rebecca", "Great Expectations", "Anne of Green Gables"}, 
            {"Animal Farm", "The Color Purple", "Beloved", "Great Expectations", "Pride and Prejudice", "Treasure Island", "Scarlet Letter", "Rebecca", "The Vegetarian", "Little Women"}, 
            {"Treasure Island", "Hunger Games", "Insurrecto", "Fahrenheit 451", "Harry Potter Series", "Crimes and Punishment", "Beloved", "Macbeth", "Percy Jackson Series", "1984"}, 
            {"Anne of Green Gables", "Hunger Games", "Illustrado", "Great Expectations", "Charlotte's Web", "Moby Dick", "Wuthering Heights", "Little Women", "Percy Jackson Series", "1984"}, 
            {"To kill a Mockingbird", "Treasure Island", "Hunger Games", "Moby Dick", "Illustrado", "Insurrecto", "Great Expectations", "Harry Potter Series", "Crimes and Punishment", "Charlotte's Web"}, 
            {"To kill a Mockingbird", "Beloved", "The Color Purple", "Anne of Green Gables", "Hunger Games", "Insurrecto", "Wuthering Heights","Fahrenheit 451", "Illustrado", "Siddhartha"}, 
            {"Animal Farm", "Hunger Games", "Illustrado", "Insurrecto", "Great Expectations", "Harry Potter Series", "Anne of Green Gables", "The Vegetarian", "Pride and Prejudice", "Little Women"}
        
        };

        return books;
    }

    // an array list of different books,, not an array because I don't know how many different books there are in total

    ArrayList<String> differentBooks(String[][] books){

        ArrayList<String> diffBooks = new ArrayList<String>();

        for(int i = 0; i < books.length; i++){
            for(String x : books[i]){
                if(!diffBooks.contains(x)){
                    diffBooks.add(x);
                }
            }
        }
        return diffBooks;
    }

    // names of all libraries
    // arranged by array index

    String[] libraryNames(){

        // string array

        String [] names = {
            "Spring's Library", 
            "Art Library", 
            "Central Library", 
            "Fairfax Library", 
            "Free Library", 
            "Liberation Library", 
            "Imagination Library", 
            "Foxfire Library", 
            "Lily Library", 
            "Angel Library"
        };

        return names;
    }

    // for searching book

    void searchBook(){

        String[][] bookslib = librarybooks();
        ArrayList<String> catalog = differentBooks(bookslib);

        System.out.print("Would you like to take a look at the book list? Enter 1 for yes and 0 for no: ");
        int see = scanner.nextInt();

        if(see == 1){System.out.println(); bookList();}

        System.out.println();

        // getting bookchoice input (refer to input method)

        int bookchoice = input(1, catalog.size(), "Please enter a number corresponding to your book");

        String book = catalog.get(bookchoice-1);
        ArrayList<Integer> libraries = new ArrayList<Integer>();

        String[] names = libraryNames();
        int[][] coors = libraryloc();

        for(int i = 0; i < bookslib.length; i++){
            for(String x : bookslib[i]){
                if(x.equals(book)) libraries.add(i);
            }
        }

        System.out.println();

        // using spacedLines method from shortcuts class

        sc.spacedLines("You can find the book in the following libraries");

        int[] sorted_distances = new int[coors.length];
        for(int i = 0; i < sorted_distances.length; i++){

            // distance from ISM library through distance formula

            int d = (int) Math.hypot(coors[i][0], coors[i][1]);
            sorted_distances[i] = d;
        }

        // merge sort -> but really I could use any sort,, refer to sorting class
        sorting.mergesort(sorted_distances, 0, sorted_distances.length-1);

        for(int x: libraries){
            System.out.println("Library name: " + names[x]);

            // distance from ISM library through distance formula
            
            int dist = (int) Math.hypot(coors[x][0], coors[x][1]);

            // using binary search 
            
            System.out.println("The library is located approximately " + dist + "km away from you and is the " + (util.binsearch(sorted_distances, dist)+1) + " ist/nd/rd/th closest library from you.");
            System.out.println();
        }

    }

    // for searching library

    void searchLibrary(){

        String [] libraries = libraryNames();

        // for printing all the library names

        for(int i = 0; i < libraries.length; i++){
            System.out.print((i+1) + "    ");
            System.out.println(libraries[i]);
        }
        System.out.println();

        int libchoice = input(1, libraries.length, "Please enter a number corresponding to your choice");
       
        String library = libraries[libchoice-1];
        System.out.println();
        System.out.println("Name: " + library);

        // calls library loc function

        int [][] locations = libraryloc();

        // distance from ISM library through distance formula

        int dist = (int) Math.hypot(locations[libchoice-1][0], locations[libchoice-1][1]);
        System.out.println("Distance away from you: " + dist + "km.");
        System.out.print("Books you can borrow from this library: ");
        String [][] books = librarybooks();

        for(int i = 0; i< books[libchoice-1].length; i++){
            System.out.print(books[libchoice-1][i]);
            if(i < books[libchoice-1].length-1){
                System.out.print(", ");
            }
        } 
        System.out.println();
    }

    // for finding all libraries from nearest to furthest

    void nearestLibrary(){

        int [][] coors = libraryloc();
        int[] distances = new int[coors.length];
        for(int i = 0; i < distances.length; i++){

            // distance from ISM library through distance formula

            int dist = (int) Math.hypot(coors[i][0], coors[i][1]);
            distances[i] = dist;
        }

        // merge sort
        sorting.mergesort(distances, 0, distances.length-1);
        // bubble sort
        sorting.bubbleswapsort(distances);
        // selection sort
        sorting.selectionsort(distances);

        // redundant sorting but I wanted to show that they all work. Two of three can be commented out.

        Map<Integer, String> hashtable = data();
        System.out.println();

        // using spacedLines method from shortcuts class

        sc.spacedLines("Library from Nearest to Furthest");

        for(int i = 0; i < distances.length; i++){
            System.out.print((i+1) + "   ");

            // map / hash table / dictionary (pythonic)

            System.out.println("Library name: " + hashtable.get(distances[i]));
            System.out.println(distances[i] + "km away from you");
            System.out.println();
        }
    }

    // for printing information of all libraries

    void libraryInfo(){

        System.out.println();
        String [] names = libraryNames();
        String [][] books = librarybooks();
        int[][] locations = libraryloc();
        for(int i = 0; i < names.length; i++){
            System.out.print((i+1) + "   ");

            // using spacedLines method from shortcuts class

            sc.spacedLines(names[i]);

            // printing book names

            System.out.print("Books you can read in this library: ");
            for(int j = 0; j < books[i].length; j++){
                System.out.print(books[i][j]);
                if(j != books[i].length-1){
                    System.out.print(", ");
                }
            }

            System.out.println();

            // distance from ISM library through distance formula

            int dist = (int) Math.hypot(locations[i][0], locations[i][1]);
            System.out.println("The library is located approximately " + dist + "km away from you.");
            System.out.println();
        }

        // nearest furthest

        Map<Integer, String> data = data();
        int [] distances = new int[locations.length];
        
        for(int i = 0; i < distances.length; i++){

            // distance from ISM library through distance formula

            int dist = (int) Math.hypot(locations[i][0], locations[i][1]);
            distances[i] = dist;
        }

        // getting minimum and maximum distances,, refer to shortcuts class to see how the method works

        int min_dist = sc.getMin(distances);
        int max_dist = sc.getMax(distances);

        System.out.println("The Library located nearest from you is " + data.get(min_dist) + ", which is " + min_dist + "km away from you.");
        System.out.println("The Library located furthest from you is " + data.get(max_dist) + ", which is " + max_dist + "km away from you.");
    }

    // for printing out book list containing all the book to number pairs (unique)

    void bookList(){

        // for printing out booklist and its corresponding number

        String[][] bookslib = librarybooks();
        ArrayList<String> catalog = differentBooks(bookslib);

        for(int i = 0; i < catalog.size(); i++){
            System.out.print((i+1) + "    ");
            System.out.println(catalog.get(i));
        }
    }

    // for quitting program

    void quit(){

        System.out.println();
        System.out.print("Would you like to quit the program? Please enter 1 for yes and 0 for no: ");
        int quit = scanner.nextInt();

        if(quit == 1){
            System.out.println();
            System.out.println("Thank you for using this program!");
            System.exit(0);
        }
        System.out.println();
    }

    // for going back to menu

    void back(){

        System.out.println();
        System.out.print("Would you like to go back to menu? Please enter 1 for yes and 0 for no: ");
        int back = scanner.nextInt();
        if(back == 1){
            int choice = choices();
            action(choice);
        }
        System.out.println();
    }
    
}