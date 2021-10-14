package edu.design_patterns.command;

public class LightOffCommand implements ICommand {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void unexecute() {
        light.on();
    }
}
