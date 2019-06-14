package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import org.spongycastle.crypto.tls.SessionParameters.Builder;

public class DTLSClientProtocol extends DTLSProtocol {

    protected static class ClientHandshakeState {
        /* renamed from: a */
        TlsClient f22471a = null;
        /* renamed from: b */
        TlsClientContextImpl f22472b = null;
        /* renamed from: c */
        TlsSession f22473c = null;
        /* renamed from: d */
        SessionParameters f22474d = null;
        /* renamed from: e */
        Builder f22475e = null;
        /* renamed from: f */
        int[] f22476f = null;
        /* renamed from: g */
        short[] f22477g = null;
        /* renamed from: h */
        Hashtable f22478h = null;
        /* renamed from: i */
        Hashtable f22479i = null;
        /* renamed from: j */
        byte[] f22480j = null;
        /* renamed from: k */
        boolean f22481k = false;
        /* renamed from: l */
        boolean f22482l = false;
        /* renamed from: m */
        boolean f22483m = false;
        /* renamed from: n */
        boolean f22484n = false;
        /* renamed from: o */
        TlsKeyExchange f22485o = null;
        /* renamed from: p */
        TlsAuthentication f22486p = null;
        /* renamed from: q */
        CertificateStatus f22487q = null;
        /* renamed from: r */
        CertificateRequest f22488r = null;
        /* renamed from: s */
        TlsCredentials f22489s = null;

        protected ClientHandshakeState() {
        }
    }
}
