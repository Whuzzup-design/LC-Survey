create index IX_F31E5DB3 on lc_SurveyFile (creatorId);
create index IX_F7ACD046 on lc_SurveyFile (surveyMainId);

create index IX_FE6E5896 on lc_SurveyMain (creatorId);

create index IX_656640BF on lc_SurveyOption (surveyMainId);
create index IX_99214295 on lc_SurveyOption (surveyPageId);
create index IX_9D5503EC on lc_SurveyOption (surveyQuestionId);
create index IX_52A7D6A0 on lc_SurveyOption (surveyQuestionId, isAns);

create index IX_BFD2B759 on lc_SurveyPage (surveyMainId);
create index IX_A25B18CE on lc_SurveyPage (surveyMainId, no);

create index IX_49A3AA7 on lc_SurveyQuestion (parentId);
create index IX_4CDF01B0 on lc_SurveyQuestion (surveyMainId);
create index IX_809A0386 on lc_SurveyQuestion (surveyPageId);
create index IX_FA43391F on lc_SurveyQuestion (surveyPageId, parentId);
create index IX_3C7A2F07 on lc_SurveyQuestion (type_);

create index IX_95C5C40B on lc_SurveyResponse (surveyMainId);
create index IX_4786F1CB on lc_SurveyResponse (writerId);

create index IX_C1053067 on lc_SurveyResult (surveyMainId);
create index IX_6511009 on lc_SurveyResult (surveyMainId, writerId);
create index IX_1DF2A8BF on lc_SurveyResult (surveyOptionId, surveyWriterId);
create index IX_3C59E43C on lc_SurveyResult (surveyOptionId, writerId, isComplete);
create index IX_4C66CE19 on lc_SurveyResult (surveyPageId, surveyWriterId);
create index IX_8570072 on lc_SurveyResult (surveyQuestionId, surveyOptionId);
create index IX_918AED70 on lc_SurveyResult (surveyQuestionId, surveyWriterId);
create index IX_58DE202D on lc_SurveyResult (surveyQuestionId, writerId, isComplete);
create index IX_65E605E1 on lc_SurveyResult (surveyWriterId);

create index IX_2F7E4906 on lc_SurveyWriteSequence (surveyMainId);
create index IX_5C572DE8 on lc_SurveyWriteSequence (surveyMainId, writerId);
create index IX_E7B892E6 on lc_SurveyWriteSequence (surveyMainId, writerId, pageId);
create index IX_E7BB020C on lc_SurveyWriteSequence (surveyMainId, writerId, pageNo);
create index IX_1A7B72C0 on lc_SurveyWriteSequence (surveyWriterId);
create index IX_89167FBE on lc_SurveyWriteSequence (surveyWriterId, pageId);

create index IX_2A18A0BD on lc_SurveyWriter (surveyMainId);
create index IX_9FD4E374 on lc_SurveyWriter (surveyMainId, isComplete);
create index IX_885F9748 on lc_SurveyWriter (surveyMainId, isPreview, isComplete);