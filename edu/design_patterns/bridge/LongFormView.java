package edu.design_patterns.bridge;

public class LongFormView extends View {

    public LongFormView(Resource resource) {
        super(resource);
    }

    @Override
    String getView() {
        return "Title: " + resource.getTitle()
            + "\nDescription: " + resource.getDescription()
            + "\nRatings: " + resource.getRatings()
            + "\nImage: " + resource.getImageUrl();
    }
}
