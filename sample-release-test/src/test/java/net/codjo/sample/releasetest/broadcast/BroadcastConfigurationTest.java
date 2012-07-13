package net.codjo.sample.releasetest.broadcast;
import net.codjo.broadcast.gui.plugin.BroadcastGuiPlugin;
import net.codjo.broadcast.gui.plugin.BroadcastGuiPluginConfiguration;
import net.codjo.broadcast.releasetest.BroadcastConfigurationTestCase;
import net.codjo.broadcast.server.plugin.BroadcastServerPlugin;
import net.codjo.broadcast.server.plugin.BroadcastServerPluginConfiguration;
import net.codjo.control.gui.plugin.ControlGuiPlugin;
import net.codjo.control.server.plugin.ControlServerPlugin;
import net.codjo.i18n.common.plugin.InternationalizationPlugin;
import net.codjo.i18n.gui.plugin.InternationalizationGuiPlugin;
import net.codjo.imports.gui.plugin.ImportGuiPlugin;
import net.codjo.imports.server.plugin.ImportServerPlugin;
import net.codjo.mad.client.plugin.MadConnectionPlugin;
import net.codjo.mad.client.request.MadServerFixture;
import net.codjo.mad.gui.base.MadGuiCore;
import net.codjo.mad.gui.plugin.MadGuiPlugin;
import net.codjo.mad.server.plugin.MadServerPlugin;
import net.codjo.plugin.server.ServerCore;
import net.codjo.referential.gui.plugin.ReferentialGuiPlugin;
import net.codjo.sample.gui.SampleGui.SampleGuiPlugin;
import net.codjo.sample.server.SampleServer.SampleServerPlugin;
import net.codjo.security.client.plugin.SecurityClientPlugin;
import net.codjo.security.server.plugin.SecurityServerPlugin;
import net.codjo.sql.server.plugin.JdbcServerPlugin;
import net.codjo.workflow.gui.plugin.WorkflowAuditGuiPlugin;
import net.codjo.workflow.gui.plugin.WorkflowGuiPlugin;
import net.codjo.workflow.server.plugin.WorkflowAuditServerPlugin;
import net.codjo.workflow.server.plugin.WorkflowServerPlugin;
import server.plugin.ReferentialServerPlugin;
/**
 * Test qui verifie la coherence du parametrage client et serveur.
 */
public class BroadcastConfigurationTest extends BroadcastConfigurationTestCase {
    private MadServerFixture fixture = new MadServerFixture();


    @Override
    protected BroadcastGuiPluginConfiguration createGuiConfiguration() {
        MadGuiCore guiClient = new MadGuiCore();
        guiClient.addPlugin(SecurityClientPlugin.class);
        guiClient.addPlugin(InternationalizationGuiPlugin.class);
        guiClient.addPlugin(MadConnectionPlugin.class);
        guiClient.addPlugin(MadGuiPlugin.class);
        guiClient.addPlugin(WorkflowGuiPlugin.class);
        guiClient.addPlugin(WorkflowAuditGuiPlugin.class);
        guiClient.addPlugin(ImportGuiPlugin.class);
        guiClient.addPlugin(ControlGuiPlugin.class);
        guiClient.addPlugin(BroadcastGuiPlugin.class);
        guiClient.addPlugin(ReferentialGuiPlugin.class);
        guiClient.addPlugin(SampleGuiPlugin.class);
        return guiClient.getPlugin(BroadcastGuiPlugin.class).getConfiguration();
    }


    @Override
    protected BroadcastServerPluginConfiguration createServerConfiguration() {
        ServerCore server = new ServerCore();
        server.addPlugin(JdbcServerPlugin.class);
        server.addPlugin(SecurityServerPlugin.class);
        server.addPlugin(InternationalizationPlugin.class);
        server.addPlugin(MadServerPlugin.class);
        server.addPlugin(WorkflowServerPlugin.class);
        server.addPlugin(WorkflowAuditServerPlugin.class);
        server.addPlugin(ImportServerPlugin.class);
        server.addPlugin(ControlServerPlugin.class);
        server.addPlugin(BroadcastServerPlugin.class);
        server.addPlugin(ReferentialServerPlugin.class);
        server.addPlugin(SampleServerPlugin.class);
        return server.getPlugin(BroadcastServerPlugin.class).getConfiguration();
    }


    @Override
    public void test_buildSelectionComboBox() throws Exception {
        // bouchon pour faire fonctionner les constructions de combo avec handler.

        fixture.mockServerResult(new String[]{"selectorId", "selectorName", "selectorQuery",
                                              "selectorFamily"},
                                 new String[][]{
                                       {"1", "Selecteur 1", "select *", "VL"},
                                       {"2", "Selecteur 2", "select *", "VL"},
                                 });
        fixture.mockServerResult(new String[]{"selectorId", "selectorName", "selectorQuery",
                                              "selectorFamily"},
                                 new String[][]{
                                       {"1", "Selecteur 3", "select *", "VL"},
                                       {"2", "Selecteur 4", "select *", "VL"},
                                 });
        super.test_buildSelectionComboBox();
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        fixture.doSetUp();
    }


    @Override
    protected void tearDown() throws Exception {
        fixture.doTearDown();
        super.tearDown();
    }
}