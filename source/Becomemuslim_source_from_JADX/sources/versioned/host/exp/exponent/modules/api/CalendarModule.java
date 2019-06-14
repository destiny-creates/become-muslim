package versioned.host.exp.exponent.modules.api;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.provider.CalendarContract.Attendees;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Instances;
import android.provider.CalendarContract.Reminders;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.server.http.HttpStatus;
import expo.modules.contacts.EXColumns;
import host.exp.exponent.p339f.C6330b;
import host.exp.p333a.C6271b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import versioned.host.exp.exponent.modules.ExpoKernelServiceConsumerBaseModule;

public class CalendarModule extends ExpoKernelServiceConsumerBaseModule {
    private static final String TAG = "CalendarModule";
    private ReactContext reactContext;

    public String getName() {
        return "ExponentCalendar";
    }

    public CalendarModule(ReactApplicationContext reactApplicationContext, C6330b c6330b) {
        super(reactApplicationContext, c6330b);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void getCalendarsAsync(String str, final Promise promise) {
        if (isMissingPermissions()) {
            promise.reject("E_CANNOT_GET_CALENDARS", "User rejected permissions required to get calendars.");
        } else if (str == null || str.equals("reminder") == null) {
            try {
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        promise.resolve(CalendarModule.this.findCalendars());
                    }
                });
            } catch (String str2) {
                promise.reject("E_CALENDARS_NOT_FOUND", "Calendars could not be found", str2);
            }
        } else {
            promise.reject("E_CALENDARS_NOT_FOUND", "Calendars of type `reminder` are not supported on Android");
        }
    }

    @ReactMethod
    public void saveCalendarAsync(final ReadableMap readableMap, final Promise promise) {
        if (isMissingPermissions()) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to save the calendar.");
            return;
        }
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    try {
                        promise.resolve(Integer.valueOf(CalendarModule.this.saveCalendar(readableMap)).toString());
                    } catch (Throwable e) {
                        promise.reject("E_CALENDAR_NOT_SAVED", "Calendar could not be saved", e);
                    }
                }
            });
        } catch (ReadableMap readableMap2) {
            promise.reject("E_CALENDAR_NOT_SAVED", "Calendar could not be saved", readableMap2);
        }
    }

    @ReactMethod
    public void deleteCalendarAsync(final String str, final Promise promise) {
        if (isMissingPermissions()) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to delete the calendar.");
            return;
        }
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    if (CalendarModule.this.deleteCalendar(str)) {
                        promise.resolve(null);
                        return;
                    }
                    promise.reject("E_CALENDAR_NOT_DELETED", String.format("Calendar with id %s could not be deleted", new Object[]{str}));
                }
            });
        } catch (Throwable e) {
            promise.reject("E_CALENDAR_NOT_DELETED", String.format("Calendar with id %s could not be deleted", new Object[]{str}), e);
        }
    }

    @ReactMethod
    public void getEventsAsync(Dynamic dynamic, Dynamic dynamic2, ReadableArray readableArray, Promise promise) {
        if (isMissingPermissions()) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to get events.");
            return;
        }
        try {
            final Dynamic dynamic3 = dynamic;
            final Dynamic dynamic4 = dynamic2;
            final ReadableArray readableArray2 = readableArray;
            final Promise promise2 = promise;
            AsyncTask.execute(new Runnable() {
                public void run() {
                    promise2.resolve(CalendarModule.this.findEvents(dynamic3, dynamic4, readableArray2));
                }
            });
        } catch (Dynamic dynamic5) {
            promise.reject("E_EVENTS_NOT_FOUND", "Events could not be found", dynamic5);
        }
    }

    @ReactMethod
    public void getEventByIdAsync(final String str, final Promise promise) {
        if (isMissingPermissions()) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to get the event.");
            return;
        }
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    promise.resolve(CalendarModule.this.findEventById(str));
                }
            });
        } catch (Throwable e) {
            promise.reject("E_EVENT_NOT_FOUND", String.format("Event with id %s could not be found", new Object[]{str}), e);
        }
    }

    @ReactMethod
    public void saveEventAsync(final ReadableMap readableMap, ReadableMap readableMap2, final Promise promise) {
        if (isMissingPermissions() != null) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to save the event.");
            return;
        }
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    try {
                        promise.resolve(Integer.valueOf(CalendarModule.this.saveEvent(readableMap)));
                    } catch (Throwable e) {
                        promise.reject("E_EVENT_NOT_SAVED", "Event could not be saved", e);
                    }
                }
            });
        } catch (ReadableMap readableMap3) {
            promise.reject("E_EVENT_NOT_SAVED", "Event could not be saved", readableMap3);
        }
    }

    @ReactMethod
    public void deleteEventAsync(final ReadableMap readableMap, ReadableMap readableMap2, final Promise promise) {
        if (isMissingPermissions() != null) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to delete the event.");
            return;
        }
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    try {
                        if (CalendarModule.this.removeEvent(readableMap)) {
                            promise.resolve(null);
                            return;
                        }
                        promise.reject("E_EVENT_NOT_DELETED", String.format("Event with id %s could not be deleted", new Object[]{readableMap.getString("id")}));
                    } catch (Throwable e) {
                        promise.reject("E_EVENT_NOT_DELETED", String.format("Event with id %s could not be deleted", new Object[]{readableMap.getString("id")}), e);
                    }
                }
            });
        } catch (ReadableMap readableMap22) {
            promise.reject("E_EVENT_NOT_DELETED", String.format("Event with id %s could not be deleted", new Object[]{readableMap.getString("id")}), readableMap22);
        }
    }

    @ReactMethod
    public void getAttendeesForEventAsync(final String str, final Promise promise) {
        if (isMissingPermissions()) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to get attendees.");
            return;
        }
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    promise.resolve(CalendarModule.this.findAttendeesByEventId(str));
                }
            });
        } catch (Throwable e) {
            promise.reject("E_ATTENDEES_NOT_FOUND", String.format("Attendees for event with id %s could not be found", new Object[]{str}), e);
        }
    }

    @ReactMethod
    public void saveAttendeeForEventAsync(final ReadableMap readableMap, final String str, final Promise promise) {
        if (isMissingPermissions()) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to save the attendee.");
            return;
        }
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    try {
                        promise.resolve(Integer.valueOf(CalendarModule.this.saveAttendeeForEvent(readableMap, str)));
                    } catch (Throwable e) {
                        promise.reject("E_ATTENDEE_NOT_SAVED", String.format("Attendees for event with id %s could not be saved", new Object[]{str}), e);
                    }
                }
            });
        } catch (ReadableMap readableMap2) {
            promise.reject("E_ATTENDEE_NOT_SAVED", String.format("Attendees for event with id %s could not be saved", new Object[]{str}), readableMap2);
        }
    }

    @ReactMethod
    public void deleteAttendeeAsync(final String str, final Promise promise) {
        if (isMissingPermissions()) {
            promise.reject("E_CANNOT_SAVE_CALENDAR", "User rejected permissions required to delete the attendee.");
            return;
        }
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    if (CalendarModule.this.deleteAttendee(str)) {
                        promise.resolve(null);
                        return;
                    }
                    promise.reject("E_ATTENDEE_NOT_DELETED", String.format("Attendee with id %s could not be deleted", new Object[]{str}));
                }
            });
        } catch (Throwable e) {
            promise.reject("E_ATTENDEE_NOT_DELETED", String.format("Attendee with id %s could not be deleted", new Object[]{str}), e);
        }
    }

    @ReactMethod
    public void openEventInCalendar(int i) {
        i = new Intent("android.intent.action.VIEW").addFlags(268435456).setData(ContentUris.withAppendedId(Events.CONTENT_URI, (long) i));
        if (i.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(i);
        }
    }

    private WritableNativeArray findCalendars() {
        return serializeEventCalendars(this.reactContext.getContentResolver().query(Calendars.CONTENT_URI, new String[]{EXColumns.ID, "calendar_displayName", "account_name", "isPrimary", "calendar_access_level", "allowedAvailability", "name", "account_type", "calendar_color", "ownerAccount", "calendar_timezone", "allowedReminders", "allowedAttendeeTypes", ViewProps.VISIBLE, "sync_events"}, null, null, null));
    }

    private WritableNativeArray findEvents(Dynamic dynamic, Dynamic dynamic2, ReadableArray readableArray) {
        CalendarModule calendarModule = this;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        try {
            if (dynamic.getType() == ReadableType.String) {
                instance.setTime(simpleDateFormat.parse(dynamic.asString()));
            } else if (dynamic.getType() == ReadableType.Number) {
                instance.setTimeInMillis((long) dynamic.asDouble());
            }
            if (dynamic2.getType() == ReadableType.String) {
                instance2.setTime(simpleDateFormat.parse(dynamic2.asString()));
            } else if (dynamic2.getType() == ReadableType.Number) {
                instance2.setTimeInMillis((long) dynamic2.asDouble());
            }
        } catch (Throwable e) {
            Log.e(TAG, "error parsing", e);
        } catch (Throwable e2) {
            Log.e(TAG, "misc error parsing", e2);
        }
        ContentResolver contentResolver = calendarModule.reactContext.getContentResolver();
        Builder buildUpon = Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(buildUpon, instance.getTimeInMillis());
        ContentUris.appendId(buildUpon, instance2.getTimeInMillis());
        Uri build = buildUpon.build();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("((begin >= ");
        stringBuilder.append(instance.getTimeInMillis());
        stringBuilder.append(") AND (");
        stringBuilder.append(ViewProps.END);
        stringBuilder.append(" <= ");
        stringBuilder.append(instance2.getTimeInMillis());
        stringBuilder.append(") AND (");
        stringBuilder.append(ViewProps.VISIBLE);
        stringBuilder.append(" = 1) ");
        String stringBuilder2 = stringBuilder.toString();
        if (readableArray.size() > 0) {
            String str = "AND (";
            for (int i = 0; i < readableArray.size(); i++) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append("calendar_id = ");
                stringBuilder3.append(readableArray.getString(i));
                str = stringBuilder3.toString();
                if (i != readableArray.size() - 1) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append(" OR ");
                    str = stringBuilder3.toString();
                }
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str);
            stringBuilder4.append(")");
            str = stringBuilder4.toString();
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(str);
            stringBuilder2 = stringBuilder4.toString();
        }
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(stringBuilder2);
        stringBuilder5.append(")");
        return serializeEvents(contentResolver.query(build, new String[]{"event_id", "title", "description", "begin", ViewProps.END, "allDay", "eventLocation", "rrule", "calendar_id", "availability", "organizer", "eventTimezone", "eventEndTimezone", "accessLevel", "guestsCanModify", "guestsCanInviteOthers", "guestsCanSeeGuests", "original_id", EXColumns.ID}, stringBuilder5.toString(), null, null));
    }

    private WritableNativeMap findEventById(String str) {
        WritableNativeMap serializeEvent;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Cursor query = this.reactContext.getContentResolver().query(ContentUris.withAppendedId(Events.CONTENT_URI, (long) Integer.parseInt(str)), new String[]{EXColumns.ID, "title", "description", "dtstart", "dtend", "allDay", "eventLocation", "rrule", "calendar_id", "availability", "organizer", "eventTimezone", "eventEndTimezone", "accessLevel", "guestsCanModify", "guestsCanInviteOthers", "guestsCanSeeGuests", "original_id"}, "((deleted != 1))", null, null);
        if (query.getCount() > 0) {
            query.moveToFirst();
            serializeEvent = serializeEvent(query);
        } else {
            serializeEvent = null;
        }
        query.close();
        return serializeEvent;
    }

    private WritableNativeMap findCalendarById(String str) {
        WritableNativeMap serializeEventCalendar;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Cursor query = this.reactContext.getContentResolver().query(ContentUris.withAppendedId(Calendars.CONTENT_URI, (long) Integer.parseInt(str)), new String[]{EXColumns.ID, "calendar_displayName", "account_name", "isPrimary", "calendar_access_level", "allowedAvailability", "name", "account_type", "calendar_color", "ownerAccount", "calendar_timezone", "allowedReminders", "allowedAttendeeTypes", ViewProps.VISIBLE, "sync_events"}, null, null, null);
        if (query.getCount() > 0) {
            query.moveToFirst();
            serializeEventCalendar = serializeEventCalendar(query);
        } else {
            serializeEventCalendar = null;
        }
        query.close();
        return serializeEventCalendar;
    }

    private WritableNativeArray findAttendeesByEventId(String str) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        return serializeAttendees(Attendees.query(this.reactContext.getContentResolver(), Long.parseLong(str), new String[]{EXColumns.ID, "attendeeName", "attendeeEmail", "attendeeRelationship", "attendeeType", "attendeeStatus"}));
    }

    private int saveCalendar(ReadableMap readableMap) {
        ContentResolver contentResolver = this.reactContext.getContentResolver();
        ContentValues contentValues = new ContentValues();
        if (readableMap.hasKey("name")) {
            contentValues.put("name", readableMap.getString("name"));
        }
        if (readableMap.hasKey("title")) {
            contentValues.put("calendar_displayName", readableMap.getString("title"));
        }
        if (readableMap.hasKey("isVisible")) {
            contentValues.put(ViewProps.VISIBLE, Integer.valueOf(readableMap.getBoolean("isVisible")));
        }
        if (readableMap.hasKey("isSynced")) {
            contentValues.put("sync_events", Integer.valueOf(readableMap.getBoolean("isSynced")));
        }
        if (readableMap.hasKey("id")) {
            readableMap = Integer.parseInt(readableMap.getString("id"));
            contentResolver.update(ContentUris.withAppendedId(Calendars.CONTENT_URI, (long) readableMap), contentValues, null, null);
            return readableMap;
        } else if (!readableMap.hasKey(ShareConstants.FEED_SOURCE_PARAM)) {
            throw new Exception("new calendars require `source` object");
        } else if (!readableMap.hasKey("name")) {
            throw new Exception("new calendars require `name`");
        } else if (!readableMap.hasKey("title")) {
            throw new Exception("new calendars require `title`");
        } else if (!readableMap.hasKey(ViewProps.COLOR)) {
            throw new Exception("new calendars require `color`");
        } else if (!readableMap.hasKey("accessLevel")) {
            throw new Exception("new calendars require `accessLevel`");
        } else if (readableMap.hasKey("ownerAccount")) {
            ReadableMap map = readableMap.getMap(ShareConstants.FEED_SOURCE_PARAM);
            if (map.hasKey("name")) {
                ReadableArray array;
                Integer[] numArr;
                int i;
                int i2 = 0;
                Boolean valueOf = Boolean.valueOf(false);
                if (map.hasKey("isLocalAccount")) {
                    valueOf = Boolean.valueOf(map.getBoolean("isLocalAccount"));
                }
                if (!map.hasKey("type")) {
                    if (!valueOf.booleanValue()) {
                        throw new Exception("new calendars require a `source` object with a `type`, or `isLocalAccount`: true");
                    }
                }
                contentValues.put("account_name", map.getString("name"));
                contentValues.put("account_type", valueOf.booleanValue() ? "LOCAL" : map.getString("type"));
                contentValues.put("calendar_color", Integer.valueOf(readableMap.getInt(ViewProps.COLOR)));
                contentValues.put("calendar_access_level", calAccessConstantMatchingString(readableMap.getString("accessLevel")));
                contentValues.put("ownerAccount", readableMap.getString("ownerAccount"));
                if (readableMap.hasKey("timeZone")) {
                    contentValues.put("calendar_timezone", readableMap.getString("timeZone"));
                }
                if (readableMap.hasKey("allowedReminders")) {
                    array = readableMap.getArray("allowedReminders");
                    numArr = new Integer[array.size()];
                    for (i = 0; i < array.size(); i++) {
                        numArr[i] = reminderConstantMatchingString(array.getString(i));
                    }
                    contentValues.put("allowedReminders", TextUtils.join(",", numArr));
                }
                if (readableMap.hasKey("allowedAvailabilities")) {
                    array = readableMap.getArray("allowedAvailabilities");
                    numArr = new Integer[array.size()];
                    for (i = 0; i < array.size(); i++) {
                        numArr[i] = availabilityConstantMatchingString(array.getString(i));
                    }
                    contentValues.put("allowedAvailability", TextUtils.join(",", numArr));
                }
                if (readableMap.hasKey("allowedAttendeeTypes")) {
                    readableMap = readableMap.getArray("allowedAttendeeTypes");
                    Integer[] numArr2 = new Integer[readableMap.size()];
                    while (i2 < readableMap.size()) {
                        numArr2[i2] = attendeeTypeConstantMatchingString(readableMap.getString(i2));
                        i2++;
                    }
                    contentValues.put("allowedAttendeeTypes", TextUtils.join(",", numArr2));
                }
                readableMap = Calendars.CONTENT_URI.buildUpon();
                readableMap.appendQueryParameter("caller_is_syncadapter", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                readableMap.appendQueryParameter("account_name", map.getString("name"));
                readableMap.appendQueryParameter("account_type", valueOf.booleanValue() ? "LOCAL" : map.getString("type"));
                return Integer.parseInt(contentResolver.insert(readableMap.build(), contentValues).getLastPathSegment());
            }
            throw new Exception("new calendars require a `source` object with a `name`");
        } else {
            throw new Exception("new calendars require `ownerAccount`");
        }
    }

    private boolean deleteCalendar(String str) {
        return this.reactContext.getContentResolver().delete(ContentUris.withAppendedId(Calendars.CONTENT_URI, (long) Integer.parseInt(str)), null, null) > null ? true : null;
    }

    private int saveEvent(ReadableMap readableMap) {
        Calendar instance;
        ReadableType type;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        ContentResolver contentResolver = this.reactContext.getContentResolver();
        ContentValues contentValues = new ContentValues();
        if (readableMap.hasKey("title")) {
            contentValues.put("title", readableMap.getString("title"));
        }
        if (readableMap.hasKey("notes")) {
            contentValues.put("description", readableMap.getString("notes"));
        }
        if (readableMap.hasKey(PlaceFields.LOCATION)) {
            contentValues.put("eventLocation", readableMap.getString(PlaceFields.LOCATION));
        }
        if (readableMap.hasKey("startDate")) {
            instance = Calendar.getInstance();
            type = readableMap.getType("startDate");
            try {
                if (type == ReadableType.String) {
                    instance.setTime(simpleDateFormat.parse(readableMap.getString("startDate")));
                    contentValues.put("dtstart", Long.valueOf(instance.getTimeInMillis()));
                } else if (type == ReadableType.Number) {
                    contentValues.put("dtstart", Long.valueOf((long) readableMap.getDouble("startDate")));
                }
            } catch (ReadableMap readableMap2) {
                Log.e(TAG, "error", readableMap2);
                throw readableMap2;
            }
        }
        if (readableMap2.hasKey("endDate")) {
            instance = Calendar.getInstance();
            type = readableMap2.getType("endDate");
            try {
                if (type == ReadableType.String) {
                    instance.setTime(simpleDateFormat.parse(readableMap2.getString("endDate")));
                    contentValues.put("dtend", Long.valueOf(instance.getTimeInMillis()));
                } else if (type == ReadableType.Number) {
                    contentValues.put("dtend", Long.valueOf((long) readableMap2.getDouble("endDate")));
                }
            } catch (ReadableMap readableMap22) {
                Log.e(TAG, "error", readableMap22);
                throw readableMap22;
            }
        }
        if (readableMap22.hasKey("recurrenceRule")) {
            ReadableMap map = readableMap22.getMap("recurrenceRule");
            if (map.hasKey("frequency")) {
                String format;
                String string = map.getString("frequency");
                Integer valueOf = map.hasKey("interval") ? Integer.valueOf(map.getInt("interval")) : null;
                Integer valueOf2 = map.hasKey("occurrence") ? Integer.valueOf(map.getInt("occurrence")) : null;
                if (map.hasKey("endDate")) {
                    ReadableType type2 = map.getType("endDate");
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
                    if (type2 == ReadableType.String) {
                        format = simpleDateFormat2.format(simpleDateFormat.parse(map.getString("endDate")));
                    } else if (type2 == ReadableType.Number) {
                        Calendar instance2 = Calendar.getInstance();
                        instance2.setTimeInMillis((long) map.getDouble("endDate"));
                        format = simpleDateFormat2.format(instance2.getTime());
                    }
                    format = createRecurrenceRule(string, valueOf, format, valueOf2);
                    if (format != null) {
                        contentValues.put("rrule", format);
                    }
                }
                format = null;
                format = createRecurrenceRule(string, valueOf, format, valueOf2);
                if (format != null) {
                    contentValues.put("rrule", format);
                }
            }
        }
        if (readableMap22.hasKey("allDay")) {
            contentValues.put("allDay", Integer.valueOf(readableMap22.getBoolean("allDay")));
        }
        if (readableMap22.hasKey("alarms")) {
            contentValues.put("hasAlarm", Boolean.valueOf(true));
        }
        if (readableMap22.hasKey("availability")) {
            contentValues.put("availability", availabilityConstantMatchingString(readableMap22.getString("availability")));
        }
        if (readableMap22.hasKey("organizer_email")) {
            contentValues.put("organizer", readableMap22.getString("organizerEmail"));
        }
        if (readableMap22.hasKey("timeZone")) {
            contentValues.put("eventTimezone", readableMap22.getString("timeZone"));
        }
        if (readableMap22.hasKey("endTimeZone")) {
            contentValues.put("eventEndTimezone", readableMap22.getString("endTimeZone"));
        }
        if (readableMap22.hasKey("accessLevel")) {
            contentValues.put("accessLevel", accessConstantMatchingString(readableMap22.getString("accessLevel")));
        }
        if (readableMap22.hasKey("guestsCanModify")) {
            contentValues.put("guestsCanModify", Integer.valueOf(readableMap22.getBoolean("guestsCanModify")));
        }
        if (readableMap22.hasKey("guestsCanInviteOthers")) {
            contentValues.put("guestsCanInviteOthers", Integer.valueOf(readableMap22.getBoolean("guestsCanInviteOthers")));
        }
        if (readableMap22.hasKey("guestsCanSeeGuests")) {
            contentValues.put("guestsCanSeeGuests", Integer.valueOf(readableMap22.getBoolean("guestsCanSeeGuests")));
        }
        int parseInt;
        if (readableMap22.hasKey("id")) {
            parseInt = Integer.parseInt(readableMap22.getString("id"));
            contentResolver.update(ContentUris.withAppendedId(Events.CONTENT_URI, (long) parseInt), contentValues, null, null);
            removeRemindersForEvent(contentResolver, parseInt);
            if (readableMap22.hasKey("alarms")) {
                createRemindersForEvent(contentResolver, parseInt, readableMap22.getArray("alarms"));
            }
            return parseInt;
        }
        if (readableMap22.hasKey("calendarId")) {
            WritableNativeMap findCalendarById = findCalendarById(readableMap22.getString("calendarId"));
            if (findCalendarById != null) {
                contentValues.put("calendar_id", Integer.valueOf(Integer.parseInt(findCalendarById.getString("id"))));
            } else {
                contentValues.put("calendar_id", Integer.valueOf(1));
            }
        } else {
            contentValues.put("calendar_id", Integer.valueOf(1));
        }
        parseInt = Integer.parseInt(contentResolver.insert(Events.CONTENT_URI, contentValues).getLastPathSegment());
        if (readableMap22.hasKey("alarms")) {
            createRemindersForEvent(contentResolver, parseInt, readableMap22.getArray("alarms"));
        }
        return parseInt;
    }

    private boolean removeEvent(ReadableMap readableMap) {
        Integer valueOf = Integer.valueOf(Integer.parseInt(readableMap.getString("id")));
        ContentResolver contentResolver = this.reactContext.getContentResolver();
        boolean z = true;
        if (readableMap.hasKey("instanceStartDate")) {
            ContentValues contentValues = new ContentValues();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Calendar instance = Calendar.getInstance();
            ReadableType type = readableMap.getType("instanceStartDate");
            try {
                if (type == ReadableType.String) {
                    instance.setTime(simpleDateFormat.parse(readableMap.getString("instanceStartDate")));
                    contentValues.put("originalInstanceTime", Long.valueOf(instance.getTimeInMillis()));
                } else if (type == ReadableType.Number) {
                    contentValues.put("originalInstanceTime", Long.valueOf((long) readableMap.getDouble("instanceStartDate")));
                }
                contentValues.put("eventStatus", Integer.valueOf(2));
                contentResolver.insert(ContentUris.withAppendedId(Events.CONTENT_EXCEPTION_URI, (long) valueOf.intValue()), contentValues);
                return true;
            } catch (ReadableMap readableMap2) {
                Log.e(TAG, "error", readableMap2);
                throw readableMap2;
            }
        }
        if (contentResolver.delete(ContentUris.withAppendedId(Events.CONTENT_URI, (long) valueOf.intValue()), null, null) <= null) {
            z = false;
        }
        return z;
    }

    private int saveAttendeeForEvent(ReadableMap readableMap, String str) {
        ContentResolver contentResolver = this.reactContext.getContentResolver();
        ContentValues contentValues = new ContentValues();
        int hasKey = readableMap.hasKey("id") ^ 1;
        if (readableMap.hasKey("name")) {
            contentValues.put("attendeeName", readableMap.getString("name"));
        }
        if (readableMap.hasKey("email")) {
            contentValues.put("attendeeEmail", readableMap.getString("email"));
        } else if (hasKey != 0) {
            throw new Exception("new attendees require `email`");
        }
        if (readableMap.hasKey("role")) {
            contentValues.put("attendeeRelationship", attendeeRelationshipConstantMatchingString(readableMap.getString("role")));
        } else if (hasKey != 0) {
            throw new Exception("new attendees require `role`");
        }
        if (readableMap.hasKey("type")) {
            contentValues.put("attendeeType", attendeeTypeConstantMatchingString(readableMap.getString("type")));
        } else if (hasKey != 0) {
            throw new Exception("new attendees require `type`");
        }
        if (readableMap.hasKey(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
            contentValues.put("attendeeStatus", attendeeStatusConstantMatchingString(readableMap.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)));
        } else if (hasKey != 0) {
            throw new Exception("new attendees require `status`");
        }
        if (hasKey != 0) {
            contentValues.put("event_id", Integer.valueOf(Integer.parseInt(str)));
            return Integer.parseInt(contentResolver.insert(Attendees.CONTENT_URI, contentValues).getLastPathSegment());
        }
        readableMap = Integer.parseInt(readableMap.getString("id"));
        contentResolver.update(ContentUris.withAppendedId(Attendees.CONTENT_URI, (long) readableMap), contentValues, null, null);
        return readableMap;
    }

    private boolean deleteAttendee(String str) {
        return this.reactContext.getContentResolver().delete(ContentUris.withAppendedId(Attendees.CONTENT_URI, (long) Integer.parseInt(str)), null, null) > null ? true : null;
    }

    private void createRemindersForEvent(ContentResolver contentResolver, int i, ReadableArray readableArray) {
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            if (map.getType("relativeOffset") == ReadableType.Number) {
                int i3 = -map.getInt("relativeOffset");
                ContentValues contentValues = new ContentValues();
                int intValue = map.hasKey("method") ? reminderConstantMatchingString(map.getString("method")).intValue() : 0;
                contentValues.put("event_id", Integer.valueOf(i));
                contentValues.put("minutes", Integer.valueOf(i3));
                contentValues.put("method", Integer.valueOf(intValue));
                contentResolver.insert(Reminders.CONTENT_URI, contentValues);
            }
        }
    }

    private void removeRemindersForEvent(ContentResolver contentResolver, int i) {
        i = Reminders.query(contentResolver, (long) i, new String[]{EXColumns.ID});
        while (i.moveToNext()) {
            contentResolver.delete(ContentUris.withAppendedId(Reminders.CONTENT_URI, i.getLong(0)), null, null);
        }
    }

    private String reminderStringMatchingConstant(Integer num) {
        switch (num.intValue()) {
            case 1:
                return "alert";
            case 2:
                return "email";
            case 3:
                return "sms";
            case 4:
                return "alarm";
            default:
                return "default";
        }
    }

    private Integer reminderConstantMatchingString(String str) {
        if (str.equals("alert")) {
            return Integer.valueOf(1);
        }
        if (str.equals("alarm")) {
            return Integer.valueOf(4);
        }
        if (str.equals("email")) {
            return Integer.valueOf(2);
        }
        if (str.equals("sms") != null) {
            return Integer.valueOf(3);
        }
        return Integer.valueOf(null);
    }

    private WritableNativeArray calendarAllowedRemindersFromDBString(String str) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (String parseInt : str.split(",")) {
            writableNativeArray.pushString(reminderStringMatchingConstant(Integer.valueOf(Integer.parseInt(parseInt))));
        }
        return writableNativeArray;
    }

    private WritableNativeArray calendarAllowedAvailabilitiesFromDBString(String str) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (String parseInt : str.split(",")) {
            switch (Integer.parseInt(parseInt)) {
                case 0:
                    writableNativeArray.pushString("busy");
                    break;
                case 1:
                    writableNativeArray.pushString("free");
                    break;
                case 2:
                    writableNativeArray.pushString("tentative");
                    break;
                default:
                    break;
            }
        }
        return writableNativeArray;
    }

    private String availabilityStringMatchingConstant(Integer num) {
        switch (num.intValue()) {
            case 1:
                return "free";
            case 2:
                return "tentative";
            default:
                return "busy";
        }
    }

    private Integer availabilityConstantMatchingString(String str) {
        if (str.equals("free")) {
            return Integer.valueOf(1);
        }
        if (str.equals("tentative") != null) {
            return Integer.valueOf(2);
        }
        return Integer.valueOf(null);
    }

    private String accessStringMatchingConstant(Integer num) {
        switch (num.intValue()) {
            case 1:
                return "confidential";
            case 2:
                return "private";
            case 3:
                return "public";
            default:
                return "default";
        }
    }

    private Integer accessConstantMatchingString(String str) {
        if (str.equals("confidential")) {
            return Integer.valueOf(1);
        }
        if (str.equals("private")) {
            return Integer.valueOf(2);
        }
        if (str.equals("public") != null) {
            return Integer.valueOf(3);
        }
        return Integer.valueOf(null);
    }

    private String calAccessStringMatchingConstant(Integer num) {
        num = num.intValue();
        if (num == 100) {
            return "freebusy";
        }
        if (num == 200) {
            return "read";
        }
        if (num == 300) {
            return "respond";
        }
        if (num == 400) {
            return "override";
        }
        if (num == 500) {
            return "contributor";
        }
        if (num == 600) {
            return "editor";
        }
        if (num != 700) {
            return num != 800 ? ViewProps.NONE : "root";
        } else {
            return "owner";
        }
    }

    private Integer calAccessConstantMatchingString(String str) {
        if (str.equals("contributor")) {
            return Integer.valueOf(HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        }
        if (str.equals("editor")) {
            return Integer.valueOf(600);
        }
        if (str.equals("freebusy")) {
            return Integer.valueOf(100);
        }
        if (str.equals("override")) {
            return Integer.valueOf(400);
        }
        if (str.equals("owner")) {
            return Integer.valueOf(700);
        }
        if (str.equals("read")) {
            return Integer.valueOf(HttpStatus.HTTP_OK);
        }
        if (str.equals("respond")) {
            return Integer.valueOf(300);
        }
        if (str.equals("root") != null) {
            return Integer.valueOf(800);
        }
        return Integer.valueOf(null);
    }

    private String attendeeRelationshipStringMatchingConstant(Integer num) {
        switch (num.intValue()) {
            case 1:
                return "attendee";
            case 2:
                return "organizer";
            case 3:
                return "performer";
            case 4:
                return "speaker";
            default:
                return ViewProps.NONE;
        }
    }

    private Integer attendeeRelationshipConstantMatchingString(String str) {
        if (str.equals("attendee")) {
            return Integer.valueOf(1);
        }
        if (str.equals("organizer")) {
            return Integer.valueOf(2);
        }
        if (str.equals("performer")) {
            return Integer.valueOf(3);
        }
        if (str.equals("speaker") != null) {
            return Integer.valueOf(4);
        }
        return Integer.valueOf(null);
    }

    private String attendeeTypeStringMatchingConstant(Integer num) {
        switch (num.intValue()) {
            case 1:
                return "required";
            case 2:
                return "optional";
            case 3:
                return "resource";
            default:
                return ViewProps.NONE;
        }
    }

    private Integer attendeeTypeConstantMatchingString(String str) {
        if (str.equals("optional")) {
            return Integer.valueOf(2);
        }
        if (str.equals("required")) {
            return Integer.valueOf(1);
        }
        if (str.equals("resource") != null) {
            return Integer.valueOf(3);
        }
        return Integer.valueOf(null);
    }

    private WritableNativeArray calendarAllowedAttendeeTypesFromDBString(String str) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (String parseInt : str.split(",")) {
            writableNativeArray.pushString(attendeeTypeStringMatchingConstant(Integer.valueOf(Integer.parseInt(parseInt))));
        }
        return writableNativeArray;
    }

    private String attendeeStatusStringMatchingConstant(Integer num) {
        switch (num.intValue()) {
            case 1:
                return "accepted";
            case 2:
                return "declined";
            case 3:
                return "invited";
            case 4:
                return "tentative";
            default:
                return ViewProps.NONE;
        }
    }

    private Integer attendeeStatusConstantMatchingString(String str) {
        if (str.equals("accepted")) {
            return Integer.valueOf(1);
        }
        if (str.equals("declined")) {
            return Integer.valueOf(2);
        }
        if (str.equals("invited")) {
            return Integer.valueOf(3);
        }
        if (str.equals("tentative") != null) {
            return Integer.valueOf(4);
        }
        return Integer.valueOf(null);
    }

    private String createRecurrenceRule(String str, Integer num, String str2, Integer num2) {
        if (str.equals("daily")) {
            str = "FREQ=DAILY";
        } else if (str.equals("weekly")) {
            str = "FREQ=WEEKLY";
        } else if (str.equals("monthly")) {
            str = "FREQ=MONTHLY";
        } else if (str.equals("yearly") == null) {
            return null;
        } else {
            str = "FREQ=YEARLY";
        }
        if (num != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(";INTERVAL=");
            stringBuilder.append(num);
            str = stringBuilder.toString();
        }
        if (str2 != null) {
            num = new StringBuilder();
            num.append(str);
            num.append(";UNTIL=");
            num.append(str2);
            str = num.toString();
        } else if (num2 != null) {
            num = new StringBuilder();
            num.append(str);
            num.append(";COUNT=");
            num.append(num2);
            str = num.toString();
        }
        return str;
    }

    private WritableNativeArray serializeEvents(Cursor cursor) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        while (cursor.moveToNext()) {
            writableNativeArray.pushMap(serializeEvent(cursor));
        }
        cursor.close();
        return writableNativeArray;
    }

    private WritableNativeMap serializeEvent(Cursor cursor) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        String str = "";
        String str2 = "";
        String string = cursor.getString(3);
        if (string != null) {
            instance.setTimeInMillis(Long.parseLong(string));
            str = simpleDateFormat.format(instance.getTime());
        }
        String string2 = cursor.getString(4);
        if (string2 != null) {
            instance2.setTimeInMillis(Long.parseLong(string2));
            str2 = simpleDateFormat.format(instance2.getTime());
        }
        string2 = optStringFromCursor(cursor, "rrule");
        boolean z = true;
        if (string2 != null) {
            WritableMap writableNativeMap2 = new WritableNativeMap();
            String[] split = string2.split(";");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
            writableNativeMap2.putString("frequency", split[0].split("=")[1].toLowerCase());
            if (split.length >= 2 && split[1].split("=")[0].equals("INTERVAL")) {
                writableNativeMap2.putInt("interval", Integer.parseInt(split[1].split("=")[1]));
            }
            if (split.length >= 3) {
                if (split[2].split("=")[0].equals("UNTIL")) {
                    try {
                        writableNativeMap2.putString("endDate", simpleDateFormat.format(simpleDateFormat2.parse(split[2].split("=")[1])));
                    } catch (Throwable e) {
                        Log.e(TAG, "error", e);
                    }
                } else if (split[2].split("=")[0].equals("COUNT")) {
                    writableNativeMap2.putInt("occurrence", Integer.parseInt(split[2].split("=")[1]));
                }
            }
            writableNativeMap.putMap("recurrenceRule", writableNativeMap2);
        }
        writableNativeMap.putString("id", cursor.getString(0));
        writableNativeMap.putString("calendarId", optStringFromCursor(cursor, "calendar_id"));
        writableNativeMap.putString("title", optStringFromCursor(cursor, "title"));
        writableNativeMap.putString("notes", optStringFromCursor(cursor, "description"));
        writableNativeMap.putString("startDate", str);
        writableNativeMap.putString("endDate", str2);
        writableNativeMap.putBoolean("allDay", optIntFromCursor(cursor, "allDay") != 0);
        writableNativeMap.putString(PlaceFields.LOCATION, optStringFromCursor(cursor, "eventLocation"));
        writableNativeMap.putString("availability", availabilityStringMatchingConstant(Integer.valueOf(optIntFromCursor(cursor, "availability"))));
        writableNativeMap.putArray("alarms", serializeAlarms(cursor.getLong(0)));
        writableNativeMap.putString("organizerEmail", optStringFromCursor(cursor, "organizer"));
        writableNativeMap.putString("timeZone", optStringFromCursor(cursor, "eventTimezone"));
        writableNativeMap.putString("endTimeZone", optStringFromCursor(cursor, "eventEndTimezone"));
        writableNativeMap.putString("accessLevel", accessStringMatchingConstant(Integer.valueOf(optIntFromCursor(cursor, "accessLevel"))));
        writableNativeMap.putBoolean("guestsCanModify", optIntFromCursor(cursor, "guestsCanModify") != 0);
        writableNativeMap.putBoolean("guestsCanInviteOthers", optIntFromCursor(cursor, "guestsCanInviteOthers") != 0);
        string2 = "guestsCanSeeGuests";
        if (optIntFromCursor(cursor, "guestsCanSeeGuests") == 0) {
            z = false;
        }
        writableNativeMap.putBoolean(string2, z);
        writableNativeMap.putString("originalId", optStringFromCursor(cursor, "original_id"));
        if (cursor.getColumnCount() > 18) {
            writableNativeMap.putString("instanceId", cursor.getString(18));
        }
        return writableNativeMap;
    }

    private WritableNativeArray serializeAlarms(long j) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        j = Reminders.query(this.reactContext.getContentResolver(), j, new String[]{"minutes", "method"});
        while (j.moveToNext()) {
            WritableMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt("relativeOffset", -j.getInt(0));
            writableNativeMap.putString("method", reminderStringMatchingConstant(Integer.valueOf(j.getInt(1))));
            writableNativeArray.pushMap(writableNativeMap);
        }
        return writableNativeArray;
    }

    private WritableNativeArray serializeEventCalendars(Cursor cursor) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        while (cursor.moveToNext()) {
            writableNativeArray.pushMap(serializeEventCalendar(cursor));
        }
        cursor.close();
        return writableNativeArray;
    }

    private WritableNativeMap serializeEventCalendar(Cursor cursor) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("id", optStringFromCursor(cursor, EXColumns.ID));
        writableNativeMap.putString("title", optStringFromCursor(cursor, "calendar_displayName"));
        writableNativeMap.putBoolean("isPrimary", optStringFromCursor(cursor, "isPrimary") == AppEventsConstants.EVENT_PARAM_VALUE_YES);
        writableNativeMap.putArray("allowedAvailabilities", calendarAllowedAvailabilitiesFromDBString(optStringFromCursor(cursor, "allowedAvailability")));
        writableNativeMap.putString("name", optStringFromCursor(cursor, "name"));
        writableNativeMap.putString(ViewProps.COLOR, String.format("#%06X", new Object[]{Integer.valueOf(16777215 & optIntFromCursor(cursor, "calendar_color"))}));
        writableNativeMap.putString("ownerAccount", optStringFromCursor(cursor, "ownerAccount"));
        writableNativeMap.putString("timeZone", optStringFromCursor(cursor, "calendar_timezone"));
        writableNativeMap.putArray("allowedReminders", calendarAllowedRemindersFromDBString(optStringFromCursor(cursor, "allowedReminders")));
        writableNativeMap.putArray("allowedAttendeeTypes", calendarAllowedAttendeeTypesFromDBString(optStringFromCursor(cursor, "allowedAttendeeTypes")));
        writableNativeMap.putBoolean("isVisible", optIntFromCursor(cursor, ViewProps.VISIBLE) != 0);
        writableNativeMap.putBoolean("isSynced", optIntFromCursor(cursor, "sync_events") != 0);
        WritableMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putString("name", optStringFromCursor(cursor, "account_name"));
        String optStringFromCursor = optStringFromCursor(cursor, "account_type");
        writableNativeMap2.putString("type", optStringFromCursor);
        writableNativeMap2.putBoolean("isLocalAccount", optStringFromCursor.equals("LOCAL"));
        writableNativeMap.putMap(ShareConstants.FEED_SOURCE_PARAM, writableNativeMap2);
        cursor = optIntFromCursor(cursor, "calendar_access_level");
        writableNativeMap.putString("accessLevel", calAccessStringMatchingConstant(Integer.valueOf(cursor)));
        if (!(cursor == 800 || cursor == 700 || cursor == 600)) {
            if (cursor != 500) {
                writableNativeMap.putBoolean("allowsModifications", false);
                return writableNativeMap;
            }
        }
        writableNativeMap.putBoolean("allowsModifications", true);
        return writableNativeMap;
    }

    private WritableNativeArray serializeAttendees(Cursor cursor) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        while (cursor.moveToNext()) {
            writableNativeArray.pushMap(serializeAttendee(cursor));
        }
        cursor.close();
        return writableNativeArray;
    }

    private WritableNativeMap serializeAttendee(Cursor cursor) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("id", optStringFromCursor(cursor, EXColumns.ID));
        writableNativeMap.putString("name", optStringFromCursor(cursor, "attendeeName"));
        writableNativeMap.putString("email", optStringFromCursor(cursor, "attendeeEmail"));
        writableNativeMap.putString("role", attendeeRelationshipStringMatchingConstant(Integer.valueOf(optIntFromCursor(cursor, "attendeeRelationship"))));
        writableNativeMap.putString("type", attendeeTypeStringMatchingConstant(Integer.valueOf(optIntFromCursor(cursor, "attendeeType"))));
        writableNativeMap.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, attendeeStatusStringMatchingConstant(Integer.valueOf(optIntFromCursor(cursor, "attendeeStatus"))));
        return writableNativeMap;
    }

    private String optStringFromCursor(Cursor cursor, String str) {
        str = cursor.getColumnIndex(str);
        if (str == -1) {
            return null;
        }
        return cursor.getString(str);
    }

    private int optIntFromCursor(Cursor cursor, String str) {
        str = cursor.getColumnIndex(str);
        if (str == -1) {
            return null;
        }
        return cursor.getInt(str);
    }

    private boolean isMissingPermissions() {
        return (C6271b.m25897a().m25916a("android.permission.READ_CALENDAR", this.experienceId) || C6271b.m25897a().m25916a("android.permission.WRITE_CALENDAR", this.experienceId)) ? false : true;
    }
}
