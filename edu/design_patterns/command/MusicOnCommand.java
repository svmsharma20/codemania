package edu.design_patterns.command;

public class MusicOnCommand implements ICommand {

    private Music music;

    public MusicOnCommand(Music music) {
        this.music = music;
    }

    @Override
    public void execute() {
        music.on();
    }

    @Override
    public void unexecute() {
        music.off();
    }
}
