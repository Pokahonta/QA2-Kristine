import java.sql.SQLOutput;

public class StringLenght {
    public static void main (String [] args) {
        String str = "Percent rate for the period is 1.3, but total loan will be 91000.0EUR";
        System.out.println("Length of text: " +str.length());


        System.out.println("Lenght of text without spaces: " +str.replace(" ", "").length());
    }
}

