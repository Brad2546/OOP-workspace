public class PasswordDriver {

    public static void main(String[] args) {
        Password p = new Password("hello world");
        Secret s = new Secret("Hello World");
        System.out.println("Password encryption - ");
        System.out.println("plainTxt = " + p);
        p.encrypt();
        System.out.println("cipherTxt = " + p);
        System.out.println("unEncrypted = " + p.decrypt());
        System.out.println("");
        System.out.println("Secret encryption - ");
        System.out.println("plainTxt = " + s);
        s.encrypt();
        System.out.println("cipherTxt = " + s);
        System.out.println("unEncrypted = " + s.decrypt());
    }
}
