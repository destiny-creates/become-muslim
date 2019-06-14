package com.google.android.gms.p185e;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.e.fe */
class fe extends es {
    /* renamed from: a */
    private static final String f13290a = C4992a.f16247O.toString();
    /* renamed from: b */
    private static final String f13291b = ab.f16295J.toString();
    /* renamed from: c */
    private static final String f13292c = ab.f16313b.toString();
    /* renamed from: d */
    private static final String f13293d = ab.f16294I.toString();
    /* renamed from: e */
    private static final String f13294e;
    /* renamed from: f */
    private static final Set<String> f13295f = new HashSet();
    /* renamed from: g */
    private final C2939a f13296g;
    /* renamed from: h */
    private final Context f13297h;

    /* renamed from: com.google.android.gms.e.fe$a */
    public interface C2939a {
        /* renamed from: a */
        ax mo2566a();
    }

    public fe(Context context) {
        this(context, new ff(context));
    }

    private fe(Context context, C2939a c2939a) {
        super(f13290a, f13291b);
        this.f13296g = c2939a;
        this.f13297h = context;
    }

    /* renamed from: b */
    public final void mo3297b(Map<String, ct> map) {
        String a = map.get(f13293d) != null ? eu.m8719a((ct) map.get(f13293d)) : null;
        if (a == null || !m16905a(a)) {
            Builder buildUpon = Uri.parse(eu.m8719a((ct) map.get(f13291b))).buildUpon();
            ct ctVar = (ct) map.get(f13292c);
            if (ctVar != null) {
                map = eu.m8734f(ctVar);
                if (map instanceof List) {
                    for (Object next : (List) map) {
                        if (next instanceof Map) {
                            for (Entry entry : ((Map) next).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            map = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ";
                            a = String.valueOf(buildUpon.build().toString());
                            bs.m8582a(a.length() != 0 ? map.concat(a) : new String(map));
                            return;
                        }
                    }
                }
                map = "ArbitraryPixel: additional params not a list: not sending partial hit: ";
                a = String.valueOf(buildUpon.build().toString());
                bs.m8582a(a.length() != 0 ? map.concat(a) : new String(map));
                return;
            }
            map = buildUpon.build().toString();
            this.f13296g.mo2566a().mo2505a(map);
            String str = "ArbitraryPixel: url = ";
            map = String.valueOf(map);
            bs.m8588e(map.length() != 0 ? str.concat(map) : new String(str));
            if (a != null) {
                synchronized (fe.class) {
                    f13295f.add(a);
                    ee.m8703a(this.f13297h, f13294e, a, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
    }

    /* renamed from: a */
    private final synchronized boolean m16905a(String str) {
        if (f13295f.contains(str)) {
            return true;
        }
        if (!this.f13297h.getSharedPreferences(f13294e, 0).contains(str)) {
            return false;
        }
        f13295f.add(str);
        return true;
    }

    static {
        String str = f13290a;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 17);
        stringBuilder.append("gtm_");
        stringBuilder.append(str);
        stringBuilder.append("_unrepeatable");
        f13294e = stringBuilder.toString();
    }
}
