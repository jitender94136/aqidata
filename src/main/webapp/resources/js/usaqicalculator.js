var colorObj = {};
colorObj["Good"] = "#00e000";
colorObj["Moderate"] = "#ffff00";
colorObj["Unhealthy for Sensitive Groups"]= "#ff7600";
colorObj["Unhealthy"] = "#ff0000";
colorObj["Very Unhealthy"]="#990049";
colorObj["Hazardous"]="#7E0023";


function InvLinear(AQIhigh, AQIlow, Conchigh, Conclow, a)
{
var AQIhigh;
var AQIlow;
var Conchigh;
var Conclow;
var a;
var c;
c=((a-AQIlow)/(AQIhigh-AQIlow))*(Conchigh-Conclow)+Conclow;
return c;
}



function ConcPM25(a)
{
if (a>=0 && a<=50)
{
ConcCalc=InvLinear(50,0,12,0,a);
}
else if (a>50 && a<=100)
{
ConcCalc=InvLinear(100,51,35.4,12.1,a);
}
else if (a>100 && a<=150)
{
ConcCalc=InvLinear(150,101,55.4,35.5,a);
}
else if (a>150 && a<=200)
{
ConcCalc=InvLinear(200,151,150.4,55.5,a);
}
else if (a>200 && a<=300)
{
ConcCalc=InvLinear(300,201,250.4,150.5,a);
}
else if (a>300 && a<=400)
{
ConcCalc=InvLinear(400,301,350.4,250.5,a);
}
else if (a>400 && a<=500)
{
ConcCalc=InvLinear(500,401,500.4,350.5,a);
}
else
{
ConcCalc="PM25message";
}
return ConcCalc;
}



function ConcPM10(a)
{
if (a>=0 && a<=50)
{
ConcCalc=InvLinear(50,0,54,0,a);
}
else if (a>50 && a<=100)
{
ConcCalc=InvLinear(100,51,154,55,a);
}
else if (a>100 && a<=150)
{
ConcCalc=InvLinear(150,101,254,155,a);
}
else if (a>150 && a<=200)
{
ConcCalc=InvLinear(200,151,354,255,a);
}
else if (a>200 && a<=300)
{
ConcCalc=InvLinear(300,201,424,355,a);
}
else if (a>300 && a<=400)
{
ConcCalc=InvLinear(400,301,504,425,a);
}
else if (a>400 && a<=500)
{
ConcCalc=InvLinear(500,401,604,505,a);
}
else
{
ConcCalc="PM10message";
}
return ConcCalc;
}


function ConcCO(a)
{
if (a>=0 && a<=50)
{
ConcCalc=InvLinear(50,0,4.4,0,a);
}
else if (a>50 && a<=100)
{
ConcCalc=InvLinear(100,51,9.4,4.5,a);
}
else if (a>100 && a<=150)
{
ConcCalc=InvLinear(150,101,12.4,9.5,a);
}
else if (a>150 && a<=200)
{
ConcCalc=InvLinear(200,151,15.4,12.5,a);
}
else if (a>200 && a<=300)
{
ConcCalc=InvLinear(300,201,30.4,15.5,a);
}
else if (a>300 && a<=400)
{
ConcCalc=InvLinear(400,301,40.4,30.5,a);
}
else if (a>400 && a<=500)
{
ConcCalc=InvLinear(500,401,50.4,40.5,a);
}
else
{
ConcCalc="Out of Range";
}
return ConcCalc;
}


function ConcSO21hr(a)
{
if (a>=0 && a<=50)
{
ConcCalc=InvLinear(50,0,35,0,a);
}
else if (a>50 && a<=100)
{
ConcCalc=InvLinear(100,51,75,36,a);
}
else if (a>100 && a<=150)
{
ConcCalc=InvLinear(150,101,185,76,a);
}
else if (a>150 && a<=200)
{
ConcCalc=InvLinear(200,151,304,186,a);
}
else
{
ConcCalc="Out of Range";
}
return ConcCalc;
}



function ConcSO224hr(a)
{
if (a>=201 && a<=300)
{
ConcCalc=InvLinear(300,201,604,305,a);
}
else if (a>300 && a<=400)
{
ConcCalc=InvLinear(400,301,804,605,a);
}
else if (a>400 && a<=500)
{
ConcCalc=InvLinear(500,401,1004,805,a);
}
else
{
ConcCalc="Out of Range";
}
return ConcCalc;
}



function ConcOzone8hr(a)
{
if (a>=0 && a<=50)
{
ConcCalc=InvLinear(50,0,54,0,a);
}
else if (a>50 && a<=100)
{
ConcCalc=InvLinear(100,51,70,55,a);
}
else if (a>100 && a<=150)
{
ConcCalc=InvLinear(150,101,85,71,a);
}
else if (a>150 && a<=200)
{
ConcCalc=InvLinear(200,151,105,86,a);
}
else if (a>200 && a<=300)
{
ConcCalc=InvLinear(300,201,200,106,a);
}
else
{
ConcCalc="O3message";
}
return ConcCalc;
}




