 [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12


    $Form = New-Object System.Windows.Forms.Form
    $Form.Text = "FBI"
    $Form.Size = New-Object System.Drawing.Size(200,200)
$Form.ForeColor = "Black"
$Form.BackColor = "Black"

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
$l2.Text = "     Web Service - nonPoliceEditor"
$Form.Controls.Add($l2)

$tb01 = New-Object System.Windows.Forms.TextBox  
$tb01.Location = New-Object System.Drawing.Point(0,40)  
$tb01.Size = New-Object System.Drawing.Size(180,100)
$tb01.ForeColor="White"
$tb01.BackColor = "Black"
$tb01.MultiLine = "True"
$tb01.Text = "public Strin runTransaction(){}"

$Form.Controls.Add($tb01)

$r2 = New-Object System.Windows.Forms.label
$r2.Location = New-Object System.Drawing.Size(85,70)
$r2.Size = New-Object System.Drawing.Size(20,23)
$r2.BackColor = ""
$r2.ForeColor = "black"
$r2.Text = "45"

$Form.Controls.Add($r2)
     
$Button2 = New-Object System.Windows.Forms.Button
$Button2.Location = New-Object System.Drawing.Size(20,100)
$Button2.Size = New-Object System.Drawing.Size(135,23)
$Button2.Text = "Start"

    $Button.Add_Click({})

    $Form.Controls.Add($Button)
    $form.ShowDialog()