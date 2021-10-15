package edu.design_patterns.proxy.virtual;

public class BookParser implements IBookParser {

    private String bookName;

    public BookParser(String bookName) {
        this.bookName = bookName;
        System.out.println("Expensive parsing of book: " + bookName);
    }

    @Override
    public int getNumberOfPages() {
        return bookName.length();
    }

    @Override
    public String getPage(int pageNumber) {
        if (pageNumber < 0 && pageNumber >= bookName.length()) {
            return null;
        }
        return bookName.charAt(pageNumber) + "";
    }
}
