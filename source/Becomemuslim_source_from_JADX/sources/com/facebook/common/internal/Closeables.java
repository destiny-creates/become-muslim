package com.facebook.common.internal;

import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Closeables {
    @VisibleForTesting
    static final Logger logger = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void close(Closeable closeable, boolean z) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                if (z) {
                    logger.log(Level.WARNING, "IOException thrown while closing Closeable.", closeable2);
                } else {
                    throw closeable2;
                }
            }
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (InputStream inputStream2) {
            throw new AssertionError(inputStream2);
        }
    }

    public static void closeQuietly(Reader reader) {
        try {
            close(reader, true);
        } catch (Reader reader2) {
            throw new AssertionError(reader2);
        }
    }
}
