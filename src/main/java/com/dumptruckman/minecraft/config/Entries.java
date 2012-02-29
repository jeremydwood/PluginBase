package com.dumptruckman.minecraft.config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public final class Entries {

    protected static final Set<ConfigEntry> entries = new HashSet<ConfigEntry>();

    public static void registerConfig(Class configClass) {
        Field[] fields = configClass.getDeclaredFields();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            field.setAccessible(true);
            try {
                if (ConfigEntry.class.isInstance(field.get(null))) {
                    try {

                        entries.add((ConfigEntry) field.get(null));
                    } catch(IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IllegalArgumentException ignore) {
            } catch (IllegalAccessException ignore) {
            } catch (NullPointerException ignore) { }
        }
    }
}
