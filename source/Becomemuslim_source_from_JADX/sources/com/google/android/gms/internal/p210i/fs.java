package com.google.android.gms.internal.p210i;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.i.fs */
public class fs extends IOException {
    /* renamed from: a */
    private gt f16622a = null;

    public fs(String str) {
        super(str);
    }

    /* renamed from: a */
    public final fs m20576a(gt gtVar) {
        this.f16622a = gtVar;
        return this;
    }

    /* renamed from: a */
    static fs m20568a() {
        return new fs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static fs m20569b() {
        return new fs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static fs m20570c() {
        return new fs("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static fs m20571d() {
        return new fs("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: e */
    static ft m20572e() {
        return new ft("Protocol message tag had invalid wire type.");
    }

    /* renamed from: f */
    static fs m20573f() {
        return new fs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: g */
    static fs m20574g() {
        return new fs("Failed to parse the message.");
    }

    /* renamed from: h */
    static fs m20575h() {
        return new fs("Protocol message had invalid UTF-8.");
    }
}
