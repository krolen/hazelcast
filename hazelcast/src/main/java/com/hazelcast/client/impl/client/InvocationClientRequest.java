/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client.impl.client;

import com.hazelcast.nio.Address;
import com.hazelcast.spi.InvocationBuilder;
import com.hazelcast.spi.Operation;

public abstract class InvocationClientRequest extends ClientRequest {

    @Override
    public final void process() throws Exception {
        invoke();
    }

    protected abstract void invoke();

    protected final InvocationBuilder createInvocationBuilder(String serviceName, Operation op, int partitionId) {
        return operationService.createInvocationBuilder(serviceName, op, partitionId);
    }

    protected final InvocationBuilder createInvocationBuilder(String serviceName, Operation op, Address target) {
        return operationService.createInvocationBuilder(serviceName, op, target);
    }
}
