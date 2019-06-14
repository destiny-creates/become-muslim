package ai.api.p005a;

import ai.api.C0011b;
import ai.api.C0028d;
import android.content.Context;
import com.google.p127a.C2157f;
import java.util.TimeZone;

/* compiled from: AIDataService */
/* renamed from: ai.api.a.b */
public class C3089b extends C0011b {
    /* renamed from: b */
    public static final String f7883b = "ai.api.a.b";
    /* renamed from: c */
    private final Context f7884c;
    /* renamed from: d */
    private final C3087a f7885d;
    /* renamed from: e */
    private final C2157f f7886e = C0007d.m22a();

    /* compiled from: AIDataService */
    /* renamed from: ai.api.a.b$a */
    private static class C3088a implements C0028d {
        /* renamed from: a */
        private final String f7882a;

        public C3088a(Context context) {
            this.f7882a = C0008e.m23a(context);
        }

        /* renamed from: a */
        public String mo2a() {
            return this.f7882a;
        }

        /* renamed from: b */
        public TimeZone mo3b() {
            return TimeZone.getDefault();
        }
    }

    public C3089b(Context context, C3087a c3087a) {
        super(c3087a, new C3088a(context));
        this.f7884c = context;
        this.f7885d = c3087a;
    }
}
