package edu.design_patterns.bridge;

public abstract class View {

    protected Resource resource;

    public View(Resource resource) {
        this.resource = resource;
    }

    abstract String getView();
}
