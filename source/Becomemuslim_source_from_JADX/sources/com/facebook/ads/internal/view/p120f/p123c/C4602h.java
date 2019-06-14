package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p122b.C3659m;
import com.facebook.ads.internal.view.p120f.p124d.C1658d;

/* renamed from: com.facebook.ads.internal.view.f.c.h */
public class C4602h extends C3639c implements OnTouchListener {
    /* renamed from: a */
    private final C3659m f12516a;
    /* renamed from: b */
    private final C3655i f12517b;
    /* renamed from: c */
    private final C3657k f12518c;
    /* renamed from: d */
    private final C3649c f12519d;
    /* renamed from: e */
    private final C1649m f12520e;

    /* renamed from: com.facebook.ads.internal.view.f.c.h$1 */
    class C45981 extends C3659m {
        /* renamed from: a */
        final /* synthetic */ C4602h f12512a;

        C45981(C4602h c4602h) {
            this.f12512a = c4602h;
        }

        /* renamed from: a */
        public void m15855a(C3658l c3658l) {
            this.f12512a.setVisibility(0);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.h$2 */
    class C45992 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C4602h f12513a;

        C45992(C4602h c4602h) {
            this.f12513a = c4602h;
        }

        /* renamed from: a */
        public void m15857a(C3654h c3654h) {
            this.f12513a.f12520e.setChecked(true);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.h$3 */
    class C46003 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C4602h f12514a;

        C46003(C4602h c4602h) {
            this.f12514a = c4602h;
        }

        /* renamed from: a */
        public void m15859a(C3656j c3656j) {
            this.f12514a.f12520e.setChecked(false);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.h$4 */
    class C46014 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C4602h f12515a;

        C46014(C4602h c4602h) {
            this.f12515a = c4602h;
        }

        /* renamed from: a */
        public void m15861a(C3648b c3648b) {
            this.f12515a.f12520e.setChecked(true);
        }
    }

    public C4602h(Context context) {
        this(context, null);
    }

    public C4602h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C4602h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12516a = new C45981(this);
        this.f12517b = new C45992(this);
        this.f12518c = new C46003(this);
        this.f12519d = new C46014(this);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f12520e = new C1649m(context);
        this.f12520e.setChecked(true);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 25.0f));
        setVisibility(8);
        addView(this.f12520e, layoutParams);
        setClickable(true);
        setFocusable(true);
    }

    /* renamed from: a */
    protected void mo2877a() {
        super.mo2877a();
        this.f12520e.setOnTouchListener(this);
        setOnTouchListener(this);
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4804a(this.f12516a, this.f12519d, this.f12517b, this.f12518c);
        }
    }

    /* renamed from: b */
    protected void mo2878b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4806b(this.f12518c, this.f12517b, this.f12519d, this.f12516a);
        }
        setOnTouchListener(null);
        this.f12520e.setOnTouchListener(null);
        super.mo2878b();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        C3640a videoView = getVideoView();
        if (videoView == null) {
            return false;
        }
        if (!(videoView.getState() == C1658d.PREPARED || videoView.getState() == C1658d.PAUSED)) {
            if (videoView.getState() != C1658d.PLAYBACK_COMPLETED) {
                if (videoView.getState() == C1658d.STARTED) {
                    videoView.m11917a(true);
                }
                return false;
            }
        }
        videoView.m11914a(C1624a.USER_STARTED);
        return true;
    }
}
