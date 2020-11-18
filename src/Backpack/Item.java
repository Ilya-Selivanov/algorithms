package Backpack;

public class Item {
    private int coast;
    private int weight;

    public Item(int coast, int weight) {
        this.coast = coast;
        this.weight = weight;
    }

    public double getValue(){
        return (double)coast/(double)weight;
    }

    public int getCoast() {
        return coast;
    }

    public int getWeight() {
        return weight;
    }
}
