/**
 *A class representing a player character in a fantasy role-playing game, such as the Dungeons & Dragons tabletop game or The Elder Scrolls video games.
 *@author Michael Cummings
 *@version 10.23.21
 */
public class Hero
{
    public final int BASE_HEALTH = 90; //Minimum value for a Hero character's maximum health, intended to be added to a base statFortitude of 10 to equal a base maxHealthPoints of 100
    public final int BASE_STAMINA = 40; //Minimum value for a Hero character's maximum stamina, intended to be added to a base statAgility of 10 to equal a base maxStaminaPoints of 50
    public final int BASE_MAGIC = -10; //Minimum value for a Hero character's maximum stamina, intended to be a base statIntelligence of 10 to equal a base maxMagicPoints of 10; if maxMagicPoints would be <0, set maxMagicPoints to 0
    
    private String name;
    private String species; //Hero characters don't necessarily have to be human
    private String role = "None"; //Subclasses will assign the Hero class the role field, default is None
    private int age;
    private double weight; //weight will be represented in pounds
    private double height; //height will be represented in centimeters
    
    private int statStrength; //The Strength stat determines how much damage a Hero can deal, how much weight they can lift, etc.
    private int statDexterity; //The Dexterity stat determines how well a character performs physical feats requiring precision and finesse
    private int statFortitude; //The Fortitude stat determines how much damage a Hero can sustain by adding to ther Hero's base Health Points
    private int statAgility; //The Agility stat determines how fast a Hero can move, as well as their chance to avoid damage. Also determines a Hero's minimum Stamina points
    private int statIntelligence; //The Intelligence stat determines how many Magic Points a character has, and consequently which spells that Hero can cast
    private int statCharisma;//The Charisma stat influences how much non-player characters like the Hero character
    private int statLuck; //The Luck stat influences how the Hero is impacted by events involving randomness
    
    private int maxHealthPoints; //health value represents the hero's physical status, Hero will be incapacited if maxHealthPoints <= 0
    private int currentHealthPoints;
    private int maxStaminaPoints; //stamina value represents how much Hero can physically exert themselves (running, swimming, fighting, etc)
    private int currentStaminaPoints;
    private int maxMagicPoints; //magic value represents how much Hero can mentally exert themselves performing magic spells
    private int currentMagicPoints;
    
    private String weaponSlotOneName; //Hero characters will have a minimum of two weapon slots
    private String weaponSlotTwoName;

    /**
     * Constructor for objects of class Hero
     */
    public Hero()
    {
        this.name = "Unknown";
        this.age = 18;
        this.species = "Human";
        this.weight = 160.0; //Weight in pounds
        this.height = 177.8; //Height in centimeters, converted from 5'10" (thanks Google!)
        
        this.statStrength = 10; //10 is the default value for character attributes
        this.statDexterity = 10;
        this.statFortitude = 10;
        this.statAgility = 10;
        this.statIntelligence = 10;
        this.statCharisma = 10;
        this.statLuck = 10;
        
        this.maxHealthPoints = BASE_HEALTH + this.statFortitude; //health is calculated by adding Hero's Fortitude stat to a base of 90
        this.currentHealthPoints = this.maxHealthPoints;
        this.maxStaminaPoints = BASE_STAMINA + this.statAgility; //stamina is calculated by adding Hero's Agility stat to a base of 40
        this.currentStaminaPoints = this.maxStaminaPoints;
        this.maxMagicPoints = BASE_MAGIC + this.statIntelligence; //magic is calculated by adding Hero's Intelligence stat to a base of -10
        if(this.maxMagicPoints < 0) //if maxMagicPoints would be <0, set maxMagicPoints to 0
        {
            this.maxMagicPoints = 0;
        }
        this.currentMagicPoints = this.maxMagicPoints;
        
        this.weaponSlotOneName = "None";
        this.weaponSlotTwoName = "None";
    }
    
