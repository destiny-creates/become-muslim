package com.google.android.gms.internal.p213l;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.AdError;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.internal.C2872v;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.l.ad */
final class ad extends fl {
    /* renamed from: b */
    private static final String[] f32780b = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    /* renamed from: c */
    private static final String[] f32781c = new String[]{"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* renamed from: d */
    private static final String[] f32782d = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;"};
    /* renamed from: e */
    private static final String[] f32783e = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* renamed from: f */
    private static final String[] f32784f = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* renamed from: g */
    private static final String[] f32785g = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    /* renamed from: h */
    private final ag f32786h = new ag(this, mo4752n(), "google_app_measurement.db");
    /* renamed from: i */
    private final fh f32787i = new fh(mo4751m());

    ad(fm fmVar) {
        super(fmVar);
    }

    /* renamed from: K */
    private final boolean m43902K() {
        return mo4752n().getDatabasePath("google_app_measurement.db").exists();
    }

    /* renamed from: a */
    private final long m43903a(String str, String[] strArr, long j) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = m43947i().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    mo4754r().I_().m21309a("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            mo4754r().I_().m21309a("Database error", str, e);
            throw e;
        }
    }

    /* renamed from: a */
    private final Object m43905a(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                mo4754r().I_().m21307a("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                mo4754r().I_().m21307a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                mo4754r().I_().m21308a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    /* renamed from: a */
    private static void m43906a(ContentValues contentValues, String str, Object obj) {
        C2872v.a(str);
        C2872v.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* renamed from: a */
    private final boolean m43907a(String str, int i, ga gaVar) {
        m42632I();
        mo6210d();
        C2872v.a(str);
        C2872v.a(gaVar);
        if (TextUtils.isEmpty(gaVar.f28995d)) {
            mo4754r().m42565i().m21310a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", bb.m42550a(str), Integer.valueOf(i), String.valueOf(gaVar.f28994c));
            return false;
        }
        try {
            byte[] bArr = new byte[gaVar.m21444d()];
            C5035b a = C5035b.m21284a(bArr, 0, bArr.length);
            gaVar.mo4757a(a);
            a.m21294a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", gaVar.f28994c);
            contentValues.put("event_name", gaVar.f28995d);
            contentValues.put("data", bArr);
            try {
                if (m43947i().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    mo4754r().I_().m21308a("Failed to insert event filter (got -1). appId", bb.m42550a(str));
                }
                return true;
            } catch (SQLiteException e) {
                mo4754r().I_().m21309a("Error storing event filter. appId", bb.m42550a(str), e);
                return false;
            }
        } catch (IOException e2) {
            mo4754r().I_().m21309a("Configuration loss. Failed to serialize event filter. appId", bb.m42550a(str), e2);
            return false;
        }
    }

    /* renamed from: a */
    private final boolean m43908a(String str, int i, gd gdVar) {
        m42632I();
        mo6210d();
        C2872v.a(str);
        C2872v.a(gdVar);
        if (TextUtils.isEmpty(gdVar.f29013d)) {
            mo4754r().m42565i().m21310a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", bb.m42550a(str), Integer.valueOf(i), String.valueOf(gdVar.f29012c));
            return false;
        }
        try {
            byte[] bArr = new byte[gdVar.m21444d()];
            C5035b a = C5035b.m21284a(bArr, 0, bArr.length);
            gdVar.mo4757a(a);
            a.m21294a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", gdVar.f29012c);
            contentValues.put("property_name", gdVar.f29013d);
            contentValues.put("data", bArr);
            try {
                if (m43947i().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                mo4754r().I_().m21308a("Failed to insert property filter (got -1). appId", bb.m42550a(str));
                return false;
            } catch (SQLiteException e) {
                mo4754r().I_().m21309a("Error storing property filter. appId", bb.m42550a(str), e);
                return false;
            }
        } catch (IOException e2) {
            mo4754r().I_().m21309a("Configuration loss. Failed to serialize property filter. appId", bb.m42550a(str), e2);
            return false;
        }
    }

    /* renamed from: a */
    private final boolean m43909a(String str, List<Integer> list) {
        C2872v.a(str);
        m42632I();
        mo6210d();
        SQLiteDatabase i = m43947i();
        try {
            if (m43910b("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(AdError.SERVER_ERROR_CODE, mo6215t().m38039b(str, as.f16920N))))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < list.size()) {
                Integer num = (Integer) list.get(i2);
                if (num != null) {
                    if (num instanceof Integer) {
                        arrayList.add(Integer.toString(num.intValue()));
                        i2++;
                    }
                }
                return false;
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(join).length() + 2);
            stringBuilder.append("(");
            stringBuilder.append(join);
            stringBuilder.append(")");
            join = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(join).length() + 140);
            stringBuilder2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            stringBuilder2.append(join);
            stringBuilder2.append(" order by rowid desc limit -1 offset ?)");
            return i.delete("audience_filter_values", stringBuilder2.toString(), new String[]{str, Integer.toString(r2)}) > 0;
        } catch (SQLiteException e) {
            mo4754r().I_().m21309a("Database error querying filters. appId", bb.m42550a(str), e);
            return false;
        }
    }

    /* renamed from: b */
    private final long m43910b(String str, String[] strArr) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = m43947i().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    mo4754r().I_().m21309a("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    rawQuery = cursor;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            mo4754r().I_().m21309a("Database error", str, e);
            throw e;
        }
    }

    /* renamed from: A */
    public final long m43911A() {
        Object obj;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = m43947i().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return -1;
            } catch (SQLiteException e) {
                Cursor cursor2 = rawQuery;
                obj = e;
                cursor = cursor2;
                try {
                    mo4754r().I_().m21308a("Error querying raw events", obj);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            mo4754r().I_().m21308a("Error querying raw events", obj);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        }
    }

    /* renamed from: a */
    public final long m43912a(gn gnVar) {
        mo6210d();
        m42632I();
        C2872v.a(gnVar);
        C2872v.a(gnVar.f29083q);
        try {
            long j;
            Object obj = new byte[gnVar.m21444d()];
            C5035b a = C5035b.m21284a(obj, 0, obj.length);
            gnVar.mo4757a(a);
            a.m21294a();
            db G_ = G_();
            C2872v.a(obj);
            G_.mo6213p().mo6210d();
            MessageDigest i = fw.m42654i();
            if (i == null) {
                G_.mo4754r().I_().m21307a("Failed to get MD5");
                j = 0;
            } else {
                j = fw.m42635a(i.digest(obj));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", gnVar.f29083q);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", obj);
            try {
                m43947i().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                mo4754r().I_().m21309a("Error storing raw event metadata. appId", bb.m42550a(gnVar.f29083q), e);
                throw e;
            }
        } catch (IOException e2) {
            mo4754r().I_().m21309a("Data loss. Failed to serialize event metadata. appId", bb.m42550a(gnVar.f29083q), e2);
            throw e2;
        }
    }

    /* renamed from: a */
    public final Pair<gk, Long> m43913a(String str, Long l) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        mo6210d();
        m42632I();
        try {
            rawQuery = m43947i().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                if (rawQuery.moveToFirst()) {
                    byte[] blob = rawQuery.getBlob(0);
                    Long valueOf = Long.valueOf(rawQuery.getLong(1));
                    C5033a a = C5033a.m21210a(blob, 0, blob.length);
                    C5043j gkVar = new gk();
                    try {
                        gkVar.mo6216a(a);
                        Pair<gk, Long> create = Pair.create(gkVar, valueOf);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return create;
                    } catch (IOException e2) {
                        mo4754r().I_().m21310a("Failed to merge main event. appId, eventId", bb.m42550a(str), l, e2);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    }
                }
                mo4754r().m42579w().m21307a("Main event not found");
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    mo4754r().I_().m21308a("Error selecting main event", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            rawQuery = null;
            mo4754r().I_().m21308a("Error selecting main event", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public final ae m43914a(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Object e;
        Throwable th;
        C2872v.a(str);
        mo6210d();
        m42632I();
        String[] strArr = new String[]{str};
        ae aeVar = new ae();
        Cursor cursor = null;
        try {
            SQLiteDatabase i = m43947i();
            SQLiteDatabase sQLiteDatabase = i;
            Cursor query = sQLiteDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        aeVar.f16874b = query.getLong(1);
                        aeVar.f16873a = query.getLong(2);
                        aeVar.f16875c = query.getLong(3);
                        aeVar.f16876d = query.getLong(4);
                        aeVar.f16877e = query.getLong(5);
                    }
                    if (z) {
                        aeVar.f16874b++;
                    }
                    if (z2) {
                        aeVar.f16873a++;
                    }
                    if (z3) {
                        aeVar.f16875c++;
                    }
                    if (z4) {
                        aeVar.f16876d++;
                    }
                    if (z5) {
                        aeVar.f16877e++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(aeVar.f16873a));
                    contentValues.put("daily_events_count", Long.valueOf(aeVar.f16874b));
                    contentValues.put("daily_conversions_count", Long.valueOf(aeVar.f16875c));
                    contentValues.put("daily_error_events_count", Long.valueOf(aeVar.f16876d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(aeVar.f16877e));
                    i.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return aeVar;
                }
                mo4754r().m42565i().m21308a("Not updating daily counts, app is not known. appId", bb.m42550a(str));
                if (query != null) {
                    query.close();
                }
                return aeVar;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo4754r().I_().m21309a("Error updating daily counts. appId", bb.m42550a(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return aeVar;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            mo4754r().I_().m21309a("Error updating daily counts. appId", bb.m42550a(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return aeVar;
        }
    }

    /* renamed from: a */
    public final am m43915a(String str, String str2) {
        Object e;
        Throwable th;
        String str3 = str2;
        C2872v.a(str);
        C2872v.a(str2);
        mo6210d();
        m42632I();
        Cursor cursor;
        try {
            r5 = new String[2];
            boolean z = false;
            r5[0] = str;
            r5[1] = str3;
            Cursor query = m43947i().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", r5, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Boolean bool;
                    long j = query.getLong(0);
                    long j2 = query.getLong(1);
                    long j3 = query.getLong(2);
                    long j4 = query.isNull(3) ? 0 : query.getLong(3);
                    Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                    Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                    if (query.isNull(6)) {
                        bool = null;
                    } else {
                        if (query.getLong(6) == 1) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    }
                    am amVar = amVar;
                    long j5 = j4;
                    cursor = query;
                    try {
                        amVar = new am(str, str2, j, j2, j3, j5, valueOf, valueOf2, bool);
                        if (cursor.moveToNext()) {
                            mo4754r().I_().m21308a("Got multiple records for event aggregates, expected one. appId", bb.m42550a(str));
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return amVar;
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            mo4754r().I_().m21310a("Error querying events. appId", bb.m42550a(str), mo6212o().m42528a(str3), e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
                mo4754r().I_().m21310a("Error querying events. appId", bb.m42550a(str), mo6212o().m42528a(str3), e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            mo4754r().I_().m21310a("Error querying events. appId", bb.m42550a(str), mo6212o().m42528a(str3), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public final String m43916a(long j) {
        Object e;
        Throwable th;
        mo6210d();
        m42632I();
        Cursor rawQuery;
        try {
            rawQuery = m43947i().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    String string = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return string;
                }
                mo4754r().m42579w().m21307a("No expired configs for apps with pending events");
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo4754r().I_().m21308a("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            mo4754r().I_().m21308a("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public final List<fv> m43917a(String str) {
        Cursor query;
        Object e;
        Throwable th;
        C2872v.a(str);
        mo6210d();
        m42632I();
        List<fv> arrayList = new ArrayList();
        try {
            query = m43947i().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = query.getLong(2);
                        Object a = m43905a(query, 3);
                        if (a == null) {
                            mo4754r().I_().m21308a("Read invalid user property value, ignoring it. appId", bb.m42550a(str));
                        } else {
                            arrayList.add(new fv(str, str2, string, j, a));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                mo4754r().I_().m21309a("Error querying user properties. appId", bb.m42550a(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public final List<Pair<gn, Long>> m43918a(String str, int i, int i2) {
        Cursor query;
        Object e;
        bd I_;
        String str2;
        Object a;
        Object e2;
        Throwable th;
        mo6210d();
        m42632I();
        C2872v.b(i > 0);
        C2872v.b(i2 > 0);
        C2872v.a(str);
        Cursor cursor = null;
        try {
            query = m43947i().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    List<Pair<gn, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    do {
                        long j = query.getLong(0);
                        try {
                            byte[] a2 = G_().m44294a(query.getBlob(1));
                            if (!arrayList.isEmpty() && a2.length + i3 > i2) {
                                break;
                            }
                            C5033a a3 = C5033a.m21210a(a2, 0, a2.length);
                            C5043j gnVar = new gn();
                            try {
                                gnVar.mo6216a(a3);
                                if (!query.isNull(2)) {
                                    gnVar.f29064J = Integer.valueOf(query.getInt(2));
                                }
                                i3 += a2.length;
                                arrayList.add(Pair.create(gnVar, Long.valueOf(j)));
                            } catch (IOException e3) {
                                e = e3;
                                I_ = mo4754r().I_();
                                str2 = "Failed to merge queued bundle. appId";
                                a = bb.m42550a(str);
                                I_.m21309a(str2, a, e);
                                if (query.moveToNext()) {
                                    break;
                                } else if (i3 > i2) {
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return arrayList;
                            }
                            if (query.moveToNext()) {
                                break;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            I_ = mo4754r().I_();
                            str2 = "Failed to unzip queued bundle. appId";
                            a = bb.m42550a(str);
                            I_.m21309a(str2, a, e);
                            if (query.moveToNext()) {
                                break;
                            } else if (i3 > i2) {
                            }
                            if (query != null) {
                                query.close();
                            }
                            return arrayList;
                        }
                    } while (i3 > i2);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                List<Pair<gn, Long>> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            } catch (SQLiteException e5) {
                e2 = e5;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e6) {
            e2 = e6;
            try {
                mo4754r().I_().m21309a("Error querying bundles. appId", bb.m42550a(str), e2);
                List<Pair<gn, Long>> emptyList2 = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList2;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final java.util.List<com.google.android.gms.internal.p213l.fv> m43919a(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
        r21 = this;
        com.google.android.gms.common.internal.C2872v.a(r22);
        r21.mo6210d();
        r21.m42632I();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0105, all -> 0x0101 }
        r3 = 3;
        r2.<init>(r3);	 Catch:{ SQLiteException -> 0x0105, all -> 0x0101 }
        r11 = r22;
        r2.add(r11);	 Catch:{ SQLiteException -> 0x00fd, all -> 0x0101 }
        r4 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x00fd, all -> 0x0101 }
        r5 = "app_id=?";
        r4.<init>(r5);	 Catch:{ SQLiteException -> 0x00fd, all -> 0x0101 }
        r5 = android.text.TextUtils.isEmpty(r23);	 Catch:{ SQLiteException -> 0x00fd, all -> 0x0101 }
        if (r5 != 0) goto L_0x0037;
    L_0x0027:
        r5 = r23;
        r2.add(r5);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r6 = " and origin=?";
        r4.append(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        goto L_0x0039;
    L_0x0032:
        r0 = move-exception;
        r12 = r21;
        goto L_0x010c;
    L_0x0037:
        r5 = r23;
    L_0x0039:
        r6 = android.text.TextUtils.isEmpty(r24);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        if (r6 != 0) goto L_0x0051;
    L_0x003f:
        r6 = java.lang.String.valueOf(r24);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r7 = "*";
        r6 = r6.concat(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r2.add(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r6 = " and name glob ?";
        r4.append(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
    L_0x0051:
        r6 = r2.size();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r2 = r2.toArray(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r16 = r2;
        r16 = (java.lang.String[]) r16;	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r12 = r21.m43947i();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r13 = "user_attributes";
        r2 = "name";
        r6 = "set_timestamp";
        r7 = "value";
        r8 = "origin";
        r14 = new java.lang.String[]{r2, r6, r7, r8};	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r15 = r4.toString();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = "1001";
        r2 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0101 }
        r4 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        if (r4 != 0) goto L_0x008d;
    L_0x0087:
        if (r2 == 0) goto L_0x008c;
    L_0x0089:
        r2.close();
    L_0x008c:
        return r0;
    L_0x008d:
        r4 = r0.size();	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r4 < r6) goto L_0x00a9;
    L_0x0095:
        r3 = r21.mo4754r();	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r3 = r3.I_();	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r4 = "Read more than the max allowed user properties, ignoring excess";
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r3.m21308a(r4, r6);	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r12 = r21;
        goto L_0x00eb;
    L_0x00a9:
        r4 = 0;
        r7 = r2.getString(r4);	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r4 = 1;
        r8 = r2.getLong(r4);	 Catch:{ SQLiteException -> 0x00f9, all -> 0x00f5 }
        r4 = 2;
        r12 = r21;
        r10 = r12.m43905a(r2, r4);	 Catch:{ SQLiteException -> 0x00f3 }
        r13 = r2.getString(r3);	 Catch:{ SQLiteException -> 0x00f3 }
        if (r10 != 0) goto L_0x00d7;
    L_0x00c0:
        r4 = r21.mo4754r();	 Catch:{ SQLiteException -> 0x00d4 }
        r4 = r4.I_();	 Catch:{ SQLiteException -> 0x00d4 }
        r5 = "(2)Read invalid user property value, ignoring it";
        r6 = com.google.android.gms.internal.p213l.bb.m42550a(r22);	 Catch:{ SQLiteException -> 0x00d4 }
        r14 = r24;
        r4.m21310a(r5, r6, r13, r14);	 Catch:{ SQLiteException -> 0x00d4 }
        goto L_0x00e5;
    L_0x00d4:
        r0 = move-exception;
        r5 = r13;
        goto L_0x010d;
    L_0x00d7:
        r14 = r24;
        r15 = new com.google.android.gms.internal.l.fv;	 Catch:{ SQLiteException -> 0x00d4 }
        r4 = r15;
        r5 = r22;
        r6 = r13;
        r4.<init>(r5, r6, r7, r8, r10);	 Catch:{ SQLiteException -> 0x00d4 }
        r0.add(r15);	 Catch:{ SQLiteException -> 0x00d4 }
    L_0x00e5:
        r4 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x00d4 }
        if (r4 != 0) goto L_0x00f1;
    L_0x00eb:
        if (r2 == 0) goto L_0x00f0;
    L_0x00ed:
        r2.close();
    L_0x00f0:
        return r0;
    L_0x00f1:
        r5 = r13;
        goto L_0x008d;
    L_0x00f3:
        r0 = move-exception;
        goto L_0x010d;
    L_0x00f5:
        r0 = move-exception;
        r12 = r21;
        goto L_0x0125;
    L_0x00f9:
        r0 = move-exception;
        r12 = r21;
        goto L_0x010d;
    L_0x00fd:
        r0 = move-exception;
        r12 = r21;
        goto L_0x010a;
    L_0x0101:
        r0 = move-exception;
        r12 = r21;
        goto L_0x0126;
    L_0x0105:
        r0 = move-exception;
        r12 = r21;
        r11 = r22;
    L_0x010a:
        r5 = r23;
    L_0x010c:
        r2 = r1;
    L_0x010d:
        r3 = r21.mo4754r();	 Catch:{ all -> 0x0124 }
        r3 = r3.I_();	 Catch:{ all -> 0x0124 }
        r4 = "(2)Error querying user properties";
        r6 = com.google.android.gms.internal.p213l.bb.m42550a(r22);	 Catch:{ all -> 0x0124 }
        r3.m21310a(r4, r6, r5, r0);	 Catch:{ all -> 0x0124 }
        if (r2 == 0) goto L_0x0123;
    L_0x0120:
        r2.close();
    L_0x0123:
        return r1;
    L_0x0124:
        r0 = move-exception;
    L_0x0125:
        r1 = r2;
    L_0x0126:
        if (r1 == 0) goto L_0x012b;
    L_0x0128:
        r1.close();
    L_0x012b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ad.a(java.lang.String, java.lang.String, java.lang.String):java.util.List<com.google.android.gms.internal.l.fv>");
    }

    /* renamed from: a */
    public final List<C7827y> m43920a(String str, String[] strArr) {
        Object e;
        Throwable th;
        mo6210d();
        m42632I();
        List<C7827y> arrayList = new ArrayList();
        Cursor cursor = null;
        Cursor query;
        try {
            query = m43947i().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", AppStateModule.APP_STATE_ACTIVE, "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    do {
                        if (arrayList.size() >= 1000) {
                            mo4754r().I_().m21308a("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                            break;
                        }
                        boolean z = false;
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object a = m43905a(query, 3);
                        if (query.getInt(4) != 0) {
                            z = true;
                        }
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        aq aqVar = (aq) G_().m44285a(query.getBlob(7), aq.CREATOR);
                        long j2 = query.getLong(8);
                        aq aqVar2 = (aq) G_().m44285a(query.getBlob(9), aq.CREATOR);
                        long j3 = query.getLong(10);
                        long j4 = query.getLong(11);
                        aq aqVar3 = (aq) G_().m44285a(query.getBlob(12), aq.CREATOR);
                        ft ftVar = new ft(string3, j3, a, string2);
                        boolean z2 = z;
                        C7827y c7827y = r3;
                        C7827y c7827y2 = new C7827y(string, string2, ftVar, j2, z2, string4, aqVar, j, aqVar2, j4, aqVar3);
                        arrayList.add(c7827y);
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            try {
                mo4754r().I_().m21308a("Error querying conditional user property value", e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final void m43921a(am amVar) {
        C2872v.a(amVar);
        mo6210d();
        m42632I();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", amVar.f16891a);
        contentValues.put("name", amVar.f16892b);
        contentValues.put("lifetime_count", Long.valueOf(amVar.f16893c));
        contentValues.put("current_bundle_count", Long.valueOf(amVar.f16894d));
        contentValues.put("last_fire_timestamp", Long.valueOf(amVar.f16895e));
        contentValues.put("last_bundled_timestamp", Long.valueOf(amVar.f16896f));
        contentValues.put("last_sampled_complex_event_id", amVar.f16897g);
        contentValues.put("last_sampling_rate", amVar.f16898h);
        Long valueOf = (amVar.f16899i == null || !amVar.f16899i.booleanValue()) ? null : Long.valueOf(1);
        contentValues.put("last_exempt_from_sampling", valueOf);
        try {
            if (m43947i().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo4754r().I_().m21308a("Failed to insert/update event aggregates (got -1). appId", bb.m42550a(amVar.f16891a));
            }
        } catch (SQLiteException e) {
            mo4754r().I_().m21309a("Error storing event aggregates. appId", bb.m42550a(amVar.f16891a), e);
        }
    }

    /* renamed from: a */
    public final void m43922a(C5050t c5050t) {
        C2872v.a(c5050t);
        mo6210d();
        m42632I();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c5050t.m21456b());
        contentValues.put("app_instance_id", c5050t.m21460c());
        contentValues.put("gmp_app_id", c5050t.m21464d());
        contentValues.put("resettable_device_id_hash", c5050t.m21467e());
        contentValues.put("last_bundle_index", Long.valueOf(c5050t.m21490o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(c5050t.m21473g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c5050t.m21476h()));
        contentValues.put("app_version", c5050t.m21478i());
        contentValues.put("app_store", c5050t.m21482k());
        contentValues.put("gmp_version", Long.valueOf(c5050t.m21484l()));
        contentValues.put("dev_cert_hash", Long.valueOf(c5050t.m21486m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(c5050t.m21489n()));
        contentValues.put("day", Long.valueOf(c5050t.m21495s()));
        contentValues.put("daily_public_events_count", Long.valueOf(c5050t.m21496t()));
        contentValues.put("daily_events_count", Long.valueOf(c5050t.m21497u()));
        contentValues.put("daily_conversions_count", Long.valueOf(c5050t.m21498v()));
        contentValues.put("config_fetched_time", Long.valueOf(c5050t.m21492p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(c5050t.m21493q()));
        contentValues.put("app_version_int", Long.valueOf(c5050t.m21480j()));
        contentValues.put("firebase_instance_id", c5050t.m21470f());
        contentValues.put("daily_error_events_count", Long.valueOf(c5050t.m21500x()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(c5050t.m21499w()));
        contentValues.put("health_monitor_sample", c5050t.m21501y());
        contentValues.put("android_id", Long.valueOf(c5050t.m21449A()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(c5050t.m21450B()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(c5050t.m21451C()));
        try {
            SQLiteDatabase i = m43947i();
            if (((long) i.update("apps", contentValues, "app_id = ?", new String[]{c5050t.m21456b()})) == 0 && i.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo4754r().I_().m21308a("Failed to insert/update app (got -1). appId", bb.m42550a(c5050t.m21456b()));
            }
        } catch (SQLiteException e) {
            mo4754r().I_().m21309a("Error storing app. appId", bb.m42550a(c5050t.m21456b()), e);
        }
    }

    /* renamed from: a */
    final void m43923a(String str, fz[] fzVarArr) {
        m42632I();
        mo6210d();
        C2872v.a(str);
        C2872v.a(fzVarArr);
        SQLiteDatabase i = m43947i();
        i.beginTransaction();
        try {
            m42632I();
            mo6210d();
            C2872v.a(str);
            SQLiteDatabase i2 = m43947i();
            String[] strArr = new String[1];
            int i3 = 0;
            strArr[0] = str;
            i2.delete("property_filters", "app_id=?", strArr);
            i2.delete("event_filters", "app_id=?", new String[]{str});
            for (fz fzVar : fzVarArr) {
                m42632I();
                mo6210d();
                C2872v.a(str);
                C2872v.a(fzVar);
                C2872v.a(fzVar.f28990e);
                C2872v.a(fzVar.f28989d);
                if (fzVar.f28988c == null) {
                    mo4754r().m42565i().m21308a("Audience with no ID. appId", bb.m42550a(str));
                } else {
                    bd i4;
                    String str2;
                    Object a;
                    Object obj;
                    Object obj2;
                    int intValue = fzVar.f28988c.intValue();
                    for (ga gaVar : fzVar.f28990e) {
                        if (gaVar.f28994c == null) {
                            i4 = mo4754r().m42565i();
                            str2 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                            a = bb.m42550a(str);
                            obj = fzVar.f28988c;
                            break;
                        }
                    }
                    for (gd gdVar : fzVar.f28989d) {
                        if (gdVar.f29012c == null) {
                            i4 = mo4754r().m42565i();
                            str2 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                            a = bb.m42550a(str);
                            obj = fzVar.f28988c;
                            i4.m21309a(str2, a, obj);
                            break;
                        }
                    }
                    for (ga gaVar2 : fzVar.f28990e) {
                        if (!m43907a(str, intValue, gaVar2)) {
                            obj2 = null;
                            break;
                        }
                    }
                    obj2 = 1;
                    if (obj2 != null) {
                        for (gd gdVar2 : fzVar.f28989d) {
                            if (!m43908a(str, intValue, gdVar2)) {
                                obj2 = null;
                                break;
                            }
                        }
                    }
                    if (obj2 == null) {
                        m42632I();
                        mo6210d();
                        C2872v.a(str);
                        SQLiteDatabase i5 = m43947i();
                        i5.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        i5.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            int length = fzVarArr.length;
            while (i3 < length) {
                arrayList.add(fzVarArr[i3].f28988c);
                i3++;
            }
            m43909a(str, arrayList);
            i.setTransactionSuccessful();
        } finally {
            i.endTransaction();
        }
    }

    /* renamed from: a */
    final void m43924a(List<Long> list) {
        mo6210d();
        m42632I();
        C2872v.a(list);
        C2872v.a(list.size());
        if (m43902K()) {
            String join = TextUtils.join(",", list);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(join).length() + 2);
            stringBuilder.append("(");
            stringBuilder.append(join);
            stringBuilder.append(")");
            join = stringBuilder.toString();
            stringBuilder = new StringBuilder(String.valueOf(join).length() + 80);
            stringBuilder.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            stringBuilder.append(join);
            stringBuilder.append(" AND retry_count =  2147483647 LIMIT 1");
            if (m43910b(stringBuilder.toString(), null) > 0) {
                mo4754r().m42565i().m21307a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase i = m43947i();
                StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(join).length() + 127);
                stringBuilder2.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                stringBuilder2.append(join);
                stringBuilder2.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                i.execSQL(stringBuilder2.toString());
            } catch (SQLiteException e) {
                mo4754r().I_().m21308a("Error incrementing retry count. error", e);
            }
        }
    }

    /* renamed from: a */
    public final boolean m43925a(al alVar, long j, boolean z) {
        Object e;
        bd I_;
        String str;
        mo6210d();
        m42632I();
        C2872v.a(alVar);
        C2872v.a(alVar.f16885a);
        C5043j gkVar = new gk();
        gkVar.f29045f = Long.valueOf(alVar.f16888d);
        gkVar.f29042c = new gl[alVar.f16889e.m38073a()];
        Iterator it = alVar.f16889e.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            gl glVar = new gl();
            int i2 = i + 1;
            gkVar.f29042c[i] = glVar;
            glVar.f29048c = str2;
            G_().m44289a(glVar, alVar.f16889e.m38074a(str2));
            i = i2;
        }
        try {
            byte[] bArr = new byte[gkVar.m21444d()];
            C5035b a = C5035b.m21284a(bArr, 0, bArr.length);
            gkVar.mo4757a(a);
            a.m21294a();
            mo4754r().m42579w().m21309a("Saving event, name, data size", mo6212o().m42528a(alVar.f16886b), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", alVar.f16885a);
            contentValues.put("name", alVar.f16886b);
            contentValues.put("timestamp", Long.valueOf(alVar.f16887c));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z));
            try {
                if (m43947i().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                mo4754r().I_().m21308a("Failed to insert raw event (got -1). appId", bb.m42550a(alVar.f16885a));
                return false;
            } catch (SQLiteException e2) {
                e = e2;
                I_ = mo4754r().I_();
                str = "Error storing raw event. appId";
                I_.m21309a(str, bb.m42550a(alVar.f16885a), e);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            I_ = mo4754r().I_();
            str = "Data loss. Failed to serialize event params/data. appId";
            I_.m21309a(str, bb.m42550a(alVar.f16885a), e);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m43926a(fv fvVar) {
        C2872v.a(fvVar);
        mo6210d();
        m42632I();
        if (m43934c(fvVar.f17237a, fvVar.f17239c) == null) {
            if (fw.m42643a(fvVar.f17239c)) {
                if (m43910b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{fvVar.f17237a}) >= 25) {
                    return false;
                }
            }
            if (m43910b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{fvVar.f17237a, fvVar.f17238b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", fvVar.f17237a);
        contentValues.put("origin", fvVar.f17238b);
        contentValues.put("name", fvVar.f17239c);
        contentValues.put("set_timestamp", Long.valueOf(fvVar.f17240d));
        ad.m43906a(contentValues, "value", fvVar.f17241e);
        try {
            if (m43947i().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                mo4754r().I_().m21308a("Failed to insert/update user property (got -1). appId", bb.m42550a(fvVar.f17237a));
            }
        } catch (SQLiteException e) {
            mo4754r().I_().m21309a("Error storing user property. appId", bb.m42550a(fvVar.f17237a), e);
        }
        return true;
    }

    /* renamed from: a */
    public final boolean m43927a(gn gnVar, boolean z) {
        Object e;
        bd I_;
        String str;
        mo6210d();
        m42632I();
        C2872v.a(gnVar);
        C2872v.a(gnVar.f29083q);
        C2872v.a(gnVar.f29074h);
        m43950v();
        long a = mo4751m().a();
        if (gnVar.f29074h.longValue() < a - aa.m38032j() || gnVar.f29074h.longValue() > aa.m38032j() + a) {
            mo4754r().m42565i().m21310a("Storing bundle outside of the max uploading time span. appId, now, timestamp", bb.m42550a(gnVar.f29083q), Long.valueOf(a), gnVar.f29074h);
        }
        try {
            byte[] bArr = new byte[gnVar.m21444d()];
            C5035b a2 = C5035b.m21284a(bArr, 0, bArr.length);
            gnVar.mo4757a(a2);
            a2.m21294a();
            bArr = G_().m44297b(bArr);
            mo4754r().m42579w().m21308a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", gnVar.f29083q);
            contentValues.put("bundle_end_timestamp", gnVar.f29074h);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z));
            if (gnVar.f29064J != null) {
                contentValues.put("retry_count", gnVar.f29064J);
            }
            try {
                if (m43947i().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                mo4754r().I_().m21308a("Failed to insert bundle (got -1). appId", bb.m42550a(gnVar.f29083q));
                return false;
            } catch (SQLiteException e2) {
                e = e2;
                I_ = mo4754r().I_();
                str = "Error storing bundle. appId";
                I_.m21309a(str, bb.m42550a(gnVar.f29083q), e);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            I_ = mo4754r().I_();
            str = "Data loss. Failed to serialize bundle. appId";
            I_.m21309a(str, bb.m42550a(gnVar.f29083q), e);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m43928a(C7827y c7827y) {
        C2872v.a(c7827y);
        mo6210d();
        m42632I();
        if (m43934c(c7827y.f29124a, c7827y.f29126c.f28979a) == null) {
            if (m43910b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{c7827y.f29124a}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c7827y.f29124a);
        contentValues.put("origin", c7827y.f29125b);
        contentValues.put("name", c7827y.f29126c.f28979a);
        ad.m43906a(contentValues, "value", c7827y.f29126c.m38105a());
        contentValues.put(AppStateModule.APP_STATE_ACTIVE, Boolean.valueOf(c7827y.f29128e));
        contentValues.put("trigger_event_name", c7827y.f29129f);
        contentValues.put("trigger_timeout", Long.valueOf(c7827y.f29131h));
        mo6213p();
        contentValues.put("timed_out_event", fw.m42645a(c7827y.f29130g));
        contentValues.put("creation_timestamp", Long.valueOf(c7827y.f29127d));
        mo6213p();
        contentValues.put("triggered_event", fw.m42645a(c7827y.f29132i));
        contentValues.put("triggered_timestamp", Long.valueOf(c7827y.f29126c.f28980b));
        contentValues.put("time_to_live", Long.valueOf(c7827y.f29133j));
        mo6213p();
        contentValues.put("expired_event", fw.m42645a(c7827y.f29134k));
        try {
            if (m43947i().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                mo4754r().I_().m21308a("Failed to insert/update conditional user property (got -1)", bb.m42550a(c7827y.f29124a));
            }
        } catch (SQLiteException e) {
            mo4754r().I_().m21309a("Error storing conditional user property", bb.m42550a(c7827y.f29124a), e);
        }
        return true;
    }

    /* renamed from: a */
    public final boolean m43929a(String str, Long l, long j, gk gkVar) {
        mo6210d();
        m42632I();
        C2872v.a(gkVar);
        C2872v.a(str);
        C2872v.a(l);
        try {
            byte[] bArr = new byte[gkVar.m21444d()];
            C5035b a = C5035b.m21284a(bArr, 0, bArr.length);
            gkVar.mo4757a(a);
            a.m21294a();
            mo4754r().m42579w().m21309a("Saving complex main event, appId, data size", mo6212o().m42528a(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (m43947i().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                mo4754r().I_().m21308a("Failed to insert complex main event (got -1). appId", bb.m42550a(str));
                return false;
            } catch (SQLiteException e) {
                mo4754r().I_().m21309a("Error storing complex main event. appId", bb.m42550a(str), e);
                return false;
            }
        } catch (IOException e2) {
            mo4754r().I_().m21310a("Data loss. Failed to serialize event params/data. appId, eventId", bb.m42550a(str), l, e2);
            return false;
        }
    }

    /* renamed from: b */
    public final C5050t m43930b(String str) {
        Cursor query;
        Object e;
        Throwable th;
        ad adVar;
        String str2 = str;
        C2872v.a(str);
        mo6210d();
        m42632I();
        try {
            boolean z = true;
            query = m43947i().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled"}, "app_id=?", new String[]{str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    try {
                        boolean z2;
                        C5050t c5050t = new C5050t(this.a.m32075o(), str2);
                        c5050t.m21454a(query.getString(0));
                        c5050t.m21458b(query.getString(1));
                        c5050t.m21462c(query.getString(2));
                        c5050t.m21471f(query.getLong(3));
                        c5050t.m21453a(query.getLong(4));
                        c5050t.m21457b(query.getLong(5));
                        c5050t.m21469e(query.getString(6));
                        c5050t.m21472f(query.getString(7));
                        c5050t.m21465d(query.getLong(8));
                        c5050t.m21468e(query.getLong(9));
                        if (!query.isNull(10)) {
                            if (query.getInt(10) == 0) {
                                z2 = false;
                                c5050t.m21455a(z2);
                                c5050t.m21479i(query.getLong(11));
                                c5050t.m21481j(query.getLong(12));
                                c5050t.m21483k(query.getLong(13));
                                c5050t.m21485l(query.getLong(14));
                                c5050t.m21474g(query.getLong(15));
                                c5050t.m21477h(query.getLong(16));
                                c5050t.m21461c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                                c5050t.m21466d(query.getString(18));
                                c5050t.m21488n(query.getLong(19));
                                c5050t.m21487m(query.getLong(20));
                                c5050t.m21475g(query.getString(21));
                                c5050t.m21491o(query.isNull(22) ? 0 : query.getLong(22));
                                if (!query.isNull(23)) {
                                    if (query.getInt(23) != 0) {
                                        z2 = false;
                                        c5050t.m21459b(z2);
                                        if (!query.isNull(24)) {
                                            if (query.getInt(24) == 0) {
                                                z = false;
                                            }
                                        }
                                        c5050t.m21463c(z);
                                        c5050t.m21452a();
                                        if (query.moveToNext()) {
                                            mo4754r().I_().m21308a("Got multiple records for app, expected one. appId", bb.m42550a(str));
                                        }
                                        if (query != null) {
                                            query.close();
                                        }
                                        return c5050t;
                                    }
                                }
                                z2 = true;
                                c5050t.m21459b(z2);
                                if (query.isNull(24)) {
                                    if (query.getInt(24) == 0) {
                                        z = false;
                                    }
                                }
                                c5050t.m21463c(z);
                                c5050t.m21452a();
                                if (query.moveToNext()) {
                                    mo4754r().I_().m21308a("Got multiple records for app, expected one. appId", bb.m42550a(str));
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return c5050t;
                            }
                        }
                        z2 = true;
                        c5050t.m21455a(z2);
                        c5050t.m21479i(query.getLong(11));
                        c5050t.m21481j(query.getLong(12));
                        c5050t.m21483k(query.getLong(13));
                        c5050t.m21485l(query.getLong(14));
                        c5050t.m21474g(query.getLong(15));
                        c5050t.m21477h(query.getLong(16));
                        if (query.isNull(17)) {
                        }
                        c5050t.m21461c(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                        c5050t.m21466d(query.getString(18));
                        c5050t.m21488n(query.getLong(19));
                        c5050t.m21487m(query.getLong(20));
                        c5050t.m21475g(query.getString(21));
                        if (query.isNull(22)) {
                        }
                        c5050t.m21491o(query.isNull(22) ? 0 : query.getLong(22));
                        if (query.isNull(23)) {
                            if (query.getInt(23) != 0) {
                                z2 = false;
                                c5050t.m21459b(z2);
                                if (query.isNull(24)) {
                                    if (query.getInt(24) == 0) {
                                        z = false;
                                    }
                                }
                                c5050t.m21463c(z);
                                c5050t.m21452a();
                                if (query.moveToNext()) {
                                    mo4754r().I_().m21308a("Got multiple records for app, expected one. appId", bb.m42550a(str));
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return c5050t;
                            }
                        }
                        z2 = true;
                        c5050t.m21459b(z2);
                        if (query.isNull(24)) {
                            if (query.getInt(24) == 0) {
                                z = false;
                            }
                        }
                        c5050t.m21463c(z);
                        c5050t.m21452a();
                        if (query.moveToNext()) {
                            mo4754r().I_().m21308a("Got multiple records for app, expected one. appId", bb.m42550a(str));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return c5050t;
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            mo4754r().I_().m21309a("Error querying app. appId", bb.m42550a(str), e);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                adVar = this;
                mo4754r().I_().m21309a("Error querying app. appId", bb.m42550a(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                adVar = this;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            adVar = this;
            query = null;
            mo4754r().I_().m21309a("Error querying app. appId", bb.m42550a(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            adVar = this;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    public final List<C7827y> m43931b(String str, String str2, String str3) {
        C2872v.a(str);
        mo6210d();
        m42632I();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        return m43920a(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* renamed from: b */
    public final void m43932b(String str, String str2) {
        C2872v.a(str);
        C2872v.a(str2);
        mo6210d();
        m42632I();
        try {
            mo4754r().m42579w().m21308a("Deleted user attribute rows", Integer.valueOf(m43947i().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            mo4754r().I_().m21310a("Error deleting user attribute. appId", bb.m42550a(str), mo6212o().m42532c(str2), e);
        }
    }

    /* renamed from: c */
    public final long m43933c(String str) {
        C2872v.a(str);
        mo6210d();
        m42632I();
        try {
            SQLiteDatabase i = m43947i();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, mo6215t().m38039b(str, as.f16956x))));
            return (long) i.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            mo4754r().I_().m21309a("Error deleting over the limit events. appId", bb.m42550a(str), e);
            return 0;
        }
    }

    /* renamed from: c */
    public final fv m43934c(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        ad adVar;
        String str3 = str2;
        C2872v.a(str);
        C2872v.a(str2);
        mo6210d();
        m42632I();
        try {
            query = m43947i().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    long j = query.getLong(0);
                    try {
                        String str4 = str;
                        fv fvVar = new fv(str4, query.getString(2), str2, j, m43905a(query, 1));
                        if (query.moveToNext()) {
                            mo4754r().I_().m21308a("Got multiple records for user property, expected one. appId", bb.m42550a(str));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return fvVar;
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            mo4754r().I_().m21310a("Error querying user property. appId", bb.m42550a(str), mo6212o().m42532c(str3), e);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                adVar = this;
                mo4754r().I_().m21310a("Error querying user property. appId", bb.m42550a(str), mo6212o().m42532c(str3), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                adVar = this;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            adVar = this;
            query = null;
            mo4754r().I_().m21310a("Error querying user property. appId", bb.m42550a(str), mo6212o().m42532c(str3), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            adVar = this;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: d */
    public final C7827y m43935d(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        ad adVar;
        String str3 = str2;
        C2872v.a(str);
        C2872v.a(str2);
        mo6210d();
        m42632I();
        try {
            query = m43947i().query("conditional_properties", new String[]{"origin", "value", AppStateModule.APP_STATE_ACTIVE, "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    try {
                        Object a = m43905a(query, 1);
                        boolean z = query.getInt(2) != 0;
                        String string2 = query.getString(3);
                        long j = query.getLong(4);
                        aq aqVar = (aq) G_().m44285a(query.getBlob(5), aq.CREATOR);
                        String str4 = str;
                        C7827y c7827y = new C7827y(str4, string, new ft(str2, query.getLong(8), a, string), query.getLong(6), z, string2, aqVar, j, (aq) G_().m44285a(query.getBlob(7), aq.CREATOR), query.getLong(9), (aq) G_().m44285a(query.getBlob(10), aq.CREATOR));
                        if (query.moveToNext()) {
                            mo4754r().I_().m21309a("Got multiple records for conditional property, expected one", bb.m42550a(str), mo6212o().m42532c(str3));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return c7827y;
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            mo4754r().I_().m21310a("Error querying conditional property", bb.m42550a(str), mo6212o().m42532c(str3), e);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                adVar = this;
                mo4754r().I_().m21310a("Error querying conditional property", bb.m42550a(str), mo6212o().m42532c(str3), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                adVar = this;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            adVar = this;
            query = null;
            mo4754r().I_().m21310a("Error querying conditional property", bb.m42550a(str), mo6212o().m42532c(str3), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            adVar = this;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: d */
    public final byte[] m43936d(String str) {
        Cursor query;
        Object e;
        Throwable th;
        C2872v.a(str);
        mo6210d();
        m42632I();
        try {
            query = m43947i().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        mo4754r().I_().m21308a("Got multiple records for app config, expected one. appId", bb.m42550a(str));
                    }
                    if (query != null) {
                        query.close();
                    }
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo4754r().I_().m21309a("Error querying remote config. appId", bb.m42550a(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            mo4754r().I_().m21309a("Error querying remote config. appId", bb.m42550a(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: e */
    public final int m43937e(String str, String str2) {
        C2872v.a(str);
        C2872v.a(str2);
        mo6210d();
        m42632I();
        try {
            return m43947i().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo4754r().I_().m21310a("Error deleting conditional property", bb.m42550a(str), mo6212o().m42532c(str2), e);
            return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.p213l.go> m43938e(java.lang.String r12) {
        /*
        r11 = this;
        r11.m42632I();
        r11.mo6210d();
        com.google.android.gms.common.internal.C2872v.a(r12);
        r0 = r11.m43947i();
        r8 = 0;
        r1 = "audience_filter_values";
        r2 = "audience_id";
        r3 = "current_results";
        r2 = new java.lang.String[]{r2, r3};	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r3 = "app_id=?";
        r9 = 1;
        r4 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r10 = 0;
        r4[r10] = r12;	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r1 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x0077 }
        if (r1 != 0) goto L_0x0033;
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();
    L_0x0032:
        return r8;
    L_0x0033:
        r1 = new android.support.v4.util.a;	 Catch:{ SQLiteException -> 0x0077 }
        r1.<init>();	 Catch:{ SQLiteException -> 0x0077 }
    L_0x0038:
        r2 = r0.getInt(r10);	 Catch:{ SQLiteException -> 0x0077 }
        r3 = r0.getBlob(r9);	 Catch:{ SQLiteException -> 0x0077 }
        r4 = r3.length;	 Catch:{ SQLiteException -> 0x0077 }
        r3 = com.google.android.gms.internal.p213l.C5033a.m21210a(r3, r10, r4);	 Catch:{ SQLiteException -> 0x0077 }
        r4 = new com.google.android.gms.internal.l.go;	 Catch:{ SQLiteException -> 0x0077 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0077 }
        r4.mo6216a(r3);	 Catch:{ IOException -> 0x0055 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0077 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0077 }
        goto L_0x006b;
    L_0x0055:
        r3 = move-exception;
        r4 = r11.mo4754r();	 Catch:{ SQLiteException -> 0x0077 }
        r4 = r4.I_();	 Catch:{ SQLiteException -> 0x0077 }
        r5 = "Failed to merge filter results. appId, audienceId, error";
        r6 = com.google.android.gms.internal.p213l.bb.m42550a(r12);	 Catch:{ SQLiteException -> 0x0077 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0077 }
        r4.m21310a(r5, r6, r2, r3);	 Catch:{ SQLiteException -> 0x0077 }
    L_0x006b:
        r2 = r0.moveToNext();	 Catch:{ SQLiteException -> 0x0077 }
        if (r2 != 0) goto L_0x0038;
    L_0x0071:
        if (r0 == 0) goto L_0x0076;
    L_0x0073:
        r0.close();
    L_0x0076:
        return r1;
    L_0x0077:
        r1 = move-exception;
        goto L_0x007e;
    L_0x0079:
        r12 = move-exception;
        r0 = r8;
        goto L_0x0096;
    L_0x007c:
        r1 = move-exception;
        r0 = r8;
    L_0x007e:
        r2 = r11.mo4754r();	 Catch:{ all -> 0x0095 }
        r2 = r2.I_();	 Catch:{ all -> 0x0095 }
        r3 = "Database error querying filter results. appId";
        r12 = com.google.android.gms.internal.p213l.bb.m42550a(r12);	 Catch:{ all -> 0x0095 }
        r2.m21309a(r3, r12, r1);	 Catch:{ all -> 0x0095 }
        if (r0 == 0) goto L_0x0094;
    L_0x0091:
        r0.close();
    L_0x0094:
        return r8;
    L_0x0095:
        r12 = move-exception;
    L_0x0096:
        if (r0 == 0) goto L_0x009b;
    L_0x0098:
        r0.close();
    L_0x009b:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ad.e(java.lang.String):java.util.Map<java.lang.Integer, com.google.android.gms.internal.l.go>");
    }

    /* renamed from: e */
    protected final boolean mo6850e() {
        return false;
    }

    /* renamed from: f */
    public final long m43940f(String str) {
        C2872v.a(str);
        return m43903a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.p213l.ga>> m43941f(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.m42632I();
        r12.mo6210d();
        com.google.android.gms.common.internal.C2872v.a(r13);
        com.google.android.gms.common.internal.C2872v.a(r14);
        r0 = new android.support.v4.util.a;
        r0.<init>();
        r1 = r12.m43947i();
        r9 = 0;
        r2 = "event_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r4 = "app_id=? AND event_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x0091 }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x0091 }
        r1 = com.google.android.gms.internal.p213l.C5033a.m21210a(r1, r10, r2);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = new com.google.android.gms.internal.l.ga;	 Catch:{ SQLiteException -> 0x0091 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r2.mo6216a(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x0091 }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0091 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x0091 }
        goto L_0x0085;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.mo4754r();	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r2.I_();	 Catch:{ SQLiteException -> 0x0091 }
        r3 = "Failed to merge filter. appId";
        r4 = com.google.android.gms.internal.p213l.bb.m42550a(r13);	 Catch:{ SQLiteException -> 0x0091 }
        r2.m21309a(r3, r4, r1);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x0085:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x008b:
        if (r14 == 0) goto L_0x0090;
    L_0x008d:
        r14.close();
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0098;
    L_0x0093:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00b0;
    L_0x0096:
        r0 = move-exception;
        r14 = r9;
    L_0x0098:
        r1 = r12.mo4754r();	 Catch:{ all -> 0x00af }
        r1 = r1.I_();	 Catch:{ all -> 0x00af }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.p213l.bb.m42550a(r13);	 Catch:{ all -> 0x00af }
        r1.m21309a(r2, r13, r0);	 Catch:{ all -> 0x00af }
        if (r14 == 0) goto L_0x00ae;
    L_0x00ab:
        r14.close();
    L_0x00ae:
        return r9;
    L_0x00af:
        r13 = move-exception;
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();
    L_0x00b5:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ad.f(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.l.ga>>");
    }

    /* renamed from: f */
    public final void m43942f() {
        m42632I();
        m43947i().beginTransaction();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.p213l.gd>> m43943g(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.m42632I();
        r12.mo6210d();
        com.google.android.gms.common.internal.C2872v.a(r13);
        com.google.android.gms.common.internal.C2872v.a(r14);
        r0 = new android.support.v4.util.a;
        r0.<init>();
        r1 = r12.m43947i();
        r9 = 0;
        r2 = "property_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r4 = "app_id=? AND property_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x0091 }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x0091 }
        r1 = com.google.android.gms.internal.p213l.C5033a.m21210a(r1, r10, r2);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = new com.google.android.gms.internal.l.gd;	 Catch:{ SQLiteException -> 0x0091 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r2.mo6216a(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x0091 }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0091 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x0091 }
        goto L_0x0085;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.mo4754r();	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r2.I_();	 Catch:{ SQLiteException -> 0x0091 }
        r3 = "Failed to merge filter";
        r4 = com.google.android.gms.internal.p213l.bb.m42550a(r13);	 Catch:{ SQLiteException -> 0x0091 }
        r2.m21309a(r3, r4, r1);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x0085:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x008b:
        if (r14 == 0) goto L_0x0090;
    L_0x008d:
        r14.close();
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0098;
    L_0x0093:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00b0;
    L_0x0096:
        r0 = move-exception;
        r14 = r9;
    L_0x0098:
        r1 = r12.mo4754r();	 Catch:{ all -> 0x00af }
        r1 = r1.I_();	 Catch:{ all -> 0x00af }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.p213l.bb.m42550a(r13);	 Catch:{ all -> 0x00af }
        r1.m21309a(r2, r13, r0);	 Catch:{ all -> 0x00af }
        if (r14 == 0) goto L_0x00ae;
    L_0x00ab:
        r14.close();
    L_0x00ae:
        return r9;
    L_0x00af:
        r13 = move-exception;
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();
    L_0x00b5:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ad.g(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.l.gd>>");
    }

    /* renamed from: g */
    public final void m43944g() {
        m42632I();
        m43947i().setTransactionSuccessful();
    }

    /* renamed from: h */
    protected final long m43945h(String str, String str2) {
        Object e;
        C2872v.a(str);
        C2872v.a(str2);
        mo6210d();
        m42632I();
        SQLiteDatabase i = m43947i();
        i.beginTransaction();
        long a;
        try {
            ContentValues contentValues;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 32);
            stringBuilder.append("select ");
            stringBuilder.append(str2);
            stringBuilder.append(" from app2 where app_id=?");
            a = m43903a(stringBuilder.toString(), new String[]{str}, -1);
            if (a == -1) {
                contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Integer.valueOf(0));
                contentValues.put("previous_install_count", Integer.valueOf(0));
                if (i.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    mo4754r().I_().m21309a("Failed to insert column (got -1). appId", bb.m42550a(str), str2);
                    i.endTransaction();
                    return -1;
                }
                a = 0;
            }
            try {
                contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put(str2, Long.valueOf(1 + a));
                if (((long) i.update("app2", contentValues, "app_id = ?", new String[]{str})) == 0) {
                    mo4754r().I_().m21309a("Failed to update column (got 0). appId", bb.m42550a(str), str2);
                    i.endTransaction();
                    return -1;
                }
                i.setTransactionSuccessful();
                i.endTransaction();
                return a;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo4754r().I_().m21310a("Error inserting column. appId", bb.m42550a(str), str2, e);
                    i.endTransaction();
                    return a;
                } catch (Throwable th) {
                    i.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            a = 0;
            mo4754r().I_().m21310a("Error inserting column. appId", bb.m42550a(str), str2, e);
            i.endTransaction();
            return a;
        }
    }

    /* renamed from: h */
    public final void m43946h() {
        m42632I();
        m43947i().endTransaction();
    }

    /* renamed from: i */
    final SQLiteDatabase m43947i() {
        mo6210d();
        try {
            return this.f32786h.getWritableDatabase();
        } catch (SQLiteException e) {
            mo4754r().m42565i().m21308a("Error opening database", e);
            throw e;
        }
    }

    /* renamed from: j */
    public final String m43948j() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        try {
            rawQuery = m43947i().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    String string = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return string;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo4754r().I_().m21308a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            mo4754r().I_().m21308a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: k */
    public final boolean m43949k() {
        return m43910b("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    /* renamed from: v */
    final void m43950v() {
        mo6210d();
        m42632I();
        if (m43902K()) {
            long a = mo6214s().f32329f.m21318a();
            long b = mo4751m().b();
            if (Math.abs(b - a) > ((Long) as.f16913G.m21260b()).longValue()) {
                mo6214s().f32329f.m21319a(b);
                mo6210d();
                m42632I();
                if (m43902K()) {
                    int delete = m43947i().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo4751m().a()), String.valueOf(aa.m38032j())});
                    if (delete > 0) {
                        mo4754r().m42579w().m21308a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* renamed from: w */
    public final long m43951w() {
        return m43903a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    /* renamed from: x */
    public final long m43952x() {
        return m43903a("select max(timestamp) from raw_events", null, 0);
    }

    /* renamed from: y */
    public final boolean m43953y() {
        return m43910b("select count(1) > 0 from raw_events", null) != 0;
    }

    /* renamed from: z */
    public final boolean m43954z() {
        return m43910b("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }
}
