
/**
 *A class representing a player character in a fantasy role-playing game, such as the Dungeons & Dragons tabletop game or The Elder Scrolls video games.
 *@author Michael Cummings
 */
public class Hero
{
    private String name;
    private String species; //Hero characters don't necessarily have to be human
    private String role = "None"; //Subclasses will assign the Hero class the role field, default is None
    private int age;
    private double weight;
    private double height;
    
    private int statStrength; //The Strength stat determines how much damage a Hero can deal, how much weight they can lift, etc.
    private int statDexterity; //The Dexterity stat determines how well a character performs physical feats requiring precision and finesse
    private int statFortitude; //The Fortitude stat determines how much damage a Hero can sustain by adding to ther Hero's base Health Points
    private int statAgility; //The Agility stat determines how fast a Hero can move, as well as their chance to avoid damage. Also determines a Hero's minimum Stamina points
    private int statIntelligence; //The Intelligence stat determines how many Magic Points a character has, and consequently which spells that Hero can cast
    private int statCharisma;//The Charisma stat influences how much non-player characters like the Hero character
    private int statLuck; //The Luck stat influences how the Hero is impacted by events involving randomness
    
    private int healthPoints; //health value represents the hero's physical status, Hero will be incapacited if healthPoints <= 0
    private int staminaPoints; //stamina value represents how much Hero can physically exert themselves (running, swimming, fighting, etc)
    private int magicPoints; //magic value represents how much Hero can mentally exert themselves performing magic spells

    /**
     * Constructor for objects of class Hero
     */
    public Hero()
    {
        this.name = "Unknown";
        this.age = 0;
        this.species = "Human";
        this.weight = 150.0; //Weight in pounds
        this.height = 177.8; //Height in centimeters, converted from 5'10" (thanks Google!)
        
        this.statStrength = 10; //10 is the default value for character attributes
        this.statDexterity = 10;
        this.statFortitude = 10;
        this.statAgility = 10;
        this.statIntelligence = 10;
        this.statCharisma = 10;
        this.statLuck = 10;
        
        this.healthPoints = 90 + this.statFortitude; //health is calculated by adding Hero's Fortitude stat to a base of 90
        this.staminaPoints = 40 + this.statAgility; //stamina is calculated by adding Hero's Agility stat to a base of 40
        this.magicPoints = -10 + this.statIntelligence; //magic is calculated by adding Hero's Intelligence stat to a base of -10
    }
    
    /**
     * Constructor for Hero objects with user defined parameters
     */
    public Hero(String name, String species, int age, double weight, double height)
    {
        this.name = name;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.height = height;
        
        this.statStrength = 10; //10 is the default value for character attributes
        this.statDexterity = 10;
        this.statFortitude = 10;
        this.statAgility = 10;
        this.statIntelligence = 10;
        this.statCharisma = 10;
        this.statLuck = 10;
        
        this.healthPoints = 90 + this.statFortitude;
        this.staminaPoints = 40 + this.statAgility;
        this.magicPoints = -10 + this.statIntelligence;
    }
    
    /**
     * Method to set a Hero's name to a desired String
     */
    public void setName(String playerName)
    {
        this.name = playerName;
    }

    /**
     * Method to print a Hero's name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Method to set a Hero's age
     */
    public void setAge(int playerAge)
    {
        this.age = playerAge;
    }
    
    /**
     * Method to print a Hero's age
     */
    public int getAge()
    {
        return this.age;
    }
    
    /**
     * Method to set a Hero's species (Human, Elf, Orc, etc.)
     */
    public void setSpecies(String playerSpecies)
    {
        this.species = playerSpecies;
    }
    
    /**
     * Method to print a Hero's species
     */
    public String getSpecies()
    {
        return this.species;
    }
    
    /**
     * Method to set a Hero's role. Meant only to be used in subclass constructors
     */
    public void setRole(String playerRole)
    {
        this.role = playerRole;
    }
    
    /**
     * Method to print a Hero's role. No complementing set method because role will be set by subclass
     */
    public String getRole()
    {
        return this.role;
    }
    
    /**
     * Method to set a character's height
     */
    public void setHeight(double playerHeight)
    {
        this.height = playerHeight;
    }
    
    /**
     * Method to print a player's height
     */
    public double getHeight()
    {
        return this.height;
    }
    
    /**
     * Method to set a character's weight
     */
    public void setWeight(double playerWeight)
    {
        this.weight = playerWeight;
    }
    
    /**
     * Method to print a character's weight
     */
    public double getWeight()
    {
        return this.weight;
    }
    
    /**
     * TODO: Write get and set methods for each attribute, won't be able to access them from subclasses directly
     */
    
    /**
     * Method to print all info in a Hero character
     */
    public void getInfo()
    {
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Species: " + this.getSpecies());
        System.out.println("Height: " + this.getHeight() + " cm");
        System.out.println("Weight: " + this.getWeight() + " lbs");
        System.out.println("Role: " + this.getRole());
        
        System.out.println("/////////////////////////////");
        System.out.println("Health Points: " + this.healthPoints);
        System.out.println("Stamina Points: " + this.staminaPoints);
        System.out.println("Magic Points: " + this.magicPoints);
        System.out.println("/////////////////////////////");
        
        System.out.println("Strength: " + this.statStrength);
        System.out.println("Dexterity: " + this.statDexterity);
        System.out.println("Fortitude: " + this.statFortitude);
        System.out.println("Agility: " + this.statAgility);
        System.out.println("Intelligence: " + this.statIntelligence);
        System.out.println("Charisma: " + this.statCharisma);
        System.out.println("Luck: " + this.statLuck);
        System.out.println();
    }
}
