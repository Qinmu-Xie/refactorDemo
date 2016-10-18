public class MarsRover {

    private Position position;
    private Orientation orientation;

    public MarsRover(String initialPosition, String initialOrientation) {
        String[] strings = initialPosition.split(" ");
        position = new Position(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
        orientation = Orientation.valueOf(initialOrientation);
    }

    public void execute(String commands) {
        commands.chars()
                .mapToObj(c -> (char) c)
                .map(Cmd::of)
                .forEach(cmd -> cmd.move(this));
    }

    public void rotateRight() {
        this.orientation = this.orientation.right();
    }

    public void rotateLeft() {
        this.orientation = this.orientation.left();
    }

    public void moveForward() {
        this.position.go(orientation);
    }

    public String getPositionAndOrientation() {
        return position + " " + orientation.getDirection();
    }
}
