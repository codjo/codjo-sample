package net.codjo.sample.server;
import net.codjo.agent.AgentContainer;
import net.codjo.agent.ContainerConfiguration;
import net.codjo.broadcast.server.plugin.BroadcastServerPlugin;
import net.codjo.control.server.plugin.ControlServerPlugin;
import net.codjo.imports.server.plugin.ImportServerPlugin;
import net.codjo.mad.server.plugin.MadServerPlugin;
import net.codjo.plugin.common.ApplicationPlugin;
import net.codjo.plugin.common.CommandLineArguments;
import net.codjo.plugin.server.ServerCore;
import net.codjo.sample.server.broadcast.BookPreferences;
import net.codjo.security.server.plugin.SecurityServerPlugin;
import net.codjo.sql.server.plugin.JdbcServerPlugin;
import net.codjo.workflow.server.plugin.WorkflowAuditServerPlugin;
import net.codjo.workflow.server.plugin.WorkflowServerPlugin;

public class SampleServer {
    private SampleServer() {
    }


    public static void main(String[] arguments) {
        ServerCore server = new ServerCore();

        server.addPlugin(JdbcServerPlugin.class);
        server.addPlugin(SecurityServerPlugin.class);
        server.addPlugin(MadServerPlugin.class);
        server.addPlugin(WorkflowServerPlugin.class);
        server.addPlugin(WorkflowAuditServerPlugin.class);
        server.addPlugin(ImportServerPlugin.class);
        server.addPlugin(ControlServerPlugin.class);
        server.addPlugin(BroadcastServerPlugin.class);

        server.addPlugin(SampleServerPlugin.class);

        server.startAndExitIfFailure(new CommandLineArguments(arguments));
    }


    public static class SampleServerPlugin implements ApplicationPlugin {
        public SampleServerPlugin(BroadcastServerPlugin broadcast) {
            broadcast.getConfiguration().addServerPreference(new BookPreferences());
        }


        public void initContainer(ContainerConfiguration containerConfiguration) throws Exception {
        }


        public void start(AgentContainer agentContainer) throws Exception {
        }


        public void stop() throws Exception {
        }
    }
}
