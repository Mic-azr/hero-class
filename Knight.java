
/**
 * A subclass of Hero representing a character of the Knight role
 *
 * @author Michael Cummings
 * @version 10.26.21
 */
public class Knight extends Hero
{
    /**
     * Constructor for objects of class Knight
     */
    public Knight()
    {
        this.setName("Unknown");
        this.setSpecies("Human");
        this.setAge(21);
        this.setWeight(185); //Weight in pounds
        this.setHeight(190); //Height in centimeters, converted from 6'3"
        this.setRole("Knight");
        this.setLevel(2); //TODO: Write get / set for level, and levelUp method
        
        this.setStatStrength(this.getStatStrength() + 2); //Knights get a +2 bonus to Strength and Fortitude
        this.setStatFortitude(this.getStatFortitude() + 2);
        
        this.setMaxHealthPoints(BASE_HEALTH);
        this.setCurrentHealthPoints(this.getMaxHealthPoints());
        this.setMaxStaminaPoints(BASE_STAMINA);
        this.setCurrentStaminaPoints(this.getMaxStaminaPoints());
        this.setMaxMagicPoints(BASE_MAGIC);
        this.setCurrentMagicPoints(this.getMaxMagicPoints());
        
        this.setWeaponSlotOneName("Sword"); //Knight class default weapons are a sword and shield
        this.setWeaponSlotTwoName("Shield");
    }
    /**
     * Constructor for Knight objects with user defined parameters
     * @param name  the character's name
     * @param species   the character's species
     * @param age   the character's age in years
     * @param weight    the character's weight in pounds
     * @param height    the character's height in centimeters
     */
    public Knight(String name, String species, int age, double weight, double height)
    {
        this.setName(name);
        this.setSpecies(species);
        this.setAge(age);
        this.setWeight(weight);
        this.setHeight(height);
        this.setRole("Knight");
        this.setLevel(2);
        
        this.setStatStrength(this.getStatStrength() + 2); //Knights get a +2 bonus to Strength and Fortitude
        this.setStatFortitude(this.getStatFortitude() + 2);
        
        this.setMaxHealthPoints(BASE_HEALTH);
        this.setCurrentHealthPoints(this.getMaxHealthPoints());
        this.setMaxStaminaPoints(BASE_STAMINA);
        this.setCurrentStaminaPoints(this.getMaxStaminaPoints());
        this.setMaxMagicPoints(BASE_MAGIC);
        this.setCurrentMagicPoints(this.getMaxMagicPoints());
        
        this.setWeaponSlotOneName("Sword"); //Knight class default weapons are a sword and shield
        this.setWeaponSlotTwoName("Shield");
    }

    /**
     * Method representing the Knight charging forward with their sword. This action would cost the Knight 10 stamina points
     */
    public void charge()
    {
        int staminaPointCost = 10;
        if(this.getCurrentStaminaPoints() >= staminaPointCost)
        {
            this.setCurrentStaminaPoints(this.getCurrentStaminaPoints() - staminaPointCost);
            System.out.println(this.getName() + " raises their " + this.getWeaponSlotOneName() + " and charges forward!");
        }
        else
        {
            System.out.println(this.getName() + " doesn't have enough stamina to do that.");
        }
    }
    
    /**
     * Method representing the Knight raising their shield to defend against an attack. This action would cost the Knight 5 stamina points
     */
    public void shieldBlock()
    {
        int staminaPointCost = 5;
        if(this.getCurrentStaminaPoints() >= staminaPointCost)
        {
            this.setCurrentStaminaPoints(this.getCurrentStaminaPoints() - staminaPointCost);
            System.out.println(this.getName() + " holds their " + this.getWeaponSlotTwoName() + " up and braces themselves!");
        }
        else
        {
            System.out.println(this.getName() + " doesn't have enough stamina to do that.");
        }
    }
}
