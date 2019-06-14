package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xo.C8309b;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ui {
    /* renamed from: a */
    private static final Logger f16052a = Logger.getLogger(ui.class.getName());
    /* renamed from: b */
    private static final ConcurrentMap<String, ua> f16053b = new ConcurrentHashMap();
    /* renamed from: c */
    private static final ConcurrentMap<String, Boolean> f16054c = new ConcurrentHashMap();
    /* renamed from: d */
    private static final ConcurrentMap<String, tu> f16055d = new ConcurrentHashMap();

    /* renamed from: a */
    public static <P> acx m20146a(String str, acx acx) {
        ua b = m20156b(str);
        if (((Boolean) f16054c.get(str)).booleanValue()) {
            return b.mo4383b(acx);
        }
        String str2 = "newKey-operation not permitted for key type ";
        str = String.valueOf(str);
        throw new GeneralSecurityException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    /* renamed from: a */
    public static <P> tu<P> m20147a(String str) {
        if (str != null) {
            tu<P> tuVar = (tu) f16055d.get(str.toLowerCase());
            if (tuVar != null) {
                return tuVar;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.init().");
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                str = String.valueOf(format);
                format = "Maybe call DeterministicAeadConfig.init().";
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                str = String.valueOf(format);
                format = "Maybe call StreamingAeadConfig.init().";
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                str = String.valueOf(format);
                format = "Maybe call HybridConfig.init().";
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                str = String.valueOf(format);
                format = "Maybe call MacConfig.init().";
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                str = String.valueOf(format);
                format = "Maybe call SignatureConfig.init().";
            } else {
                if (str.toLowerCase().startsWith("tink")) {
                    str = String.valueOf(format);
                    format = "Maybe call TinkConfig.init().";
                }
                throw new GeneralSecurityException(format);
            }
            format = str.concat(format);
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    /* renamed from: a */
    public static <P> ug<P> m20148a(ub ubVar, ua<P> uaVar) {
        uj.m20159b(ubVar.m20135a());
        ug<P> ugVar = new ug();
        for (C8309b c8309b : ubVar.m20135a().m43747b()) {
            if (c8309b.m43740c() == xi.ENABLED) {
                uh a = ugVar.m20142a(m20150a(c8309b.m43739b().m43705a(), c8309b.m43739b().m43706b()), c8309b);
                if (c8309b.m43741d() == ubVar.m20135a().m43745a()) {
                    ugVar.m20143a(a);
                }
            }
        }
        return ugVar;
    }

    /* renamed from: a */
    public static <P> xf m20149a(xk xkVar) {
        ua b = m20156b(xkVar.m43711a());
        if (((Boolean) f16054c.get(xkVar.m43711a())).booleanValue()) {
            return b.mo4384c(xkVar.m43712b());
        }
        String str = "newKey-operation not permitted for key type ";
        String valueOf = String.valueOf(xkVar.m43711a());
        throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: a */
    private static <P> P m20150a(String str, aai aai) {
        return m20156b(str).mo4380a(aai);
    }

    /* renamed from: a */
    public static <P> P m20151a(String str, byte[] bArr) {
        return m20150a(str, aai.m17831a(bArr));
    }

    /* renamed from: a */
    public static synchronized <P> void m20152a(String str, tu<P> tuVar) {
        synchronized (ui.class) {
            if (f16055d.containsKey(str.toLowerCase())) {
                if (!tuVar.getClass().equals(((tu) f16055d.get(str.toLowerCase())).getClass())) {
                    Logger logger = f16052a;
                    Level level = Level.WARNING;
                    String str2 = "com.google.crypto.tink.Registry";
                    String str3 = "addCatalogue";
                    String str4 = "Attempted overwrite of a catalogueName catalogue for name ";
                    String valueOf = String.valueOf(str);
                    logger.logp(level, str2, str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 47);
                    stringBuilder.append("catalogue for name ");
                    stringBuilder.append(str);
                    stringBuilder.append(" has been already registered");
                    throw new GeneralSecurityException(stringBuilder.toString());
                }
            }
            f16055d.put(str.toLowerCase(), tuVar);
        }
    }

    /* renamed from: a */
    public static <P> void m20153a(String str, ua<P> uaVar) {
        m20154a(str, uaVar, true);
    }

    /* renamed from: a */
    public static synchronized <P> void m20154a(String str, ua<P> uaVar, boolean z) {
        synchronized (ui.class) {
            if (uaVar != null) {
                if (f16053b.containsKey(str)) {
                    ua b = m20156b(str);
                    boolean booleanValue = ((Boolean) f16054c.get(str)).booleanValue();
                    if (!uaVar.getClass().equals(b.getClass()) || (!booleanValue && z)) {
                        Logger logger = f16052a;
                        Level level = Level.WARNING;
                        String str2 = "com.google.crypto.tink.Registry";
                        String str3 = "registerKeyManager";
                        String str4 = "Attempted overwrite of a registered key manager for key type ";
                        String valueOf = String.valueOf(str);
                        logger.logp(level, str2, str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                        throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{str, b.getClass().getName(), uaVar.getClass().getName()}));
                    }
                }
                f16053b.put(str, uaVar);
                f16054c.put(str, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    /* renamed from: b */
    public static <P> acx m20155b(xk xkVar) {
        ua b = m20156b(xkVar.m43711a());
        if (((Boolean) f16054c.get(xkVar.m43711a())).booleanValue()) {
            return b.mo4382b(xkVar.m43712b());
        }
        String str = "newKey-operation not permitted for key type ";
        String valueOf = String.valueOf(xkVar.m43711a());
        throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: b */
    private static <P> ua<P> m20156b(String str) {
        ua<P> uaVar = (ua) f16053b.get(str);
        if (uaVar != null) {
            return uaVar;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 78);
        stringBuilder.append("No key manager found for key type: ");
        stringBuilder.append(str);
        stringBuilder.append(".  Check the configuration of the registry.");
        throw new GeneralSecurityException(stringBuilder.toString());
    }

    /* renamed from: b */
    public static <P> P m20157b(String str, acx acx) {
        return m20156b(str).mo4381a(acx);
    }
}
