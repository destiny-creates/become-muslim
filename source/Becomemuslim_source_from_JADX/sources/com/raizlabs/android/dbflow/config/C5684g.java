package com.raizlabs.android.dbflow.config;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.raizlabs.android.dbflow.C5656a;
import com.raizlabs.android.dbflow.config.C5679e.C5678a;
import com.raizlabs.android.dbflow.p273c.C5673e;
import com.raizlabs.android.dbflow.p276d.C7135b;
import com.raizlabs.android.dbflow.p276d.p279c.C5689a;
import com.raizlabs.android.dbflow.p281e.C8030i;
import com.raizlabs.android.dbflow.p281e.C8031j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FlowSQLiteOpenHelper */
/* renamed from: com.raizlabs.android.dbflow.config.g */
public class C5684g extends SQLiteOpenHelper {
    /* renamed from: a */
    private C5656a f18991a;
    /* renamed from: b */
    private C5675a f18992b;
    /* renamed from: c */
    private SQLiteOpenHelper f18993c;

    public C5684g(C5675a c5675a, C5656a c5656a) {
        super(C5680f.m24085b(), c5675a.m24066h(), null, c5675a.mo5053i());
        this.f18991a = c5656a;
        this.f18992b = c5675a;
        m24105b(this.f18992b.m24066h(), this.f18992b.m24066h());
        if (c5675a.mo5056l() != null) {
            this.f18993c = new SQLiteOpenHelper(this, C5680f.m24085b(), m24102c(), null, c5675a.mo5053i()) {
                /* renamed from: a */
                final /* synthetic */ C5684g f18982a;

                public void onOpen(SQLiteDatabase sQLiteDatabase) {
                    this.f18982a.m24093a(sQLiteDatabase);
                }

                public void onCreate(SQLiteDatabase sQLiteDatabase) {
                    this.f18982a.m24093a(sQLiteDatabase);
                    this.f18982a.m24100b(sQLiteDatabase);
                    this.f18982a.m24094a(sQLiteDatabase, -1, sQLiteDatabase.getVersion());
                }

                public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                    this.f18982a.m24093a(sQLiteDatabase);
                    this.f18982a.m24100b(sQLiteDatabase);
                    this.f18982a.m24094a(sQLiteDatabase, i, i2);
                }
            };
            m24103a(m24102c(), this.f18992b.m24066h());
            this.f18993c.getWritableDatabase();
        }
    }

    /* renamed from: c */
    private String m24102c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temp-");
        stringBuilder.append(this.f18992b.mo5052g());
        stringBuilder.append(".db");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public boolean m24104a() {
        Throwable th;
        SQLiteStatement compileStatement;
        try {
            compileStatement = getWritableDatabase().compileStatement("PRAGMA quick_check(1)");
            try {
                boolean z;
                String simpleQueryForString = compileStatement.simpleQueryForString();
                if (simpleQueryForString.equalsIgnoreCase("ok")) {
                    z = true;
                } else {
                    C5678a c5678a = C5678a.E;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("PRAGMA integrity_check on ");
                    stringBuilder.append(this.f18992b.mo5052g());
                    stringBuilder.append(" returned: ");
                    stringBuilder.append(simpleQueryForString);
                    C5679e.m24075a(c5678a, stringBuilder.toString());
                    z = false;
                    if (this.f18992b.mo5056l()) {
                        z = m24106b();
                    }
                }
                if (compileStatement != null) {
                    compileStatement.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (compileStatement != null) {
                    compileStatement.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            compileStatement = null;
            th = th4;
            if (compileStatement != null) {
                compileStatement.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public void m24103a(String str, String str2) {
        File databasePath = C5680f.m24085b().getDatabasePath(str);
        if (!databasePath.exists()) {
            databasePath.getParentFile().mkdirs();
            try {
                InputStream fileInputStream;
                File databasePath2 = C5680f.m24085b().getDatabasePath(this.f18992b.m24066h());
                if (databasePath2.exists() && this.f18992b.mo5056l() && C5680f.m24084a(this.f18993c)) {
                    fileInputStream = new FileInputStream(databasePath2);
                } else {
                    fileInputStream = C5680f.m24085b().getAssets().open(str2);
                }
                m24099a(databasePath, fileInputStream);
            } catch (Throwable e) {
                C5679e.m24079a(e);
            }
        }
    }

    /* renamed from: b */
    public boolean m24106b() {
        Context b = C5680f.m24085b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temp-");
        stringBuilder.append(this.f18992b.mo5052g());
        File databasePath = b.getDatabasePath(stringBuilder.toString());
        File databasePath2 = C5680f.m24085b().getDatabasePath(this.f18992b.mo5052g());
        if (databasePath2.delete()) {
            try {
                m24099a(databasePath2, new FileInputStream(databasePath));
            } catch (Throwable e) {
                C5679e.m24079a(e);
                return false;
            }
        }
        C5679e.m24075a(C5678a.E, "Failed to delete DB");
        return true;
    }

    /* renamed from: a */
    private void m24099a(File file, InputStream inputStream) {
        OutputStream fileOutputStream = new FileOutputStream(file);
        file = new byte[1024];
        while (true) {
            int read = inputStream.read(file);
            if (read > 0) {
                fileOutputStream.write(file, 0, read);
            } else {
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                return;
            }
        }
    }

    /* renamed from: b */
    public void m24105b(String str, String str2) {
        File databasePath = C5680f.m24085b().getDatabasePath(str);
        if (!databasePath.exists() || (this.f18992b.mo5054j() && !(this.f18992b.mo5054j() && m24104a()))) {
            databasePath.getParentFile().mkdirs();
            try {
                InputStream open;
                File databasePath2 = C5680f.m24085b().getDatabasePath(m24102c());
                if (!databasePath2.exists() || (this.f18992b.mo5056l() && !(this.f18992b.mo5056l() && C5680f.m24084a(this.f18993c)))) {
                    open = C5680f.m24085b().getAssets().open(str2);
                } else {
                    open = new FileInputStream(databasePath2);
                }
                m24099a(databasePath, open);
            } catch (String str3) {
                C5679e.m24077a(C5678a.W, "Failed to open file", str3);
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (this.f18991a != null) {
            this.f18991a.mo5051b(sQLiteDatabase);
        }
        m24093a(sQLiteDatabase);
        m24100b(sQLiteDatabase);
        m24094a(sQLiteDatabase, -1, sQLiteDatabase.getVersion());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (this.f18991a != null) {
            this.f18991a.mo5050a(sQLiteDatabase, i, i2);
        }
        m24093a(sQLiteDatabase);
        m24100b(sQLiteDatabase);
        m24094a(sQLiteDatabase, i, i2);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.f18991a != null) {
            this.f18991a.mo5049a(sQLiteDatabase);
        }
        m24093a(sQLiteDatabase);
    }

    /* renamed from: a */
    private void m24093a(SQLiteDatabase sQLiteDatabase) {
        if (this.f18992b.mo5055k()) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys=ON;");
            C5679e.m24075a(C5678a.I, "Foreign Keys supported. Enabling foreign key features.");
        }
    }

    /* renamed from: b */
    private void m24100b(final SQLiteDatabase sQLiteDatabase) {
        C5673e.m24046a(sQLiteDatabase, new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C5684g f18984b;

            public void run() {
                for (C8030i h : this.f18984b.f18992b.m24057a()) {
                    sQLiteDatabase.execSQL(h.mo6779h());
                }
                for (C8031j c8031j : this.f18984b.f18992b.m24059b()) {
                    try {
                        sQLiteDatabase.execSQL(new C7135b().m33189b((Object) "CREATE VIEW").m33183a(c8031j.m38928c()).m33189b((Object) "AS ").m33189b(c8031j.m38927b()).mo5061a());
                    } catch (Throwable e) {
                        C5679e.m24079a(e);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private void m24094a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            AssetManager assets = C5680f.m24085b().getAssets();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("migrations/");
            stringBuilder.append(this.f18992b.mo5052g());
            List<String> asList = Arrays.asList(assets.list(stringBuilder.toString()));
            Collections.sort(asList, new C5685h());
            final Map hashMap = new HashMap();
            for (String str : asList) {
                try {
                    Integer valueOf = Integer.valueOf(str.replace(".sql", ""));
                    List list = (List) hashMap.get(valueOf);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(valueOf, list);
                    }
                    list.add(str);
                } catch (Throwable e) {
                    C5678a c5678a = C5678a.W;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Skipping invalidly named file: ");
                    stringBuilder2.append(str);
                    C5679e.m24077a(c5678a, stringBuilder2.toString(), e);
                }
            }
            final Map c = this.f18992b.m24061c();
            final int i3 = i + 1;
            final int i4 = i2;
            final SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            C5673e.m24046a(sQLiteDatabase, new Runnable(this) {
                /* renamed from: f */
                final /* synthetic */ C5684g f18990f;

                public void run() {
                    for (int i = i3; i <= i4; i++) {
                        List<String> list = (List) hashMap.get(Integer.valueOf(i));
                        if (list != null) {
                            for (String str : list) {
                                this.f18990f.m24095a(sQLiteDatabase2, str);
                                C5678a c5678a = C5678a.I;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(str);
                                stringBuilder.append(" executed succesfully.");
                                C5679e.m24075a(c5678a, stringBuilder.toString());
                            }
                        }
                        if (c != null) {
                            List<C5689a> list2 = (List) c.get(Integer.valueOf(i));
                            if (list2 != null) {
                                for (C5689a c5689a : list2) {
                                    c5689a.m24114a();
                                    c5689a.m24115a(sQLiteDatabase2);
                                    c5689a.m24116b();
                                }
                            }
                        }
                    }
                }
            });
        } catch (SQLiteDatabase sQLiteDatabase3) {
            C5679e.m24077a(C5678a.E, "Failed to execute migrations.", sQLiteDatabase3);
        }
    }

    /* renamed from: a */
    private void m24095a(SQLiteDatabase sQLiteDatabase, String str) {
        StringBuilder stringBuilder;
        try {
            AssetManager assets = C5680f.m24085b().getAssets();
            stringBuilder = new StringBuilder();
            stringBuilder.append("migrations/");
            stringBuilder.append(this.f18992b.mo5052g());
            stringBuilder.append("/");
            stringBuilder.append(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assets.open(stringBuilder.toString())));
            String str2 = ";";
            String str3 = "\\";
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                readLine = readLine.trim();
                boolean endsWith = readLine.endsWith(str2);
                if (!readLine.startsWith(str3)) {
                    if (endsWith) {
                        readLine = readLine.substring(0, readLine.length() - str2.length());
                    }
                    stringBuffer.append(" ");
                    stringBuffer.append(readLine);
                    if (endsWith) {
                        sQLiteDatabase.execSQL(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                sQLiteDatabase.execSQL(stringBuffer.toString());
            }
        } catch (SQLiteDatabase sQLiteDatabase2) {
            C5678a c5678a = C5678a.E;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to execute ");
            stringBuilder.append(str);
            C5679e.m24077a(c5678a, stringBuilder.toString(), sQLiteDatabase2);
        }
    }
}