    /**
     * Constructor for Hero objects with user defined parameters
     * @param name
     * @param species
     * @param age
     * @param weight
     * @param height
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
        
        this.maxHealthPoints = BASE_HEALTH + this.statFortitude; //health is calculated by adding Hero's Fortitude stat to a base of 90
        this.currentHealthPoints = this.maxHealthPoints;
        this.maxStaminaPoints = BASE_STAMINA + this.statAgility; //stamina is calculated by adding Hero's Agility stat to a base of 40
        this.currentStaminaPoints = this.maxStaminaPoints;
        this.maxMagicPoints = BASE_MAGIC + this.statIntelligence; //magic is calculated by adding Hero's Intelligence stat to a base of -10
        if(this.maxMagicPoints < 0) //if maxMagicPoints would be <0, set maxMagicPoints to 0
        {
            this.maxMagicPoints = 0;
        }
        this.currentMagicPoints = this.maxMagicPoints;
        
        this.weaponSlotOneName = "None";
        this.weaponSlotTwoName = "None";
    }
    
    /**
     * Method to set a Hero's name to a desired String
     * @param playerName
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
     * @param playerAge
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
     * @param playerSpecies
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
     * @param playerRole
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
     * @param playerHeight
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
     * @param playerWeight
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
     * Method to return a Hero's Strength attribute
     */
    public int getStatStrength()
    {
        return this.statStrength;
    }
    /**
     * Method to set a Hero's Strength attribute
     * @param strength
     */
    public void setStatStrength(int strength)
    {
        this.statStrength = strength;
    }
    /**
     * Method to return a Hero's Dexterity attribute
     */
    public int getStatDexterity()
    {
        return this.statDexterity;
    }
    /**
     * Method to set a Hero's Dexterity attribute
     * @param dexterity
     */
    public void setStatDexterity(int dexterity)
    {
        this.statDexterity = dexterity;
    }
    /**
     * Method to return a Hero's Fortitude stat
     */
    public int getStatFortitude()
    {
        return this.statFortitude;
    }
    /**
     * Method to set a Hero's Fortitude attribute
     * @param fortitude
     */
    public void setStatFortitude(int fortitude)
    {
        this.statFortitude = fortitude;
    }
    /**
     * Method to return a Hero's Agility attribute
     */
    public int getStatAgility()
    {
        return this.statAgility;
    }
    /**
     * Method to set a Hero's Agility attribute
     * @param agility
     */
    public void setStatAgility(int agility)
    {
        this.statAgility = agility;
    }
    /**
     * Method to return a Hero's Intelligence attribute
     */
    public int getStatIntelligence()
    {
        return this.statIntelligence;
    }
    /**
     * Method to set a Hero's Intelligence attribute
     * @param intelligence
     */
    public void setStatIntelligence(int intelligence)
    {
        this.statIntelligence = intelligence;
    }
    /**
     * Method to return a Hero's Charisma attribute
     */
    public int getStatCharisma()
    {
        return this.statCharisma;
    }
    /**
     * Method to set a Hero's Charisma attribute
     * @param charisma
     */
    public void setStatCharisma(int charisma)
    {
        this.statCharisma = charisma;
    }
    /**
     * Method to return a Hero's Luck attribute
     */
    public int getStatLuck()
    {
        return this.statLuck;
    }
    /**
     * Method to set a Hero's Luck attribute
     * @param luck
     */
    public void setStatLuck(int luck)
    {
        this.statLuck = luck;
    }
    
