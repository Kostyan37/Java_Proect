public enum Filters {
    RAM("RAMs GB"),
    HDD_SIZE("HDDs size GB"),
    COLOR("Color"),
    OS("Operating System");

    private final String title;

    Filters(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
