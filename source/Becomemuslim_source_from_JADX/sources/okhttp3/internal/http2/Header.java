package okhttp3.internal.http2;

import okhttp3.internal.Util;
import p286d.C5869f;

public final class Header {
    public static final C5869f PSEUDO_PREFIX = C5869f.m24697a(":");
    public static final C5869f RESPONSE_STATUS = C5869f.m24697a(":status");
    public static final C5869f TARGET_AUTHORITY = C5869f.m24697a(":authority");
    public static final C5869f TARGET_METHOD = C5869f.m24697a(":method");
    public static final C5869f TARGET_PATH = C5869f.m24697a(":path");
    public static final C5869f TARGET_SCHEME = C5869f.m24697a(":scheme");
    final int hpackSize;
    public final C5869f name;
    public final C5869f value;

    public Header(String str, String str2) {
        this(C5869f.m24697a(str), C5869f.m24697a(str2));
    }

    public Header(C5869f c5869f, String str) {
        this(c5869f, C5869f.m24697a(str));
    }

    public Header(C5869f c5869f, C5869f c5869f2) {
        this.name = c5869f;
        this.value = c5869f2;
        this.hpackSize = (c5869f.mo5110h() + 32) + c5869f2.mo5110h();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (this.name.equals(header.name) && this.value.equals(header.value) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((527 + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.name.mo5099a(), this.value.mo5099a());
    }
}