    /**
     * Method to return a Hero's maximum health point value
     */
    public int getMaxHealthPoints()
    {
        return this.maxHealthPoints;
    }
    /**
     * Method to set a Hero's maximum health point value. A Hero's maximum health points are given a bonus depending on that Hero's Fortitude attribute.
     * @param health
     */
    public void setMaxHealthPoints(int health)
    {
        this.maxHealthPoints = health + this.statFortitude;
    }
    /**
     * Method to return a Hero's current health point value
     */
    public int getCurrentHealthPoints()
    {
        return this.currentHealthPoints;
    }
    /**
     * Method to set a Hero's current health point value
     * @param health
     */
    public void setCurrentHealthPoints(int health)
    {
        this.currentHealthPoints = health;
    }
    /**
     * Method to return a Hero's maximum stamina point value
     */
    public int getMaxStaminaPoints()
    {
        return this.maxStaminaPoints;
    }
    /**
     * Method to set a Hero's maximum stamina point value. A Hero's maximum stamina points are given a bonus depending on their Agility attribute.
     * @param stamina
     */
    public void setMaxStaminaPoints(int stamina)
    {
        this.maxStaminaPoints = stamina + this.statAgility;
    }
    /**
     * Method to return a Hero's current stamina point value
     */
    public int getCurrentStaminaPoints()
    {
        return this.currentStaminaPoints;
    }
    /**
     * Method to set a Hero's current stamina point value
     * @param stamina
     */
    public void setCurrentStaminaPoints(int stamina)
    {
        this.currentStaminaPoints = stamina;
    }
    /**
     * Method to return a Hero's maximum magic point value
     */
    public int getMaxMagicPoints()
    {
        return this.maxMagicPoints;
    }
    /**
     * Method to set a Hero's maximum magic point value. A Hero's maximum magic points are given a bonus depending on their Intelligence attribute.
     * @param magic
     */
    public void setMaxMagicPoints(int magic)
    {
        this.maxMagicPoints = magic + this.statIntelligence;
    }
    /**
     * Method to return a Hero's current magic point value
     */
    public int getCurrentMagicPoints()
    {
        return this.currentMagicPoints;
    }
    /**
     * Method to set a Hero's current magic point value
     * int magic
     */
    public void setCurrentMagicPoints(int magic)
    {
        this.currentMagicPoints = magic;
    }
    
    /**
     * Method to return the String in weaponSlotOneName
     */
    public String getWeaponSlotOneName()
    {
        return this.weaponSlotOneName;
    }
    /**
     * Method to set the String in weaponSlotOneName
     */
    public void setWeaponSlotOneName(String name)
    {
        this.weaponSlotOneName = name;
    }
    /**
     * Method to return the String in weaponSlotTwoName
     */
    public String getWeaponSlotTwoName()
    {
        return this.weaponSlotTwoName;
    }
    /**
     * Method to set the String in weaponSlotTwoName
     */
    public void setWeaponSlotTwoName(String name)
    {
        this.weaponSlotTwoName = name;
    }
    
    /**
     * Method to print all info in a Hero character
     */
    public void getInfo()
    {
        System.out.println("/////////////////////////////");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Species: " + this.species);
        System.out.println("Height: " + this.height + " cm");
        System.out.println("Weight: " + this.weight + " lbs");
        System.out.println("Role: " + this.role);
        System.out.println("/////////////////////////////");
        
        System.out.println("Health Points: " + this.currentHealthPoints + " / " + this.maxHealthPoints);
        System.out.println("Stamina Points: " + this.currentStaminaPoints + " / " + this.maxStaminaPoints);
        System.out.println("Magic Points: " + this.currentMagicPoints + " / " + this.maxMagicPoints);
        System.out.println("/////////////////////////////");
        
        System.out.println("Weapon 1: " + this.weaponSlotOneName);
        System.out.println("Weapon 2: " + this.weaponSlotTwoName);
        System.out.println("/////////////////////////////");
        
        System.out.println("Strength: " + this.statStrength);
        System.out.println("Dexterity: " + this.statDexterity);
        System.out.println("Fortitude: " + this.statFortitude);
        System.out.println("Agility: " + this.statAgility);
        System.out.println("Intelligence: " + this.statIntelligence);
        System.out.println("Charisma: " + this.statCharisma);
        System.out.println("Luck: " + this.statLuck);
        System.out.println("/////////////////////////////");
        System.out.println();
    }
    
    /**
     * Method to print a short sentence describing the Hero character
     */
    public void getInfoSimple()
    {
        if(this.role.equals("None"))
        {
            System.out.println(this.name + " is a " + this.age + "-year-old " + this.species + " who has yet to find their destiny.");
        }
        else
        {
            System.out.println(this.name + " is a " + this.age + "-year-old " + this.species + " " + this.role + ".");
        }
        System.out.println();
    }
}
