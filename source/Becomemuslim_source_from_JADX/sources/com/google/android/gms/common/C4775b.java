package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.common.b */
public final class C4775b extends C4363a {
    public static final Creator<C4775b> CREATOR = new C2878o();
    /* renamed from: a */
    public static final C4775b f13206a = new C4775b(0);
    /* renamed from: b */
    private final int f13207b;
    /* renamed from: c */
    private final int f13208c;
    /* renamed from: d */
    private final PendingIntent f13209d;
    /* renamed from: e */
    private final String f13210e;

    C4775b(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f13207b = i;
        this.f13208c = i2;
        this.f13209d = pendingIntent;
        this.f13210e = str;
    }

    public C4775b(int i) {
        this(i, null, null);
    }

    public C4775b(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public C4775b(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    /* renamed from: a */
    public final boolean m16825a() {
        return (this.f13208c == 0 || this.f13209d == null) ? false : true;
    }

    /* renamed from: b */
    public final boolean m16826b() {
        return this.f13208c == 0;
    }

    /* renamed from: c */
    public final int m16827c() {
        return this.f13208c;
    }

    /* renamed from: d */
    public final PendingIntent m16828d() {
        return this.f13209d;
    }

    /* renamed from: e */
    public final String m16829e() {
        return this.f13210e;
    }

    /* renamed from: a */
    static String m16824a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder stringBuilder = new StringBuilder(31);
                        stringBuilder.append("UNKNOWN_ERROR_CODE(");
                        stringBuilder.append(i);
                        stringBuilder.append(")");
                        return stringBuilder.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4775b)) {
            return false;
        }
        C4775b c4775b = (C4775b) obj;
        return this.f13208c == c4775b.f13208c && C2868t.m8374a(this.f13209d, c4775b.f13209d) && C2868t.m8374a(this.f13210e, c4775b.f13210e) != null;
    }

    public final int hashCode() {
        return C2868t.m8372a(Integer.valueOf(this.f13208c), this.f13209d, this.f13210e);
    }

    public final String toString() {
        return C2868t.m8373a((Object) this).m8371a("statusCode", C4775b.m16824a(this.f13208c)).m8371a("resolution", this.f13209d).m8371a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f13210e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13207b);
        C2835c.m8184a(parcel, 2, m16827c());
        C2835c.m8188a(parcel, 3, m16828d(), i, false);
        C2835c.m8193a(parcel, 4, m16829e(), false);
        C2835c.m8180a(parcel, a);
    }
}
