$urls = @{
    "mon1.jpg" = "https://images.unsplash.com/photo-1582878826629-29b7ad1cdc43?w=400"
    "mon2.jpg" = "https://images.unsplash.com/photo-1555126634-323283e090fa?w=400"
    "mon3.jpg" = "https://images.unsplash.com/photo-1626803775151-61d756612f97?w=400"
    "mon4.jpg" = "https://images.unsplash.com/photo-1627308595229-7830a5c91f9f?w=400"
}

$targetDir = "C:/dev/LTDD/A11_241A010541/app/src/main/res/drawable"

foreach ($key in $urls.Keys) {
    $url = $urls[$key]
    $outPath = Join-Path $targetDir $key
    try {
        Invoke-WebRequest -Uri $url -OutFile $outPath -UserAgent "Mozilla/5.0"
        Write-Host "Downloaded $key"
    } catch {
        Write-Host "Failed $key : $_"
    }
}
