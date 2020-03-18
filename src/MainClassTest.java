import org.junit.Assert;
import org.junit.Test;


public class MainClassTest extends MainClass {

    @Test
    public void testGetLocalNumber() {
        this.getLocalNumber();
        Assert.assertTrue("getLocalNumber = 14", getLocalNumber() == 14);
    }

    @Test
    public void testGetClassNumber(){
        int a = this.gotClassNumber();
        if (a > 45){
            System.out.println("True");
        } else {
            System.out.println("Fail");
        }

    }


    @Test
    public void testGetClassString() {
        String a = this.getClassString();
        String firstWord = a.substring(0, 5);


        if (firstWord.contains("Hello")){
            System.out.println("В тексте первое слово \"Hello\"");
        } else if (firstWord.contains("hello")) {
            System.out.println("В тексте первое слово \"hello\"");
        } else {
            Assert.assertTrue("Первое слово отличается от \"Hello\" или \"hello\"",  firstWord == "hello" ^ firstWord =="Hello");
        }

    }
}