function ConcOzone1hr(a)
{
if (a>100 && a<=150)
{
ConcCalc=InvLinear(150,101,164,125,a);
}
else if (a>150 && a<=200)
{
ConcCalc=InvLinear(200,151,204,165,a);
}
else if (a>200 && a<=300)
{
ConcCalc=InvLinear(300,201,404,205,a);
}
else if (a>300 && a<=400)
{
ConcCalc=InvLinear(400,301,504,405,a);
}
else if (a>400 && a<=500)
{
ConcCalc=InvLinear(500,401,604,505,a);
}
else
{
ConcCalc="Out of Range";
}
return ConcCalc;
}




function ConcNO2(a)
{
if (a>=0 && a<=50)
{
ConcCalc=InvLinear(50,0,53,0,a);
}
else if (a>50 && a<=100)
{
ConcCalc=InvLinear(100,51,100,54,a);
}
else if (a>100 && a<=150)
{
ConcCalc=InvLinear(150,101,360,101,a);
}
else if (a>150 && a<=200)
{
ConcCalc=InvLinear(200,151,649,361,a);
}
else if (a>200 && a<=300)
{
ConcCalc=InvLinear(300,201,1244,650,a);
}
else if (a>300 && a<=400)
{
ConcCalc=InvLinear(400,301,1644,1245,a);
}
else if (a>400 && a<=500)
{
ConcCalc=InvLinear(500,401,2044,1645,a);
}
else
{
ConcCalc="Out of Range";
}
return ConcCalc;
}



function Linear(AQIhigh, AQIlow, Conchigh, Conclow, Concentration) {
		var linear;
		var Conc=parseFloat(Concentration);
		var a;
		a=((Conc-Conclow)/(Conchigh-Conclow))*(AQIhigh-AQIlow)+AQIlow;
		linear=Math.round(a);
		return linear;
}




function AQIPM25(Concentration)
{
var Conc=parseFloat(Concentration);
var c;
var AQI;
c=(Math.floor(10*Conc))/10;
if (c>=0 && c<12.1)
{
	AQI=Linear(50,0,12,0,c);
}
else if (c>=12.1 && c<35.5)
{
	AQI=Linear(100,51,35.4,12.1,c);
}
else if (c>=35.5 && c<55.5)
{
	AQI=Linear(150,101,55.4,35.5,c);
}
else if (c>=55.5 && c<150.5)
{
	AQI=Linear(200,151,150.4,55.5,c);
}
else if (c>=150.5 && c<250.5)
{
	AQI=Linear(300,201,250.4,150.5,c);
}
else if (c>=250.5 && c<350.5)
{
	AQI=Linear(400,301,350.4,250.5,c);
}
else if (c>=350.5 && c<500.5)
{
	AQI=Linear(500,401,500.4,350.5,c);
}
else
{
	AQI="PM25message";
}
return AQI;
}



function AQIPM10(Concentration)
{
var Conc=parseFloat(Concentration);
var c;
var AQI;
c=Math.floor(Conc);
if (c>=0 && c<55)
{
	AQI=Linear(50,0,54,0,c);
}
else if (c>=55 && c<155)
{
	AQI=Linear(100,51,154,55,c);
}
else if (c>=155 && c<255)
{
	AQI=Linear(150,101,254,155,c);
}
else if (c>=255 && c<355)
{
	AQI=Linear(200,151,354,255,c);
}
else if (c>=355 && c<425)
{
	AQI=Linear(300,201,424,355,c);
}
else if (c>=425 && c<505)
{
	AQI=Linear(400,301,504,425,c);
}
else if (c>=505 && c<605)
{
	AQI=Linear(500,401,604,505,c);
}
else
{
	AQI="PM10message";
}
return AQI;
}



function AQICO(Concentration)
{
var Conc=parseFloat(Concentration);
var c;
var AQI;
c=(Math.floor(10*Conc))/10;
if (c>=0 && c<4.5)
{
	AQI=Linear(50,0,4.4,0,c);
}
else if (c>=4.5 && c<9.5)
{
	AQI=Linear(100,51,9.4,4.5,c);
}
else if (c>=9.5 && c<12.5)
{
	AQI=Linear(150,101,12.4,9.5,c);
}
else if (c>=12.5 && c<15.5)
{
	AQI=Linear(200,151,15.4,12.5,c);
}
else if (c>=15.5 && c<30.5)
{
	AQI=Linear(300,201,30.4,15.5,c);
}
else if (c>=30.5 && c<40.5)
{
	AQI=Linear(400,301,40.4,30.5,c);
}
else if (c>=40.5 && c<50.5)
{
	AQI=Linear(500,401,50.4,40.5,c);
}
else
{
	AQI="Out of Range";
}
return AQI;
}




