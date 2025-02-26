package Itemtest;

public class FacebookLoginTest {
    public static void main(String[] args) {
        // **Step 1:** Base class instance create pannrom.
        Base base = new Base();
        base.initializeDriver(); // Browser open pannrom.
        base.openUrl("http://www.facebook.com"); // Facebook website open pannrom.

        try {
            // **Step 2:** FacebookLoginValidation ku driver pass pannrom.
            FacebookLoginValidation facebookLoginValidation = new FacebookLoginValidation(base.driver);

            // **Step 3:** Validation logic call pannrom.
            facebookLoginValidation.validateFacebookLoginPage();
        } catch (Exception e) {
            e.printStackTrace(); // Errors console la print pannrom.
        } finally {
            base.tearDown(); // Browser close pannrom.
        }
    }
}
