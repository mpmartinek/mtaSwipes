create table disDim(
disID int ,
Neighborhood text,
Population int,
Median_income int,
SubwayUsage numeric(10,5),
AverageCommTime int,
primary key (disID)
);
create table stationDim(
stID int,
StationName text,
LineName text,
disID int,
primary key (stID),
foreign key (disID) references disDim(disID)
);
create table dateDim(
dateID int,
Date text,
primary key (dateID)
);
create table riderDim(
stID int,
dateID int,
Swipes int,
primary key (stID, dateID)
);