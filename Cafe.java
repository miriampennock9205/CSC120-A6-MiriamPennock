/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; //The number of ounces of coffee in stock
    private int nSugarPackets; //The number of sugar packets in stock
    private int nCreams; //The number of "splashes" of cream in stock
    private int nCups; //The number of cups in stock

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (nCoffeeOunces >= size && nSugarPackets <= this.nSugarPackets && nCreams < this.nCreams && nCups > 0) {
            this.nCoffeeOunces -= size; //Reduce coffee stock
            this.nSugarPackets -= nSugarPackets; //Reduce sugar stock
            this.nCreams -= nCreams; //Reduce cream stock
            this.nCups -= 1; //Reduce cup stock
            System.out.println("Coffee sold!");
        } else {
            System.out.println("Cannot complete sale: not enough stock.");
        }
    }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Cafe", "100 Green St, Northampton, MA", 1, 100, 50, 30, 20);
        System.out.println(myCafe);
    }
    
}
