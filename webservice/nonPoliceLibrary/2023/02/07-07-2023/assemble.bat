if "%1" == "" start "" /min "%~f0" MY_FLAG && exit
@echo Add-Type -AssemblyName System.Windows.Forms > %temp%\file.ps1
@echo $f                    = New-Object system.Windows.Forms.Form >>  %temp%\file.ps1
@echo $f.ClientSize         = '500,300' >>  %temp%\file.ps1
@echo $f.text               = 'nonPoliceLazyEye' >>   %temp%\file.ps1
@echo $f.BackColor          = '#ffffff' >>  %temp%\file.ps1


@echo $l = New-Object System.Windows.Forms.Label >> %temp%\file.ps1
@echo $l.Location = New-Object System.Drawing.Point(10,20) >> %temp%\file.ps1
@echo $l.Size = New-Object System.Drawing.Size(280,20) >> %temp%\file.ps1
@echo $l.Text =(New-WebServiceProxy -Uri "http://localhost:8080/nonPolice9.01/services/nonPolice9?wsdl").add(40,5) >> %temp%\file.ps1
@echo $f.Controls.Add($l) >> %temp%\file.ps1

@echo $textBox = New-Object System.Windows.Forms.TextBox>> %temp%\file.ps1
@echo $textBox.Location = New-Object System.Drawing.Point(10,40)>> %temp%\file.ps1
@echo $textBox.Size = New-Object System.Drawing.Size(260,20)>> %temp%\file.ps1
@echo $f.Controls.Add($textBox)>> %temp%\file.ps1

@echo $okButton = New-Object System.Windows.Forms.Button>> %temp%\file.ps1
@echo $okButton.Location = New-Object System.Drawing.Point(75,120)>> %temp%\file.ps1
@echo $okButton.Size = New-Object System.Drawing.Size(75,23)>> %temp%\file.ps1
@echo $okButton.Text = 'OK'>> %temp%\file.ps1
@echo $okButton.DialogResult = [System.Windows.Forms.DialogResult]::OK>> %temp%\file.ps1

@echo $f.Controls.Add($okButton)>> %temp%\file.ps1

@echo $result = $f.ShowDialog() >> %temp%\file.ps1


@Powershell.exe -ExecutionPolicy Bypass -File  %temp%\file.ps1