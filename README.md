
# Movie Review System

## Overview
The **Movie Review System** is a console-based application built using **Core Java**. This system allows users to register, log in, write reviews for movies, and view all existing reviews. It is designed to manage users and their reviews using Java's object-oriented principles and the `ArrayList` data structure.

## Features
- **User Registration**: Users can register by providing a username and password.
- **User Login**: Registered users can log in to access additional features.
- **Write Movie Reviews**: Users can write reviews for movies by providing the movie name, genre, director, rating (1-5 stars), a description, and whether the review contains spoilers.
- **View Reviews**: Users can view all movie reviews in a structured format, displaying key details and a rating represented by stars.

## Technologies Used
- **Core Java**: The project is implemented using core Java, emphasizing object-oriented programming principles.
- **ArrayList**: Used to manage the collection of users and reviews.

## How to Run the Project

### Prerequisites
- **JDK**: Ensure Java Development Kit (JDK) version 8 or higher is installed.
- **Java IDE**: Use any IDE (such as IntelliJ IDEA or Eclipse) or a text editor and the command line.
  
### Steps to Run
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/MovieReviewSystem.git
   cd MovieReviewSystem
   ```
   
2. **Compile the program**:
   ```bash
   javac MovieReviewSystem.java
   ```

3. **Run the program**:
   ```bash
   java MovieReviewSystem
   ```

4. **Interact with the system**: Follow the on-screen instructions to register, log in, write a review, or view reviews.

## Example Interaction
```
Welcome to the Movie Review System
1. Register
2. Login
3. Exit
Choose an option: 1
Enter username: JohnDoe
Enter password: pass123
Confirm password: pass123
Registration successful!

1. Write a Review
2. View Reviews
3. Logout
Choose an option: 1
Enter movie name: Inception
Enter genre: Sci-Fi
Enter director: Christopher Nolan
Enter rating (1 to 5): 5
Enter description: A mind-bending thriller.
Does the review contain spoilers? (yes/no): no
Review added successfully!

All Reviews:
+---------------------------+
| Movie Name: Inception      |
| Genre: Sci-Fi              |
| Director: Christopher Nolan|
| Rating: ***** (5)          |
| Spoiler: No                |
| Description: A mind-bending thriller. |
+---------------------------+
```

## Future Enhancements
- **Admin Panel**: Add admin functionalities for managing reviews (e.g., deleting inappropriate reviews).
- **Persistent Storage**: Implement file handling or database support to store user and review data permanently.
- **Improved UI**: Transition from a console-based system to a graphical user interface (GUI) for better user experience.

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue if you have suggestions or find bugs.
