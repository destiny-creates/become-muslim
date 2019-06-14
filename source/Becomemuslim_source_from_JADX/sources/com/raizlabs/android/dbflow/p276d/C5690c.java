package com.raizlabs.android.dbflow.p276d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.net.Uri.Builder;
import com.raizlabs.android.dbflow.C5658b;
import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p271a.C5655b;
import com.raizlabs.android.dbflow.p273c.C5672d;
import com.raizlabs.android.dbflow.p276d.p278b.C7129c;
import com.raizlabs.android.dbflow.p281e.C5696f;
import com.raizlabs.android.dbflow.p281e.C5698h;
import com.raizlabs.android.dbflow.p281e.C5699l;
import com.raizlabs.android.dbflow.p281e.C7139b.C5695a;
import com.raizlabs.android.dbflow.p281e.C8030i;
import com.raizlabs.android.dbflow.p281e.p282a.C5694c;
import com.raizlabs.android.dbflow.p281e.p282a.C8027a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SqlUtils */
/* renamed from: com.raizlabs.android.dbflow.d.c */
public class C5690c {
    /* renamed from: a */
    public static <ModelClass extends C5698h> List<ModelClass> m24121a(Class<ModelClass> cls, String str, String... strArr) {
        Cursor rawQuery = C5680f.m24086b(cls).m24064f().rawQuery(str, strArr);
        if (C8027a.class.isAssignableFrom(cls) != null) {
            cls = C5690c.m24119a((Class) cls, rawQuery);
        } else {
            cls = C5690c.m24128b(cls, rawQuery);
        }
        rawQuery.close();
        return cls;
    }

