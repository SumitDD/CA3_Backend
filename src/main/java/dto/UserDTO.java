
package dto;

import entities.User;


public class UserDTO {
    
    private String uName;
    private String pHobby;

    public UserDTO(User user) {
        this.uName = user.getUserName();
        this.pHobby = user.getHobbies().get(0).getDescription();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getpHobby() {
        return pHobby;
    }

    public void setpHobby(String pHobby) {
        this.pHobby = pHobby;
    }

}
