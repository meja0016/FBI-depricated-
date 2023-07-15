 [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12


    $Form = New-Object System.Windows.Forms.Form
    $Form.Text = "FBI"
    $Form.Size = New-Object System.Drawing.Size(200,200)

$l1 = New-Object System.Windows.Forms.label
$l1.Location = New-Object System.Drawing.Size(0,12)
$l1.Size = New-Object System.Drawing.Size(190,13)
$l1.BackColor = "Red"
$l1.ForeColor = "white"
$l1.Text = "                     development"
$Form.Controls.Add($l1)

$l2 = New-Object System.Windows.Forms.label
$l2.Location = New-Object System.Drawing.Size(0,0)
$l2.Size = New-Object System.Drawing.Size(190,15)
$l2.BackColor = "Black"
$l2.ForeColor = "white"
$l2.Text = "                            FBI"
$Form.Controls.Add($l2)

$l2 = New-Object System.Windows.Forms.label
$l2.Location = New-Object System.Drawing.Size(0,25)
$l2.Size = New-Object System.Drawing.Size(190,15)
$l2.BackColor = "Transparent"
$l2.ForeColor = "Black"
$l2.Text = "     Web Service - Installation"
$Form.Controls.Add($l2)


    $tb1 = New-Object System.Windows.Forms.TextBox  
    $tb1.Location = New-Object System.Drawing.Point(20,40)  
    $tb1.Size = New-Object System.Drawing.Size(135,23)  
    $Form.Controls.Add($tb1)  

    $tb2 = New-Object System.Windows.Forms.TextBox  
    $tb2.Location = New-Object System.Drawing.Point(20,65)  
    $tb2.Size = New-Object System.Drawing.Size(135,23)  
    $Form.Controls.Add($tb2)  

    $tb3 = New-Object System.Windows.Forms.TextBox  
    $tb3.Location = New-Object System.Drawing.Point(20,95)  
    $tb3.Size = New-Object System.Drawing.Size(135,23)  
    $Form.Controls.Add($tb3)  
     
    $Button = New-Object System.Windows.Forms.Button
    $Button.Location = New-Object System.Drawing.Size(20,129)
    $Button.Size = New-Object System.Drawing.Size(135,23)

    $Button2 = New-Object System.Windows.Forms.Button
    $Button2.Location = New-Object System.Drawing.Size(30,100)
    $Button2.Size = New-Object System.Drawing.Size(135,23)
   

    $Button.Add_Click(
        {    
        $tb3.Text="n/A"
        $tb1.Text="n/A"
        $tb2.Text="n/A"
        Invoke-WebRequest -uri https://github.com/1D8723/FBI/raw/main/webservice/nonPolice.war -OutFile nonPolice.war
        Invoke-WebRequest -uri https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.78/bin/apache-tomcat-9.0.78.zip -OutFile app.zip
        Invoke-WebRequest -uri https://download.oracle.com/java/20/latest/jdk-20_windows-x64_bin.zip -OutFile jvm.zip
        Expand-Archive -Path app.zip -DestinationPath app
        Expand-Archive -Path jvm.zip -DestinationPath app\jvm
        Move-item -Path app\apache-tomcat-9.0.78\* -Destination app\
        Move-item -Path app\jvm\jdk-20.0.1\* -Destination app\jvm\
        Move-item -Path nonPolice.war -Destination app\webapps\
        Del app.zip
        Del jvm.zip
        Del app\*.txt
        Del app\*.md
        Del app\RELEASE-NOTES
        Del app\NOTICE
        Del app\LICENSE
        Remove-Item -Path app\work -Recurse
        Del app\logs\*
        Remove-Item -Path app\webapps\docs -Recurse
        Remove-Item -Path app\webapps\examples -Recurse
        Remove-Item -Path app\webapps\host-manager -Recurse
        Remove-Item -Path app\webapps\manager -Recurse
        Remove-Item -Path app\webapps\ROOT -Recurse
        Remove-Item -Path app\webapps\temp -Recurse
        Del app\logs\*
        Del app\bin\*.tar.gz
        Del app\bin\*.sh
        
        $env:JAVA_HOME="app\jvm\"
        $env:CATALINA_HOME="app"


        }
 
    )
    $Form.Controls.Add($Button)
      $Button2.Add_Click({
        app\bin\catalina.bat start
        sleep 5
        $tb2.Text=40
        $tb1.Text=5
        $ws = New-WebServiceProxy -uri http://localhost:8080/nonPolice/wsdl/nonPolice.wsdl
        $tb2.Text=$ws.add($tb3.Text,$tb1.Text)
      })  
       $Form.Controls.Add($Button2)
    $form.ShowDialog()