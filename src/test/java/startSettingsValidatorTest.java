import gameState.userIO.startSettingsInput.StartSettingsValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class startSettingsValidatorTest {
    private StartSettingsValidator startSettingsValidator;
    @BeforeTest
    public void setUp (){
        startSettingsValidator = new StartSettingsValidator();
    }

    @Test
    public void validateTableParamInserted_insertValueHigherThanMax_shouldResultInFalse() {
        // given
        String inputHigherThanMax = String.valueOf(StartSettingsValidator.MAX_BOARD_SIZE+1);
        // when
        boolean validateTableParamHigherThanMax = startSettingsValidator.isTableParamVaild(inputHigherThanMax);
        // then
        assertFalse(validateTableParamHigherThanMax);
    }

    @Test
    public void validateTableParamInserted_insertMax_shouldReturnTrue() {
        // given
        String inputMaxValue = String.valueOf(StartSettingsValidator.MAX_BOARD_SIZE);
        // when
        boolean validateTableParamLesserThanMax = startSettingsValidator.isTableParamVaild(inputMaxValue);
        // then
        assertTrue(validateTableParamLesserThanMax);
    }

    @Test
    public void validateTableParamInserted_insertValueLesserThan3_shouldResultInFalse() {
        // given
        String inputLowerThanMin = String.valueOf(StartSettingsValidator.MIN_BOARD_SIZE-1);
        // when
        boolean validateTableParamLesserThanMin = startSettingsValidator.isTableParamVaild(inputLowerThanMin);
        // then
        assertFalse(validateTableParamLesserThanMin);
    }

    @Test
    public void validateTableParamInserted_insertTextInsteadOfInteger_shouldResultInFalse() {
        // given
        // when

        boolean invalidTableParam = startSettingsValidator.isTableParamVaild("tekstksaf");
        // then
        assertFalse(invalidTableParam);
    }

    @Test
    public void validateSymbolInsertedViaPlayer_insertOSymbol_shouldReturnTrue(){
        // given
        // when
        boolean symbolOShouldByValidatedAsTrue = startSettingsValidator.isValidSymbol("O");
        // then
        assertTrue(symbolOShouldByValidatedAsTrue);
    }

    @Test
    public void validateSymbolInsertedViaPlayer_insertOSymbolWithWhiteChars_shouldReturnTrue(){
        // given
        // when
        boolean symbolOShouldByValidatedAsTrue = startSettingsValidator.isValidSymbol("         O   \t \n ");
        // then
        assertTrue(symbolOShouldByValidatedAsTrue);
    }

    @Test
    public void validateSymbolInsertedViaPlayer_insertXSymbol_shouldReturnTrue(){
        // given
        // when
        boolean symbolXShouldByValidatedAsTrue = startSettingsValidator.isValidSymbol("X");
        // then
        assertTrue(symbolXShouldByValidatedAsTrue);
    }

    @Test
    public void validateSymbolInsertedViaPlayerWithWhiteChars_insertXSymbol_shouldReturnTrue(){
        // given
        // when
        boolean symbolXShouldByValidatedAsTrue = startSettingsValidator.isValidSymbol("              X         ");
        // then
        assertTrue(symbolXShouldByValidatedAsTrue);
    }

    @Test
    public void validateSymbolInsertedViaPlayer_insertUSymbol_shouldReturnFalse(){
        // given
        String wrongSymbol = "U";
        // when
        boolean wrongSymbolValidateShouldReturnFalse = startSettingsValidator.isValidSymbol(wrongSymbol);
        // then
        assertFalse(wrongSymbolValidateShouldReturnFalse);
    }

    @Test
    public void validateFieldNumber_insertNegativeNumber_shouldReturnFalse(){
        // given
        String negativeNumber = "-1";
        // when
        boolean negativeNumberShouldReturnFalse = startSettingsValidator.isTableParamVaild(negativeNumber);
        // then
        assertFalse(negativeNumberShouldReturnFalse);
    }

    @Test
    public void validateFieldNumber_insertZeroNumber_shouldReturnFalse(){
        // given
        String negativeNumber = "0";
        // when
        boolean zeroBoardFieldShouldReturnFalse = startSettingsValidator.isTableParamVaild(negativeNumber);
        // then
        assertFalse(zeroBoardFieldShouldReturnFalse);
    }
}
