package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.google.android.gms.internal.l.ag */
final class ag extends SQLiteOpenHelper {
    /* renamed from: a */
    private final /* synthetic */ ad f16878a;

    ag(ad adVar, Context context, String str) {
        this.f16878a = adVar;
        super(context, str, null, 1);
    }

    public final android.database.sqlite.SQLiteDatabase getWritableDatabase() {
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
        r3 = this;
        r0 = r3.f16878a;
        r0 = r0.f32787i;
        r1 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0 = r0.m21368a(r1);
        if (r0 == 0) goto L_0x006c;
    L_0x000f:
        r0 = super.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = r3.f16878a;
        r0 = r0.f32787i;
        r0.m21367a();
        r0 = r3.f16878a;
        r0 = r0.mo4754r();
        r0 = r0.I_();
        r1 = "Opening the database failed, dropping and recreating it";
        r0.m21307a(r1);
        r0 = "google_app_measurement.db";
        r1 = r3.f16878a;
        r1 = r1.mo4752n();
        r1 = r1.getDatabasePath(r0);
        r1 = r1.delete();
        if (r1 != 0) goto L_0x004d;
    L_0x003e:
        r1 = r3.f16878a;
        r1 = r1.mo4754r();
        r1 = r1.I_();
        r2 = "Failed to delete corrupted db file";
        r1.m21308a(r2, r0);
    L_0x004d:
        r0 = super.getWritableDatabase();	 Catch:{ SQLiteException -> 0x005b }
        r1 = r3.f16878a;	 Catch:{ SQLiteException -> 0x005b }
        r1 = r1.f32787i;	 Catch:{ SQLiteException -> 0x005b }
        r1.m21369b();	 Catch:{ SQLiteException -> 0x005b }
        return r0;
    L_0x005b:
        r0 = move-exception;
        r1 = r3.f16878a;
        r1 = r1.mo4754r();
        r1 = r1.I_();
        r2 = "Failed to open freshly created database";
        r1.m21308a(r2, r0);
        throw r0;
    L_0x006c:
        r0 = new android.database.sqlite.SQLiteException;
        r1 = "Database open failed";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ag.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ah.m21236a(this.f16878a.mo4754r(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", ad.f32780b);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", ad.f32781c);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", ad.f32782d);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", ad.f32784f);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", ad.f32783e);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", ad.f32785g);
        ah.m21237a(this.f16878a.mo4754r(), sQLiteDatabase2, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
