public class Flat {
	private int itemNumber;
    private String itemName;
    private int noOfItem;
    private double rent;
    private boolean available;

    public Flat(int itemNumber, String itemName, int noOfItem, double rent, boolean available) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.noOfItem = noOfItem;
        this.rent = rent;
        this.available = available;
    }

    public int getitemNumber() {
        return itemNumber;
    }

    public String getitemName() {
        return itemName;
    }

    public int getnoOfItem() {
        return noOfItem;
    }

    public double getRent() {
        return rent;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
