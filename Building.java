/**
 * Represents a general building with a name, address, and number of floors.
 */
public class Building {

    /** The name of the building */
    protected String name = "<Name Unknown>";
    /** The address of the building */
    protected String address = "<Address Unknown>";
    /** The number of floors in the building */
    protected int nFloors = 1;


    /**
     * Constructs a Building object with a specified name, address, and number of floors
     * @param name The name of the building
     * @param address The address of the building
     * @param nFloors The number of floors in the building
     * @throws RuntimeException if nFloors is less than 1
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Gets the name of the building
     * 
     * @return The name of the building
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the address of the building
     * 
     * @return The name of the building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets the number of floors in the building
     * 
     * @return The number of floors in the building
     */
    public int getFloors() {
        return this.nFloors;
    }

    
    /**
     * Returns a strung representation of the Building object.
     * 
     * @return A strung containing the building's name, number of floors, and address
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    /**
     * Tests the functionalisty of the Building class methods.
     * 
     * @param args command line arguemtns (not used)
     */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);

        //Test getName method
        System.out.println("Building Name: " + fordHall.getName()); // Expected output: Building Name: Ford Hall

        //Test getAddress method
        System.out.println("Building Address: " + fordHall.getAddress()); // Expected output: Building Address: 100 Green Street Northampton, MA 01063


        //Test getFloors method
        System.out.println("Number of Floors: " + fordHall.getFloors()); //Expected output: Number of Floors: 4

        //Test toString method
        System.out.println("Building Details: " + fordHall.toString()); //Expected output: Ford Hall is a 4-story building located at 100 Green Street Northampton, MA 01063.
    }

}
