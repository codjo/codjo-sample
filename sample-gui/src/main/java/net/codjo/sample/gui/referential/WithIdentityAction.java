package net.codjo.sample.gui.referential;
import javax.swing.JInternalFrame;
import net.codjo.mad.gui.framework.AbstractAction;
import net.codjo.mad.gui.framework.GuiContext;
import net.codjo.mad.gui.framework.SimpleListLogic;
/**
 *
 */
public class WithIdentityAction extends AbstractAction {
    private static final String LABEL = "With Identity";


    public WithIdentityAction(GuiContext guiContext) {
        super(guiContext, LABEL, "Liste les ref with identity");
    }


    @Override
    protected JInternalFrame buildFrame(GuiContext guiContext)
          throws Exception {
        return new SimpleListLogic(guiContext, LABEL, "WithIdentityList").getGui();
    }
}

