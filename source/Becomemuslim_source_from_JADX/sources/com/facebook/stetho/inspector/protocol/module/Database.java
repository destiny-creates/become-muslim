package com.facebook.stetho.inspector.protocol.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import com.facebook.GraphResponse;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@TargetApi(11)
public class Database implements ChromeDevtoolsDomain {
    private static final int MAX_BLOB_LENGTH = 512;
    private static final int MAX_EXECUTE_RESULTS = 250;
    private static final String UNKNOWN_BLOB_LABEL = "{blob}";
    private final ChromePeerManager mChromePeerManager = new ChromePeerManager();
    private List<DatabaseDriver> mDatabaseDrivers = new ArrayList();
    private final ObjectMapper mObjectMapper;
    private final DatabasePeerRegistrationListener mPeerListener = new DatabasePeerRegistrationListener(this.mDatabaseDrivers);

    public static class AddDatabaseEvent {
        @JsonProperty(required = true)
        public DatabaseObject database;
    }

    public static abstract class DatabaseDriver {
        protected Context mContext;

        public interface ExecuteResultHandler<T> {
            T handleInsert(long j);

            T handleRawQuery();

            T handleSelect(Cursor cursor);

            T handleUpdateDelete(int i);
        }

        private final void onUnregistered(JsonRpcPeer jsonRpcPeer) {
        }

        public abstract ExecuteSQLResponse executeSQL(String str, String str2, ExecuteResultHandler<ExecuteSQLResponse> executeResultHandler);

        public abstract List<String> getDatabaseNames();

        public abstract List<String> getTableNames(String str);

        public DatabaseDriver(Context context) {
            this.mContext = context;
        }

        private final void onRegistered(JsonRpcPeer jsonRpcPeer) {
            for (String str : getDatabaseNames()) {
                DatabaseObject databaseObject = new DatabaseObject();
                databaseObject.id = str;
                databaseObject.name = str;
                databaseObject.domain = this.mContext.getPackageName();
                databaseObject.version = "N/A";
                AddDatabaseEvent addDatabaseEvent = new AddDatabaseEvent();
                addDatabaseEvent.database = databaseObject;
                jsonRpcPeer.invokeMethod("Database.addDatabase", addDatabaseEvent, null);
            }
        }
    }

    public static class DatabaseObject {
        @JsonProperty(required = true)
        public String domain;
        @JsonProperty(required = true)
        public String id;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String version;
    }

    public static class Error {
        @JsonProperty(required = true)
        public int code;
        @JsonProperty(required = true)
        public String message;
    }

    public static class ExecuteSQLRequest {
        @JsonProperty(required = true)
        public String databaseId;
        @JsonProperty(required = true)
        public String query;
    }

    private static class GetDatabaseTableNamesRequest {
        @JsonProperty(required = true)
        public String databaseId;

        private GetDatabaseTableNamesRequest() {
        }
    }

    /* renamed from: com.facebook.stetho.inspector.protocol.module.Database$1 */
    class C39661 implements ExecuteResultHandler<ExecuteSQLResponse> {
        C39661() {
        }

