package Person;

public class Address {

    private String street;
    private int number;
    private int postcode; 

    public Address(String street, int number, int postcode) {
        this.street = street;
        this.number = number;
        this.postcode = postcode;
    }

    public void printAddress() {
        System.out.print(this.street);
        System.out.println(this.number);
        System.out.println(this.postcode);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
