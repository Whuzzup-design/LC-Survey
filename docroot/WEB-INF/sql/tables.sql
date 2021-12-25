create table lc_SurveyFile (
	surveyFileId LONG not null primary key,
	surveyMainId LONG,
	fileName VARCHAR(150) null,
	creatorId LONG,
	createDate LONG
);

create table lc_SurveyMain (
	surveyMainId LONG not null primary key,
	title VARCHAR(200) null,
	description TEXT null,
	epilog TEXT null,
	startDate DATE null,
	endDate DATE null,
	needAuth BOOLEAN,
	calculateScore BOOLEAN,
	viewAnswer BOOLEAN,
	color VARCHAR(75) null,
	creatorId LONG,
	modifierId LONG,
	createDate LONG,
	modifiedDate LONG
);

create table lc_SurveyOption (
	surveyOptionId LONG not null primary key,
	surveyMainId LONG,
	surveyPageId LONG,
	surveyQuestionId LONG,
	no INTEGER,
	option_ VARCHAR(200) null,
	isAns BOOLEAN,
	pageDirectId LONG,
	uploadFileId LONG,
	creatorId LONG,
	modifierId LONG,
	createDate LONG,
	modifiedDate LONG
);

create table lc_SurveyPage (
	surveyPageId LONG not null primary key,
	surveyMainId LONG,
	no INTEGER,
	title VARCHAR(200) null,
	pageDirectId LONG,
	creatorId LONG,
	modifierId LONG,
	createDate LONG,
	modifiedDate LONG
);

create table lc_SurveyQuestion (
	surveyQuestionId LONG not null primary key,
	surveyMainId LONG,
	surveyPageId LONG,
	parentId LONG,
	no INTEGER,
	question VARCHAR(500) null,
	type_ VARCHAR(75) null,
	isRequired BOOLEAN,
	hasOther BOOLEAN,
	optionDirect BOOLEAN,
	points VARCHAR(75) null,
	starsCount INTEGER,
	uploadFileId LONG,
	creatorId LONG,
	modifierId LONG,
	createDate LONG,
	modifiedDate LONG
);

create table lc_SurveyResponse (
	surveyResponseId LONG not null primary key,
	surveyMainId LONG,
	writerId LONG,
	response STRING null,
	creatorId LONG,
	createDate LONG
);

create table lc_SurveyResult (
	surveyResultId LONG not null primary key,
	surveyMainId LONG,
	surveyPageId LONG,
	surveyQuestionId LONG,
	surveyOptionId LONG,
	surveyWriterId LONG,
	ans STRING null,
	creatorId LONG,
	createDate LONG
);

create table lc_SurveyWriteSequence (
	surveyWriteSequenceId LONG not null primary key,
	surveyWriterId LONG,
	pageId LONG,
	prePageId LONG,
	isDirect BOOLEAN,
	creatorId LONG,
	createDate LONG
);

create table lc_SurveyWriter (
	surveyWriterId LONG not null primary key,
	surveyMainId LONG,
	isPreview BOOLEAN,
	isComplete BOOLEAN,
	completionTime LONG,
	creatorId LONG,
	createDate LONG
);