function AQISO21hr(Concentration)
{
var Conc=parseFloat(Concentration);
var c;
var AQI;
c=Math.floor(Conc);
if (c>=0 && c<36)
{
	AQI=Linear(50,0,35,0,c);
}
else if (c>=36 && c<76)
{
	AQI=Linear(100,51,75,36,c);
}
else if (c>=76 && c<186)
{
	AQI=Linear(150,101,185,76,c);
}
else if (c>=186 && c<=304)
{
	AQI=Linear(200,151,304,186,c);
}
else if (c>=304 && c<=604)
{
	AQI="SO21hrmessage";
}
else
{
	AQI="Out of Range";
}
return AQI;
}


function AQISO224hr(Concentration)
{
var Conc=parseFloat(Concentration);
var c;
var AQI;
c=Math.floor(Conc);
if (c>=0 && c<=304)
{
	AQI="SO224hrmessage";
}

else if (c>=304 && c<605)
{
	AQI=Linear(300,201,604,305,c);
}
else if (c>=605 && c<805)
{
	AQI=Linear(400,301,804,605,c);
}
else if (c>=805 && c<=1004)
{	
	AQI=Linear(500,401,1004,805,c);
}
else
{
	AQI="Out of Range";
}
return AQI;
}



function AQIOzone8hr(Concentration)
{
var Conc=parseFloat(Concentration);
var c;
var AQI;
c=(Math.floor(Conc))/1000;

if (c>=0 && c<.055)
{
	AQI=Linear(50,0,0.054,0,c);
}
else if (c>=.055 && c<.071)
{
	AQI=Linear(100,51,.070,.055,c);
}
else if (c>=.071 && c<.086)
{
	AQI=Linear(150,101,.085,.071,c);
}
else if (c>=.086 && c<.106)
{
AQI=Linear(200,151,.105,.086,c);
}
else if (c>=.106 && c<.201)
{
	AQI=Linear(300,201,.200,.106,c);
}
else if (c>=.201 && c<.605)
{
	AQI="O3message";
}
else
{
	AQI="Out of Range";
}
return AQI;
}
//line219


function AQIOzone1hr(Concentration)
{
var Conc=parseFloat(Concentration);
var c;
var AQI;
c=(Math.floor(Conc))/1000;
	if (c>=0 && c<=.165)
{
	AQI="O31hrmessage";
}
	
else if (c>=.125 && c<.165)
{
	AQI=Linear(150,101,.164,.125,c);
}
else if (c>=.165 && c<.205)
{
	AQI=Linear(200,151,.204,.165,c);
}
else if (c>=.205 && c<.405)
{
	AQI=Linear(300,201,.404,.205,c);
}
else if (c>=.405 && c<.505)
{
	AQI=Linear(400,301,.504,.405,c);
}
else if (c>=.505 && c<.605)
{


	AQI=Linear(500,401,.604,.505,c);
}
else
{
	AQI="Out of Range";
}
return AQI;
}

function AQINO2(Concentration)
{
var Conc=parseFloat(Concentration);
var c;
var AQI;
c=(Math.floor(Conc))/1000;
if (c>=0 && c<.054)
{
	AQI=Linear(50,0,.053,0,c);
}
else if (c>=.054 && c<.101)
{
	AQI=Linear(100,51,.100,.054,c);
}
else if (c>=.101 && c<.361)
{
	AQI=Linear(150,101,.360,.101,c);
}
else if (c>=.361 && c<.650)
{
	AQI=Linear(200,151,.649,.361,c);
}
else if (c>=.650 && c<1.250)
{
	AQI=Linear(300,201,1.249,.650,c);
}
else if (c>=1.250 && c<1.650)
{
	AQI=Linear(400,301,1.649,1.250,c);
}
else if (c>=1.650 && c<=2.049)
{
	AQI=Linear(500,401,2.049,1.650,c);
}
else
{
	AQI="Out of Range";
}
return AQI;
}


function AQICategory(AQIndex)
{
var AQI=parseFloat(AQIndex)
var AQICategory;
if (AQI<=50)
{
	AQICategory="Good";
}
else if (AQI>50 && AQI<=100)
{
	AQICategory="Moderate";
}
else if (AQI>100 && AQI<=150)
{
	AQICategory="Unhealthy for Sensitive Groups";
}
else if (AQI>150 && AQI<=200)
{
	AQICategory="Unhealthy";
}
else if (AQI>200 && AQI<=300)
{
	AQICategory="Very Unhealthy";
}
else if (AQI>300 && AQI<=400)
{
	AQICategory="Hazardous";
}
else if (AQI>400 && AQI<=500)
{
	AQICategory="Hazardous";
}
else
{
	AQICategory="Out of Range";
}
return AQICategory;
}

function getAQIColor(AQICategory) {
	return colorObj[AQICategory];
}
