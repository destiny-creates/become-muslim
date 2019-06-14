package com.facebook.react.modules.storage;

import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner.Cleanable;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

@ReactModule(name = "AsyncSQLiteDBStorage")
public class AsyncStorageModule extends ReactContextBaseJavaModule implements Cleanable {
    public static int MAX_SQL_KEYS = 999;
    public static final String NAME = "AsyncSQLiteDBStorage";
    public final SerialExecutor executor;
    public ReactDatabaseSupplier mReactDatabaseSupplier;
    public boolean mShuttingDown;

    private class SerialExecutor implements Executor {
        public final Executor executor;
        public Runnable mActive;
        public final ArrayDeque<Runnable> mTasks = new ArrayDeque();

        SerialExecutor(Executor executor) {
            this.executor = executor;
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        synchronized void scheduleNext() {
            Runnable runnable = (Runnable) this.mTasks.poll();
            this.mActive = runnable;
            if (runnable != null) {
                this.executor.execute(this.mActive);
            }
        }
    }

    public String getName() {
        return NAME;
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @VisibleForTesting
    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        this.executor = new SerialExecutor(executor);
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(reactApplicationContext);
    }

    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    public void clearSensitiveData() {
        this.mReactDatabaseSupplier.clearAndCloseDatabase();
    }

