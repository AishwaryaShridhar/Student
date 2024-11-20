<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(135deg, #f6d365 0%, #fda085 100%);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    h2 {
        text-align: center;
        color: #444;
        margin-bottom: 20px;
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
    }
    .form-container {
        background: #fff;
        padding: 20px 30px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        width: 100%;
        max-width: 400px;
    }
    .form-container table {
        width: 100%;
        border-collapse: collapse;
    }
    .form-container td {
        padding: 10px 5px;
        font-size: 16px;
        color: #555;
    }
    .form-container td:first-child {
        text-align: right;
        padding-right: 10px;
        font-weight: bold;
    }
    .form-container input[type="text"],
    .form-container input[type="password"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 14px;
    }
    .form-container input[type="submit"] {
        width: 100%;
        background: #fda085;
        color: #fff;
        border: none;
        padding: 10px;
        font-size: 16px;
        font-weight: bold;
        border-radius: 5px;
        cursor: pointer;
        transition: background 0.3s;
    }
    .form-container input[type="submit"]:hover {
        background: #f6d365;
    }
</style>
</head>
<body>
    <div class="form-container">
        <h2>Add Student</h2>
        <form action="addStudent" method="POST">
            <table>
                <tr>
                    <td>Student ID:</td>
                    <td><input type="text" name="student_id"></td>
                </tr>
                <tr>
                    <td>Student Name:</td>
                    <td><input type="text" name="student_name"></td>
                </tr>
                <tr>
                    <td>Student Email:</td>
                    <td><input type="text" name="student_email"></td>
                </tr>
                <tr>
                    <td>Student Address:</td>
                    <td><input type="text" name="student_address"></td>
                </tr>
                <tr>
                    <td>Student Mobile:</td>
                    <td><input type="text" name="student_mobile"></td>
                </tr>
                <tr>
                    <td>Student Password:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Add Student">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
