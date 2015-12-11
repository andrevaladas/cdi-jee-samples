package com.chronosystems.cdi.factories;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class ModelQueryFactory {

    @Produces
    @ModelQueryQualifier
    public ModelQuery getModelQuery(
            @Any Instance<ModelQuery> instance, 
            InjectionPoint ip){
        Annotated gtAnnotated = ip.getAnnotated();
        ModelQueryType gtAnnotation = gtAnnotated.getAnnotation(ModelQueryType.class);
        Class<? extends ModelQuery> modelService = gtAnnotation.value().getClazz();
        return instance.select(modelService).get();
    }

}