package edu.design_patterns.proxy.virtual;

public class Main {

    public static void main(String[] args) {
        String bookName = "The Silent Patient";
        System.out.println("Initializing bookParser with LazyBookParserProxy");
        IBookParser bookParser = new LazyBookParserProxy(bookName);
        System.out.println("Calling methods on bookParser");
        System.out.println(bookParser.getNumberOfPages());
        System.out.println(bookParser.getPage(0));
    }
}
