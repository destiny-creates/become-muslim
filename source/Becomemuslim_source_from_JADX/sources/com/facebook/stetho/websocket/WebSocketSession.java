package com.facebook.stetho.websocket;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class WebSocketSession implements SimpleSession {
    private final SimpleEndpoint mEndpoint;
    private final WriteCallback mErrorForwardingWriteCallback = new C39732();
    private AtomicBoolean mIsOpen = new AtomicBoolean(false);
    private final ReadCallback mReadCallback = new C39721();
    private final ReadHandler mReadHandler;
    private volatile boolean mSentClose;
    private final WriteHandler mWriteHandler;

    /* renamed from: com.facebook.stetho.websocket.WebSocketSession$1 */
    class C39721 implements ReadCallback {
        private void handlePong(byte[] bArr, int i) {
        }

        C39721() {
        }

        public void onCompleteFrame(byte b, byte[] bArr, int i) {
            switch (b) {
                case (byte) 1:
                    handleTextFrame(bArr, i);
                    return;
                case (byte) 2:
                    handleBinaryFrame(bArr, i);
                    return;
                default:
                    switch (b) {
                        case (byte) 8:
                            handleClose(bArr, i);
                            return;
                        case (byte) 9:
                            handlePing(bArr, i);
                            return;
                        case (byte) 10:
                            handlePong(bArr, i);
                            return;
                        default:
                            bArr = WebSocketSession.this;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unsupported frame opcode=");
                            stringBuilder.append(b);
                            bArr.signalError(new IOException(stringBuilder.toString()));
                            return;
                    }
            }
        }

        private void handleClose(byte[] bArr, int i) {
            int i2;
            String str;
            if (i >= 2) {
                i2 = ((bArr[0] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[1] & JfifUtil.MARKER_FIRST_BYTE);
                str = i > 2 ? new String(bArr, 2, i - 2) : null;
            } else {
                i2 = CloseCodes.CLOSED_ABNORMALLY;
                str = "Unparseable close frame";
            }
            if (WebSocketSession.this.mSentClose == null) {
                WebSocketSession.this.sendClose(1000, "Received close frame");
            }
            WebSocketSession.this.markAndSignalClosed(i2, str);
        }

        private void handlePing(byte[] bArr, int i) {
            WebSocketSession.this.doWrite(FrameHelper.createPongFrame(bArr, i));
        }

        private void handleTextFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(bArr, 0, i));
        }

        private void handleBinaryFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, bArr, i);
        }
    }

    /* renamed from: com.facebook.stetho.websocket.WebSocketSession$2 */
    class C39732 implements WriteCallback {
        public void onSuccess() {
        }

        C39732() {
        }

        public void onFailure(IOException iOException) {
            WebSocketSession.this.signalError(iOException);
        }
    }

    public WebSocketSession(InputStream inputStream, OutputStream outputStream, SimpleEndpoint simpleEndpoint) {
        this.mReadHandler = new ReadHandler(inputStream, simpleEndpoint);
        this.mWriteHandler = new WriteHandler(outputStream);
        this.mEndpoint = simpleEndpoint;
    }

    public void handle() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r3.markAndSignalOpen();
        r0 = r3.mReadHandler;	 Catch:{ EOFException -> 0x0013, IOException -> 0x000b }
        r1 = r3.mReadCallback;	 Catch:{ EOFException -> 0x0013, IOException -> 0x000b }
        r0.readLoop(r1);	 Catch:{ EOFException -> 0x0013, IOException -> 0x000b }
        goto L_0x001a;
    L_0x000b:
        r0 = move-exception;
        r1 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        r2 = 0;
        r3.markAndSignalClosed(r1, r2);
        throw r0;
    L_0x0013:
        r0 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;
        r1 = "EOF while reading";
        r3.markAndSignalClosed(r0, r1);
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.websocket.WebSocketSession.handle():void");
    }

    public void sendText(String str) {
        doWrite(FrameHelper.createTextFrame(str));
    }

    public void sendBinary(byte[] bArr) {
        doWrite(FrameHelper.createBinaryFrame(bArr));
    }

    public void close(int i, String str) {
        sendClose(i, str);
        markAndSignalClosed(i, str);
    }

    private void sendClose(int i, String str) {
        doWrite(FrameHelper.createCloseFrame(i, str));
        markSentClose();
    }

    void markSentClose() {
        this.mSentClose = true;
    }

    void markAndSignalOpen() {
        if (!this.mIsOpen.getAndSet(true)) {
            this.mEndpoint.onOpen(this);
        }
    }

    void markAndSignalClosed(int i, String str) {
        if (this.mIsOpen.getAndSet(false)) {
            this.mEndpoint.onClose(this, i, str);
        }
    }

    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    private void doWrite(Frame frame) {
        if (!signalErrorIfNotOpen()) {
            this.mWriteHandler.write(frame, this.mErrorForwardingWriteCallback);
        }
    }

    private boolean signalErrorIfNotOpen() {
        if (isOpen()) {
            return false;
        }
        signalError(new IOException("Session is closed"));
        return true;
    }

    private void signalError(IOException iOException) {
        this.mEndpoint.onError(this, iOException);
    }
}
