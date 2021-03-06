/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.ide.ext.java.server;

import com.codenvy.everrest.CodenvyAsynchronousJobPool;
import com.codenvy.inject.DynaModule;
import com.google.inject.AbstractModule;

import org.everrest.core.impl.async.AsynchronousJobPool;
import org.everrest.core.impl.async.AsynchronousJobService;
import org.everrest.guice.PathKey;

/**
 * @author Evgen Vidolob
 */
@DynaModule
public class JavaCodeAssistantModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RestNameEnvironment.class);
        bind(JavaProjectWatcherService.class);
        bind(AsynchronousJobPool.class).to(CodenvyAsynchronousJobPool.class);
        bind(new PathKey<>(AsynchronousJobService.class, "/async/{ws-id}")).to(AsynchronousJobService.class);
        bind(com.codenvy.api.core.notification.WSocketEventBusClient.class).asEagerSingleton();
    }
}
