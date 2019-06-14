package com.facebook.stetho.json;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ObjectMapper {
    private final Map<Class<?>, Method> mJsonValueMethodCache = new IdentityHashMap();

    public <T> T convertValue(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls != Object.class && cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        try {
            if (obj instanceof JSONObject) {
                return _convertFromJSONObject((JSONObject) obj, cls);
            }
            if (cls == JSONObject.class) {
                return _convertToJSONObject(obj);
            }
            throw new IllegalArgumentException("Expecting either fromValue or toValueType to be a JSONObject");
        } catch (Object obj2) {
            throw new IllegalArgumentException(obj2);
        } catch (Object obj22) {
            throw new IllegalArgumentException(obj22);
        } catch (Object obj222) {
            throw new IllegalArgumentException(obj222);
        } catch (Object obj2222) {
            throw new IllegalArgumentException(obj2222);
        } catch (Object obj22222) {
            throw ExceptionUtil.propagate(obj22222.getCause());
        }
    }

    private <T> T _convertFromJSONObject(JSONObject jSONObject, Class<T> cls) {
        Constructor declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
        declaredConstructor.setAccessible(true);
        int i = 0;
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        Field[] fields = cls.getFields();
        while (i < fields.length) {
            Field field = fields[i];
            Object valueForField = getValueForField(field, jSONObject.opt(field.getName()));
            try {
                field.set(newInstance, valueForField);
                i++;
            } catch (JSONObject jSONObject2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Class: ");
                stringBuilder.append(cls.getSimpleName());
                stringBuilder.append(" ");
                stringBuilder.append("Field: ");
                stringBuilder.append(field.getName());
                stringBuilder.append(" type ");
                stringBuilder.append(valueForField.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString(), jSONObject2);
            }
        }
        return newInstance;
    }

    private Object getValueForField(Field field, Object obj) {
        if (obj != null) {
            StringBuilder stringBuilder;
            try {
                if (obj == JSONObject.NULL) {
                    return null;
                }
                if (obj.getClass() == field.getType()) {
                    return obj;
                }
                if (obj instanceof JSONObject) {
                    return convertValue(obj, field.getType());
                }
                if (field.getType().isEnum()) {
                    return getEnumValue((String) obj, field.getType().asSubclass(Enum.class));
                }
                if (obj instanceof JSONArray) {
                    return convertArrayToList(field, (JSONArray) obj);
                }
                if (obj instanceof Number) {
                    Number number = (Number) obj;
                    Class type = field.getType();
                    if (type != Integer.class) {
                        if (type != Integer.TYPE) {
                            if (type != Long.class) {
                                if (type != Long.TYPE) {
                                    if (type != Double.class) {
                                        if (type != Double.TYPE) {
                                            if (type != Float.class) {
                                                if (type != Float.TYPE) {
                                                    if (type != Byte.class) {
                                                        if (type != Byte.TYPE) {
                                                            if (type != Short.class) {
                                                                if (type != Short.TYPE) {
                                                                    stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("Not setup to handle class ");
                                                                    stringBuilder.append(type.getName());
                                                                    throw new IllegalArgumentException(stringBuilder.toString());
                                                                }
                                                            }
                                                            return Short.valueOf(number.shortValue());
                                                        }
                                                    }
                                                    return Byte.valueOf(number.byteValue());
                                                }
                                            }
                                            return Float.valueOf(number.floatValue());
                                        }
                                    }
                                    return Double.valueOf(number.doubleValue());
                                }
                            }
                            return Long.valueOf(number.longValue());
                        }
                    }
                    return Integer.valueOf(number.intValue());
                }
            } catch (Object obj2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to set value for field ");
                stringBuilder.append(field.getName());
                throw new IllegalArgumentException(stringBuilder.toString(), obj2);
            }
        }
        return obj2;
    }

    private Enum getEnumValue(String str, Class<? extends Enum> cls) {
        Method jsonValueMethod = getJsonValueMethod(cls);
        if (jsonValueMethod != null) {
            return getEnumByMethod(str, cls, jsonValueMethod);
        }
        return Enum.valueOf(cls, str);
    }

    private Enum getEnumByMethod(String str, Class<? extends Enum> cls, Method method) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int i = 0;
        while (i < enumArr.length) {
            Enum enumR = enumArr[i];
            try {
                Object invoke = method.invoke(enumR, new Object[0]);
                if (invoke != null && invoke.toString().equals(str)) {
                    return enumR;
                }
                i++;
            } catch (String str2) {
                throw new IllegalArgumentException(str2);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No enum constant ");
        stringBuilder.append(cls.getName());
        stringBuilder.append(".");
        stringBuilder.append(str2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private List<Object> convertArrayToList(Field field, JSONArray jSONArray) {
        if (List.class.isAssignableFrom(field.getType())) {
            Type[] actualTypeArguments = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                field = null;
                Class cls = (Class) actualTypeArguments[0];
                List<Object> arrayList = new ArrayList();
                while (field < jSONArray.length()) {
                    if (cls.isEnum()) {
                        arrayList.add(getEnumValue(jSONArray.getString(field), cls));
                    } else if (canDirectlySerializeClass(cls)) {
                        arrayList.add(jSONArray.get(field));
                    } else {
                        JSONObject jSONObject = jSONArray.getJSONObject(field);
                        if (jSONObject == null) {
                            arrayList.add(null);
                        } else {
                            arrayList.add(convertValue(jSONObject, cls));
                        }
                    }
                    field++;
                }
                return arrayList;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Only able to handle a single type in a list ");
            stringBuilder.append(field.getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("only know how to deserialize List<?> on field ");
        stringBuilder.append(field.getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private JSONObject _convertToJSONObject(Object obj) {
        JSONObject jSONObject = new JSONObject();
        Field[] fields = obj.getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            JsonProperty jsonProperty = (JsonProperty) fields[i].getAnnotation(JsonProperty.class);
            if (jsonProperty != null) {
                Object obj2 = fields[i].get(obj);
                Class type = fields[i].getType();
                if (obj2 != null) {
                    type = obj2.getClass();
                }
                String name = fields[i].getName();
                if (jsonProperty.required() && obj2 == null) {
                    obj2 = JSONObject.NULL;
                } else if (obj2 != JSONObject.NULL) {
                    obj2 = getJsonValue(obj2, type, fields[i]);
                }
                jSONObject.put(name, obj2);
            }
        }
        return jSONObject;
    }

    private Object getJsonValue(Object obj, Class<?> cls, Field field) {
        if (obj == null) {
            return null;
        }
        if (List.class.isAssignableFrom(cls) != null) {
            return convertListToJsonArray(obj);
        }
        field = getJsonValueMethod(cls);
        if (field != null) {
            return field.invoke(obj, new Object[null]);
        }
        if (canDirectlySerializeClass(cls) == null) {
            return convertValue(obj, JSONObject.class);
        }
        if (!(cls.equals(Double.class) == null && cls.equals(Float.class) == null)) {
            cls = ((Number) obj).doubleValue();
            if (Double.isNaN(cls)) {
                return "NaN";
            }
            if (cls == Double.POSITIVE_INFINITY) {
                return "Infinity";
            }
            if (cls == Double.NEGATIVE_INFINITY) {
                return "-Infinity";
            }
        }
        return obj;
    }

    private JSONArray convertListToJsonArray(Object obj) {
        JSONArray jSONArray = new JSONArray();
        for (Object next : (List) obj) {
            Object obj2 = null;
            if (next != null) {
                obj2 = getJsonValue(next, next.getClass(), null);
            }
            jSONArray.put(obj2);
        }
        return jSONArray;
    }

    private Method getJsonValueMethod(Class<?> cls) {
        Method method;
        synchronized (this.mJsonValueMethodCache) {
            method = (Method) this.mJsonValueMethodCache.get(cls);
            if (method == null && !this.mJsonValueMethodCache.containsKey(cls)) {
                method = getJsonValueMethodImpl(cls);
                this.mJsonValueMethodCache.put(cls, method);
            }
        }
        return method;
    }

    private static Method getJsonValueMethodImpl(Class<?> cls) {
        cls = cls.getMethods();
        for (int i = 0; i < cls.length; i++) {
            if (cls[i].getAnnotation(JsonValue.class) != null) {
                return cls[i];
            }
        }
        return null;
    }

    private static boolean canDirectlySerializeClass(Class cls) {
        if (!isWrapperOrPrimitiveType(cls)) {
            if (cls.equals(String.class) == null) {
                return null;
            }
        }
        return true;
    }

    private static boolean isWrapperOrPrimitiveType(Class<?> cls) {
        if (!(cls.isPrimitive() || cls.equals(Boolean.class) || cls.equals(Integer.class) || cls.equals(Character.class) || cls.equals(Byte.class) || cls.equals(Short.class) || cls.equals(Double.class) || cls.equals(Long.class))) {
            if (cls.equals(Float.class) == null) {
                return null;
            }
        }
        return true;
    }
}
