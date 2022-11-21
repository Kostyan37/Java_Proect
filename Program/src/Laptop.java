public class Laptop {
    private OperatingSystem os;
    private Color color;
    private int RAM;
    private int HDDSize;

    private String title;

    private final int price;

    public Laptop(String title, OperatingSystem os, Color color, int ram, int hddSize, int price) {
        this.os = os;
        this.color = color;
        this.RAM = ram;
        this.HDDSize = hddSize;
        this.price = price;
        this.title = title;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public void setOs(OperatingSystem os) {
        this.os = os;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getHDDSize() {
        return HDDSize;
    }

    public void setHDDSize(int HDDSize) {
        this.HDDSize = HDDSize;
    }

    public void String() {
        System.out.println(title +
                " OS: " + os.toString() +
                " Color: " + color.toString() +
                " RAM: " + RAM + " GB" +
                " HDD size: " + HDDSize + " GB" +
                " Price: $" + price);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
