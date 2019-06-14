package com.facebook.stetho.server;

import android.net.LocalSocket;

public interface SocketHandler {
    void onAccepted(LocalSocket localSocket);
}
