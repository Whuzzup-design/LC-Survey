/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lc.survey.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author kevin
 */
public class SurveyMainFinderUtil {
	public static java.util.List<com.lc.survey.model.SurveyMain> findForSearch(
		long creatorId, java.lang.String openTime,
		java.lang.String calculateScore, java.lang.String title) {
		return getFinder()
				   .findForSearch(creatorId, openTime, calculateScore, title);
	}

	public static SurveyMainFinder getFinder() {
		if (_finder == null) {
			_finder = (SurveyMainFinder)PortletBeanLocatorUtil.locate(com.lc.survey.service.ClpSerializer.getServletContextName(),
					SurveyMainFinder.class.getName());

			ReferenceRegistry.registerReference(SurveyMainFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SurveyMainFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SurveyMainFinderUtil.class,
			"_finder");
	}

	private static SurveyMainFinder _finder;
}