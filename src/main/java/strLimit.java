
public class strLimit {
    private int limit;
    private String tempString;
    public strLimit(int limit) {
        this.limit = limit;
    }


    public strLimit tryString(String s) {
        if (s.length() <= limit) {
            this.tempString = s;
        }
        return this;
    }

    public String get() {
        return this.tempString;
    }
}
