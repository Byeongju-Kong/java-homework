package hw.hello.tmp;

import javax.validation.constraints.NotEmpty;

public class Customer {

    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String address;

    public Customer(Long id, String username, String password, String name, String phoneNumber, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
