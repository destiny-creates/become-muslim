package com.facebook.stetho.server;

import android.net.LocalSocket;

public class LazySocketHandler implements SocketHandler {
    private SocketHandler mSocketHandler;
    private final SocketHandlerFactory mSocketHandlerFactory;

    public LazySocketHandler(SocketHandlerFactory socketHandlerFactory) {
        this.mSocketHandlerFactory = socketHandlerFactory;
    }

    public void onAccepted(LocalSocket localSocket) {
        getSocketHandler().onAccepted(localSocket);
    }

    private synchronized SocketHandler getSocketHandler() {
        if (this.mSocketHandler == null) {
            this.mSocketHandler = this.mSocketHandlerFactory.create();
        }
        return this.mSocketHandler;
    }
}
