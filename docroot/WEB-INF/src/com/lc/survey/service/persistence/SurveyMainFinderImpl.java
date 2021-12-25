package com.lc.survey.service.persistence;

import java.util.Date;
import java.util.List;

import com.lc.survey.model.SurveyMain;
import com.lc.survey.model.impl.SurveyMainImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SurveyMainFinderImpl extends BasePersistenceImpl<SurveyMain>
		implements SurveyMainFinder {

	private static final Log _log = LogFactoryUtil
			.getLog(SurveyMainFinder.class);

	private static final String FIND_FOR_SEARCH = SurveyMainFinder.class
			.getName() + ".findForSearch";

	@SuppressWarnings("unchecked")
	public List<SurveyMain> findForSearch(long creatorId, String openTime,
			String calculateScore, String title) {

		Session session = null;

		try {
			session = openSession();

			Date date = new Date();
			String sql = CustomSQLUtil.get(FIND_FOR_SEARCH);
			String openTimeSql = StringPool.BLANK;
			String calculateScoreSql = StringPool.BLANK;
			String titleSql = StringPool.BLANK;

			// open time
			if (openTime.equals("0"))
				openTimeSql = " AND (startDate <= ? AND endDate >= ?)";

			else if (openTime.equals("1"))
				openTimeSql = " AND endDate < ?";

			else if (openTime.equals("2"))
				openTimeSql = " AND startDate > ?";

			// calculate score
			if (calculateScore.equals("0"))
				calculateScoreSql = " AND needAuth = 1";

			else if (calculateScore.equals("1"))
				calculateScoreSql = " AND needAuth = 0";

			// title
			if (!title.equals(""))
				titleSql = " AND title LIKE ?";

			sql = StringUtil.replace(sql, new String[] { "[$OPEN_TIME$]",
					"[$CALCULATE_SCORE$]", "[$TITLE$]" }, new String[] {
					openTimeSql, calculateScoreSql, titleSql });

			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.addEntity("SurveyMain", SurveyMainImpl.class);

			QueryPos qPos = QueryPos.getInstance(sqlQuery);
			qPos.add(creatorId);

			// open time
			if (openTime.equals("0")) {
				qPos.add(CalendarUtil.getTimestamp(date));
				qPos.add(CalendarUtil.getTimestamp(date));
			} else if (openTime.equals("1") || openTime.equals("2")) {
				qPos.add(CalendarUtil.getTimestamp(date));
			}

			// title
			if (!title.equals(""))
				qPos.add("%" + title + "%");

			return (List<SurveyMain>) QueryUtil.list(sqlQuery, getDialect(),
					-1, -1);

		} catch (Exception e) {
			_log.warn(e);
		} finally {
			session.close();
		}

		return null;
	}
}
