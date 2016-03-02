package tests;

import org.junit.Test;
import ro.vdruta.models.characters.Elf;
import org.junit.Assert;


/**
 * Created by MM on 2016-03-02.
 */
public class ElfTest {
    @Test
    public void testElfHealtg() {
        Elf elf = new Elf("elfy", 1);

        Assert.assertEquals(elf.getHealth(), 1705);
        Assert.assertEquals(elf.getHealth(), 1706);
    }
    @Test
    public void testElfLevel() {
        Elf elf = new Elf("elfy", 1);

        Assert.assertEquals(elf.getLevel(), 1);
        Assert.assertEquals(elf.getLevel(), 2);
    }

}