package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.p085a.C1297b;
import com.facebook.ads.internal.p085a.C1298c;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3647a;
import java.util.HashMap;

/* renamed from: com.facebook.ads.internal.view.f.c.e */
public class C4595e extends C3639c {
    /* renamed from: a */
    private final String f12502a;
    /* renamed from: b */
    private final TextView f12503b = new TextView(getContext());
    /* renamed from: c */
    private final C1412c f12504c;
    /* renamed from: d */
    private final String f12505d;
    /* renamed from: e */
    private final Paint f12506e;
    /* renamed from: f */
    private final RectF f12507f;

    /* renamed from: com.facebook.ads.internal.view.f.c.e$1 */
    class C16411 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C4595e f4924a;

        C16411(C4595e c4595e) {
            this.f4924a = c4595e;
        }

        public void onClick(View view) {
            if (this.f4924a.getVideoView() != null) {
                Uri parse = Uri.parse(this.f4924a.f12502a);
                this.f4924a.getVideoView().getEventBus().m4803a(new C3647a(parse));
                C1297b a = C1298c.m4444a(this.f4924a.getContext(), this.f4924a.f12504c, this.f4924a.f12505d, parse, new HashMap());
                if (a != null) {
                    a.mo917b();
                }
            }
        }
    }

    public C4595e(Context context, String str, C1412c c1412c, String str2, String str3) {
        super(context);
        this.f12502a = str;
        this.f12504c = c1412c;
        this.f12505d = str2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f12503b.setTextColor(-3355444);
        this.f12503b.setTextSize(16.0f);
        this.f12503b.setPadding((int) (displayMetrics.density * 6.0f), (int) (displayMetrics.density * 4.0f), (int) (displayMetrics.density * 6.0f), (int) (displayMetrics.density * 4.0f));
        this.f12506e = new Paint();
        this.f12506e.setStyle(Style.FILL);
        this.f12506e.setColor(-16777216);
        this.f12506e.setAlpha(178);
        this.f12507f = new RectF();
        C1523w.m5342a((View) this, 0);
        this.f12503b.setText(str3);
        addView(this.f12503b, new LayoutParams(-2, -2));
    }

    /* renamed from: a */
    protected void mo2877a() {
        super.mo2877a();
        this.f12503b.setOnClickListener(new C16411(this));
    }

    /* renamed from: b */
    protected void mo2878b() {
        this.f12503b.setOnClickListener(null);
        super.mo2878b();
    }

    protected void onDraw(Canvas canvas) {
        this.f12507f.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawRoundRect(this.f12507f, 0.0f, 0.0f, this.f12506e);
        super.onDraw(canvas);
    }
}
