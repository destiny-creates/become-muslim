package com.google.android.gms.internal.p215n;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.RemoteViews;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.internal.n.p */
public final class C7833p extends C4363a {
    public static final Creator<C7833p> CREATOR = new C5069q();
    /* renamed from: a */
    private String[] f29143a;
    /* renamed from: b */
    private int[] f29144b;
    /* renamed from: c */
    private RemoteViews f29145c;
    /* renamed from: d */
    private byte[] f29146d;

    private C7833p() {
    }

    public C7833p(String[] strArr, int[] iArr, RemoteViews remoteViews, byte[] bArr) {
        this.f29143a = strArr;
        this.f29144b = iArr;
        this.f29145c = remoteViews;
        this.f29146d = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f29143a, false);
        C2835c.a(parcel, 2, this.f29144b, false);
        C2835c.a(parcel, 3, this.f29145c, i, false);
        C2835c.a(parcel, 4, this.f29146d, false);
        C2835c.a(parcel, a);
    }
}
