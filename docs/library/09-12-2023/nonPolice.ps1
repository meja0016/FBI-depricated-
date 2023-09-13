[void] [System.Reflection.Assembly]::LoadWithPartialName("System.Drawing") 
[void] [System.Reflection.Assembly]::LoadWithPartialName("System.Windows.Forms")

$csv = 
"id,name,description,year",
 "1,lux,ddr constituion HOMICIDE:LUX,1994”,
"2,rampf,soviet union constitution HOMCIDE:IS-A-BELL,1995",
"3,kystal fisher, HOMICIDE:KYSTAL,1991”,
"4,bruckshen,american wife,2003”,
"5,cat,1 cat 1 dog,2003”,
"6,dog,1 dog 1 cat,2010”,
"7,2y,SQ.CPVA,1995”,
"8,7y,Fbi kidnapping 1st grade,1994”,
"9,Stillborn,HOMCIDE:LUX:STILLBORN,1990”,
"10,Stillborn,HOMICIDE:STILLBORN §Abortion Angela Merkel phil.JFK.MKL(philpsburg) §Atomkraft WAR(kriestrasse),2000”,
"11,CHECKPOINT CHARLIE,HOMICIE:NANA,1988”,
"12,phil.JFK.MLK,HOMICIDE:phil.JFK.MLK,1993”,
"13,SQ.CPVA.HOMICIDE:SUNSTROKE,SQ.INT.FBI.investigation(charles manson),1994”,
"14,hannes,HOMICIDE:HANNES,1990”,
"15,brushini,HOMICDIE:WAKE,us-de ipx,2000”,
"16,boris ?haiduk (wolf)schlucht CPCA,HOMCIDE:BORIS,us-de ipx,2000”,
"17,fesenback, CHECKPOINT CHARLIE(KdeW) ipx HOMICIDE:BORIS redhair,2000”,
"18,tranvestite,HOMICIDE:TRANSVESTITE,2004”,
"19,Wesley,braintumor SQ.ibm:nyse:dtcc,2008”,
"20,MLK.JFK(KING),HOMIMICDEE:KING WAR(kriegstrasse),2000”,
"21,Erkan ? , HOMCIDE:AUSLAENDER CPVA.ATOMCLOCK(quartz circle), 2014”,
"22,Bill Albright, HOMICIDE:BILL Military CPVA.ATOMCLOCK(quartz circle),2014",
"23,? ? 10c, SQ.HOMICIDE:SUNSTROKE, 1994”,
"24,Bunny(rudy),HOMICIDE:BUNNY,1994”,
"25,”,
"26,”,
"27,”,
"28,”,
"29,”,
"30,”,
"31,”,
"32,”,
"33,,,,”,
"34,”,
"35,”,
"36,”,
"37,”,
"38,”,
"39,”,
"40,”,
"41,”,
"42,”,
"43,”,
"44,”,
"45,”,
"46,”,
"47,”,
"48,,,,”,
"49,”,
"50,”,
"51,”,
"52,”,
"53,”,
"54,”,
"55,”,
"56,”,
"57,”,
"58,”,
"59,”,
"60,”,
"61,”,
"62,”,
"63,,,,”,
"64,”,
"65,”,
"66,”,
"67,”,
"68,”,
"69,”,
"70,”,
"71,”,
"72,”,
"73,”,
"74,”,
"75,”,
"76,”,
"77,”,
"78,”,
"79,”,
"80,”,
"81,”,
"82,”,
"83,”,
"84,”,
"85,”,
"86,”,
"87,”,
"88,”,
"89,”,
"90,”,
"91,”,
"92,”,
"93,”,
"94,”,
"95,”,
"96,”,
"97,”,
"98,”,
"90,”,
"100,"

$form = New-Object System.Windows.Forms.Form
$form.Size = New-Object System.Drawing.Size(480,500)
$form.Text = "FBI HOMICIDE 1D8723"
$f2 = New-Object System.Windows.Forms.Form
$f2.Size = New-Object System.Drawing.Size(210,300)

$b2 = New-Object System.Windows.Forms.Button
$b2.location = New-Object System.Drawing.Size(0,380)
$pictureBox = new-object Windows.Forms.PictureBox
$base64ImageString = "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"
$imageBytes = [Convert]::FromBase64String($base64ImageString)
$ms = New-Object IO.MemoryStream($imageBytes, 0, $imageBytes.Length)
$ms.Write($imageBytes, 0, $imageBytes.Length);
$img = [System.Drawing.Image]::FromStream($ms, $true)

$pictureBox.Image = $img
$pictureBox.SizeMode = "Autosize"
$pictureBox.Anchor = "Bottom, left"
$f2.controls.add($pictureBox)
$f2_label  = New-Object System.Windows.Forms.Label
$f2_label.Text = "Krystal Fisher, ?1990"
$f2_label.location = New-Object System.Drawing.Size(0,240)
$f2_label.Size = New-Object System.Drawing.Size(100,100)
$f2.Controls.Add($f2_label)
$f2.Controls.Add($f2.l2)

$l1 = New-Object System.Windows.Forms.Label
$l1.BackColor = "Black"
$l1.ForeColor = "White"
$l1.Text = "                              FBI Homicide"
$l1.Size = New-Object System.Drawing.Size(460,20)
$l1.Location = New-Object System.Drawing.Size(0,30)
$form.Controls.Add($l1)

$l2 = New-Object System.Windows.Forms.Label
$l2.BackColor = "red"
$l2.ForeColor = "White"
$l2.Text = "                              development"
$l2.Location = New-Object System.Drawing.Size(0,50)
$l2.Size = New-Object System.Drawing.Size(460,15)
$form.Controls.Add($l2)







$gps = $csv | Out-String | ConvertFrom-Csv
$list = New-Object System.collections.ArrayList
$list.AddRange($gps)

$dataGridView = New-Object System.Windows.Forms.DataGridView -Property @{
    Size=New-Object System.Drawing.Size(460,400)
    ColumnHeadersVisible = $true
    DataSource = $list
}
$dataGridView.BackColor = "white"
$dataGridView.Location = New-Object System.Drawing.Size(0,60)
$form.Controls.Add($dataGridView)


$b3 = New-Object System.Windows.Forms.Button
$b3.Location = New-Object System.Drawing.Size(250,240)
$b3.Text = "Code"
$b3.Add_Click({

})

$form.ShowDialog()




