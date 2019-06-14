package com.facebook.stetho.inspector.database;

import android.content.Context;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver.ExecuteResultHandler;
import com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse;
import java.util.ArrayList;
import java.util.List;

public class ContentProviderDatabaseDriver extends DatabaseDriver {
    private static final String sDatabaseName = "content-providers";
    private final ContentProviderSchema[] mContentProviderSchemas;
    private List<String> mDatabaseNames;
    private List<String> mTableNames;

    public ContentProviderDatabaseDriver(Context context, ContentProviderSchema... contentProviderSchemaArr) {
        super(context);
        this.mContentProviderSchemas = contentProviderSchemaArr;
    }

    public List<String> getDatabaseNames() {
        if (this.mDatabaseNames == null && this.mContentProviderSchemas != null) {
            this.mDatabaseNames = new ArrayList();
            this.mDatabaseNames.add(sDatabaseName);
        }
        return this.mDatabaseNames;
    }

    public List<String> getTableNames(String str) {
        if (this.mTableNames == null) {
            this.mTableNames = new ArrayList();
            for (ContentProviderSchema tableName : this.mContentProviderSchemas) {
                this.mTableNames.add(tableName.getTableName());
            }
        }
        return this.mTableNames;
    }

    public ExecuteSQLResponse executeSQL(String str, String str2, ExecuteResultHandler<ExecuteSQLResponse> executeResultHandler) {
        str = this.mContentProviderSchemas[this.mTableNames.indexOf(fetchTableName(str2))];
        str = this.mContext.getContentResolver().query(str.getUri(), str.getProjection(), null, null, null);
        try {
            ExecuteSQLResponse executeSQLResponse = (ExecuteSQLResponse) executeResultHandler.handleSelect(str);
            return executeSQLResponse;
        } finally {
            str.close();
        }
    }

    private String fetchTableName(String str) {
        for (String str2 : this.mTableNames) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }
}
