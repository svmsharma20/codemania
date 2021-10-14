package edu.design_patterns.command;

public class LightOnCommand implements ICommand {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void unexecute() {
        light.off();
    }
}
