package edu.design_patterns.command;

public class Main {

    public static void main(String[] args) {

        /*
         * For Alice :
         *   button1 : turns on the light
         *   button2 : turn off the light
         * */
        Light light = new Light();
        ICommand lightOnCommand = new LightOnCommand(light);
        ICommand lightOffCommand = new LightOnCommand(light);

        Invoker aliceInvoker = new Invoker(lightOnCommand, lightOffCommand);
        aliceInvoker.executeButton1();
        aliceInvoker.executeButton2();

        /*
         * For Bob :
         *   button1 : turns on the music
         *   button2 : turns off the music
         * */
        Music music = new Music();
        ICommand musicOnCommand = new MusicOnCommand(music);
        ICommand musicOffCommand = new MusicOffCommand(music);

        Invoker bobInvoker = new Invoker(musicOnCommand, musicOffCommand);
        bobInvoker.executeButton1();
        bobInvoker.executeButton2();
    }
}
