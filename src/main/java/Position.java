
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Position go(Orientation orientation) {
        int[] vec = orientation.getVec();
        this.x += vec[0];
        this.y += vec[1];
        return this;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
