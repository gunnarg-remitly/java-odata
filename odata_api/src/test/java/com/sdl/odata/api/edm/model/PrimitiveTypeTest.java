/*
 * Copyright (c) 2014-2022 All Rights Reserved by the RWS Group for and on behalf of its affiliates and subsidiaries.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sdl.odata.api.edm.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for {@link PrimitiveType}.
 */
public class PrimitiveTypeTest {

    @Test
    public void testForName() {
        assertEquals(PrimitiveType.STRING, PrimitiveType.forName("String"));
    }

    @Test
    public void testForNameException() {
        assertThrows(IllegalArgumentException.class, () ->
                PrimitiveType.forName("Primitive")
        );
    }

    @Test
    public void testGetMetaType() {
        assertEquals(MetaType.PRIMITIVE, PrimitiveType.INT32.getMetaType());
    }

    @Test
    public void testGetName() {
        assertEquals("Decimal", PrimitiveType.DECIMAL.getName());
    }

    @Test
    public void testGetNamespace() {
        assertEquals("Edm", PrimitiveType.DOUBLE.getNamespace());
    }

    @Test
    public void testGetFullyQualifiedName() {
        assertEquals("Edm.Boolean", PrimitiveType.BOOLEAN.getFullyQualifiedName());
    }

    @Test
    public void testGetJavaType() {
        assertEquals(short.class.getName(), PrimitiveType.INT16.getJavaType().getName());
    }
}
