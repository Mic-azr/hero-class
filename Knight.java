
/**
 * A subclass of Hero representing a character of the Knight class
 *
 * @author Michael Cummings
 * @version 10.23.21
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
     * @param name
     * @param species
     * @param age
     * @param weight
     * @param height
     */
    public Knight(String name, String species, int age, double weight, double height)
    {
        this.setName(name);
        this.setSpecies(species);
        this.setAge(age);
        this.setWeight(weight);
        this.setHeight(height);
        this.setRole("Knight");
        
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
     * Method representing the Knight charging forward with their sword
     */
    public void charge()
    {
        System.out.println(this.getName() + " raises their " + this.getWeaponSlotOneName() + " and charges forward!");
    }
    
    /**
     * Method representing the Knight raising their shield to defend against an attack
     */
    public void shieldBlock()
    {
        System.out.println(this.getName() + " holds their " + this.getWeaponSlotTwoName() + " up and braces themselves!");
    }
}
