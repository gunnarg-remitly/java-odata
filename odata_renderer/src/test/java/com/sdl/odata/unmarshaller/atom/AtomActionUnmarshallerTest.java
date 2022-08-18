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
package com.sdl.odata.unmarshaller.atom;

import com.google.common.collect.ImmutableMap;
import com.sdl.odata.api.parser.ODataParser;
import com.sdl.odata.api.parser.ODataUriParseException;
import com.sdl.odata.parser.ODataParserImpl;
import com.sdl.odata.unmarshaller.UnmarshallerTest;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.sdl.odata.api.service.ODataRequest.Method.GET;
import static com.sdl.odata.api.service.ODataRequest.Method.POST;
import static com.sdl.odata.test.util.TestUtils.createODataRequest;
import static com.sdl.odata.test.util.TestUtils.createODataRequestContext;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test for Atom Action Unmarshaller class.
 */
public class AtomActionUnmarshallerTest extends UnmarshallerTest {
    private static final Map<String, String> CONTENT_TYPE = ImmutableMap.of("Content-type", "application/xml");

    private static final Map<String, String> CONTENT_TYPE_JSON = ImmutableMap.of("Content-type", "application/json");

    private final AtomActionUnmarshaller unmarshaller = new AtomActionUnmarshaller();

    private final ODataParser uriParser = new ODataParserImpl();

    @Test
    public void testActionPostRequestScore() throws UnsupportedEncodingException, ODataUriParseException {
        String uri = "http://some.com/xyz.svc/Customers(2)/ODataDemo.ODataDemoAction";
        odataUri = uriParser.parseUri(uri, entityDataModel);
        int score = unmarshaller.score(createODataRequestContext(
                createODataRequest(POST, CONTENT_TYPE), odataUri, entityDataModel));
        assertThat(score, is(180));
    }

    @Test
    public void testActionGetRequestScore() throws UnsupportedEncodingException, ODataUriParseException {
        String uri = "http://some.com/xyz.svc/Customers(2)/ODataDemo.ODataDemoAction";
        odataUri = uriParser.parseUri(uri, entityDataModel);
        int score = unmarshaller.score(createODataRequestContext(
                createODataRequest(GET, CONTENT_TYPE), odataUri, entityDataModel));
        assertThat(score, is(0));
    }

    @Test
    public void testActionPostRequestXmlScore() throws UnsupportedEncodingException, ODataUriParseException {
        String uri = "http://some.com/xyz.svc/Customers(2)/ODataDemo.ODataDemoAction";
        odataUri = uriParser.parseUri(uri, entityDataModel);
        int score = unmarshaller.score(createODataRequestContext(
                createODataRequest(POST, CONTENT_TYPE_JSON), odataUri, entityDataModel));
        assertThat(score, is(0));
    }

    @Test
    public void testActionImportPostRequestScore() throws UnsupportedEncodingException, ODataUriParseException {
        String uri = "http://some.com/xyz.svc/ODataDemoActionImport";
        odataUri = uriParser.parseUri(uri, entityDataModel);
        int score = unmarshaller.score(createODataRequestContext(
                createODataRequest(POST, CONTENT_TYPE), odataUri, entityDataModel));
        assertThat(score, is(180));
    }

    @Test
    public void testEntityPostRequestScore() throws UnsupportedEncodingException, ODataUriParseException {
        String uri = "http://some.com/xyz.svc/Customers(111)";
        odataUri = uriParser.parseUri(uri, entityDataModel);
        int score = unmarshaller.score(createODataRequestContext(
                createODataRequest(POST, CONTENT_TYPE), odataUri, entityDataModel));
        assertThat(score, is(0));
    }
}
