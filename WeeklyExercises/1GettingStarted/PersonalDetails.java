public class PersonalDetails {
    int age = 19;
    String name = "Brad";
    String address = "Arena village, Leeds";
    long phoneNo = 123456789L;
    public static void main(String[] args) {
        PersonalDetails obj = new PersonalDetails();
        obj.displayPersonalDetails();
    }

    public void displayPersonalDetails() {
        String nameDisplayString = String.format("%-10s - %s","name",name);
        String ageDisplayString = String.format("%-10s - %d","age",age);
        String addressDisplayString = String.format("%-10s - %s","address",address);
        String phoneNoDisplayString = String.format("%-10s - %d","phoneNo",phoneNo);

        System.out.println(nameDisplayString);
        System.out.println(ageDisplayString);
        System.out.println(addressDisplayString);
        System.out.println(phoneNoDisplayString);
    }
}
