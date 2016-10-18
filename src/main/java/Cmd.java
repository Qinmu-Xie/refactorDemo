public abstract class Cmd {

    public void move(MarsRover marsRover) {}

    public static Cmd of(Character c) {
        if (c == 'R'){
            return new RCmd();
        } else if ( c == 'L') {
            return new LCmd();
        }
        return new FCmd();
    }
}
