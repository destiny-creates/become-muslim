package com.facebook.stetho.websocket;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

class WriteHandler {
    private final BufferedOutputStream mBufferedOutput;

    public WriteHandler(OutputStream outputStream) {
        this.mBufferedOutput = new BufferedOutputStream(outputStream, 1024);
    }

    public synchronized void write(Frame frame, WriteCallback writeCallback) {
        try {
            frame.writeTo(this.mBufferedOutput);
            this.mBufferedOutput.flush();
            writeCallback.onSuccess();
        } catch (Frame frame2) {
            writeCallback.onFailure(frame2);
        }
        return;
    }
}
