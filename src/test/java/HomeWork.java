import org.junit.jupiter.api.Test;

public class HomeWork {
    @Test

    public void firstHomeWork(){
        double startingLoan = 70000.00 ;

        double percentRate = 0.02 ;
        int years = 15;

        double percentRateForThePeriod = 1 + years * percentRate;
        double totalLoan = startingLoan * percentRateForThePeriod;

        System.out.println( "Percent rate fot the period is " + percentRateForThePeriod +"," +
                " but total loan will be " +
                totalLoan + "EUR");

    }

    public static void main (String [] args){
        String str = "Percent rate fot the period is 1.3, but total loan will be 91000.0EUR";

        System.out.println("Length of the string is " +str.length());

    }

}

