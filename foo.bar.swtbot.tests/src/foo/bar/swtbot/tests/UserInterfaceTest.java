package foo.bar.swtbot.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.junit.Test;

public class UserInterfaceTest {
    private final SWTWorkbenchBot bot = new SWTWorkbenchBot();

    @Test
    public void test() {
        // now lets find a view part
        SWTBotView viewById = bot.viewById("foo.bar.swtbot.app.view");
        assertNotNull(viewById);
        
        // find the text after the label "My Label"
        SWTBotText textWithLabel = bot.textWithLabel("My Label");
        // Set the focus and write a text into the text field
        textWithLabel.setFocus();
        assertEquals("This is my text", textWithLabel.getText());
        textWithLabel.selectAll();
        textWithLabel.typeText("Java rules them all");
        assertEquals("Java rules them all", textWithLabel.getText());

        // find the text with with the assigned id
        SWTBotText textWithId = bot.textWithId("text1");
        assertEquals("This text has an ID", textWithId.getText());
    }
}

