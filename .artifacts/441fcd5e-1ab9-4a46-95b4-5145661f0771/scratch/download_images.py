import urllib.request
import os

urls = {
    'mon1.jpg': 'https://images.unsplash.com/photo-1582878826629-29b7ad1cdc43?w=400', # Pho
    'mon2.jpg': 'https://images.unsplash.com/photo-1555126634-323283e090fa?w=400', # Noodles / Bun Cha
    'mon3.jpg': 'https://images.unsplash.com/photo-1626803775151-61d756612f97?w=400', # Rice / Com Tam
    'mon4.jpg': 'https://images.unsplash.com/photo-1627308595229-7830a5c91f9f?w=400'  # Banh mi / Sandwich
}

target_dir = r'C:/dev/LTDD/A11_241A010541/app/src/main/res/drawable'
os.makedirs(target_dir, exist_ok=True)

headers = {'User-Agent': 'Mozilla/5.0'}

for filename, url in urls.items():
    filepath = os.path.join(target_dir, filename)
    try:
        req = urllib.request.Request(url, headers=headers)
        with urllib.request.urlopen(req) as response, open(filepath, 'wb') as out_file:
            out_file.write(response.read())
        print(f"Downloaded {filename} successfully.")
    except Exception as e:
        print(f"Failed to download {filename}: {e}")
