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
package com.sdl.odata.edm.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for ActionImpl class.
 */
public class ActionImplTest {

    @Test
    public void testActionImpl() {
        ActionImpl.Builder builder = new ActionImpl.Builder();
        builder.setName("testAction")
                .setBound(true)
                .setNamespace("testNamespace")
                .setEntitySetPath("someEntitySetPath")
                .setReturnType("someReturnType")
                .setParameters(new HashSet<>());

        ActionImpl action = builder.build();
        assertEquals("testAction", action.getName());
        assertEquals("testNamespace", action.getNamespace());

        assertTrue(action.isBound());
        assertEquals("someReturnType", action.getReturnType());
        assertEquals("someEntitySetPath", action.getEntitySetPath());
        assertEquals(0, action.getParameters().size());
    }
}
