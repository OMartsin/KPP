import martin.dev.TextManipulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextManipulatorTest {

    private final TextManipulator textManipulator = new TextManipulator();

    @Test
    public void TestRemoveWorldsByLengthWithConsonantEmptyString(){
        String text = "";
        String result = textManipulator.removeWorldsByLengthWithConsonant(text, 5);
        assert result.equals("");
    }

    @Test
    public void TestRemoveWorldsByLengthWithConsonantNullString(){
        String text = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String result = textManipulator.removeWorldsByLengthWithConsonant(text, 5);
        });
    }
    @Test
    public void TestRemoveWorldsByLengthWithConsonantBigWorld(){
        String text = "Hello World, this is a test";
        String result = textManipulator.removeWorldsByLengthWithConsonant(text, 5);
        assert result.equals("Hello this is a test");
    }

    @Test
    public void TestRemoveWorldsByLengthWithConsonantAllBigWorlds(){
        String text = "Hello World, this test";
        String result = textManipulator.removeWorldsByLengthWithConsonant(text, 1);
        assert result.equals("");
    }

    @Test
    public void TestRemoveWorldsByLengthWithConsonantWithoutBigWords(){
        String text = "Hello World, this is a test";
        String result = textManipulator.removeWorldsByLengthWithConsonant(text, 6);
        assert result.equals("Hello World, this is a test");
    }

    @Test
    public void TestGetCapitalWordGroupsEmptyString(){
        String text = "";
        var result = textManipulator.getCapitalWordGroups(text);
        assert result.size() == 0;
    }

    @Test
    public void TestGetCapitalWordGroupsNullString(){
        String text = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            var result = textManipulator.getCapitalWordGroups(text);
        });
    }

    @Test
    public void TestGetCapitalWordGroupsWithoutCapitalWord(){
        String text = "hello";
        var result = textManipulator.getCapitalWordGroups(text);
        assert result.size() == 0 ;
    }

    @Test
    public void TestGetCapitalWordGroupsOneCapitalWord(){
        String text = "Hello";
        var result = textManipulator.getCapitalWordGroups(text);
        assert result.size() == 1 && result.get(0).equals("Hello");
    }

    @Test
    public void TestGetCapitalWordGroupsTwoCapitalWords(){
        String text = "Hello World";
        var result = textManipulator.getCapitalWordGroups(text);
        assert result.size() == 1 && result.get(0).equals("Hello World");
    }

    @Test
    public void TestGetCapitalWordGroupsFourCapitalWords(){
        String text = "Hello World, This is a Test";
        var result = textManipulator.getCapitalWordGroups(text);
        textManipulator.PrintWorldsGroups(result);
        assert result.size() == 2 && result.get(0).equals("Hello World, This") && result.get(1).equals("Test");
    }

}
