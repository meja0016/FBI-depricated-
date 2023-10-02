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
    $tb1.Size = New-Object System.Drawing.Size(20,23)  
    $Form.Controls.Add($tb1)  

    $tb2 = New-Object System.Windows.Forms.TextBox  
    $tb2.Location = New-Object System.Drawing.Point(55,40)  
    $tb2.Size = New-Object System.Drawing.Size(20,23)  
    $Form.Controls.Add($tb2)  

$r1 = New-Object System.Windows.Forms.label
$r1.Location = New-Object System.Drawing.Size(85,40)
$r1.Size = New-Object System.Drawing.Size(20,23)
$r1.BackColor = ""
$r1.ForeColor = "white"
$r1.Text = "90"
$Form.Controls.Add($r1)

    $tb01 = New-Object System.Windows.Forms.TextBox  
    $tb01.Location = New-Object System.Drawing.Point(20,70)  
    $tb01.Size = New-Object System.Drawing.Size(20,23)

$Form.Controls.Add($tb01)  

$tb02 = New-Object System.Windows.Forms.TextBox  
$tb02.Location = New-Object System.Drawing.Point(55,70)  
$tb02.Size = New-Object System.Drawing.Size(20,23)  
$Form.Controls.Add($tb02)  

$tb04 = New-Object System.Windows.Forms.TextBox  
$tb04.Location = New-Object System.Drawing.Point(10,130)  
$tb04.Size = New-Object System.Drawing.Size(5,2)  
$tb04.Add_Click({
    
})
$Form.Controls.Add($tb04)  


$r2 = New-Object System.Windows.Forms.label
$r2.Location = New-Object System.Drawing.Size(85,70)
$r2.Size = New-Object System.Drawing.Size(20,23)
$r2.BackColor = ""
$r2.ForeColor = "white"
$r2.Text = "45"
    $Form.Controls.Add($r2)
     
    $Button = New-Object System.Windows.Forms.Button
    $Button.Location = New-Object System.Drawing.Size(20,100)
    $Button.Size = New-Object System.Drawing.Size(135,25)
    $Button.Text = "Install"

    $Button2 = New-Object System.Windows.Forms.Button
    $Button2.Location = New-Object System.Drawing.Size(20,129)
    $Button2.Size = New-Object System.Drawing.Size(135,23)
    $Button2.Text = "Start"

    $Button.Add_Click(
        {    
        Invoke-WebRequest -uri https://github.com/1D8723/FBI/raw/main/webservice/nonPolice.war -OutFile nonPolice.war
        Invoke-WebRequest -uri https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.78/bin/apache-tomcat-9.0.78.zip -OutFile app.zip
        Invoke-WebRequest -uri https://github.com/ibmruntimes/semeru20-binaries/releases/download/jdk-20.0.1%2B9_openj9-0.39.0/ibm-semeru-open-jdk_x64_windows_20.0.1_9_openj9-0.39.0.zip -OutFile jvm.zip
        Expand-Archive -Path app.zip -DestinationPath ibm
        Expand-Archive -Path jvm.zip -DestinationPath ibm\jvm
        Move-item -Path ibm\apache-tomcat-9.0.78\* -Destination ibm\
        Move-item -Path ibm\jvm\jdk-20*\* -Destination ibm\jvm\
        Move-item -Path nonPolice.war -Destination ibm\webapps\
        Del ibm\apache-tomcat-9.0.78
        Del app.zip
        Del jvm.zip
        Del ibm\*.txt
        Del ibm\*.md
        Del ibm\RELEASE-NOTES
        Del ibm\NOTICE
        Del ibm\LICENSE
        Remove-Item -Path ibm\work -Recurse
        Del app\logs\*
        Remove-Item -Path ibm\webapps\docs -Recurse
        Remove-Item -Path ibm\webapps\examples -Recurse
        Remove-Item -Path ibm\webapps\host-manager -Recurse
        Remove-Item -Path ibm\webapps\manager -Recurse
        Remove-Item -Path ibm\webapps\ROOT -Recurse
        Remove-Item -Path ibm\webapps\temp -Recurse
        Del ibm\logs\*
        Del ibm\jvm\jdk-20.0.1+9
        Del ibm\bin\*.tar.gz
        Del ibm\bin\*.sh
        
        $env:JAVA_HOME="ibm\jvm\"
        $env:CATALINA_HOME="ibm"
        }
 
    )
    $Form.Controls.Add($Button)
      $Button2.Add_Click({
        $env:Title="IBM Web Service - Partner"
        Start-Job -ScriptBlock {
            ibm\bin\catalina.bat start
        }
        sleep 5
        $ws = New-WebServiceProxy -uri http://localhost:8080/nonPolice/wsdl/nonPolice.wsdl
        $r1.Text=$ws.add($tb2.Text,$tb1.Text)
        $r1.ForeColor = "black"
        $r2.Text=$ws.add($tb02.Text,$tb01.Text)
        $r2.ForeColor="Black"

        cp ibm\webapps\nonPolice\nonPolice.j
        ava  ibm\webapps\nonPolice\WEB-INF\classes\nonPolice
        explorer ibm\webapps\nonPoliclsce\WEB-INF\classes\nonPolice
      })  
    $Form.Controls.Add($Button2)
    $form.ShowDialog()