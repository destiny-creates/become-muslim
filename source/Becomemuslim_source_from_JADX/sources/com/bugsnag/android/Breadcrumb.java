package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class Breadcrumb implements C1071a {
    private static final String DEFAULT_NAME = "manual";
    private static final int MAX_MESSAGE_LENGTH = 140;
    private static final String MESSAGE_METAKEY = "message";
    private static final String METADATA_KEY = "metaData";
    private static final String NAME_KEY = "name";
    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String TYPE_KEY = "type";
    private final Map<String, String> metadata;
    private final String name;
    private final String timestamp;
    private final BreadcrumbType type;

    Breadcrumb(String str) {
        this(DEFAULT_NAME, BreadcrumbType.MANUAL, Collections.singletonMap("message", str.substring(0, Math.min(str.length(), MAX_MESSAGE_LENGTH))));
    }

    Breadcrumb(String str, BreadcrumbType breadcrumbType, Map<String, String> map) {
        this.timestamp = C1093m.m3874a(new Date());
        this.type = breadcrumbType;
        this.metadata = map;
        this.name = str;
    }

    Breadcrumb(String str, BreadcrumbType breadcrumbType, Date date, Map<String, String> map) {
        this.timestamp = C1093m.m3874a(date);
        this.type = breadcrumbType;
        this.metadata = map;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public BreadcrumbType getType() {
        return this.type;
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void toStream(ab abVar) {
        abVar.mo772c();
        abVar.mo764a(TIMESTAMP_KEY).mo771b(this.timestamp);
        abVar.mo764a("name").mo771b(this.name);
        abVar.mo764a("type").mo771b(this.type.toString());
        abVar.mo764a(METADATA_KEY);
        abVar.mo772c();
        List<String> arrayList = new ArrayList(this.metadata.keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        for (String str : arrayList) {
            abVar.mo764a(str).mo771b((String) this.metadata.get(str));
        }
        abVar.mo770b();
        abVar.mo770b();
    }

    int payloadSize() {
        Writer stringWriter = new StringWriter();
        toStream(new ab(stringWriter));
        return stringWriter.toString().length();
    }
}
