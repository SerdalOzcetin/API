package pojos;

public class Pojo_Herokuapp_BookingDates {
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




      //  To create a POJO class, we need 5 steps:

            //  1- Create all variables as "private"


              private String checkin;
              private String checkout;


            //  2- Create getter() and setter() methods for all variables

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    //  3- Create a constructor that includes all parameters

    public Pojo_Herokuapp_BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }


    //  4- Create a default constructor (without parameters)

    public Pojo_Herokuapp_BookingDates() {
    }


    //  5- Create a toString() method.


    @Override
    public String toString() {
        return "Pojo_Herokuapp_BookingDates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
