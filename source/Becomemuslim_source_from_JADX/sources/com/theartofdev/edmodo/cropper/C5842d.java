package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Images.Media;
import com.facebook.stetho.server.http.HttpStatus;
import com.theartofdev.edmodo.cropper.C5855i.C5853d;
import com.theartofdev.edmodo.cropper.CropImageView.C5819a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CropImage */
/* renamed from: com.theartofdev.edmodo.cropper.d */
public final class C5842d {

    /* compiled from: CropImage */
    /* renamed from: com.theartofdev.edmodo.cropper.d$a */
    public static final class C5840a {
        /* renamed from: a */
        private final Uri f19399a;
        /* renamed from: b */
        private final C5845f f19400b;

        private C5840a(Uri uri) {
            this.f19399a = uri;
            this.f19400b = new C5845f();
        }

        /* renamed from: a */
        public Intent m24624a(Context context) {
            return m24625a(context, CropImageActivity.class);
        }

        /* renamed from: a */
        public Intent m24625a(Context context, Class<?> cls) {
            this.f19400b.m24652a();
            Intent intent = new Intent();
            intent.setClass(context, cls);
            context = new Bundle();
            context.putParcelable("CROP_IMAGE_EXTRA_SOURCE", this.f19399a);
            context.putParcelable("CROP_IMAGE_EXTRA_OPTIONS", this.f19400b);
            intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", context);
            return intent;
        }

        /* renamed from: a */
        public void m24632a(Activity activity) {
            this.f19400b.m24652a();
            activity.startActivityForResult(m24624a((Context) activity), 203);
        }

        /* renamed from: a */
        public C5840a m24626a(float f) {
            this.f19400b.f19444k = f;
            return this;
        }

        /* renamed from: a */
        public C5840a m24631a(boolean z) {
            this.f19400b.f19445l = z;
            return this;
        }

        /* renamed from: a */
        public C5840a m24628a(int i, int i2) {
            this.f19400b.f19446m = i;
            this.f19400b.f19447n = i2;
            this.f19400b.f19445l = true;
            return this;
        }

        /* renamed from: a */
        public C5840a m24630a(Uri uri) {
            this.f19400b.f19417F = uri;
            return this;
        }

        /* renamed from: a */
        public C5840a m24629a(CompressFormat compressFormat) {
            this.f19400b.f19418G = compressFormat;
            return this;
        }

        /* renamed from: a */
        public C5840a m24627a(int i) {
            this.f19400b.f19419H = i;
            return this;
        }
    }

    /* compiled from: CropImage */
    /* renamed from: com.theartofdev.edmodo.cropper.d$b */
    public static final class C7196b extends C5819a implements Parcelable {
        public static final Creator<C7196b> CREATOR = new C58411();

        /* compiled from: CropImage */
        /* renamed from: com.theartofdev.edmodo.cropper.d$b$1 */
        static class C58411 implements Creator<C7196b> {
            C58411() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m24633a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m24634a(i);
            }

            /* renamed from: a */
            public C7196b m24633a(Parcel parcel) {
                return new C7196b(parcel);
            }

