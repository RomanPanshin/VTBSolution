import mysql.connector
import json
import random

# Connect to the MySQL database
conn = mysql.connector.connect(
    host="localhost",
    user="spring",
    password="springpassword",
    database="mydatabase"
)

cursor = conn.cursor()

# Create tables
cursor.execute("""
CREATE TABLE IF NOT EXISTS branches (
    id INT AUTO_INCREMENT PRIMARY KEY,
    salePointName VARCHAR(255),
    address VARCHAR(255),
    status VARCHAR(50),
    rko VARCHAR(50),
    officeType VARCHAR(50),
    salePointFormat VARCHAR(50),
    suoAvailability CHAR(1),
    hasRamp CHAR(1),
    latitude FLOAT,
    longitude FLOAT,
    metroStation VARCHAR(255),
    distance FLOAT,
    kep BOOLEAN,
    myBranch BOOLEAN
)
""")

cursor.execute("""
CREATE TABLE IF NOT EXISTS open_hours (
    branch_id INT,
    day VARCHAR(10),
    hours VARCHAR(50),
    capacity INT,
    FOREIGN KEY (branch_id) REFERENCES branches(id)
)
""")

cursor.execute("""
CREATE TABLE IF NOT EXISTS functions (
    branch_id INT,
    function_name VARCHAR(255),
    FOREIGN KEY (branch_id) REFERENCES branches(id)
)
""")

# Load and parse JSON data
with open("offices.txt", "r") as f:
    data = json.load(f)

# Functions list
functions_list = [
    "Оформление и обслуживание вкладов",
    "Оформление потребительских и ипотечных кредитов",
    "Выпуск и восстановление карты",
    "Выдача и обмен валюты",
    "Международные переводы",
    "Услуги страхования"
]

# Insert branches data into the database
for branch in data:
    cursor.execute("INSERT INTO branches (salePointName, address, status, rko, officeType, salePointFormat, suoAvailability, hasRamp, latitude, longitude, metroStation, distance, kep, myBranch) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", (branch['salePointName'], branch['address'], branch['status'], branch['rko'], branch['officeType'], branch['salePointFormat'], branch['suoAvailability'], branch['hasRamp'], branch['latitude'], branch['longitude'], branch['metroStation'], branch['distance'], branch['kep'], branch['myBranch']))
    branch_id = cursor.lastrowid

    for open_hour in branch['openHours']:
        start_hour, end_hour = map(int, open_hour['hours'].split("-")[0].split(":"))
        end_hour = int(open_hour['hours'].split("-")[1].split(":")[0]) if "выходной" not in open_hour['hours'] else start_hour
        for hour in range(start_hour, end_hour):
            cursor.execute("INSERT INTO open_hours (branch_id, day, hours, capacity) VALUES (%s, %s, %s, %s)", (branch_id, open_hour['days'], f"{hour}:00-{hour + 1}:00", random.randint(1, 100)))

    random_functions = random.sample(functions_list, random.randint(2, 6))
    for function in random_functions:
        cursor.execute("INSERT INTO functions (branch_id, function_name) VALUES (%s, %s)", (branch_id, function))

conn.commit()
cursor.close()
conn.close()
