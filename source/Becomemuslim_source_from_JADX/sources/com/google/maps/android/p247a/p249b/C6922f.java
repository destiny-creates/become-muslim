package com.google.maps.android.p247a.p249b;

import android.content.Context;
import com.google.android.gms.maps.C5125c;
import com.google.maps.android.p247a.C5394d;
import com.google.maps.android.p247a.C5395h;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: KmlLayer */
/* renamed from: com.google.maps.android.a.b.f */
public class C6922f extends C5394d {
    public C6922f(C5125c c5125c, InputStream inputStream, Context context) {
        if (inputStream != null) {
            C5395h c6924m = new C6924m(c5125c, context);
            context = new C5388i(C6922f.m32458a(inputStream));
            context.m22870a();
            inputStream.close();
            c6924m.m32487b(context.m22871b(), context.m22873d(), context.m22872c(), context.m22874e(), context.m22875f());
            m22898a(c6924m);
            return;
        }
        throw new IllegalArgumentException("KML InputStream cannot be null");
    }

    /* renamed from: a */
    private static XmlPullParser m32458a(InputStream inputStream) {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(inputStream, null);
        return newPullParser;
    }

    /* renamed from: c */
    public void m32460c() {
        super.m22897a();
    }

    /* renamed from: b */
    public Iterable<C5384b> mo4899b() {
        return super.mo4899b();
    }
}
