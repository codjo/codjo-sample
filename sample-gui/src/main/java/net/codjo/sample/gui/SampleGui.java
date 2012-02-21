/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.sample.gui;
import java.awt.Dimension;
import java.io.IOException;
import net.codjo.broadcast.gui.plugin.BroadcastGuiPlugin;
import net.codjo.control.gui.plugin.ControlGuiPlugin;
import net.codjo.imports.gui.plugin.ImportGuiPlugin;
import net.codjo.mad.client.plugin.MadConnectionPlugin;
import net.codjo.mad.gui.base.AbstractGuiPlugin;
import net.codjo.mad.gui.base.GuiConfiguration;
import net.codjo.mad.gui.base.MadGuiCore;
import net.codjo.mad.gui.plugin.MadGuiPlugin;
import net.codjo.mad.gui.util.ApplicationData;
import net.codjo.security.client.plugin.SecurityClientPlugin;
import net.codjo.security.gui.plugin.SecurityGuiPlugin;
import net.codjo.workflow.gui.plugin.WorkflowAuditGuiPlugin;
import net.codjo.workflow.gui.plugin.WorkflowGuiPlugin;

/**
 * Classe Main du client IHM.
 */
public class SampleGui {
    private SampleGui() {
    }


    public static void main(String[] arguments) throws IOException {
        final MadGuiCore guiClient = new MadGuiCore();

        guiClient.addPlugin(SecurityGuiPlugin.class);
        guiClient.addPlugin(SecurityClientPlugin.class);
        guiClient.addPlugin(MadConnectionPlugin.class);
        guiClient.addPlugin(MadGuiPlugin.class);
        guiClient.addPlugin(WorkflowGuiPlugin.class);
        guiClient.addPlugin(WorkflowAuditGuiPlugin.class);
        guiClient.addPlugin(ImportGuiPlugin.class);
        guiClient.addPlugin(ControlGuiPlugin.class);
        guiClient.addPlugin(BroadcastGuiPlugin.class);

        guiClient.addPlugin(SampleGuiPlugin.class);

        ApplicationData applicationData =
              new ApplicationData(SampleGui.class.getResourceAsStream("/conf/application.properties"));

        guiClient.getConfiguration().setMainWindowSize(new Dimension(1200, 970));
        guiClient.show(arguments, applicationData);
    }


    public static class SampleGuiPlugin extends AbstractGuiPlugin {

        public SampleGuiPlugin(BroadcastGuiPlugin broadcastGuiPlugin) {
            broadcastGuiPlugin.getConfiguration().installGenericSelector();
        }


        public void initGui(GuiConfiguration configuration) throws Exception {
        }
    }
}
