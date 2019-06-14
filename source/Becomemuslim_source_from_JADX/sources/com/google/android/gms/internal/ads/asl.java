package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

@cm
public final class asl {
    /* renamed from: a */
    private final Collection<asf<?>> f14900a = new ArrayList();
    /* renamed from: b */
    private final Collection<asf<String>> f14901b = new ArrayList();
    /* renamed from: c */
    private final Collection<asf<String>> f14902c = new ArrayList();

    /* renamed from: a */
    public final List<String> m18882a() {
        List<String> arrayList = new ArrayList();
        for (asf a : this.f14901b) {
            String str = (String) aph.m18688f().m18889a(a);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m18883a(Editor editor, int i, JSONObject jSONObject) {
        for (asf asf : this.f14900a) {
            if (asf.m18881c() == 1) {
                asf.mo3957a(editor, asf.mo3956a(jSONObject));
            }
        }
    }

    /* renamed from: a */
    public final void m18884a(asf asf) {
        this.f14900a.add(asf);
    }

    /* renamed from: b */
    public final List<String> m18885b() {
        List<String> a = m18882a();
        for (asf a2 : this.f14902c) {
            String str = (String) aph.m18688f().m18889a(a2);
            if (str != null) {
                a.add(str);
            }
        }
        return a;
    }

    /* renamed from: b */
    public final void m18886b(asf<String> asf) {
        this.f14901b.add(asf);
    }

    /* renamed from: c */
    public final void m18887c(asf<String> asf) {
        this.f14902c.add(asf);
    }
}
