<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Office-Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="styles.css"/>
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 20px;
        }

        .header {
            background-color: rosybrown;
            color: #fff;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        .btn-custom {
            background-color: rosybrown;
            border-color: rosybrown;
            color: white;
        }

        .btn-custom:hover {
            background-color: saddlebrown;
            border-color: saddlebrown;
            color: white;
        }

        .office-card {
            border: 1px solid rosybrown;
            border-radius: 10px;
            padding: 10px;
            margin: 10px 30px;
            transition: transform 0.3s;
        }

        .office-card:hover {
            transform: scale(1.05);
        }

        .office-title {
            font-size: 1.2rem;
            color: rosybrown;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .office-details {
            color: #495057;
        }

        .action-buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }

        .action-buttons button {
            margin-right: 5px;
        }

        .employee-card {
            border: 1px solid rosybrown;
            border-radius: 10px;
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Classic Model Offices</h1>
    </div>
    <!-- Search bar and buttons -->


    <div class="row">
        <%--    select page--%>
        <div class="col-2 mt-2 ">
            <a class="btn btn-custom right" href="office-list" role="button">OFFICE-LIST</a>
        </div>
        <div class="col-2 mt-2">
            <form action="office-add" method="get" class="pr-2">
                <input type="submit" class="btn btn-dark" value="ADD-OFFICE">
            </form>
        </div>
        <div class="col-2"></div>
        <%--            search--%>
        <div class="col-5">
            <form action="office-list" method="get" class="d-inline right form-inline mt-2 pr-0">
                <input class="form-control" type="text" name="search" value="${search}">
                <input class="btn btn-info" type="submit" value="SEARCH">
            </form>
        </div>
        <%--            reset search--%>
        <div class="col-1 ml-0 pl-0">
            <form action="office-list" method="get" class="d-inline">
                <input class="mt-2 btn btn-warning" type="submit" value="RESET">
            </form>
        </div>
    </div>

    <div class="row">
        <!-- Office list -->
        <c:forEach items="${offices}" var="office">
            <div class="col-3 office-card">
                <div class="office-title">OFFICE ${office.officeCode}</div>
                <div class="office-details">
                    <a href="office-list?officeCode=${office.officeCode}">${office.city}</a>, ${office.country}
                    <div>${office.phone}</div>
                </div>
                <div class="action-buttons">
                    <a href="office-update?officeCode=${office.officeCode}">
                        <button class="btn btn-success btn-sm">EDIT</button>
                    </a>
                    <form action="office-list" method="post">
                        <input type="hidden" name="delete" value="${office.officeCode}">
                        <button class="btn btn-danger btn-sm">DELETE</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>

    <br>
    <div class="row bg-light"><b>Employees ::</b></div>
    <div class="row">

        <c:forEach items="${selectedOffice.employeeList}" var="employee">
            <div class="employee-card col-2 pl-2 m-2 border border-secondary rounded-pill">
                <div> ${employee.firstName}
                        ${employee.lastName} - ${employee.jobTitle}
                </div>
            </div>
        </c:forEach>
    </div>
    <hr>
</div>
</body>
</html>