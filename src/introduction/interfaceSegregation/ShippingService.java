package introduction.interfaceSegregation;

public class ShippingService {

    public void sendPackage(HasAddressInfo receiver) {
        if (!canCheckout(receiver.getAddress(), receiver.getZipCode())) {
            // Can't send!!
        }

        // Send the package.
    }

    private boolean canCheckout(String address, String zipCode) {
        return false;
    }
}
