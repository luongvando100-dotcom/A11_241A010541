$path = "C:\Users\hp\Downloads\Lab_A11_HuongDanThucHanh.docx"
$outPath = "C:\dev\LTDD\A11_241A010541\.artifacts\441fcd5e-1ab9-4a46-95b4-5145661f0771\scratch\lab_content.txt"
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zip = [System.IO.Compression.ZipFile]::OpenRead($path)
$entry = $zip.GetEntry("word/document.xml")
$stream = $entry.Open()
$reader = New-Object System.IO.StreamReader($stream)
$xmlText = $reader.ReadToEnd()
$reader.Close()
$stream.Close()
$zip.Dispose()

[xml]$xml = $xmlText
$ns = New-Object System.Xml.XmlNamespaceManager($xml.NameTable)
$ns.AddNamespace("w", "http://schemas.openxmlformats.org/wordprocessingml/2006/main")
$nodes = $xml.SelectNodes("//w:t", $ns)
$sb = New-Object System.Text.StringBuilder
foreach($node in $nodes) {
    [void]$sb.AppendLine($node.InnerText)
}
[System.IO.File]::WriteAllText($outPath, $sb.ToString(), [System.Text.Encoding]::UTF8)
Write-Host "Done"
