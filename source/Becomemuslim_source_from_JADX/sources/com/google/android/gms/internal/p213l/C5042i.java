package com.google.android.gms.internal.p213l;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.l.i */
public final class C5042i extends IOException {
    public C5042i(String str) {
        super(str);
    }

    /* renamed from: a */
    static C5042i m21435a() {
        return new C5042i("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static C5042i m21436b() {
        return new C5042i("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static C5042i m21437c() {
        return new C5042i("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static C5042i m21438d() {
        return new C5042i("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
