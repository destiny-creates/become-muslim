package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.view.f.c.i */
public class C4603i extends C3639c {
    /* renamed from: a */
    private final C1644a f12521a;
    /* renamed from: b */
    private final int f12522b;
    /* renamed from: c */
    private final String f12523c;
    /* renamed from: d */
    private final String f12524d;
    /* renamed from: e */
    private final AtomicBoolean f12525e;
    /* renamed from: f */
    private final C1402f<C3660n> f12526f = new C36791(this);

    /* renamed from: com.facebook.ads.internal.view.f.c.i$2 */
    class C16432 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C4603i f4926a;

        C16432(C4603i c4603i) {
            this.f4926a = c4603i;
        }

        public void onClick(View view) {
            if (!this.f4926a.f12525e.get()) {
                Log.i("SkipPlugin", "User clicked skip before the ads is allowed to skip.");
            } else if (this.f4926a.getVideoView() != null) {
                this.f4926a.getVideoView().m11920e();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.i$a */
    private static class C1644a extends TextView {
        /* renamed from: a */
        private final Paint f4927a = new Paint();
        /* renamed from: b */
        private final Paint f4928b;
        /* renamed from: c */
        private final RectF f4929c;

        public C1644a(Context context) {
            super(context);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            C1523w.m5342a((View) this, 0);
            setTextColor(-3355444);
            setPadding((int) (displayMetrics.density * 9.0f), (int) (displayMetrics.density * 5.0f), (int) (displayMetrics.density * 9.0f), (int) (displayMetrics.density * 5.0f));
            setTextSize(18.0f);
            this.f4927a.setStyle(Style.STROKE);
            this.f4927a.setColor(-10066330);
            this.f4927a.setStrokeWidth(1.0f);
            this.f4927a.setAntiAlias(true);
            this.f4928b = new Paint();
            this.f4928b.setStyle(Style.FILL);
            this.f4928b.setColor(-1895825408);
            this.f4929c = new RectF();
        }

        protected void onDraw(Canvas canvas) {
            if (getText().length() != 0) {
                int width = getWidth();
                int height = getHeight();
                float f = (float) 0;
                this.f4929c.set(f, f, (float) width, (float) height);
                canvas.drawRoundRect(this.f4929c, 6.0f, 6.0f, this.f4928b);
                float f2 = (float) 2;
                this.f4929c.set(f2, f2, (float) (width - 2), (float) (height - 2));
                canvas.drawRoundRect(this.f4929c, 6.0f, 6.0f, this.f4927a);
                super.onDraw(canvas);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.i$1 */
    class C36791 extends C1402f<C3660n> {
        /* renamed from: a */
        final /* synthetic */ C4603i f9808a;

        C36791(C4603i c4603i) {
            this.f9808a = c4603i;
        }

        /* renamed from: a */
        public Class<C3660n> mo930a() {
            return C3660n.class;
        }

        /* renamed from: a */
        public void m12011a(C3660n c3660n) {
            if (!this.f9808a.f12525e.get()) {
                if (this.f9808a.getVideoView() != null) {
                    int c = this.f9808a.f12522b - (this.f9808a.getVideoView().getCurrentPositionInMillis() / 1000);
                    if (c > 0) {
                        C1644a f = this.f9808a.f12521a;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(this.f9808a.f12523c);
                        stringBuilder.append(' ');
                        stringBuilder.append(c);
                        f.setText(stringBuilder.toString());
                        return;
                    }
                    this.f9808a.f12521a.setText(this.f9808a.f12524d);
                    this.f9808a.f12525e.set(true);
                }
            }
        }
    }

    public C4603i(Context context, int i, String str, String str2) {
        super(context);
        this.f12522b = i;
        this.f12523c = str;
        this.f12524d = str2;
        this.f12525e = new AtomicBoolean(false);
        this.f12521a = new C1644a(context);
        C1644a c1644a = this.f12521a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f12523c);
        stringBuilder.append(' ');
        stringBuilder.append(i);
        c1644a.setText(stringBuilder.toString());
        addView(this.f12521a, new LayoutParams(-2, -2));
    }

    /* renamed from: a */
    public void mo2877a() {
        super.mo2877a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4805a(this.f12526f);
        }
        this.f12521a.setOnClickListener(new C16432(this));
    }

    /* renamed from: b */
    public void mo2878b() {
        if (getVideoView() != null) {
            this.f12521a.setOnClickListener(null);
            getVideoView().getEventBus().m4807b(this.f12526f);
        }
        super.mo2878b();
    }
}
