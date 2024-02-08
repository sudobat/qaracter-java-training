package introduction;

public class Chair {
    private int numberOfLegs;
    private String material;
    private String color;
    private double height;
    private boolean isReclining;

    public Chair(
            int numberOfLegs,
            String material,
            String color,
            double height,
            boolean isReclining
    ) throws Exception {

        if (numberOfLegs < 3) {
            throw new Exception("Invalid number legs");
        }

        if (color == "orange") {
            throw new Exception("Invalid color");
        }

        if (height <= 0) {
            throw new Exception("Invalid height");
        }

        this.numberOfLegs = numberOfLegs;
        this.material = material;
        this.color = color;
        this.height = height;
        this.isReclining = isReclining;
    }

    public int numberOfLegs() {
        return numberOfLegs;
    }

    public String color() {
        return color;
    }

    public void paint(String newColor) throws Exception {
        if (newColor == "orange") {
            throw new Exception("Invalid color");
        }

        color = newColor;
    }

    public void removeLeg() throws Exception {
        if (numberOfLegs < 3) {
            throw new Exception("Invalid number legs");
        }

        numberOfLegs--;
    }
}
