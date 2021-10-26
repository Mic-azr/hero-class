
/**
 * A subclass of Hero representing a character of the Druid role. Similar to the Wizard, the Druid is magically skilled, but draws their power from nature rather than the arcane.
 * The Druid is unique in that they have an animal companion with its own name, species, health value, stamina value, height and weight.
 * @author Michael Cummings
 * @version 10.26.21
 */
public class Druid extends Hero
{
    private String animalCompanionName;
    private String animalCompanionSpecies;
    private int animalCompanionMaxHealthPoints;
    private int animalCompanionCurrentHealthPoints;
    private int animalCompanionMaxStaminaPoints;
    private int animalCompanionCurrentStaminaPoints;
    private double animalCompanionHeight;
    private double animalCompanionWeight;

    /**
     * Constructor for objects of class Druid
     */
    public Druid()
    {
        this.setName("Unknown");
        this.setSpecies("Human");
        this.setAge(37);
        this.setWeight(145);
        this.setHeight(175.26); //converted to centimeters from 5'9"
        this.setRole("Druid");
        this.setLevel(2);
        
        this.setStatIntelligence(this.getStatIntelligence() + 2); //Druids get +2 to their Intelligence and Perception attributes
        this.setStatPerception(this.getStatPerception() + 2);
        
        this.setMaxHealthPoints(BASE_HEALTH);
        this.setCurrentHealthPoints(this.getMaxHealthPoints());
        this.setMaxStaminaPoints(BASE_STAMINA);
        this.setCurrentStaminaPoints(this.getMaxStaminaPoints());
        this.setMaxMagicPoints(BASE_MAGIC);
        this.setCurrentMagicPoints(this.getMaxMagicPoints());
        
        this.setWeaponSlotOneName("Machete");
        this.setWeaponSlotTwoName("Wooden Totem");
        
        this.animalCompanionName = "Wolf";
        this.animalCompanionSpecies = "Wolf";
        this.animalCompanionHeight = 80;
        this.animalCompanionWeight = 90; //Height and weight values taken from https://en.wikipedia.org/wiki/Wolf#Description
        this.animalCompanionMaxHealthPoints = 25; //For the sake of simplicity, companion health and stamina will be 25 and 10 respectively, regardless of the animal's species for now
        this.animalCompanionMaxStaminaPoints = 10;
        this.animalCompanionCurrentHealthPoints = this.animalCompanionMaxHealthPoints;
        this.animalCompanionCurrentStaminaPoints = this.animalCompanionMaxStaminaPoints;
    }

    /**
     * Constructor for Druid objects with user defined parameters. 
     * Has 9 params altogether, so maybe the next place to go with this project is constructing a more robust Main allowing for creation of Heroes through user prompts, that way could split a constructor like this into two sets of prompts, one for the Hero and one for the companion
     * @param name  the character's intended name
     * @param species   the character's intended species
     * @param age   the character's intended age
     * @param weight    the character's intended weight
     * @param height    the character's intended height
     * @param animalName    the animal companion's intended name
     * @param animalSpecies the animal companion's intended species
     * @param animalWeight  the animal companion's intended weight
     * @param animalHeight  the animal companion's intended height
     */
    public Druid(String name, String species, int age, double weight, double height, String animalName, String animalSpecies, double animalWeight, double animalHeight)
    {
        this.setName(name);
        this.setSpecies(species);
        this.setAge(age);
        this.setWeight(weight);
        this.setHeight(height);
        this.setRole("Druid");
        this.setLevel(2);
        
        this.setStatIntelligence(this.getStatIntelligence() + 2); //Druids get +2 to their Intelligence and Perception attributes
        this.setStatPerception(this.getStatPerception() + 2);
        
        this.setMaxHealthPoints(BASE_HEALTH);
        this.setCurrentHealthPoints(this.getMaxHealthPoints());
        this.setMaxStaminaPoints(BASE_STAMINA);
        this.setCurrentStaminaPoints(this.getMaxStaminaPoints());
        this.setMaxMagicPoints(BASE_MAGIC);
        this.setCurrentMagicPoints(this.getMaxMagicPoints());
        
        this.setWeaponSlotOneName("Machete");
        this.setWeaponSlotTwoName("Wooden Totem");
        
        this.animalCompanionName = animalName;
        this.animalCompanionSpecies = animalSpecies;
        this.animalCompanionWeight = animalWeight;
        this.animalCompanionHeight = animalHeight;
        this.animalCompanionMaxHealthPoints = 25;
        this.animalCompanionMaxStaminaPoints = 10;
        this.animalCompanionCurrentHealthPoints = this.animalCompanionMaxHealthPoints;
        this.animalCompanionCurrentStaminaPoints = this.animalCompanionMaxStaminaPoints;
    }
    
