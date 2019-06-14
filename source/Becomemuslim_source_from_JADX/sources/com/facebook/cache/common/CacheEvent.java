package com.facebook.cache.common;

import com.facebook.cache.common.CacheEventListener.EvictionReason;
import java.io.IOException;

public interface CacheEvent {
    CacheKey getCacheKey();

    long getCacheLimit();

    long getCacheSize();

    EvictionReason getEvictionReason();

    IOException getException();

    long getItemSize();

    String getResourceId();
}
