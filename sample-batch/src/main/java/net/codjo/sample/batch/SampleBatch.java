/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.sample.batch;
import net.codjo.broadcast.batch.plugin.BroadcastBatchPlugin;
import net.codjo.imports.batch.plugin.ImportBatchPlugin;
import net.codjo.mad.client.plugin.MadConnectionPlugin;
import net.codjo.plugin.batch.BatchCore;
import net.codjo.plugin.common.CommandLineArguments;
import net.codjo.security.client.plugin.SecurityClientPlugin;
/**
 *
 */
public class SampleBatch {
    private SampleBatch() {
    }


    public static void main(String[] args) throws Exception {
        CommandLineArguments arguments = new CommandLineArguments(args);
        BatchCore batch = new BatchCore(arguments);
        batch.addPlugin(SecurityClientPlugin.class);
        batch.addPlugin(MadConnectionPlugin.class);
        batch.addPlugin(BroadcastBatchPlugin.class);
        batch.addPlugin(ImportBatchPlugin.class);
        batch.start();
        batch.executeAndExit();
    }
}
