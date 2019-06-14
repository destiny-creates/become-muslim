package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import com.facebook.stetho.common.Utf8Charset;
import java.util.ArrayList;
import java.util.List;

public final class CacheKeyUtil {
    public static List<String> getResourceIds(CacheKey cacheKey) {
        try {
            List<String> arrayList;
            if (cacheKey instanceof MultiCacheKey) {
                cacheKey = ((MultiCacheKey) cacheKey).getCacheKeys();
                arrayList = new ArrayList(cacheKey.size());
                for (int i = 0; i < cacheKey.size(); i++) {
                    arrayList.add(secureHashKey((CacheKey) cacheKey.get(i)));
                }
                return arrayList;
            }
            arrayList = new ArrayList(1);
            arrayList.add(secureHashKey(cacheKey));
            return arrayList;
        } catch (CacheKey cacheKey2) {
            throw new RuntimeException(cacheKey2);
        }
    }

    public static String getFirstResourceId(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                return secureHashKey((CacheKey) ((MultiCacheKey) cacheKey).getCacheKeys().get(0));
            }
            return secureHashKey(cacheKey);
        } catch (CacheKey cacheKey2) {
            throw new RuntimeException(cacheKey2);
        }
    }

    private static String secureHashKey(CacheKey cacheKey) {
        return SecureHashUtil.makeSHA1HashBase64(cacheKey.getUriString().getBytes(Utf8Charset.NAME));
    }
}
