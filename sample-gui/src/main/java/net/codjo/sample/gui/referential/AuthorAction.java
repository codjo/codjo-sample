package net.codjo.sample.gui.referential;
import javax.swing.JInternalFrame;
import net.codjo.mad.gui.framework.AbstractAction;
import net.codjo.mad.gui.framework.GuiContext;
import net.codjo.mad.gui.framework.SimpleListLogic;
/**
 *
 */
public class AuthorAction extends AbstractAction {
    private static final String LABEL = "Artistes";


    public AuthorAction(GuiContext guiContext) {
        super(guiContext, LABEL, "Liste les artistes");
    }


    @Override
    protected JInternalFrame buildFrame(GuiContext guiContext)
          throws Exception {
        return new SimpleListLogic(guiContext, LABEL, "AuthorList").getGui();
    }
}

