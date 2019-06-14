package ai.api.p005a;

import ai.api.C0009a;
import ai.api.C0009a.C0004a;
import android.content.res.AssetFileDescriptor;

/* compiled from: AIConfiguration */
/* renamed from: ai.api.a.a */
public class C3087a extends C0009a {
    /* renamed from: a */
    private final C0005a f7876a;
    /* renamed from: b */
    private AssetFileDescriptor f7877b;
    /* renamed from: c */
    private AssetFileDescriptor f7878c;
    /* renamed from: d */
    private AssetFileDescriptor f7879d;
    /* renamed from: e */
    private boolean f7880e = true;
    /* renamed from: f */
    private boolean f7881f = null;

    /* compiled from: AIConfiguration */
    /* renamed from: ai.api.a.a$a */
    public enum C0005a {
        Google,
        System,
        Speaktoit
    }

    public C3087a(String str, C0004a c0004a, C0005a c0005a) {
        super(str, c0004a);
        this.f7876a = c0005a;
        if (c0005a != C0005a.Speaktoit) {
            return;
        }
        if (c0004a == C0004a.Korean) {
            throw new UnsupportedOperationException("Only System recognition supported for Korean language");
        }
    }

    /* renamed from: h */
    public C0005a m9028h() {
        return this.f7876a;
    }

    /* renamed from: i */
    public boolean m9029i() {
        return this.f7880e;
    }

    /* renamed from: j */
    public boolean m9030j() {
        return this.f7881f;
    }

    /* renamed from: k */
    public AssetFileDescriptor m9031k() {
        return this.f7877b;
    }

    /* renamed from: l */
    public AssetFileDescriptor m9032l() {
        return this.f7878c;
    }

    /* renamed from: m */
    public AssetFileDescriptor m9033m() {
        return this.f7879d;
    }
}
