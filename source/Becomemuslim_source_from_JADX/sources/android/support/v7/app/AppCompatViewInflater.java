package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.support.v4.util.C3211a;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.view.C0642d;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.C0796k;
import android.support.v7.widget.C0804v;
import android.support.v7.widget.C0805w;
import android.support.v7.widget.C3320g;
import android.support.v7.widget.C3321i;
import android.support.v7.widget.C3322j;
import android.support.v7.widget.C3326n;
import android.support.v7.widget.C3327p;
import android.support.v7.widget.C3328r;
import android.support.v7.widget.C3329u;
import android.support.v7.widget.C3332y;
import android.support.v7.widget.bn;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
    /* renamed from: a */
    private static final Class<?>[] f1553a = new Class[]{Context.class, AttributeSet.class};
    /* renamed from: b */
    private static final int[] f1554b = new int[]{16843375};
    /* renamed from: c */
    private static final String[] f1555c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    /* renamed from: d */
    private static final Map<String, Constructor<? extends View>> f1556d = new C3211a();
    /* renamed from: e */
    private final Object[] f1557e = new Object[2];

    /* renamed from: android.support.v7.app.AppCompatViewInflater$a */
    private static class C0604a implements OnClickListener {
        /* renamed from: a */
        private final View f1549a;
        /* renamed from: b */
        private final String f1550b;
        /* renamed from: c */
        private Method f1551c;
        /* renamed from: d */
        private Context f1552d;

        public C0604a(View view, String str) {
            this.f1549a = view;
            this.f1550b = str;
        }

        public void onClick(View view) {
            if (this.f1551c == null) {
                m1992a(this.f1549a.getContext(), this.f1550b);
            }
            try {
                this.f1551c.invoke(this.f1552d, new Object[]{view});
            } catch (View view2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", view2);
            } catch (View view22) {
                throw new IllegalStateException("Could not execute method for android:onClick", view22);
            }
        }

        /* renamed from: a */
        private void m1992a(android.content.Context r5, java.lang.String r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r4 = this;
        L_0x0000:
            if (r5 == 0) goto L_0x002e;
        L_0x0002:
            r6 = r5.isRestricted();	 Catch:{ NoSuchMethodException -> 0x0021 }
            if (r6 != 0) goto L_0x0021;	 Catch:{ NoSuchMethodException -> 0x0021 }
        L_0x0008:
            r6 = r5.getClass();	 Catch:{ NoSuchMethodException -> 0x0021 }
            r0 = r4.f1550b;	 Catch:{ NoSuchMethodException -> 0x0021 }
            r1 = 1;	 Catch:{ NoSuchMethodException -> 0x0021 }
            r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0021 }
            r2 = 0;	 Catch:{ NoSuchMethodException -> 0x0021 }
            r3 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0021 }
            r1[r2] = r3;	 Catch:{ NoSuchMethodException -> 0x0021 }
            r6 = r6.getMethod(r0, r1);	 Catch:{ NoSuchMethodException -> 0x0021 }
            if (r6 == 0) goto L_0x0021;	 Catch:{ NoSuchMethodException -> 0x0021 }
        L_0x001c:
            r4.f1551c = r6;	 Catch:{ NoSuchMethodException -> 0x0021 }
            r4.f1552d = r5;	 Catch:{ NoSuchMethodException -> 0x0021 }
            return;
        L_0x0021:
            r6 = r5 instanceof android.content.ContextWrapper;
            if (r6 == 0) goto L_0x002c;
        L_0x0025:
            r5 = (android.content.ContextWrapper) r5;
            r5 = r5.getBaseContext();
            goto L_0x0000;
        L_0x002c:
            r5 = 0;
            goto L_0x0000;
        L_0x002e:
            r5 = r4.f1549a;
            r5 = r5.getId();
            r6 = -1;
            if (r5 != r6) goto L_0x003a;
        L_0x0037:
            r5 = "";
            goto L_0x005e;
        L_0x003a:
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r0 = " with id '";
            r6.append(r0);
            r0 = r4.f1549a;
            r0 = r0.getContext();
            r0 = r0.getResources();
            r5 = r0.getResourceEntryName(r5);
            r6.append(r5);
            r5 = "'";
            r6.append(r5);
            r5 = r6.toString();
        L_0x005e:
            r6 = new java.lang.IllegalStateException;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = "Could not find method ";
            r0.append(r1);
            r1 = r4.f1550b;
            r0.append(r1);
            r1 = "(View) in a parent or ancestor Context for android:onClick ";
            r0.append(r1);
            r1 = "attribute defined on view ";
            r0.append(r1);
            r1 = r4.f1549a;
            r1 = r1.getClass();
            r0.append(r1);
            r0.append(r5);
            r5 = r0.toString();
            r6.<init>(r5);
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatViewInflater.a.a(android.content.Context, java.lang.String):void");
        }
    }

    /* renamed from: a */
    protected View m1999a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* renamed from: a */
    final View m2000a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View a;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m1993a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = bn.m2764a(context2);
        }
        z = true;
        switch (str.hashCode()) {
            case true:
                if (str.equals("RatingBar")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("CheckedTextView")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("MultiAutoCompleteTextView")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("TextView")) {
                    z = false;
                    break;
                }
                break;
            case true:
                if (str.equals("ImageButton")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("SeekBar")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("Spinner")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("RadioButton")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("ImageView")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("AutoCompleteTextView")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("CheckBox")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("EditText")) {
                    z = true;
                    break;
                }
                break;
            case true:
                if (str.equals("Button")) {
                    z = true;
                    break;
                }
                break;
            default:
                break;
        }
        switch (z) {
            case false:
                a = m1998a(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2001b(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2002c(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2003d(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2004e(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2005f(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2006g(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2007h(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2008i(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2009j(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2010k(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2011l(context2, attributeSet);
                m1996a(a, str);
                break;
            case true:
                a = m2012m(context2, attributeSet);
                m1996a(a, str);
                break;
            default:
                a = m1999a(context2, str, attributeSet);
                break;
        }
        if (!(a != false || context == context2)) {
            a = m1997b(context2, str, attributeSet);
        }
        if (a == true) {
            m1995a(a, attributeSet);
        }
        return a;
    }

    /* renamed from: a */
    protected AppCompatTextView m1998a(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    /* renamed from: b */
    protected AppCompatImageView m2001b(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    /* renamed from: c */
    protected C3321i m2002c(Context context, AttributeSet attributeSet) {
        return new C3321i(context, attributeSet);
    }

    /* renamed from: d */
    protected C3326n m2003d(Context context, AttributeSet attributeSet) {
        return new C3326n(context, attributeSet);
    }

    /* renamed from: e */
    protected C3332y m2004e(Context context, AttributeSet attributeSet) {
        return new C3332y(context, attributeSet);
    }

    /* renamed from: f */
    protected C3327p m2005f(Context context, AttributeSet attributeSet) {
        return new C3327p(context, attributeSet);
    }

    /* renamed from: g */
    protected C3322j m2006g(Context context, AttributeSet attributeSet) {
        return new C3322j(context, attributeSet);
    }

    /* renamed from: h */
    protected C3329u m2007h(Context context, AttributeSet attributeSet) {
        return new C3329u(context, attributeSet);
    }

    /* renamed from: i */
    protected C0796k m2008i(Context context, AttributeSet attributeSet) {
        return new C0796k(context, attributeSet);
    }

    /* renamed from: j */
    protected C3320g m2009j(Context context, AttributeSet attributeSet) {
        return new C3320g(context, attributeSet);
    }

    /* renamed from: k */
    protected C3328r m2010k(Context context, AttributeSet attributeSet) {
        return new C3328r(context, attributeSet);
    }

    /* renamed from: l */
    protected C0804v m2011l(Context context, AttributeSet attributeSet) {
        return new C0804v(context, attributeSet);
    }

    /* renamed from: m */
    protected C0805w m2012m(Context context, AttributeSet attributeSet) {
        return new C0805w(context, attributeSet);
    }

    /* renamed from: a */
    private void m1996a(View view, String str) {
        if (view == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getName());
            stringBuilder.append(" asked to inflate view for <");
            stringBuilder.append(str);
            stringBuilder.append(">, but returned null");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: b */
    private android.view.View m1997b(android.content.Context r5, java.lang.String r6, android.util.AttributeSet r7) {
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
        r4 = this;
        r0 = "view";
        r0 = r6.equals(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x000f;
    L_0x0009:
        r6 = "class";
        r6 = r7.getAttributeValue(r1, r6);
    L_0x000f:
        r0 = 1;
        r2 = 0;
        r3 = r4.f1557e;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3[r2] = r5;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r4.f1557e;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3[r0] = r7;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r7 = -1;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = 46;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r6.indexOf(r3);	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        if (r7 != r3) goto L_0x0047;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
    L_0x0022:
        r7 = 0;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
    L_0x0023:
        r3 = f1555c;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r3.length;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        if (r7 >= r3) goto L_0x003e;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
    L_0x0028:
        r3 = f1555c;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r3[r7];	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r4.m1994a(r5, r6, r3);	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        if (r3 == 0) goto L_0x003b;
    L_0x0032:
        r5 = r4.f1557e;
        r5[r2] = r1;
        r5 = r4.f1557e;
        r5[r0] = r1;
        return r3;
    L_0x003b:
        r7 = r7 + 1;
        goto L_0x0023;
    L_0x003e:
        r5 = r4.f1557e;
        r5[r2] = r1;
        r5 = r4.f1557e;
        r5[r0] = r1;
        return r1;
    L_0x0047:
        r5 = r4.m1994a(r5, r6, r1);	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r6 = r4.f1557e;
        r6[r2] = r1;
        r6 = r4.f1557e;
        r6[r0] = r1;
        return r5;
    L_0x0054:
        r5 = move-exception;
        r6 = r4.f1557e;
        r6[r2] = r1;
        r6 = r4.f1557e;
        r6[r0] = r1;
        throw r5;
    L_0x005e:
        r5 = r4.f1557e;
        r5[r2] = r1;
        r5 = r4.f1557e;
        r5[r0] = r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatViewInflater.b(android.content.Context, java.lang.String, android.util.AttributeSet):android.view.View");
    }

    /* renamed from: a */
    private void m1995a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (VERSION.SDK_INT < 15 || C0517s.m1684B(view)) {
                attributeSet = context.obtainStyledAttributes(attributeSet, f1554b);
                String string = attributeSet.getString(0);
                if (string != null) {
                    view.setOnClickListener(new C0604a(view, string));
                }
                attributeSet.recycle();
            }
        }
    }

    /* renamed from: a */
    private android.view.View m1994a(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
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
        r1 = this;
        r0 = f1556d;
        r0 = r0.get(r3);
        r0 = (java.lang.reflect.Constructor) r0;
        if (r0 != 0) goto L_0x0036;
    L_0x000a:
        r2 = r2.getClassLoader();	 Catch:{ Exception -> 0x0043 }
        if (r4 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x0043 }
    L_0x0010:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043 }
        r0.<init>();	 Catch:{ Exception -> 0x0043 }
        r0.append(r4);	 Catch:{ Exception -> 0x0043 }
        r0.append(r3);	 Catch:{ Exception -> 0x0043 }
        r4 = r0.toString();	 Catch:{ Exception -> 0x0043 }
        goto L_0x0021;	 Catch:{ Exception -> 0x0043 }
    L_0x0020:
        r4 = r3;	 Catch:{ Exception -> 0x0043 }
    L_0x0021:
        r2 = r2.loadClass(r4);	 Catch:{ Exception -> 0x0043 }
        r4 = android.view.View.class;	 Catch:{ Exception -> 0x0043 }
        r2 = r2.asSubclass(r4);	 Catch:{ Exception -> 0x0043 }
        r4 = f1553a;	 Catch:{ Exception -> 0x0043 }
        r0 = r2.getConstructor(r4);	 Catch:{ Exception -> 0x0043 }
        r2 = f1556d;	 Catch:{ Exception -> 0x0043 }
        r2.put(r3, r0);	 Catch:{ Exception -> 0x0043 }
    L_0x0036:
        r2 = 1;	 Catch:{ Exception -> 0x0043 }
        r0.setAccessible(r2);	 Catch:{ Exception -> 0x0043 }
        r2 = r1.f1557e;	 Catch:{ Exception -> 0x0043 }
        r2 = r0.newInstance(r2);	 Catch:{ Exception -> 0x0043 }
        r2 = (android.view.View) r2;	 Catch:{ Exception -> 0x0043 }
        return r2;
    L_0x0043:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatViewInflater.a(android.content.Context, java.lang.String, java.lang.String):android.view.View");
    }

    /* renamed from: a */
    private static Context m1993a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        attributeSet = context.obtainStyledAttributes(attributeSet, C0590j.View, 0, 0);
        int resourceId = z ? attributeSet.getResourceId(C0590j.View_android_theme, 0) : false;
        if (z2 && !resourceId != false) {
            resourceId = attributeSet.getResourceId(C0590j.View_theme, 0);
            if (resourceId == true) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        attributeSet.recycle();
        if (resourceId == true) {
            return ((context instanceof C0642d) == null || ((C0642d) context).m2154a() != resourceId) ? new C0642d(context, resourceId) : context;
        } else {
            return context;
        }
    }
}
