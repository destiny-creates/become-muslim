package com.google.android.gms.internal.p210i;

import com.google.android.gms.p185e.eu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.dc */
public final class dc {
    /* renamed from: a */
    private final List<dd> f16477a;
    /* renamed from: b */
    private final Map<String, List<cz>> f16478b;
    /* renamed from: c */
    private String f16479c;
    /* renamed from: d */
    private int f16480d;

    private dc() {
        this.f16477a = new ArrayList();
        this.f16478b = new HashMap();
        this.f16479c = "";
        this.f16480d = 0;
    }

    /* renamed from: a */
    public final dc m20420a(dd ddVar) {
        this.f16477a.add(ddVar);
        return this;
    }

    /* renamed from: a */
    public final dc m20419a(cz czVar) {
        String a = eu.a((ct) czVar.m20408b().get(ab.INSTANCE_NAME.toString()));
        List list = (List) this.f16478b.get(a);
        if (list == null) {
            list = new ArrayList();
            this.f16478b.put(a, list);
        }
        list.add(czVar);
        return this;
    }

    /* renamed from: a */
    public final dc m20421a(String str) {
        this.f16479c = str;
        return this;
    }

    /* renamed from: a */
    public final dc m20418a(int i) {
        this.f16480d = i;
        return this;
    }

    /* renamed from: a */
    public final db m20417a() {
        return new db(this.f16477a, this.f16478b, this.f16479c, this.f16480d);
    }
}
