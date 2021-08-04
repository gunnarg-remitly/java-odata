/**
 * Copyright (c) 2014 All Rights Reserved by the RWS Group.
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
package com.sdl.odata.api.processor;

import com.sdl.odata.api.ODataException;
import com.sdl.odata.api.service.ODataRequestContext;

/**
 * OData query processor interface. A query processor is used for read operations (querying entities).
 */
public interface ODataQueryProcessor {

    ProcessorResult query(ODataRequestContext requestContext, Object data) throws ODataException;
}
