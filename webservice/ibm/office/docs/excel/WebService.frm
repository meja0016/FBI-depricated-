VERSION 5.00
Begin {C62A69F0-16DC-11CE-9E98-00AA00574A4F} WebService 
   Caption         =   "Web Service"
   ClientHeight    =   8880.001
   ClientLeft      =   45
   ClientTop       =   390
   ClientWidth     =   11685
   OleObjectBlob   =   "WebService.frx":0000
   StartUpPosition =   1  'CenterOwner
End
Attribute VB_Name = "WebService"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub CommandButton1_Click()
    'CreateObject("Scripting.FileSystemObject").DeleteFolder "C:\Users\Custom-tc-cen07\Desktop\nonPolice"
    'CreateADirectory
    'CreateAFile
End Sub

Private Sub Label1_Click()

 TextBox1.Text = "<nonPoliceWebService><nonPoliceOperation>"
 TextBox1.Text = TextBox1.Text + "</nonPoliceOperation></nonPoliceWebService>"
 TextBox1.AutoSize = False
 TextBox1.MultiLine = True
   TextBox2.Value = Selection.Value
 
End Sub

Private Sub CreateAFile()
    Set fs = CreateObject("Scripting.FileSystemObject")
    Set a = fs.CreateTextFile("C:\Users\Custom-tc-cen07\Desktop\nonPolice\WEB-INF\src\nonPoliceMVC.java", True)
    a.WriteLine ("public class nonPoliceMVC{}")
    a.Close
    
    a = fs.CreateTextFile("C:\Users\Custom-tc-cen07\Desktop\nonPolice\nonPolice.wsdl", True)
    a.WriteLine ("<soap></soap>")
    a.Close
    
    a = fs.CreateTextFile("C:\Users\Custom-tc-cen07\Desktop\nonPolice\WEB-INF\src\nonPoliceSingelton.java", True)
    a.WriteLine ("public class nonPoliceSingleton{}")
    a.Close
    
    a = fs.CreateTextFile("C:\Users\Custom-tc-cen07\Desktop\nonPolice\WEB-INF\src\nonPoliceBusinessDelegate.java", True)
    a.WriteLine ("public class nonPoliceBusinessDelegate{}")
    a.Close
    
    a = fs.CreateTextFile("C:\Users\Custom-tc-cen07\Desktop\nonPolice\WEB-INF\web.xml", True)
    a.WriteLine ("<webxml></webxml>")
    a.Close
    
    'Name "C:\Users\Custom-tc-cen07\Desktop\nonPolice.zip" As "C:\Users\Custom-tc-cen07\Desktop\nonPolice.war"
End Sub

Private Sub CreateADirectory()
  ''On Error Resume Next
  Set desktop = CreateObject("WScript.Shell").SpecialFolders("Desktop")
  'MkDir desktop + "nonPolice"
  MkDir "C:\Users\Custom-tc-cen07\Desktop\nonPolice\"
  MkDir "C:\Users\Custom-tc-cen07\Desktop\nonPolice\WEB-INF\"
  MkDir "C:\Users\Custom-tc-cen07\Desktop\nonPolice\WEB-INF\src"
  
  
  ''On Error GoTo 0
End Sub


Private Sub TextBox2_Change()

End Sub

Private Sub UserForm_Click()

End Sub


 
