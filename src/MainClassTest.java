import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {

    @Test
    public void testGetLocalNumber() {

        this.getLocalNumber();
        Assert.assertTrue("getLocalNumber = 14", getLocalNumber() == 14);
    }

}
