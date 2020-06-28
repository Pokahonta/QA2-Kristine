import org.junit.jupiter.api.Test;

public class JavaPractice {
    @Test
    public void firstJavaCode() {
        double distance = 135.7;
        double fuelAmount = 20.00;

        double ticketMonthlyPrice = 50.00;
        int ridesCount = 80;

        int zojasRidesCount = 2;


        double consumption = fuelAmount / distance * 100;

        double pricePerRide = calculatedPricePerRide(ridesCount);
        double pricePerRideForZoja = calculatedPricePerRide(zojasRidesCount);

        System.out.println("current fuel consumption is " + consumption + " EUR" +
                " but using Trolley it costs " + pricePerRide + " EUR" +  "per Month " +
                "and now Zoja spend " + pricePerRideForZoja + " EUR" + " per ride");

        int a = 15;
        int b = 10;

        String c = "15";
        String d = "10";

        System.out.println(a+b);
        System.out.println(c+d);


    }

    private double calculatedPricePerRide(int ridesCount) {
       final double PRICE = 50.00;
       double pricePerRide = PRICE / ridesCount;
       return pricePerRide;
    }
}
