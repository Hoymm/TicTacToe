import UserIO.InputParams;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Scanner;

public class InputParamsTest {
    InputParams inputParams;

    @BeforeTest
    public void setUp (){
        inputParams = new InputParams(new Scanner(System.in));
    }

    @Test
    public void isInteger_whenPassIntegerString_shouldReturnTrue (){
        Assert.assertTrue(inputParams.isInteger("123"));
    }

    @Test
    public void isInteger_whenPassNonIntegerString_shouldReturnFalse (){
        Assert.assertFalse(inputParams.isInteger("jh43"));
    }

    @Test
    public void isInteger_whenPassEmptyString_shouldReturnFalse (){
        Assert.assertFalse(inputParams.isInteger(""));
    }
}
