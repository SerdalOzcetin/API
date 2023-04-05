package pojos;

public class Pojo_Herokuapp_requestBody {

/*
    {
        "firstname": "Jhon",
            "lastname": "Doe",
            "totalprice": 500,
            "depositpaid": false,
            "bookingdates": {
        "checkin": "2021-06-01",
                "checkout": "2021-06-10"
         },
        "additionalneeds": "wi-fi"
    }

 */


    //  1- Create all variables as "private"

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private Pojo_Herokuapp_BookingDates bookingdates;
    private String additionalneeds;



    //  2- Create getter() and setter() methods for all variables

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Pojo_Herokuapp_BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Pojo_Herokuapp_BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }


    //  3- Create a constructor that includes all parameters

    public Pojo_Herokuapp_requestBody(String firstname, String lastname, int totalprice, boolean depositpaid, Pojo_Herokuapp_BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }


    //  4- Create a default constructor (without parameters)

    public Pojo_Herokuapp_requestBody() {
    }


    //  5- Create a toString() method.


    @Override
    public String toString() {
        return "Pojo_Herokuapp_requestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
