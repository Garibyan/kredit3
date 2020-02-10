
import org.joda.time.DateTime;


public class Kredit {
    private int number_Of_Payment;
    private DateTime start_Date;
    private DateTime payment_Start_Date;
    private DateTime expiration_Date;


    public int getNumber_Of_Payment() {
        return number_Of_Payment;
    }

    public void setNumber_Of_Payment(int number_Of_Payment) {
        this.number_Of_Payment = number_Of_Payment;
    }

    public DateTime getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(DateTime start_Date) {
        this.start_Date = start_Date;
    }

    public DateTime getExpiration_Date() {
        return expiration_Date;
    }

    public void setExpiration_Date(DateTime expiration_Date) {
        this.expiration_Date = expiration_Date;
    }

    public DateTime getPayment_Start_Date() {
        return payment_Start_Date;
    }

    public void setPayment_Start_Date(DateTime payment_Start_Date) {
        this.payment_Start_Date = payment_Start_Date;
    }



    public Kredit(int number_Of_Payment, DateTime start_Date, DateTime payment_Start_Date, DateTime expiration_Date) {
        this.number_Of_Payment = number_Of_Payment;
        this.start_Date = start_Date;
        this.payment_Start_Date = payment_Start_Date;
        this.expiration_Date = expiration_Date;
    }

    @Override
    public String
    toString() {
        return "Kredit{" +
                ", number_Of_Payment=" + number_Of_Payment +
                ", start_Date=" + start_Date +
                ", expiration_Date=" + expiration_Date +
                ", payment_Start_Date=" + payment_Start_Date +
                '}';
    }
}
