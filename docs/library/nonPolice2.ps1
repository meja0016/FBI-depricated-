[void] [System.Reflection.Assembly]::LoadWithPartialName("System.Drawing") 
[void] [System.Reflection.Assembly]::LoadWithPartialName("System.Windows.Forms")

$form = New-Object System.Windows.Forms.Form
$form.Size = New-Object System.Drawing.Size(230,260)
$form.Text = "FBI"




$desktop= [Environment]::GetFolderPath("Desktop")
$d = date -Format "MM-dd-yyyy"


$b1 = new-object System.Windows.Forms.Button
$b1.location = new-object System.Drawing.Size(10,45)
$b1.Size = new-object System.Drawing.Size(200,40)
$b1.Text = "Web Archive"

$b1.Add_click({
    [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
    mkdir -Path "$desktop\$d" -Force
    mkdir -Path "$desktop\$d\css\PNG" -Force
    mkdir -Path "$desktop\$d\WEB-INF" -Force
    mkdir -Path "$desktop\$d\WEB-INF\lib" -Force
    mkdir -Path "$desktop\$d\WEB-INF\classes" -Force
    Invoke-WebRequest -uri "https://github.com/1D8723/FBI/raw/main/css/fbi-internet-payments.png" -OutFile "$desktop\$d/css/PNG/application.png"
    Invoke-WebRequest -uri "https://1d8723.github.io/FBI/docs/library/07-10-2023/quarter.png" -OutFile "$desktop\$d/css/PNG/slides.png"
    Invoke-WebRequest -uri "https://1d8723.github.io/FBI/docs/library/07-24-2023/css/download.png" -OutFile  "$desktop\$d/css/PNG/download.png"
    Invoke-WebRequest -uri "https://1d8723.github.io/FBI/docs/library/1.jpg" -OutFile "$desktop\$d/css/PNG/1.png"
    Invoke-WebRequest -uri "https://1d8723.github.io/FBI/docs/library/2.jpg" -OutFile "$desktop\$d/css/PNG/2.png"
    Invoke-WebRequest -uri "https://1d8723.github.io/FBI/docs/library/3.jpg" -OutFile "$desktop\$d/css/PNG/3.png"
    New-Item -Path "$desktop\$d\" -Force -Name index.html  -Value "<script></script><body style='margin: 0px'><div style='background-color:black'><center><font color=white size=2em><h1>FBI</h1><sub>partner</sub></font><center><div style='background-color:red'><center><h2><font size=0.2em color=white>DEVELOPMENT</font></h2></center></div></div><br><table width=1000px align=center><tr><td valign=top><h1><font color=navy>Application</font></h1><hr><br><a href=><img src=css/PNG/application.png></a><br><h1><font color=navy>Download</font></h1><hr><a href=nonPolice.zip><img src=css/PNG/download.png></a></td><td valign=top width=600px><h1><font color=navy>Journal</font></h1><hr><br></img><a href=></a><hr><td width=200px valign=top><h1><font color=navy>Marketing</font></h2><table><tr><td><img src='css/PNG/1.png' width=200px ></img><br><br><img src='css/PNG/2.png' width=200px ></img><br><br><a href=https://quantum-computing.ibm.com/login><img src='css/PNG/3.png' width=200px ></img></a><br><sub><a href=nonPolicePresentation.html>Presentation</a></sub></td></tr></table><b><hr><img width=200px  https://1d8723.github.io/FBI/docs/library/07-24-2023/nonPolice.gif></img><br><br><audio controls><source src=poc.mp3 type=audio/mpeg></audio><br><h1><font color=navy>Sales</font></h1><hr><a href=nonPolicePresentation.html /><img src='$desktop\$d/css/PNG/slides.png'></a></td></tr></table></td></tr></table>"
    Start-Process $desktop\$d\index.html
})
$form.Controls.Add($b1)

$b2 = new-object System.Windows.Forms.Button
$b2.location = new-object System.Drawing.Size(10,100)
$b2.Size = new-object System.Drawing.Size(200,40)
$b2.Text = "Presentation"
$b2.Add_click({
    New-Item -Path "$desktop\$d" -Force -Name nonPolicePresentation.html  -Value "<script></script><body style='margin: 0px'><div style='background-color:black'><font color=white><center><h1><b>FBI </b></h1><center></font><div style='background-color:red'><center><h2><font color=white>DEVELOPMENT</font></h2></center></div></div><br><table align=center valign=top><tr><td valign=top><h1><font color=navy>Download</font></h1><hr><br><a href=$d.pptx><img src=css/PNG/download.png></img></a></td><td><h1><font color=navy>Presentation</font></h1><hr><br><a href=07-24-2023/Slide1.png><img width=600px src='07-24-2023/Slide1.png'></img></a><br><td valign=top width=200px><h1><font color=navy>Marketing</font></h2><hr><br><table><tr><td><img src='css/PNG/1.png' width=200px ></img><br><br><img src='css/PNG/2.png' width=200px ></img><br><br><a href=https://quantum-computing.ibm.com/login><img src='css/PNG/3.png' width=200px ></img></a><br><sub><a href=nonPolicePresentation.html>Presentation</a></sub></td></tr></table><hr></td></tr></table>"
    Start-Process $desktop\$d/nonPolicePresentation.html

})
$form.Controls.Add($b2)

$l4 = New-Object System.Windows.Forms.Label
$l4.Text = "Version Date: $d"
$l4.Font = New-Object System.Drawing.Font("Arial",6,[System.Drawing.FontStyle]::Bold)
$l4.Size = New-Object System.Drawing.Size(230,20)
$l4.Location = New-Object System.Drawing.Size(10,200)
$form.Controls.Add($l4)

$l1 = New-Object System.Windows.Forms.Label
$l1.BackColor = "Black"
$l1.ForeColor = "White"
$l1.Text = "FBI White Colar Crime"
$l1.Size = New-Object System.Drawing.Size(230,20)
$l1.Location = New-Object System.Drawing.Size(0,0)
$form.Controls.Add($l1)

$l2 = New-Object System.Windows.Forms.Label
$l2.BackColor = "red"
$l2.ForeColor = "White"
$l2.Text = "development"
$l2.Location = New-Object System.Drawing.Size(0,20)
$l2.Size = New-Object System.Drawing.Size(230,15)
$form.Controls.Add($l2)

$b0 = new-object System.Windows.Forms.Button
$b0.location = new-object System.Drawing.Size(10,150)
$b0.Size = new-object System.Drawing.Size(200,40)
$b0.Text = "Archive"
$b0.Add_click({
    Compress-Archive -Path "$desktop\$d\*" -DestinationPath "$desktop\$d.zip"
    Rename-Item -Path "$desktop\$d.zip" -NewName  "$desktop\$d.war"
})
$form.Controls.Add($b0)

$b4 = new-object System.Windows.Forms.Button
$b4.location = new-object System.Drawing.Size(400,400)
$b4.Size = new-object System.Drawing.Size(10,10)
$b4.Text = "Code"
$b4.Add_click({
    $str = ""
    $str = [System.Text.Encoding]::UTF8.GetString([System.Convert]::FromBase64String($str))
    New-Item -Path . -Name "$d\nonPolice2.ps1" -ItemType "file" -Value $str

})
$form.Controls.Add($b4)


$form.ShowDialog()




