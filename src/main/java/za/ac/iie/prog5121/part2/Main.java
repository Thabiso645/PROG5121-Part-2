/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.prog5121.part1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("==============================");
            System.out.println("      CHAT APP - PART 1     ");
            System.out.println("   REGISTRATION AND LOGIN   ");
            System.out.println("==============================");
            
            // Get the users first name
            System.out.print("Enter your first name:");
            String firstName = scanner.nextLine();
            
            // Get the users last name
            System.out.print("Enter your last name:");
            String lastName = scanner.nextLine();
       
            //Registration
            System.out.println("\n========== REGISTRATION ==========");
            
        
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter Cellphone Number: ");
        String cell = scanner.nextLine();

        // Instantiate the Login class from your Part 1 files
        Login user = new Login(username, password, cell, firstName, lastName);
        
        String regStatus = user.registerUser();
        System.out.println("\n" + regStatus);

        // Enforce formatting rules check before allowing login
        if (!user.checkUserName() || !user.checkPasswordComplexity() || !user.checkCellPhoneNumber()) {
            System.out.println("Registration failed due to incorrect formatting. Terminating program.");
            return;
        }

        System.out.println("\n============= LOGIN =============");
        System.out.print("Enter Username: ");
        String loginUser = scanner.nextLine();
        System.out.print("Enter Password: ");
        String loginPass = scanner.nextLine();

        boolean isAuthed = user.loginUser(loginUser, loginPass);
        System.out.println(user.returnLoginStatus(isAuthed));

        if (!isAuthed) {
            return; // Exit if login fails
        }

        // =========================================================
        // PART 2: QUICKCHAT MESSAGING APPLICATION
        // =========================================================
        System.out.print("\nEnter the number of messages you wish to send: ");
        int totalLimit = scanner.nextInt();
        scanner.nextLine(); // clear input buffer stream

        int currentMessageCount = 0;
        boolean appRunning = true;

        // Loop runs dynamically until the user selects option 3 to quit
        while (appRunning) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            
            int menuSelection = scanner.nextInt();
            scanner.nextLine(); // clear input buffer stream

            switch (menuSelection) {
                case 1:
                    if (currentMessageCount >= totalLimit) {
                        System.out.println("Limit reached! You can only enter " + totalLimit + " messages.");
                        break;
                    }

                    System.out.print("\nEnter Recipient Number (e.g. +27718693002): ");
                    String recipient = scanner.nextLine();
                    
                    System.out.print("Enter Message Content: ");
                    String content = scanner.nextLine();

                    // Create the message object pass index counter numbers
                    Message msg = new Message(currentMessageCount, recipient, content);

                    // Perform length bounds checks
                    String lengthCheck = msg.checkMessageLength();
                    if (lengthCheck.contains("exceeds")) {
                        System.out.println("[Error] " + lengthCheck);
                        break;
                    }

                    // Display cellphone validation status message
                    System.out.println("[Status] " + msg.checkRecipientCell());

                    // Display numeric choice handling selection options
                    System.out.println("\nProcessing Status Options:");
                    System.out.println("1 - Send Message");
                    System.out.println("2 - Disregard Message");
                    System.out.println("3 - Store Message to send later");
                    System.out.print("Select action: ");
                    int processingChoice = scanner.nextInt();
                    scanner.nextLine(); // clear buffer queue

                    // Process selection and output tracking report
                    System.out.println("\n" + msg.SentMessage(processingChoice));
                    System.out.println(msg.printMessages());

                    currentMessageCount++;
                    break;

                case 2:
                    System.out.println("\nComing Soon.");
                    break;

                case 3:
                    System.out.println("\n=======================================================");
                    System.out.println("Total successful messages processed: " + Message.returnTotalMessagess());
                    System.out.println("Exiting QuickChat Application Framework. Goodbye!");
                    System.out.println("=======================================================");
                    appRunning = false;
                    break;

                default:
                    System.out.println("Invalid selection option code index. Please try again.");
            }
        }
        scanner.close();
    }
}
            
