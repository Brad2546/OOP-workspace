public class Test
// When changed to "test" - "java: class test is public, should be declared in a file named test.java" error occurs
{
    //----------------------------------------------------
    //  Prints a statement.
    //----------------------------------------------------
    public static void main (String[] args)
    // File cannot be run if "main" is changed to "man"
    {
        System.out.println("An emergency Broadcast");
        // No error occurs when changing the string to be printed

        // When first " is removed - "java: ')' or ',' expected" Error occurs

        // When "printLn" is changed to "bogus" - "java: cannot find symbol
        //                                              symbol:   method bogus(java.lang.String)
        //                                              location: variable out of type java.io.PrintStream" - Error occurs

        // When print statement is missing ; - "java: ';' expected" Error occurs

    }
}
// when last bracket is removed - "java: reached end of file while parsing" Error occurs
