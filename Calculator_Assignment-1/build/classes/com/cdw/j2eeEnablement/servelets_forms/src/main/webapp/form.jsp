<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        input {
            width: 280px;
            padding: 10px;
        }
        
        
        form {
            width: 300px; 
            margin: auto;
            text-align: left;
        }
        

        input[type="radio"],
        input[type="checkbox"] {
            width: auto;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }
    </style>
</head>
<body>
        <h2>EMPLOYEE DETAILS FORM</h2>

    <form action="ServletForm" method="post">
        <p>
            First name: <input type="text" name="fname" required />
        </p>
        <p>
            Last name: <input type="text" name="lname" required />
        </p>
        <p>
            Gender:
            <input type="radio" name="Gender" value="Male" required> Male
            <input type="radio" name="Gender" value="Female" required> Female
        </p>
        <p>
            Email ID: <input type="email" name="email" required />
        </p>
        <p>
            Designation: <input type="text" name="designation" required />
        </p>
        <p>
            Phone Number: <input type="number" name="phone" required />
        </p>
        <p>
            Languages Known:
            <input type="checkbox" name="C" /> C
            <input type="checkbox" name="C++" /> C++
        </p>
        <input type="submit" name="submit" value="Submit" />
    </form>
</body>
</html>
