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

package org.apache.commons.chain.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.CatalogFactory;

/**
 * <p>A simple implementation of {@link CatalogFactory}.</p>
 *
 * @author Sean Schofield
 * @version $Revision$ $Date$
 */

public class CatalogFactoryBase extends CatalogFactory {


    // ----------------------------------------------------------- Constructors


    /**
     * <p>Construct an empty instance of {@link CatalogFactoryBase}.  This
     * constructor is intended solely for use by {@link CatalogFactory}.</p>
     */
    public CatalogFactoryBase() { }


    // ----------------------------------------------------- Instance Variables


    /**
     * <p>The default {@link Catalog} for this {@link CatalogFactory}.</p>
     */
    private Catalog catalog = null;


    /**
     * <p>Map of named {@link Catalog}s, keyed by catalog name.</p>
     */
    private final Map<String, Catalog> catalogs =
            new ConcurrentHashMap<String, Catalog>();


    // --------------------------------------------------------- Public Methods


    /**
     * <p>Gets the default instance of Catalog associated with the factory
     * (if any); otherwise, return <code>null</code>.</p>
     *
     * @return the default Catalog instance
     */
    @Override
    public Catalog getCatalog() {

        return catalog;

    }


    /**
     * <p>Sets the default instance of Catalog associated with the factory.</p>
     *
     * @param catalog the default Catalog instance
     */
    @Override
    public void setCatalog(Catalog catalog) {

        this.catalog = catalog;

    }


    /**
     * <p>Retrieves a Catalog instance by name (if any); otherwise
     * return <code>null</code>.</p>
     *
     * @param name the name of the Catalog to retrieve
     * @return the specified Catalog
     */
    @Override
    public Catalog getCatalog(String name) {

        return catalogs.get(name);

    }


    /**
     * <p>Adds a named instance of Catalog to the factory (for subsequent
     * retrieval later).</p>
     *
     * @param name the name of the Catalog to add
     * @param catalog the Catalog to add
     */
    @Override
    public void addCatalog(String name, Catalog catalog) {

            catalogs.put(name, catalog);

    }


    /**
     * <p>Return an <code>Iterator</code> over the set of named
     * {@link Catalog}s known to this {@link CatalogFactory}.
     * If there are no known catalogs, an empty Iterator is returned.</p>
     * @return An Iterator of the names of the Catalogs known by this factory.
     */
    @Override
    public Iterator<String> getNames() {

            return catalogs.keySet().iterator();

    }


}
