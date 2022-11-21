public enum OperatingSystem {
    WINDOWS("Windows"),
    LINUX("Linux"),
    MAC("Mac");

    private final String title;

    OperatingSystem(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
