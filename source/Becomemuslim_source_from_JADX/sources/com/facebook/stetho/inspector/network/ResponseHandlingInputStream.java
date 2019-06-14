package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.protocol.module.Console.MessageLevel;
import com.facebook.stetho.inspector.protocol.module.Console.MessageSource;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ResponseHandlingInputStream extends FilterInputStream {
    private static final int BUFFER_SIZE = 1024;
    public static final String TAG = "ResponseHandlingInputStream";
    private boolean mClosed;
    private final CountingOutputStream mDecompressedCounter;
    private boolean mEofSeen;
    private long mLastDecompressedCount = 0;
    private final ChromePeerManager mNetworkPeerManager;
    private final OutputStream mOutputStream;
    private final String mRequestId;
    private final ResponseHandler mResponseHandler;
    private byte[] mSkipBuffer;

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public ResponseHandlingInputStream(InputStream inputStream, String str, OutputStream outputStream, CountingOutputStream countingOutputStream, ChromePeerManager chromePeerManager, ResponseHandler responseHandler) {
        super(inputStream);
        this.mRequestId = str;
        this.mOutputStream = outputStream;
        this.mDecompressedCounter = countingOutputStream;
        this.mNetworkPeerManager = chromePeerManager;
        this.mResponseHandler = responseHandler;
        this.mClosed = null;
    }

    private synchronized int checkEOF(int i) {
        if (i == -1) {
            closeOutputStreamQuietly();
            this.mResponseHandler.onEOF();
            this.mEofSeen = true;
        }
        return i;
    }

    public int read() {
        try {
            int checkEOF = checkEOF(this.in.read());
            if (checkEOF != -1) {
                this.mResponseHandler.onRead(1);
                writeToOutputStream(checkEOF);
            }
            return checkEOF;
        } catch (IOException e) {
            throw handleIOException(e);
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            i2 = checkEOF(this.in.read(bArr, i, i2));
            if (i2 != -1) {
                this.mResponseHandler.onRead(i2);
                writeToOutputStream(bArr, i, i2);
            }
            return i2;
        } catch (byte[] bArr2) {
            throw handleIOException(bArr2);
        }
    }

    public synchronized long skip(long j) {
        long j2;
        byte[] skipBufferLocked = getSkipBufferLocked();
        j2 = 0;
        while (j2 < j) {
            int read = read(skipBufferLocked, 0, (int) Math.min((long) skipBufferLocked.length, j - j2));
            if (read == -1) {
                break;
            }
            j2 += (long) read;
        }
        return j2;
    }

    private byte[] getSkipBufferLocked() {
        if (this.mSkipBuffer == null) {
            this.mSkipBuffer = new byte[1024];
        }
        return this.mSkipBuffer;
    }

    public void reset() {
        throw new UnsupportedOperationException("Mark not supported");
    }

    public void close() {
        try {
            long j;
            if (!this.mEofSeen) {
                byte[] bArr = new byte[1024];
                j = 0;
                while (true) {
                    int read = read(bArr);
                    if (read == -1) {
                        break;
                    }
                    j += (long) read;
                }
            } else {
                j = 0;
            }
            if (j > 0) {
                ChromePeerManager chromePeerManager = this.mNetworkPeerManager;
                MessageLevel messageLevel = MessageLevel.ERROR;
                MessageSource messageSource = MessageSource.NETWORK;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("There were ");
                stringBuilder.append(String.valueOf(j));
                stringBuilder.append(" bytes that were not consumed while ");
                stringBuilder.append("processing request ");
                stringBuilder.append(this.mRequestId);
                CLog.writeToConsole(chromePeerManager, messageLevel, messageSource, stringBuilder.toString());
            }
            super.close();
            closeOutputStreamQuietly();
        } catch (Throwable th) {
            super.close();
            closeOutputStreamQuietly();
        }
    }

    private synchronized void closeOutputStreamQuietly() {
        if (!this.mClosed) {
            try {
                this.mOutputStream.close();
                reportDecodedSizeIfApplicable();
            } catch (IOException e) {
                try {
                    ChromePeerManager chromePeerManager = this.mNetworkPeerManager;
                    MessageLevel messageLevel = MessageLevel.ERROR;
                    MessageSource messageSource = MessageSource.NETWORK;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not close the output stream");
                    stringBuilder.append(e);
                    CLog.writeToConsole(chromePeerManager, messageLevel, messageSource, stringBuilder.toString());
                } catch (Throwable th) {
                    this.mClosed = true;
                }
            }
            this.mClosed = true;
        }
    }

    private IOException handleIOException(IOException iOException) {
        this.mResponseHandler.onError(iOException);
        return iOException;
    }

    private void reportDecodedSizeIfApplicable() {
        if (this.mDecompressedCounter != null) {
            long count = this.mDecompressedCounter.getCount();
            this.mResponseHandler.onReadDecoded((int) (count - this.mLastDecompressedCount));
            this.mLastDecompressedCount = count;
        }
    }

    private synchronized void writeToOutputStream(int i) {
        if (!this.mClosed) {
            try {
                this.mOutputStream.write(i);
                reportDecodedSizeIfApplicable();
            } catch (int i2) {
                handleIOExceptionWritingToStream(i2);
            }
        } else {
            return;
        }
        return;
    }

    private synchronized void writeToOutputStream(byte[] bArr, int i, int i2) {
        if (!this.mClosed) {
            try {
                this.mOutputStream.write(bArr, i, i2);
                reportDecodedSizeIfApplicable();
            } catch (byte[] bArr2) {
                handleIOExceptionWritingToStream(bArr2);
            }
        } else {
            return;
        }
        return;
    }

    private void handleIOExceptionWritingToStream(IOException iOException) {
        ChromePeerManager chromePeerManager = this.mNetworkPeerManager;
        MessageLevel messageLevel = MessageLevel.ERROR;
        MessageSource messageSource = MessageSource.NETWORK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not write response body to the stream ");
        stringBuilder.append(iOException);
        CLog.writeToConsole(chromePeerManager, messageLevel, messageSource, stringBuilder.toString());
        closeOutputStreamQuietly();
    }
}
