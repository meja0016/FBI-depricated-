Add-Type -AssemblyName System.Drawing
Add-Type -AssemblyName System.Windows.Forms
$w = New-WebServiceProxy -uri http://localhost:8080/nonPolice/services/nonPolice?wsdl
$f = New-Object System.Windows.Forms.Form 
$l1 = New-Object System.Windows.Forms.Label
$l1.Size = New-Object System.Drawing.Size(295,15)
$l1.BackColor = "black"
$l1.ForeColor = "White"
$l1.Text = "                                     FBI"
$l2 = New-Object System.Windows.Forms.Label
$l2 = New-Object System.Windows.Forms.Label
$l2.Size = New-Object System.Drawing.Size(295,15)
$l2.Location = New-Object System.Drawing.Size(0,15)
$l2.BackColor = "Red"
$l2.ForeColor = "White"
$l2.Text = "                                     Development"
$l3 = New-Object System.Windows.Forms.Label
$l3.Location = New-Object System.Drawing.Size(200,200)
$l3.Text = "n/a";
$f.Controls.Add($l1) 
$f.Controls.Add($l2) 
$f.Controls.Add($l3) 
$b = New-Object System.Windows.Forms.Button
$b.location = New-Object System.Drawing.Size(0,200)
$b.Add_click({$l3.Text= 0;$l3.Text= $w.add(1,1);})
$f.Controls.Add($b)
$f.ShowDialog()