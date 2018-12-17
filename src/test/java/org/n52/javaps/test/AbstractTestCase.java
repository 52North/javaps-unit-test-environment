/*
 * Copyright 2018 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.javaps.test;
import java.io.File;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.n52.javaps.io.AbstractInputOutputHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:components/*.xml")
public abstract class AbstractTestCase<T extends AbstractInputOutputHandler> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractTestCase.class);

    protected String projectRoot;

    protected T dataHandler;

    public AbstractTestCase() {

        File f = new File(this.getClass().getProtectionDomain().getCodeSource()
                 .getLocation().getFile());
                 projectRoot = f.getParentFile().getParentFile().getParent();

    }

    @Before
    public void setUp(){
        initializeDataHandler();
    }

    protected boolean isDataHandlerActive(){
        return true;
    }

    protected abstract void initializeDataHandler();

}
