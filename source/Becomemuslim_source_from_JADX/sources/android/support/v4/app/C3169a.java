package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.ai.C0287a;
import android.support.v4.content.C0366b;
import android.view.View;
import java.util.List;
import java.util.Map;

/* compiled from: ActivityCompat */
/* renamed from: android.support.v4.app.a */
public class C3169a extends C0366b {
    /* renamed from: a */
    private static C0274b f8127a;

    /* compiled from: ActivityCompat */
    /* renamed from: android.support.v4.app.a$a */
    public interface C0273a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat */
    /* renamed from: android.support.v4.app.a$b */
    public interface C0274b {
        /* renamed from: a */
        boolean m751a(Activity activity, int i, int i2, Intent intent);

        /* renamed from: a */
        boolean m752a(Activity activity, String[] strArr, int i);
    }

    /* compiled from: ActivityCompat */
    /* renamed from: android.support.v4.app.a$c */
    public interface C0275c {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* compiled from: ActivityCompat */
    /* renamed from: android.support.v4.app.a$d */
    private static class C0276d extends SharedElementCallback {
        /* renamed from: a */
        protected ai f676a;

        C0276d(ai aiVar) {
            this.f676a = aiVar;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f676a.m854a((List) list, (List) list2, (List) list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f676a.m856b(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f676a.m852a((List) list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f676a.m855a((List) list, (Map) map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f676a.m850a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f676a.m851a(context, parcelable);
        }
    }

    /* compiled from: ActivityCompat */
    /* renamed from: android.support.v4.app.a$e */
    private static class C3168e extends C0276d {
        C3168e(ai aiVar) {
            super(aiVar);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, final OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.a.m853a((List) list, (List) list2, new C0287a(this) {
                /* renamed from: b */
                final /* synthetic */ C3168e f8126b;

                /* renamed from: a */
                public void mo177a() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    /* renamed from: a */
    public static C0274b m9424a() {
        return f8127a;
    }

    /* renamed from: a */
    public static void m9426a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    public static void m9427a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m9425a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* renamed from: b */
    public static void m9431b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static void m9428a(Activity activity, ai aiVar) {
        SharedElementCallback sharedElementCallback = null;
        if (VERSION.SDK_INT >= 23) {
            if (aiVar != null) {
                sharedElementCallback = new C3168e(aiVar);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        } else if (VERSION.SDK_INT >= 21) {
            if (aiVar != null) {
                sharedElementCallback = new C0276d(aiVar);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    /* renamed from: b */
    public static void m9432b(Activity activity, ai aiVar) {
        SharedElementCallback sharedElementCallback = null;
        if (VERSION.SDK_INT >= 23) {
            if (aiVar != null) {
                sharedElementCallback = new C3168e(aiVar);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        } else if (VERSION.SDK_INT >= 21) {
            if (aiVar != null) {
                sharedElementCallback = new C0276d(aiVar);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    /* renamed from: c */
    public static void m9433c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    /* renamed from: d */
    public static void m9434d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    /* renamed from: a */
    public static void m9429a(final Activity activity, final String[] strArr, final int i) {
        if (f8127a == null || !f8127a.m752a(activity, strArr, i)) {
            if (VERSION.SDK_INT >= 23) {
                if (activity instanceof C0275c) {
                    ((C0275c) activity).validateRequestPermissionsRequestCode(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof C0273a) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        int[] iArr = new int[strArr.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i = 0; i < length; i++) {
                            iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                        }
                        ((C0273a) activity).onRequestPermissionsResult(i, strArr, iArr);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public static boolean m9430a(Activity activity, String str) {
        return VERSION.SDK_INT >= 23 ? activity.shouldShowRequestPermissionRationale(str) : null;
    }
}
