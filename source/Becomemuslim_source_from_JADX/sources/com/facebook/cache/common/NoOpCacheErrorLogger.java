package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;

public class NoOpCacheErrorLogger implements CacheErrorLogger {
    private static NoOpCacheErrorLogger sInstance;

    public void logError(CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, Throwable th) {
    }

    private NoOpCacheErrorLogger() {
    }

    public static synchronized NoOpCacheErrorLogger getInstance() {
        NoOpCacheErrorLogger noOpCacheErrorLogger;
        synchronized (NoOpCacheErrorLogger.class) {
            if (sInstance == null) {
                sInstance = new NoOpCacheErrorLogger();
            }
            noOpCacheErrorLogger = sInstance;
        }
        return noOpCacheErrorLogger;
    }
}