        public ExecuteSQLResponse handleRawQuery() {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList(GraphResponse.SUCCESS_KEY);
            executeSQLResponse.values = Collections.singletonList(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleSelect(Cursor cursor) {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Arrays.asList(cursor.getColumnNames());
            executeSQLResponse.values = Database.flattenRows(cursor, Database.MAX_EXECUTE_RESULTS);
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleInsert(long j) {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList("ID of last inserted row");
            executeSQLResponse.values = Collections.singletonList(String.valueOf(j));
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleUpdateDelete(int i) {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Collections.singletonList("Modified rows");
            executeSQLResponse.values = Collections.singletonList(String.valueOf(i));
            return executeSQLResponse;
        }
    }

    private static class DatabasePeerRegistrationListener implements PeerRegistrationListener {
        private final List<DatabaseDriver> mDatabaseDrivers;

        private DatabasePeerRegistrationListener(List<DatabaseDriver> list) {
            this.mDatabaseDrivers = list;
        }

        public void onPeerRegistered(JsonRpcPeer jsonRpcPeer) {
            for (DatabaseDriver access$300 : this.mDatabaseDrivers) {
                access$300.onRegistered(jsonRpcPeer);
            }
        }

        public void onPeerUnregistered(JsonRpcPeer jsonRpcPeer) {
            for (DatabaseDriver access$400 : this.mDatabaseDrivers) {
                access$400.onUnregistered(jsonRpcPeer);
            }
        }
    }

    public static class ExecuteSQLResponse implements JsonRpcResult {
        @JsonProperty
        public List<String> columnNames;
        @JsonProperty
        public Error sqlError;
        @JsonProperty
        public List<String> values;
    }

    private static class GetDatabaseTableNamesResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<String> tableNames;

        private GetDatabaseTableNamesResponse() {
        }
    }

    public Database() {
        this.mChromePeerManager.setListener(this.mPeerListener);
        this.mObjectMapper = new ObjectMapper();
    }

    public void add(DatabaseDriver databaseDriver) {
        this.mDatabaseDrivers.add(databaseDriver);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mChromePeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mChromePeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDatabaseTableNames(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetDatabaseTableNamesRequest getDatabaseTableNamesRequest = (GetDatabaseTableNamesRequest) this.mObjectMapper.convertValue(jSONObject, GetDatabaseTableNamesRequest.class);
        jSONObject = getDatabasePeer(getDatabaseTableNamesRequest.databaseId);
        try {
            JsonRpcResult getDatabaseTableNamesResponse = new GetDatabaseTableNamesResponse();
            getDatabaseTableNamesResponse.tableNames = jSONObject.getTableNames(getDatabaseTableNamesRequest.databaseId);
            return getDatabaseTableNamesResponse;
        } catch (JsonRpcPeer jsonRpcPeer2) {
            throw new JsonRpcException(new JsonRpcError(ErrorCode.INVALID_REQUEST, jsonRpcPeer2.toString(), null));
        }
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult executeSQL(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ExecuteSQLRequest executeSQLRequest = (ExecuteSQLRequest) this.mObjectMapper.convertValue(jSONObject, ExecuteSQLRequest.class);
        jSONObject = executeSQLRequest.databaseId;
        String str = executeSQLRequest.query;
        try {
            return getDatabasePeer(jSONObject).executeSQL(executeSQLRequest.databaseId, executeSQLRequest.query, new C39661());
        } catch (JsonRpcPeer jsonRpcPeer2) {
            jSONObject = new Error();
            jSONObject.code = 0;
            jSONObject.message = jsonRpcPeer2.getMessage();
            jsonRpcPeer2 = new ExecuteSQLResponse();
            jsonRpcPeer2.sqlError = jSONObject;
            return jsonRpcPeer2;
        }
    }

    private DatabaseDriver getDatabasePeer(String str) {
        for (DatabaseDriver databaseDriver : this.mDatabaseDrivers) {
            List databaseNames = databaseDriver.getDatabaseNames();
            if (databaseNames != null && databaseNames.contains(str)) {
                return databaseDriver;
            }
        }
        return null;
    }

    private static ArrayList<String> flattenRows(Cursor cursor, int i) {
        Util.throwIfNot(i >= 0);
        ArrayList<String> arrayList = new ArrayList();
        int columnCount = cursor.getColumnCount();
        for (int i2 = 0; i2 < i && cursor.moveToNext(); i2++) {
            for (int i3 = 0; i3 < columnCount; i3++) {
                int type = cursor.getType(i3);
                if (type != 4) {
                    switch (type) {
                        case 0:
                            arrayList.add(null);
                            break;
                        case 1:
                            arrayList.add(String.valueOf(cursor.getLong(i3)));
                            break;
                        case 2:
                            arrayList.add(String.valueOf(cursor.getDouble(i3)));
                            break;
                        default:
                            arrayList.add(cursor.getString(i3));
                            break;
                    }
                }
                arrayList.add(blobToString(cursor.getBlob(i3)));
            }
        }
        if (cursor.isAfterLast() == null) {
            for (int i4 = 0; i4 < columnCount; i4++) {
                arrayList.add("{truncated}");
            }
        }
        return arrayList;
    }

    private static java.lang.String blobToString(byte[] r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r2.length;
        r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r0 > r1) goto L_0x0013;
    L_0x0005:
        r0 = fastIsAscii(r2);
        if (r0 == 0) goto L_0x0013;
    L_0x000b:
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r1 = "US-ASCII";	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r0.<init>(r2, r1);	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        return r0;
    L_0x0013:
        r2 = "{blob}";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.protocol.module.Database.blobToString(byte[]):java.lang.String");
    }

    private static boolean fastIsAscii(byte[] bArr) {
        for (byte b : bArr) {
            if ((b & -128) != 0) {
                return false;
            }
        }
        return 1;
    }
}
