
/**
 * A subclass of Hero representing a character of the Thief role
 *
 * @author Michael Cummings
 * @version 10.24.21
 */
public class Thief extends Hero
{
    /**
     * Constructor for objects of class Thief
     */
    public Thief()
    {
        this.setName("Unknown");
        this.setSpecies("Human");
        this.setAge(21);
        this.setWeight(150);
        this.setHeight(167.64); //converted from 5'6" to centimeters
        this.setRole("Thief");
        
        this.setStatAgility(this.getStatAgility() + 2); //Thieves get +2 to their Agility and Charisma attributes
        this.setStatCharisma(this.getStatCharisma() + 2);
        
        this.setMaxHealthPoints(BASE_HEALTH);
        this.setCurrentHealthPoints(this.getMaxHealthPoints());
        this.setMaxStaminaPoints(BASE_STAMINA);
        this.setCurrentStaminaPoints(this.getMaxStaminaPoints());
        this.setMaxMagicPoints(BASE_MAGIC);
        this.setCurrentMagicPoints(this.getMaxMagicPoints());
        
        this.setWeaponSlotOneName("Dagger");
        this.setWeaponSlotTwoName("Smoke Bomb");
    }
    
    /**
     * Constructor for Thief objects with user defined parameters
     * @param name  the character's name
     * @param species   the character's species
     * @param age   the character's age in years
     * @param weight    the character's weight in pounds
     * @param height    the character's height in centimeters
     */
    public Thief(String name, String species, int age, double weight, double height)
    {
        this.setName(name);
        this.setSpecies(species);
        this.setAge(age);
        this.setWeight(weight);
        this.setHeight(height);
        this.setRole("Thief");
        
        this.setStatAgility(this.getStatAgility() + 2); //Thieves get +2 to their Agility and Charisma attributes
        this.setStatCharisma(this.getStatCharisma() + 2);
        
        this.setMaxHealthPoints(BASE_HEALTH);
        this.setCurrentHealthPoints(this.getMaxHealthPoints());
        this.setMaxStaminaPoints(BASE_STAMINA);
        this.setCurrentStaminaPoints(this.getMaxStaminaPoints());
        this.setMaxMagicPoints(BASE_MAGIC);
        this.setCurrentMagicPoints(this.getMaxMagicPoints());
        
        this.setWeaponSlotOneName("Dagger");
        this.setWeaponSlotTwoName("Smoke Bomb");
    }

    /**
     * Method representing the Thief utilizing a lockpick. This action would cost 2 stamina points.
     */
    public void useLockpick()
    {
        int staminaPointCost = 2;
        if (this.getCurrentStaminaPoints() >= staminaPointCost)
        {
            this.setCurrentStaminaPoints(this.getCurrentStaminaPoints() - staminaPointCost);
            System.out.println(this.getName() + " attempts to pick the lock.");
        }
        else
        {
            System.out.println(this.getName() + " doesn't have enough stamina to do that.");
        }
    }
    
    /**
     * Method representing the Thief deploying a smoke bomb. This action would cost 5 stamina points.
     */
    public void throwSmokeBomb()
    {
        int staminaPointCost = 5;
        if (this.getCurrentStaminaPoints() >= 5)
        {
            this.setCurrentStaminaPoints(this.getCurrentStaminaPoints() - staminaPointCost);
            System.out.println(this.getName() + " throws a smoke bomb at their feet, and they disappear into a cloud of dark, choking gas!");
        }
        else
        {
            System.out.println(this.getName() + " doesn't have enough stamina to do that.");
        }
    }
}
