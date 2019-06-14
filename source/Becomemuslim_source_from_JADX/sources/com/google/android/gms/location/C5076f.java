package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.p211j.aj;

/* renamed from: com.google.android.gms.location.f */
public interface C5076f {

    /* renamed from: com.google.android.gms.location.f$a */
    public static final class C5075a {
        /* renamed from: a */
        private String f17365a = null;
        /* renamed from: b */
        private int f17366b = 0;
        /* renamed from: c */
        private long f17367c = Long.MIN_VALUE;
        /* renamed from: d */
        private short f17368d = (short) -1;
        /* renamed from: e */
        private double f17369e;
        /* renamed from: f */
        private double f17370f;
        /* renamed from: g */
        private float f17371g;
        /* renamed from: h */
        private int f17372h = 0;
        /* renamed from: i */
        private int f17373i = -1;

        /* renamed from: a */
        public final C5075a m21550a(double d, double d2, float f) {
            this.f17368d = (short) 1;
            this.f17369e = d;
            this.f17370f = d2;
            this.f17371g = f;
            return this;
        }

        /* renamed from: a */
        public final C5075a m21551a(int i) {
            this.f17366b = i;
            return this;
        }

        /* renamed from: a */
        public final C5075a m21552a(long j) {
            if (j < 0) {
                this.f17367c = -1;
            } else {
                this.f17367c = SystemClock.elapsedRealtime() + j;
            }
            return this;
        }

        /* renamed from: a */
        public final C5075a m21553a(String str) {
            this.f17365a = str;
            return this;
        }

        /* renamed from: a */
        public final C5076f m21554a() {
            if (this.f17365a == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.f17366b != 0) {
                if ((this.f17366b & 4) != 0) {
                    if (this.f17373i < 0) {
                        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
                    }
                }
                if (this.f17367c == Long.MIN_VALUE) {
                    throw new IllegalArgumentException("Expiration not set.");
                } else if (this.f17368d == (short) -1) {
                    throw new IllegalArgumentException("Geofence region not set.");
                } else if (this.f17372h >= 0) {
                    return new aj(this.f17365a, this.f17366b, (short) 1, this.f17369e, this.f17370f, this.f17371g, this.f17367c, this.f17372h, this.f17373i);
                } else {
                    throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                }
            } else {
                throw new IllegalArgumentException("Transitions types not set.");
            }
        }
    }

    /* renamed from: a */
    String mo6206a();
}
