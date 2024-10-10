import java.util.ArrayList;
import java.util.Scanner;

class User {
    protected static int userCount = 0; 
    protected int userId; 
    protected String username; 
    protected String password; 

    public User(String username, String password) {
        this.userId = ++userCount; 
        this.username = username;
        this.password = password;
    }
}

// Admin class extending User
class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
}

class Review {
    private static int reviewCount = 0; 
    private int reviewId; 
    private int userId; 
    private String movieName; 
    private String genre; 
    private String director; 
    private int rating; 
    private String description; 
    private boolean hasSpoiler; 

    public Review(int userId, String movieName, String genre, String director, int rating, String description, boolean hasSpoiler) {
        this.reviewId = ++reviewCount;
        this.userId = userId;
        this.movieName = movieName;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.description = description;
        this.hasSpoiler = hasSpoiler;
    }

    // Method to generate stars based on rating
    private String getStars() {
        StringBuilder stars = new StringBuilder(); 
        for (int i = 0; i < rating; i++) {
            stars.append("*");
        }
        return stars.toString(); 
    }

    @Override
    public String toString() {
        return "+---------------------------+\n" +
               "| Movie Name: " + movieName + "\n" +
               "| Genre: " + genre + "\n" +
               "| Director: " + director + "\n" +
               "| Rating: " + getStars() + " (" + rating + ")\n" +
               "| Spoiler: " + (hasSpoiler ? "Yes" : "No") + "\n" +
               "| Description: " + description + "\n" +
               "+---------------------------+";
    }
}

public class MovieReviewSystem {
    private static ArrayList<User> users = new ArrayList<>(); 
    private static ArrayList<Review> reviews = new ArrayList<>(); 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Welcome to the Movie Review System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit"); 
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 3);
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        if (password.equals(confirmPassword)) {
            users.add(new User(username, password));
            System.out.println("Registration successful!");
        } else {
            System.out.println("Passwords do not match. Registration failed.");
        }       
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = authenticateUser(username, password);
        if (user != null) {
            System.out.println("Login successful!");
            userMenu(scanner, user);
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
    }

    private static User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static void userMenu(Scanner scanner, User user) {
        int option;

        do {
            System.out.println("1. Write a Review");
            System.out.println("2. View Reviews");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    addReview(scanner, user.userId);
                    break;
                case 2:
                    viewReviews();
                    break;
                case 3:
                    System.out.println("Logged out successfully!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 3);
    }

    private static void addReview(Scanner scanner, int userId) {
        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter rating (1 to 5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Does the review contain spoilers? (yes/no): ");
        boolean hasSpoiler = scanner.nextLine().equalsIgnoreCase("yes");

        reviews.add(new Review(userId, movieName, genre, director, rating, description, hasSpoiler));
        System.out.println("Review added successfully!");
    }

    private static void viewReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews available.");
        } else {
            System.out.println("All Reviews:");
            for (int i = reviews.size() - 1; i >= 0; i--) { 
                System.out.println(reviews.get(i));
            }
        }
    }
}
