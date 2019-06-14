package com.facebook.messenger;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.ServerProtocol;
import com.facebook.messenger.MessengerThreadParams.Origin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p043b.C0816c;

public class MessengerUtils {
    public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
    public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
    public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
    public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
    public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
    public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
    public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
    public static final String PACKAGE_NAME = "com.facebook.orca";
    public static final int PROTOCOL_VERSION_20150314 = 20150314;
    private static final String TAG = "MessengerUtils";

    public static void shareToMessenger(Activity activity, int i, ShareToMessengerParams shareToMessengerParams) {
        if (hasMessengerInstalled(activity)) {
            if (getAllAvailableProtocolVersions(activity).contains(Integer.valueOf(PROTOCOL_VERSION_20150314))) {
                shareToMessenger20150314(activity, i, shareToMessengerParams);
            } else {
                openMessengerInPlayStore(activity);
            }
            return;
        }
        openMessengerInPlayStore(activity);
    }

    private static void shareToMessenger20150314(android.app.Activity r4, int r5, com.facebook.messenger.ShareToMessengerParams r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r1 = "android.intent.action.SEND";	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.<init>(r1);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r1 = 1;	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.setFlags(r1);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r1 = "com.facebook.orca";	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.setPackage(r1);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r1 = "android.intent.extra.STREAM";	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r2 = r6.uri;	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.putExtra(r1, r2);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r1 = r6.mimeType;	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.setType(r1);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r1 = com.facebook.FacebookSdk.getApplicationId();	 Catch:{ ActivityNotFoundException -> 0x0041 }
        if (r1 == 0) goto L_0x003d;	 Catch:{ ActivityNotFoundException -> 0x0041 }
    L_0x0022:
        r2 = "com.facebook.orca.extra.PROTOCOL_VERSION";	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r3 = 20150314; // 0x133782a float:3.296332E-38 double:9.955578E-317;	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.putExtra(r2, r3);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r2 = "com.facebook.orca.extra.APPLICATION_ID";	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.putExtra(r2, r1);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r1 = "com.facebook.orca.extra.METADATA";	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r2 = r6.metaData;	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.putExtra(r1, r2);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r1 = "com.facebook.orca.extra.EXTERNAL_URI";	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r6 = r6.externalUri;	 Catch:{ ActivityNotFoundException -> 0x0041 }
        r0.putExtra(r1, r6);	 Catch:{ ActivityNotFoundException -> 0x0041 }
    L_0x003d:
        r4.startActivityForResult(r0, r5);	 Catch:{ ActivityNotFoundException -> 0x0041 }
        goto L_0x004e;
    L_0x0041:
        r5 = r4.getPackageManager();
        r6 = "com.facebook.orca";
        r5 = r5.getLaunchIntentForPackage(r6);
        r4.startActivity(r5);
    L_0x004e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messenger.MessengerUtils.shareToMessenger20150314(android.app.Activity, int, com.facebook.messenger.ShareToMessengerParams):void");
    }

    public static MessengerThreadParams getMessengerThreadParamsForIntent(Intent intent) {
        Set categories = intent.getCategories();
        if (categories == null || !categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
            return null;
        }
        intent = C0816c.m2965b(intent);
        String string = intent.getString(EXTRA_THREAD_TOKEN_KEY);
        String string2 = intent.getString(EXTRA_METADATA);
        String string3 = intent.getString(EXTRA_PARTICIPANTS);
        boolean z = intent.getBoolean(EXTRA_IS_REPLY);
        intent = intent.getBoolean(EXTRA_IS_COMPOSE);
        Origin origin = Origin.UNKNOWN;
        if (z) {
            origin = Origin.REPLY_FLOW;
        } else if (intent != null) {
            origin = Origin.COMPOSE_FLOW;
        }
        return new MessengerThreadParams(origin, string, string2, parseParticipants(string3));
    }

    public static void finishShareToMessenger(Activity activity, ShareToMessengerParams shareToMessengerParams) {
        Intent intent = activity.getIntent();
        Set categories = intent.getCategories();
        if (categories == null) {
            activity.setResult(0, null);
            activity.finish();
            return;
        }
        if (categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
            Bundle b = C0816c.m2965b(intent);
            Intent intent2 = new Intent();
            if (categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                intent2.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
                intent2.putExtra(EXTRA_THREAD_TOKEN_KEY, b.getString(EXTRA_THREAD_TOKEN_KEY));
                intent2.setDataAndType(shareToMessengerParams.uri, shareToMessengerParams.mimeType);
                intent2.setFlags(1);
                intent2.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
                intent2.putExtra(EXTRA_METADATA, shareToMessengerParams.metaData);
                intent2.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.externalUri);
                activity.setResult(-1, intent2);
                activity.finish();
            } else {
                throw new RuntimeException();
            }
        }
        activity.setResult(0, null);
        activity.finish();
    }

    public static boolean hasMessengerInstalled(Context context) {
        return FacebookSignatureValidator.validateSignature(context, PACKAGE_NAME);
    }

    public static void openMessengerInPlayStore(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = "market://details?id=com.facebook.orca";	 Catch:{ ActivityNotFoundException -> 0x0006 }
        startViewUri(r1, r0);	 Catch:{ ActivityNotFoundException -> 0x0006 }
        goto L_0x000b;
    L_0x0006:
        r0 = "http://play.google.com/store/apps/details?id=com.facebook.orca";
        startViewUri(r1, r0);
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messenger.MessengerUtils.openMessengerInPlayStore(android.content.Context):void");
    }

    private static Set<Integer> getAllAvailableProtocolVersions(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        context = new HashSet();
        Cursor query = contentResolver.query(Uri.parse("content://com.facebook.orca.provider.MessengerPlatformProvider/versions"), new String[]{ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION}, null, null, null);
        if (query != null) {
            try {
                int columnIndex = query.getColumnIndex(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                while (query.moveToNext()) {
                    context.add(Integer.valueOf(query.getInt(columnIndex)));
                }
            } finally {
                query.close();
            }
        }
        return context;
    }

    private static void startViewUri(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private static List<String> parseParticipants(String str) {
        if (str != null) {
            if (str.length() != 0) {
                str = str.split(",");
                List<String> arrayList = new ArrayList();
                for (String trim : str) {
                    arrayList.add(trim.trim());
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }
}
