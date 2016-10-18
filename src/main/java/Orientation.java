public enum Orientation {
    N("N") {
        @Override
        public int[] getVec() {
            return new int[]{0, 1};
        }
    },
    E("E") {
        @Override
        public int[] getVec() {
            return new int[]{0, 1};
        }
    },
    S("S") {
        @Override
        public int[] getVec() {
            return new int[]{0, -1};

        }
    },
    W("W") {
        @Override
        public int[] getVec() {
            return new int[]{-1, 0};
        }
    };

    private String direction;

    Orientation(String direction) {
        this.direction = direction;
    }

    public abstract int[] getVec();

    public String getDirection() {
        return direction;
    }

    Orientation right() {
        return values()[(ordinal() + 1) % values().length];
    }

    Orientation left() {
        return values()[(ordinal() + values().length - 1) % values().length];
    }
}
