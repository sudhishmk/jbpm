/*
  Copyright 2010 Intalio Inc

  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.process.builder.dialect.xpath;

import org.drools.compiler.DescrBuildError;
import org.drools.compiler.ReturnValueDescr;
import org.drools.rule.builder.PackageBuildContext;
import org.jbpm.process.builder.ReturnValueEvaluatorBuilder;
import org.jbpm.process.core.ContextResolver;
import org.jbpm.process.instance.impl.ReturnValueConstraintEvaluator;
import org.jbpm.process.instance.impl.XPATHReturnValueEvaluator;

public class XPATHReturnValueEvaluatorBuilder
    implements
    ReturnValueEvaluatorBuilder {

    public XPATHReturnValueEvaluatorBuilder() {

    }

    public void build(final PackageBuildContext context,
                      final ReturnValueConstraintEvaluator constraintNode,
                      final ReturnValueDescr descr,
                      final ContextResolver contextResolver) {

        String text = descr.getText();

        try {
            XPATHReturnValueEvaluator expr = new XPATHReturnValueEvaluator( text,
                                                                          null );

            constraintNode.setEvaluator( expr );
            
        } catch ( final Exception e ) {
            context.getErrors().add( new DescrBuildError( context.getParentDescr(),
                                                          descr,
                                                          null,
                                                          "Unable to build expression for 'constraint' " + descr.getText() + "': " + e ) );
        }
    }

}
