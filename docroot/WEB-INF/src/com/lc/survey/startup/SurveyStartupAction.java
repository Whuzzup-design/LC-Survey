package com.lc.survey.startup;

import java.util.List;

import com.lc.survey.model.SurveyQuestion;
import com.lc.survey.service.SurveyQuestionLocalServiceUtil;
import com.lc.survey.utils.SurveyConstants;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SurveyStartupAction extends SimpleAction {

	private static final Log _log = LogFactoryUtil
			.getLog(SurveyStartupAction.class);

	@Override
	public void run(String[] arg0) throws ActionException {

		// change the record question type to "single-choice" which question type is "radio"
		try {
			
			if (SurveyQuestionLocalServiceUtil.countByType("radio") == 0)
				return;

			List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil
					.findByType("radio");

			for (SurveyQuestion s_question : s_questions) {

				s_question.setType(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE);

				SurveyQuestionLocalServiceUtil.updateSurveyQuestion(s_question);
			}

		} catch (Exception e) {
			_log.warn(e);
		}
	}

}
