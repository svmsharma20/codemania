package edu.design_patterns.bridge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
     * https://www.youtube.com/watch?v=F1YQ7YRjttI&list=PLrhzvIcii6GNjpARdnO4ueTUAVR9eMBpc&index=11
     * */
    public static void main(String[] args) {
        ArtistResource artistResource = getArtistResource();
        BookResource bookResource = getBookResource();

        View longFormArtistView = new LongFormView(artistResource);
        View longFormBookView = new LongFormView(bookResource);
        View shortFormArtistView = new ShortFormView(artistResource);
        View shortFormBookView = new ShortFormView(bookResource);

        System.out.println("----------------------------");
        System.out.println("Long Form Artist View");
        System.out.println(longFormArtistView.getView());
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Long Form Book View");
        System.out.println(longFormBookView.getView());
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Short Form Artist View");
        System.out.println(shortFormArtistView.getView());
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Short Form Book View");
        System.out.println(shortFormBookView.getView());
        System.out.println("----------------------------");
    }

    public static ArtistResource getArtistResource() {
        Artist artist = new Artist();
        artist.setFirstName("Shreya");
        artist.setLastName("Ghoshal");
        artist.setBio("Shreya Ghoshal is an Indian playback singer.");
        artist.setRatings(5.0);
        artist.setImageUrl("https://www.shreyaghoshal.com/");

        List<String> songs = new ArrayList<>();
        songs.add("Teri Meri");
        songs.add("Teri Ore");
        artist.setAlbums(songs);

        return new ArtistResource(artist);
    }

    public static BookResource getBookResource() {
        Book book = new Book();
        book.setName("Atomic Habits");
        book.setDescription("A supremely practical and useful book.");
        book.setGenere("Self-development");
        book.setRatings(4.6);
        book.setImageUrl("https://jamesclear.com/atomic-habits");
        return new BookResource(book);
    }
}
