import java.util.HashMap;
import java.util.Scanner;

public class FinancialForecastTool {

    // Memoization to store already computed results
    static HashMap<Integer, Double> memo = new HashMap<>();

    // Recursive function to calculate future value
    public static double forecastValue(int year, double initialValue, double growthRate) {
        if (year == 0) {
            return initialValue;
        }

        if (memo.containsKey(year)) {
            return memo.get(year);
        }

        // Recursive call for previous year
        double result = forecastValue(year - 1, initialValue, growthRate) * (1 + growthRate);
        memo.put(year, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input initial investment, growth rate, and number of years
        System.out.print("Enter initial investment amount (₹): ");
        double initialValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.10 for 10%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();

        System.out.println("\n--- Financial Forecast ---");
        for (int year = 0; year <= years; year++) {
            double value = forecastValue(year, initialValue, growthRate);
            System.out.printf("Year %d: ₹%.2f%n", year, value);
        }

        scanner.close();
    }
}
