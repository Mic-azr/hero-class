
/**
 * A subclass of Hero representing a character of the Wizard role
 *
 * @author Michael Cummings
 * @version 10.24.21
 */
public class Wizard extends Hero
{
    /**
     * Constructor for objects of class Wizard
     */
    public Wizard()
    {
        this.setName("Unknown");
        this.setSpecies("Human");
        this.setAge(53);
        this.setWeight(130);
        this.setHeight(180.33); //converted from 5'11" to centimeters
        this.setRole("Wizard");
        this.setLevel(2);
        
        this.setStatIntelligence(this.getStatIntelligence() + 2); //Wizards get a +2 bonus to their Intelligence and Luck attributes
        this.setStatLuck(this.getStatLuck() + 2);
        
        this.setMaxHealthPoints(BASE_HEALTH);
        this.setCurrentHealthPoints(this.getMaxHealthPoints());
        this.setMaxStaminaPoints(BASE_STAMINA);
        this.setCurrentStaminaPoints(this.getMaxStaminaPoints());
        this.setMaxMagicPoints(BASE_MAGIC);
        this.setCurrentMagicPoints(this.getMaxMagicPoints());
        
        this.setWeaponSlotOneName("Enchanted Staff");
        this.setWeaponSlotTwoName("Spellbook");
    }
    
    /**
     * Constructor for Wizard objects with user defined parameters
     * @param name  the character's name
     * @param species   the character's species
     * @param age   the character's age in years
     * @param weight    the character's weight in pounds
     * @param height    the character's height in centimeters
     */
    public Wizard(String name, String species, int age, double weight, double height)
    {
        this.setName(name);
        this.setSpecies(species);
        this.setAge(age);
        this.setWeight(weight);
        this.setHeight(height);
        this.setRole("Wizard");
        this.setLevel(2);
        
        this.setStatIntelligence(this.getStatIntelligence() + 2); //Wizards get a +2 bonus to their Intelligence and Luck attributes
        this.setStatLuck(this.getStatLuck() + 2);
        
        this.setMaxHealthPoints(BASE_HEALTH);
        this.setCurrentHealthPoints(this.getMaxHealthPoints());
        this.setMaxStaminaPoints(BASE_STAMINA);
        this.setCurrentStaminaPoints(this.getMaxStaminaPoints());
        this.setMaxMagicPoints(BASE_MAGIC);
        this.setCurrentMagicPoints(this.getMaxMagicPoints());
        
        this.setWeaponSlotOneName("Enchanted Staff");
        this.setWeaponSlotTwoName("Spellbook");
    }
    
    /**
     * Method representing the Wizard casting a magical lightning bolt. This action would cost 1 magic point.
     */
    public void castLightningBolt()
    {
        int magicPointCost = 1;
        if (this.getCurrentMagicPoints() >= magicPointCost)
        {
            this.setCurrentMagicPoints(this.getCurrentMagicPoints() - magicPointCost);
            System.out.println("An arc of bright blue electricity shoots forth from " + this.getName() + "'s " + this.getWeaponSlotOneName() + "!");
        }
        else
        {
            System.out.println(this.getName() + " doesn't have enough magical focus to do that.");
        }
    }
    
    /**
     * Method representing the Wizard performing a spell to summon a monster. This action would cost 2 magic points.
     */
    public void summonMonster()
    {
        int magicPointCost = 2;
        if (this.getCurrentMagicPoints() >= magicPointCost)
        {
            this.setCurrentMagicPoints(this.getCurrentMagicPoints() - magicPointCost);
            System.out.println(this.getName() + " recites an incantation from their " + this.getWeaponSlotTwoName() + ", and a monster appears in a flash of blue fire!");
        }
        else
        {
            System.out.println(this.getName() + " doesn't have enough magical focus to do that.");
        }
    }
}
