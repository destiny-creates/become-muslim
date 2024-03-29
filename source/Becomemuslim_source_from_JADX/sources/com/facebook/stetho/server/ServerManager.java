package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;

public class ServerManager {
    private static final String THREAD_PREFIX = "StethoListener";
    private final LocalSocketServer mServer;
    private volatile boolean mStarted;

    public ServerManager(LocalSocketServer localSocketServer) {
        this.mServer = localSocketServer;
    }

    public void start() {
        if (this.mStarted) {
            throw new IllegalStateException("Already started");
        }
        this.mStarted = true;
        startServer(this.mServer);
    }

    private void startServer(final LocalSocketServer localSocketServer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StethoListener-");
        stringBuilder.append(localSocketServer.getName());
        new Thread(stringBuilder.toString()) {
            public void run() {
                try {
                    localSocketServer.run();
                } catch (Throwable e) {
                    LogUtil.m5745e(e, "Could not start Stetho server: %s", localSocketServer.getName());
                }
            }
        }.start();
    }
}
