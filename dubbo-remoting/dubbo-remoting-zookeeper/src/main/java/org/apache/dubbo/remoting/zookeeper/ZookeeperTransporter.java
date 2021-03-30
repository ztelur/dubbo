/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.remoting.zookeeper;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;
import org.apache.dubbo.remoting.Constants;

/**
 * 我们从代码中可以看到，ZookeeperTransporter 接口被 @SPI 注解修饰，成为一个扩展点，默认选择扩展名 “curator” 的实现
 */
@SPI("curator")
public interface ZookeeperTransporter {

    /**
     * 其中的 connect() 方法用于创建 ZookeeperClient 实例
     * （该方法被 @Adaptive 注解修饰，我们可以通过 URL 参数中的 client 或 transporter 参数覆盖 @SPI 注解指定的默认扩展名）。
     * @param url
     * @return
     */
    @Adaptive({Constants.CLIENT_KEY, Constants.TRANSPORTER_KEY})
    ZookeeperClient connect(URL url);

}
