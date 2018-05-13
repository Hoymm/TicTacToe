import gameState.userIO.InputParamsValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class InsertParamsValidatorTest {
    private InputParamsValidator inputParamsValidator;
    @BeforeTest
    public void setUp (){
        inputParamsValidator = new InputParamsValidator();
    }

    @Test
    public void validateTableParamInserted_insertValueHigherThan50_shouldResultInFalse() {
        // given
        // when

        boolean validateTableParamHigherThan50 = inputParamsValidator.isTableParamVaild("51");
        // then
        assertFalse(validateTableParamHigherThan50);
    }

    @Test
    public void validateTableParamInserted_insertValueSmallerThan51_shouldResultInTrue() {
        // given
        // when

        boolean validateTableParamLesserThan50 = inputParamsValidator.isTableParamVaild("50");
        // then
        assertTrue(validateTableParamLesserThan50);
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

    @Test
    public void validateSymbolInsertedViaPlayer_insertOSymbol_shouldReturnTrue(){
        // given
        // when
        boolean symbolOShouldByValidatedAsTrue = inputParamsValidator.isValidSymbol("O");
        // then
        assertTrue(symbolOShouldByValidatedAsTrue);
    }

    @Test
    public void validateSymbolInsertedViaPlayer_insertOSymbolWithWhiteChars_shouldReturnTrue(){
        // given
        // when
        boolean symbolOShouldByValidatedAsTrue = inputParamsValidator.isValidSymbol("         O   \t \n ");
        // then
        assertTrue(symbolOShouldByValidatedAsTrue);
    }

    @Test
    public void validateSymbolInsertedViaPlayer_insertXSymbol_shouldReturnTrue(){
        // given
        // when
        boolean symbolXShouldByValidatedAsTrue = inputParamsValidator.isValidSymbol("X");
        // then
        assertTrue(symbolXShouldByValidatedAsTrue);
    }

    @Test
    public void validateSymbolInsertedViaPlayerWithWhiteChars_insertXSymbol_shouldReturnTrue(){
        // given
        // when
        boolean symbolXShouldByValidatedAsTrue = inputParamsValidator.isValidSymbol("              X         ");
        // then
        assertTrue(symbolXShouldByValidatedAsTrue);
    }

    @Test
    public void validateSymbolInsertedViaPlayer_insertUSymbol_shouldReturnFalse(){
        // given
        String wrongSymbol = "U";
        // when
        boolean wrongSymbolValidateShouldReturnFalse = inputParamsValidator.isValidSymbol(wrongSymbol);
        // then
        assertFalse(wrongSymbolValidateShouldReturnFalse);
    }

    @Test
    public void validateFieldNumber_insertNegativeNumber_shouldReturnFalse(){
        // given
        String negativeNumber = "-1";
        // when
        boolean negativeNumberShouldReturnFalse = inputParamsValidator.isVaildBoardField(negativeNumber);
        // then
        assertFalse(negativeNumberShouldReturnFalse);
    }

    @Test
    public void validateFieldNumber_insertZeroNumber_shouldReturnFalse(){
        // given
        String negativeNumber = "0";
        // when
        boolean zeroBoardFieldShouldReturnFalse = inputParamsValidator.isVaildBoardField(negativeNumber);
        // then
        assertFalse(zeroBoardFieldShouldReturnFalse);
    }

    @Test
    public void validateFieldNumber_insertPossitiveNumber_shouldReturnTrue(){
        // given
        String possitiveNumber = "1";
        // when
        boolean boardFieldOfValueOneShouldBeValidatedAsTrue = inputParamsValidator.isVaildBoardField(possitiveNumber);
        // then
        assertTrue(boardFieldOfValueOneShouldBeValidatedAsTrue);
    }

    @Test
    public void validateFieldNumber_insertNonNumberValue_shouldReturnFalse(){
        // given
        String possitiveNumber = "abc";
        // when
        boolean boardFieldOfValueOneShouldBeValidatedAsTrue = inputParamsValidator.isVaildBoardField(possitiveNumber);
        // then
        assertFalse(boardFieldOfValueOneShouldBeValidatedAsTrue);
    }

    @Test
    public void is123APossitiveIntegerAndGreaterEqualTo3_shouldReturnTrue() {
        assertTrue(inputParamsValidator.isItIntegerAndGraterOrEqualTo("123", 3));
    }

    @Test
    public void is2APossitiveIntegerAndGreaterEqualTo3_shouldReturnFalse() {
        assertFalse(inputParamsValidator.isItIntegerAndGraterOrEqualTo("2", 3));
    }

    @Test
    public void isNegative232APossitiveIntegerAndGreaterEqualTo3_shouldReturnFalse() {
        assertFalse(inputParamsValidator.isItIntegerAndGraterOrEqualTo("-232", 3));
    }

    @Test
    public void isNegative4APossitiveIntegerAndGreaterEqualTo4_shouldReturnTrue() {
        assertTrue(inputParamsValidator.isItIntegerAndGraterOrEqualTo("4", 4));
    }

    @Test
    public void isNegative4APossitiveIntegerAndGreaterEqualTo5_shouldReturnFalse() {
        assertFalse(inputParamsValidator.isItIntegerAndGraterOrEqualTo("4", 5));
    }
}
