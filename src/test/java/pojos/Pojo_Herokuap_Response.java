package pojos;

public class Pojo_Herokuap_Response {

    private int bookingdid;
    private Pojo_Herokuapp_requestBody booking;

    public int getBookingdid() {
        return bookingdid;
    }

    public void setBookingdid(int bookingdid) {
        this.bookingdid = bookingdid;
    }

    public Pojo_Herokuapp_requestBody getBooking() {
        return booking;
    }

    public void setBooking(Pojo_Herokuapp_requestBody booking) {
        this.booking = booking;
    }


    public Pojo_Herokuap_Response(int bookingdid, Pojo_Herokuapp_requestBody booking) {
        this.bookingdid = bookingdid;
        this.booking = booking;
    }

    public Pojo_Herokuap_Response() {
    }

    @Override
    public String toString() {
        return "Pojo_Herokuap_Response{" +
                "bookingdid=" + bookingdid +
                ", booking=" + booking +
                '}';
    }
}
