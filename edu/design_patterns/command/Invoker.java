package edu.design_patterns.command;

public class Invoker {

    private ICommand button1Command;
    private ICommand button2Command;

    public Invoker(ICommand button1Command, ICommand button2Command) {
        this.button1Command = button1Command;
        this.button2Command = button2Command;
    }

    public void executeButton1() {
        button1Command.execute();
    }

    public void executeButton2() {
        button2Command.execute();
    }
}
