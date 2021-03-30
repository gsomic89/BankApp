import java.text.DecimalFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private double principle;
    private double rate;
    private double years;

    public MortgageCalculator(double principle, double rate, double years) {
        this.principle = principle;
        this.rate = rate;
        this.years = years;
        validate();
    }

    public String calculate() {
        double topRow;
        double bottomRow;
        double interest = (rate / 100) / 12;
        double terms = years * 12;
        double interest_plus = 1 + interest;

        topRow = principle * (interest) * (Math.pow(interest_plus, terms));
        bottomRow = (Math.pow(interest_plus, terms)) - 1;
        double total = topRow / bottomRow;

        DecimalFormat df2 = new DecimalFormat("#.##");
        String formattedStr = df2.format(total);

        return formattedStr;
    }

    public void validate() {
        if (principle <= 0 || years < 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
    }
}
