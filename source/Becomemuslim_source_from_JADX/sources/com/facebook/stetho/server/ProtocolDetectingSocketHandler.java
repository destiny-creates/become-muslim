package com.facebook.stetho.server;

import android.content.Context;
import android.net.LocalSocket;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ProtocolDetectingSocketHandler extends SecureSocketHandler {
    private static final int SENSING_BUFFER_SIZE = 256;
    private final ArrayList<HandlerInfo> mHandlers = new ArrayList(2);

    private static class HandlerInfo {
        public final SocketLikeHandler handler;
        public final MagicMatcher magicMatcher;

        private HandlerInfo(MagicMatcher magicMatcher, SocketLikeHandler socketLikeHandler) {
            this.magicMatcher = magicMatcher;
            this.handler = socketLikeHandler;
        }
    }

    public interface MagicMatcher {
        boolean matches(InputStream inputStream);
    }

    public static class AlwaysMatchMatcher implements MagicMatcher {
        public boolean matches(InputStream inputStream) {
            return true;
        }
    }

    public static class ExactMagicMatcher implements MagicMatcher {
        private final byte[] mMagic;

        public ExactMagicMatcher(byte[] bArr) {
            this.mMagic = bArr;
        }

        public boolean matches(InputStream inputStream) {
            byte[] bArr = new byte[this.mMagic.length];
            return (inputStream.read(bArr) != bArr.length || Arrays.equals(bArr, this.mMagic) == null) ? null : true;
        }
    }

    public ProtocolDetectingSocketHandler(Context context) {
        super(context);
    }

    public void addHandler(MagicMatcher magicMatcher, SocketLikeHandler socketLikeHandler) {
        this.mHandlers.add(new HandlerInfo(magicMatcher, socketLikeHandler));
    }

    protected void onSecured(LocalSocket localSocket) {
        LeakyBufferedInputStream leakyBufferedInputStream = new LeakyBufferedInputStream(localSocket.getInputStream(), SENSING_BUFFER_SIZE);
        if (this.mHandlers.isEmpty()) {
            throw new IllegalStateException("No handlers added");
        }
        int size = this.mHandlers.size();
        for (int i = 0; i < size; i++) {
            HandlerInfo handlerInfo = (HandlerInfo) this.mHandlers.get(i);
            leakyBufferedInputStream.mark(SENSING_BUFFER_SIZE);
            boolean matches = handlerInfo.magicMatcher.matches(leakyBufferedInputStream);
            leakyBufferedInputStream.reset();
            if (matches) {
                handlerInfo.handler.onAccepted(new SocketLike(localSocket, leakyBufferedInputStream));
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No matching handler, firstByte=");
        stringBuilder.append(leakyBufferedInputStream.read());
        throw new IOException(stringBuilder.toString());
    }
}
