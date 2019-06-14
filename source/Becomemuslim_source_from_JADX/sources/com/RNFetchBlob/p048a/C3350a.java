package com.RNFetchBlob.p048a;

import com.RNFetchBlob.C0869f;
import com.RNFetchBlob.C0874g;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.ac;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C6259t;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.nio.charset.Charset;

/* compiled from: RNFetchBlobDefaultResp */
/* renamed from: com.RNFetchBlob.a.a */
public class C3350a extends ac {
    /* renamed from: a */
    String f8896a;
    /* renamed from: b */
    ReactApplicationContext f8897b;
    /* renamed from: c */
    ac f8898c;
    /* renamed from: d */
    boolean f8899d = false;

    /* compiled from: RNFetchBlobDefaultResp */
    /* renamed from: com.RNFetchBlob.a.a$a */
    private class C3349a implements C6258s {
        /* renamed from: a */
        C7497e f8893a;
        /* renamed from: b */
        long f8894b = 0;
        /* renamed from: c */
        final /* synthetic */ C3350a f8895c;

        public void close() {
        }

        public C6259t timeout() {
            return null;
        }

        C3349a(C3350a c3350a, C7497e c7497e) {
            this.f8895c = c3350a;
            this.f8893a = c7497e;
        }

        public long read(C8170c c8170c, long j) {
            j = this.f8893a.read(c8170c, j);
            this.f8894b += j > 0 ? j : 0;
            C0869f b = C0874g.m3115b(this.f8895c.f8896a);
            long contentLength = this.f8895c.contentLength();
            if (!(b == null || contentLength == 0 || !b.m3104a((float) (this.f8894b / this.f8895c.contentLength())))) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("taskId", this.f8895c.f8896a);
                createMap.putString("written", String.valueOf(this.f8894b));
                createMap.putString("total", String.valueOf(this.f8895c.contentLength()));
                if (this.f8895c.f8899d) {
                    createMap.putString("chunk", c8170c.a(Charset.defaultCharset()));
                } else {
                    createMap.putString("chunk", "");
                }
                ((RCTDeviceEventEmitter) this.f8895c.f8897b.getJSModule(RCTDeviceEventEmitter.class)).emit("RNFetchBlobProgress", createMap);
            }
            return j;
        }
    }

    public C3350a(ReactApplicationContext reactApplicationContext, String str, ac acVar, boolean z) {
        this.f8897b = reactApplicationContext;
        this.f8896a = str;
        this.f8898c = acVar;
        this.f8899d = z;
    }

    public C6240u contentType() {
        return this.f8898c.contentType();
    }

    public long contentLength() {
        return this.f8898c.contentLength();
    }

    public C7497e source() {
        return C6252l.a(new C3349a(this, this.f8898c.source()));
    }
}
