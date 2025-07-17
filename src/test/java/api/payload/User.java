package api.payload;

public class User {

        int age;
        int playerId = 0;
        String editor;
        String gender;
        String login;
        String password;
        String role;
        String screenName;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=16 && age<=60){
            System.out.println("invalid");
        }
    }

    public String getEditor() {
        return editor;
    }
    public void setEditor(String supervisor) {
        this.editor = supervisor;
    }

    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int id) {
        this.playerId = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;

    }
}
