/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//chain/apps/mailreader/src/test/org/apache/commons/mailreader/ChangeLocaleTest.java,v 1.1 2004/03/29 00:54:23 husted Exp $
 * $Revision: 1.1 $
 * $Date: 2004/03/29 00:54:23 $
 *
 * Copyright 2000-2004 Apache Software Foundation
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
package org.apache.commons.mailreader;

import junit.framework.TestCase;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.mailreader.MailReader;
import org.apache.commons.chain.mailreader.MailReaderBase;
import org.apache.commons.chain.mailreader.commands.LocaleChange;
import org.apache.commons.chain.impl.ContextBase;

import java.util.Locale;

/**
 */
public class ChangeLocaleTest extends TestCase {

    private Command command;

    public void setUp() {

        command = new LocaleChange();

    }

    public void testCanadaFrench() {

        Locale original = Locale.US;
        Locale expected = Locale.CANADA_FRENCH;

        Context input = new ContextBase();
        input.put(MailReader.PN_COUNTRY,"CA");
        input.put(MailReader.PN_LANGUAGE,"FR");

        MailReader context = new MailReaderBase(original,input);

        try {
            command.execute(context);
        }
        catch(Exception e) {
            fail(e.getMessage());
        }

        assertEquals("Unexpected Locale",expected,context.getLocale());

    }

}
