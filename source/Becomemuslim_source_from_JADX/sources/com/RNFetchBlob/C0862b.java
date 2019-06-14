package com.RNFetchBlob;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: RNFetchBlobConfig */
/* renamed from: com.RNFetchBlob.b */
public class C0862b {
    /* renamed from: a */
    public Boolean f2401a;
    /* renamed from: b */
    public String f2402b;
    /* renamed from: c */
    public String f2403c;
    /* renamed from: d */
    public ReadableMap f2404d;
    /* renamed from: e */
    public Boolean f2405e;
    /* renamed from: f */
    public String f2406f;
    /* renamed from: g */
    public String f2407g;
    /* renamed from: h */
    public Boolean f2408h;
    /* renamed from: i */
    public Boolean f2409i = Boolean.valueOf(true);
    /* renamed from: j */
    public long f2410j = 60000;
    /* renamed from: k */
    public Boolean f2411k;
    /* renamed from: l */
    public Boolean f2412l;
    /* renamed from: m */
    public ReadableArray f2413m;

    C0862b(ReadableMap readableMap) {
        boolean z = false;
        this.f2411k = Boolean.valueOf(false);
        this.f2412l = Boolean.valueOf(true);
        String str = null;
        this.f2413m = null;
        if (readableMap != null) {
            this.f2401a = Boolean.valueOf(readableMap.hasKey("fileCache") ? readableMap.getBoolean("fileCache") : false);
            this.f2402b = readableMap.hasKey("path") ? readableMap.getString("path") : null;
            this.f2403c = readableMap.hasKey("appendExt") ? readableMap.getString("appendExt") : "";
            this.f2405e = Boolean.valueOf(readableMap.hasKey("trusty") ? readableMap.getBoolean("trusty") : false);
            if (readableMap.hasKey("addAndroidDownloads")) {
                this.f2404d = readableMap.getMap("addAndroidDownloads");
            }
            if (readableMap.hasKey("binaryContentTypes")) {
                this.f2413m = readableMap.getArray("binaryContentTypes");
            }
            if (this.f2402b != null && this.f2402b.toLowerCase().contains("?append=true")) {
                this.f2409i = Boolean.valueOf(false);
            }
            if (readableMap.hasKey("overwrite")) {
                this.f2409i = Boolean.valueOf(readableMap.getBoolean("overwrite"));
            }
            if (readableMap.hasKey("followRedirect")) {
                this.f2412l = Boolean.valueOf(readableMap.getBoolean("followRedirect"));
            }
            this.f2406f = readableMap.hasKey("key") ? readableMap.getString("key") : null;
            if (readableMap.hasKey("contentType")) {
                str = readableMap.getString("contentType");
            }
            this.f2407g = str;
            this.f2411k = Boolean.valueOf(readableMap.hasKey("increment") ? readableMap.getBoolean("increment") : false);
            if (readableMap.hasKey("auto")) {
                z = readableMap.getBoolean("auto");
            }
            this.f2408h = Boolean.valueOf(z);
            if (readableMap.hasKey("timeout")) {
                this.f2410j = (long) readableMap.getInt("timeout");
            }
        }
    }
}
