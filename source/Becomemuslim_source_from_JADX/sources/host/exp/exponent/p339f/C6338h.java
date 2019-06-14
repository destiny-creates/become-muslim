package host.exp.exponent.p339f;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: ExponentKernelModuleProvider */
/* renamed from: host.exp.exponent.f.h */
public class C6338h {
    /* renamed from: a */
    public static Queue<C6336b> f20581a = new LinkedList();
    /* renamed from: b */
    private static C6335a f20582b = new C75511();
    /* renamed from: c */
    private static C6334g f20583c;

    /* compiled from: ExponentKernelModuleProvider */
    /* renamed from: host.exp.exponent.f.h$a */
    public interface C6335a {
        /* renamed from: a */
        C6334g mo5383a(ReactApplicationContext reactApplicationContext);
    }

    /* compiled from: ExponentKernelModuleProvider */
    /* renamed from: host.exp.exponent.f.h$b */
    public static class C6336b {
        /* renamed from: a */
        public final String f20578a;
        /* renamed from: b */
        public final WritableMap f20579b;
        /* renamed from: c */
        public final C6337c f20580c;

        public C6336b(String str, WritableMap writableMap, C6337c c6337c) {
            this.f20578a = str;
            this.f20579b = writableMap;
            this.f20580c = c6337c;
        }
    }

    /* compiled from: ExponentKernelModuleProvider */
    /* renamed from: host.exp.exponent.f.h$c */
    public interface C6337c {
        void onEventFailure(String str);

        void onEventSuccess(ReadableMap readableMap);
    }

    /* compiled from: ExponentKernelModuleProvider */
    /* renamed from: host.exp.exponent.f.h$1 */
    static class C75511 implements C6335a {
        C75511() {
        }

        /* renamed from: a */
        public C6334g mo5383a(ReactApplicationContext reactApplicationContext) {
            return new C7550d(reactApplicationContext);
        }
    }

    /* renamed from: a */
    public static void m26058a(C6335a c6335a) {
        f20582b = c6335a;
    }

    /* renamed from: a */
    public static C6334g m26057a(ReactApplicationContext reactApplicationContext) {
        f20583c = f20582b.mo5383a(reactApplicationContext);
        return f20583c;
    }

    /* renamed from: a */
    public static void m26060a(String str, WritableMap writableMap, C6337c c6337c) {
        C6338h.m26059a(new C6336b(str, writableMap, c6337c));
    }

    /* renamed from: a */
    public static void m26059a(C6336b c6336b) {
        f20581a.add(c6336b);
        if (f20583c != null) {
            f20583c.consumeEventQueue();
        }
    }
}
