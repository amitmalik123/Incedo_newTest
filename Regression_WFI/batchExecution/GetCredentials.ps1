#Checking if the arguments were correctly entered in the build.

$environment = $Args[0]
 echo "Selected environment: " + $environment;
$browser = $Args[1]
 echo "Selected browser: " + $browser;
$threadCount = $Args[2]

$url = ""
$bawUrl = ""
$dbEWM = ""
$dbBPM = ""
switch ($environment) {
    "test12"{
                $url = "https://test12.ewealthmanager.com/"
		$bawUrl = "https://fpkt12bawps1.corp.local:9444/ProcessPortal/login.jsp"
		$dbEWM = "t12ewmdba"
		$dbBPM = "t12bpmdba"
                echo "Selected environment: " + $environment;
                break;
              }
    "test11"{
                $url = "https://test11.ewealthmanager.com/"
		$bawUrl = "https://fpkt11bawps1.corp.local:9444/ProcessPortal/login.jsp"
		$dbEWM = "t11ewmdba"
		$dbBPM = "t11bpmdba"
                echo "Selected environment: " + $environment;
                break;
              }
    "test10"{
                $url = "https://test10.ewealthmanager.com/"
		$bawUrl = "https://fpkt10bawps1.corp.local:9444/ProcessPortal/login.jsp"
		$dbEWM = "t10ewmdba"
		$dbBPM = "t10bpmdba"
                echo "Selected environment: " + $environment;
                 break;
              }    
       default{
                Write-Error ("No environment were selected. your input : " + $environment)
                exit 1
                break;
              } 
}
echo " Browser: " + $browser
echo " bawUrl: " + $bawUrl

$oldContent = Get-Content -Path "./src/test/resources/propertiesFiles/config.properties"
if (!$?){
    Write-Error ("Error getting parameters content, build cannot continue")
    exit 1
}
Clear-Content -Path "./src/test/resources/propertiesFiles/config.properties"
if (!$?){
    Write-Error ("Error cleaning parameters content, build cannot continue")
    exit 1
}
#Replacing the username and password in parameters.
foreach($line in $oldContent ){
    #look for url
    if ($line.Contains('BROWSER=')){
        $line = "BROWSER= " + $browser
	echo " browser: " + $line
    }
    if ($line.Contains('ENVIRONMENT_DETAILS.URL')){
        $line = "ENVIRONMENT_DETAILS.URL= " + $url
	echo " Url: " + $line
    }
    #look for baw url
    if ($line.Contains('BAW_ENVIRONMENT_URL')){
        $line = "BAW_ENVIRONMENT_URL= " + $bawUrl
	echo " bawUrl: " + $line
    }
    #look for db ewm
        if ($line.Contains('DBEWM_HOSTNAME=')){
            $line = "ENVIRONMENT_DETAILS.DBEWM_HOSTNAME= " + $dbEWM
	   echo " dbEWM" + $line
    } 
    #look for browser
        if ($line.Contains('DBBPM_HOSTNAME=')){
            $line = "ENVIRONMENT_DETAILS.DBBPM_HOSTNAME= " + $dbBPM
	echo " dbBPM" + $line
    }
    Add-Content -Path "./src/test/resources/propertiesFiles/config.properties" -Value $line
    if (!$?){
        Write-Error ("Error adding content to parameters file, build cannot continue")
        exit 1
    } 
}
   

     

