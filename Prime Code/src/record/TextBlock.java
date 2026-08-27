package record;


import static java.lang.StringTemplate.STR;

public class TextBlock{
    public static void main(String[] args) {

        final String textBlock1 = """
            Hello Java 17""";
        final String textBlock2 = """
                Hello Java 17""";
        String myString = new String("""
    {
        "name": "John Doe",
        "role": "Developer"
    }
    """);
        String myString1  = new String("""
    {
        "name": "John Doe",
        "role": "Developer"
    }
    """);



        System.out.println("Using equals(): " + textBlock1.equals(textBlock2));

        System.out.println("Using intern(): " + (textBlock1.intern() == textBlock2.intern()));

        System.out.println(myString.equalsIgnoreCase(myString1));
        String title = "Java 21 Updates";
        String author = "John Doe";

        String json = STR."""
{
    "title": "\{title}",
    "author": "\{author}"
}
""";
        System.out.println(json);
        String name = "Alice";
        int age = 30;

// Java 21 String Template
        String message = STR."My name is \{name} and I am \{age} years old.";
        System.out.println(message);

        System.out.println(   Runtime.getRuntime().availableProcessors());
        System.out.println(   Runtime.getRuntime().maxMemory());
        System.out.println(   Runtime.getRuntime().freeMemory());


    }
}
