/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.prog5121.part1;

import java.util.Random;

/**
 *
 * @author thabiso
 */
public final class Message {
    // Instance variables
    private final String messageId;
    private final int messageNumber;
    private final String recipientNumber;
    private final String messageContent;
    private String messageHash;
    private String deliveryStatus;

    // Static counter for total messages sent across the application
    private static int totalMessagesSent = 0;

    // Constructor
    public Message(int messageNumber, String recipientNumber, String messageContent) {
        this.messageNumber = messageNumber;
        this.recipientNumber = recipientNumber;
        this.messageContent = messageContent;
        this.messageId = generateRandomID();
        this.messageHash = createMessageHash();
    }

    // Helper to generate a random 10-digit ID
    private String generateRandomID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // 1. Boolean: checkMessageID()
    public boolean checkMessageID() {
        return this.messageId != null && this.messageId.length() <= 10;
    }

    // 2. String: checkRecipientCell()
    public String checkRecipientCell() {
        // Validation rules based on assignment rubrics and test data
        if (recipientNumber.startsWith("+") && recipientNumber.length() >= 10) {
            return "Cell phone number successfully captured.";
        } else if (!recipientNumber.startsWith("+") && recipientNumber.length() == 10) {
            // fallback handling for local 10 digit numbers if required
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Validation helper for the message length test requirement
    public String checkMessageLength() {
        if (messageContent.length() <= 250) {
            return "Message ready to send.";
        } else {
            int exceededBy = messageContent.length() - 250;
            return "Message exceeds 250 characters by " + exceededBy + ", please reduce the size.";
        }
    }

    // 3. String: createMessageHash()
    public String createMessageHash() {
        if (messageId == null || messageId.length() < 2 || messageContent == null || messageContent.trim().isEmpty()) {
            return "00:0:UNKNOWN";
        }
        
        // Get first two characters of message ID
        String idPrefix = messageId.substring(0, 2);
        
        // Split content into words to find first and last
        String[] words = messageContent.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z0-String]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z0-String]", "");
        
        // Construct the hash in ALL CAPS format
        this.messageHash = (idPrefix + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
        return this.messageHash;
    }

    // 4. String: SentMessage()
    public String SentMessage(int choice) {
        switch (choice) {
            case 1 -> {
                totalMessagesSent++;
                this.deliveryStatus = "Sent";
                return "Message successfully sent.";
            }
            case 2 -> {
                this.deliveryStatus = "Disregarded";
                return "Press 0 to delete the message.";
            }
            case 3 -> {
                this.deliveryStatus = "Stored";
                return "Message successfully stored.";
            }
            default -> {
                return "Invalid selection.";
            }
        }
    }

    // 5. String: printMessages()
    public String printMessages() {
        return """
               -------------------------------------------
               Message ID generated: <""" + messageId + ">\n" +
               "Message Hash: " + messageHash + "\n" +
               "Recipient: " + recipientNumber + "\n" +
               "Message: " + messageContent + "\n" +
               "Status: " + deliveryStatus + "\n" +
               "-------------------------------------------";
    }

    // 6. Int: returnTotalMessagess()
    public static int returnTotalMessagess() {
        return totalMessagesSent;
    }

    // 7. Research Requirement for Part 3 placeholder stub
    public void storeMessage() {
        // Will be fully implemented using JSON libraries in Part 3
        System.out.println("JSON storage initialized for Message ID: " + messageId);
    }

    // Getters for Part 3/Testing compliance
    public String getMessageId() { return messageId; }
    public String getMessageHash() { return messageHash; }
    public String getRecipientNumber() { return recipientNumber; }
    public String getMessageContent() { return messageContent; }
}
