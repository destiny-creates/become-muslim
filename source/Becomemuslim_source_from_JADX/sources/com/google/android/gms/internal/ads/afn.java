package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class afn extends IOException {
    public afn(String str) {
        super(str);
    }

    /* renamed from: a */
    static afn m18383a() {
        return new afn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static afn m18384b() {
        return new afn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static afn m18385c() {
        return new afn("CodedInputStream encountered a malformed varint.");
    }
}
