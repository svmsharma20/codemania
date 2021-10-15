package edu.design_patterns.bridge;

public class ArtistResource implements Resource {

    private Artist artist;

    public ArtistResource(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String getDescription() {
        return artist.getBio();
    }

    @Override
    public String getTitle() {
        return artist.getFirstName() + " " + artist.getLastName();
    }

    @Override
    public String getImageUrl() {
        return artist.getImageUrl();
    }

    @Override
    public double getRatings() {
        return artist.getRatings();
    }
}
