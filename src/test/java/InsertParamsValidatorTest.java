import UserIO.InputCannotBeEmptyException;
import UserIO.InputParams;
import UserIO.InputParamsValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

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
        assertTrue(isNameCorrect);
    }

    @Test
    public void validateNameInserted_nameContainingAnyOtherSignsThanLetters_shouldReturnFalse() throws InputCannotBeEmptyException {
        // given
        // when

        boolean validateNameWithSpecialSign = inputParamsValidator.validateInsertedName(String.format("%s%c%s", "Anna", InputParams.SEPARATOR, "Beata"));
        // then
        assertFalse(validateNameWithSpecialSign);
    }

    @Test
    public void validateTableParamInserted_insertValue5_shouldResultInTrue() {
        // given
        // when

        boolean validateTableParamLesserThan2 = inputParamsValidator.isTableParamVaild("5");
        // then
        assertTrue(validateTableParamLesserThan2);
    }

    @Test
    public void validateTableParamInserted_insertValueLesserThan3_shouldResultInFalse() {
        // given
        // when

        boolean validateTableParamLesserThan2 = inputParamsValidator.isTableParamVaild("2");
        // then
        assertFalse(validateTableParamLesserThan2);
    }

    @Test
    public void validateTableParamInserted_insertTextInsteadOfInteger_shouldResultInFalse() {
        // given
        // when

        boolean validateTableParamLesserThan2 = inputParamsValidator.isTableParamVaild("tekstksaf");
        // then
        assertFalse(validateTableParamLesserThan2);
    }
}
