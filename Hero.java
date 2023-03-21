/**
 *A class representing a player character in a fantasy role-playing game, such as the Dungeons & Dragons tabletop game or The Elder Scrolls video games.
 *@author Michael Cummings
 *@version 3.21.23
 */
public class Hero
{
    public final int BASE_HEALTH = 100; //Minimum value for a Hero character's maximum health, summed with the Hero's Fortitude minus 10 to calculate the Hero's total Health
    public final int BASE_STAMINA = 50; //Minimum value for a Hero character's maximum stamina, summed with the Hero's Agility minus 10 to calculate the Hero's total Stamina
    public final int BASE_MAGIC = 0; //Minimum value for a Hero character's maximum magic, summed with the Hero's Intelligence minus 10 to calculate the Hero's total Magic
    
    private String name;
    private String species; //Hero characters don't necessarily have to be human
    private int level; //int representing a Hero's overall power level. Default Hero objects are constructed with a level=1, subclasses are constructed with level=2
    private String role = "None"; //Subclasses will assign the Hero class the role field, default is None
    private int age;
    private double weight; //weight will be represented in pounds
    private double height; //height will be represented in centimeters
    
    private int statStrength; //The Strength stat determines how much damage a Hero can deal, how much weight they can lift, etc.
    private int statDexterity; //The Dexterity stat determines how well a character performs physical feats requiring precision and finesse
    private int statFortitude; //The Fortitude stat determines how much damage a Hero can sustain by adding to ther Hero's base Health Points
    private int statAgility; //The Agility stat determines how fast a Hero can move, as well as their chance to avoid damage. Also determines a Hero's minimum Stamina points
    private int statPerception; //The Perception stat determines a Hero's degree of situational awareness and intuition. Used to determine wether the Hero recognizes subtle details and clues in their environment and in dialogue with other characters
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
        this.level = 1;
        this.weight = 160.0; //Weight in pounds
        this.height = 177.8; //Height in centimeters, converted from 5'10" (thanks Google!)
        
        this.statStrength = 10; //10 is the default value for character Stats, meant to represent the degree to which the average person possesses that attribute
        this.statDexterity = 10;
        this.statFortitude = 10;
        this.statAgility = 10;
        this.statPerception = 10;
        this.statIntelligence = 10;
        this.statCharisma = 10;
        this.statLuck = 10;
        
        this.maxHealthPoints = BASE_HEALTH + (this.statFortitude - 10); //health is calculated by adding Hero's Fortitude stat minus 10 to a base of 100
        this.currentHealthPoints = this.maxHealthPoints;
        this.maxStaminaPoints = BASE_STAMINA + (this.statAgility - 10); //stamina is calculated by adding Hero's Agility stat minus 10 to a base of 50
        this.currentStaminaPoints = this.maxStaminaPoints;
        this.maxMagicPoints = BASE_MAGIC + (this.statIntelligence - 10); //magic is calculated by adding Hero's Intelligence stat minus 10 to a base of 0
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
        if(name.length() < 1)
        {
            throw new IllegalArgumentException("Please enter a name containing at least one character."); 
        }
        else
        {
            this.name = name;
        }
        
        if(species.length() < 1)
        {
            throw new IllegalArgumentException("Please enter a species name containing at least one character.");
        }
        else
        {
            this.species = species;
        }
        
        if(age < 18)
        {
            throw new IllegalArgumentException("Hero characters should be adults of their species, and at least 18 years old.");
        }
        else
        {
            this.age = age;
        }
        
        this.level = 1;
        
        if(weight <= 0)
        {
            throw new IllegalArgumentException("Hero characters can't weigh nothing, or have negative weight.");
        }
        else
        {
            this.weight = weight;
        }
        
        if(height <= 0)
        {
            throw new IllegalArgumentException("Hero characters must have a height in cm greater than 0.");
        }
        else
        {
            this.height = height;
        }
        
        this.statStrength = 10; //10 is the default value for character Stats
        this.statDexterity = 10;
        this.statFortitude = 10;
        this.statAgility = 10;
        this.statIntelligence = 10;
        this.statPerception = 10;
        this.statCharisma = 10;
        this.statLuck = 10;
        
