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
package org.apache.plc4x.java.transport.rawsocket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import org.apache.plc4x.java.spi.configuration.HasConfiguration;
import org.apache.plc4x.java.spi.connection.NettyChannelFactory;
import org.apache.plc4x.java.utils.rawsockets.netty.RawSocketAddress;
import org.apache.plc4x.java.utils.rawsockets.netty.RawSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RawSocketChannelFactory extends NettyChannelFactory implements HasConfiguration<RawSocketTransportConfiguration> {

    private static final Logger logger = LoggerFactory.getLogger(RawSocketChannelFactory.class);

    private RawSocketTransportConfiguration configuration;

    public RawSocketChannelFactory(RawSocketAddress address) {
        super(address);
    }

    @Override
    public void setConfiguration(RawSocketTransportConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Class<? extends Channel> getChannel() {
        return RawSocketChannel.class;
    }

    @Override
    public void configureBootstrap(Bootstrap bootstrap) {
        if(configuration != null) {
            logger.info("Configuring Bootstrap with {}", configuration);
        }
    }

}
