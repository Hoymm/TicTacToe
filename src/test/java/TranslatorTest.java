import messenger.MessageKeys;
import messenger.Translator;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class TranslatorTest {
    private Translator translator;

    @Test
    public void englishHelloKey_givesHelloInEnglish() {
        // given
        translator = new Translator(Locale.ENGLISH);
        // when
        assertEquals(translator.getMessage(MessageKeys.hello), "hello");
        // then
    }

    @Test
    public void polishHelloKey_givesHelloInPolish() {
        // given
        translator = new Translator(new Locale("pl", "PL"));
        // when
        assertEquals(translator.getMessage(MessageKeys.hello), "czesc");
        // then
    }
}
