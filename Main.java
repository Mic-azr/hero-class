
/**
 * Driver program for Hero class and subclasses
 *
 * @author Michael Cummings
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
        Hero character1 = new Hero();
        character1.getInfoSimple();
        
        Hero character2 = new Hero("Madeline", "Elf", 24, 135.0, 165);
        character2.getInfo();
        
        Knight character3 = new Knight("Steve", "Dwarf", 36, 210, 95);
        character3.getInfo();
        character3.getInfoSimple();
        character3.charge();
    }
}
