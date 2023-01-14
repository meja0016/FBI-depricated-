VERSION 5.00
Begin {C62A69F0-16DC-11CE-9E98-00AA00574A4F} WebService 
   Caption         =   "Web Service"
   ClientHeight    =   6585
   ClientLeft      =   45
   ClientTop       =   390
   ClientWidth     =   5280
   OleObjectBlob   =   "WebService.frx":0000
   StartUpPosition =   1  'CenterOwner
End
Attribute VB_Name = "WebService"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub CommandButton1_Click()
    CreateADirectory
    CreateAFile
    
End Sub

Private Sub Label1_Click()

End Sub

Private Sub CreateAFile()
    Set fs = CreateObject("Scripting.FileSystemObject")
    Set a = fs.CreateTextFile("C:\Users\Custom-tc-cen07\Desktop\nonPolice\nonPoliceMVC.java", True)
    a.WriteLine ("public class nonPoliceMVC{}")
    a.Close
    
    a = fs.CreateTextFile("C:\Users\Custom-tc-cen07\Desktop\nonPolice\nonPolice.wsdl", True)
    a.WriteLine ("public class nonPoliceMVC{}")
    a.Close
    
    a = fs.CreateTextFile("C:\Users\Custom-tc-cen07\Desktop\nonPolice\nonPoliceSinglton.java", True)
    a.WriteLine ("public class nonPoliceSingleton{}")
    a.Close
End Sub

Private Sub CreateADirectory()
  ''On Error Resume Next
  MkDir "C:\Users\Custom-tc-cen07\Desktop\nonPolice"
  ''On Error GoTo 0
End Sub


Private Sub UserForm_Click()

End Sub
