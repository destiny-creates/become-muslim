package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.util.C2894d;
import com.google.android.gms.common.util.C2907r;

@TargetApi(17)
public class ki extends kk {
    /* renamed from: a */
    public final android.graphics.drawable.Drawable mo6867a(android.content.Context r4, android.graphics.Bitmap r5, boolean r6, float r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        if (r6 == 0) goto L_0x0053;
    L_0x0002:
        r6 = 0;
        r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x0053;
    L_0x0007:
        r6 = 1103626240; // 0x41c80000 float:25.0 double:5.45263811E-315;
        r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0053;
    L_0x000e:
        r6 = r5.getWidth();	 Catch:{ RuntimeException -> 0x0049 }
        r0 = r5.getHeight();	 Catch:{ RuntimeException -> 0x0049 }
        r1 = 0;	 Catch:{ RuntimeException -> 0x0049 }
        r6 = android.graphics.Bitmap.createScaledBitmap(r5, r6, r0, r1);	 Catch:{ RuntimeException -> 0x0049 }
        r0 = android.graphics.Bitmap.createBitmap(r6);	 Catch:{ RuntimeException -> 0x0049 }
        r1 = android.renderscript.RenderScript.create(r4);	 Catch:{ RuntimeException -> 0x0049 }
        r2 = android.renderscript.Element.U8_4(r1);	 Catch:{ RuntimeException -> 0x0049 }
        r2 = android.renderscript.ScriptIntrinsicBlur.create(r1, r2);	 Catch:{ RuntimeException -> 0x0049 }
        r6 = android.renderscript.Allocation.createFromBitmap(r1, r6);	 Catch:{ RuntimeException -> 0x0049 }
        r1 = android.renderscript.Allocation.createFromBitmap(r1, r0);	 Catch:{ RuntimeException -> 0x0049 }
        r2.setRadius(r7);	 Catch:{ RuntimeException -> 0x0049 }
        r2.setInput(r6);	 Catch:{ RuntimeException -> 0x0049 }
        r2.forEach(r1);	 Catch:{ RuntimeException -> 0x0049 }
        r1.copyTo(r0);	 Catch:{ RuntimeException -> 0x0049 }
        r6 = new android.graphics.drawable.BitmapDrawable;	 Catch:{ RuntimeException -> 0x0049 }
        r7 = r4.getResources();	 Catch:{ RuntimeException -> 0x0049 }
        r6.<init>(r7, r0);	 Catch:{ RuntimeException -> 0x0049 }
        return r6;
    L_0x0049:
        r6 = new android.graphics.drawable.BitmapDrawable;
        r4 = r4.getResources();
        r6.<init>(r4, r5);
        return r6;
    L_0x0053:
        r6 = new android.graphics.drawable.BitmapDrawable;
        r4 = r4.getResources();
        r6.<init>(r4, r5);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ki.a(android.content.Context, android.graphics.Bitmap, boolean, float):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    public final String mo6868a(Context context) {
        mb a = mb.m19848a();
        if (TextUtils.isEmpty(a.f15776a)) {
            a.f15776a = (String) (C2894d.a() ? lz.m19845a(context, new mc(a, context)) : lz.m19845a(context, new md(a, C2832i.getRemoteContext(context), context)));
        }
        return a.f15776a;
    }

    /* renamed from: a */
    public final boolean mo6103a(Context context, WebSettings webSettings) {
        super.mo6103a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    /* renamed from: b */
    public final void mo6869b(Context context) {
        mb a = mb.m19848a();
        jn.m30864a("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(a.f15776a)) {
            Context remoteContext = C2832i.getRemoteContext(context);
            if (C2894d.a() || remoteContext == null) {
                Editor putString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext == null) {
                    putString.apply();
                } else {
                    C2907r.a(context, putString, "admob_user_agent");
                }
            }
            a.f15776a = defaultUserAgent;
        }
        jn.m30864a("User agent is updated.");
    }
}
