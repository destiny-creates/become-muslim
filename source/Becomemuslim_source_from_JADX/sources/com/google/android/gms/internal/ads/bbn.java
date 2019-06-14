package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@cm
public final class bbn implements azw, bbm {
    /* renamed from: a */
    private final bbl f32209a;
    /* renamed from: b */
    private final HashSet<SimpleEntry<String, ae<? super bbl>>> f32210b = new HashSet();

    public bbn(bbl bbl) {
        this.f32209a = bbl;
    }

    /* renamed from: a */
    public final void mo6657a() {
        Iterator it = this.f32210b.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((ae) simpleEntry.getValue()).toString());
            jn.m30864a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f32209a.mo6656b((String) simpleEntry.getKey(), (ae) simpleEntry.getValue());
        }
        this.f32210b.clear();
    }

    /* renamed from: a */
    public final void mo6655a(String str, ae<? super bbl> aeVar) {
        this.f32209a.mo6655a(str, aeVar);
        this.f32210b.add(new SimpleEntry(str, aeVar));
    }

    /* renamed from: a */
    public final void mo6649a(String str, String str2) {
        azx.m19177a((azw) this, str, str2);
    }

    /* renamed from: a */
    public final void mo6650a(String str, Map map) {
        azx.m19178a((azw) this, str, map);
    }

    /* renamed from: a */
    public final void mo4089a(String str, JSONObject jSONObject) {
        azx.m19180b(this, str, jSONObject);
    }

    /* renamed from: b */
    public final void mo4090b(String str) {
        this.f32209a.mo4090b(str);
    }

    /* renamed from: b */
    public final void mo6656b(String str, ae<? super bbl> aeVar) {
        this.f32209a.mo6656b(str, aeVar);
        this.f32210b.remove(new SimpleEntry(str, aeVar));
    }

    /* renamed from: b */
    public final void mo6652b(String str, JSONObject jSONObject) {
        azx.m19179a((azw) this, str, jSONObject);
    }
}
