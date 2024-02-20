package introduction.interfaceSegregation;

public class AuthorizationService {

    public boolean authorize(Authorizable authorizable) {
        return isAuthenticated(authorizable.getUsername(), authorizable.getPassword());
    }

    private boolean isAuthenticated(String email, String password) {
        return false;
    }
}