    /* renamed from: a */
    public static <CacheableClass extends C8027a> List<CacheableClass> m24120a(Class<CacheableClass> cls, Cursor cursor, C5694c<CacheableClass, ?> c5694c) {
        List<CacheableClass> arrayList = new ArrayList();
        cls = C5680f.m24089e(cls);
        if (cls != null) {
            if (!cls.mo6778g()) {
                throw new IllegalArgumentException("You cannot call this method for a table that has no caching id. Eitheruse one Primary Key or call convertToList()");
            } else if (c5694c != null) {
                synchronized (cursor) {
                    if (cursor.moveToFirst()) {
                        do {
                            C8027a c8027a = (C8027a) c5694c.mo5062a(Long.valueOf(cursor.getLong(cursor.getColumnIndex(cls.mo6777f()))));
                            if (c8027a != null) {
                                arrayList.add(c8027a);
                            } else {
                                c8027a = (C8027a) cls.mo6768a();
                                cls.mo6771a(cursor, c8027a);
                                arrayList.add(c8027a);
                            }
                        } while (cursor.moveToNext());
                    }
                }
            } else {
                throw new IllegalArgumentException("ModelCache specified in convertToCacheableList() must not be null.");
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <CacheableClass extends C8027a> List<CacheableClass> m24119a(Class<CacheableClass> cls, Cursor cursor) {
        return C5690c.m24120a((Class) cls, cursor, C8027a.m38909a(cls));
    }

    /* renamed from: b */
    public static <ModelClass extends C5698h> List<ModelClass> m24128b(Class<ModelClass> cls, Cursor cursor) {
        List<ModelClass> arrayList = new ArrayList();
        cls = C5680f.m24088d(cls);
        if (cls != null) {
            synchronized (cursor) {
                if (cursor.moveToFirst()) {
                    do {
                        C5698h a = cls.mo6768a();
                        cls.mo6771a(cursor, a);
                        arrayList.add(a);
                    } while (cursor.moveToNext());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <ModelClass extends C5698h> ModelClass m24118a(boolean z, Class<ModelClass> cls, Cursor cursor) {
        if (z || cursor.moveToFirst()) {
            z = C5680f.m24088d(cls);
            if (z) {
                cls = z.mo6768a();
                z.mo6771a(cursor, cls);
                return cls;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static <CacheableClass extends C8027a> CacheableClass m24126b(boolean z, Class<CacheableClass> cls, Cursor cursor) {
        if (z || cursor.moveToFirst()) {
            z = C5680f.m24089e(cls);
            if (z) {
                C8027a c8027a = (C8027a) C8027a.m38909a(cls).mo5062a(z.mo6769a(cursor, cursor.getColumnIndex(z.mo6777f())));
                if (c8027a != null) {
                    return c8027a;
                }
                c8027a = (C8027a) z.mo6768a();
                z.mo6771a(cursor, c8027a);
                return c8027a;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static <ModelClass extends C5698h> ModelClass m24127b(Class<ModelClass> cls, String str, String... strArr) {
        Cursor rawQuery = C5680f.m24086b(cls).m24064f().rawQuery(str, strArr);
        if (C8027a.class.isAssignableFrom(cls) != null) {
            cls = C5690c.m24126b(false, (Class) cls, rawQuery);
        } else {
            cls = C5690c.m24118a(false, (Class) cls, rawQuery);
        }
        rawQuery.close();
        return cls;
    }

    /* renamed from: c */
    public static <ModelClass extends C5698h> boolean m24131c(Class<ModelClass> cls, String str, String... strArr) {
        cls = C5680f.m24086b(cls).m24064f().rawQuery(str, strArr);
        str = cls.getCount() > null ? true : null;
        cls.close();
        return str;
    }

    /* renamed from: a */
    public static <ModelClass extends C5698h, TableClass extends C5698h, AdapterClass extends C5699l & C5696f> void m24122a(TableClass tableClass, AdapterClass adapterClass, C8030i<ModelClass> c8030i) {
        if (tableClass != null) {
            boolean e = adapterClass.mo6775e(tableClass);
            if (e) {
                e = C5690c.m24129b((C5698h) tableClass, (C5699l) adapterClass, (C8030i) c8030i);
            }
            if (!e) {
                C5690c.m24130c((C5698h) tableClass, (C5699l) adapterClass, (C8030i) c8030i);
            }
            C5690c.m24123a((C5698h) tableClass, (C5699l) adapterClass, (C8030i) c8030i, C5695a.SAVE);
            return;
        }
        adapterClass = new StringBuilder();
        adapterClass.append("Model from ");
        adapterClass.append(c8030i.mo6773b());
        adapterClass.append(" was null");
        throw new IllegalArgumentException(adapterClass.toString());
    }

    /* renamed from: b */
    public static <ModelClass extends C5698h, TableClass extends C5698h, AdapterClass extends C5699l & C5696f> boolean m24129b(TableClass tableClass, AdapterClass adapterClass, C8030i<ModelClass> c8030i) {
        SQLiteDatabase f = C5680f.m24086b(c8030i.mo6773b()).m24064f();
        ContentValues contentValues = new ContentValues();
        ((C5696f) adapterClass).mo6770a(contentValues, (C5698h) tableClass);
        boolean z = C5658b.m24010a(f, c8030i.mo6774c(), contentValues, adapterClass.mo6776f(tableClass).mo5061a(), null, C5655b.m24004a(c8030i.m38926j())) != 0;
        if (z) {
            C5690c.m24123a((C5698h) tableClass, (C5699l) adapterClass, (C8030i) c8030i, C5695a.UPDATE);
        } else {
            C5690c.m24130c((C5698h) tableClass, (C5699l) adapterClass, (C8030i) c8030i);
        }
        return z;
    }

    /* renamed from: c */
    public static <ModelClass extends C5698h, TableClass extends C5698h, AdapterClass extends C5699l & C5696f> void m24130c(TableClass tableClass, AdapterClass adapterClass, C8030i<ModelClass> c8030i) {
        SQLiteStatement d = c8030i.m38920d();
        C5696f c5696f = (C5696f) adapterClass;
        c5696f.mo6772a(d, (C5698h) tableClass);
        c5696f.mo6284a((C5698h) tableClass, d.executeInsert());
        C5690c.m24123a((C5698h) tableClass, (C5699l) adapterClass, (C8030i) c8030i, C5695a.INSERT);
    }

    /* renamed from: d */
    public static <ModelClass extends C5698h, TableClass extends C5698h, AdapterClass extends C5699l & C5696f> void m24132d(TableClass tableClass, AdapterClass adapterClass, C8030i<ModelClass> c8030i) {
        C5696f c5696f = (C5696f) adapterClass;
        new C7129c().m33170a(c5696f.mo6773b()).m38892a(adapterClass.mo6776f(tableClass)).m38907e();
        c5696f.mo6284a((C5698h) tableClass, 0);
        C5690c.m24123a((C5698h) tableClass, (C5699l) adapterClass, (C8030i) c8030i, C5695a.DELETE);
    }

    /* renamed from: a */
    public static void m24124a(Class<? extends C5698h> cls, C5695a c5695a, String str, Object obj) {
        C5680f.m24085b().getContentResolver().notifyChange(C5690c.m24125b(cls, c5695a, str, obj), null, true);
    }

    /* renamed from: a */
    private static <ModelClass extends C5698h, TableClass extends C5698h, AdapterClass extends C5699l & C5696f> void m24123a(TableClass tableClass, AdapterClass adapterClass, C8030i<ModelClass> c8030i, C5695a c5695a) {
        if (!C5672d.m24043a()) {
            return;
        }
        if (c8030i.mo6778g()) {
            C5690c.m24124a(c8030i.mo6773b(), c5695a, c8030i.mo6777f(), ((C5696f) adapterClass).mo6283a(tableClass));
        } else {
            C5690c.m24124a(c8030i.mo6773b(), c5695a, null, null);
        }
    }

    /* renamed from: b */
    public static Uri m24125b(Class<? extends C5698h> cls, C5695a c5695a, String str, Object obj) {
        cls = new Builder().scheme("dbflow").authority(C5680f.m24082a((Class) cls));
        if (c5695a != null) {
            cls.fragment(c5695a.name());
        }
        if (str != null) {
            cls.appendQueryParameter(Uri.encode(str), Uri.encode(String.valueOf(obj)));
        }
        return cls.build();
    }

    /* renamed from: a */
    public static Uri m24117a(Class<? extends C5698h> cls, C5695a c5695a) {
        return C5690c.m24125b(cls, c5695a, null, null);
    }
}
