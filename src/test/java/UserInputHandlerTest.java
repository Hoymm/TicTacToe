import gameState.userIO.InputParamsValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserInputHandlerTest {
    private InputParamsValidator inputParamsValidator;

    @BeforeTest
    public void setUp (){
        inputParamsValidator = new InputParamsValidator();
    }

    @Test
    public void isInteger_whenPassIntegerString_shouldReturnTrue (){
        Assert.assertTrue(inputParamsValidator.isInteger("123"));
    }

    @Test
    public void isInteger_whenPassNonIntegerString_shouldReturnFalse (){
        Assert.assertFalse(inputParamsValidator.isInteger("jh43"));
    }

    @Test
    public void isInteger_whenPassEmptyString_shouldReturnFalse (){
        Assert.assertFalse(inputParamsValidator.isInteger(""));
    }


}
