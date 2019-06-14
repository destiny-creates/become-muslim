package com.google.android.gms.wallet;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.C4357j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2842b;
import com.google.android.gms.p186f.C2950c;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.wallet.b */
public class C5153b {
    /* renamed from: a */
    static long f17429a = SystemClock.elapsedRealtime();
    /* renamed from: b */
    private static final long f17430b = TimeUnit.MINUTES.toMillis(10);

    /* renamed from: com.google.android.gms.wallet.b$b */
    public static class C5152b extends Fragment {
        /* renamed from: a */
        private static String f17422a = "resolveCallId";
        /* renamed from: b */
        private static String f17423b = "requestCode";
        /* renamed from: c */
        private static String f17424c = "initializationElapsedRealtime";
        /* renamed from: d */
        private static String f17425d = "delivered";
        /* renamed from: e */
        private int f17426e;
        /* renamed from: f */
        private C6849a<?> f17427f;
        /* renamed from: g */
        private boolean f17428g;

        /* renamed from: a */
        private final void m21835a() {
            if (this.f17427f != null) {
                this.f17427f.m32230b(this);
            }
        }

        /* renamed from: a */
        private final void m21836a(C2954g<? extends C5151a> c2954g) {
            if (!this.f17428g) {
                this.f17428g = true;
                Activity activity = getActivity();
                activity.getFragmentManager().beginTransaction().remove(this).commit();
                if (c2954g != null) {
                    C5153b.m21847b(activity, this.f17426e, c2954g);
                    return;
                }
                C5153b.m21846b(activity, this.f17426e, 0, new Intent());
            }
        }

        /* renamed from: b */
        private static Fragment m21838b(int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt(f17422a, i);
            bundle.putInt(f17423b, i2);
            bundle.putLong(f17424c, C5153b.f17429a);
            Fragment c5152b = new C5152b();
            c5152b.setArguments(bundle);
            return c5152b;
        }

        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f17426e = getArguments().getInt(f17423b);
            this.f17427f = C5153b.f17429a != getArguments().getLong(f17424c) ? null : (C6849a) C6849a.f24664a.get(getArguments().getInt(f17422a));
            boolean z = bundle != null && bundle.getBoolean(f17425d);
            this.f17428g = z;
        }

        public final void onPause() {
            super.onPause();
            m21835a();
        }

        public final void onResume() {
            super.onResume();
            if (this.f17427f != null) {
                this.f17427f.m32229a(this);
                return;
            }
            if (Log.isLoggable("AutoResolveHelper", 5)) {
                Log.w("AutoResolveHelper", "Sending canceled result for garbage collected task!");
            }
            m21836a(null);
        }

