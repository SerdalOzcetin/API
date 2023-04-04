package pojos;

public class Pojo_JhsonPlaceHolder {

    /*

                {
                "title": "Jhon",
                "body": "Doe",
                "userId": 10,
                "id": 70
                }
     */


    //  To create a POJO class, we need 5 steps:

    //  1- Create all variables as "private"

        private String title;
        private String body;
        private int userId;
        private int id;


    //  2- Create getter() and setter() methods for all variables

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getBody() {
                return body;
        }

        public void setBody(String body) {
                this.body = body;
        }

        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }


        //  3- Create a constructor that includes all parameters

        public Pojo_JhsonPlaceHolder(String title, String body, int userId, int id) {
                this.title = title;
                this.body = body;
                this.userId = userId;
                this.id = id;
        }


        //  4- Create a default constructor (without parameters)

        public Pojo_JhsonPlaceHolder() {
        }


        //  5- Create a toString() method.


        @Override
        public String toString() {
                return "Pojo_JhsonPlaceHolder{" +
                        "title='" + title + '\'' +
                        ", body='" + body + '\'' +
                        ", userId=" + userId +
                        ", id=" + id +
                        '}';
        }
}
