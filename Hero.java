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
     * @param name  the character's name
     * @param species   the character's species
     * @param age   the character's age in years
     * @param weight    the character's weight in pounds
     * @param height    the character's height in centimeters
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
     * @param playerName    the character's intended name
     */
    public void setName(String playerName)
    {
        this.name = playerName;
    }
    /**
     * Method to print a Hero's name
     * @return name     the character's name
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Method to set a Hero's age
     * @param playerAge     the character's intended age     
     */
    public void setAge(int playerAge)
    {
        this.age = playerAge;
    }
    /**
     * Method to print a Hero's age
     * @return age      the character's age
     */
    public int getAge()
    {
        return this.age;
    }
    /**
     * Method to set a Hero's species (Human, Elf, Orc, etc.)
     * @param playerSpecies     the character's intended species
     */
    public void setSpecies(String playerSpecies)
    {
        this.species = playerSpecies;
    }
    /**
     * Method to print a Hero's species
     * @return species      the character's species
     */
    public String getSpecies()
    {
        return this.species;
    }
    /**
     * Method to set a Hero's role. Meant only to be used in subclass constructors
     * @param playerRole    the character's role
     */
    public void setRole(String playerRole)
    {
        this.role = playerRole;
    }
    /**
     * Method to print a Hero's role. No complementing set method because role will be set by subclass
     * @return role     the character's role
     */
    public String getRole()
    {
        return this.role;
    }
    /**
     * Method to set a character's height
     * @param playerHeight     the character's height in centimeters
     */
    public void setHeight(double playerHeight)
    {
        this.height = playerHeight;
    }
    /**
     * Method to print a player's height
     * @return height   the character's height in centimeters
     */
    public double getHeight()
    {
        return this.height;
    }
    /**
     * Method to set a character's weight
     * @param playerWeight      the character's weight in pounds
     */
    public void setWeight(double playerWeight)
    {
        this.weight = playerWeight;
    }
    /**
     * Method to print a character's weight
     * @return weight   the character's weight in pounds
     */
    public double getWeight()
    {
        return this.weight;
    }
    
    /**
     * Method to return a Hero's Strength attribute
     * @return strength     the character's Strength attribute
     */
    public int getStatStrength()
    {
        return this.statStrength;
    }
    /**
     * Method to set a Hero's Strength attribute
     * @param strength      the character's intended Strength attribute
     */
    public void setStatStrength(int strength)
    {
        this.statStrength = strength;
    }
    /**
     * Method to return a Hero's Dexterity attribute
     * @return dexterity    the character's Dexterity attribute
     */
    public int getStatDexterity()
    {
        return this.statDexterity;
    }
    /**
     * Method to set a Hero's Dexterity attribute
     * @param dexterity     the character's intended Dexterity attribute
     */
    public void setStatDexterity(int dexterity)
    {
        this.statDexterity = dexterity;
    }
    /**
     * Method to return a Hero's Fortitude stat
     * @return fortitude    the character's Fortitude attribute
     */
    public int getStatFortitude()
    {
        return this.statFortitude;
    }
    /**
     * Method to set a Hero's Fortitude attribute
     * @param fortitude     the character's intended Fortitude attribute
     */
    public void setStatFortitude(int fortitude)
    {
        this.statFortitude = fortitude;
    }
    /**
     * Method to return a Hero's Agility attribute
     * @return agility      the character's Agility attribute
     */
    public int getStatAgility()
    {
        return this.statAgility;
    }
    /**
     * Method to set a Hero's Agility attribute
     * @param agility       the character's intended Agility attribute
     */
    public void setStatAgility(int agility)
    {
        this.statAgility = agility;
    }
    /**
     * Method to return a Hero's Intelligence attribute
     * @return intelligence     the character's Intelligence attribute
     */
    public int getStatIntelligence()
    {
        return this.statIntelligence;
    }
    /**
     * Method to set a Hero's Intelligence attribute
     * @param intelligence      the character's intended Intelligence attribute
     */
    public void setStatIntelligence(int intelligence)
    {
        this.statIntelligence = intelligence;
    }
    /**
     * Method to return a Hero's Charisma attribute
     * @return charisma     the character's Charisma attribute
     */
    public int getStatCharisma()
    {
        return this.statCharisma;
    }
    /**
     * Method to set a Hero's Charisma attribute
     * @param charisma      the character's intended Charisma attribute
     */
    public void setStatCharisma(int charisma)
    {
        this.statCharisma = charisma;
    }
    /**
     * Method to return a Hero's Luck attribute
     * @return luck     the character's Luck attribute
     */
    public int getStatLuck()
    {
        return this.statLuck;
    }
    /**
     * Method to set a Hero's Luck attribute
     * @param luck      the character's intended Luck attribute
     */
    public void setStatLuck(int luck)
    {
        this.statLuck = luck;
    }
    
    /**
     * Method to return a Hero's maximum health point value
     * @return maxHealth    the character's maximum health point value
     */
    public int getMaxHealthPoints()
    {
        return this.maxHealthPoints;
    }
    /**
     * Method to set a Hero's maximum health point value. A Hero's maximum health points are given a bonus depending on that Hero's Fortitude attribute.
     * @param maxHealth     the character's intended maximum health value, not counting any bonus granted by the character's Fortitude attribute  
     */
    public void setMaxHealthPoints(int maxHealth)
    {
        this.maxHealthPoints = maxHealth + this.statFortitude;
    }
    /**
     * Method to return a Hero's current health point value
     * @return currentHealth    the character's current health point value
     */
    public int getCurrentHealthPoints()
    {
        return this.currentHealthPoints;
    }
    /**
     * Method to set a Hero's current health point value
     * @param currentHealth     the character's intended current health point value
     */
    public void setCurrentHealthPoints(int currentHealth)
    {
        this.currentHealthPoints = currentHealth;
    }
    /**
     * Method to return a Hero's maximum stamina point value
     * @return maxStamina   the character's maximum stamina point value
     */
    public int getMaxStaminaPoints()
    {
        return this.maxStaminaPoints;
    }
    /**
     * Method to set a Hero's maximum stamina point value. A Hero's maximum stamina points are given a bonus depending on their Agility attribute.
     * @param maxStamina    the character's intended maximum stamina value, not counting any bonus granted by the Hero's Agility attribute
     */
    public void setMaxStaminaPoints(int maxStamina)
    {
        this.maxStaminaPoints = maxStamina + this.statAgility;
    }
    /**
     * Method to return a Hero's current stamina point value
     * @return currentStamina   the Hero's current stamina point value
     */
    public int getCurrentStaminaPoints()
    {
        return this.currentStaminaPoints;
    }
    /**
     * Method to set a Hero's current stamina point value
     * @param currentStamina    the character's intended current stamina point value
     */
    public void setCurrentStaminaPoints(int currentStamina)
    {
        this.currentStaminaPoints = currentStamina;
    }
    /**
     * Method to return a Hero's maximum magic point value
     * @return maxMagic     the character's maximum magic point value
     */
    public int getMaxMagicPoints()
    {
        return this.maxMagicPoints;
    }
    /**
     * Method to set a Hero's maximum magic point value. A Hero's maximum magic points are given a bonus depending on their Intelligence attribute.
     * @param maxMagic      the character's intended maximum magic point value, not counting any bonus granted by the Hero's Intelligence attribute
     */
    public void setMaxMagicPoints(int maxMagic)
    {
        this.maxMagicPoints = maxMagic + this.statIntelligence;
    }
    /**
     * Method to return a Hero's current magic point value
     * @return currentMagic     the Hero's current magic point value
     */
    public int getCurrentMagicPoints()
    {
        return this.currentMagicPoints;
    }
    /**
     * Method to set a Hero's current magic point value
     * @param currentMagic      the Hero's intended current magic point value
     */
    public void setCurrentMagicPoints(int currentMagic)
    {
        this.currentMagicPoints = currentMagic;
    }
    
    /**
     * Method to return the String in weaponSlotOneName
     * @return weaponOne    the String in weaponSlotOneName
     */
    public String getWeaponSlotOneName()
    {
        return this.weaponSlotOneName;
    }
    /**
     * Method to set the String in weaponSlotOneName
     * @param weaponOne     the String to be entered in weaponSlotOneName
     */
    public void setWeaponSlotOneName(String name)
    {
        this.weaponSlotOneName = name;
    }
    /**
     * Method to return the String in weaponSlotTwoName
     * @return weaponTwo    the String in weaponSlotTwoName
     */
    public String getWeaponSlotTwoName()
    {
        return this.weaponSlotTwoName;
    }
    /**
     * Method to set the String in weaponSlotTwoName
     * @param weaponTwo     the String to be entered in weaponSlotTwoName
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