    /**
     * Method representing the Druid using their magic to make their skin as hard and thick as a tree trunk, protecting them from damage
     */
    public void treebarkShield()
    {
        int magicPointCost = 1;
        
        if(this.getCurrentMagicPoints() >= magicPointCost)
        {
            this.setCurrentMagicPoints(this.getCurrentMagicPoints() - magicPointCost);
            System.out.println(this.getName() + "'s skin turns hard as tree bark!");
        }
        else
        {
            System.out.println(this.getName() + " doesn't have enough magical focus to do that.");
        }
    }
    
    /**
     * Method representing the Druid using their magic to cause plants and vines to erupt from the ground, slowing enemies and blocking their path.
     */
    public void plantAttack()
    {
        int magicPointCost = 2;
        int staminaPointCost = 10;
        
        if(this.getCurrentMagicPoints() >= magicPointCost && this.getCurrentStaminaPoints() >= staminaPointCost)
        {
            this.setCurrentMagicPoints(this.getCurrentMagicPoints() - magicPointCost);
            this.setCurrentStaminaPoints(this.getCurrentStaminaPoints() - staminaPointCost);
            System.out.println(this.getName() + " closes their eyes in concentration, and suddenly vines explode forth from the ground and ensnare the enemies!");
        }
        else
        {
            System.out.println(this.getName() + " is too tired to do that.");
        }
    }
    
    /**
     * Method representing the animal companion attacking a target
     */
    public void animalCompanionAttack()
    {
        int staminaPointCost = 4;
        
        if (this.animalCompanionCurrentStaminaPoints >= staminaPointCost)
        {
            this.animalCompanionCurrentStaminaPoints = this.animalCompanionCurrentStaminaPoints - staminaPointCost;
            System.out.println(this.animalCompanionName + " the " + this.animalCompanionSpecies + " charges as fast as they can!");
        }
        else 
        {
            System.out.println(this.animalCompanionName + " the " + this.animalCompanionSpecies + " doesn't have enough stamina to do that.");
        }
    }
    
    /**
     * Method representing the animal companion guarding the Druid
     */
    public void animalCompanionDefend()
    {
        int staminaPointCost = 2;
        
        if (this.animalCompanionCurrentStaminaPoints >= staminaPointCost)
        {
            this.animalCompanionCurrentStaminaPoints = this.animalCompanionCurrentStaminaPoints - staminaPointCost;
            System.out.println(this.animalCompanionName + " the " + this.animalCompanionSpecies + " stands close to " + this.getName() + ", ready to protect them!"); 
        }
        else 
        {
            System.out.println(this.animalCompanionName + " the " + this.animalCompanionSpecies + " doesn't have enough stamina to do that.");
        }
    }

    /**
     * Method to print the info for a Druid Hero and their animal companion
     */
    public void getInfo()
    {
        System.out.println("/////////////////////////////");
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Species: " + this.getSpecies());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Height: " + this.getHeight() + " cm");
        System.out.println("Weight: " + this.getWeight() + " lbs");
        System.out.println("Role: " + this.getRole());
        System.out.println("/////////////////////////////");
        
        System.out.println("Health Points: " + this.getCurrentHealthPoints() + " / " + this.getMaxHealthPoints());
        System.out.println("Stamina Points: " + this.getCurrentStaminaPoints() + " / " + this.getMaxStaminaPoints());
        System.out.println("Magic Points: " + this.getCurrentMagicPoints() + " / " + this.getMaxMagicPoints());
        System.out.println("/////////////////////////////");
        
        System.out.println("Animal Companion: " + this.animalCompanionName + " the " + this.animalCompanionSpecies);
        System.out.println("Health Points: " + this.animalCompanionCurrentHealthPoints + " / " + this.animalCompanionMaxHealthPoints);
        System.out.println("Stamina Points: " + this.animalCompanionCurrentStaminaPoints + " / " +  this.animalCompanionMaxStaminaPoints);
        System.out.println("/////////////////////////////");
        
        System.out.println("Weapon 1: " + this.getWeaponSlotOneName());
        System.out.println("Weapon 2: " + this.getWeaponSlotTwoName());
        System.out.println("/////////////////////////////");
        
        System.out.println("Strength: " + this.getStatStrength());
        System.out.println("Dexterity: " + this.getStatDexterity());
        System.out.println("Fortitude: " + this.getStatFortitude());
        System.out.println("Agility: " + this.getStatAgility());
        System.out.println("Perception: " + this.getStatPerception());
        System.out.println("Intelligence: " + this.getStatIntelligence());
        System.out.println("Charisma: " + this.getStatCharisma());
        System.out.println("Luck: " + this.getStatLuck());
        System.out.println("/////////////////////////////");
        System.out.println();
    }
    
    public void getInfoSimple()
    {
        System.out.println(this.getName() + " is a " + this.getAge() + "-year-old " + "Level " + this.getLevel() + " " + this.getSpecies() + " " + this.getRole() + ". Their animal companion is " + this.animalCompanionName + " the " + this.animalCompanionSpecies + ".");
        System.out.println();
    }
}
