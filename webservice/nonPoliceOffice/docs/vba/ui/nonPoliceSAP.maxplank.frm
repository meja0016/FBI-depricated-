VERSION 5.00
Begin {C62A69F0-16DC-11CE-9E98-00AA00574A4F} UserForm1 
   Caption         =   "nonPoliceSap"
   ClientHeight    =   2820
   ClientLeft      =   45
   ClientTop       =   390
   ClientWidth     =   4305
   OleObjectBlob   =   "nonPoliceSAP.maxplank.frx":0000
   StartUpPosition =   1  'CenterOwner
End
Attribute VB_Name = "UserForm1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub CommandButton1_Click()
    ActiveWorkbook.FollowHyperlink _
      Address:="http://justice.gov", _
      NewWindow:=True

End Sub

Private Sub CommandButton2_Click()

End Sub

Private Sub CommandButton3_Click()
    ActiveWorkbook.FollowHyperlink _
      Address:="https://raw.githubusercontent.com/meja0016/www/main/nonPoliceLog.txt", _
      NewWindow:=True
End Sub

Private Sub CommandButton4_Click()
    ActiveWorkbook.FollowHyperlink _
      Address:="http://publibfp.boulder.ibm.com/epubs/pdf/c3163142.pdf?mhsrc=ibmsearch_a&mhq=cyanea%20wsam", _
      NewWindow:=True
End Sub

Private Sub UserForm_Click()
    ActiveWorkbook.FollowHyperlink _
      Address:="http://publibfp.boulder.ibm.com/epubs/pdf/c3163142.pdf?mhsrc=ibmsearch_a&mhq=cyanea%20wsam", _
      NewWindow:=True
End Sub
