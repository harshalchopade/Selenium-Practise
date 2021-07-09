#include <InetConstants.au3>
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>

; Download a file in the background.
; Wait for the download to complete.

Example()

Func Example()



    Local $hDownload = InetGet("https://selenium-release.storage.googleapis.com/3.141/selenium-java-3.141.59.zip","C:\Users\hchopade\eclipse-workspace\SeleniumTutorials\Downloads", $INET_FORCERELOAD)

EndFunc   ;==>Example
