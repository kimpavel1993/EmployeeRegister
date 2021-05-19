create table Employee_Bank (
	bankId LONG not null primary key,
	name VARCHAR(75) null,
	bik LONG,
	streetAddress VARCHAR(75) null
);

create table Employee_Employee (
	employeeId LONG not null primary key,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	sex VARCHAR(75) null,
	birthdayDate DATE null,
	positionId LONG,
	employmentDate DATE null,
	salary VARCHAR(75) null,
	workPhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	bankId LONG,
	isArchived BOOLEAN
);

create table Employee_Position (
	positionId LONG not null primary key,
	name VARCHAR(75) null,
	isArchived BOOLEAN
);