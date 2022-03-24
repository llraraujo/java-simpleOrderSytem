package entities;

import java.util.Date;

public class Client {
    private String name;
    private String email;
    private Date brithDate;

    public Client(){

    }

    public Client(String name, String email, Date date){
        this.name = name;
        this.email = email;
        this.brithDate = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }
}
