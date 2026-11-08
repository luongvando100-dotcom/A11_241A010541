import zipfile
import xml.etree.ElementTree as ET

with zipfile.ZipFile(r'C:\Users\hp\Downloads\Lab_A11_HuongDanThucHanh.docx', 'r') as z:
    xml_content = z.read('word/document.xml')
    root = ET.fromstring(xml_content)
    texts = []
    for elem in root.iter():
        if elem.tag.endswith('t') and elem.text:
            texts.append(elem.text)

with open(r'C:/dev/LTDD/A11_241A010541/.artifacts/441fcd5e-1ab9-4a46-95b4-5145661f0771/scratch/lab_content.txt', 'w', encoding='utf-8') as f:
    f.write('\n'.join(texts))
print("Successfully extracted docx to lab_content.txt")
