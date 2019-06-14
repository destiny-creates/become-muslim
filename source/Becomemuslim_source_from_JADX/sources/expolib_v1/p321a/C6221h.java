package expolib_v1.p321a;

import com.facebook.imageutils.JfifUtil;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: CipherSuite */
/* renamed from: expolib_v1.a.h */
public final class C6221h {
    /* renamed from: A */
    public static final C6221h f20185A = C6221h.m25647a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    /* renamed from: B */
    public static final C6221h f20186B = C6221h.m25647a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    /* renamed from: C */
    public static final C6221h f20187C = C6221h.m25647a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    /* renamed from: D */
    public static final C6221h f20188D = C6221h.m25647a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    /* renamed from: E */
    public static final C6221h f20189E = C6221h.m25647a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    /* renamed from: F */
    public static final C6221h f20190F = C6221h.m25647a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    /* renamed from: G */
    public static final C6221h f20191G = C6221h.m25647a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    /* renamed from: H */
    public static final C6221h f20192H = C6221h.m25647a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    /* renamed from: I */
    public static final C6221h f20193I = C6221h.m25647a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    /* renamed from: J */
    public static final C6221h f20194J = C6221h.m25647a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    /* renamed from: K */
    public static final C6221h f20195K = C6221h.m25647a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    /* renamed from: L */
    public static final C6221h f20196L = C6221h.m25647a("TLS_RSA_WITH_NULL_SHA256", 59);
    /* renamed from: M */
    public static final C6221h f20197M = C6221h.m25647a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    /* renamed from: N */
    public static final C6221h f20198N = C6221h.m25647a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    /* renamed from: O */
    public static final C6221h f20199O = C6221h.m25647a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    /* renamed from: P */
    public static final C6221h f20200P = C6221h.m25647a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    /* renamed from: Q */
    public static final C6221h f20201Q = C6221h.m25647a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    /* renamed from: R */
    public static final C6221h f20202R = C6221h.m25647a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    /* renamed from: S */
    public static final C6221h f20203S = C6221h.m25647a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    /* renamed from: T */
    public static final C6221h f20204T = C6221h.m25647a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    /* renamed from: U */
    public static final C6221h f20205U = C6221h.m25647a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    /* renamed from: V */
    public static final C6221h f20206V = C6221h.m25647a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    /* renamed from: W */
    public static final C6221h f20207W = C6221h.m25647a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    /* renamed from: X */
    public static final C6221h f20208X = C6221h.m25647a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    /* renamed from: Y */
    public static final C6221h f20209Y = C6221h.m25647a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    /* renamed from: Z */
    public static final C6221h f20210Z = C6221h.m25647a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    /* renamed from: a */
    public static final C6221h f20211a = C6221h.m25647a("SSL_RSA_WITH_NULL_MD5", 1);
    public static final C6221h aA = C6221h.m25647a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final C6221h aB = C6221h.m25647a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final C6221h aC = C6221h.m25647a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final C6221h aD = C6221h.m25647a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final C6221h aE = C6221h.m25647a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final C6221h aF = C6221h.m25647a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final C6221h aG = C6221h.m25647a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final C6221h aH = C6221h.m25647a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final C6221h aI = C6221h.m25647a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final C6221h aJ = C6221h.m25647a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final C6221h aK = C6221h.m25647a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final C6221h aL = C6221h.m25647a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final C6221h aM = C6221h.m25647a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final C6221h aN = C6221h.m25647a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final C6221h aO = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final C6221h aP = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final C6221h aQ = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final C6221h aR = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final C6221h aS = C6221h.m25647a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final C6221h aT = C6221h.m25647a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final C6221h aU = C6221h.m25647a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final C6221h aV = C6221h.m25647a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final C6221h aW = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final C6221h aX = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final C6221h aY = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final C6221h aZ = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final C6221h aa = C6221h.m25647a("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final C6221h ab = C6221h.m25647a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final C6221h ac = C6221h.m25647a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final C6221h ad = C6221h.m25647a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final C6221h ae = C6221h.m25647a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final C6221h af = C6221h.m25647a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final C6221h ag = C6221h.m25647a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final C6221h ah = C6221h.m25647a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final C6221h ai = C6221h.m25647a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final C6221h aj = C6221h.m25647a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final C6221h ak = C6221h.m25647a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final C6221h al = C6221h.m25647a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final C6221h am = C6221h.m25647a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final C6221h an = C6221h.m25647a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", JfifUtil.MARKER_FIRST_BYTE);
    public static final C6221h ao = C6221h.m25647a("TLS_FALLBACK_SCSV", 22016);
    public static final C6221h ap = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final C6221h aq = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final C6221h ar = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final C6221h as = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final C6221h at = C6221h.m25647a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final C6221h au = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final C6221h av = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final C6221h aw = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final C6221h ax = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final C6221h ay = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final C6221h az = C6221h.m25647a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    /* renamed from: b */
    public static final C6221h f20212b = C6221h.m25647a("SSL_RSA_WITH_NULL_SHA", 2);
    public static final C6221h ba = C6221h.m25647a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final C6221h bb = C6221h.m25647a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final C6221h bc = C6221h.m25647a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final C6221h bd = C6221h.m25647a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final C6221h be = C6221h.m25647a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final C6221h bf = C6221h.m25647a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final C6221h bg = C6221h.m25647a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final C6221h bh = C6221h.m25647a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    private static final ConcurrentMap<String, C6221h> bj = new ConcurrentHashMap();
    /* renamed from: c */
    public static final C6221h f20213c = C6221h.m25647a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    /* renamed from: d */
    public static final C6221h f20214d = C6221h.m25647a("SSL_RSA_WITH_RC4_128_MD5", 4);
    /* renamed from: e */
    public static final C6221h f20215e = C6221h.m25647a("SSL_RSA_WITH_RC4_128_SHA", 5);
    /* renamed from: f */
    public static final C6221h f20216f = C6221h.m25647a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    /* renamed from: g */
    public static final C6221h f20217g = C6221h.m25647a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    /* renamed from: h */
    public static final C6221h f20218h = C6221h.m25647a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    /* renamed from: i */
    public static final C6221h f20219i = C6221h.m25647a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    /* renamed from: j */
    public static final C6221h f20220j = C6221h.m25647a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    /* renamed from: k */
    public static final C6221h f20221k = C6221h.m25647a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    /* renamed from: l */
    public static final C6221h f20222l = C6221h.m25647a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    /* renamed from: m */
    public static final C6221h f20223m = C6221h.m25647a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    /* renamed from: n */
    public static final C6221h f20224n = C6221h.m25647a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    /* renamed from: o */
    public static final C6221h f20225o = C6221h.m25647a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    /* renamed from: p */
    public static final C6221h f20226p = C6221h.m25647a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    /* renamed from: q */
    public static final C6221h f20227q = C6221h.m25647a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    /* renamed from: r */
    public static final C6221h f20228r = C6221h.m25647a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    /* renamed from: s */
    public static final C6221h f20229s = C6221h.m25647a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    /* renamed from: t */
    public static final C6221h f20230t = C6221h.m25647a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    /* renamed from: u */
    public static final C6221h f20231u = C6221h.m25647a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    /* renamed from: v */
    public static final C6221h f20232v = C6221h.m25647a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    /* renamed from: w */
    public static final C6221h f20233w = C6221h.m25647a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    /* renamed from: x */
    public static final C6221h f20234x = C6221h.m25647a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    /* renamed from: y */
    public static final C6221h f20235y = C6221h.m25647a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    /* renamed from: z */
    public static final C6221h f20236z = C6221h.m25647a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    final String bi;

    /* renamed from: a */
    public static C6221h m25646a(String str) {
        C6221h c6221h = (C6221h) bj.get(str);
        if (c6221h != null) {
            return c6221h;
        }
        c6221h = new C6221h(str);
        C6221h c6221h2 = (C6221h) bj.putIfAbsent(str, c6221h);
        return c6221h2 == null ? c6221h : c6221h2;
    }

    private C6221h(String str) {
        if (str != null) {
            this.bi = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private static C6221h m25647a(String str, int i) {
        return C6221h.m25646a(str);
    }

    /* renamed from: a */
    public String m25648a() {
        return this.bi;
    }

    public String toString() {
        return this.bi;
    }
}
