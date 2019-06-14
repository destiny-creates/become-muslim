package expo.modules.permissions;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v4.app.af;
import com.facebook.places.model.PlaceFields;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5995b;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6000g;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;
import expo.p307b.p315h.C6033a;
import expo.p307b.p315h.C6034b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermissionsModule extends C6006c implements C6000g, C6001h {
    private static final String DENIED_VALUE = "denied";
    private static final String ERROR_TAG = "E_PERMISSIONS";
    private static final String EXPIRES_KEY = "expires";
    private static final String GRANTED_VALUE = "granted";
    private static String PERMISSION_EXPIRES_NEVER = "never";
    private static final String STATUS_KEY = "status";
    private static final String UNDETERMINED_VALUE = "undetermined";
    private C5995b mActivityProvider;
    private ArrayList<String> mAskAsyncPermissionsTypesToBeAsked = null;
    private C6009f mAskAsyncPromise = null;
    private ArrayList<String> mAskAsyncRequestedPermissionsTypes = null;
    private C6033a mPermissions;
    private PermissionsRequester mPermissionsRequester;
    private boolean mWritingPermissionBeingAsked = null;

    public String getName() {
        return "ExpoPermissions";
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public PermissionsModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mPermissionsRequester = new PermissionsRequester(c6007d);
        this.mPermissions = (C6033a) c6007d.m25133a(C6033a.class);
        this.mActivityProvider = (C5995b) c6007d.m25133a(C5995b.class);
        ((C5993b) c6007d.m25133a(C5993b.class)).registerLifecycleEventListener(this);
    }

    @C5996c
    public void getAsync(ArrayList<String> arrayList, C6009f c6009f) {
        try {
            c6009f.mo5137a(getPermissions(arrayList));
        } catch (Throwable e) {
            c6009f.m25154a("E_PERMISSIONS_UNKNOWN", e);
        }
    }

    @C5996c
    public void askAsync(ArrayList<String> arrayList, C6009f c6009f) {
        Set<String> hashSet = new HashSet(arrayList);
        try {
            Object permissions = getPermissions(arrayList);
            for (String str : permissions.keySet()) {
                Bundle bundle = permissions.getBundle(str);
                if (bundle.getString("status") != null && bundle.getString("status").equals(GRANTED_VALUE)) {
                    hashSet.remove(str);
                }
            }
            if (hashSet.isEmpty()) {
                c6009f.mo5137a(permissions);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : hashSet) {
                Object obj = -1;
                switch (str2.hashCode()) {
                    case -2012177086:
                        if (str2.equals("cameraRoll")) {
                            obj = 8;
                            break;
                        }
                        break;
                    case -1367751899:
                        if (str2.equals("camera")) {
                            obj = 5;
                            break;
                        }
                        break;
                    case -612105885:
                        if (str2.equals("userFacingNotifications")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case -567451565:
                        if (str2.equals("contacts")) {
                            obj = 6;
                            break;
                        }
                        break;
                    case -178324674:
                        if (str2.equals("calendar")) {
                            obj = 9;
                            break;
                        }
                        break;
                    case 1103187521:
                        if (str2.equals("reminders")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 1218441915:
                        if (str2.equals("audioRecording")) {
                            obj = 7;
                            break;
                        }
                        break;
                    case 1272354024:
                        if (str2.equals("notifications")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 1663486944:
                        if (str2.equals("systemBrightness")) {
                            obj = 3;
                            break;
                        }
                        break;
                    case 1901043637:
                        if (str2.equals(PlaceFields.LOCATION)) {
                            obj = 4;
                            break;
                        }
                        break;
                    default:
                        break;
                }
                switch (obj) {
                    case null:
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                        arrayList2.add("android.permission.ACCESS_FINE_LOCATION");
                        arrayList2.add("android.permission.ACCESS_COARSE_LOCATION");
                        break;
                    case 5:
                        arrayList2.add("android.permission.CAMERA");
                        break;
                    case 6:
                        arrayList2.add("android.permission.READ_CONTACTS");
                        if (!isPermissionPresentInManifest("android.permission.WRITE_CONTACTS")) {
                            break;
                        }
                        arrayList2.add("android.permission.WRITE_CONTACTS");
                        break;
                    case 7:
                        arrayList2.add("android.permission.RECORD_AUDIO");
                        break;
                    case 8:
                        arrayList2.add("android.permission.READ_EXTERNAL_STORAGE");
                        arrayList2.add("android.permission.WRITE_EXTERNAL_STORAGE");
                        break;
                    case 9:
                        arrayList2.add("android.permission.READ_CALENDAR");
                        arrayList2.add("android.permission.WRITE_CALENDAR");
                        break;
                    default:
                        c6009f.m25152a("E_PERMISSIONS_UNSUPPORTED", String.format("Cannot request permission: %s", new Object[]{str2}));
                        return;
                }
            }
            if (!hashSet.contains("systemBrightness") || VERSION.SDK_INT < 23) {
                askForPermissions(arrayList, arrayList2, c6009f);
            } else if (this.mAskAsyncPromise != null) {
                c6009f.m25152a("E_PERMISSIONS_ASKING_IN_PROGRESS", "Different asking for permissions in progress. Await the old request and then try again.");
            } else {
                this.mAskAsyncPromise = c6009f;
                this.mAskAsyncRequestedPermissionsTypes = arrayList;
                this.mAskAsyncPermissionsTypesToBeAsked = arrayList2;
                askForWriteSettingsPermissionFirst();
            }
        } catch (Throwable e) {
            c6009f.m25154a("E_PERMISSIONS_UNKNOWN", e);
        }
    }

    private void askForPermissions(final ArrayList<String> arrayList, ArrayList<String> arrayList2, final C6009f c6009f) {
        if (this.mPermissionsRequester.askForPermissions((String[]) arrayList2.toArray(new String[arrayList2.size()]), new C6034b() {
            public void onPermissionResult(String[] strArr, int[] iArr) {
                c6009f.mo5137a(PermissionsModule.this.getPermissions(arrayList));
            }
        }) == null) {
            c6009f.m25152a("E_PERMISSIONS_UNAVAILABLE", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
        }
    }

    private Bundle getPermissions(ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            String str = (String) arrayList.next();
            bundle.putBundle(str, getPermission(str));
        }
        return bundle;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.os.Bundle getPermission(java.lang.String r4) {
        /*
        r3 = this;
        r0 = r4.hashCode();
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case -2012177086: goto L_0x0073;
            case -1367751899: goto L_0x0069;
            case -612105885: goto L_0x005f;
            case -567451565: goto L_0x0055;
            case -178324674: goto L_0x004a;
            case 82233: goto L_0x003f;
            case 1103187521: goto L_0x0034;
            case 1218441915: goto L_0x002a;
            case 1272354024: goto L_0x0020;
            case 1663486944: goto L_0x0016;
            case 1901043637: goto L_0x000b;
            default: goto L_0x0009;
        };
    L_0x0009:
        goto L_0x007d;
    L_0x000b:
        r0 = "location";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x0013:
        r0 = 2;
        goto L_0x007e;
    L_0x0016:
        r0 = "systemBrightness";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x001e:
        r0 = 6;
        goto L_0x007e;
    L_0x0020:
        r0 = "notifications";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x0028:
        r0 = 0;
        goto L_0x007e;
    L_0x002a:
        r0 = "audioRecording";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x0032:
        r0 = 5;
        goto L_0x007e;
    L_0x0034:
        r0 = "reminders";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x003c:
        r0 = 10;
        goto L_0x007e;
    L_0x003f:
        r0 = "SMS";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x0047:
        r0 = 9;
        goto L_0x007e;
    L_0x004a:
        r0 = "calendar";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x0052:
        r0 = 8;
        goto L_0x007e;
    L_0x0055:
        r0 = "contacts";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x005d:
        r0 = 4;
        goto L_0x007e;
    L_0x005f:
        r0 = "userFacingNotifications";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x0067:
        r0 = 1;
        goto L_0x007e;
    L_0x0069:
        r0 = "camera";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x0071:
        r0 = 3;
        goto L_0x007e;
    L_0x0073:
        r0 = "cameraRoll";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x007d;
    L_0x007b:
        r0 = 7;
        goto L_0x007e;
    L_0x007d:
        r0 = -1;
    L_0x007e:
        switch(r0) {
            case 0: goto L_0x00d5;
            case 1: goto L_0x00d5;
            case 2: goto L_0x00d0;
            case 3: goto L_0x00c9;
            case 4: goto L_0x00c2;
            case 5: goto L_0x00bb;
            case 6: goto L_0x00b6;
            case 7: goto L_0x00b1;
            case 8: goto L_0x00ac;
            case 9: goto L_0x00a5;
            case 10: goto L_0x0091;
            default: goto L_0x0081;
        };
    L_0x0081:
        r0 = new java.lang.IllegalStateException;
        r2 = new java.lang.Object[r2];
        r2[r1] = r4;
        r4 = "Unrecognized permission type: %s";
        r4 = java.lang.String.format(r4, r2);
        r0.<init>(r4);
        throw r0;
    L_0x0091:
        r4 = new android.os.Bundle;
        r4.<init>();
        r0 = "status";
        r1 = "granted";
        r4.putString(r0, r1);
        r0 = "expires";
        r1 = PERMISSION_EXPIRES_NEVER;
        r4.putString(r0, r1);
        return r4;
    L_0x00a5:
        r4 = "android.permission.READ_SMS";
        r4 = r3.getSimplePermission(r4);
        return r4;
    L_0x00ac:
        r4 = r3.getCalendarPermissions();
        return r4;
    L_0x00b1:
        r4 = r3.getCameraRollPermissions();
        return r4;
    L_0x00b6:
        r4 = r3.getWriteSettingsPermission();
        return r4;
    L_0x00bb:
        r4 = "android.permission.RECORD_AUDIO";
        r4 = r3.getSimplePermission(r4);
        return r4;
    L_0x00c2:
        r4 = "android.permission.READ_CONTACTS";
        r4 = r3.getSimplePermission(r4);
        return r4;
    L_0x00c9:
        r4 = "android.permission.CAMERA";
        r4 = r3.getSimplePermission(r4);
        return r4;
    L_0x00d0:
        r4 = r3.getLocationPermissions();
        return r4;
    L_0x00d5:
        r4 = r3.getNotificationPermissions();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.permissions.PermissionsModule.getPermission(java.lang.String):android.os.Bundle");
    }

    private Bundle getNotificationPermissions() {
        Bundle bundle = new Bundle();
        bundle.putString("status", af.a(getContext()).a() ? GRANTED_VALUE : DENIED_VALUE);
        bundle.putString(EXPIRES_KEY, PERMISSION_EXPIRES_NEVER);
        return bundle;
    }

    private android.os.Bundle getLocationPermissions() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = "none";
        r2 = "android.permission.ACCESS_FINE_LOCATION";	 Catch:{ IllegalStateException -> 0x0034 }
        r2 = r4.isPermissionGranted(r2);	 Catch:{ IllegalStateException -> 0x0034 }
        if (r2 == 0) goto L_0x001a;	 Catch:{ IllegalStateException -> 0x0034 }
    L_0x000f:
        r2 = "status";	 Catch:{ IllegalStateException -> 0x0034 }
        r3 = "granted";	 Catch:{ IllegalStateException -> 0x0034 }
        r0.putString(r2, r3);	 Catch:{ IllegalStateException -> 0x0034 }
        r2 = "fine";	 Catch:{ IllegalStateException -> 0x0034 }
    L_0x0018:
        r1 = r2;	 Catch:{ IllegalStateException -> 0x0034 }
        goto L_0x003b;	 Catch:{ IllegalStateException -> 0x0034 }
    L_0x001a:
        r2 = "android.permission.ACCESS_COARSE_LOCATION";	 Catch:{ IllegalStateException -> 0x0034 }
        r2 = r4.isPermissionGranted(r2);	 Catch:{ IllegalStateException -> 0x0034 }
        if (r2 == 0) goto L_0x002c;	 Catch:{ IllegalStateException -> 0x0034 }
    L_0x0022:
        r2 = "status";	 Catch:{ IllegalStateException -> 0x0034 }
        r3 = "granted";	 Catch:{ IllegalStateException -> 0x0034 }
        r0.putString(r2, r3);	 Catch:{ IllegalStateException -> 0x0034 }
        r2 = "coarse";	 Catch:{ IllegalStateException -> 0x0034 }
        goto L_0x0018;	 Catch:{ IllegalStateException -> 0x0034 }
    L_0x002c:
        r2 = "status";	 Catch:{ IllegalStateException -> 0x0034 }
        r3 = "denied";	 Catch:{ IllegalStateException -> 0x0034 }
        r0.putString(r2, r3);	 Catch:{ IllegalStateException -> 0x0034 }
        goto L_0x003b;
    L_0x0034:
        r2 = "status";
        r3 = "undetermined";
        r0.putString(r2, r3);
    L_0x003b:
        r2 = "expires";
        r3 = PERMISSION_EXPIRES_NEVER;
        r0.putString(r2, r3);
        r2 = new android.os.Bundle;
        r2.<init>();
        r3 = "scope";
        r2.putString(r3, r1);
        r1 = "android";
        r0.putBundle(r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.permissions.PermissionsModule.getLocationPermissions():android.os.Bundle");
    }

    private Bundle getWriteSettingsPermission() {
        Bundle bundle = new Bundle();
        bundle.putString(EXPIRES_KEY, PERMISSION_EXPIRES_NEVER);
        if (VERSION.SDK_INT < 23) {
            bundle.putString("status", GRANTED_VALUE);
        } else if (System.canWrite(this.mActivityProvider.getCurrentActivity().getApplicationContext())) {
            bundle.putString("status", GRANTED_VALUE);
        } else {
            bundle.putString("status", DENIED_VALUE);
        }
        return bundle;
    }

    private android.os.Bundle getSimplePermission(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new android.os.Bundle;
        r0.<init>();
        r3 = r2.isPermissionGranted(r3);	 Catch:{ IllegalStateException -> 0x001b }
        if (r3 == 0) goto L_0x0013;	 Catch:{ IllegalStateException -> 0x001b }
    L_0x000b:
        r3 = "status";	 Catch:{ IllegalStateException -> 0x001b }
        r1 = "granted";	 Catch:{ IllegalStateException -> 0x001b }
        r0.putString(r3, r1);	 Catch:{ IllegalStateException -> 0x001b }
        goto L_0x0022;	 Catch:{ IllegalStateException -> 0x001b }
    L_0x0013:
        r3 = "status";	 Catch:{ IllegalStateException -> 0x001b }
        r1 = "denied";	 Catch:{ IllegalStateException -> 0x001b }
        r0.putString(r3, r1);	 Catch:{ IllegalStateException -> 0x001b }
        goto L_0x0022;
    L_0x001b:
        r3 = "status";
        r1 = "undetermined";
        r0.putString(r3, r1);
    L_0x0022:
        r3 = "expires";
        r1 = PERMISSION_EXPIRES_NEVER;
        r0.putString(r3, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.permissions.PermissionsModule.getSimplePermission(java.lang.String):android.os.Bundle");
    }

    private android.os.Bundle getCameraRollPermissions() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = "android.permission.READ_EXTERNAL_STORAGE";	 Catch:{ IllegalStateException -> 0x0023 }
        r2 = "android.permission.WRITE_EXTERNAL_STORAGE";	 Catch:{ IllegalStateException -> 0x0023 }
        r1 = new java.lang.String[]{r1, r2};	 Catch:{ IllegalStateException -> 0x0023 }
        r1 = r3.arePermissionsGranted(r1);	 Catch:{ IllegalStateException -> 0x0023 }
        if (r1 == 0) goto L_0x001b;	 Catch:{ IllegalStateException -> 0x0023 }
    L_0x0013:
        r1 = "status";	 Catch:{ IllegalStateException -> 0x0023 }
        r2 = "granted";	 Catch:{ IllegalStateException -> 0x0023 }
        r0.putString(r1, r2);	 Catch:{ IllegalStateException -> 0x0023 }
        goto L_0x002a;	 Catch:{ IllegalStateException -> 0x0023 }
    L_0x001b:
        r1 = "status";	 Catch:{ IllegalStateException -> 0x0023 }
        r2 = "denied";	 Catch:{ IllegalStateException -> 0x0023 }
        r0.putString(r1, r2);	 Catch:{ IllegalStateException -> 0x0023 }
        goto L_0x002a;
    L_0x0023:
        r1 = "status";
        r2 = "undetermined";
        r0.putString(r1, r2);
    L_0x002a:
        r1 = "expires";
        r2 = PERMISSION_EXPIRES_NEVER;
        r0.putString(r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.permissions.PermissionsModule.getCameraRollPermissions():android.os.Bundle");
    }

    private android.os.Bundle getCalendarPermissions() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = "android.permission.READ_CALENDAR";	 Catch:{ IllegalStateException -> 0x0023 }
        r2 = "android.permission.WRITE_CALENDAR";	 Catch:{ IllegalStateException -> 0x0023 }
        r1 = new java.lang.String[]{r1, r2};	 Catch:{ IllegalStateException -> 0x0023 }
        r1 = r3.arePermissionsGranted(r1);	 Catch:{ IllegalStateException -> 0x0023 }
        if (r1 == 0) goto L_0x001b;	 Catch:{ IllegalStateException -> 0x0023 }
    L_0x0013:
        r1 = "status";	 Catch:{ IllegalStateException -> 0x0023 }
        r2 = "granted";	 Catch:{ IllegalStateException -> 0x0023 }
        r0.putString(r1, r2);	 Catch:{ IllegalStateException -> 0x0023 }
        goto L_0x002a;	 Catch:{ IllegalStateException -> 0x0023 }
    L_0x001b:
        r1 = "status";	 Catch:{ IllegalStateException -> 0x0023 }
        r2 = "denied";	 Catch:{ IllegalStateException -> 0x0023 }
        r0.putString(r1, r2);	 Catch:{ IllegalStateException -> 0x0023 }
        goto L_0x002a;
    L_0x0023:
        r1 = "status";
        r2 = "undetermined";
        r0.putString(r1, r2);
    L_0x002a:
        r1 = "expires";
        r2 = PERMISSION_EXPIRES_NEVER;
        r0.putString(r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.permissions.PermissionsModule.getCalendarPermissions():android.os.Bundle");
    }

    private boolean isPermissionGranted(String str) {
        if (this.mPermissions != null) {
            return this.mPermissions.getPermission(str) == null ? true : null;
        } else {
            throw new IllegalStateException("No Permissions module present.");
        }
    }

    private boolean arePermissionsGranted(String[] strArr) {
        if (this.mPermissions != null) {
            int[] permissions = this.mPermissions.getPermissions(strArr);
            if (strArr.length != permissions.length) {
                return false;
            }
            for (int i : permissions) {
                if (i != 0) {
                    return false;
                }
            }
            return 1;
        }
        throw new IllegalStateException("No Permissions module present.");
    }

    private boolean isPermissionPresentInManifest(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.getContext();	 Catch:{ NameNotFoundException -> 0x0023 }
        r2 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0023 }
        r1 = r1.getPackageName();	 Catch:{ NameNotFoundException -> 0x0023 }
        r3 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ NameNotFoundException -> 0x0023 }
        r1 = r2.getPackageInfo(r1, r3);	 Catch:{ NameNotFoundException -> 0x0023 }
        r2 = r1.requestedPermissions;	 Catch:{ NameNotFoundException -> 0x0023 }
        if (r2 == 0) goto L_0x0022;	 Catch:{ NameNotFoundException -> 0x0023 }
    L_0x0017:
        r1 = r1.requestedPermissions;	 Catch:{ NameNotFoundException -> 0x0023 }
        r1 = java.util.Arrays.asList(r1);	 Catch:{ NameNotFoundException -> 0x0023 }
        r5 = r1.contains(r5);	 Catch:{ NameNotFoundException -> 0x0023 }
        return r5;
    L_0x0022:
        return r0;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.permissions.PermissionsModule.isPermissionPresentInManifest(java.lang.String):boolean");
    }

    @TargetApi(23)
    private void askForWriteSettingsPermissionFirst() {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package:");
        stringBuilder.append(getContext().getPackageName());
        intent.setData(Uri.parse(stringBuilder.toString()));
        intent.addFlags(268435456);
        this.mWritingPermissionBeingAsked = true;
        getContext().startActivity(intent);
    }

    public void onHostResume() {
        if (this.mWritingPermissionBeingAsked) {
            this.mWritingPermissionBeingAsked = false;
            C6009f c6009f = this.mAskAsyncPromise;
            ArrayList arrayList = this.mAskAsyncRequestedPermissionsTypes;
            ArrayList arrayList2 = this.mAskAsyncPermissionsTypesToBeAsked;
            this.mAskAsyncPromise = null;
            this.mAskAsyncRequestedPermissionsTypes = null;
            this.mAskAsyncPermissionsTypesToBeAsked = null;
            askForPermissions(arrayList, arrayList2, c6009f);
        }
    }
}
