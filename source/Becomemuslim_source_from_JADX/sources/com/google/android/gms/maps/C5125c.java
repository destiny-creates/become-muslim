package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.C5023d;
import com.google.android.gms.internal.p212k.C5030s;
import com.google.android.gms.internal.p212k.C5031v;
import com.google.android.gms.internal.p212k.ab;
import com.google.android.gms.maps.model.C5138e;
import com.google.android.gms.maps.model.C5139g;
import com.google.android.gms.maps.model.C5141i;
import com.google.android.gms.maps.model.C5143l;
import com.google.android.gms.maps.model.C5144p;
import com.google.android.gms.maps.model.C5145r;
import com.google.android.gms.maps.model.C5146u;
import com.google.android.gms.maps.model.C5147x;
import com.google.android.gms.maps.model.C7848f;
import com.google.android.gms.maps.model.C7849h;
import com.google.android.gms.maps.model.C7850k;
import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.C7853o;
import com.google.android.gms.maps.model.C7854q;
import com.google.android.gms.maps.model.C7855s;
import com.google.android.gms.maps.model.C7857y;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.p216a.C5092b;
import com.google.android.gms.maps.p216a.am;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.maps.c */
public final class C5125c {
    /* renamed from: a */
    private final C5092b f17396a;
    /* renamed from: b */
    private C5132i f17397b;

    /* renamed from: com.google.android.gms.maps.c$a */
    public interface C5108a {
        /* renamed from: a */
        void m21697a();

        /* renamed from: b */
        void m21698b();
    }

    /* renamed from: com.google.android.gms.maps.c$b */
    public interface C5109b {
        View getInfoContents(C5143l c5143l);

        View getInfoWindow(C5143l c5143l);
    }

    /* renamed from: com.google.android.gms.maps.c$c */
    public interface C5110c {
        void onCameraIdle();
    }

    /* renamed from: com.google.android.gms.maps.c$d */
    public interface C5111d {
        void onCameraMove();
    }

    /* renamed from: com.google.android.gms.maps.c$e */
    public interface C5112e {
        void onCameraMoveStarted(int i);
    }

    /* renamed from: com.google.android.gms.maps.c$f */
    public interface C5113f {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(C5141i c5141i);
    }

    /* renamed from: com.google.android.gms.maps.c$g */
    public interface C5114g {
        void onInfoWindowClick(C5143l c5143l);
    }

    /* renamed from: com.google.android.gms.maps.c$h */
    public interface C5115h {
        void onMapClick(LatLng latLng);
    }

    /* renamed from: com.google.android.gms.maps.c$i */
    public interface C5116i {
        void onMapLoaded();
    }

    /* renamed from: com.google.android.gms.maps.c$j */
    public interface C5117j {
        void onMapLongClick(LatLng latLng);
    }

    /* renamed from: com.google.android.gms.maps.c$k */
    public interface C5118k {
        boolean onMarkerClick(C5143l c5143l);
    }

    /* renamed from: com.google.android.gms.maps.c$l */
    public interface C5119l {
        void onMarkerDrag(C5143l c5143l);

        void onMarkerDragEnd(C5143l c5143l);

        void onMarkerDragStart(C5143l c5143l);
    }

    @Deprecated
    /* renamed from: com.google.android.gms.maps.c$m */
    public interface C5120m {
        void onMyLocationChange(Location location);
    }

    /* renamed from: com.google.android.gms.maps.c$n */
    public interface C5121n {
        void onPoiClick(C7853o c7853o);
    }

    /* renamed from: com.google.android.gms.maps.c$o */
    public interface C5122o {
        void onPolygonClick(C5144p c5144p);
    }

    /* renamed from: com.google.android.gms.maps.c$p */
    public interface C5123p {
        void onPolylineClick(C5145r c5145r);
    }

    /* renamed from: com.google.android.gms.maps.c$q */
    public interface C5124q {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.c$r */
    private static final class C7842r extends am {
        /* renamed from: a */
        private final C5108a f29220a;

        C7842r(C5108a c5108a) {
            this.f29220a = c5108a;
        }

        /* renamed from: a */
        public final void mo6232a() {
            this.f29220a.m21697a();
        }

        /* renamed from: b */
        public final void mo6233b() {
            this.f29220a.m21698b();
        }
    }

    public C5125c(C5092b c5092b) {
        this.f17396a = (C5092b) C2872v.a(c5092b);
    }

