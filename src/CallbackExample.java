import java.util.function.Consumer;
import java.util.function.Supplier;

public class CallbackExample {

    protected static void getSalary(Consumer<Double> callback) {
        double salary = 67_0000.00;
        System.out.println("Get Gross Salary");
        callback.accept(salary);
    }

    protected static void deductTax(double grossSalary, Consumer<Double> callback) {
        System.out.println("Deducting Tax");
        double rateInt = 0.00;
        double deductSal = 0.00;
        if (grossSalary < 1000000 && grossSalary > 500000)
            rateInt = 20.00;
        deductSal = grossSalary - grossSalary * rateInt / 100;
        callback.accept(deductSal);
    }


    public static void main(String[] args) {
        getSalary((sal) -> {
            System.out.println("Gross Salary " + sal);
            deductTax(sal, (afterSal) -> {
                System.out.println("Deducted Salary " + afterSal);
            });
        });
    }


}
