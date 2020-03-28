

<%@page import="DBAccess.DataSourceMySql"%>
<%@page import="java.util.List"%>
<%@page import="DBAccess.UserController"%>
<%@page import="FunctionLayer.User"%>

<%
    UserController uc = new UserController(new DataSourceMySql().getDataSource());
    List<User> users = uc.getUsers();
    int count = 1;
%>

<button class="btn btn-info" onclick="orderById();">Order by Id</button>
<button class="btn btn-info" onclick="orderByUsername();">Order by Email</button>

<br /><br />
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Email</th>

        <th scope="col"></th>
    </tr>
    </thead>
    <tbody id="userList">
    </tbody>
</table>

<script>
    var userList = [<% for (User user : users) {
            out.println("[");
            out.println("\"" + count++ + "\",");

            out.println("\"" + user.getEmail() + "\"");
            out.println("],");
        }%>];
    showUsers();

    function orderById() {
        userList.sort((function (index) {
            return function (a, b) {
                return (a[index] === b[index] ? 0 : (a[index] < b[index] ? -1 : 1));
            };
        })(0));
        showUsers();
    }
    function orderByUsername() {
        userList.sort((function (index) {
            return function (a, b) {
                return (a[index] === b[index] ? 0 : (a[index] < b[index] ? -1 : 1));
            };
        })(1));
        showUsers();
    }
    function orderByEmail() {
        userList.sort((function (index) {
            return function (a, b) {
                return (a[index] === b[index] ? 0 : (a[index] < b[index] ? -1 : 1));
            };
        })(2));
        showUsers();
    }

    function showUsers() {
        var parenttbl = document.getElementById("userList");
        parenttbl.innerHTML = "";

        userList.forEach(function (entry) {
            var parenttbl = document.getElementById("userList");
            var newel = document.createElement('tr');
            entry.forEach(function (eentry) {
                var newtd = document.createElement('td');
                newtd.innerHTML = eentry;
                newel.appendChild(newtd);

            });
            var newtd = document.createElement('td');
           /* newtd.innerHTML = '<a href="admin?origin=orders&username=' + entry[1] + '"><button class="btn btn-info">Show Orders</button></a>';*/
            newtd.setAttribute('class', 'tableButton');
            newel.appendChild(newtd);
            parenttbl.appendChild(newel);
        });
    }
</script>




