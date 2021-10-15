package edu.design_patterns.bridge;

public class ShortFormView extends View {

    public ShortFormView(Resource resource) {
        super(resource);
    }

    @Override
    String getView() {
        return "Title: " + resource.getTitle()
            + "\nRatings: " + resource.getRatings();
    }
}