        public final void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(f17425d, this.f17428g);
            m21835a();
        }
    }

    /* renamed from: com.google.android.gms.wallet.b$a */
    static class C6849a<TResult extends C5151a> implements C2950c<TResult>, Runnable {
        /* renamed from: a */
        static final SparseArray<C6849a<?>> f24664a = new SparseArray(2);
        /* renamed from: c */
        private static final Handler f24665c = new Handler(Looper.getMainLooper());
        /* renamed from: d */
        private static final AtomicInteger f24666d = new AtomicInteger();
        /* renamed from: b */
        int f24667b;
        /* renamed from: e */
        private C5152b f24668e;
        /* renamed from: f */
        private C2954g<TResult> f24669f;

        C6849a() {
        }

        /* renamed from: a */
        public static <TResult extends C5151a> C6849a<TResult> m32227a(C2954g<TResult> c2954g) {
            C6849a<TResult> c6849a = new C6849a();
            c6849a.f24667b = f24666d.incrementAndGet();
            f24664a.put(c6849a.f24667b, c6849a);
            f24665c.postDelayed(c6849a, C5153b.f17430b);
            c2954g.a(c6849a);
            return c6849a;
        }

        /* renamed from: a */
        private final void m32228a() {
            if (this.f24669f != null && this.f24668e != null) {
                f24664a.delete(this.f24667b);
                f24665c.removeCallbacks(this);
                this.f24668e.m21836a(this.f24669f);
            }
        }

        /* renamed from: a */
        public final void m32229a(C5152b c5152b) {
            this.f24668e = c5152b;
            m32228a();
        }

        /* renamed from: b */
        public final void m32230b(C5152b c5152b) {
            if (this.f24668e == c5152b) {
                this.f24668e = null;
            }
        }

        public final void onComplete(C2954g<TResult> c2954g) {
            this.f24669f = c2954g;
            m32228a();
        }

        public final void run() {
            f24664a.delete(this.f24667b);
        }
    }

    /* renamed from: a */
    public static Status m21840a(Intent intent) {
        return intent == null ? null : (Status) intent.getParcelableExtra("com.google.android.gms.common.api.AutoResolveHelper.status");
    }

    /* renamed from: a */
    public static void m21843a(Intent intent, Status status) {
        if (status == null) {
            intent.removeExtra("com.google.android.gms.common.api.AutoResolveHelper.status");
        } else {
            intent.putExtra("com.google.android.gms.common.api.AutoResolveHelper.status", status);
        }
    }

    /* renamed from: a */
    public static <TResult> void m21844a(Status status, TResult tResult, C2955h<TResult> c2955h) {
        if (status.d()) {
            c2955h.a(tResult);
        } else {
            c2955h.a(C2842b.a(status));
        }
    }

    /* renamed from: a */
    public static <TResult extends C5151a> void m21845a(C2954g<TResult> c2954g, Activity activity, int i) {
        C6849a a = C6849a.m32227a((C2954g) c2954g);
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        Fragment a2 = C5152b.m21838b(a.f24667b, i);
        int i2 = a.f24667b;
        StringBuilder stringBuilder = new StringBuilder(58);
        stringBuilder.append("com.google.android.gms.wallet.AutoResolveHelper");
        stringBuilder.append(i2);
        beginTransaction.add(a2, stringBuilder.toString()).commit();
    }

    /* renamed from: b */
    private static void m21846b(Activity activity, int i, int i2, Intent intent) {
        PendingIntent createPendingResult = activity.createPendingResult(i, intent, 1073741824);
        if (createPendingResult != null) {
            try {
                createPendingResult.send(i2);
            } catch (Throwable e) {
                if (Log.isLoggable("AutoResolveHelper", 6)) {
                    Log.e("AutoResolveHelper", "Exception sending pending result", e);
                }
            }
        } else if (Log.isLoggable("AutoResolveHelper", 5)) {
            Log.w("AutoResolveHelper", "Null pending result returned when trying to deliver task result!");
        }
    }

    /* renamed from: b */
    private static void m21847b(Activity activity, int i, C2954g<? extends C5151a> c2954g) {
        if (activity.isFinishing()) {
            if (Log.isLoggable("AutoResolveHelper", 3)) {
                Log.d("AutoResolveHelper", "Ignoring task result for, Activity is finishing.");
            }
        } else if (c2954g.e() instanceof C4357j) {
            try {
                ((C4357j) c2954g.e()).a(activity, i);
            } catch (Throwable e) {
                if (Log.isLoggable("AutoResolveHelper", 6)) {
                    Log.e("AutoResolveHelper", "Error starting pending intent!", e);
                }
            }
        } else {
            Intent intent = new Intent();
            int i2 = 1;
            if (c2954g.b()) {
                i2 = -1;
                ((C5151a) c2954g.d()).mo6255a(intent);
            } else if (c2954g.e() instanceof C2782b) {
                C2782b c2782b = (C2782b) c2954g.e();
                C5153b.m21843a(intent, new Status(c2782b.a(), c2782b.getMessage(), null));
            } else {
                if (Log.isLoggable("AutoResolveHelper", 6)) {
                    Log.e("AutoResolveHelper", "Unexpected non API exception!", c2954g.e());
                }
                C5153b.m21843a(intent, new Status(8, "Unexpected non API exception when trying to deliver the task result to an activity!"));
            }
            C5153b.m21846b(activity, i, i2, intent);
        }
    }
}
