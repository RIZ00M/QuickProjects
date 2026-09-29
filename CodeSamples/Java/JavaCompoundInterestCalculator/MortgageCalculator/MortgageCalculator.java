public class MortgageCalculator {
    private double investment;
    private double interest;
    private int years;

    public MortgageCalculator(double investment, double interest, int years) {
        this.investment = investment;
        this.interest = interest;
        this.years = years;
    }

    public double calculateTotal() {
        double total = investment;
        for (int i = 0; i < years; i++) {
            total = total * (1 + interest);
        }
        return total;
    }
}
