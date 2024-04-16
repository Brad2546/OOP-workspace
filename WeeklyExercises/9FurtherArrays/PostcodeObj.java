public class PostcodeObj {
    String firstnames, surname, postcode;

    public PostcodeObj(String firstnames, String surname, String postcode) {
        this.firstnames = firstnames;
        this.surname = surname;
        this.postcode = postcode;
    }

    public String getFirstnames() {
        return firstnames;
    }

    public String getSurname() {
        return surname;
    }

    public String getPostcode() {
        return postcode;
    }

    @Override
    public String toString() {
        return "PostcodeObj{" +
                "firstnames='" + firstnames + '\'' +
                ", surname='" + surname + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
