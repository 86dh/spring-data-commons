/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.mapping;

import java.util.List;

/**
 * Mechanism to create an entity instance.
 *
 * @author Mark Paluch
 * @since 3.0
 */
public interface EntityCreator<P extends PersistentProperty<P>> {

	/**
	 * Check whether the given {@link PersistentProperty} is being used as creator parameter.
	 *
	 * @param property
	 * @return
	 */
	boolean isCreatorParameter(PersistentProperty<?> property);

	/**
	 * @return the number of parameters.
	 */
	int getParameterCount();

	/**
	 * @return the parameters used by this creator.
	 */
	List<Parameter<Object, P>> getParameters();

	/**
	 * @return whether the creator accepts {@link Parameter}s.
	 */
	default boolean hasParameters() {
		return getParameterCount() != 0;
	}
}
