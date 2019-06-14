package expo.adapters.react.services;

import android.graphics.Typeface;
import com.facebook.react.views.text.ReactFontManager;
import expo.p304a.p305a.C5998e;
import expo.p307b.p313f.C6028a;
import java.util.Collections;
import java.util.List;

/* compiled from: FontManagerModule */
/* renamed from: expo.adapters.react.services.b */
public class C7375b implements C5998e, C6028a {
    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C6028a.class);
    }

    /* renamed from: a */
    public void mo5143a(String str, int i, Typeface typeface) {
        ReactFontManager.getInstance().setTypeface(str, i, typeface);
    }
}
