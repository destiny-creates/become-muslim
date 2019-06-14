package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C2836d;
import com.google.android.gms.common.internal.p181a.C2837e;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.List;

public class ActivityRecognitionResult extends C4363a implements ReflectedParcelable {
    public static final Creator<ActivityRecognitionResult> CREATOR = new ag();
    /* renamed from: a */
    private List<C7834c> f29147a;
    /* renamed from: b */
    private long f29148b;
    /* renamed from: c */
    private long f29149c;
    /* renamed from: d */
    private int f29150d;
    /* renamed from: e */
    private Bundle f29151e;

    public ActivityRecognitionResult(List<C7834c> list, long j, long j2, int i, Bundle bundle) {
        boolean z = true;
        boolean z2 = list != null && list.size() > 0;
        C2872v.b(z2, "Must have at least 1 detected activity");
        if (j <= 0 || j2 <= 0) {
            z = false;
        }
        C2872v.b(z, "Must set times");
        this.f29147a = list;
        this.f29148b = j;
        this.f29149c = j2;
        this.f29150d = i;
        this.f29151e = bundle;
    }

    /* renamed from: a */
    public static boolean m38201a(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List c = m38204c(intent);
        return (c == null || c.isEmpty()) ? false : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m38202a(android.os.Bundle r5, android.os.Bundle r6) {
        /*
        r0 = 1;
        if (r5 != 0) goto L_0x0006;
    L_0x0003:
        if (r6 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = 0;
        if (r5 != 0) goto L_0x000b;
    L_0x0009:
        if (r6 != 0) goto L_0x000f;
    L_0x000b:
        if (r5 == 0) goto L_0x0010;
    L_0x000d:
        if (r6 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r2 = r5.size();
        r3 = r6.size();
        if (r2 == r3) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        r2 = r5.keySet();
        r2 = r2.iterator();
    L_0x0023:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0069;
    L_0x0029:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = r6.containsKey(r3);
        if (r4 != 0) goto L_0x0036;
    L_0x0035:
        return r1;
    L_0x0036:
        r4 = r5.get(r3);
        if (r4 != 0) goto L_0x0043;
    L_0x003c:
        r3 = r6.get(r3);
        if (r3 == 0) goto L_0x0023;
    L_0x0042:
        return r1;
    L_0x0043:
        r4 = r5.get(r3);
        r4 = r4 instanceof android.os.Bundle;
        if (r4 == 0) goto L_0x005a;
    L_0x004b:
        r4 = r5.getBundle(r3);
        r3 = r6.getBundle(r3);
        r3 = m38202a(r4, r3);
        if (r3 != 0) goto L_0x0023;
    L_0x0059:
        return r1;
    L_0x005a:
        r4 = r5.get(r3);
        r3 = r6.get(r3);
        r3 = r4.equals(r3);
        if (r3 != 0) goto L_0x0023;
    L_0x0068:
        return r1;
    L_0x0069:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.a(android.os.Bundle, android.os.Bundle):boolean");
    }

    /* renamed from: b */
    public static ActivityRecognitionResult m38203b(Intent intent) {
        ActivityRecognitionResult activityRecognitionResult;
        List c;
        if (m38201a(intent)) {
            C2836d c2836d = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
            if (c2836d instanceof byte[]) {
                c2836d = C2837e.a((byte[]) c2836d, CREATOR);
            } else if (c2836d instanceof ActivityRecognitionResult) {
            }
            activityRecognitionResult = (ActivityRecognitionResult) c2836d;
            if (activityRecognitionResult != null) {
                return activityRecognitionResult;
            }
            c = m38204c(intent);
            if (c != null) {
                if (c.isEmpty()) {
                    return (ActivityRecognitionResult) c.get(c.size() - 1);
                }
            }
            return null;
        }
        activityRecognitionResult = null;
        if (activityRecognitionResult != null) {
            return activityRecognitionResult;
        }
        c = m38204c(intent);
        if (c != null) {
            if (c.isEmpty()) {
                return (ActivityRecognitionResult) c.get(c.size() - 1);
            }
        }
        return null;
    }

    /* renamed from: c */
    private static List<ActivityRecognitionResult> m38204c(Intent intent) {
        return !(intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST")) ? null : C2837e.b(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
    }

    /* renamed from: a */
    public C7834c m38205a() {
        return (C7834c) this.f29147a.get(0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
                return this.f29148b == activityRecognitionResult.f29148b && this.f29149c == activityRecognitionResult.f29149c && this.f29150d == activityRecognitionResult.f29150d && C2868t.a(this.f29147a, activityRecognitionResult.f29147a) && m38202a(this.f29151e, activityRecognitionResult.f29151e);
            }
        }
    }

    public int hashCode() {
        return C2868t.a(new Object[]{Long.valueOf(this.f29148b), Long.valueOf(this.f29149c), Integer.valueOf(this.f29150d), this.f29147a, this.f29151e});
    }

    public String toString() {
        String valueOf = String.valueOf(this.f29147a);
        long j = this.f29148b;
        long j2 = this.f29149c;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 124);
        stringBuilder.append("ActivityRecognitionResult [probableActivities=");
        stringBuilder.append(valueOf);
        stringBuilder.append(", timeMillis=");
        stringBuilder.append(j);
        stringBuilder.append(", elapsedRealtimeMillis=");
        stringBuilder.append(j2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.c(parcel, 1, this.f29147a, false);
        C2835c.a(parcel, 2, this.f29148b);
        C2835c.a(parcel, 3, this.f29149c);
        C2835c.a(parcel, 4, this.f29150d);
        C2835c.a(parcel, 5, this.f29151e, false);
        C2835c.a(parcel, i);
    }
}
