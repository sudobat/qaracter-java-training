package introduction.interfaceSegregation;

public class UserImplementation
        implements Authorizable, CanReceiveEmails, HasAddressInfo {
    private String name;
    private String email;
    private String password;
    private String address;
    private String zipCode;
    private String addressDetails;

    private String favoriteTheme; // Can be dark or light

    public UserImplementation(
            String name,
            String email,
            String password,
            String address,
            String zipCode,
            String addressDetails
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.zipCode = zipCode;
        this.addressDetails = addressDetails;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddressDetails() {
        return addressDetails;
    }
}
