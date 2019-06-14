package io.p347a.p348a.p349a.p350a.p358g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;

/* compiled from: IconRequest */
/* renamed from: io.a.a.a.a.g.n */
public class C6498n {
    /* renamed from: a */
    public final String f20940a;
    /* renamed from: b */
    public final int f20941b;
    /* renamed from: c */
    public final int f20942c;
    /* renamed from: d */
    public final int f20943d;

    public C6498n(String str, int i, int i2, int i3) {
        this.f20940a = str;
        this.f20941b = i;
        this.f20942c = i2;
        this.f20943d = i3;
    }

    /* renamed from: a */
    public static C6498n m26605a(Context context, String str) {
        if (str != null) {
            try {
                int l = C6428i.m26388l(context);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("App icon resource ID is ");
                stringBuilder.append(l);
                C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new C6498n(str, l, options.outWidth, options.outHeight);
            } catch (Context context2) {
                C6514c.m26634h().mo5480e("Fabric", "Failed to load icon", context2);
            }
        }
        return null;
    }
}
