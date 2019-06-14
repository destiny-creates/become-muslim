package com.google.android.gms.fitness.p187a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2868t.C2867a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.common.util.C2892b;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.p208g.af;
import com.google.android.gms.internal.p208g.ag;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.a.b */
public class C4793b extends C4363a {
    public static final Creator<C4793b> CREATOR = new C2982t();
    /* renamed from: a */
    private final List<DataType> f13340a;
    /* renamed from: b */
    private final List<Integer> f13341b;
    /* renamed from: c */
    private final boolean f13342c;
    /* renamed from: d */
    private final af f13343d;

    /* renamed from: com.google.android.gms.fitness.a.b$a */
    public static class C2969a {
        /* renamed from: a */
        private DataType[] f7623a = new DataType[0];
        /* renamed from: b */
        private int[] f7624b = new int[]{0, 1};
        /* renamed from: c */
        private boolean f7625c = false;

        /* renamed from: a */
        public C2969a m8817a(DataType... dataTypeArr) {
            this.f7623a = dataTypeArr;
            return this;
        }

        /* renamed from: a */
        public C4793b m8818a() {
            boolean z = false;
            C2872v.m8387a(this.f7623a.length > 0, (Object) "Must add at least one data type");
            if (this.f7624b.length > 0) {
                z = true;
            }
            C2872v.m8387a(z, (Object) "Must add at least one data source type");
            return new C4793b();
        }
    }

    private C4793b(C2969a c2969a) {
        this(C2892b.m8417a(c2969a.f7623a), Arrays.asList(C2892b.m8419a(c2969a.f7624b)), false, null);
    }

    public C4793b(C4793b c4793b, af afVar) {
        this(c4793b.f13340a, c4793b.f13341b, c4793b.f13342c, afVar);
    }

    C4793b(List<DataType> list, List<Integer> list2, boolean z, IBinder iBinder) {
        this.f13340a = list;
        this.f13341b = list2;
        this.f13342c = z;
        this.f13343d = ag.a(iBinder);
    }

    private C4793b(List<DataType> list, List<Integer> list2, boolean z, af afVar) {
        this.f13340a = list;
        this.f13341b = list2;
        this.f13342c = z;
        this.f13343d = afVar;
    }

    /* renamed from: a */
    public List<DataType> m16946a() {
        return this.f13340a;
    }

    public String toString() {
        C2867a a = C2868t.m8373a((Object) this).m8371a("dataTypes", this.f13340a).m8371a("sourceTypes", this.f13341b);
        if (this.f13342c) {
            a.m8371a("includeDbOnlySources", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8207c(parcel, 1, m16946a(), false);
        C2835c.m8194a(parcel, 2, this.f13341b, false);
        C2835c.m8196a(parcel, 3, this.f13342c);
        C2835c.m8187a(parcel, 4, this.f13343d == null ? null : this.f13343d.asBinder(), false);
        C2835c.m8180a(parcel, i);
    }
}
