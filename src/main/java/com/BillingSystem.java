package com.billing;

import java.util.Scanner;

public class BillingSystem {

    public static double calculateBill(String planType, double dataConsumed) {
        double baseRate = 0;
        double dataLimit = 0;
        double extraRatePerGb = 0;

        switch (planType.toLowerCase()) {
            case "basic":
                baseRate = 30.0;
                dataLimit = 50.0;
                extraRatePerGb = 1.00;
                break;
            case "standard":
                baseRate = 50.0;
                dataLimit = 100.0;
                extraRatePerGb = 0.75;
                break;
            case "premium":
                baseRate = 80.0;
                dataLimit = 200.0;
                extraRatePerGb = 0.50;
                break;
            default:
                System.out.println("Unknown Plan Type. Applying Basic rates by default.");
                baseRate = 30.0;
                dataLimit = 50.0;
                extraRatePerGb = 1.00;
                break;
        }

        double finalBill = baseRate;
        if (dataConsumed > dataLimit) {
            double extraUsage = dataConsumed - dataLimit;
            finalBill += extraUsage * extraRatePerGb;
        }
        return finalBill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("=== Internet Data Usage Billing System ===");

        do {
            System.out.print("\nEnter Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Plan Type (Basic / Standard / Premium): ");
            String plan = scanner.nextLine().trim();

            System.out.print("Enter Total Data Consumed (in GB): ");
            double data = 0;
            if (scanner.hasNextDouble()) {
                data = scanner.nextDouble();
            }
            scanner.nextLine(); // Clear scanner buffer

            double totalBill = calculateBill(plan, data);

            System.out.println("\n--- Invoice Summary ---");
            System.out.println("Customer Name: " + name);
            System.out.println("Plan Chosen: " + plan.toUpperCase());
            System.out.println("Data Consumed: " + data + " GB");
            System.out.printf("Total Monthly Bill: $%.2f\n", totalBill);
            System.out.println("------------------------");

            System.out.print("\nDo you want to process another customer? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();

        } while (choice.equals("yes") || choice.equals("y"));

        System.out.println("\nThank you for using the Billing System!");
        scanner.close();
    }
}
