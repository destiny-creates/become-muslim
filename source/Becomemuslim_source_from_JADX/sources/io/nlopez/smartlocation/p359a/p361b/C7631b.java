package io.nlopez.smartlocation.p359a.p361b;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.GooglePlayServicesUtil;
import io.nlopez.smartlocation.C6544d;
import io.nlopez.smartlocation.p359a.C6527a;
import io.nlopez.smartlocation.p359a.p360a.C6526b;
import io.nlopez.smartlocation.p364b.C6537a;
import io.nlopez.smartlocation.p364b.C6538b;

/* compiled from: LocationGooglePlayServicesWithFallbackProvider */
/* renamed from: io.nlopez.smartlocation.a.b.b */
public class C7631b implements C6527a, C6537a {
    /* renamed from: a */
    private C6538b f26360a;
    /* renamed from: b */
    private C6544d f26361b;
    /* renamed from: c */
    private boolean f26362c = false;
    /* renamed from: d */
    private Context f26363d;
    /* renamed from: e */
    private C6526b f26364e;
    /* renamed from: f */
    private boolean f26365f = false;
    /* renamed from: g */
    private C6527a f26366g;

    /* renamed from: a */
    public void mo5493a(Bundle bundle) {
    }

    public C7631b(Context context) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == null) {
            this.f26366g = new C8187a(this);
        } else {
            this.f26366g = new C7632c();
        }
    }

    /* renamed from: a */
    public void mo5492a(Context context, C6538b c6538b) {
        this.f26360a = c6538b;
        this.f26363d = context;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Currently selected provider = ");
        stringBuilder.append(this.f26366g.getClass().getSimpleName());
        c6538b.mo5497a(stringBuilder.toString(), new Object[0]);
        this.f26366g.mo5492a(context, c6538b);
    }

    /* renamed from: a */
    public void mo5495a(C6544d c6544d, C6526b c6526b, boolean z) {
        this.f26362c = true;
        this.f26361b = c6544d;
        this.f26364e = c6526b;
        this.f26365f = z;
        this.f26366g.mo5495a(c6544d, c6526b, z);
    }

    /* renamed from: a */
    public void mo5490a() {
        this.f26366g.mo5490a();
        this.f26362c = false;
    }

    /* renamed from: b */
    public Location mo5496b() {
        return this.f26366g.mo5496b();
    }

    /* renamed from: a */
    public void mo5491a(int i) {
        m34465c();
    }

    /* renamed from: a */
    public void mo5494a(C4775b c4775b) {
        m34465c();
    }

    /* renamed from: c */
    private void m34465c() {
        this.f26360a.mo5497a("FusedLocationProvider not working, falling back and using LocationManager", new Object[0]);
        this.f26366g = new C7632c();
        this.f26366g.mo5492a(this.f26363d, this.f26360a);
        if (this.f26362c) {
            this.f26366g.mo5495a(this.f26361b, this.f26364e, this.f26365f);
        }
    }
}
