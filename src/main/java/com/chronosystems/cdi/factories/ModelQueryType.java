package com.chronosystems.cdi.factories;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ FIELD, TYPE, METHOD })
public @interface ModelQueryType {
	
	ModelQueries value();
	
	
	enum ModelQueries {
		
		DAS(new DasModelQuery()),
		DIS(new DisModelQuery());

		ModelQuery modelQuery;

		private ModelQueries(ModelQuery modelQuery) {
			this.modelQuery = modelQuery;
		}

		Class<? extends ModelQuery> getClazz() {
			return modelQuery.getClass();
		}
	}
	
}