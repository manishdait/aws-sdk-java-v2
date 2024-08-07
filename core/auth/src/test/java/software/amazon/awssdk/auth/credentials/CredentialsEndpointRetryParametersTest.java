/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.auth.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.regions.util.ResourcesEndpointRetryParameters;

/**
 * Unit tests for {@link ResourcesEndpointRetryParameters}.
 */
public class CredentialsEndpointRetryParametersTest {

    @Test
    public void defaultParams() {
        ResourcesEndpointRetryParameters params = ResourcesEndpointRetryParameters.builder().build();
        assertNull(params.getStatusCode());
        assertNull(params.getException());
    }

    @Test
    public void defaultParams_withStatusCode() {
        Integer statusCode = 400;
        ResourcesEndpointRetryParameters params = ResourcesEndpointRetryParameters.builder()
                                                                                  .withStatusCode(statusCode)
                                                                                  .build();
        assertEquals(statusCode, params.getStatusCode());
        assertNull(params.getException());
    }

    @Test
    public void defaultParams_withStatusCodeAndException() {
        Integer statusCode = 500;
        ResourcesEndpointRetryParameters params = ResourcesEndpointRetryParameters.builder()
                                                                                  .withStatusCode(statusCode)
                                                                                  .withException(new IOException())
                                                                                  .build();
        assertEquals(statusCode, params.getStatusCode());
        assertInstanceOf(IOException.class, params.getException());
    }

}
