<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.server.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Students</title>
<style>
    /* General Body Styling */
    body {
        font-family: 'Open Sans', Arial, sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(120deg, #89f7fe, #66a6ff);
        color: #333;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    /* Header Styling */
    h1 {
        margin: 20px 0;
        font-size: 2.8em;
        color: #ffffff;
        text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.4);
    }

    /* Action Buttons Styling */
    .action-buttons {
        margin-bottom: 20px;
        display: flex;
        justify-content: center;
        gap: 15px;
    }
    .action-buttons button {
        padding: 10px 20px;
        border: none;
        border-radius: 10px;
        background: #ffffff;
        color: #007bff;
        font-size: 1em;
        cursor: pointer;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        transition: transform 0.3s ease, background-color 0.3s ease;
    }
    .action-buttons button:hover {
        background: #007bff;
        color: #ffffff;
        transform: scale(1.05);
    }

    /* Container for Cards */
    .container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 20px;
        padding: 20px;
        max-width: 1200px;
    }

    /* Card Styling */
    .card {
        background: #ffffff;
        border-radius: 15px;
        width: 320px;
        padding: 20px;
        box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    .card:hover {
        transform: translateY(-10px);
        box-shadow: 0 12px 25px rgba(0, 0, 0, 0.2);
    }
    .card h2 {
        font-size: 1.5em;
        margin-bottom: 10px;
        color: #007bff;
        text-align: center;
    }
    .card p {
        font-size: 0.95em;
        margin: 8px 0;
        line-height: 1.5;
        color: #333;
    }
    .card p strong {
        color: #007bff;
    }

    /* Button Inside Cards */
    .card a button {
        margin-top: 15px;
        padding: 8px 12px;
        border: none;
        border-radius: 8px;
        background: #007bff;
        color: #ffffff;
        cursor: pointer;
        font-size: 0.9em;
        transition: background 0.3s ease, transform 0.3s ease;
    }
    .card a button:hover {
        background: #0056b3;
        transform: scale(1.1);
    }

    /* No Data Message */
    .no-data {
        font-size: 1.2em;
        color: #ffffff;
        margin-top: 20px;
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.3);
    }
</style>
</head>
<body>
    <h1>Student List</h1>
    <div class="action-buttons">
        <a href="addStudent.jsp"><button>Add Student</button></a>
    </div>
    <div class="container">
        <%! ArrayList<Student> slist; %>
        <%
        slist = (ArrayList<Student>) session.getAttribute("slist"); 
        if (slist != null && !slist.isEmpty()) {
            for(Student s : slist) {
        %>
        <div class="card">
            <h2>ID: <%= s.getStudent_id() %></h2>
            <p><strong>Name:</strong> <%= s.getStudent_name() %></p>
            <p><strong>Email:</strong> <%= s.getStudent_email() %></p>
            <p><strong>Address:</strong> <%= s.getStudent_address() %></p>
            <p><strong>Mobile:</strong> <%= s.getStudent_mobile() %></p>
            <p><strong>Password:</strong> <%= s.getPassword() %></p>
            <a href="EditStudent.jsp?student_id=<%= s.getStudent_id() %>"><button>Edit</button></a>
            <a href="DeleteStudent?student_id=<%= s.getStudent_id() %>"><button>Delete</button></a>
        </div>
        <%
            }
        } else {
        %>
        <div class="no-data">No students available.</div>
        <%
        }
        %>
    </div>
</body>
</html>
