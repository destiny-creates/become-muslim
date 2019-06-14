package com.google.android.exoplayer2.p145g;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p145g.p146a.C4161b;
import com.google.android.exoplayer2.p145g.p147b.C4162g;
import com.google.android.exoplayer2.p145g.p148c.C4165c;

/* compiled from: MetadataDecoderFactory */
/* renamed from: com.google.android.exoplayer2.g.d */
public interface C2366d {
    /* renamed from: a */
    public static final C2366d f5826a = new C41661();

    /* compiled from: MetadataDecoderFactory */
    /* renamed from: com.google.android.exoplayer2.g.d$1 */
    static class C41661 implements C2366d {
        C41661() {
        }

        /* renamed from: a */
        public boolean mo2228a(C2515k c2515k) {
            c2515k = c2515k.f6380f;
            if (!("application/id3".equals(c2515k) || "application/x-emsg".equals(c2515k))) {
                if ("application/x-scte35".equals(c2515k) == null) {
                    return null;
                }
            }
            return true;
        }

        /* renamed from: b */
        public C2356b mo2229b(C2515k c2515k) {
            c2515k = c2515k.f6380f;
            int hashCode = c2515k.hashCode();
            if (hashCode != -1248341703) {
                if (hashCode != 1154383568) {
                    if (hashCode == 1652648887) {
                        if (c2515k.equals("application/x-scte35") != null) {
                            c2515k = 2;
                            switch (c2515k) {
                                case null:
                                    return new C4162g();
                                case 1:
                                    return new C4161b();
                                case 2:
                                    return new C4165c();
                                default:
                                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                            }
                        }
                    }
                } else if (c2515k.equals("application/x-emsg") != null) {
                    c2515k = true;
                    switch (c2515k) {
                        case null:
                            return new C4162g();
                        case 1:
                            return new C4161b();
                        case 2:
                            return new C4165c();
                        default:
                            throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                    }
                }
            } else if (c2515k.equals("application/id3") != null) {
                c2515k = null;
                switch (c2515k) {
                    case null:
                        return new C4162g();
                    case 1:
                        return new C4161b();
                    case 2:
                        return new C4165c();
                    default:
                        throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                }
            }
            c2515k = -1;
            switch (c2515k) {
                case null:
                    return new C4162g();
                case 1:
                    return new C4161b();
                case 2:
                    return new C4165c();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    /* renamed from: a */
    boolean mo2228a(C2515k c2515k);

    /* renamed from: b */
    C2356b mo2229b(C2515k c2515k);
}
