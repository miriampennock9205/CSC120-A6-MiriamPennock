import java.util.ArrayList;
/* This is a stub for the House class */
public class House extends Building{

  private ArrayList<String> residents; //Stores list of residents in the house
  private boolean hasDiningRoom; //indicated if a house has a dining room

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors); //call the Building constructor
    this.residents = new ArrayList<String>(); //Initalize the residents list
    this.hasDiningRoom = hasDiningRoom; //Set whether the house has a dining room
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    if (!this.residents.contains(name)) {
      this.residents.add(name); 
    } else {
      System.out.println(name + " is already a resident.");
    }
  }

  public String moveOut(String name) {
    if (this.residents.contains(name)) {
      this.residents.remove(name);
      return name;
    } else {
      System.out.println(name + " is not a resident.");
      return null;
    }
  }
  public static void main(String[] args) {
    House myHouse = new House("My House", "123 Main St", 2, true);
    System.out.println(myHouse);
  }
}