package edu.design_patterns.command;

public class MusicOffCommand implements ICommand {

    private Music music;

    public MusicOffCommand(Music music) {
        this.music = music;
    }

    @Override
    public void execute() {
        music.off();
    }

    @Override
    public void unexecute() {
        music.on();
    }
}
