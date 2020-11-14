package dto;


public class PersonDTO {
    
    private String name;
    private String address;
    private String phone_h;

    public PersonDTO(String name, String address, String phone_h) {
        this.name = name;
        this.address = address;
        this.phone_h = phone_h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_h() {
        return phone_h;
    }

    public void setPhone_h(String phone_h) {
        this.phone_h = phone_h;
    }
    
    


    
    
}
