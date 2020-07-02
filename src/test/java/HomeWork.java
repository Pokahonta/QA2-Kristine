
import org.junit.jupiter.api.Test;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


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

    @Test

    public static void main (String []args ){
        String text = "Percent rate for period is 1.3, but total loan will be 91000.0 EUR";
        System.out.println("Length of text: " + text.length());

        System.out.println("Lenght of text without spaces: " + text.replace( " ", "").length());

        String[] words = text.split(" ");
        System.out.println(words.length);

    }

    @Test

    public void distanceBetweenToDots(){
        double x1 = 6;
        double y1 = 4;

        double x2 = 24;
        double y2 = 14;

        double AC = x2-x1;
        double BC = y2-y1;
        double AB = sqrt(pow(AC,2) + pow(BC,2));

        System.out.println("Distance between points A and B is " + AB + ".");

    }


}

