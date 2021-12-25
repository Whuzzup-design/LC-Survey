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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author kevin
 * @generated
 */
public class SurveyFilePK implements Comparable<SurveyFilePK>, Serializable {
	public long surveyFileId;
	public long surveyMainId;

	public SurveyFilePK() {
	}

	public SurveyFilePK(long surveyFileId, long surveyMainId) {
		this.surveyFileId = surveyFileId;
		this.surveyMainId = surveyMainId;
	}

	public long getSurveyFileId() {
		return surveyFileId;
	}

	public void setSurveyFileId(long surveyFileId) {
		this.surveyFileId = surveyFileId;
	}

	public long getSurveyMainId() {
		return surveyMainId;
	}

	public void setSurveyMainId(long surveyMainId) {
		this.surveyMainId = surveyMainId;
	}

	@Override
	public int compareTo(SurveyFilePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (surveyFileId < pk.surveyFileId) {
			value = -1;
		}
		else if (surveyFileId > pk.surveyFileId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (surveyMainId < pk.surveyMainId) {
			value = -1;
		}
		else if (surveyMainId > pk.surveyMainId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyFilePK)) {
			return false;
		}

		SurveyFilePK pk = (SurveyFilePK)obj;

		if ((surveyFileId == pk.surveyFileId) &&
				(surveyMainId == pk.surveyMainId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(surveyFileId) + String.valueOf(surveyMainId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("surveyFileId");
		sb.append(StringPool.EQUAL);
		sb.append(surveyFileId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("surveyMainId");
		sb.append(StringPool.EQUAL);
		sb.append(surveyMainId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}