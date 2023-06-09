/*
 * Copyright (C) 2022 GroovyMC and contributors
 * SPDX-License-Identifier: LGPL-3.0-or-later
 */

package org.groovymc.cgl.impl.transform.forge

import com.google.auto.service.AutoService
import groovy.transform.CompileStatic
import org.groovymc.cgl.api.transform.util.ModClassTransformer
import org.groovymc.gml.transform.gmods.GModASTTransformer

@CompileStatic
@AutoService(ModClassTransformer.Helper.class)
@SuppressWarnings('unused')
class ForgeModClassTransformer implements ModClassTransformer.Helper {
    @Override
    void addTransformer(String modId, ModClassTransformer.Transformer transformer) {
        GModASTTransformer.registerTransformer(modId) { clazz, annotation, source ->
            transformer.transform(clazz, annotation, source)
        }
    }
}
