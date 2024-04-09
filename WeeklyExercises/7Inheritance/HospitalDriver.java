public class HospitalDriver {
    public static void main(String[] args) {
        Doctor doc1 = new Doctor();
        Nurse nurse1 = new Nurse();
        Receptionist rec1 = new Receptionist();

        Doctor doc2 = new Doctor("0002", "Dr. House", "Hepatology", "Doctor", "To diagnose and perscribe medicines to patients", "Liver");
        Nurse nurse2 = new Nurse("1002", "Vladamir harkonnen", "Critical care wing", "Nurse", "To care for patients in their wing", "Bobby (has tummy ache)");
        Receptionist rec2 = new Receptionist("2002", "Zach", "Reception", "Receptionist", "To answer calls from the public", "07123 456789");

        System.out.println(doc1);
        System.out.println(nurse1);
        System.out.println(rec1);
        System.out.println(doc2);
        System.out.println(nurse2);
        System.out.println(rec2);
    }
}
