package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.internal.ads.atu;
import com.google.android.gms.internal.ads.atw;
import com.google.android.gms.internal.ads.avd;
import com.google.android.gms.internal.ads.ave;
import com.google.android.gms.internal.ads.bcp;
import com.google.android.gms.internal.ads.bdk;
import com.google.android.gms.internal.ads.bdo;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.internal.ads.rw;
import com.google.android.gms.internal.ads.rx;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.ads.internal.t */
public final class C2674t {
    /* renamed from: a */
    public static View m7549a(is isVar) {
        if (isVar == null) {
            jn.c("AdState is null");
            return null;
        } else if (C2674t.m7561b(isVar) && isVar.f15575b != null) {
            return isVar.f15575b.getView();
        } else {
            try {
                C2758b a = isVar.f15589p != null ? isVar.f15589p.a() : null;
                if (a != null) {
                    return (View) C4757d.m16685a(a);
                }
                jn.e("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                jn.c("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    /* renamed from: a */
    static ae<qo> m7550a(bdk bdk, bdo bdo, C2641d c2641d) {
        return new C4294y(bdk, c2641d, bdo);
    }

    /* renamed from: a */
    private static avd m7551a(Object obj) {
        return obj instanceof IBinder ? ave.a((IBinder) obj) : null;
    }

    /* renamed from: a */
    private static String m7552a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            jn.e("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        encodeToString = String.valueOf(encodeToString);
        return encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
    }

    /* renamed from: a */
    private static java.lang.String m7553a(com.google.android.gms.internal.ads.avd r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        if (r1 != 0) goto L_0x000a;
    L_0x0002:
        r1 = "Image is null. Returning empty string";
        com.google.android.gms.internal.ads.jn.e(r1);
        r1 = "";
        return r1;
    L_0x000a:
        r0 = r1.b();	 Catch:{ RemoteException -> 0x0015 }
        if (r0 == 0) goto L_0x001a;	 Catch:{ RemoteException -> 0x0015 }
    L_0x0010:
        r0 = r0.toString();	 Catch:{ RemoteException -> 0x0015 }
        return r0;
    L_0x0015:
        r0 = "Unable to get image uri. Trying data uri next";
        com.google.android.gms.internal.ads.jn.e(r0);
    L_0x001a:
        r1 = com.google.android.gms.ads.internal.C2674t.m7559b(r1);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.t.a(com.google.android.gms.internal.ads.avd):java.lang.String");
    }

    /* renamed from: a */
    private static JSONObject m7554a(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    if (bundle.containsKey(str2)) {
                        Object obj;
                        if (MessengerShareContentUtility.MEDIA_IMAGE.equals(jSONObject2.getString(str2))) {
                            obj = bundle.get(str2);
                            if (obj instanceof Bitmap) {
                                obj = C2674t.m7552a((Bitmap) obj);
                            } else {
                                str2 = "Invalid type. An image type extra should return a bitmap";
                                jn.e(str2);
                            }
                        } else if (bundle.get(str2) instanceof Bitmap) {
                            str2 = "Invalid asset type. Bitmap should be returned only for image type";
                            jn.e(str2);
                        } else {
                            obj = String.valueOf(bundle.get(str2));
                        }
                        jSONObject.put(str2, obj);
                    }
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    static final /* synthetic */ void m7555a(atu atu, String str, qo qoVar, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", atu.a());
            jSONObject.put("body", atu.c());
            jSONObject.put("call_to_action", atu.e());
            jSONObject.put("price", atu.h());
            jSONObject.put("star_rating", String.valueOf(atu.f()));
            jSONObject.put("store", atu.g());
            jSONObject.put("icon", C2674t.m7553a(atu.d()));
            JSONArray jSONArray = new JSONArray();
            List<Object> b = atu.b();
            if (b != null) {
                for (Object a : b) {
                    jSONArray.put(C2674t.m7553a(C2674t.m7551a(a)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, C2674t.m7554a(atu.n(), str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "2");
            qoVar.b("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (Throwable e) {
            jn.c("Exception occurred when loading assets", e);
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m7556a(atw atw, String str, qo qoVar, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", atw.a());
            jSONObject.put("body", atw.e());
            jSONObject.put("call_to_action", atw.g());
            jSONObject.put("advertiser", atw.h());
            jSONObject.put("logo", C2674t.m7553a(atw.f()));
            JSONArray jSONArray = new JSONArray();
            List<Object> b = atw.b();
            if (b != null) {
                for (Object a : b) {
                    jSONArray.put(C2674t.m7553a(C2674t.m7551a(a)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put(AppLinkData.ARGUMENTS_EXTRAS_KEY, C2674t.m7554a(atw.n(), str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            qoVar.b("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (Throwable e) {
            jn.c("Exception occurred when loading assets", e);
        }
    }

    /* renamed from: a */
    public static boolean m7558a(qo qoVar, bcp bcp, CountDownLatch countDownLatch) {
        qo qoVar2 = qoVar;
        bcp bcp2 = bcp;
        CountDownLatch countDownLatch2 = countDownLatch;
        boolean z = false;
        try {
            String str;
            View view = qoVar.getView();
            if (view == null) {
                str = "AdWebView is null";
            } else {
                view.setVisibility(4);
                List list = bcp2.f15221b.f15190r;
                if (list != null) {
                    if (!list.isEmpty()) {
                        String str2;
                        rw v;
                        rx c4290u;
                        qoVar2.a("/nativeExpressAssetsLoaded", new C4292w(countDownLatch2));
                        qoVar2.a("/nativeExpressAssetsLoadingFailed", new C4293x(countDownLatch2));
                        bdk h = bcp2.f15222c.h();
                        bdo i = bcp2.f15222c.i();
                        View view2 = null;
                        String a;
                        List b;
                        String c;
                        avd d;
                        String e;
                        if (list.contains("2") && h != null) {
                            a = h.a();
                            b = h.b();
                            c = h.c();
                            d = h.d();
                            e = h.e();
                            double f = h.f();
                            String g = h.g();
                            String h2 = h.h();
                            Bundle l = h.l();
                            if (h.p() != null) {
                                view2 = (View) C4757d.m16685a(h.p());
                            }
                            atu atu = new atu(a, b, c, d, e, f, g, h2, null, l, null, view2, h.q(), null);
                            str2 = bcp2.f15221b.f15189q;
                            v = qoVar.v();
                            c4290u = new C4290u(atu, str2, qoVar2);
                        } else if (!list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES) || i == null) {
                            str = "No matching template id and mapper";
                        } else {
                            a = i.a();
                            b = i.b();
                            c = i.c();
                            d = i.d();
                            e = i.e();
                            String f2 = i.f();
                            Bundle j = i.j();
                            if (i.n() != null) {
                                view2 = (View) C4757d.m16685a(i.n());
                            }
                            atw atw = new atw(a, b, c, d, e, f2, null, j, null, view2, i.o(), null);
                            str2 = bcp2.f15221b.f15189q;
                            v = qoVar.v();
                            c4290u = new C4291v(atw, str2, qoVar2);
                        }
                        v.a(c4290u);
                        str2 = bcp2.f15221b.f15187o;
                        String str3 = bcp2.f15221b.f15188p;
                        if (str3 != null) {
                            qoVar.loadDataWithBaseURL(str3, str2, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME, null);
                        } else {
                            qoVar2.loadData(str2, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME);
                        }
                        z = true;
                        if (!z) {
                            countDownLatch.countDown();
                        }
                        return z;
                    }
                }
                str = "No template ids present in mediation response";
            }
            jn.e(str);
        } catch (Throwable e2) {
            jn.c("Unable to invoke load assets", e2);
        } catch (RuntimeException e3) {
            countDownLatch.countDown();
            throw e3;
        }
        if (z) {
            countDownLatch.countDown();
        }
        return z;
    }

    /* renamed from: b */
    private static java.lang.String m7559b(com.google.android.gms.internal.ads.avd r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = r1.a();	 Catch:{ RemoteException -> 0x002b }
        if (r1 != 0) goto L_0x000e;	 Catch:{ RemoteException -> 0x002b }
    L_0x0006:
        r1 = "Drawable is null. Returning empty string";	 Catch:{ RemoteException -> 0x002b }
        com.google.android.gms.internal.ads.jn.e(r1);	 Catch:{ RemoteException -> 0x002b }
        r1 = "";	 Catch:{ RemoteException -> 0x002b }
        return r1;	 Catch:{ RemoteException -> 0x002b }
    L_0x000e:
        r1 = com.google.android.gms.p174b.C4757d.m16685a(r1);	 Catch:{ RemoteException -> 0x002b }
        r1 = (android.graphics.drawable.Drawable) r1;	 Catch:{ RemoteException -> 0x002b }
        r0 = r1 instanceof android.graphics.drawable.BitmapDrawable;
        if (r0 != 0) goto L_0x0020;
    L_0x0018:
        r1 = "Drawable is not an instance of BitmapDrawable. Returning empty string";
        com.google.android.gms.internal.ads.jn.e(r1);
        r1 = "";
        return r1;
    L_0x0020:
        r1 = (android.graphics.drawable.BitmapDrawable) r1;
        r1 = r1.getBitmap();
        r1 = com.google.android.gms.ads.internal.C2674t.m7552a(r1);
        return r1;
    L_0x002b:
        r1 = "Unable to get drawable. Returning empty string";
        com.google.android.gms.internal.ads.jn.e(r1);
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.t.b(com.google.android.gms.internal.ads.avd):java.lang.String");
    }

    /* renamed from: b */
    private static void m7560b(qo qoVar) {
        OnClickListener onClickListener = qoVar.getOnClickListener();
        if (onClickListener != null) {
            onClickListener.onClick(qoVar.getView());
        }
    }

    /* renamed from: b */
    public static boolean m7561b(is isVar) {
        return (isVar == null || !isVar.f15587n || isVar.f15588o == null || isVar.f15588o.f15187o == null) ? false : true;
    }
}
