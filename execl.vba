Private Sub CommandButton1_Click()
    Dim folder As String
     folder = "C:\Users\Custom-tc-cen06\Desktop\enterpriseArchive.nonPoliceJustice\webarchive.DomesticViolance\"
    ''  MkDir (folder)
     '' MkDir (folder + "\META-INF\")
     '' MkDir (folder + "\WEB-INF\")
    ''  MkDir (folder + "\WEB-INF\classes")
    ''  MkDir (folder + "\WEB-INF\lib")
      

     ''For I = 1 To 20
     '' ActiveSheet.Cells(I, 3).Select
     '' MsgBox (ActiveSheet.Cells(I, 3).Value)
     ''Next
  
    Set fs = CreateObject("Scripting.FileSystemObject")
    Set a = fs.CreateTextFile(folder + "\WEB-INF\web.xml", True)
    a.WriteLine ("<?xml version='1.0' encoding='ISO-8859-1'?><web-app xmlns='http://java.sun.com/xml/ns/j2ee'    xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'    xsi:schemaLocation='http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd'    version='2.4'>    <display-name>Hello, World Application</display-name>    <description>        This is a simple web application with a source code organization        based on the recommendations of the Application Developer's Guide.    </description>    <servlet>        <servlet-name>HelloServlet</servlet-name>        <servlet-class>mypackage.Hello</servlet-class>    </servlet>    <servlet-mapping>        <servlet-name>HelloServlet</servlet-name>        <url-pattern>/hello</url-pattern>    </servlet-mapping></web-app>")
    a.Close
   
   Set a = fs.CreateTextFile(folder + "\nonPoliceTest.jsp", True)
   a.WriteLine ("<html><head><title>Web Service</title></head><body><%double num = Math.random(); if (num > 0.95) {%> <h2>You'll have a luck day!</h2><p>(<%= num %>)</p><%} else {%><h2>Well, life goes on ... </h2><p>(<%= num %>)</p><%}%><a href='<%= request.getRequestURI() %>'><h3>Try Again</h3></a></body></html>")
   a.Close
End Sub
