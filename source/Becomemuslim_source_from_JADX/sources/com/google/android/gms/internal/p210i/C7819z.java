package com.google.android.gms.internal.p210i;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.analytics.C2721s;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2901l;
import java.io.Closeable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.z */
final class C7819z extends C6797o implements Closeable {
    /* renamed from: a */
    private static final String f28920a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    /* renamed from: b */
    private static final String f28921b = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    /* renamed from: c */
    private final aa f28922c;
    /* renamed from: d */
    private final by f28923d = new by(m21043j());
    /* renamed from: e */
    private final by f28924e = new by(m21043j());

    C7819z(C5008q c5008q) {
        super(c5008q);
        this.f28922c = new aa(this, c5008q.m21059a(), "google_analytics_v4.db");
    }

    /* renamed from: D */
    private static String m37990D() {
        return "google_analytics_v4.db";
    }

    /* renamed from: a */
    protected final void mo6145a() {
    }

    /* renamed from: b */
    public final void m38003b() {
        m31800z();
        m38011h().beginTransaction();
    }

    /* renamed from: c */
    public final void m38006c() {
        m31800z();
        m38011h().setTransactionSuccessful();
    }

    /* renamed from: d */
    public final void m38007d() {
        m31800z();
        m38011h().endTransaction();
    }

