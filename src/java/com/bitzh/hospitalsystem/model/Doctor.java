package java.com.bitzh.hospitalsystem.model;

//  包含医生的信息，如姓名、专长和可用时间
public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private String available_time;
    private String username;
    private String password;

    // 无参数构造函数
    public Doctor() {
    }

    public Doctor(int id, String name, String specialty, String available_time, String username, String password) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.available_time = available_time;
        this.username = username;
        this.password = password;
    }
    // getter 和 setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAvailable_time() {
        return available_time;
    }

    public void setAvailable_time(String available_time) {
        this.available_time = available_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
