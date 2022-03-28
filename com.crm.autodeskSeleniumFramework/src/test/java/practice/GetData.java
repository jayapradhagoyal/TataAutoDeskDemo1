package practice;

import java.util.Date;
class GetData{
public String GetSystemDate () {
		Date date=new Date();
		String DateAndTime=date.toString();
	
		String yyyy = DateAndTime.split(" ")[5];

String MM=DateAndTime.split(" ")[2];
int DD=date.getMonth()+1;
String fileformat=yyyy+"-"+MM+"-"+DD;
return fileformat;
	}

}
