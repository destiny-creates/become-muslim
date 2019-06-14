package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class acf extends aac<String> implements acg, RandomAccess {
    /* renamed from: a */
    private static final acf f28022a;
    /* renamed from: b */
    private static final acg f28023b = f28022a;
    /* renamed from: c */
    private final List<Object> f28024c;

    static {
        aac acf = new acf();
        f28022a = acf;
        acf.mo3615b();
    }

    public acf() {
        this(10);
    }

    public acf(int i) {
        this(new ArrayList(i));
    }

    private acf(ArrayList<Object> arrayList) {
        this.f28024c = arrayList;
    }

    /* renamed from: a */
    private static String m36721a(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof aai ? ((aai) obj).m17844c() : abs.m17938b((byte[]) obj);
    }

    /* renamed from: a */
    public final /* synthetic */ abv mo6027a(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f28024c);
            return new acf(arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public final void mo3789a(aai aai) {
        m29505c();
        this.f28024c.add(aai);
        this.modCount++;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo3614a() {
        return super.mo3614a();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        m29505c();
        this.f28024c.add(i, str);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        Collection d;
        m29505c();
        if (collection instanceof acg) {
            d = ((acg) collection).mo3791d();
        }
        boolean addAll = this.f28024c.addAll(i, d);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    /* renamed from: b */
    public final Object mo3790b(int i) {
        return this.f28024c.get(i);
    }

    public final void clear() {
        m29505c();
        this.f28024c.clear();
        this.modCount++;
    }

    /* renamed from: d */
    public final List<?> mo3791d() {
        return Collections.unmodifiableList(this.f28024c);
    }

    /* renamed from: e */
    public final acg mo3792e() {
        return mo3614a() ? new aem(this) : this;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.f28024c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        String c;
        if (obj instanceof aai) {
            aai aai = (aai) obj;
            c = aai.m17844c();
            if (aai.mo6043d()) {
                this.f28024c.set(i, c);
            }
            return c;
        }
        byte[] bArr = (byte[]) obj;
        c = abs.m17938b(bArr);
        if (abs.m17937a(bArr)) {
            this.f28024c.set(i, c);
        }
        return c;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i) {
        m29505c();
        Object remove = this.f28024c.remove(i);
        this.modCount++;
        return m36721a(remove);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        m29505c();
        return m36721a(this.f28024c.set(i, str));
    }

    public final int size() {
        return this.f28024c.size();
    }
}
