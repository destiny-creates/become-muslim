package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

@cm
public final class mv extends C4363a {
    public static final Creator<mv> CREATOR = new mw();
    /* renamed from: a */
    public String f28709a;
    /* renamed from: b */
    public int f28710b;
    /* renamed from: c */
    public int f28711c;
    /* renamed from: d */
    public boolean f28712d;
    /* renamed from: e */
    public boolean f28713e;

    public mv(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public mv(int i, int i2, boolean z, boolean z2) {
        this((int) C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE, i2, true, false, z2);
    }

    private mv(int i, int i2, boolean z, boolean z2, boolean z3) {
        String str = z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 36);
        stringBuilder.append("afma-sdk-a-v");
        stringBuilder.append(i);
        stringBuilder.append(".");
        stringBuilder.append(i2);
        stringBuilder.append(".");
        stringBuilder.append(str);
        this(stringBuilder.toString(), i, i2, z, z3);
    }

    mv(String str, int i, int i2, boolean z, boolean z2) {
        this.f28709a = str;
        this.f28710b = i;
        this.f28711c = i2;
        this.f28712d = z;
        this.f28713e = z2;
    }

    /* renamed from: a */
    public static mv m37566a() {
        return new mv(12451009, 12451009, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28709a, false);
        C2835c.a(parcel, 3, this.f28710b);
        C2835c.a(parcel, 4, this.f28711c);
        C2835c.a(parcel, 5, this.f28712d);
        C2835c.a(parcel, 6, this.f28713e);
        C2835c.a(parcel, i);
    }
}
