package com.google.p127a.p129b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* compiled from: $Gson$Types */
/* renamed from: com.google.a.b.b */
public final class C2132b {
    /* renamed from: a */
    static final Type[] f5101a = new Type[0];

    /* compiled from: $Gson$Types */
    /* renamed from: com.google.a.b.b$a */
    private static final class C2129a implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        /* renamed from: a */
        private final Type f5095a;

        public C2129a(Type type) {
            this.f5095a = C2132b.m5852d(type);
        }

        public Type getGenericComponentType() {
            return this.f5095a;
        }

        public boolean equals(Object obj) {
            return (!(obj instanceof GenericArrayType) || C2132b.m5846a((Type) this, (GenericArrayType) obj) == null) ? null : true;
        }

        public int hashCode() {
            return this.f5095a.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C2132b.m5854f(this.f5095a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: $Gson$Types */
    /* renamed from: com.google.a.b.b$b */
    private static final class C2130b implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        /* renamed from: a */
        private final Type f5096a;
        /* renamed from: b */
        private final Type f5097b;
        /* renamed from: c */
        private final Type[] f5098c;

        public C2130b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Object obj;
                Class cls = (Class) type2;
                boolean z = true;
                if (!Modifier.isStatic(cls.getModifiers())) {
                    if (cls.getEnclosingClass() != null) {
                        obj = null;
                        if (type == null) {
                            if (obj != null) {
                                z = false;
                            }
                        }
                        C2128a.m5835a(z);
                    }
                }
                obj = 1;
                if (type == null) {
                    if (obj != null) {
                        z = false;
                    }
                }
                C2128a.m5835a(z);
            }
            if (type == null) {
                type = null;
            } else {
                type = C2132b.m5852d(type);
            }
            this.f5096a = type;
            this.f5097b = C2132b.m5852d(type2);
            this.f5098c = (Type[]) typeArr.clone();
            for (int i = 0; i < this.f5098c.length; i++) {
                C2128a.m5834a(this.f5098c[i]);
                C2132b.m5857i(this.f5098c[i]);
                this.f5098c[i] = C2132b.m5852d(this.f5098c[i]);
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f5098c.clone();
        }

        public Type getRawType() {
            return this.f5097b;
        }

        public Type getOwnerType() {
            return this.f5096a;
        }

        public boolean equals(Object obj) {
            return (!(obj instanceof ParameterizedType) || C2132b.m5846a((Type) this, (ParameterizedType) obj) == null) ? null : true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f5098c) ^ this.f5097b.hashCode()) ^ C2132b.m5847b(this.f5096a);
        }

        public String toString() {
            int i = 1;
            StringBuilder stringBuilder = new StringBuilder((this.f5098c.length + 1) * 30);
            stringBuilder.append(C2132b.m5854f(this.f5097b));
            if (this.f5098c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<");
            stringBuilder.append(C2132b.m5854f(this.f5098c[0]));
            while (i < this.f5098c.length) {
                stringBuilder.append(", ");
                stringBuilder.append(C2132b.m5854f(this.f5098c[i]));
                i++;
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    /* compiled from: $Gson$Types */
    /* renamed from: com.google.a.b.b$c */
    private static final class C2131c implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        /* renamed from: a */
        private final Type f5099a;
        /* renamed from: b */
        private final Type f5100b;

        public C2131c(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            C2128a.m5835a(typeArr2.length <= 1);
            C2128a.m5835a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C2128a.m5834a(typeArr2[0]);
                C2132b.m5857i(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    z = false;
                }
                C2128a.m5835a(z);
                this.f5100b = C2132b.m5852d(typeArr2[0]);
                this.f5099a = Object.class;
                return;
            }
            C2128a.m5834a(typeArr[0]);
            C2132b.m5857i(typeArr[0]);
            this.f5100b = null;
            this.f5099a = C2132b.m5852d(typeArr[0]);
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f5099a};
        }

        public Type[] getLowerBounds() {
            if (this.f5100b == null) {
                return C2132b.f5101a;
            }
            return new Type[]{this.f5100b};
        }

        public boolean equals(Object obj) {
            return (!(obj instanceof WildcardType) || C2132b.m5846a((Type) this, (WildcardType) obj) == null) ? null : true;
        }

        public int hashCode() {
            return (this.f5100b != null ? this.f5100b.hashCode() + 31 : 1) ^ (this.f5099a.hashCode() + 31);
        }

        public String toString() {
            StringBuilder stringBuilder;
            if (this.f5100b != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("? super ");
                stringBuilder.append(C2132b.m5854f(this.f5100b));
                return stringBuilder.toString();
            } else if (this.f5099a == Object.class) {
                return "?";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("? extends ");
                stringBuilder.append(C2132b.m5854f(this.f5099a));
                return stringBuilder.toString();
            }
        }
    }

    /* renamed from: a */
    public static ParameterizedType m5840a(Type type, Type type2, Type... typeArr) {
        return new C2130b(type, type2, typeArr);
    }

    /* renamed from: a */
    public static GenericArrayType m5839a(Type type) {
        return new C2129a(type);
    }

    /* renamed from: b */
    public static WildcardType m5849b(Type type) {
        return new C2131c(new Type[]{type}, f5101a);
    }

    /* renamed from: c */
    public static WildcardType m5851c(Type type) {
        return new C2131c(new Type[]{Object.class}, new Type[]{type});
    }

    /* renamed from: d */
    public static Type m5852d(Type type) {
        if (type instanceof Class) {
            type = (Class) type;
            if (type.isArray()) {
                type = new C2129a(C2132b.m5852d(type.getComponentType()));
            }
            return type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C2130b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new C2129a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new C2131c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    /* renamed from: e */
    public static Class<?> m5853e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
            C2128a.m5835a(type instanceof Class);
            return (Class) type;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(C2132b.m5853e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return C2132b.m5853e(((WildcardType) type).getUpperBounds()[0]);
            }
            String str;
            if (type == null) {
                str = "null";
            } else {
                str = type.getClass().getName();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            stringBuilder.append(type);
            stringBuilder.append("> is of type ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    static boolean m5845a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m5846a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!C2132b.m5845a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()) == null) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return C2132b.m5846a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()) == null) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || typeVariable.getName().equals(typeVariable2.getName()) == null) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: b */
    private static int m5847b(Object obj) {
        return obj != null ? obj.hashCode() : null;
    }

    /* renamed from: f */
    public static String m5854f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: a */
    static Type m5842a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface() != null) {
            type = cls.getInterfaces();
            int length = type.length;
            for (int i = 0; i < length; i++) {
                if (type[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(type[i])) {
                    return C2132b.m5842a(cls.getGenericInterfaces()[i], type[i], (Class) cls2);
                }
            }
        }
        if (cls.isInterface() == null) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return C2132b.m5842a(cls.getGenericSuperclass(), (Class) superclass, (Class) cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: b */
    static Type m5848b(Type type, Class<?> cls, Class<?> cls2) {
        C2128a.m5835a(cls2.isAssignableFrom(cls));
        return C2132b.m5843a(type, (Class) cls, C2132b.m5842a(type, (Class) cls, (Class) cls2));
    }

    /* renamed from: g */
    public static Type m5855g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    /* renamed from: a */
    public static Type m5841a(Type type, Class<?> cls) {
        type = C2132b.m5848b(type, cls, Collection.class);
        if ((type instanceof WildcardType) != null) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    /* renamed from: b */
    public static Type[] m5850b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        type = C2132b.m5848b(type, cls, Map.class);
        if ((type instanceof ParameterizedType) != null) {
            return ((ParameterizedType) type).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    /* renamed from: a */
    public static Type m5843a(Type type, Class<?> cls, Type type2) {
        while (type2 instanceof TypeVariable) {
            type2 = (TypeVariable) type2;
            Type a = C2132b.m5844a(type, (Class) cls, (TypeVariable) type2);
            if (a == type2) {
                return a;
            }
            type2 = a;
        }
        if (type2 instanceof Class) {
            a = (Class) type2;
            if (a.isArray()) {
                type2 = a.getComponentType();
                type = C2132b.m5843a(type, (Class) cls, type2);
                if (type2 != type) {
                    a = C2132b.m5839a(type);
                }
                return a;
            }
        }
        if (type2 instanceof GenericArrayType) {
            type2 = (GenericArrayType) type2;
            a = type2.getGenericComponentType();
            type = C2132b.m5843a(type, (Class) cls, a);
            if (a != type) {
                type2 = C2132b.m5839a(type);
            }
            return type2;
        }
        int i = 0;
        if (type2 instanceof ParameterizedType) {
            type2 = (ParameterizedType) type2;
            a = type2.getOwnerType();
            Type a2 = C2132b.m5843a(type, (Class) cls, a);
            Object obj = a2 != a ? 1 : null;
            Type[] actualTypeArguments = type2.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                Type a3 = C2132b.m5843a(type, (Class) cls, actualTypeArguments[i]);
                if (a3 != actualTypeArguments[i]) {
                    if (obj == null) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        obj = 1;
                    }
                    actualTypeArguments[i] = a3;
                }
                i++;
            }
            if (obj != null) {
                type2 = C2132b.m5840a(a2, type2.getRawType(), actualTypeArguments);
            }
            return type2;
        } else if (!(type2 instanceof WildcardType)) {
            return type2;
        } else {
            WildcardType wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                type = C2132b.m5843a(type, (Class) cls, lowerBounds[0]);
                if (type != lowerBounds[0]) {
                    return C2132b.m5851c(type);
                }
            } else if (upperBounds.length == 1) {
                type = C2132b.m5843a(type, (Class) cls, upperBounds[0]);
                if (type != upperBounds[0]) {
                    return C2132b.m5849b(type);
                }
            }
            return wildcardType;
        }
    }

    /* renamed from: a */
    static Type m5844a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a = C2132b.m5838a((TypeVariable) typeVariable);
        if (a == null) {
            return typeVariable;
        }
        type = C2132b.m5842a(type, (Class) cls, a);
        if ((type instanceof ParameterizedType) == null) {
            return typeVariable;
        }
        return ((ParameterizedType) type).getActualTypeArguments()[C2132b.m5837a(a.getTypeParameters(), (Object) typeVariable)];
    }

    /* renamed from: a */
    private static int m5837a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    private static Class<?> m5838a(TypeVariable<?> typeVariable) {
        typeVariable = typeVariable.getGenericDeclaration();
        return typeVariable instanceof Class ? (Class) typeVariable : null;
    }

    /* renamed from: i */
    private static void m5857i(Type type) {
        boolean z;
        if (type instanceof Class) {
            if (((Class) type).isPrimitive() != null) {
                z = null;
                C2128a.m5835a(z);
            }
        }
        z = true;
        C2128a.m5835a(z);
    }
}
