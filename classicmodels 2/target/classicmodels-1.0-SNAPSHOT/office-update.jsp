<%--
  Created by IntelliJ IDEA.
  User: 9inejames
  Date: 7/11/2023 AD
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UPDATE OFFICE</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="styles.css"/>
</head>
<style>body {
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
</style>
<body>
<div class="container">
    <div class="header">
        <h1 class="col-8">Update Office ::</h1>
    </div>
    <div class="row">
        <div class="col-2 mt-2 ">
            <a class="btn btn-dark right" href="office-list" role="button">OFFICE-LIST</a>
        </div>
        <div class="col-2 mt-2">
            <form action="office-add" method="get" class="pr-2">
                <input type="submit" class="btn btn-dark" value="ADD-OFFICE">
            </form>
        </div>
        <div class="col-8"></div>
    </div>
    <form action="office-update" method="post">
        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="offCode">Office Code:<span style="color: red">*</span></label><br>
                <input type="text" class="form-control form-control-lg" id="offCode" name="offCode"
                       value="${requestScope.office.officeCode}" readonly required>
            </div>
            <div class="form-group col-md-7">
                <label for="city">City:<span style="color: red">*</span></label><br>
                <input type="text" class="form-control form-control-lg" id="city" name="city"
                       value="${requestScope.office.city}" required>
            </div>
            <div class="form-group col-md-3">
                <label for="phone">Phone:<span style="color: red">*</span></label><br>
                <input type="text" class="form-control form-control-lg" id="phone" name="phone"
                       value="${requestScope.office.phone}" required>
            </div>

            <div class="form-group col-md-6">
                <label for="address1" class="ml-2">Address Line1:<span style="color: red">*</span></label>
                <textarea class="form-control form-control-lg" id="address1" rows="3" name="addressLine1"
                          required>${requestScope.office.addressLine1}</textarea>
            </div>
            <div class="form-group col-md-6">
                <label for="address2" class="ml-2">Address Line2</label>
                <textarea class="form-control form-control-lg" id="address2" rows="3"
                          name="addressLine1">${requestScope.office.addressLine2}</textarea>
            </div>
            <div class="form-group col-md-3">
                <label for="state">State:</label><br>
                <input type="text" class="form-control form-control-lg" id="state" name="state"
                       value="${requestScope.office.state}" required>
            </div>
            <div class="form-group col-md-3">
                <label for="country">Country:<span style="color: red">*</span></label><br>
                <input type="text" class="form-control form-control-lg" id="country" name="country"
                       value="${requestScope.office.country}" required>
            </div>
            <div class="form-group col-md-3">
                <label for="postalCode">Postal Code:<span style="color: red">*</span></label><br>
                <input type="text" class="form-control form-control-lg" id="postalCode" name="postalCode"
                       value="${requestScope.office.postalCode}" required>
            </div>
            <div class="form-group col-md-3">
                <label for="territory">Territory:<span style="color: red">*</span></label><br>
                <input type="text" class="form-control form-control-lg" id="territory" name="territory"
                       value="${requestScope.office.territory}" required>
            </div>

        </div>
        <br>
        <div class="right">
            <input class="btn btn-success" type="submit" value="UPDATE OFFICE">
        </div>
    </form>
    <br>


    <hr>


</div>


</body>
</html>
