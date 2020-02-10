import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class main {

    public static void main(String[] args) {

        String dateTime = "1/1/2020";
        String startPayment = "01/10/2020";//hadaxtebis sawyisi tarigi
        String endPayment = "01/29/2021";//gadaxtebis saboloo tarigi
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy");
        Kredit kredit = null;
        try {
            DateTime jodatime = dtfOut.parseDateTime(dateTime);
            DateTime jodatime1 = dtfOut.parseDateTime(startPayment);
            DateTime jodatime2 = dtfOut.parseDateTime(endPayment);
                                    //gadaxtebis raodenoba
             kredit = new Kredit(2, jodatime, jodatime1, jodatime2);
        }catch (DateTimeParseException e){
            System.out.println(e.getLocalizedMessage());
        }
        if(monthCount(kredit) <= 0){
            System.out.println("Wrong dates!!!");
        }else if(kredit.getNumber_Of_Payment() > monthCount(kredit)) {
            System.out.println("Wrong number of payment!!!!");
        }else {
            for (Object date : paymentList(kredit)) {
                System.out.println(date);
            }
        }
    }
    public static int monthCount(Kredit kredit){
        int startMonth = kredit.getPayment_Start_Date().getMonthOfYear();
        int endMonth = kredit.getExpiration_Date().getMonthOfYear();
        int startYear = kredit.getPayment_Start_Date().getYear();
        int endYear = kredit.getExpiration_Date().getYear();
        int startDay = kredit.getPayment_Start_Date().getDayOfMonth();
        int endDay = kredit.getExpiration_Date().getDayOfMonth();
        int monthCount = 12*(endYear-startYear) + endMonth-startMonth ;
        if(endDay < startDay) monthCount--;
        if(endDay >= startDay) monthCount++;
        return monthCount;
    }

    public static DateTime[] paymentList (Kredit kredit){
        DateTime timesArray[] = new DateTime[kredit.getNumber_Of_Payment()];
        DateTime paymentStartDate = new DateTime(kredit.getPayment_Start_Date());
        int monthCount = monthCount(kredit);
        int paymentCalculation = monthCount/kredit.getNumber_Of_Payment();

        if(monthCount > 0){
            timesArray[0] = paymentStartDate;
            for(int i = 1; i < timesArray.length; i++){
                timesArray[i] = paymentStartDate.plusMonths(paymentCalculation*i);
            }
        }
        return timesArray;
    }

}