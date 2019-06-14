package com.google.android.gms.internal.p210i;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.i.jg */
public final class jg extends IOException {
    public jg(String str) {
        super(str);
    }

    public jg(String str, Exception exception) {
        super(str, exception);
    }

    /* renamed from: a */
    static jg m21005a() {
        return new jg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static jg m21006b() {
        return new jg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static jg m21007c() {
        return new jg("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static jg m21008d() {
        return new jg("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
