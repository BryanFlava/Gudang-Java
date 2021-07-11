<%@ page language="java" import ="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String name = request.getParameter("name");    
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String gender = request.getParameter("male");
    //String gender = request.getParameter("female");
    
    String country = request.getParameter("country");
    
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trimeals",
            "root", "");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into members(name,email,password,gender, country) values ('" + name + "','" + email + "','" + password + "','" + gender + "','" + country + "'");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("Login.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("Registration.jsp");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration</h1>

<form action="Registration.jsp" method="post">
<label for="name"><b>Name</b></label>
<input name="name" type="text" placeholder="name" value=""/><br>
<label for="email"><b>Email</b></label>
<input name="email" type="text" placeholder="Email" value=""/><br>
<label for="password"><b>Password</b></label>
<input name="password" type="text" placeholder="password" vlaue=""/><br>
<input type="radio" name="male" value="male" checked> Male<br>
  <input type="radio" name="female" value="female"> Female<br>
  <select>
  <option value="india">India</option>
  <option value="us">Us</option>
  <option value="chaina">Chaina</option>
  
</select><br>
<button type="submit">Register</button>
</form>

</body>
</html>