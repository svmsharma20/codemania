package edu.design_patterns.bridge;

public class BookResource implements Resource {

    private Book book;

    public BookResource(Book book) {
        this.book = book;
    }

    @Override
    public String getDescription() {
        return book.getDescription();
    }

    @Override
    public String getTitle() {
        return book.getName();
    }

    @Override
    public String getImageUrl() {
        return book.getImageUrl();
    }

    @Override
    public double getRatings() {
        return book.getRatings();
    }
}
