package com.facebook.ads.internal.p098m;

import android.content.Context;
import android.database.Cursor;
import com.facebook.ads.internal.p090e.C1372d;
import com.facebook.ads.internal.p090e.C3575c;
import com.facebook.ads.internal.p091f.C1380e;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p098m.C1411b.C1410a;
import com.facebook.ads.internal.p105q.p106a.C1519s;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.m.g */
public class C3581g implements C1410a {
    /* renamed from: a */
    private static final String f9584a = "g";
    /* renamed from: b */
    private Context f9585b;
    /* renamed from: c */
    private C1372d f9586c;

    public C3581g(Context context, C1372d c1372d) {
        this.f9585b = context;
        this.f9586c = c1372d;
    }

    /* renamed from: a */
    private static JSONArray m11677a(JSONArray jSONArray, JSONArray jSONArray2) {
        int i = 0;
        if (jSONArray != null) {
            i = 0 + jSONArray.length();
        }
        if (jSONArray2 != null) {
            i += jSONArray2.length();
        }
        return C3581g.m11678a(jSONArray, jSONArray2, i);
    }

    /* renamed from: a */
    private static org.json.JSONArray m11678a(org.json.JSONArray r18, org.json.JSONArray r19, int r20) {
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
        r0 = r18;
        r1 = r19;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r2 = r18.length();
        r3 = r19.length();
        r4 = new org.json.JSONArray;
        r4.<init>();
        r5 = 0;
        r6 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r8 = 0;
        r10 = r20;
        r13 = r6;
        r15 = r13;
        r11 = r8;
        r12 = r11;
        r9 = 0;
    L_0x0025:
        if (r5 < r2) goto L_0x0029;
    L_0x0027:
        if (r9 >= r3) goto L_0x006a;
    L_0x0029:
        if (r10 <= 0) goto L_0x006a;
    L_0x002b:
        if (r5 >= r2) goto L_0x003e;
    L_0x002d:
        if (r11 != 0) goto L_0x003e;
    L_0x002f:
        r11 = r0.getJSONObject(r5);	 Catch:{ JSONException -> 0x003a }
        r13 = "time";	 Catch:{ JSONException -> 0x003a }
        r13 = r11.getDouble(r13);	 Catch:{ JSONException -> 0x003a }
        goto L_0x003c;
    L_0x003a:
        r13 = r6;
        r11 = r8;
    L_0x003c:
        r5 = r5 + 1;
    L_0x003e:
        if (r9 >= r3) goto L_0x0051;
    L_0x0040:
        if (r12 != 0) goto L_0x0051;
    L_0x0042:
        r12 = r1.getJSONObject(r9);	 Catch:{ JSONException -> 0x004d }
        r15 = "time";	 Catch:{ JSONException -> 0x004d }
        r15 = r12.getDouble(r15);	 Catch:{ JSONException -> 0x004d }
        goto L_0x004f;
    L_0x004d:
        r15 = r6;
        r12 = r8;
    L_0x004f:
        r9 = r9 + 1;
    L_0x0051:
        if (r11 != 0) goto L_0x0055;
    L_0x0053:
        if (r12 == 0) goto L_0x0025;
    L_0x0055:
        if (r11 == 0) goto L_0x0062;
    L_0x0057:
        r17 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1));
        if (r17 >= 0) goto L_0x005c;
    L_0x005b:
        goto L_0x0062;
    L_0x005c:
        r4.put(r11);
        r13 = r6;
        r11 = r8;
        goto L_0x0067;
    L_0x0062:
        r4.put(r12);
        r15 = r6;
        r12 = r8;
    L_0x0067:
        r10 = r10 + -1;
        goto L_0x0025;
    L_0x006a:
        if (r10 <= 0) goto L_0x0077;
    L_0x006c:
        if (r11 == 0) goto L_0x0072;
    L_0x006e:
        r4.put(r11);
        goto L_0x0077;
    L_0x0072:
        if (r12 == 0) goto L_0x0077;
    L_0x0074:
        r4.put(r12);
    L_0x0077:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.g.a(org.json.JSONArray, org.json.JSONArray, int):org.json.JSONArray");
    }

    /* renamed from: a */
    private org.json.JSONObject m11679a(int r8) {
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
        r7 = this;
        r0 = 0;
        r1 = r7.f9586c;	 Catch:{ JSONException -> 0x006f, all -> 0x0061 }
        r1 = r1.m4693d();	 Catch:{ JSONException -> 0x006f, all -> 0x0061 }
        r2 = r7.f9586c;	 Catch:{ JSONException -> 0x005f, all -> 0x005c }
        r2 = r2.m4685a(r8);	 Catch:{ JSONException -> 0x005f, all -> 0x005c }
        r3 = r2.getCount();	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        if (r3 <= 0) goto L_0x001c;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x0013:
        r3 = r7.m11680a(r2);	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        r4 = r7.m11683c(r2);	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        goto L_0x001e;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x001c:
        r3 = r0;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        r4 = r3;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x001e:
        r5 = r7.f9585b;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        r5 = com.facebook.ads.internal.p097l.C1405a.m4827h(r5);	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        if (r5 == 0) goto L_0x0038;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x0026:
        r5 = r7.f9585b;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        r5 = com.facebook.ads.internal.p091f.C1380e.m4720a(r5, r8);	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        if (r5 == 0) goto L_0x0038;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x002e:
        r6 = r5.length();	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        if (r6 <= 0) goto L_0x0038;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x0034:
        r4 = com.facebook.ads.internal.p098m.C3581g.m11678a(r5, r4, r8);	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x0038:
        if (r4 == 0) goto L_0x004c;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x003a:
        r8 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        r8.<init>();	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        if (r3 == 0) goto L_0x0046;	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x0041:
        r5 = "tokens";	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        r8.put(r5, r3);	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
    L_0x0046:
        r3 = "events";	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        r8.put(r3, r4);	 Catch:{ JSONException -> 0x005a, all -> 0x0058 }
        goto L_0x004d;
    L_0x004c:
        r8 = r0;
    L_0x004d:
        if (r1 == 0) goto L_0x0052;
    L_0x004f:
        r1.close();
    L_0x0052:
        if (r2 == 0) goto L_0x0057;
    L_0x0054:
        r2.close();
    L_0x0057:
        return r8;
    L_0x0058:
        r8 = move-exception;
        goto L_0x0064;
        goto L_0x0071;
    L_0x005c:
        r8 = move-exception;
        r2 = r0;
        goto L_0x0064;
    L_0x005f:
        r2 = r0;
        goto L_0x0071;
    L_0x0061:
        r8 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0064:
        if (r1 == 0) goto L_0x0069;
    L_0x0066:
        r1.close();
    L_0x0069:
        if (r2 == 0) goto L_0x006e;
    L_0x006b:
        r2.close();
    L_0x006e:
        throw r8;
    L_0x006f:
        r1 = r0;
        r2 = r1;
    L_0x0071:
        if (r1 == 0) goto L_0x0076;
    L_0x0073:
        r1.close();
    L_0x0076:
        if (r2 == 0) goto L_0x007b;
    L_0x0078:
        r2.close();
    L_0x007b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.g.a(int):org.json.JSONObject");
    }

    /* renamed from: a */
    private JSONObject m11680a(Cursor cursor) {
        JSONObject jSONObject = new JSONObject();
        while (cursor.moveToNext()) {
            jSONObject.put(cursor.getString(0), cursor.getString(1));
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m11681a(String str) {
        if (C1380e.m4729c(str)) {
            C1380e.m4723a(str);
        } else {
            this.f9586c.m4689a(str);
        }
    }

    /* renamed from: b */
    private JSONArray m11682b(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cursor.getString(C3575c.f9556a.f3971a));
            jSONObject.put("token_id", cursor.getString(C3575c.f9557b.f3971a));
            jSONObject.put("type", cursor.getString(C3575c.f9559d.f3971a));
            jSONObject.put("time", C1519s.m5327a(cursor.getDouble(C3575c.f9560e.f3971a)));
            jSONObject.put("session_time", C1519s.m5327a(cursor.getDouble(C3575c.f9561f.f3971a)));
            jSONObject.put("session_id", cursor.getString(C3575c.f9562g.f3971a));
            String string = cursor.getString(C3575c.f9563h.f3971a);
            jSONObject.put("data", string != null ? new JSONObject(string) : new JSONObject());
            jSONObject.put("attempt", cursor.getString(C3575c.f9564i.f3971a));
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /* renamed from: c */
    private JSONArray m11683c(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cursor.getString(2));
            jSONObject.put("token_id", cursor.getString(0));
            jSONObject.put("type", cursor.getString(4));
            jSONObject.put("time", C1519s.m5327a(cursor.getDouble(5)));
            jSONObject.put("session_time", C1519s.m5327a(cursor.getDouble(6)));
            jSONObject.put("session_id", cursor.getString(7));
            String string = cursor.getString(8);
            jSONObject.put("data", string != null ? new JSONObject(string) : new JSONObject());
            jSONObject.put("attempt", cursor.getString(9));
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /* renamed from: d */
    private org.json.JSONObject m11684d() {
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
        r8 = this;
        r0 = 0;
        r1 = r8.f9586c;	 Catch:{ JSONException -> 0x0077, all -> 0x0068 }
        r1 = r1.m4695f();	 Catch:{ JSONException -> 0x0077, all -> 0x0068 }
        r2 = r8.f9586c;	 Catch:{ JSONException -> 0x0066, all -> 0x0061 }
        r2 = r2.m4694e();	 Catch:{ JSONException -> 0x0066, all -> 0x0061 }
        r3 = r1.getCount();	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        if (r3 <= 0) goto L_0x0022;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x0013:
        r3 = r2.getCount();	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        if (r3 <= 0) goto L_0x0022;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x0019:
        r3 = r8.m11680a(r1);	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        r4 = r8.m11682b(r2);	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        goto L_0x0024;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x0022:
        r3 = r0;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        r4 = r3;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x0024:
        r5 = r8.f9585b;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        r5 = com.facebook.ads.internal.p097l.C1405a.m4827h(r5);	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        if (r5 == 0) goto L_0x003e;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x002c:
        r5 = r8.f9585b;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        r5 = com.facebook.ads.internal.p091f.C1380e.m4719a(r5);	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        if (r5 == 0) goto L_0x003e;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x0034:
        r6 = r5.length();	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        if (r6 <= 0) goto L_0x003e;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x003a:
        r4 = com.facebook.ads.internal.p098m.C3581g.m11677a(r5, r4);	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x003e:
        if (r4 == 0) goto L_0x0052;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x0040:
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        r5.<init>();	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        if (r3 == 0) goto L_0x004c;	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x0047:
        r6 = "tokens";	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        r5.put(r6, r3);	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
    L_0x004c:
        r3 = "events";	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        r5.put(r3, r4);	 Catch:{ JSONException -> 0x005f, all -> 0x005d }
        r0 = r5;
    L_0x0052:
        if (r1 == 0) goto L_0x0057;
    L_0x0054:
        r1.close();
    L_0x0057:
        if (r2 == 0) goto L_0x005c;
    L_0x0059:
        r2.close();
    L_0x005c:
        return r0;
    L_0x005d:
        r0 = move-exception;
        goto L_0x006c;
        goto L_0x0079;
    L_0x0061:
        r2 = move-exception;
        r7 = r2;
        r2 = r0;
        r0 = r7;
        goto L_0x006c;
    L_0x0066:
        r2 = r0;
        goto L_0x0079;
    L_0x0068:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
    L_0x006c:
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.close();
    L_0x0071:
        if (r2 == 0) goto L_0x0076;
    L_0x0073:
        r2.close();
    L_0x0076:
        throw r0;
    L_0x0077:
        r1 = r0;
        r2 = r1;
    L_0x0079:
        if (r1 == 0) goto L_0x007e;
    L_0x007b:
        r1.close();
    L_0x007e:
        if (r2 == 0) goto L_0x0083;
    L_0x0080:
        r2.close();
    L_0x0083:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.g.d():org.json.JSONObject");
    }

    /* renamed from: a */
    public JSONObject mo956a() {
        int o = C1405a.m4834o(this.f9585b);
        return o > 0 ? m11679a(o) : m11684d();
    }

    /* renamed from: a */
    public boolean mo957a(org.json.JSONArray r10) {
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
        r9 = this;
        r0 = r9.f9585b;
        r0 = com.facebook.ads.internal.p097l.C1405a.m4827h(r0);
        r1 = 0;
        r2 = 1;
        r3 = 0;
        r4 = 1;
    L_0x000a:
        r5 = r10.length();
        if (r3 >= r5) goto L_0x0051;
    L_0x0010:
        r5 = r10.getJSONObject(r3);	 Catch:{ JSONException -> 0x004e }
        r6 = "id";	 Catch:{ JSONException -> 0x004e }
        r6 = r5.getString(r6);	 Catch:{ JSONException -> 0x004e }
        r7 = "code";	 Catch:{ JSONException -> 0x004e }
        r5 = r5.getInt(r7);	 Catch:{ JSONException -> 0x004e }
        if (r5 != r2) goto L_0x0030;	 Catch:{ JSONException -> 0x004e }
    L_0x0022:
        r5 = r9.f9586c;	 Catch:{ JSONException -> 0x004e }
        r5 = r5.m4691b(r6);	 Catch:{ JSONException -> 0x004e }
        if (r5 != 0) goto L_0x004e;	 Catch:{ JSONException -> 0x004e }
    L_0x002a:
        if (r0 == 0) goto L_0x004e;	 Catch:{ JSONException -> 0x004e }
    L_0x002c:
        com.facebook.ads.internal.p091f.C1380e.m4727b(r6);	 Catch:{ JSONException -> 0x004e }
        goto L_0x004e;	 Catch:{ JSONException -> 0x004e }
    L_0x0030:
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ JSONException -> 0x004e }
        r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;	 Catch:{ JSONException -> 0x004e }
        if (r5 < r7) goto L_0x003d;	 Catch:{ JSONException -> 0x004e }
    L_0x0036:
        if (r5 >= r8) goto L_0x003d;	 Catch:{ JSONException -> 0x004e }
    L_0x0038:
        r9.m11681a(r6);	 Catch:{ JSONException -> 0x004e }
        r4 = 0;	 Catch:{ JSONException -> 0x004e }
        goto L_0x004e;	 Catch:{ JSONException -> 0x004e }
    L_0x003d:
        if (r5 < r8) goto L_0x004e;	 Catch:{ JSONException -> 0x004e }
    L_0x003f:
        r7 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ JSONException -> 0x004e }
        if (r5 >= r7) goto L_0x004e;	 Catch:{ JSONException -> 0x004e }
    L_0x0043:
        r5 = r9.f9586c;	 Catch:{ JSONException -> 0x004e }
        r5 = r5.m4691b(r6);	 Catch:{ JSONException -> 0x004e }
        if (r5 != 0) goto L_0x004e;
    L_0x004b:
        if (r0 == 0) goto L_0x004e;
    L_0x004d:
        goto L_0x002c;
    L_0x004e:
        r3 = r3 + 1;
        goto L_0x000a;
    L_0x0051:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.g.a(org.json.JSONArray):boolean");
    }

    /* renamed from: b */
    public void mo958b() {
        this.f9586c.m4696g();
        this.f9586c.m4690b();
        C1380e.m4728c(this.f9585b);
    }

    /* renamed from: b */
    public void mo959b(org.json.JSONArray r5) {
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
        r4 = this;
        r0 = r5.length();
        r1 = 0;
    L_0x0005:
        if (r1 >= r0) goto L_0x0017;
    L_0x0007:
        r2 = r5.getJSONObject(r1);	 Catch:{ JSONException -> 0x0014 }
        r3 = "id";	 Catch:{ JSONException -> 0x0014 }
        r2 = r2.getString(r3);	 Catch:{ JSONException -> 0x0014 }
        r4.m11681a(r2);	 Catch:{ JSONException -> 0x0014 }
    L_0x0014:
        r1 = r1 + 1;
        goto L_0x0005;
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.g.b(org.json.JSONArray):void");
    }

    /* renamed from: c */
    public boolean mo960c() {
        Throwable th;
        int o = C1405a.m4834o(this.f9585b);
        boolean z = true;
        if (o < 1) {
            return false;
        }
        Cursor d;
        try {
            d = this.f9586c.m4693d();
            try {
                if ((d.moveToFirst() ? d.getInt(0) : 0) + C1380e.m4725b(this.f9585b) <= o) {
                    z = false;
                }
                if (d != null) {
                    d.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (d != null) {
                    d.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            d = null;
            if (d != null) {
                d.close();
            }
            throw th;
        }
    }
}
