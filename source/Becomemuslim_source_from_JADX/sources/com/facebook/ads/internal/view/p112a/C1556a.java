package com.facebook.ads.internal.view.p112a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p107b.C1527b;
import com.facebook.ads.internal.p105q.p107b.C1528c;
import com.facebook.internal.NativeProtocol;
import java.util.List;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.a.a */
public class C1556a extends LinearLayout {
    /* renamed from: a */
    private static final int f4640a = Color.rgb(224, 224, 224);
    /* renamed from: b */
    private static final Uri f4641b = Uri.parse("http://www.facebook.com");
    /* renamed from: c */
    private static final OnTouchListener f4642c = new C15521();
    /* renamed from: d */
    private static final int f4643d = Color.argb(34, 0, 0, 0);
    /* renamed from: e */
    private ImageView f4644e;
    /* renamed from: f */
    private C1562e f4645f;
    /* renamed from: g */
    private ImageView f4646g;
    /* renamed from: h */
    private C1555a f4647h;
    /* renamed from: i */
    private String f4648i;

    /* renamed from: com.facebook.ads.internal.view.a.a$1 */
    static class C15521 implements OnTouchListener {
        C15521() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    C1523w.m5342a(view, C1556a.f4643d);
                    break;
                case 1:
                    C1523w.m5342a(view, 0);
                    break;
                default:
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.a$2 */
    class C15532 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1556a f4638a;

        C15532(C1556a c1556a) {
            this.f4638a = c1556a;
        }

        public void onClick(View view) {
            if (this.f4638a.f4647h != null) {
                this.f4638a.f4647h.mo1000a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.a$3 */
    class C15543 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1556a f4639a;

        C15543(C1556a c1556a) {
            this.f4639a = c1556a;
        }

        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f4639a.f4648i)) {
                if (!"about:blank".equals(this.f4639a.f4648i)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f4639a.f4648i));
                    intent.addFlags(268435456);
                    this.f4639a.getContext().startActivity(intent);
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.a$a */
    public interface C1555a {
        /* renamed from: a */
        void mo1000a();
    }

    public C1556a(Context context) {
        super(context);
        m5454a(context);
    }

    /* renamed from: a */
    private void m5454a(Context context) {
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (50.0f * f);
        int i2 = (int) (f * 4.0f);
        C1523w.m5342a((View) this, -1);
        setGravity(16);
        this.f4644e = new ImageView(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        this.f4644e.setScaleType(ScaleType.CENTER);
        this.f4644e.setImageBitmap(C1528c.m5354a(C1527b.BROWSER_CLOSE));
        this.f4644e.setOnTouchListener(f4642c);
        this.f4644e.setOnClickListener(new C15532(this));
        addView(this.f4644e, layoutParams);
        this.f4645f = new C1562e(context);
        layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.f4645f.setPadding(0, i2, 0, i2);
        addView(this.f4645f, layoutParams);
        this.f4646g = new ImageView(context);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
        this.f4646g.setScaleType(ScaleType.CENTER);
        this.f4646g.setOnTouchListener(f4642c);
        this.f4646g.setOnClickListener(new C15543(this));
        addView(this.f4646g, layoutParams2);
        setupDefaultNativeBrowser(context);
    }

    private void setupDefaultNativeBrowser(Context context) {
        Bitmap bitmap;
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", f4641b), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (queryIntentActivities.size() == 0) {
            this.f4646g.setVisibility(8);
            bitmap = null;
        } else {
            C1527b c1527b = (queryIntentActivities.size() == 1 && "com.android.chrome".equals(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName)) ? C1527b.BROWSER_LAUNCH_CHROME : C1527b.BROWSER_LAUNCH_NATIVE;
            bitmap = C1528c.m5354a(c1527b);
        }
        this.f4646g.setImageBitmap(bitmap);
    }

    public void setListener(C1555a c1555a) {
        this.f4647h = c1555a;
    }

    public void setTitle(String str) {
        this.f4645f.setTitle(str);
    }

    public void setUrl(String str) {
        this.f4648i = str;
        if (!TextUtils.isEmpty(str)) {
            if (!"about:blank".equals(str)) {
                this.f4645f.setSubtitle(str);
                this.f4646g.setEnabled(true);
                this.f4646g.setColorFilter(null);
                return;
            }
        }
        this.f4645f.setSubtitle(null);
        this.f4646g.setEnabled(false);
        this.f4646g.setColorFilter(new PorterDuffColorFilter(f4640a, Mode.SRC_IN));
    }
}
