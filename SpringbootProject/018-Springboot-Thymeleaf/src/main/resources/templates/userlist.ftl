<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>userpassword</th>
            <th>useraddress</th>
        </tr>

        <#list userList as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.userpassword}</td>
                <td>${user.useraddress}</td>
            </tr>
        </#list>
    </table>
</div>


</body>
</html>
