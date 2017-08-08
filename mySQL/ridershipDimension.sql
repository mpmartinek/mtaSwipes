

SELECT date,swipes,StationName,LineName
from dateDim
right outer join riderDim on dateDim.dateID=riderDim.dateID
right outer join stationDim on date
