<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
            color: #495057;
        }

        .container {
            margin-top: 50px;
        }

        .my-heading {
            text-align: center;
            margin-bottom: 30px;
            font-family: 'Arial', sans-serif;
        }

        .my-btn-group {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .my-btn {
            margin: 10px;
        }

        .my-btn a {
            text-decoration: none;
            color: #fff;
        }

        .my-btn a:hover {
            color: #fff;
            text-decoration: none;
        }

        .my-btn a:focus {
            color: #fff;
            text-decoration: none;
        }

        .my-btn button {
            transition: transform 0.3s;
        }

        .my-btn button:hover {
            transform: scale(1.1);
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
    </style>
</head>

<body>
<div class="container">
    <h1 class="my-heading">Natthaphol Nirattisaikul <br> 65130500105</h1>
    <div class="my-btn-group">
        <div class="my-btn">
            <a href="office-list">
                <button type="button" class="btn btn-custom btn-lg">Explore Office Servlet</button>
            </a>
        </div>
    </div>
</div>
</body>

</html>
