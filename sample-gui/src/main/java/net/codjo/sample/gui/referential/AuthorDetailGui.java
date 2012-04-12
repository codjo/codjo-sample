package net.codjo.sample.gui.referential;
import net.codjo.gui.toolkit.text.TextField;
import net.codjo.mad.gui.framework.AbstractDetailGui;
import net.codjo.mad.gui.request.DetailDataSource;
/**
 *
 */
public class AuthorDetailGui extends AbstractDetailGui {
    private TextField authorField;
    private TextField biographiyField;


    AuthorDetailGui() {
        super("Auteurs/Artistes");
    }


    @Override
    protected void buildAndAddItems() {
        authorField = new TextField();
        authorField.setMaxTextLength(150);
        itemPanel.addItem("Auteur", authorField);

        biographiyField = new TextField();
        authorField.setMaxTextLength(300);
        itemPanel.addItem("Biographie", biographiyField);
    }


    @Override
    public void declareFields(DetailDataSource dataSource) {
        dataSource.declare("author", authorField);
        dataSource.declare("biography", biographiyField);
    }


    @Override
    public void switchToUpdateMode() {
        authorField.setEnabled(false);
    }
}
