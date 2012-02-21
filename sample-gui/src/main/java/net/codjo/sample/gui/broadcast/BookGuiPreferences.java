package net.codjo.sample.gui.broadcast;
import net.codjo.broadcast.gui.GuiField;
import net.codjo.broadcast.gui.selector.AbstractSelectorGuiPreference;
import net.codjo.mad.common.structure.StructureReader;
/**
 *
 */
public class BookGuiPreferences extends AbstractSelectorGuiPreference {

    public BookGuiPreferences(StructureReader structures) {
        super("BOOK", "#COMPUTED_TAB", structures);
    }


    @Override
    protected String getSelectorColumnsDescription() {
        return "ZE_CODE, ZE_LABEL, BROADCAST_DATE";
    }


    @Override
    protected SelectionComboBoxBuilder addStaticSelectors(SelectionComboBoxBuilder comboBoxBuilder) {
        return comboBoxBuilder.withSelector("1", "Sélection statique 1");
    }


    @Override
    protected GuiField[] getComputedFields(String aComputedTableName) {
        return new GuiField[0];
    }
}

