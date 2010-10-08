/*
 * (C) Copyright 2009 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     arussel
 */
package org.nuxeo.ecm.platform.routing.core.api;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.platform.routing.api.DocumentRoute;

/**
 * The DocumentRoutingPersister is responsible creating a folder structure to
 * persist {@link DocumentRoute} instance, persisting new {@link DocumentRoute}
 * instances and creating {@link DocumentRoute} model from {@link DocumentRoute}
 * instance.
 *
 * @author arussel
 *
 */
public interface DocumentRoutingPersister {
    /**
     * The name of the document in which will be create
     */
    String DocumentRouteInstanceRootName = "DocumentRouteInstancesRoot";

    /**
     * Get or create the parent folder for a {@link DocumentRoute} route
     * instance.
     *
     * @param document The {@link DocumentRoute} model from which the instance
     *            will be created. Its metadata may be used when creating the
     *            parent.
     * @return The parent folder in which the {@link DocumentRoute} will be
     *         persisted.
     */
    DocumentModel getParentFolderForDocumentRouteInstance(
            DocumentModel document, CoreSession session);

    /**
     * Creates a blank {@link DocumentRoute} instance from a model.
     *
     * @param model the model
     * @return The created {@link DocumentRoute}
     */
    DocumentModel createDocumentRouteInstanceFromDocumentRouteModel(
            DocumentModel model, CoreSession session);

    /**
     *
     * @param routeInstance
     * @param parentFolder
     * @return
     */
    DocumentModel saveDocumentRouteInstanceAsNewModel(
            DocumentModel routeInstance, DocumentModel parentFolder,
            CoreSession session);

    /**
     * Will get, and create if it does not exists the root document in which
     * {@link DocumentRoute} structure will be created.
     *
     * @param session The session use to get or create the document.
     *
     * @return The root of the {@link DocumentRoute} structure.
     */
    DocumentModel getOrCreateRootOfDocumentRouteInstanceStructure(
            CoreSession session);
}
