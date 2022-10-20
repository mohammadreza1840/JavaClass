Sub GetParagraf()
Dim bb As Variant
'///refrence-Microsoft Office Object libray
DelNewTlbs
Dim contCtl As Long
Dim DocAll As Long
Dim ParCount As Long
Dim MyFile As String
Dim NamF, ParNum, ParStyl, ParStrt, FootNum, FootStart, FootTxt, ParColor, SorcTxt, IDSJ, LastIDSJ, TempPTxt As String
Dim ParTxt As String
Dim AFC As Long ' Asc First Caracter
Dim MaxPN As Long
Dim FHS As Boolean 'First Heading
Dim FHSPlus As Byte  'Plus number to First Heading
Dim CheckSoalJavab As Boolean


DocAll = Word.Application.Documents.Count
contCtl = 0
If Check1.Value = 1 Then CheckSoalJavab = True Else CheckSoalJavab = False
If db.State = 0 Then db.Open

Dim RsMaxRart As Recordset
Set RsMaxRart = db.Execute("select * from Q_MaxPartNum ")
Set RsMaxRart.ActiveConnection = Nothing
MaxPN = RsMaxRart.Fields(0).Value
Set RsMaxRart = Nothing




For DocCount = 1 To Word.Application.Documents.Count
    ParCount = Word.Application.Documents(DocCount).Paragraphs.Count
    MaxPN = MaxPN + 1
    contCtl = contCtl + ParCount
        With Word.Application.Documents(DocCount)
            Me.Caption = .Name
            NamF = ""
            FHS = False
            FHSPlus = 0
            For I = 1 To ParCount
            TempPTxt = ""
            ParTxt = ""
                    ParTxt = Trim(.Paragraphs(I).Range)
                    If Len(ParTxt) < 2 Then
                        ParTxt = .Paragraphs(I).Range.ListFormat.ListString
                        If Len(ParTxt) = 0 Then GoTo NxtPar
                    End If
                    AFC = Asc(Left(ParTxt, 1))
                    If (AFC > 192 And AFC < 238) And AFC <> 220 And AFC <> 215 And AFC <> 129 And AFC <> 141 And AFC <> 142 And AFC <> 144 And AFC <> 152 And AFC <> 170 Then
                        TempPTxt = ParTxt
                    Else
                        TempPTxt = DelFromTotalAlaem(ParTxt)
                    End If

                If TempPTxt <> "" Then
                
                    ParTxt = DelFromBeginAlaem(ParTxt)
                    ParTxt = RemoveNonCode(ParTxt)
                    If NamF = "" Then
                        IDSJ = "0"
                        NamF = "Bk_" & UserProperties.UserID & MaxPN
                        db.Execute ("insert into New_Tlb_Kotob_NamBook (part,NamBook, Moalef, tartibPart,KetaKhane) values ('" & _
                        NamF & "','" & Trim(.Paragraphs(I).Range) & "','" & Trim(.Paragraphs(I + 1).Range) & "',6,1)")
                        
                        ParNum = I
                        ParStrt = .Paragraphs(I).Range.Start
                        ParColor = .Paragraphs(I).Range.Font.ColorIndex
                        SorcTxt = .Paragraphs(I).Range.ListFormat.ListString
                        db.Execute ("insert into New_Tlb_ketab_Jadid (NamF,ParNum, ParTxt, ParStyl, ParStrt,ColorIndex,IDSJ,Sourcetxt) values ('" & _
                        NamF & "'," & ParNum & ",'" & ParTxt & "','Heading 1'," & ParStrt & "," & ParColor & "," & IDSJ & ",'" & SorcTxt & "')")
                        DoEvents
                        
                        ParNum = I + 1
                        ParTxt = Trim(.Paragraphs(ParNum).Range)
                        ParStrt = .Paragraphs(ParNum).Range.Start
                        ParColor = .Paragraphs(ParNum).Range.Font.ColorIndex
                        SorcTxt = .Paragraphs(I).Range.ListFormat.ListString
                        db.Execute ("insert into New_Tlb_ketab_Jadid (NamF,ParNum, ParTxt, ParStyl, ParStrt,ColorIndex,IDSJ,Sourcetxt) values ('" & _
                        NamF & "'," & ParNum & ",'" & ParTxt & "','Normal'," & ParStrt & "," & ParColor & "," & IDSJ & ",'" & SorcTxt & "')")
                        DoEvents
                            
                        I = I + 1
                        SorcTxt = ""
                        GoTo NxtPar:
                    End If
                    
                    ParNum = I
                    If CheckSoalJavab Then
                        If IDSJ <> "0" Then LastIDSJ = IDSJ
                        IDSJ = "0"
                        SorcTxt = .Paragraphs(I).Range.ListFormat.ListString
                        If Left(ParTxt, 3) = "س. " Then IDSJ = "1"
                        If Left(ParTxt, 3) = "ج. " Then IDSJ = "3"
                        If Left(ParTxt, 3) = "ح. " Then IDSJ = "2"
                        If IDSJ = "0" And SorcTxt <> "" Then
                            If Left(SorcTxt, 3) = "س. " Then IDSJ = "1"
                            If Left(SorcTxt, 3) = "س. " Then IDSJ = "1"
                        End If
                        If IDSJ = LastIDSJ Then
                            IDSJ = 0
                            
                        End If
                    End If
                    ParStyl = .Paragraphs(I).Style
                    If FHS = False And InStr(ParStyl, "Heading") > 0 Then
                        If Right(ParStyl, 1) = 1 Then FHSPlus = 1 Else FHSPlus = 0
                        FHS = True
                    End If
                    If InStr(ParStyl, "Heading") > 0 Then ParStyl = "Heading " & (Val(Mid(ParStyl, 9)) + FHSPlus)
                    ParStrt = .Paragraphs(I).Range.Start
                    ParColor = .Paragraphs(I).Range.Font.ColorIndex
                    FootNum = ""
                    FootStart = ""
                    FootTxt = ""
                    If .Paragraphs(I).Range.Footnotes.Count > 0 Then
                        For J = 1 To .Paragraphs(I).Range.Footnotes.Count
                            If .Paragraphs(I).Range.Footnotes.Count > 1 Then
                            End If
                            FootNum = J
                            FootStart = .Paragraphs(I).Range.Footnotes(J).Reference.Start - .Paragraphs(I).Range.Start
                            FootTxt = .Paragraphs(I).Range.Footnotes(J).Range
                            db.Execute ("insert into New_Tlb_ketab_Jadid_Footnote (NamF, ParNum, FootNum, FootStart, FootTxt) values ('" & _
                            NamF & "','" & ParNum & "','" & FootNum & "','" & FootStart & "','" & FootTxt & "')")
                        Next
                    End If
                
                    ParTxt = Replace(ParTxt, "'", " ")
                    db.Execute ("insert into New_Tlb_ketab_Jadid (NamF,ParNum, ParTxt, ParStyl, ParStrt,ColorIndex,IDSJ,Sourcetxt) values ('" & _
                    NamF & "'," & ParNum & ",'" & ParTxt & "','" & ParStyl & "'," & ParStrt & "," & ParColor & "," & IDSJ & ",'" & SorcTxt & "')")
                    DoEvents
                Else
                    a = a
                End If
NxtPar:
                StB.Panels(1).Text = "Doc_" & DocCount & "_DocAll_" & DocAll & "_Par_" & I & "_ParAll_" & ParCount
                StB.Panels(2).Text = Fix((I * 100) / ParCount) & "%"
            Next I
        End With
Next DocCount
End Sub