            /* renamed from: a */
            public C7196b[] m24634a(int i) {
                return new C7196b[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public C7196b(Uri uri, Uri uri2, Exception exception, float[] fArr, Rect rect, int i, Rect rect2, int i2) {
            super(null, uri, null, uri2, exception, fArr, rect, rect2, i, i2);
        }

        protected C7196b(Parcel parcel) {
            super(null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Exception) parcel.readSerializable(), parcel.createFloatArray(), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(m24533a(), i);
            parcel.writeParcelable(m24534b(), i);
            parcel.writeSerializable(m24535c());
            parcel.writeFloatArray(m24536d());
            parcel.writeParcelable(m24537e(), i);
            parcel.writeParcelable(m24538f(), i);
            parcel.writeInt(m24539g());
            parcel.writeInt(m24540h());
        }
    }

    /* renamed from: a */
    public static void m24642a(Activity activity) {
        activity.startActivityForResult(C5842d.m24635a((Context) activity), HttpStatus.HTTP_OK);
    }

    /* renamed from: a */
    public static Intent m24635a(Context context) {
        return C5842d.m24636a(context, context.getString(C5853d.pick_image_intent_chooser_title), false, true);
    }

    /* renamed from: a */
    public static Intent m24636a(Context context, CharSequence charSequence, boolean z, boolean z2) {
        List arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (!C5842d.m24645b(context) && z2) {
            arrayList.addAll(C5842d.m24640a(context, packageManager));
        }
        context = C5842d.m24641a(packageManager, "android.intent.action.GET_CONTENT", z);
        if (!context.size()) {
            context = C5842d.m24641a(packageManager, "android.intent.action.PICK", z);
        }
        arrayList.addAll(context);
        if (arrayList.isEmpty() != null) {
            context = new Intent();
        } else {
            context = (Intent) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        context = Intent.createChooser(context, charSequence);
        context.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        return context;
    }

    /* renamed from: a */
    public static List<Intent> m24640a(Context context, PackageManager packageManager) {
        List<Intent> arrayList = new ArrayList();
        context = C5842d.m24647c(context);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (context != null) {
                intent2.putExtra("output", context);
            }
            arrayList.add(intent2);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<Intent> m24641a(PackageManager packageManager, String str, boolean z) {
        List<Intent> arrayList = new ArrayList();
        Intent intent = str == "android.intent.action.GET_CONTENT" ? new Intent(str) : new Intent(str, Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, null)) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            arrayList.add(intent2);
        }
        if (!z) {
            for (Intent intent3 : arrayList) {
                if (intent3.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                    arrayList.remove(intent3);
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static boolean m24645b(Context context) {
        return (VERSION.SDK_INT < 23 || !C5842d.m24644a(context, "android.permission.CAMERA") || context.checkSelfPermission("android.permission.CAMERA") == null) ? null : true;
    }

    /* renamed from: a */
    public static boolean m24644a(android.content.Context r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getPackageName();
        r1 = 0;
        r4 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0027 }
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ NameNotFoundException -> 0x0027 }
        r4 = r4.getPackageInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x0027 }
        r4 = r4.requestedPermissions;	 Catch:{ NameNotFoundException -> 0x0027 }
        if (r4 == 0) goto L_0x0027;	 Catch:{ NameNotFoundException -> 0x0027 }
    L_0x0013:
        r0 = r4.length;	 Catch:{ NameNotFoundException -> 0x0027 }
        if (r0 <= 0) goto L_0x0027;	 Catch:{ NameNotFoundException -> 0x0027 }
    L_0x0016:
        r0 = r4.length;	 Catch:{ NameNotFoundException -> 0x0027 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0027 }
    L_0x0018:
        if (r2 >= r0) goto L_0x0027;	 Catch:{ NameNotFoundException -> 0x0027 }
    L_0x001a:
        r3 = r4[r2];	 Catch:{ NameNotFoundException -> 0x0027 }
        r3 = r3.equalsIgnoreCase(r5);	 Catch:{ NameNotFoundException -> 0x0027 }
        if (r3 == 0) goto L_0x0024;
    L_0x0022:
        r4 = 1;
        return r4;
    L_0x0024:
        r2 = r2 + 1;
        goto L_0x0018;
    L_0x0027:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.d.a(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: c */
    public static Uri m24647c(Context context) {
        context = context.getExternalCacheDir();
        return context != null ? Uri.fromFile(new File(context.getPath(), "pickImageResult.jpeg")) : null;
    }

    /* renamed from: a */
    public static Uri m24637a(Context context, Intent intent) {
        Object obj = 1;
        if (!(intent == null || intent.getData() == null)) {
            String action = intent.getAction();
            if (action == null || !action.equals("android.media.action.IMAGE_CAPTURE")) {
                obj = null;
            }
        }
        if (obj == null) {
            if (intent.getData() != null) {
                return intent.getData();
            }
        }
        return C5842d.m24647c(context);
    }

    /* renamed from: a */
    public static boolean m24643a(Context context, Uri uri) {
        return (VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 || C5842d.m24646b(context, uri) == null) ? null : true;
    }

    /* renamed from: b */
    public static boolean m24646b(android.content.Context r0, android.net.Uri r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x000f }
        r0 = r0.openInputStream(r1);	 Catch:{ Exception -> 0x000f }
        if (r0 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x000f }
    L_0x000a:
        r0.close();	 Catch:{ Exception -> 0x000f }
    L_0x000d:
        r0 = 0;
        return r0;
    L_0x000f:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.d.b(android.content.Context, android.net.Uri):boolean");
    }

    /* renamed from: a */
    public static C5840a m24638a(Uri uri) {
        return new C5840a(uri);
    }

    /* renamed from: a */
    public static C7196b m24639a(Intent intent) {
        return intent != null ? (C7196b) intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT") : null;
    }
}
