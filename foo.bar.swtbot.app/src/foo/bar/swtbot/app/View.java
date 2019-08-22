package foo.bar.swtbot.app;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
    public static final String ID = "foo.bar.swtbot.app.view";

    @Inject
    IWorkbench workbench;

    private class StringLabelProvider extends ColumnLabelProvider {
        @Override
        public String getText(Object element) {
            return super.getText(element);
        }

        @Override
        public Image getImage(Object obj) {
            return workbench.getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
        }

    }

    @Override
    public void createPartControl(Composite parent) {
        Label label = new Label(parent, SWT.NONE);
        label.setText("My Label");
        Text text = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
        text.setText("This is my text");

        // Define another text field but also assign an ID to this field for SWTBot
        text = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
        text.setText("This text has an ID");
        text.setData("org.eclipse.swtbot.widget.key", "text1");
    }

    @Override
    public void setFocus() {
    }

}