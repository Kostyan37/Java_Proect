public enum Color {
    BLUE("Blue"),
    GRAY("Gray"),
    RED("RED"),
    DARK("Dark");

    private final String title;

    Color(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
