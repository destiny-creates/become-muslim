package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.C7835j;
import com.google.android.gms.location.C7836n;
import com.google.android.gms.location.ae;

/* renamed from: com.google.android.gms.internal.j.q */
public final class C6803q extends C5015a implements C5019p {
    C6803q(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    /* renamed from: a */
    public final Location mo4641a(String str) {
        Parcel a = m21086a();
        a.writeString(str);
        Parcel a2 = m21087a(21, a);
        Location location = (Location) ap.m21095a(a2, Location.CREATOR);
        a2.recycle();
        return location;
    }

    /* renamed from: a */
    public final void mo4642a(long j, boolean z, PendingIntent pendingIntent) {
        Parcel a = m21086a();
        a.writeLong(j);
        ap.m21098a(a, true);
        ap.m21097a(a, (Parcelable) pendingIntent);
        m21088b(5, a);
    }

    /* renamed from: a */
    public final void mo4643a(ah ahVar) {
        Parcel a = m21086a();
        ap.m21097a(a, (Parcelable) ahVar);
        m21088b(59, a);
    }

    /* renamed from: a */
    public final void mo4644a(ay ayVar) {
        Parcel a = m21086a();
        ap.m21097a(a, (Parcelable) ayVar);
        m21088b(75, a);
    }

    /* renamed from: a */
    public final void mo4645a(ae aeVar, C5018n c5018n) {
        Parcel a = m21086a();
        ap.m21097a(a, (Parcelable) aeVar);
        ap.m21096a(a, (IInterface) c5018n);
        m21088b(74, a);
    }

    /* renamed from: a */
    public final void mo4646a(C7835j c7835j, PendingIntent pendingIntent, C5018n c5018n) {
        Parcel a = m21086a();
        ap.m21097a(a, (Parcelable) c7835j);
        ap.m21097a(a, (Parcelable) pendingIntent);
        ap.m21096a(a, (IInterface) c5018n);
        m21088b(57, a);
    }

    /* renamed from: a */
    public final void mo4647a(C7836n c7836n, C5020r c5020r, String str) {
        Parcel a = m21086a();
        ap.m21097a(a, (Parcelable) c7836n);
        ap.m21096a(a, (IInterface) c5020r);
        a.writeString(str);
        m21088b(63, a);
    }

    /* renamed from: a */
    public final void mo4648a(boolean z) {
        Parcel a = m21086a();
        ap.m21098a(a, z);
        m21088b(12, a);
    }
}
