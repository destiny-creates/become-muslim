package com.google.android.gms.internal.p210i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.ga */
public final class ga extends du<String> implements gb, RandomAccess {
    /* renamed from: a */
    private static final ga f28910a;
    /* renamed from: b */
    private static final gb f28911b = f28910a;
    /* renamed from: c */
    private final List<Object> f28912c;

    public ga() {
        this(10);
    }

    public ga(int i) {
        this(new ArrayList(i));
    }

    private ga(ArrayList<Object> arrayList) {
        this.f28912c = arrayList;
    }

    public final int size() {
        return this.f28912c.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        m31336c();
        if (collection instanceof gb) {
            collection = ((gb) collection).mo4605d();
        }
        i = this.f28912c.addAll(i, collection);
        this.modCount++;
        return i;
    }

    public final void clear() {
        m31336c();
        this.f28912c.clear();
        this.modCount++;
    }

    /* renamed from: a */
    public final void mo4603a(dy dyVar) {
        m31336c();
        this.f28912c.add(dyVar);
        this.modCount++;
    }

    /* renamed from: b */
    public final Object mo4604b(int i) {
        return this.f28912c.get(i);
    }

    /* renamed from: a */
    private static String m37960a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof dy) {
            return ((dy) obj).m20464b();
        }
        return fm.m20561b((byte[]) obj);
    }

    /* renamed from: d */
    public final List<?> mo4605d() {
        return Collections.unmodifiableList(this.f28912c);
    }

    /* renamed from: e */
    public final gb mo4606e() {
        return mo4429a() ? new ie(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        m31336c();
        return ga.m37960a(this.f28912c.set(i, str));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* synthetic */ Object remove(int i) {
        m31336c();
        Object remove = this.f28912c.remove(i);
        this.modCount++;
        return ga.m37960a(remove);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo4429a() {
        return super.mo4429a();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        m31336c();
        this.f28912c.add(i, str);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: a */
    public final /* synthetic */ fr mo6150a(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f28912c);
            return new ga(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.f28912c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        String b;
        if (obj instanceof dy) {
            dy dyVar = (dy) obj;
            b = dyVar.m20464b();
            if (dyVar.mo6167c()) {
                this.f28912c.set(i, b);
            }
            return b;
        }
        byte[] bArr = (byte[]) obj;
        b = fm.m20561b(bArr);
        if (fm.m20560a(bArr)) {
            this.f28912c.set(i, b);
        }
        return b;
    }

    static {
        du gaVar = new ga();
        f28910a = gaVar;
        gaVar.mo4430b();
    }
}
