package com.dumptruckman.minecraft.pluginbase.config;

import com.dumptruckman.minecraft.pluginbase.config.examples.Child;
import com.dumptruckman.minecraft.pluginbase.config.examples.Parent;
import com.dumptruckman.minecraft.pluginbase.config.examples.Unknown;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ConfigSerializerTest extends TestBase {

    @Test
    public void testSerialize() throws Exception {
        Child child = new Child(true);
        Parent parent = new Parent(child);
        assertEquals("{" + ConfigSerializer.SERIALIZED_TYPE_KEY + "=com.dumptruckman.minecraft.pluginbase.config.examples.Parent, aChild={" + ConfigSerializer.SERIALIZED_TYPE_KEY + "=com.dumptruckman.minecraft.pluginbase.config.examples.Child, aBoolean=true}}", ConfigSerializer.serialize(parent).toString());
    }

    @Test
    public void testDeserialize() throws Exception {
        Child child = new Child(true);
        Parent parent = new Parent(child);
        Map<String, Object> data = ConfigSerializer.serialize(parent);
        Object deserialized = ConfigSerializer.deserialize(data);
        assertEquals(parent, deserialized);
    }

    @Test
    public void testSerializeUnknownObject() throws Exception {
        Unknown unknown = new Unknown();
        boolean thrown = false;
        try {
            ConfigSerializer.serialize(unknown);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
