package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.internal.p211j.aj;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.location.j */
public class C7835j extends C4363a {
    public static final Creator<C7835j> CREATOR = new al();
    /* renamed from: a */
    private final List<aj> f29185a;
    /* renamed from: b */
    private final int f29186b;
    /* renamed from: c */
    private final String f29187c;

    /* renamed from: com.google.android.gms.location.j$a */
    public static final class C5079a {
        /* renamed from: a */
        private final List<aj> f17378a = new ArrayList();
        /* renamed from: b */
        private int f17379b = 5;
        /* renamed from: c */
        private String f17380c = "";

        /* renamed from: a */
        public final C5079a m21566a(int i) {
            this.f17379b = i & 7;
            return this;
        }

        /* renamed from: a */
        public final C5079a m21567a(C5076f c5076f) {
            C2872v.a(c5076f, "geofence can't be null.");
            C2872v.b(c5076f instanceof aj, "Geofence must be created using Geofence.Builder.");
            this.f17378a.add((aj) c5076f);
            return this;
        }

        /* renamed from: a */
        public final C5079a m21568a(List<C5076f> list) {
            if (list != null) {
                if (!list.isEmpty()) {
                    for (C5076f c5076f : list) {
                        if (c5076f != null) {
                            m21567a(c5076f);
                        }
                    }
                }
            }
            return this;
        }

        /* renamed from: a */
        public final C7835j m21569a() {
            C2872v.b(this.f17378a.isEmpty() ^ 1, "No geofence has been added to this request.");
            return new C7835j(this.f17378a, this.f17379b, this.f17380c);
        }
    }

    C7835j(List<aj> list, int i, String str) {
        this.f29185a = list;
        this.f29186b = i;
        this.f29187c = str;
    }

    /* renamed from: a */
    public int m38223a() {
        return this.f29186b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GeofencingRequest[");
        stringBuilder.append("geofences=");
        stringBuilder.append(this.f29185a);
        int i = this.f29186b;
        StringBuilder stringBuilder2 = new StringBuilder(30);
        stringBuilder2.append(", initialTrigger=");
        stringBuilder2.append(i);
        stringBuilder2.append(", ");
        stringBuilder.append(stringBuilder2.toString());
        String str = "tag=";
        String valueOf = String.valueOf(this.f29187c);
        stringBuilder.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.c(parcel, 1, this.f29185a, false);
        C2835c.a(parcel, 2, m38223a());
        C2835c.a(parcel, 3, this.f29187c, false);
        C2835c.a(parcel, i);
    }
}