    /* renamed from: a */
    public final void m38001a(bg bgVar) {
        C2872v.a(bgVar);
        C2721s.d();
        m31800z();
        C2872v.a(bgVar);
        Builder builder = new Builder();
        for (Entry entry : bgVar.m20321b().entrySet()) {
            String str = (String) entry.getKey();
            if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str))) {
                builder.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            m21045l().m37754a(bgVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = ((Integer) ba.f16384c.m20315a()).intValue();
        long C = m37989C();
        if (C > ((long) (intValue - 1))) {
            List d = m37997d((C - ((long) intValue)) + 1);
            m21034d("Store full, deleting hits to make room, count", Integer.valueOf(d.size()));
            m38002a(d);
        }
        SQLiteDatabase h = m38011h();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(bgVar.m20323d()));
        contentValues.put("hit_app_id", Integer.valueOf(bgVar.m20320a()));
        encodedQuery = "hit_url";
        if (bgVar.m20325f()) {
            str = as.m20293h();
        } else {
            str = as.m20294i();
        }
        contentValues.put(encodedQuery, str);
        try {
            long insert = h.insert("hits2", null, contentValues);
            if (insert == -1) {
                m21042i("Failed to insert a hit (got -1)");
            } else {
                m21030b("Hit saved to database. db-id, hit", Long.valueOf(insert), bgVar);
            }
        } catch (bg bgVar2) {
            m21037e("Error storing a hit", bgVar2);
        }
    }

    /* renamed from: C */
    private final long m37989C() {
        C2721s.d();
        m31800z();
        return m37991a("SELECT COUNT(*) FROM hits2", null);
    }

    /* renamed from: e */
    final boolean m38008e() {
        return m37989C() == 0;
    }

    /* renamed from: d */
    private final List<Long> m37997d(long j) {
        Object e;
        Throwable th;
        C2721s.d();
        m31800z();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase h = m38011h();
        List<Long> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            j = h.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Long.toString(j));
            try {
                if (j.moveToFirst()) {
                    do {
                        arrayList.add(Long.valueOf(j.getLong(0)));
                    } while (j.moveToNext());
                }
                if (j != null) {
                    j.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = j;
                try {
                    m21034d("Error selecting hit ids", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = j;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            m21034d("Error selecting hit ids", e);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: a */
    public final List<bg> m37999a(long j) {
        Object e;
        Throwable th;
        C2872v.b(j >= 0);
        C2721s.d();
        m31800z();
        Cursor cursor = null;
        try {
            j = m38011h().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Long.toString(j));
            try {
                List<bg> arrayList = new ArrayList();
                if (j.moveToFirst()) {
                    do {
                        long j2 = j.getLong(0);
                        arrayList.add(new bg(this, m37994a(j.getString(2)), j.getLong(1), bz.m20384e(j.getString(3)), j2, j.getInt(4)));
                    } while (j.moveToNext());
                }
                if (j != null) {
                    j.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = j;
                try {
                    m21037e("Error loading hits from the database", e);
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
                cursor = j;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            m21037e("Error loading hits from the database", e);
            throw e;
        }
    }

    /* renamed from: a */
    public final void m38002a(List<Long> list) {
        C2872v.a(list);
        C2721s.d();
        m31800z();
        if (!list.isEmpty()) {
            int i;
            StringBuilder stringBuilder = new StringBuilder("hit_id");
            stringBuilder.append(" in (");
            for (i = 0; i < list.size(); i++) {
                Long l = (Long) list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(l);
            }
            stringBuilder.append(")");
            String stringBuilder2 = stringBuilder.toString();
            try {
                SQLiteDatabase h = m38011h();
                m21026a("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                i = h.delete("hits2", stringBuilder2, null);
                if (i != list.size()) {
                    m21031b("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(i), stringBuilder2);
                }
            } catch (List<Long> list2) {
                m21037e("Error deleting hits", list2);
                throw list2;
            }
        }
    }

    /* renamed from: b */
    public final void m38004b(long j) {
        C2721s.d();
        m31800z();
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        m21026a("Deleting hit, id", Long.valueOf(j));
        m38002a(arrayList);
    }

    /* renamed from: f */
    public final int m38009f() {
        C2721s.d();
        m31800z();
        if (!this.f28923d.m20366a(86400000)) {
            return 0;
        }
        this.f28923d.m20365a();
        m21036e("Deleting stale hits (if any)");
        int delete = m38011h().delete("hits2", "hit_time < ?", new String[]{Long.toString(m21043j().a() - 2592000000L)});
        m21026a("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    /* renamed from: g */
    public final long m38010g() {
        C2721s.d();
        m31800z();
        return m37992a(f28921b, null, 0);
    }

    /* renamed from: a */
    public final long m37998a(long j, String str, String str2) {
        C2872v.a(str);
        C2872v.a(str2);
        m31800z();
        C2721s.d();
        return m37992a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    /* renamed from: c */
    public final List<C5011t> m38005c(long j) {
        m31800z();
        C2721s.d();
        SQLiteDatabase h = m38011h();
        Cursor query;
        try {
            String[] strArr = new String[]{"cid", "tid", "adid", "hits_count", NativeProtocol.WEB_DIALOG_PARAMS};
            int intValue = ((Integer) ba.f16385d.m20315a()).intValue();
            String str = "properties";
            query = h.query(str, strArr, "app_uid=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null, String.valueOf(intValue));
            try {
                j = new ArrayList();
                if (query.moveToFirst()) {
                    do {
                        Object string = query.getString(0);
                        Object string2 = query.getString(1);
                        boolean z = query.getInt(2) != 0;
                        long j2 = (long) query.getInt(3);
                        Map b = m37996b(query.getString(4));
                        if (!TextUtils.isEmpty(string)) {
                            if (!TextUtils.isEmpty(string2)) {
                                j.add(new C5011t(0, string, string2, z, j2, b));
                            }
                        }
                        m21033c("Read property with empty client id or tracker id", string, string2);
                    } while (query.moveToNext());
                }
                if (j.size() >= intValue) {
                    m21040h("Sending hits to too many properties. Campaign report might be incorrect");
                }
                if (query != null) {
                    query.close();
                }
                return j;
            } catch (SQLiteException e) {
                j = e;
                try {
                    m21037e("Error loading hits from the database", j);
                    throw j;
                } catch (Throwable th) {
                    j = th;
                    if (query != null) {
                        query.close();
                    }
                    throw j;
                }
            }
        } catch (SQLiteException e2) {
            query = null;
            j = e2;
            m21037e("Error loading hits from the database", j);
            throw j;
        } catch (Throwable th2) {
            query = null;
            j = th2;
            if (query != null) {
                query.close();
            }
            throw j;
        }
    }

    public final void close() {
        try {
            this.f28922c.close();
        } catch (SQLiteException e) {
            m21037e("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            m21037e("Error closing database", e2);
        }
    }

    /* renamed from: a */
    private final long m37991a(String str, String[] strArr) {
        Object e;
        try {
            strArr = m38011h().rawQuery(str, null);
            try {
                if (strArr.moveToFirst()) {
                    long j = strArr.getLong(0);
                    if (strArr != null) {
                        strArr.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    m21035d("Database error", str, e);
                    throw e;
                } catch (Throwable th) {
                    str = th;
                    if (strArr != null) {
                        strArr.close();
                    }
                    throw str;
                }
            }
        } catch (Object e3) {
            e = e3;
            strArr = null;
            m21035d("Database error", str, e);
            throw e;
        } catch (Throwable th2) {
            str = th2;
            strArr = null;
            if (strArr != null) {
                strArr.close();
            }
            throw str;
        }
    }

    /* renamed from: a */
    private final long m37992a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            strArr = m38011h().rawQuery(str, strArr);
            try {
                if (strArr.moveToFirst() != null) {
                    j = strArr.getLong(0);
                    if (strArr != null) {
                        strArr.close();
                    }
                    return j;
                }
                if (strArr != null) {
                    strArr.close();
                }
                return null;
            } catch (SQLiteException e) {
                j = e;
                cursor = strArr;
                try {
                    m21035d("Database error", str, j);
                    throw j;
                } catch (Throwable th) {
                    str = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                cursor = strArr;
                if (cursor != null) {
                    cursor.close();
                }
                throw str;
            }
        } catch (SQLiteException e2) {
            j = e2;
            m21035d("Database error", str, j);
            throw j;
        }
    }

    /* renamed from: a */
    private final Map<String, String> m37994a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String str2 = "?";
                str = String.valueOf(str);
                str = str.length() != 0 ? str2.concat(str) : new String(str2);
            }
            return C2901l.a(new URI(str), Utf8Charset.NAME);
        } catch (String str3) {
            m21037e("Error parsing hit parameters", str3);
            return new HashMap(0);
        }
    }

    /* renamed from: b */
    private final Map<String, String> m37996b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String str2 = "?";
            str = String.valueOf(str);
            return C2901l.a(new URI(str.length() != 0 ? str2.concat(str) : new String(str2)), Utf8Charset.NAME);
        } catch (String str3) {
            m21037e("Error parsing property parameters", str3);
            return new HashMap(0);
        }
    }

    /* renamed from: h */
    final SQLiteDatabase m38011h() {
        try {
            return this.f28922c.getWritableDatabase();
        } catch (SQLiteException e) {
            m21034d("Error opening database", e);
            throw e;
        }
    }
}
