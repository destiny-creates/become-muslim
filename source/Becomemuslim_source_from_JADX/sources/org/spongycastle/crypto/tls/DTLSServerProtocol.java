package org.spongycastle.crypto.tls;

import java.util.Hashtable;

public class DTLSServerProtocol extends DTLSProtocol {

    protected static class ServerHandshakeState {
        /* renamed from: a */
        TlsServer f22492a = null;
        /* renamed from: b */
        TlsServerContextImpl f22493b = null;
        /* renamed from: c */
        int[] f22494c = null;
        /* renamed from: d */
        short[] f22495d = null;
        /* renamed from: e */
        Hashtable f22496e = null;
        /* renamed from: f */
        Hashtable f22497f = null;
        /* renamed from: g */
        boolean f22498g = false;
        /* renamed from: h */
        boolean f22499h = false;
        /* renamed from: i */
        boolean f22500i = false;
        /* renamed from: j */
        boolean f22501j = false;
        /* renamed from: k */
        TlsKeyExchange f22502k = null;
        /* renamed from: l */
        TlsCredentials f22503l = null;
        /* renamed from: m */
        CertificateRequest f22504m = null;
        /* renamed from: n */
        short f22505n = (short) -1;
        /* renamed from: o */
        Certificate f22506o = null;

        protected ServerHandshakeState() {
        }
    }
}
