package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.CamelliaEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.RC4Engine;
import org.spongycastle.crypto.engines.SEEDEngine;
import org.spongycastle.crypto.engines.Salsa20Engine;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;

public class DefaultTlsCipherFactory extends AbstractTlsCipherFactory {
    /* renamed from: a */
    public TlsCipher mo5807a(TlsContext tlsContext, int i, int i2) {
        if (i == 0) {
            return m40884b(tlsContext, i2);
        }
        if (i == 2) {
            return m40895g(tlsContext, 16, i2);
        }
        switch (i) {
            case 7:
                return m40877a(tlsContext, i2);
            case 8:
                return m40883b(tlsContext, 16, i2);
            case 9:
                return m40883b(tlsContext, 32, i2);
            case 10:
                return m40891e(tlsContext, 16, 16);
            case 11:
                return m40891e(tlsContext, 32, 16);
            case 12:
                return m40887c(tlsContext, 16, i2);
            case 13:
                return m40887c(tlsContext, 32, i2);
            case 14:
                return m40886c(tlsContext, i2);
            case 15:
                return m40889d(tlsContext, 16, 16);
            case 16:
                return m40889d(tlsContext, 16, 8);
            case 17:
                return m40889d(tlsContext, 32, 16);
            case 18:
                return m40889d(tlsContext, 32, 8);
            case 19:
                return m40893f(tlsContext, 16, 16);
            case 20:
                return m40893f(tlsContext, 32, 16);
            default:
                switch (i) {
                    case 100:
                        return m40880a(tlsContext, 12, 32, i2);
                    case 101:
                        return m40880a(tlsContext, 20, 32, i2);
                    case 102:
                        return m40878a(tlsContext);
                    default:
                        throw new TlsFatalAlert(80);
                }
        }
    }

    /* renamed from: b */
    protected TlsBlockCipher m40883b(TlsContext tlsContext, int i, int i2) {
        return new TlsBlockCipher(tlsContext, m40885c(), m40885c(), m40882b(i2), m40882b(i2), i);
    }

    /* renamed from: c */
    protected TlsBlockCipher m40887c(TlsContext tlsContext, int i, int i2) {
        return new TlsBlockCipher(tlsContext, m40894g(), m40894g(), m40882b(i2), m40882b(i2), i);
    }

    /* renamed from: a */
    protected TlsCipher m40878a(TlsContext tlsContext) {
        return new Chacha20Poly1305(tlsContext);
    }

    /* renamed from: d */
    protected TlsAEADCipher m40889d(TlsContext tlsContext, int i, int i2) {
        return new TlsAEADCipher(tlsContext, m40888d(), m40888d(), i, i2);
    }

    /* renamed from: e */
    protected TlsAEADCipher m40891e(TlsContext tlsContext, int i, int i2) {
        return new TlsAEADCipher(tlsContext, m40890e(), m40890e(), i, i2);
    }

    /* renamed from: f */
    protected TlsAEADCipher m40893f(TlsContext tlsContext, int i, int i2) {
        return new TlsAEADCipher(tlsContext, m40892f(), m40892f(), i, i2);
    }

    /* renamed from: a */
    protected TlsBlockCipher m40877a(TlsContext tlsContext, int i) {
        return new TlsBlockCipher(tlsContext, m40896h(), m40896h(), m40882b(i), m40882b(i), 24);
    }

    /* renamed from: b */
    protected TlsNullCipher m40884b(TlsContext tlsContext, int i) {
        return new TlsNullCipher(tlsContext, m40882b(i), m40882b(i));
    }

    /* renamed from: g */
    protected TlsStreamCipher m40895g(TlsContext tlsContext, int i, int i2) {
        return new TlsStreamCipher(tlsContext, m40897i(), m40897i(), m40882b(i2), m40882b(i2), i, false);
    }

    /* renamed from: a */
    protected TlsStreamCipher m40880a(TlsContext tlsContext, int i, int i2, int i3) {
        return new TlsStreamCipher(tlsContext, m40876a(i), m40876a(i), m40882b(i3), m40882b(i3), i2, true);
    }

    /* renamed from: c */
    protected TlsBlockCipher m40886c(TlsContext tlsContext, int i) {
        return new TlsBlockCipher(tlsContext, m40898j(), m40898j(), m40882b(i), m40882b(i), 16);
    }

    /* renamed from: a */
    protected BlockCipher m40875a() {
        return new AESEngine();
    }

    /* renamed from: b */
    protected BlockCipher m40881b() {
        return new CamelliaEngine();
    }

    /* renamed from: c */
    protected BlockCipher m40885c() {
        return new CBCBlockCipher(m40875a());
    }

    /* renamed from: d */
    protected AEADBlockCipher m40888d() {
        return new CCMBlockCipher(m40875a());
    }

    /* renamed from: e */
    protected AEADBlockCipher m40890e() {
        return new GCMBlockCipher(m40875a());
    }

    /* renamed from: f */
    protected AEADBlockCipher m40892f() {
        return new GCMBlockCipher(m40881b());
    }

    /* renamed from: g */
    protected BlockCipher m40894g() {
        return new CBCBlockCipher(m40881b());
    }

    /* renamed from: h */
    protected BlockCipher m40896h() {
        return new CBCBlockCipher(new DESedeEngine());
    }

    /* renamed from: i */
    protected StreamCipher m40897i() {
        return new RC4Engine();
    }

    /* renamed from: a */
    protected StreamCipher m40876a(int i) {
        return new Salsa20Engine(i);
    }

    /* renamed from: j */
    protected BlockCipher m40898j() {
        return new CBCBlockCipher(new SEEDEngine());
    }

    /* renamed from: b */
    protected Digest m40882b(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return TlsUtils.m27855c((short) 1);
            case 2:
                return TlsUtils.m27855c((short) 2);
            case 3:
                return TlsUtils.m27855c((short) 4);
            case 4:
                return TlsUtils.m27855c((short) 5);
            case 5:
                return TlsUtils.m27855c((short) 6);
            default:
                throw new TlsFatalAlert((short) 80);
        }
    }
}
