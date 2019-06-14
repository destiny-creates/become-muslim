package com.google.android.gms.internal.ads;

import java.io.IOException;

public class abw extends IOException {
    /* renamed from: a */
    private acx f14241a = null;

    public abw(String str) {
        super(str);
    }

    /* renamed from: a */
    static abw m17945a() {
        return new abw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static abw m17946b() {
        return new abw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static abw m17947c() {
        return new abw("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static abw m17948d() {
        return new abw("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static abw m17949e() {
        return new abw("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static abx m17950f() {
        return new abx("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static abw m17951g() {
        return new abw("Failed to parse the message.");
    }

    /* renamed from: h */
    static abw m17952h() {
        return new abw("Protocol message had invalid UTF-8.");
    }

    /* renamed from: a */
    public final abw m17953a(acx acx) {
        this.f14241a = acx;
        return this;
    }
}
