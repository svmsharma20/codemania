package edu.design_patterns.proxy.virtual;

public class LazyBookParserProxy implements IBookParser {

    private BookParser bookParser;
    private String bookName;

    public LazyBookParserProxy(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int getNumberOfPages() {
        initBookParser();
        return bookParser.getNumberOfPages();
    }

    @Override
    public String getPage(int pageNumber) {
        initBookParser();
        return bookParser.getPage(pageNumber);
    }

    private void initBookParser() {
        if (bookParser == null) {
            bookParser = new BookParser(bookName);
        }
    }
}
