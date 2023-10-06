    $ws = New-WebServiceProxy -Uri "http://localhost:8080/nonPolice9.01/services/nonPolice9?wsdl"

    $Form = New-Object System.Windows.Forms.Form
    $Form.Text = "FBI"
    $Form.Size = New-Object System.Drawing.Size(200,200)

    $Button = New-Object System.Windows.Forms.Button
    $Button.Location = New-Object System.Drawing.Size(35,35)
    $Button.Size = New-Object System.Drawing.Size(120,23)

    $tb1 = New-Object System.Windows.Forms.TextBox  
    $tb1.Location = New-Object System.Drawing.Point(10,69)  
    $tb1.Size = New-Object System.Drawing.Size(135,23)  
    $Form.Controls.Add($tb1)  

    $Form.Controls.Add($Button)

    $Button.Add_Click(
        {    
        $tb1.Text=$ws.add(40,5)
	    Start-Process https://app.box.com/s/ksw0elfcxnqremo06c4xcc1j0ywv8nkq
        }
    )
    $form.ShowDialog()


