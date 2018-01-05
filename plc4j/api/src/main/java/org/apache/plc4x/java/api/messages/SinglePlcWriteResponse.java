/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
package org.apache.plc4x.java.api.messages;

import org.apache.plc4x.java.api.messages.items.WriteResponseItem;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SinglePlcWriteResponse<T> implements PlcWriteResponse {

    private final SinglePlcWriteRequest<T> request;
    private final WriteResponseItem<T> responseItem;

    public SinglePlcWriteResponse(SinglePlcWriteRequest<T> request, WriteResponseItem<T> responseItem) {
        this.request = request;
        this.responseItem = responseItem;
    }

    @Override
    public SinglePlcWriteRequest<T> getRequest() {
        return request;
    }

    @Override
    public List<WriteResponseItem<T>> getResponseItems() {
        return responseItem != null ? Collections.singletonList(responseItem) : Collections.emptyList();
    }

    public Optional<WriteResponseItem<T>> getResponseItem() {
        return Optional.ofNullable(responseItem);
    }

}
