    $ws = New-WebServiceProxy -Uri "http://www.dneonline.com/calculator.asmx?wsdl"

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
$l2.Text = "E=mc2 Assmebly WebService Calcalutor"
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

    $Form.Controls.Add($Button)

    $Button.Add_Click(
        {    
        $tb3.Text=$ws.Multiply(15,3)
        }
    )
    $form.ShowDialog()

