package model;

import java.util.regex.Pattern;

public class Customer {
    // valid genders for the validator
    private static final String[] VALID_GENDERS = {"Male", "Female", "Other"};

    // ID tracker, whenever a customer is assigned, this value goes up by 1 so that the next customer can have value+1 as their ID
    private static int IDTracker = 1;

    private int customerID;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String houseAddress;
    private String phoneNum;
    private boolean isAdmin;

    // getters and setters (only getter for ID, as you don't want tampering on the ID)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getHouseAddress() {
        return houseAddress;
    }
    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public int getCustomerID() {
        return customerID;
    }
    public boolean isAdmin(){
        return isAdmin;
    }
    public void setAdmin (boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    // Constructor used for Customer registration, will increment the ID tracker
    public Customer(String username, String firstName, String lastName, String email, String password,
            String gender, String houseAddress, String phoneNum) {
        // Assign tracker to the ID, then add 1 to the tracker
        this.customerID = IDTracker;
        IDTracker++;

        // normal data input
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.houseAddress = houseAddress;
        this.phoneNum = phoneNum;
        this.isAdmin = false;
    }

    // Constructor used for database extraction, include the ID in the parameter & will not increment the ID tracker
    public Customer(int customerID, String username, String firstName, String lastName, String email, String password,
            String gender, String houseAddress, String phoneNum, boolean isAdmin) {
        this.customerID = customerID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.houseAddress = houseAddress;
        this.phoneNum = phoneNum;
        this.isAdmin = isAdmin;
    }

    // Validators that checks for the following rules
    //     All fields are not null or a bunch of whitespaces
    //     Names should consists of letters and whitespace in between
    //     Email should folow the email standard format (gonna be a mouthful to explain the regex)
    //     Phone numbers should be all digits, and between 8-15 characters    

    public static boolean isNotEmpty(String inputString) {
        return inputString != null && !inputString.trim().isEmpty();
    }

    public static boolean validateUsername(String username) {
        return isNotEmpty(username) && username.matches("[a-zA-Z0-9]{0,20}");
    }

    public static boolean validateFirstName(String firstName) {
        return isNotEmpty(firstName) && firstName.matches("[a-zA-Z ]+");
    }

    public static boolean validateLastName(String lastName) {
        return isNotEmpty(lastName) && lastName.matches("[a-zA-Z ]+");
    }

    public static boolean validateEmail(String email) {
        return isNotEmpty(email) && Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", email);
    }

    // Password should be longer than 8 characters
    public static boolean validatePassword(String password) {
        return isNotEmpty(password) && password.length() >= 8;
    }

    // Genders validation (Male/Female/Others) (ignoring cases)
    public static boolean validateGender(String gender) {
        if (isNotEmpty(gender))
            for (String validGender : VALID_GENDERS) {
                if (validGender.equalsIgnoreCase(gender)) {
                    return true;
                }
            }
        return false;
    }

    public static boolean validateHouseAddress(String houseAddress) {
        return isNotEmpty(houseAddress);
    }

    public static boolean validatePhoneNum(String phoneNum) {
        return isNotEmpty(phoneNum) && phoneNum.matches("^[0-9]{8,15}$");
    }

    // toString in case we're gonna need any documentation or logging
    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", username=" + username + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", gender=" + gender
                + ", houseAddress=" + houseAddress + ", phoneNum=" + phoneNum + "]";
    }


}