    @ReactMethod
    public void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(new Object[]{AsyncStorageErrorUtil.getInvalidKeyError(null), null});
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected void doInBackgroundGuarded(java.lang.Void... r20) {
                /*
                r19 = this;
                r1 = r19;
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;
                r0 = r0.ensureDatabase();
                r2 = 2;
                r3 = 0;
                r4 = 1;
                r5 = 0;
                if (r0 != 0) goto L_0x001e;
            L_0x000e:
                r0 = r5;
                r2 = new java.lang.Object[r2];
                r6 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r3);
                r2[r5] = r6;
                r2[r4] = r3;
                r0.invoke(r2);
                return;
            L_0x001e:
                r0 = new java.lang.String[r2];
                r6 = com.facebook.react.modules.storage.ReactDatabaseSupplier.KEY_COLUMN;
                r0[r5] = r6;
                r6 = com.facebook.react.modules.storage.ReactDatabaseSupplier.VALUE_COLUMN;
                r0[r4] = r6;
                r6 = new java.util.HashSet;
                r6.<init>();
                r15 = com.facebook.react.bridge.Arguments.createArray();
                r14 = 0;
            L_0x0032:
                r7 = r4;
                r7 = r7.size();
                if (r14 >= r7) goto L_0x0107;
            L_0x003a:
                r7 = r4;
                r7 = r7.size();
                r7 = r7 - r14;
                r8 = com.facebook.react.modules.storage.AsyncStorageModule.MAX_SQL_KEYS;
                r13 = java.lang.Math.min(r7, r8);
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.this;
                r7 = r7.mReactDatabaseSupplier;
                r7 = r7.get();
                r8 = com.facebook.react.modules.storage.ReactDatabaseSupplier.TABLE_CATALYST;
                r10 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.buildKeySelection(r13);
                r9 = r4;
                r11 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.buildKeySelectionArgs(r9, r14, r13);
                r12 = 0;
                r16 = 0;
                r17 = 0;
                r9 = r0;
                r18 = r13;
                r13 = r16;
                r16 = r14;
                r14 = r17;
                r7 = r7.query(r8, r9, r10, r11, r12, r13, r14);
                r6.clear();
                r8 = r7.getCount();	 Catch:{ Exception -> 0x00e2 }
                r9 = r4;	 Catch:{ Exception -> 0x00e2 }
                r9 = r9.size();	 Catch:{ Exception -> 0x00e2 }
                if (r8 == r9) goto L_0x008e;
            L_0x007c:
                r8 = r16;
            L_0x007e:
                r14 = r16 + r18;
                if (r8 >= r14) goto L_0x008e;
            L_0x0082:
                r9 = r4;	 Catch:{ Exception -> 0x00e2 }
                r9 = r9.getString(r8);	 Catch:{ Exception -> 0x00e2 }
                r6.add(r9);	 Catch:{ Exception -> 0x00e2 }
                r8 = r8 + 1;
                goto L_0x007e;
            L_0x008e:
                r8 = r7.moveToFirst();	 Catch:{ Exception -> 0x00e2 }
                if (r8 == 0) goto L_0x00b6;
            L_0x0094:
                r8 = com.facebook.react.bridge.Arguments.createArray();	 Catch:{ Exception -> 0x00e2 }
                r9 = r7.getString(r5);	 Catch:{ Exception -> 0x00e2 }
                r8.pushString(r9);	 Catch:{ Exception -> 0x00e2 }
                r9 = r7.getString(r4);	 Catch:{ Exception -> 0x00e2 }
                r8.pushString(r9);	 Catch:{ Exception -> 0x00e2 }
                r15.pushArray(r8);	 Catch:{ Exception -> 0x00e2 }
                r8 = r7.getString(r5);	 Catch:{ Exception -> 0x00e2 }
                r6.remove(r8);	 Catch:{ Exception -> 0x00e2 }
                r8 = r7.moveToNext();	 Catch:{ Exception -> 0x00e2 }
                if (r8 != 0) goto L_0x0094;
            L_0x00b6:
                r7.close();
                r7 = r6.iterator();
            L_0x00bd:
                r8 = r7.hasNext();
                if (r8 == 0) goto L_0x00d7;
            L_0x00c3:
                r8 = r7.next();
                r8 = (java.lang.String) r8;
                r9 = com.facebook.react.bridge.Arguments.createArray();
                r9.pushString(r8);
                r9.pushNull();
                r15.pushArray(r9);
                goto L_0x00bd;
            L_0x00d7:
                r6.clear();
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.MAX_SQL_KEYS;
                r14 = r16 + r7;
                goto L_0x0032;
            L_0x00e0:
                r0 = move-exception;
                goto L_0x0103;
            L_0x00e2:
                r0 = move-exception;
                r6 = "ReactNative";
                r8 = r0.getMessage();	 Catch:{ all -> 0x00e0 }
                com.facebook.common.logging.FLog.m5715w(r6, r8, r0);	 Catch:{ all -> 0x00e0 }
                r6 = r5;	 Catch:{ all -> 0x00e0 }
                r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00e0 }
                r0 = r0.getMessage();	 Catch:{ all -> 0x00e0 }
                r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r3, r0);	 Catch:{ all -> 0x00e0 }
                r2[r5] = r0;	 Catch:{ all -> 0x00e0 }
                r2[r4] = r3;	 Catch:{ all -> 0x00e0 }
                r6.invoke(r2);	 Catch:{ all -> 0x00e0 }
                r7.close();
                return;
            L_0x0103:
                r7.close();
                throw r0;
            L_0x0107:
                r0 = r5;
                r2 = new java.lang.Object[r2];
                r2[r5] = r3;
                r2[r4] = r15;
                r0.invoke(r2);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.1.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[]{AsyncStorageErrorUtil.getInvalidKeyError(null)});
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected void doInBackgroundGuarded(java.lang.Void... r7) {
                /*
                r6 = this;
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.this;
                r7 = r7.ensureDatabase();
                r0 = 0;
                r1 = 1;
                r2 = 0;
                if (r7 != 0) goto L_0x0019;
            L_0x000b:
                r7 = r5;
                r1 = new java.lang.Object[r1];
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r2);
                r1[r0] = r2;
                r7.invoke(r1);
                return;
            L_0x0019:
                r7 = new java.lang.StringBuilder;
                r7.<init>();
                r3 = "INSERT OR REPLACE INTO ";
                r7.append(r3);
                r3 = com.facebook.react.modules.storage.ReactDatabaseSupplier.TABLE_CATALYST;
                r7.append(r3);
                r3 = " VALUES (?, ?);";
                r7.append(r3);
                r7 = r7.toString();
                r3 = com.facebook.react.modules.storage.AsyncStorageModule.this;
                r3 = r3.mReactDatabaseSupplier;
                r3 = r3.get();
                r7 = r3.compileStatement(r7);
                r3 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0132 }
                r3 = r3.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0132 }
                r3 = r3.get();	 Catch:{ Exception -> 0x0132 }
                r3.beginTransaction();	 Catch:{ Exception -> 0x0132 }
                r3 = 0;
            L_0x0049:
                r4 = r4;	 Catch:{ Exception -> 0x0132 }
                r4 = r4.size();	 Catch:{ Exception -> 0x0132 }
                if (r3 >= r4) goto L_0x0106;
            L_0x0051:
                r4 = r4;	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getArray(r3);	 Catch:{ Exception -> 0x0132 }
                r4 = r4.size();	 Catch:{ Exception -> 0x0132 }
                r5 = 2;
                if (r4 == r5) goto L_0x0082;
            L_0x005e:
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidValueError(r2);	 Catch:{ Exception -> 0x0132 }
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x006e }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x006e }
                r0 = r0.get();	 Catch:{ Exception -> 0x006e }
                r0.endTransaction();	 Catch:{ Exception -> 0x006e }
                goto L_0x0081;
            L_0x006e:
                r0 = move-exception;
                r1 = "ReactNative";
                r3 = r0.getMessage();
                com.facebook.common.logging.FLog.m5715w(r1, r3, r0);
                if (r7 != 0) goto L_0x0081;
            L_0x007a:
                r7 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
            L_0x0081:
                return;
            L_0x0082:
                r4 = r4;	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getArray(r3);	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getString(r0);	 Catch:{ Exception -> 0x0132 }
                if (r4 != 0) goto L_0x00b2;
            L_0x008e:
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidKeyError(r2);	 Catch:{ Exception -> 0x0132 }
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x009e }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x009e }
                r0 = r0.get();	 Catch:{ Exception -> 0x009e }
                r0.endTransaction();	 Catch:{ Exception -> 0x009e }
                goto L_0x00b1;
            L_0x009e:
                r0 = move-exception;
                r1 = "ReactNative";
                r3 = r0.getMessage();
                com.facebook.common.logging.FLog.m5715w(r1, r3, r0);
                if (r7 != 0) goto L_0x00b1;
            L_0x00aa:
                r7 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
            L_0x00b1:
                return;
            L_0x00b2:
                r4 = r4;	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getArray(r3);	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getString(r1);	 Catch:{ Exception -> 0x0132 }
                if (r4 != 0) goto L_0x00e2;
            L_0x00be:
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidValueError(r2);	 Catch:{ Exception -> 0x0132 }
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x00ce }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x00ce }
                r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
                r0.endTransaction();	 Catch:{ Exception -> 0x00ce }
                goto L_0x00e1;
            L_0x00ce:
                r0 = move-exception;
                r1 = "ReactNative";
                r3 = r0.getMessage();
                com.facebook.common.logging.FLog.m5715w(r1, r3, r0);
                if (r7 != 0) goto L_0x00e1;
            L_0x00da:
                r7 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
            L_0x00e1:
                return;
            L_0x00e2:
                r7.clearBindings();	 Catch:{ Exception -> 0x0132 }
                r4 = r4;	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getArray(r3);	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getString(r0);	 Catch:{ Exception -> 0x0132 }
                r7.bindString(r1, r4);	 Catch:{ Exception -> 0x0132 }
                r4 = r4;	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getArray(r3);	 Catch:{ Exception -> 0x0132 }
                r4 = r4.getString(r1);	 Catch:{ Exception -> 0x0132 }
                r7.bindString(r5, r4);	 Catch:{ Exception -> 0x0132 }
                r7.execute();	 Catch:{ Exception -> 0x0132 }
                r3 = r3 + 1;
                goto L_0x0049;
            L_0x0106:
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0132 }
                r7 = r7.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0132 }
                r7 = r7.get();	 Catch:{ Exception -> 0x0132 }
                r7.setTransactionSuccessful();	 Catch:{ Exception -> 0x0132 }
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x011d }
                r7 = r7.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x011d }
                r7 = r7.get();	 Catch:{ Exception -> 0x011d }
                r7.endTransaction();	 Catch:{ Exception -> 0x011d }
                goto L_0x0166;
            L_0x011d:
                r7 = move-exception;
                r3 = "ReactNative";
                r4 = r7.getMessage();
                com.facebook.common.logging.FLog.m5715w(r3, r4, r7);
                r7 = r7.getMessage();
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
                goto L_0x0166;
            L_0x0130:
                r7 = move-exception;
                goto L_0x017a;
            L_0x0132:
                r7 = move-exception;
                r3 = "ReactNative";
                r4 = r7.getMessage();	 Catch:{ all -> 0x0130 }
                com.facebook.common.logging.FLog.m5715w(r3, r4, r7);	 Catch:{ all -> 0x0130 }
                r7 = r7.getMessage();	 Catch:{ all -> 0x0130 }
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);	 Catch:{ all -> 0x0130 }
                r3 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0151 }
                r3 = r3.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0151 }
                r3 = r3.get();	 Catch:{ Exception -> 0x0151 }
                r3.endTransaction();	 Catch:{ Exception -> 0x0151 }
            L_0x014f:
                r2 = r7;
                goto L_0x0166;
            L_0x0151:
                r3 = move-exception;
                r4 = "ReactNative";
                r5 = r3.getMessage();
                com.facebook.common.logging.FLog.m5715w(r4, r5, r3);
                if (r7 != 0) goto L_0x014f;
            L_0x015d:
                r7 = r3.getMessage();
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
                goto L_0x014f;
            L_0x0166:
                if (r2 == 0) goto L_0x0172;
            L_0x0168:
                r7 = r5;
                r1 = new java.lang.Object[r1];
                r1[r0] = r2;
                r7.invoke(r1);
                goto L_0x0179;
            L_0x0172:
                r7 = r5;
                r0 = new java.lang.Object[r0];
                r7.invoke(r0);
            L_0x0179:
                return;
            L_0x017a:
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0186 }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0186 }
                r0 = r0.get();	 Catch:{ Exception -> 0x0186 }
                r0.endTransaction();	 Catch:{ Exception -> 0x0186 }
                goto L_0x0197;
            L_0x0186:
                r0 = move-exception;
                r1 = r0.getMessage();
                r3 = "ReactNative";
                com.facebook.common.logging.FLog.m5715w(r3, r1, r0);
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r0);
            L_0x0197:
                throw r7;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.2.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[]{AsyncStorageErrorUtil.getInvalidKeyError(null)});
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected void doInBackgroundGuarded(java.lang.Void... r9) {
                /*
                r8 = this;
                r9 = com.facebook.react.modules.storage.AsyncStorageModule.this;
                r9 = r9.ensureDatabase();
                r0 = 1;
                r1 = 0;
                r2 = 0;
                if (r9 != 0) goto L_0x0019;
            L_0x000b:
                r9 = r5;
                r0 = new java.lang.Object[r0];
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r2);
                r0[r1] = r2;
                r9.invoke(r0);
                return;
            L_0x0019:
                r9 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0081 }
                r9 = r9.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0081 }
                r9 = r9.get();	 Catch:{ Exception -> 0x0081 }
                r9.beginTransaction();	 Catch:{ Exception -> 0x0081 }
                r9 = 0;
            L_0x0025:
                r3 = r4;	 Catch:{ Exception -> 0x0081 }
                r3 = r3.size();	 Catch:{ Exception -> 0x0081 }
                if (r9 >= r3) goto L_0x0055;
            L_0x002d:
                r3 = r4;	 Catch:{ Exception -> 0x0081 }
                r3 = r3.size();	 Catch:{ Exception -> 0x0081 }
                r3 = r3 - r9;
                r4 = com.facebook.react.modules.storage.AsyncStorageModule.MAX_SQL_KEYS;	 Catch:{ Exception -> 0x0081 }
                r3 = java.lang.Math.min(r3, r4);	 Catch:{ Exception -> 0x0081 }
                r4 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0081 }
                r4 = r4.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0081 }
                r4 = r4.get();	 Catch:{ Exception -> 0x0081 }
                r5 = com.facebook.react.modules.storage.ReactDatabaseSupplier.TABLE_CATALYST;	 Catch:{ Exception -> 0x0081 }
                r6 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.buildKeySelection(r3);	 Catch:{ Exception -> 0x0081 }
                r7 = r4;	 Catch:{ Exception -> 0x0081 }
                r3 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.buildKeySelectionArgs(r7, r9, r3);	 Catch:{ Exception -> 0x0081 }
                r4.delete(r5, r6, r3);	 Catch:{ Exception -> 0x0081 }
                r3 = com.facebook.react.modules.storage.AsyncStorageModule.MAX_SQL_KEYS;	 Catch:{ Exception -> 0x0081 }
                r9 = r9 + r3;
                goto L_0x0025;
            L_0x0055:
                r9 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0081 }
                r9 = r9.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0081 }
                r9 = r9.get();	 Catch:{ Exception -> 0x0081 }
                r9.setTransactionSuccessful();	 Catch:{ Exception -> 0x0081 }
                r9 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x006c }
                r9 = r9.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x006c }
                r9 = r9.get();	 Catch:{ Exception -> 0x006c }
                r9.endTransaction();	 Catch:{ Exception -> 0x006c }
                goto L_0x00b5;
            L_0x006c:
                r9 = move-exception;
                r3 = "ReactNative";
                r4 = r9.getMessage();
                com.facebook.common.logging.FLog.m5715w(r3, r4, r9);
                r9 = r9.getMessage();
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r9);
                goto L_0x00b5;
            L_0x007f:
                r9 = move-exception;
                goto L_0x00c9;
            L_0x0081:
                r9 = move-exception;
                r3 = "ReactNative";
                r4 = r9.getMessage();	 Catch:{ all -> 0x007f }
                com.facebook.common.logging.FLog.m5715w(r3, r4, r9);	 Catch:{ all -> 0x007f }
                r9 = r9.getMessage();	 Catch:{ all -> 0x007f }
                r9 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r9);	 Catch:{ all -> 0x007f }
                r3 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x00a0 }
                r3 = r3.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x00a0 }
                r3 = r3.get();	 Catch:{ Exception -> 0x00a0 }
                r3.endTransaction();	 Catch:{ Exception -> 0x00a0 }
            L_0x009e:
                r2 = r9;
                goto L_0x00b5;
            L_0x00a0:
                r3 = move-exception;
                r4 = "ReactNative";
                r5 = r3.getMessage();
                com.facebook.common.logging.FLog.m5715w(r4, r5, r3);
                if (r9 != 0) goto L_0x009e;
            L_0x00ac:
                r9 = r3.getMessage();
                r9 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r9);
                goto L_0x009e;
            L_0x00b5:
                if (r2 == 0) goto L_0x00c1;
            L_0x00b7:
                r9 = r5;
                r0 = new java.lang.Object[r0];
                r0[r1] = r2;
                r9.invoke(r0);
                goto L_0x00c8;
            L_0x00c1:
                r9 = r5;
                r0 = new java.lang.Object[r1];
                r9.invoke(r0);
            L_0x00c8:
                return;
            L_0x00c9:
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x00d5 }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x00d5 }
                r0 = r0.get();	 Catch:{ Exception -> 0x00d5 }
                r0.endTransaction();	 Catch:{ Exception -> 0x00d5 }
                goto L_0x00e6;
            L_0x00d5:
                r0 = move-exception;
                r1 = r0.getMessage();
                r3 = "ReactNative";
                com.facebook.common.logging.FLog.m5715w(r3, r1, r0);
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r0);
            L_0x00e6:
                throw r9;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.3.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected void doInBackgroundGuarded(java.lang.Void... r7) {
                /*
                r6 = this;
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.this;
                r7 = r7.ensureDatabase();
                r0 = 1;
                r1 = 0;
                r2 = 0;
                if (r7 != 0) goto L_0x0019;
            L_0x000b:
                r7 = r4;
                r0 = new java.lang.Object[r0];
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r2);
                r0[r1] = r2;
                r7.invoke(r0);
                return;
            L_0x0019:
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0134 }
                r7 = r7.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0134 }
                r7 = r7.get();	 Catch:{ Exception -> 0x0134 }
                r7.beginTransaction();	 Catch:{ Exception -> 0x0134 }
                r7 = 0;
            L_0x0025:
                r3 = r3;	 Catch:{ Exception -> 0x0134 }
                r3 = r3.size();	 Catch:{ Exception -> 0x0134 }
                if (r7 >= r3) goto L_0x0108;
            L_0x002d:
                r3 = r3;	 Catch:{ Exception -> 0x0134 }
                r3 = r3.getArray(r7);	 Catch:{ Exception -> 0x0134 }
                r3 = r3.size();	 Catch:{ Exception -> 0x0134 }
                r4 = 2;
                if (r3 == r4) goto L_0x005e;
            L_0x003a:
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidValueError(r2);	 Catch:{ Exception -> 0x0134 }
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x004a }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x004a }
                r0 = r0.get();	 Catch:{ Exception -> 0x004a }
                r0.endTransaction();	 Catch:{ Exception -> 0x004a }
                goto L_0x005d;
            L_0x004a:
                r0 = move-exception;
                r1 = "ReactNative";
                r3 = r0.getMessage();
                com.facebook.common.logging.FLog.m5715w(r1, r3, r0);
                if (r7 != 0) goto L_0x005d;
            L_0x0056:
                r7 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
            L_0x005d:
                return;
            L_0x005e:
                r3 = r3;	 Catch:{ Exception -> 0x0134 }
                r3 = r3.getArray(r7);	 Catch:{ Exception -> 0x0134 }
                r3 = r3.getString(r1);	 Catch:{ Exception -> 0x0134 }
                if (r3 != 0) goto L_0x008e;
            L_0x006a:
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidKeyError(r2);	 Catch:{ Exception -> 0x0134 }
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x007a }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x007a }
                r0 = r0.get();	 Catch:{ Exception -> 0x007a }
                r0.endTransaction();	 Catch:{ Exception -> 0x007a }
                goto L_0x008d;
            L_0x007a:
                r0 = move-exception;
                r1 = "ReactNative";
                r3 = r0.getMessage();
                com.facebook.common.logging.FLog.m5715w(r1, r3, r0);
                if (r7 != 0) goto L_0x008d;
            L_0x0086:
                r7 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
            L_0x008d:
                return;
            L_0x008e:
                r3 = r3;	 Catch:{ Exception -> 0x0134 }
                r3 = r3.getArray(r7);	 Catch:{ Exception -> 0x0134 }
                r3 = r3.getString(r0);	 Catch:{ Exception -> 0x0134 }
                if (r3 != 0) goto L_0x00be;
            L_0x009a:
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidValueError(r2);	 Catch:{ Exception -> 0x0134 }
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x00aa }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x00aa }
                r0 = r0.get();	 Catch:{ Exception -> 0x00aa }
                r0.endTransaction();	 Catch:{ Exception -> 0x00aa }
                goto L_0x00bd;
            L_0x00aa:
                r0 = move-exception;
                r1 = "ReactNative";
                r3 = r0.getMessage();
                com.facebook.common.logging.FLog.m5715w(r1, r3, r0);
                if (r7 != 0) goto L_0x00bd;
            L_0x00b6:
                r7 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
            L_0x00bd:
                return;
            L_0x00be:
                r3 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0134 }
                r3 = r3.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0134 }
                r3 = r3.get();	 Catch:{ Exception -> 0x0134 }
                r4 = r3;	 Catch:{ Exception -> 0x0134 }
                r4 = r4.getArray(r7);	 Catch:{ Exception -> 0x0134 }
                r4 = r4.getString(r1);	 Catch:{ Exception -> 0x0134 }
                r5 = r3;	 Catch:{ Exception -> 0x0134 }
                r5 = r5.getArray(r7);	 Catch:{ Exception -> 0x0134 }
                r5 = r5.getString(r0);	 Catch:{ Exception -> 0x0134 }
                r3 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.mergeImpl(r3, r4, r5);	 Catch:{ Exception -> 0x0134 }
                if (r3 != 0) goto L_0x0104;
            L_0x00e0:
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r2);	 Catch:{ Exception -> 0x0134 }
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x00f0 }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x00f0 }
                r0 = r0.get();	 Catch:{ Exception -> 0x00f0 }
                r0.endTransaction();	 Catch:{ Exception -> 0x00f0 }
                goto L_0x0103;
            L_0x00f0:
                r0 = move-exception;
                r1 = "ReactNative";
                r3 = r0.getMessage();
                com.facebook.common.logging.FLog.m5715w(r1, r3, r0);
                if (r7 != 0) goto L_0x0103;
            L_0x00fc:
                r7 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
            L_0x0103:
                return;
            L_0x0104:
                r7 = r7 + 1;
                goto L_0x0025;
            L_0x0108:
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0134 }
                r7 = r7.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0134 }
                r7 = r7.get();	 Catch:{ Exception -> 0x0134 }
                r7.setTransactionSuccessful();	 Catch:{ Exception -> 0x0134 }
                r7 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x011f }
                r7 = r7.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x011f }
                r7 = r7.get();	 Catch:{ Exception -> 0x011f }
                r7.endTransaction();	 Catch:{ Exception -> 0x011f }
                goto L_0x0168;
            L_0x011f:
                r7 = move-exception;
                r3 = "ReactNative";
                r4 = r7.getMessage();
                com.facebook.common.logging.FLog.m5715w(r3, r4, r7);
                r7 = r7.getMessage();
                r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
                goto L_0x0168;
            L_0x0132:
                r7 = move-exception;
                goto L_0x017c;
            L_0x0134:
                r7 = move-exception;
                r3 = "ReactNative";
                r4 = r7.getMessage();	 Catch:{ all -> 0x0132 }
                com.facebook.common.logging.FLog.m5715w(r3, r4, r7);	 Catch:{ all -> 0x0132 }
                r7 = r7.getMessage();	 Catch:{ all -> 0x0132 }
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);	 Catch:{ all -> 0x0132 }
                r3 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0153 }
                r3 = r3.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0153 }
                r3 = r3.get();	 Catch:{ Exception -> 0x0153 }
                r3.endTransaction();	 Catch:{ Exception -> 0x0153 }
            L_0x0151:
                r2 = r7;
                goto L_0x0168;
            L_0x0153:
                r3 = move-exception;
                r4 = "ReactNative";
                r5 = r3.getMessage();
                com.facebook.common.logging.FLog.m5715w(r4, r5, r3);
                if (r7 != 0) goto L_0x0151;
            L_0x015f:
                r7 = r3.getMessage();
                r7 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r7);
                goto L_0x0151;
            L_0x0168:
                if (r2 == 0) goto L_0x0174;
            L_0x016a:
                r7 = r4;
                r0 = new java.lang.Object[r0];
                r0[r1] = r2;
                r7.invoke(r0);
                goto L_0x017b;
            L_0x0174:
                r7 = r4;
                r0 = new java.lang.Object[r1];
                r7.invoke(r0);
            L_0x017b:
                return;
            L_0x017c:
                r0 = com.facebook.react.modules.storage.AsyncStorageModule.this;	 Catch:{ Exception -> 0x0188 }
                r0 = r0.mReactDatabaseSupplier;	 Catch:{ Exception -> 0x0188 }
                r0 = r0.get();	 Catch:{ Exception -> 0x0188 }
                r0.endTransaction();	 Catch:{ Exception -> 0x0188 }
                goto L_0x0199;
            L_0x0188:
                r0 = move-exception;
                r1 = r0.getMessage();
                r3 = "ReactNative";
                com.facebook.common.logging.FLog.m5715w(r3, r1, r0);
                r0 = r0.getMessage();
                com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r0);
            L_0x0199:
                throw r7;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.4.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        }.executeOnExecutor(this.executor, new Void[null]);
    }

    @ReactMethod
    public void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            protected void doInBackgroundGuarded(Void... voidArr) {
                if (AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase() == null) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                    callback.invoke(new Object[0]);
                } catch (Throwable e) {
                    FLog.m5715w(ReactConstants.TAG, e.getMessage(), e);
                    callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()));
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            protected void doInBackgroundGuarded(java.lang.Void... r13) {
                /*
                r12 = this;
                r13 = com.facebook.react.modules.storage.AsyncStorageModule.this;
                r13 = r13.ensureDatabase();
                r0 = 2;
                r1 = 1;
                r2 = 0;
                r3 = 0;
                if (r13 != 0) goto L_0x001c;
            L_0x000c:
                r13 = r3;
                r0 = new java.lang.Object[r0];
                r4 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r2);
                r0[r3] = r4;
                r0[r1] = r2;
                r13.invoke(r0);
                return;
            L_0x001c:
                r13 = com.facebook.react.bridge.Arguments.createArray();
                r6 = new java.lang.String[r1];
                r4 = com.facebook.react.modules.storage.ReactDatabaseSupplier.KEY_COLUMN;
                r6[r3] = r4;
                r4 = com.facebook.react.modules.storage.AsyncStorageModule.this;
                r4 = r4.mReactDatabaseSupplier;
                r4 = r4.get();
                r5 = com.facebook.react.modules.storage.ReactDatabaseSupplier.TABLE_CATALYST;
                r7 = 0;
                r8 = 0;
                r9 = 0;
                r10 = 0;
                r11 = 0;
                r4 = r4.query(r5, r6, r7, r8, r9, r10, r11);
                r5 = r4.moveToFirst();	 Catch:{ Exception -> 0x005d }
                if (r5 == 0) goto L_0x004c;
            L_0x003f:
                r5 = r4.getString(r3);	 Catch:{ Exception -> 0x005d }
                r13.pushString(r5);	 Catch:{ Exception -> 0x005d }
                r5 = r4.moveToNext();	 Catch:{ Exception -> 0x005d }
                if (r5 != 0) goto L_0x003f;
            L_0x004c:
                r4.close();
                r4 = r3;
                r0 = new java.lang.Object[r0];
                r0[r3] = r2;
                r0[r1] = r13;
                r4.invoke(r0);
                return;
            L_0x005b:
                r13 = move-exception;
                goto L_0x007e;
            L_0x005d:
                r13 = move-exception;
                r5 = "ReactNative";
                r6 = r13.getMessage();	 Catch:{ all -> 0x005b }
                com.facebook.common.logging.FLog.m5715w(r5, r6, r13);	 Catch:{ all -> 0x005b }
                r5 = r3;	 Catch:{ all -> 0x005b }
                r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x005b }
                r13 = r13.getMessage();	 Catch:{ all -> 0x005b }
                r13 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r2, r13);	 Catch:{ all -> 0x005b }
                r0[r3] = r13;	 Catch:{ all -> 0x005b }
                r0[r1] = r2;	 Catch:{ all -> 0x005b }
                r5.invoke(r0);	 Catch:{ all -> 0x005b }
                r4.close();
                return;
            L_0x007e:
                r4.close();
                throw r13;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.6.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    private boolean ensureDatabase() {
        return !this.mShuttingDown && this.mReactDatabaseSupplier.ensureDatabase();
    }
}