        this.maxHealthPoints = BASE_HEALTH + (this.statFortitude - 10); //health is calculated by adding Hero's Fortitude stat minus 10 to a base of 100
        this.currentHealthPoints = this.maxHealthPoints;
        this.maxStaminaPoints = BASE_STAMINA + (this.statAgility - 10); //stamina is calculated by adding Hero's Agility stat minus 10 to a base of 50
        this.currentStaminaPoints = this.maxStaminaPoints;
        this.maxMagicPoints = BASE_MAGIC + (this.statIntelligence - 10); //magic is calculated by adding Hero's Intelligence stat minus 10 to a base of 0
        this.currentMagicPoints = this.maxMagicPoints;
        
        this.weaponSlotOneName = "None";
        this.weaponSlotTwoName = "None";
    }
    
    /**
     * Method to set a Hero's name to a desired String
     * @param characterName    the character's intended name
     */
    public void setName(String characterName)
    {
        if(characterName.length() < 1)
        {
            throw new IllegalArgumentException("Please enter a name containing at least one character."); 
        }
        else
        {
            this.name = characterName;
        }
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
     * @param characterAge     the character's intended age     
     */
    public void setAge(int characterAge)
    {
        if(characterAge < 18)
        {
            throw new IllegalArgumentException("Hero characters should be adults of their species, and at least 18 years old.");
        }
        else
        {
            this.age = characterAge;
        }
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
     * @param characterSpecies     the character's intended species
     */
    public void setSpecies(String characterSpecies)
    {
        if(characterSpecies.length() < 1)
        {
            throw new IllegalArgumentException("Please enter a species name containing at least one character.");
        }
        else
        {
            this.species = characterSpecies;
        }
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
     * Method to return a Hero's level
     * @return level    the character's level
     */
    public int getLevel()
    {
        return this.level;
    }
    /**
     * Method to set a Hero's level
     * @param characterLevel    the character's intended level
     */
    public void setLevel(int characterLevel)
    {
        if(characterLevel < 1)
        {
            throw new IllegalArgumentException("Hero characters must have a Level of 1 or higher.");
        }
        else
        {
            this.level = characterLevel;
        }
    }
    /**
     * TODO: levelUp()
     * This method would first increment the Hero's level by one. 
     * Then, it would print a message to the terminal containing the Hero's name and new level.
     * Then, it would prompt the user to select one of their character's Stats to increment by one.
     * This prompt repeats once.
     */
    // public void levelUp()
    // {
        // this.level = this.level++;
        // int attributePointsToSpend = 2; //Whenever a Hero gains a level, they earn 2 points to spend on any of their Stats, 1 point = +1 to chosen Stat. Players may choose to spend both attribute points on the same Stat, but must spend both points and not save them
        // System.out.println(this.name + " is now level " + this.level + "!");
        // System.out.println(this.name + " has " + attributePointsToSpend + " points to spend to upgrade their Stats.");
    // }
    /**
     * Method to set a Hero's role. Meant only to be used in subclass constructors
     * @param playerRole    the character's role
     */
    public void setRole(String characterRole)
    {
        if(characterRole.length() < 1)
        {
            throw new IllegalArgumentException("Heroes must have a Role title at least one character long");
        }
        else
        {
            this.role = characterRole;
        }
    }
    /**
     * Method to print a Hero's role.
     * @return role     the character's role
     */
    public String getRole()
    {
        return this.role;
    }
    /**
     * Method to set a character's height
     * @param characterHeight     the character's height in centimeters
     */
    public void setHeight(double characterHeight)
    {
        if(characterHeight <= 0)
        {
            throw new IllegalArgumentException("Hero characters must have a height in cm greater than 0.");
        }
        else
        {
            this.height = characterHeight;
        }
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
     * @param characterWeight      the character's weight in pounds
     */
    public void setWeight(double characterWeight)
    {
        if(characterWeight <= 0)
        {
            throw new IllegalArgumentException("Hero characters can't weigh nothing, or have negative weight.");
        }
        else
        {
            this.weight = characterWeight;
        }
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
     * Method to return a Hero's Strength Stat
     * @return strength     the character's Strength Stat
     */
    public int getStatStrength()
    {
        return this.statStrength;
    }
    /**
     * Method to set a Hero's Strength Stat
     * @param characterStrength      the character's intended Strength Stat
     */
    public void setStatStrength(int characterStrength)
    {
        if(characterStrength < 1)
        {
            throw new IllegalArgumentException("Any Stat of a Hero character cannot be lower or be lowered to less than 1.");
        }
        else
        {
            this.statStrength = characterStrength;
        }
    }
    /**
     * Method to return a Hero's Dexterity Stat
     * @return dexterity    the character's Dexterity Stat
     */
    public int getStatDexterity()
    {
        return this.statDexterity;
    }
    /**
     * Method to set a Hero's Dexterity Stat
     * @param characterDexterity     the character's intended Dexterity Stat
     */
    public void setStatDexterity(int characterDexterity)
    {
        if(characterDexterity < 1)
        {
            throw new IllegalArgumentException("Any Stat of a Hero character cannot be lower or be lowered to less than 1.");
        }
        else
        {
            this.statDexterity = characterDexterity;
        }
    }
    /**
     * Method to return a Hero's Fortitude stat
     * @return fortitude    the character's Fortitude Stat
     */
    public int getStatFortitude()
    {
        return this.statFortitude;
    }
    /**
     * Method to set a Hero's Fortitude Stat
     * @param characterFortitude     the character's intended Fortitude Stat
     */
    public void setStatFortitude(int characterFortitude)
    {
        if(characterFortitude < 1)
        {
            throw new IllegalArgumentException("Any Stat of a Hero character cannot be lower or be lowered to less than 1.");
        }
        else
        {
            this.statFortitude = characterFortitude;
        }
    }
    /**
     * Method to return a Hero's Agility Stat
     * @return agility      the character's Agility Stat
     */
    public int getStatAgility()
    {
        return this.statAgility;
    }
    /**
     * Method to set a Hero's Agility Stat
     * @param characterAgility       the character's intended Agility Stat
     */
    public void setStatAgility(int characterAgility)
    {
        if(characterAgility < 1)
        {
            throw new IllegalArgumentException("Any Stat of a Hero character cannot be lower or be lowered to less than 1.");
        }
        else
        {
            this.statAgility = characterAgility;
        }
    }
    /**
     * Method to return a Hero's Perception Stat
     * @return perception   the character's Perception Stat
     */
    public int getStatPerception()
    {
        return this.statPerception;
    }
    /**
     * Method to set a Hero's Perception Stat
     * @param characterPerception    the character's intended Perception Stat
     */
    public void setStatPerception(int characterPerception)
    {
        if(characterPerception < 1)
        {
            throw new IllegalArgumentException("Any Stat of a Hero character cannot be lower or be lowered to less than 1.");
        }
        else
        {
            this.statPerception = characterPerception;
        }
    }
    /**
     * Method to return a Hero's Intelligence Stat
     * @return intelligence     the character's Intelligence Stat
     */
    public int getStatIntelligence()
    {
        return this.statIntelligence;
    }
    /**
     * Method to set a Hero's Intelligence Stat
     * @param characterIntelligence      the character's intended Intelligence Stat
     */
    public void setStatIntelligence(int characterIntelligence)
    {
        if(characterIntelligence < 1)
        {
            throw new IllegalArgumentException("Any Stat of a Hero character cannot be lower or be lowered to less than 1.");
        }
        else
        {
            this.statIntelligence = characterIntelligence;
        }
    }
    /**
     * Method to return a Hero's Charisma Stat
     * @return charisma     the character's Charisma Stat
     */
    public int getStatCharisma()
    {
        return this.statCharisma;
    }
    /**
     * Method to set a Hero's Charisma Stat
     * @param characterCharisma      the character's intended Charisma Stat
     */
    public void setStatCharisma(int characterCharisma)
    {
        if(characterCharisma < 1)
        {
            throw new IllegalArgumentException("Any Stat of a Hero character cannot be lower or be lowered to less than 1.");
        }
        else
        {
            this.statCharisma = characterCharisma;
        }
    }
    /**
     * Method to return a Hero's Luck Stat
     * @return luck     the character's Luck Stat
     */
    public int getStatLuck()
    {
        return this.statLuck;
    }
    /**
     * Method to set a Hero's Luck Stat
     * @param characterLuck      the character's intended Luck Stat
     */
    public void setStatLuck(int characterLuck)
    {
        if(characterLuck < 1)
        {
            throw new IllegalArgumentException("Any Stat of a Hero character cannot be lower or be lowered to less than 1.");
        }
        else
        {
            this.statLuck = characterLuck;
        }
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
     * Method to set a Hero's maximum health point value. A Hero's maximum health points are given a bonus depending on that Hero's Fortitude Stat.
     * @param characterMaxHealth     the character's intended maximum health value, not counting any bonus granted by the character's Fortitude Stat  
     */
    public void setMaxHealthPoints(int characterMaxHealth)
    {
        if(characterMaxHealth < 1)
        {
            throw new IllegalArgumentException("Heroes must have a maximum Health point value of at least 1, before applying modifiers granted by Stats");
        }
        else
        {
            this.maxHealthPoints = characterMaxHealth + (this.statFortitude - 10);
        }
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
    public void setCurrentHealthPoints(int characterCurrentHealth)
    {
        if(characterCurrentHealth < 0)
        {
            characterCurrentHealth = 0; //Heroes' health point values should never be less than zero, and a Hero whose current health is zero is Incapacitated
        }
        this.currentHealthPoints = characterCurrentHealth;
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
     * Method to set a Hero's maximum stamina point value. A Hero's maximum stamina points are given a bonus depending on their Agility Stat.
     * @param characterMaxStamina    the character's intended maximum stamina value, not counting any bonus granted by the Hero's Agility Stat
     */
    public void setMaxStaminaPoints(int characterMaxStamina)
    {
        if(characterMaxStamina < 1)
        {
            throw new IllegalArgumentException("Heroes must have a maximum Stamina point value of at least 1, before applying modifiers granted by Stats");
        }
        else
        {
            this.maxStaminaPoints = characterMaxStamina + (this.statAgility - 10);
        }
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
     * @param characterCurrentStamina    the character's intended current stamina point value
     */
    public void setCurrentStaminaPoints(int characterCurrentStamina)
    {
        if(characterCurrentStamina < 0)
        {
            characterCurrentStamina = 0; //Heroes' Stamina points should never drop below 0, and a Hero with an insufficient amount of Stamina points may not perform actions
        }
        this.currentStaminaPoints = characterCurrentStamina;
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
     * Method to set a Hero's maximum magic point value. A Hero's maximum magic points are given a bonus depending on their Intelligence Stat.
     * @param characterMaxMagic      the character's intended maximum magic point value, not counting any bonus granted by the Hero's Intelligence Stat
     */
    public void setMaxMagicPoints(int characterMaxMagic)
    {
        if(characterMaxMagic < 0) //Magic points are the only Hero resource that have a base value of zero
        {
            throw new IllegalArgumentException("Heroes may not have fewer than zero maximum Magic points.");
        }
        else
        {
            this.maxMagicPoints = characterMaxMagic + (this.statIntelligence - 10);
        }
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
     * @param characterCurrentMagic      the Hero's intended current magic point value
     */
    public void setCurrentMagicPoints(int characterCurrentMagic)
    {
        if(characterCurrentMagic < 0)
        {
            characterCurrentMagic = 0; //Heroes' Magic points should never drop below zero, and a Hero with an insufficient amount of Magic points may not perform magical skills
        }
        this.currentMagicPoints = characterCurrentMagic;
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
     * @param characterWeaponOneName     the String to be entered in weaponSlotOneName
     */
    public void setWeaponSlotOneName(String characterWeaponOneName)
    {
        if(characterWeaponOneName.length() < 1)
        {
            throw new IllegalArgumentException("Names of Hero equipment must be at least one character in length");
        }
        else
        {
            this.weaponSlotOneName = characterWeaponOneName;
        }
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
     * @param characterWeaponTwoName     the String to be entered in weaponSlotTwoName
     */
    public void setWeaponSlotTwoName(String characterWeaponTwoName)
    {
        if(characterWeaponTwoName.length() < 1)
        {
            throw new IllegalArgumentException("Names of Hero equipment must be at least one character in length");
        }
        else
        {
            this.weaponSlotTwoName = characterWeaponTwoName;
        }
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
        System.out.println("Level: " + this.level);
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
        System.out.println("Perception: " + this.statPerception);
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
            System.out.println(this.name + " is a " + this.age + "-year-old " + "Level " + this.level + " " + this.species + " who has yet to find their destiny.");
        }
        else
        {
            System.out.println(this.name + " is a " + this.age + "-year-old " + "Level " + this.level + " " + this.species + " " + this.role + ".");
        }
        System.out.println();
    }
}
