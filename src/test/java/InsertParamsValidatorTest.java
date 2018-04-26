import UserIO.InputCannotBeEmptyException;
import UserIO.InputParamsValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InsertParamsValidatorTest {
    private InputParamsValidator inputParamsValidator;
    @BeforeTest
    public void setUp (){
        inputParamsValidator = new InputParamsValidator();
    }

    @Test (expectedExceptions = InputCannotBeEmptyException.class)
    public void validateNameInserted_whenIsEmpty_shouldThrowInputCannotBeEmptyException() throws InputCannotBeEmptyException {
        inputParamsValidator.validateInsertedName("");
    }

    @Test
    public void validateNameInserted_nameAnna_shouldReturnTrue() throws InputCannotBeEmptyException {
        // given
        // when
        boolean isNameCorrect = inputParamsValidator.validateInsertedName("Anna");
        // then
        Assert.assertTrue(isNameCorrect);
    }
}
