package com.facebook.ads.internal.view.p114c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p085a.C1297b;
import com.facebook.ads.internal.p085a.C1298c;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p122b.C3647a;
import java.util.HashMap;

/* renamed from: com.facebook.ads.internal.view.c.a */
public class C1584a extends RelativeLayout {
    /* renamed from: a */
    private final String f4737a;
    /* renamed from: b */
    private C3640a f4738b;
    /* renamed from: c */
    private final Paint f4739c = new Paint();
    /* renamed from: d */
    private final RectF f4740d;

    public C1584a(Context context, String str, String str2, int i, C3640a c3640a, final C1412c c1412c, final String str3) {
        super(context);
        this.f4737a = str;
        this.f4738b = c3640a;
        View textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setText(str2);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        addView(textView);
        this.f4739c.setStyle(Style.FILL);
        this.f4739c.setColor(i);
        this.f4740d = new RectF();
        C1523w.m5342a((View) this, 0);
        setOnClickListener(new OnClickListener(this) {
            /* renamed from: c */
            final /* synthetic */ C1584a f4725c;

            public void onClick(View view) {
                Throwable e;
                String valueOf;
                String stringBuilder;
                try {
                    Uri parse = Uri.parse(this.f4725c.f4737a);
                    this.f4725c.f4738b.getEventBus().m4803a(new C3647a(parse));
                    C1297b a = C1298c.m4444a(this.f4725c.getContext(), c1412c, str3, parse, new HashMap());
                    if (a != null) {
                        a.mo917b();
                    }
                } catch (ActivityNotFoundException e2) {
                    e = e2;
                    valueOf = String.valueOf(C1584a.class);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Error while opening ");
                    stringBuilder2.append(this.f4725c.f4737a);
                    stringBuilder = stringBuilder2.toString();
                    Log.e(valueOf, stringBuilder, e);
                } catch (Exception e3) {
                    e = e3;
                    valueOf = String.valueOf(C1584a.class);
                    stringBuilder = "Error executing action";
                    Log.e(valueOf, stringBuilder, e);
                }
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f4740d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        f *= 10.0f;
        canvas.drawRoundRect(this.f4740d, f, f, this.f4739c);
        super.onDraw(canvas);
    }
}
