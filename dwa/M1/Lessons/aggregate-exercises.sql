use PersonalTrainer;

-- Use an aggregate to count the number of Clients.
-- 500 rows
--------------------
SELECT COUNT(ClientId)
FROM Client;

-- Use an aggregate to count Client.BirthDate.
-- The number is different than total Clients. Why?
-- 463 rows
--------------------
SELECT COUNT(Birthdate)
FROM Client;

-- Group Clients by City and count them.
-- Order by the number of Clients desc.
-- 20 rows
--------------------
SELECT City, COUNT(ClientId) AS Clients
FROM Client
GROUP BY City
ORDER BY COUNT(ClientId) DESC;

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- Group by InvoiceId.
-- You'll need an expression for the line item total: Price * Quantity.
-- Aggregate per group using SUM().
-- 1000 rows
--------------------
SELECT InvoiceId, SUM(Price * Quantity) AS 'Total Cost'
FROM InvoiceLineItem
GROUP BY InvoiceId;

-- Calculate a total per invoice using only the InvoiceLineItem table.
-- (See above.)
-- Only include totals greater than $500.00.
-- Order from lowest total to highest.
-- 234 rows
--------------------
SELECT InvoiceId, SUM(Price * Quantity) AS 'Total Cost'
FROM InvoiceLineItem
GROUP BY InvoiceId
HAVING SUM(Price * Quantity) > 500
ORDER BY SUM(Price * Quantity) ASC;

-- Calculate the average line item total
-- grouped by InvoiceLineItem.Description.
-- 3 rows
--------------------
SELECT InvoiceLineItem.Description, AVG(Price * Quantity) AS 'Average Cost'
FROM InvoiceLineItem
GROUP BY InvoiceLineItem.Description;

-- Select ClientId, FirstName, and LastName from Client
-- for clients who have *paid* over $1000 total.
-- Paid is Invoice.InvoiceStatus = 2.
-- Order by LastName, then FirstName.
-- 146 rows
--------------------
SELECT 
	Client.ClientId, 
	Client.FirstName, 
    Client.LastName
FROM Client
INNER JOIN Invoice ON Client.ClientId = Invoice.ClientId
INNER JOIN InvoiceLineItem ON Invoice.InvoiceId = InvoiceLineItem.InvoiceId
WHERE Invoice.InvoiceStatus = 2
GROUP BY ClientId
HAVING SUM(Price*Quantity) > 1000
ORDER BY LastName, FirstName;

-- Count exercises by category.
-- Group by ExerciseCategory.Name.
-- Order by exercise count descending.
-- 13 rows
--------------------
SELECT COUNT(ExerciseId) AS 'Number of Exercises', ExerciseCategory.Name
FROM Exercise
INNER JOIN ExerciseCategory ON Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId
GROUP BY ExerciseCategory.Name
ORDER BY COUNT(ExerciseId) DESC;

-- Select Exercise.Name along with the minimum, maximum,
-- and average ExerciseInstance.Sets.
-- Order by Exercise.Name.
-- 64 rows
--------------------
SELECT 
Exercise.ExerciseId,
	Exercise.Name AS 'Exercise Name', 
    MIN(Sets) AS 'Minimum Sets', 
    MAX(Sets) AS 'Maximum Sets', 
    AVG(Sets) AS 'Average Sets'
FROM Exercise
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
GROUP BY Exercise.ExerciseId
ORDER BY Exercise.Name ASC;

-- Find the minimum and maximum Client.BirthDate
-- per Workout.
-- 26 rows
-- Sample: 
-- WorkoutName, EarliestBirthDate, LatestBirthDate
-- '3, 2, 1... Yoga!', '1928-04-28', '1993-02-07'
--------------------
SELECT Workout.Name, MIN(Birthdate) AS 'EarliestBirthDate', MAX(Birthdate) AS 'LatestBirthDate'
FROM Client
INNER JOIN ClientWorkout ON Client.ClientId = ClientWorkout.ClientId
INNER JOIN Workout ON ClientWorkout.WorkoutId = Workout.WorkoutId
GROUP BY Workout.Name
ORDER BY Workout.Name ASC;

-- Count client goals.
-- Be careful not to exclude rows for clients without goals.
-- 500 rows total
-- 50 rows with no goals
--------------------
SELECT FirstName, LastName, COUNT(ClientGoal.ClientId) AS 'Client Goals'
FROM Client
LEFT OUTER JOIN ClientGoal ON Client.ClientId = ClientGoal.ClientId
GROUP BY Client.ClientId
ORDER BY COUNT(ClientGoal.ClientId), LastName;

-- Select Exercise.Name, Unit.Name, 
-- and minimum and maximum ExerciseInstanceUnitValue.Value
-- for all exercises with a configured ExerciseInstanceUnitValue.
-- Order by Exercise.Name, then Unit.Name.
-- 82 rows
--------------------
SELECT
	Exercise.Name AS 'ExerciseName', 
    Unit.Name AS 'UnitName',
    MIN(ExerciseInstanceUnitValue.Value) AS 'MinValue',
    MAX(ExerciseInstanceUnitValue.Value) AS 'MaxValue'
FROM Exercise
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId
INNER JOIN Unit ON ExerciseInstanceUnitValue.UnitId = Unit.UnitId
GROUP BY Exercise.ExerciseId, Unit.Name
ORDER BY Exercise.Name, Unit.Name;

-- Modify the query above to include ExerciseCategory.Name.
-- Order by ExerciseCategory.Name, then Exercise.Name, then Unit.Name.
-- 82 rows
--------------------
SELECT
	ExerciseCategory.Name AS 'ExerciseCategory',
	Exercise.Name AS 'ExerciseName', 
    Unit.Name AS 'UnitName',
    MIN(ExerciseInstanceUnitValue.Value) AS 'MinValue',
    MAX(ExerciseInstanceUnitValue.Value) AS 'MaxValue'
FROM Exercise
INNER JOIN ExerciseCategory ON Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId
INNER JOIN Unit ON ExerciseInstanceUnitValue.UnitId = Unit.UnitId
GROUP BY ExerciseCategory.Name, Exercise.ExerciseId, Unit.Name
ORDER BY Exercise.Name, Unit.Name;

-- Select the minimum and maximum age in years for
-- each Level.
-- To calculate age in years, use the MySQL function DATEDIFF.
-- 4 rows
--------------------
SELECT 
	Level.Name AS 'Level Name', 
	MIN(DATEDIFF(NOW(), Client.BirthDate)/365) AS 'Minimum Age', 
    MAX(DATEDIFF(NOW(), Client.BirthDate)/365) AS 'Maximum Age'
FROM Level
INNER JOIN Workout ON Level.LevelId = Workout.LevelId
INNER JOIN ClientWorkout ON Workout.WorkoutId = ClientWorkout.WorkoutId
INNER JOIN Client ON ClientWorkout.ClientId = Client.ClientId
GROUP BY Level.LevelId;

-- Stretch Goal!
-- Count logins by email extension (.com, .net, .org, etc...).
-- Research SQL functions to isolate a very specific part of a string value.
-- 27 rows (27 unique email extensions)
--------------------

-- Stretch Goal!
-- Match client goals to workout goals.
-- Select Client FirstName and LastName and Workout.Name for
-- all workouts that match at least 2 of a client's goals.
-- Order by the client's last name, then first name.
-- 139 rows
--------------------