    /* renamed from: a */
    public final CameraPosition m21699a() {
        try {
            return this.f17396a.mo4802a();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final C5138e m21700a(C7848f c7848f) {
        try {
            return new C5138e(this.f17396a.mo4800a(c7848f));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final C5139g m21701a(C7849h c7849h) {
        try {
            C5030s a = this.f17396a.mo4801a(c7849h);
            return a != null ? new C5139g(a) : null;
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final C5143l m21702a(C7851m c7851m) {
        try {
            ab a = this.f17396a.mo4796a(c7851m);
            return a != null ? new C5143l(a) : null;
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final C5144p m21703a(C7854q c7854q) {
        try {
            return new C5144p(this.f17396a.mo4797a(c7854q));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final C5145r m21704a(C7855s c7855s) {
        try {
            return new C5145r(this.f17396a.mo4798a(c7855s));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final C5147x m21705a(C7857y c7857y) {
        try {
            C5023d a = this.f17396a.mo4799a(c7857y);
            return a != null ? new C5147x(a) : null;
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21706a(float f) {
        try {
            this.f17396a.mo4803a(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21707a(int i) {
        try {
            this.f17396a.mo4804a(i);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21708a(int i, int i2, int i3, int i4) {
        try {
            this.f17396a.mo4805a(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21709a(C5106a c5106a) {
        try {
            this.f17396a.mo4806a(c5106a.m21689a());
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21710a(C5106a c5106a, int i, C5108a c5108a) {
        try {
            this.f17396a.mo4807a(c5106a.m21689a(), i, c5108a == null ? null : new C7842r(c5108a));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21711a(C5109b c5109b) {
        if (c5109b == null) {
            try {
                this.f17396a.mo4811a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4811a(new C7860p(this, c5109b));
    }

    /* renamed from: a */
    public final void m21712a(C5110c c5110c) {
        if (c5110c == null) {
            try {
                this.f17396a.mo4812a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4812a(new C7869y(this, c5110c));
    }

    /* renamed from: a */
    public final void m21713a(C5111d c5111d) {
        if (c5111d == null) {
            try {
                this.f17396a.mo4813a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4813a(new C7868x(this, c5111d));
    }

    /* renamed from: a */
    public final void m21714a(C5112e c5112e) {
        if (c5112e == null) {
            try {
                this.f17396a.mo4814a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4814a(new C7867w(this, c5112e));
    }

    /* renamed from: a */
    public final void m21715a(C5113f c5113f) {
        if (c5113f == null) {
            try {
                this.f17396a.mo4815a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4815a(new C7844j(this, c5113f));
    }

    /* renamed from: a */
    public final void m21716a(C5114g c5114g) {
        if (c5114g == null) {
            try {
                this.f17396a.mo4816a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4816a(new C7859o(this, c5114g));
    }

    /* renamed from: a */
    public final void m21717a(C5115h c5115h) {
        if (c5115h == null) {
            try {
                this.f17396a.mo4817a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4817a(new C7870z(this, c5115h));
    }

    /* renamed from: a */
    public final void m21718a(C5116i c5116i) {
        if (c5116i == null) {
            try {
                this.f17396a.mo4818a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4818a(new C7862r(this, c5116i));
    }

    /* renamed from: a */
    public final void m21719a(C5117j c5117j) {
        if (c5117j == null) {
            try {
                this.f17396a.mo4819a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4819a(new aa(this, c5117j));
    }

    /* renamed from: a */
    public final void m21720a(C5118k c5118k) {
        if (c5118k == null) {
            try {
                this.f17396a.mo4820a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4820a(new C7846m(this, c5118k));
    }

    /* renamed from: a */
    public final void m21721a(C5119l c5119l) {
        if (c5119l == null) {
            try {
                this.f17396a.mo4821a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4821a(new C7858n(this, c5119l));
    }

    @Deprecated
    /* renamed from: a */
    public final void m21722a(C5120m c5120m) {
        if (c5120m == null) {
            try {
                this.f17396a.mo4822a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4822a(new C7861q(this, c5120m));
    }

    /* renamed from: a */
    public final void m21723a(C5121n c5121n) {
        if (c5121n == null) {
            try {
                this.f17396a.mo4823a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4823a(new C7866v(this, c5121n));
    }

    /* renamed from: a */
    public final void m21724a(C5122o c5122o) {
        if (c5122o == null) {
            try {
                this.f17396a.mo4808a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4808a(new C7863s(this, c5122o));
    }

    /* renamed from: a */
    public final void m21725a(C5123p c5123p) {
        if (c5123p == null) {
            try {
                this.f17396a.mo4809a(null);
                return;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        this.f17396a.mo4809a(new C7864t(this, c5123p));
    }

    /* renamed from: a */
    public final void m21726a(C5124q c5124q) {
        m21727a(c5124q, null);
    }

    /* renamed from: a */
    public final void m21727a(C5124q c5124q, Bitmap bitmap) {
        try {
            this.f17396a.mo4810a(new C7865u(this, c5124q), (C4757d) (bitmap != null ? C4757d.a(bitmap) : null));
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21728a(LatLngBounds latLngBounds) {
        try {
            this.f17396a.mo4824a(latLngBounds);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final void m21729a(boolean z) {
        try {
            this.f17396a.mo4825a(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: a */
    public final boolean m21730a(C7850k c7850k) {
        try {
            return this.f17396a.mo4826a(c7850k);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final C5141i m21731b() {
        try {
            C5031v d = this.f17396a.mo4833d();
            return d != null ? new C5141i(d) : null;
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21732b(float f) {
        try {
            this.f17396a.mo4828b(f);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final void m21733b(C5106a c5106a) {
        try {
            this.f17396a.mo4829b(c5106a.m21689a());
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final boolean m21734b(boolean z) {
        try {
            return this.f17396a.mo4830b(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final C5132i m21735c() {
        try {
            if (this.f17397b == null) {
                this.f17397b = new C5132i(this.f17396a.mo4827b());
            }
            return this.f17397b;
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final void m21736c(boolean z) {
        try {
            this.f17396a.mo4834d(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: d */
    public final C5129g m21737d() {
        try {
            return new C5129g(this.f17396a.mo4831c());
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: d */
    public final void m21738d(boolean z) {
        try {
            this.f17396a.mo4832c(z);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
