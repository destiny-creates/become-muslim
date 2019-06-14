package org.spongycastle.asn1;

import java.io.InputStream;

class ConstructedOctetStream extends InputStream {
    /* renamed from: a */
    private final ASN1StreamParser f21452a;
    /* renamed from: b */
    private boolean f21453b = true;
    /* renamed from: c */
    private InputStream f21454c;

    ConstructedOctetStream(ASN1StreamParser aSN1StreamParser) {
        this.f21452a = aSN1StreamParser;
    }

    public int read(byte[] bArr, int i, int i2) {
        ASN1OctetStringParser aSN1OctetStringParser;
        int i3 = 0;
        if (this.f21454c == null) {
            if (!this.f21453b) {
                return -1;
            }
            aSN1OctetStringParser = (ASN1OctetStringParser) this.f21452a.m27154a();
            if (aSN1OctetStringParser == null) {
                return -1;
            }
            this.f21453b = false;
            this.f21454c = aSN1OctetStringParser.mo6439b();
        }
        while (true) {
            int read = this.f21454c.read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
                if (i3 == i2) {
                    return i3;
                }
            } else {
                aSN1OctetStringParser = (ASN1OctetStringParser) this.f21452a.m27154a();
                if (aSN1OctetStringParser == null) {
                    break;
                }
                this.f21454c = aSN1OctetStringParser.mo6439b();
            }
        }
        this.f21454c = null;
        if (i3 < 1) {
            i3 = -1;
        }
        return i3;
    }

    public int read() {
        ASN1OctetStringParser aSN1OctetStringParser;
        if (this.f21454c == null) {
            if (!this.f21453b) {
                return -1;
            }
            aSN1OctetStringParser = (ASN1OctetStringParser) this.f21452a.m27154a();
            if (aSN1OctetStringParser == null) {
                return -1;
            }
            this.f21453b = false;
            this.f21454c = aSN1OctetStringParser.mo6439b();
        }
        while (true) {
            int read = this.f21454c.read();
            if (read >= 0) {
                return read;
            }
            aSN1OctetStringParser = (ASN1OctetStringParser) this.f21452a.m27154a();
            if (aSN1OctetStringParser == null) {
                this.f21454c = null;
                return -1;
            }
            this.f21454c = aSN1OctetStringParser.mo6439b();
        }
    }
}
