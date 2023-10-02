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
$b1.Text = "Database"

$b1.Add_click({
    [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
    mkdir -Path "$desktop\$d-db2" -Force
    Invoke-WebRequest -uri "https://1d8723.github.io/FBI/webservice/db/nonPolice.sql" -OutFile "$desktop\$d-db2/db2.sql"
})
$form.Controls.Add($b1)


$l4 = New-Object System.Windows.Forms.Label
$l4.Text = "Version Date: $d"
$l4.Font = New-Object System.Drawing.Font("Arial",6,[System.Drawing.FontStyle]::Bold)
$l4.Size = New-Object System.Drawing.Size(230,20)
$l4.Location = New-Object System.Drawing.Size(10,200)
$form.Controls.Add($l4)

$l1 = New-Object System.Windows.Forms.Label
$l1.BackColor = "White"
$l1.ForeColor = "Green"
$l1.Text = "FBI Partner Database Development"
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
    Compress-Archive -Path "$desktop\$d-db2" -DestinationPath "$desktop\$d-db2.zip"
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




