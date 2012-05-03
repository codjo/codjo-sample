package net.codjo.sample.gui.referential;
import net.codjo.gui.toolkit.number.NumberField;
import net.codjo.gui.toolkit.text.TextField;
import net.codjo.mad.gui.framework.AbstractDetailGui;
import net.codjo.mad.gui.request.DetailDataSource;
/**
 *
 */
public class WithIdentityDetailGui extends AbstractDetailGui {
    private NumberField idField;
    private TextField nameField;


    WithIdentityDetailGui() {
        super("WithIdentity");
    }


    @Override
    protected void buildAndAddItems() {
        idField = new NumberField();
        itemPanel.addItem("Id de type identity", idField);

        nameField = new TextField();
        nameField.setMaxTextLength(300);
        itemPanel.addItem("Name", nameField);
    }


    @Override
    public void declareFields(DetailDataSource dataSource) {
        dataSource.declare("idTypeIdentity", idField);
        dataSource.declare("name", nameField);
    }


    @Override
    public void switchToUpdateMode() {
        idField.setEnabled(false);
    }
}
